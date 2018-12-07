package com.jikuodong.plms.service.user.impl;

import com.jikuodong.plms.mapper.UserMapper;
import com.jikuodong.plms.po.User;
import com.jikuodong.plms.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Ji kuodong
 * @version 1.0.0
 * @ClassName UserServiceImpl.java
 * @Description TODO
 * @createTime 2018年10月16日 11:39:00
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    private UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * @method addUserInfo
     * @description 添加患者信息
     * @author Ji kuodong
     * @param  user User
     * @return int
     * @data 2018/10/16 11:51
     */
    @Override
    public int addUserInfo(User user) {
        return userMapper.insert(user);
    }
}
