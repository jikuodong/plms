package com.jikuodong.plms.controller.user;

import com.jikuodong.plms.base.BaseController;
import com.jikuodong.plms.po.User;
import com.jikuodong.plms.service.user.UserService;
import com.jikuodong.plms.utils.UuidUtil;
import com.jikuodong.plms.utils.json.ReturnJsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author Ji kuodong
 * @version 1.0.0
 * @ClassName UserController.java
 * @Description 用户信息相关操作
 * @createTime 2018年10月16日 11:17:00
 */
@RestController
@RequestMapping("user")
public class UserController extends BaseController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * @method addUserInfo
     * @description 添加用户信息
     * @author Ji kuodong
     * @return java.lang.Object
     * @data 2018/10/16 12:00
     */
    @RequestMapping("addUserInfo")
    public Object addUserInfo() throws Exception {
        logBefore(logger, "添加用户信息");
        User user = new User();
        String userId = UuidUtil.get32UUID();
        user.setUserid(userId);
        user.setUsername("admin");
        user.setPassword("123456");
        user.setLastLoginOn(new Date());
        userService.addUserInfo(user);
        return ReturnJsonUtil.returnSucc("success");
    }
}
