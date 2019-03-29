package com.jikuodong.plms.utils.rabbitmq;

import com.jikuodong.plms.utils.rabbitmq.sender.MQSender;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.concurrent.locks.ReentrantLock;

/**
 * describe RabbitMQ 发送通知工具类，操作Sender发送信息
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName NoticeUtil.java
 * @createTime 2019年03月29日 10:27:00
 */
public class NoticeUtil {
    private RabbitAdmin rabbitAdmin;
    private RabbitTemplate rabbitTemplate;

    // 重入锁
    private  static ReentrantLock lock = new ReentrantLock();
    // 该对象
    private static NoticeUtil instance;

    // 单例模式
    private NoticeUtil() {
    }

    // 获取对象
    public  static  NoticeUtil getInstance(){
        lock.lock();
        try {
            if (instance == null) {
                instance = new NoticeUtil();
            }
        } finally {
            lock.unlock();
        }
        return instance;
    }

    public void setRabbitAdmin(RabbitAdmin rabbitAdmin){
        this.rabbitAdmin = rabbitAdmin;
    }
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    /*
     * -------------------------------操作-----------------------------------/
     */

    /**
     * describe 发送通知
     * @method sendNotice
     * @author JKD
     * @param sender
     * @return void
     * @data 2019/3/29 11:06
     */
    public void sendNotice(MQSender sender){
        sender.setRabbitAdminTemplate(rabbitAdmin, rabbitTemplate);
        sender.send();
    }

    /**
     * describe 发送全体通知
     * @method sendAllNotice
     * @author JKD
     * @param sender
     * @return void
     * @data 2019/3/29 11:07
     */
    public void sendAllNotice(MQSender sender) {
        sender.setRabbitAdminTemplate(rabbitAdmin, rabbitTemplate);
        sender.sendAll();
    }
}
