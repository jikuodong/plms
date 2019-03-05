package com.jikuodong.plms.interceptor.shiro.token;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * 无状态token，继承UsernamePasswordToken
 */
public class UsernamePasswordTokenCustom extends UsernamePasswordToken {
    // 添加一个无状态token属性
    private String statelessToken;

    // 重载构造方法
    public UsernamePasswordTokenCustom(String statelessToken) {
        this.statelessToken = statelessToken;
    }

    public UsernamePasswordTokenCustom(String username, String password) {
        super(username, password);
    }

    public String getStatelessToken() {
        return statelessToken;
    }
}
