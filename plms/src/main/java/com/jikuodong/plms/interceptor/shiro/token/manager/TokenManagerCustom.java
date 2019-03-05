package com.jikuodong.plms.interceptor.shiro.token.manager;

import com.jikuodong.plms.interceptor.shiro.token.UsernamePasswordTokenCustom;
import com.jikuodong.plms.po.User;
import com.jikuodong.plms.utils.TokenUtil;
import io.jsonwebtoken.Claims;
import org.apache.shiro.authc.AuthenticationToken;

import java.util.concurrent.locks.ReentrantLock;

public class TokenManagerCustom extends AbstractTokenManager {
    private static TokenManagerCustom instance;
    private static ReentrantLock lock = new ReentrantLock();
    /*
        单例模式
     */
    private TokenManagerCustom(){
        // 默认过期时间7天
        super.usefulTime = 604800;
    }

    public static TokenManagerCustom getInstance(){
        lock.lock();
        try {
            if (instance == null){
                instance = new TokenManagerCustom();
            }
        }finally {
            lock.unlock();
        }
        return instance;
    }

    /**
     * 从字符串中解析出shiro的token
     * @param token 加密后的字符串
     * @return 认证token
     */
    @Override
    public AuthenticationToken getToken(String token) {
        // 获取token中用户id
        String username = getUserNameByToken(token);
        if (username != null) {
            UsernamePasswordTokenCustom tokenCustom = new UsernamePasswordTokenCustom(token);
            tokenCustom.setUsername(username);
            return tokenCustom;
        }
        return null;
    }

    /**
     * 通过userName获取存在redis中的JWT的token
     * @param userName 用户名
     * @return jwt的token
     */
    public String getJwtToken(String userName){
        String tokenKey = tokenPrefix + userName;
        return (String) redisUtil.get(tokenKey);
    }

    /**
     * 通过无状态token获取用户名
     * @param  * @param stateLessToken
     * @return java.lang.String
     */
    public String getUserNameByToken(String stateLessToken) {
        Claims claims = TokenUtil.getClaims(stateLessToken);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    /**
     * 通过userName获取存在redis中的User实体类
     * @param userName 用户名
     * @return User实体类
     */
    public User getUserEntity(String userName){
        String userKey = userTokenPrefix + userName;
        return (User) redisUtil.get(userKey);
    }

}
