package com.jikuodong.plms.service.user;

import com.jikuodong.plms.po.User;

/**
 * @author Ji kuodong
 * @version 1.0.0
 * @ClassName UserService.java
 * @Description 用户信息接口
 * @createTime 2018年10月16日 11:38:00
 */
public interface UserService {
    /***
     * 添加用户信息
     * @method addUserInfo
     * @description 添加用户信息
     * @author Ji kuodong
     * @param user User
     * @return int
     * @data 2018/10/16 11:48
     * @throws  Exception 异常
     */
    int addUserInfo(User user) throws Exception;
}





