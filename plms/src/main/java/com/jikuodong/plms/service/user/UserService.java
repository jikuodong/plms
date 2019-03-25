package com.jikuodong.plms.service.user;

import com.jikuodong.plms.po.User;
import com.jikuodong.plms.po.UserCustom;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

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

    /**
     * 根据用户名或手机号码或OPEN_ID查询用户信息
     */
    UserCustom selectUserByUsernameOrPhoneOrOpenId(String code) throws Exception;

    /**
     * 更新用户错误次数信息，五次及以上则锁定用户
     */
    boolean updateUserFailureTimes(String userId, int times) throws Exception;

    /**
     * 更新用户登录信息
     */
    boolean updateUserLoginInfo(String userId) throws Exception;

    /**
     * 获取用户列表
     * @author JKD
     * @data 2019/3/22 17:37
     */
    List<User> getUserList(Date start, Date end) throws Exception;
}





