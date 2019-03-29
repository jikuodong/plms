package com.jikuodong.plms.utils.rabbitmq.config;

import com.jikuodong.plms.utils.rabbitmq.NoticeUtil;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * describe RabbitMQ配置
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName RabbitConfig.java
 * @createTime 2019年03月29日 09:40:00
 */
@Configuration
public class RabbitConfig {

    /**
     * describe 封装了对RabbitMQ 的管理操作的对象
     * @method rabbitAdmin
     * @author JKD
     * @param connectionFactory
     * @return org.springframework.amqp.rabbit.core.RabbitAdmin
     * @data 2019/3/29 10:04
     */
    @Bean
    RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    /**
     * describe Json 序列化
     * @method jsonMessageConverter
     * @author JKD
     * @return org.springframework.amqp.support.converter.MessageConverter
     * @data 2019/3/29 10:06
     */
    @Bean
    MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    /**
     * describe 注入RabbitAdmin 和 Template
     * @method noticeUtil
     * @author JKD
     * @param rabbitAdmin, rabbitTemplate
     * @return NoticeUtil
     * @data 2019/3/29 10:17
     */
    @Bean(name = "noticeUtil")
    NoticeUtil noticeUtil(RabbitAdmin rabbitAdmin, RabbitTemplate rabbitTemplate){
        NoticeUtil util = NoticeUtil.getInstance();
        util.setRabbitAdmin(rabbitAdmin);
        util.setRabbitTemplate(rabbitTemplate);
        return util;
    }

}
