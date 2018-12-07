package com.jikuodong.plms.controller.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

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
public class UserControllerTest {
    @Autowired
    protected WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setup() {
        // 初始化MockMvc对象
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    /**
     * @method getPostResultAction
     * @description TODO
     * @author Ji kuodong
     * @param [target, map]
     * @return org.springframework.test.web.servlet.ResultActions
     * @data 2018/12/6 14:50
     */
    protected ResultActions getPostResultAction(String target, MultiValueMap<String, String> map) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.post(target) // 构造一个post请求
                .accept(MediaType.APPLICATION_JSON_UTF8) // 接收数据类型 json形式
                .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 发送数据类型表单形式
                .params(map));
    }
    @Test
    public void addUserInfo() throws Exception {
        String target = "/user/addUserInfo";
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        getPostResultAction(target,map)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", equalTo("1")))
                .andExpect(jsonPath("$.data", equalTo("success")));
    }
}
