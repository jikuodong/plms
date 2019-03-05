package com.jikuodong.plms.interceptor.shiro.token.manager;

import com.jikuodong.plms.interceptor.shiro.token.UsernamePasswordTokenCustom;
import com.jikuodong.plms.po.UserCustom;
import com.jikuodong.plms.utils.TokenUtil;
import com.jikuodong.plms.utils.redis.RedisUtil;
import org.apache.shiro.authc.AuthenticationToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * describe tokenManager抽象类，实现部分通用方法
 * @author mingchenxu
 * @date 2018/3/13 15:26
 */
public abstract class AbstractTokenManager implements TokenManager{
    protected final Logger logger = LoggerFactory.getLogger(AbstractTokenManager.class);
    /*
        失效时间 （秒）
     */
    protected long usefulTime;

    /*
        redis中存放的key的前缀
     */
    protected String userTokenPrefix = "plms:aum:user:";
    protected String tokenPrefix = "plms:aum:token:";

    /*
        redis操作客户端
     */
    protected RedisUtil redisUtil = RedisUtil.getInstance();

    /**
     * 创建一个token关联上指定用户
     * @param userEntity 指定用户的实体类
     * @return 生成的token字符串
     */
    @Override
    public String createToken(Object userEntity) {
        UserCustom user = (UserCustom) userEntity;
        // 存放到redis中的用户的key为 plms:aum:user: + 用户名，token的key为 plms:aum:token: + 用户名
        String userInfoKey = userTokenPrefix + user.getUserName();
        String tokenKey = tokenPrefix + user.getUserName();
        String token = TokenUtil.createJWT(user.getUserId(),"PLMS", user.getUserName(), usefulTime, user.getUserName());
        redisUtil.set(userInfoKey, user, usefulTime);
        redisUtil.set(tokenKey, token, usefulTime);
        // 设置token
        return token;
    }

    /**
     * 从shiro的token中获取用户实体类
     * @param authenticationToken shrio认证token
     * @return 生成的token
     */
    @Override
    public Object getEntityByToken(AuthenticationToken authenticationToken) {
        String userInfoKey = userTokenPrefix + authenticationToken.getPrincipal();
        return redisUtil.get(userInfoKey);
    }


    /**
     * 从字符串中解析出shiro的token
     * @param token 加密后的字符串
     * @return 认证token
     */
    @Override
    public AuthenticationToken getToken(String token) {
        if (token == null || token.equals("")) {
            return null;
        }
        return new UsernamePasswordTokenCustom(token);
    }

    /**
     * 检查token字符串是否有效
     * @param token 无状态token字符串
     * @return 是否有效
     */
    @Override
    public boolean check(String token) {
        AuthenticationToken authenticationToken = getToken(token);
        return checkToken(authenticationToken);
    }

    /**
     * 检测token是否与redis中的token一致
     * @param authenticationToken 认证的token
     * @return boolean
     */
    @Override
    public boolean checkToken(AuthenticationToken authenticationToken){
        if (authenticationToken == null) {
            return false;
        }
        UsernamePasswordTokenCustom tokenCustom = (UsernamePasswordTokenCustom) authenticationToken;
        String userName = (String) tokenCustom.getPrincipal();
        String tokenKey = tokenPrefix + userName;
        String token = (String) redisUtil.get(tokenKey);
        if (token == null) {
            return false;
        }
        // 如果token相同，返回true
        return tokenCustom.getStatelessToken().equals(token);
    }

    /**
     * 清除token
     * @param userName 登录用户名
     */
    @Override
    public void deleteToken(String userName) {
        redisUtil.del(userTokenPrefix + userName);
        redisUtil.del(tokenPrefix + userName);
    }
}
