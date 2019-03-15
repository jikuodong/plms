package com.jikuodong.plms.controller;

import com.jikuodong.plms.interceptor.shiro.token.UsernamePasswordTokenCustom;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.subject.WebSubject;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import static com.jikuodong.plms.system.JunitConst.TEST_TOKEN;

/**
 * 单元测试父类接口
 * @author JKD
 * @version 1.0.0
 * @ClassName BaseControllerTest.java
 * @createTime 2019年03月15日 09:21:00
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class BaseControllerTest {
    @Autowired
    private WebApplicationContext context;
    @Resource
    private SecurityManager securityManager;

    protected MockMvc mvc;
    private Subject subject;
    private MockHttpServletRequest mockHttpServletRequest;
    private MockHttpServletResponse mockHttpServletResponse;

    /**
     *  表示在任意使用@Test注解标注的public void方法执行之前执行
     * @method setup
     * @author JKD
     * @return void
     * @data 2019/3/15 9:57
     */
    @Before
    public  void  setup() {
        mockHttpServletRequest = new MockHttpServletRequest(context.getServletContext());
        mockHttpServletResponse = new MockHttpServletResponse();
        // 初始化MockMvc对象
        this.mvc = MockMvcBuilders.webAppContextSetup(context).build();
        SecurityUtils.setSecurityManager(securityManager);
        login(TEST_TOKEN);
    }

    /**
     *  构造POST访问，返回结果
     * @method getPostResultAction
     * @author JKD
     * @param target 目标url
     * @param map 参数map
     * @return org.springframework.test.web.servlet.ResultActions
     * @data 2019/3/15 10:25
     */
    protected ResultActions getPostResultAction(String target, MultiValueMap<String, String> map) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.post(target) // 构造一个post请求
        .accept(MediaType.APPLICATION_JSON_UTF8) // 接收数据类型 json形式
        .contentType(MediaType.APPLICATION_FORM_URLENCODED) // 发送数据类型表单形式
        .params(map));
    }

    /**
     * 构造GET访问，返回结果
     * @method getGetResultAction
     * @author JKD
     * @param target 目标url
     * @param map 参数map
     * @return org.springframework.test.web.servlet.ResultActions
     * @data 2019/3/15 10:33
     */
    protected  ResultActions getGetResultAction(String target, MultiValueMap<String, String> map) throws Exception {
        return mvc.perform(MockMvcRequestBuilders.get(target)
        .accept(MediaType.APPLICATION_JSON_UTF8)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .params(map));
    }
    /**
     *
     * @method login
     * @author JKD
     * @param token 传入的token值
     * @return void
     * @data 2019/3/15 9:52
     * @throws
     */
    private void login(String token) {
        subject = new WebSubject.Builder(mockHttpServletRequest, mockHttpServletResponse).buildWebSubject();
        AuthenticationToken auth = new UsernamePasswordTokenCustom(token);
        subject.login(auth);
        ThreadContext.bind(subject);
    }
}
