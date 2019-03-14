package com.jikuodong.plms.service.impl;

import com.jikuodong.plms.po.User;
import com.jikuodong.plms.mapper.UserMapper;
import com.jikuodong.plms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JKD
 * @since 2019-03-07
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
