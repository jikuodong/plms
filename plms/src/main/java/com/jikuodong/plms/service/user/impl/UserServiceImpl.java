package com.jikuodong.plms.service.user.impl;

import com.jikuodong.plms.annotation.TargetDB;
import com.jikuodong.plms.datasource.DataSourceKey;
import com.jikuodong.plms.mapper.UserMapper;
import com.jikuodong.plms.po.User;
import com.jikuodong.plms.po.UserCustom;
import com.jikuodong.plms.service.user.UserService;
import com.jikuodong.plms.system.UserConst;
import com.jikuodong.plms.utils.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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

    /**
     * 根据用户名或手机号码查询用户信息
     *
     * @param code
     */
    @Override
    public UserCustom selectUserByUsernameOrPhoneOrOpenId(String code) throws Exception {
        return userMapper.selectUserByUsernameOrPhoneOrOpenId(code);
    }

    /**
     * 更新用户错误次数信息，五次及以上则锁定用户
     *
     * @param userId
     * @param times
     */
    @Override
    public boolean updateUserFailureTimes(String userId, int times) throws Exception {
        User user = new User();
        user.setUserId(userId);
        user.setFailureTimes(times);
        if (times >= 5) {
            // 错误次数大于5次，则锁定账号
            user.setStatus(UserConst.UserStatus.LOCKED.getValue());
        }
        int row = userMapper.updateByPrimaryKeySelective(user);
        return row == 1;
    }

    /**
     * 更新用户登录信息
     *
     * @param userId
     */
    @Override
    public boolean updateUserLoginInfo(String userId) throws Exception {
        User user = new User();
        user.setUserId(userId);
        user.setLastLoginDt(new Date());
        user.setFailureTimes(0);
        int row = userMapper.updateByPrimaryKeySelective(user);
        return row == 1;
    }

    /**
     * 获取用户列表
     * @method getUserList
     * @author JKD
     * @return java.util.List<com.jikuodong.plms.po.User>
     * @data 2019/3/25 8:39
     */
    @TargetDB(DataSourceKey.DB_SLAVE)
    @Override
    public List<User> getUserList(Date start, Date end) throws Exception {
        PageData pd = new PageData();
        pd.put("startDate", start);
        pd.put("endDate", end);
        return userMapper.getUserList(pd);
    }
}
