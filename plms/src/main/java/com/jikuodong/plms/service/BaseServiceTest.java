package com.jikuodong.plms.service;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ji kuodong
 * @version 1.0.0
 * @ClassName BaseServiceTest.java
 * @Description TODO
 * @createTime 2018年12月07日 13:33:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional(rollbackFor = Exception.class)
public class BaseServiceTest {
}
