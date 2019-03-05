package com.jikuodong.plms.interceptor.shiro.token.manager;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 对token进行操作的接口
 * @author
 */
public interface TokenManager {

    /**
     * 创建一个token关联上指定用户
     * @param userEntity 指定用户的实体类
     * @return 生成的token字符串
     */
    String createToken(Object userEntity);

    /**
     * 从shiro的token中获取用户实体类
     * @param authenticationToken shrio认证token
     * @return 生成的token
     */
    Object getEntityByToken(AuthenticationToken authenticationToken);

    /**
     * 检查token字符串是否有效
     * @param token 无状态token字符串
     * @return 是否有效
     */
    boolean check(String token);

    /**
     * 检查token是否有效
     * @param authenticationToken shiro认证token
     * @return 是否有效
     */
    boolean checkToken(AuthenticationToken authenticationToken);

    /**
     * 从字符串中解析出shiro的token
     * @param token 加密后的字符串
     * @return 认证token
     */
    AuthenticationToken getToken(String token);

    /**
     * 清除token
     * @param userName 登录用户名
     */
    void deleteToken(String userName);

}
