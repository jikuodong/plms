package com.jikuodong.plms.interceptor.shiro.realm;

import com.jikuodong.plms.interceptor.shiro.token.UsernamePasswordTokenCustom;
import com.jikuodong.plms.interceptor.shiro.token.manager.TokenManagerCustom;
import com.jikuodong.plms.mapper.UserMapper;
import com.jikuodong.plms.po.User;
import com.jikuodong.plms.po.UserCustom;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * describe 自定义Realm
 * @author xmc
 * @date 2018/8/21 13:22
 * @param  * @param null
 * @return
 */
@Slf4j
public class RealmCustom extends AuthorizingRealm {

    @Autowired
    private UserMapper userMapper;

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordTokenCustom token = (UsernamePasswordTokenCustom) authenticationToken;
        // 判断是否为无状态token登录
        // 获取无状态token信息，如为空，则是用户名密码登录模式
        String statelessToken = token.getStatelessToken();
        if (statelessToken == null) {
            return usernamePasswordLogin(token);
        } else {
            // 不为null，则是无状态token登录
            return statelessTokenLogin(token);
        }
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 转为user对象
        User user = (User) principalCollection.getPrimaryPrincipal();
        // 设置权限
        try {
            // 获取权限编码
            // List<String> rights = permissionMapperCustom.findUserRightCodesByUserId(user.getUserId());
            List<String> rights = new ArrayList<>();
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addStringPermissions(rights);
            return authorizationInfo;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return new SimpleAuthorizationInfo();
    }

    /**
     * 用户名密码登录流程
     * @method usernamePasswordLogin
     * @author JKD
     * @param token 前端传入的token数据
     * @return org.apache.shiro.authc.SimpleAuthenticationInfo
     * @data 2019/3/13 11:19
     */
    private SimpleAuthenticationInfo usernamePasswordLogin(UsernamePasswordTokenCustom token) throws AuthenticationException{
        String userId = token.getUsername();
        // 查询数据库，获取信息
        UserCustom user;
        try {
            user = userMapper.findUserBaseInfoByUserId(userId);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new AuthenticationException("获取用户信息失败");
        }
        if ( user.getStatus() == -2) {
            throw new DisabledAccountException("用户被禁用");
        }
        if ( user.getStatus() == -1) {
            throw new LockedAccountException("用户被锁定");
        }
        if ( user.getStatus() == 0) {
            throw new AccountException("用户待审核");
        }
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :RealmCustom
        return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
    }

    /**
     *  无状态token登录
     * @method statelessTokenLogin
     * @author JKD
     * @param token 前端传入的token数据
     * @return org.apache.shiro.authc.SimpleAuthenticationInfo
     * @data 2019/3/13 11:16
     */
    private SimpleAuthenticationInfo statelessTokenLogin(UsernamePasswordTokenCustom token) throws AuthenticationException{
        // token登录之前已经校验过是有效、合法的，所以直接设置凭据信息
        token.setPassword(token.getStatelessToken().toCharArray());
        // 获取token中的用户名
        TokenManagerCustom tokenManager = TokenManagerCustom.getInstance();
        String userName = tokenManager.getUserNameByToken(token.getStatelessToken());
        // 获取redis中的用户实体类
        User user = tokenManager.getUserEntity(userName);
        //认证信息里存放账号密码, getName() 是当前Realm的继承方法,通常返回当前类名 :RealmCustom
        return new SimpleAuthenticationInfo(user, token.getStatelessToken(), getName());
    }
}
