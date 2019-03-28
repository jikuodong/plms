package com.jikuodong.plms.rabbitmqtest.sender;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * describe topic 消息发送者
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName TopicSender.java
 * @createTime 2019年03月28日 11:16:00
 */
@Component
public class TopicSender {
    private RabbitTemplate rabbitTemplate;
    @Autowired
    public TopicSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send1() {
        System.out.println("发送信息1");
        String context = "Hello I am Message 1";
        // 两个队列都能接收到，符合topic.message和topic.#
        rabbitTemplate.convertAndSend("exchange", "topic.message",context);
    }
    public void send2() {
        System.out.println("发送信息2");
        String context = "Hello I am Message 2";
        // 只有由key: topic.# 绑定的队列接收到
        rabbitTemplate.convertAndSend("exchange","topic.messages",context);
    }
}
