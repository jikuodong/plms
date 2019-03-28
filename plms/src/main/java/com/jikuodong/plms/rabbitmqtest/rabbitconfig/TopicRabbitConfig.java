package com.jikuodong.plms.rabbitmqtest.rabbitconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * topic交换机，根据routing-key 自由绑定不同的队列
 * @author JKD
 * @version 1.0.0
 * @ClassName TopicRabbitConfig.java
 * @createTime 2019年03月28日 09:52:00
 */
@Configuration
public class TopicRabbitConfig {
    /**
     * 声明2个队列，并持久化（默认为持久化，false为不持久化）
     */
    static final String MESSAGE = "topic.message";
    static final String MESSAGES = "topic.messages";
    @Bean
    public Queue messageQueue() {
        return new Queue(MESSAGE, false);
    }
    @Bean
    public Queue messagesQueue() {
        return new Queue(MESSAGES);
    }
    /**
     * 声明交换机名称
     */
    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    /**
     * 将Exchange 和 Queue进行绑定
     */
    @Bean
    public Binding bindingExchangeMessage(Queue messageQueue, TopicExchange exchange){
        // 只绑定唯一的队列，只匹配“topic.message”的routing-key
        return BindingBuilder.bind(messageQueue).to(exchange).with("topic.message");
    }
    @Bean
    Binding bindingExchangeMessages(Queue messagesQueue, TopicExchange exchange) {
        // 匹配topic.开头的routing-key
        return BindingBuilder.bind(messagesQueue).to(exchange).with("topic.#");
    }
}
