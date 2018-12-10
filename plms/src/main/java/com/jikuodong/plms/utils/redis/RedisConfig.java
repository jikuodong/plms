package com.jikuodong.plms.utils.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 * @author JKD
 * @version 1.0.0
 * @ClassName RedisConfig.java
 * @createTime 2018年12月10日 09:44:00
 */
@Configuration
public class RedisConfig {
    /**
     * 实例化 RedisTemplate 对象
     * 提供给 RedisUtil 使用
     * @method RedisTemplate
     * @author JKD
     * @param redisConnectionFactory springboot配置好的连接工厂
     * @return org.springframework.data.redis.core.RedisTemplate<java.lang.String,java.lang.Object>
     * @data 2018/12/10 10:05
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        initRedisTemplate(redisTemplate, redisConnectionFactory);
        return redisTemplate;
    }

    /**
     *  设置数据存入 redis 的序列化方式,并开启事务
     * @method initRedisTemplate
     * @author JKD
     * @param redisTemplate, factory
     * @return void
     * @data 2018/12/10 10:04
     */
    private void initRedisTemplate(RedisTemplate<String, Object> redisTemplate, RedisConnectionFactory factory) {
        //如果不配置Serializer，那么存储的时候缺省使用String，如果用User类型存储，那么会提示错误User can't cast to String！
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        // 开启事务
        redisTemplate.setEnableTransactionSupport(true);
        redisTemplate.setConnectionFactory(factory);
    }

    /**
     * 注入封装RedisTemplate 给RedisUtil提供操作类
     * @method redisUtil
     * @author Ji kuodong
     * @param redisTemplate RedisTemplate
     * @return com.jikuodong.plms.utils.redis.RedisUtil
     * @data 2018/12/10 9:51
     * @throws
     */
    @Bean(name = "redisUtil")
    public RedisUtil redisUtil(RedisTemplate<String, Object> redisTemplate) {
        RedisUtil redisUtil = new RedisUtil();
        redisUtil.setRedisTemplate(redisTemplate);
        return redisUtil;
    }
}
