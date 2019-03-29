package com.jikuodong.plms.utils.rabbitmq.sender;

import com.jikuodong.plms.system.SystemConst;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.Arrays;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName TopicSender.java
 * @createTime 2019年03月29日 11:29:00
 */
@Slf4j
public class TopicSender implements MQSender {

    // 绑定相关
    private RabbitAdmin rabbitAdmin;
    private  RabbitTemplate rabbitTemplate;

    // 交换机
    private static final String EXCHANGE = "topicExchange";
    // 队列
    private String queue;
    // routingKey数组，第一个为精确队列，第二个为所属组队列
    private  String[] routingKeys;
    // 消息主体
    private Object msg;

    /**
     * describe 常量构造，目的发送全体消息
     * @method TopicSender
     * @author JKD
     * @param msg receiverTypes
     * @return
     * @data 2019/3/29 11:42
     * @throws
     */
    public TopicSender(Object msg, SystemConst.NoticeReceiverType...receiverTypes){
        this.routingKeys = new String[receiverTypes.length];
        for (int i = 0; i<receiverTypes.length; i++) {
            this.routingKeys[i] = receiverTypes[i].getKey();
        }
    }

    /**
     * describe 系统定义常量构造
     * @method TopicSender
     * @author JKD
     * @param receiverType, queue, msg]
     * @data 2019/3/29 11:48
     */
    public TopicSender(SystemConst.NoticeReceiverType receiverType, String queue, Object msg){
        this.queue = queue;
        this.routingKeys = new String[]{receiverType.getKey()+"."+queue, receiverType.getKey()};
        this.msg = msg;
    }

    /**
     * describe 普通队列、key构造
     * @method TopicSender
     * @author JKD
     * @param queue, msg, routingKeys]
     * @data 2019/3/29 11:50
     * @throws
     */
     public  TopicSender (String queue, Object msg,String... routingKeys) {
        this.routingKeys = routingKeys;
        this.queue =  queue;
        this.msg = msg;
     }

     /**
      * describe 设置模板信息
      * @method setRabbitAdminTemplate
      * @author JKD
      * @param admin 管理
      * @param template 模板
      * @return void
      * @data 2019/3/29 11:51
      */
    @Override
    public void setRabbitAdminTemplate(RabbitAdmin admin, RabbitTemplate template) {
        if (rabbitAdmin == null) {
            this.rabbitAdmin = admin;
        }
        if (rabbitTemplate == null) {
            this.rabbitTemplate = template;
        }
        // 调用初始化方法
        initSender();
    }

    /**
     * describe 初始化方法
     * @method initSender
     * @author JKD
     * @return void
     * @data 2019/3/29 11:55
     */
    @Override
    public void initSender() {
        // 创建交换机
        rabbitAdmin.declareExchange(new TopicExchange(EXCHANGE));
        // 创建队列
        rabbitAdmin.declareQueue(new Queue(queue));
        // routingKey 绑定Exchange 和 Queue
        Arrays.asList(routingKeys).forEach(e ->
                rabbitAdmin.declareBinding(BindingBuilder.bind(new Queue(queue))
                .to(new TopicExchange(EXCHANGE))
                .with(e)
                ));
    }

    /**
     * describe 发送方法
     * @method send
     * @author JKD
     * @return boolean 是否成功
     * @data 2019/3/29 12:00
     */
    @Override
    public boolean send() {
        try {
            rabbitTemplate.convertAndSend(EXCHANGE,routingKeys[0],msg);
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
        return true;
    }

    /**
     * describe 发送全体方法
     * @method sendAll
     * @author JKD
     * @return int
     * @data 2019/3/29 13:17
     */
    @Override
    public int sendAll() {
        int count = 0;
        try {
            for (String key : routingKeys) {
                rabbitTemplate.convertAndSend(EXCHANGE,key,msg);
                count++;
            }
        } catch (AmqpException e) {
            log.error(e.getMessage(),e);
        }
        return count;
    }
}
