package com.jikuodong.plms.service.user.impl;

import com.jikuodong.plms.po.User;
import com.jikuodong.plms.service.BaseServiceTest;
import com.jikuodong.plms.service.user.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Ji kuodong
 * @version 1.0.0
 * @ClassName UserServiceImplTest.java
 * @Description 用户信息service 实现类
 * @createTime 2018年12月07日 13:23:00
 */
public class UserServiceImplTest extends BaseServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUserInfo() throws Exception {
        User user = new User();
        user.setPhone("11111111111");
        user.setUserid("1111111111");
        user.setPassword("111111111");
        int count = userService.addUserInfo(user);
        assertThat("failure addUserInfo",count, is(1));
    }
}
