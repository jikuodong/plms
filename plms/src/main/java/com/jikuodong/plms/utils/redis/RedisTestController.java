package com.jikuodong.plms.utils.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * redis测试类
 * @author JKD
 * @version 1.0.0
 * @ClassName RedisTestController.java
 * @createTime 2018年12月10日 10:48:00
 */
@Controller
@RequestMapping("/redisTest")
public class RedisTestController {

    private final RedisUtil redisUtil;

    @Autowired
    public RedisTestController(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    /**
     * 测试redis
     * @method testRedisAdd
     * @author JKD
     * @param [key, value]
     * @return java.lang.Object
     * @data 2018/12/10 10:53
     */
    @RequestMapping("/testRedisAdd")
    @ResponseBody
    Object testRedisAdd(String key,String value){
        redisUtil.set(key,value);
        System.out.println(redisUtil.get(key));
        return redisUtil.get(key);
    }
}
