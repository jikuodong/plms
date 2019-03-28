package com.jikuodong.plms.service.user.impl;

import com.jikuodong.plms.rabbitmqtest.sender.TopicSender;
import com.jikuodong.plms.service.user.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;

/**
 * @author Ji kuodong
 * @version 1.0.0
 * @ClassName UserServiceImplTest.java
 * @Description 用户信息service 实现类
 * @createTime 2018年12月07日 13:23:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    TopicSender topicSender;

    @Test
    public void send1(){
        topicSender.send1();
        topicSender.send2();
    }

}
