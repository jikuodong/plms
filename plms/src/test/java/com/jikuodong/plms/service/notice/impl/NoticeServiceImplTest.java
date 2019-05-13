package com.jikuodong.plms.service.notice.impl;

import com.jikuodong.plms.service.notice.NoticeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName NoticeServiceImplTest.java
 * @createTime 2019年03月29日 15:08:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class NoticeServiceImplTest {

    @Autowired
    private NoticeService noticeService;
    @Test
    public void orderStatusChangeNotice() throws Exception {
        noticeService.orderStatusChangeNotice("111111");
    }


}
