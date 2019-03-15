package com.jikuodong.plms.controller.user;

import com.jikuodong.plms.controller.BaseControllerTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Ji kuodong
 * @version 1.0.0
 * @ClassName UserControllerTest.java
 * @Description 单元测试
 * @createTime 2018年12月04日 14:55:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest  extends BaseControllerTest {
    private static final String BASE_PATH = "/user";

    @Test
    public void addUserInfo() throws Exception {
        String target = BASE_PATH + "/addUserInfo";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        getPostResultAction(target, map)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", equalTo("1")))
                .andExpect(jsonPath("$.data", equalTo("success")));
    }
}
