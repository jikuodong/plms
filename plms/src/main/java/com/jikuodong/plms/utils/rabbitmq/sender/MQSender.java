package com.jikuodong.plms.utils.rabbitmq.sender;

import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * describe 抽象类
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName MQSender.java
 * @createTime 2019年03月29日 11:10:00
 */
public interface MQSender {
    /**
     * describe 设置模板信息
     * @method setRabbitAdminTemplate
     * @author JKD
     * @param admin 管理
     * @param template 模板
     * @return void
     * @data 2019/3/29 11:14
     */
    void setRabbitAdminTemplate(RabbitAdmin admin, RabbitTemplate template);

    /**
     *  初始化方法
     */
    void initSender();

    /**
     *  发送方法
     * @return 是否成功
     */
    boolean send();

    /**
     * sendAll
     * @return 发送成功的routingKey数量
     */
    int sendAll();
}
