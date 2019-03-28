package com.jikuodong.plms.rabbitmqtest.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * describe 消息消费者
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName TopicReceiver.java
 * @createTime 2019年03月28日 11:23:00
 */
@Component
public class TopicReceiver {
    @RabbitListener(queues = "topic.message")
    @RabbitHandler
    public void topicMessage(String msg) {
        System.out.println("接收信息1");
        System.out.println("topicMessageReceiver :" + msg);
    }
    @RabbitListener(queues = "topic.messages")
    @RabbitHandler
    public void topicMessages(String msg) {
        System.out.println("接收信息2");
        System.out.println("topicMessagesReceiver :" +msg);
    }
}
