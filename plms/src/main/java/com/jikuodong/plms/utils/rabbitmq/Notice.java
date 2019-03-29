package com.jikuodong.plms.utils.rabbitmq;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * describe RabbitMQ 所传递消息通知类
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName Notice.java
 * @createTime 2019年03月29日 14:32:00
 */
@Data
public class Notice {

    /**
     * 发送人
     */
    private String sender;
    /**
     * 发送人ID
     */
    private String senderId;
    /**
     * 接收人
     */
    private String receiver;
    /**
     * 接收人ID
     */
    private String receiverId;
    /**
     * 发送时间（指定该JSON序列化和反序列化所依照的类[自定义]）,默认对象创建时间
     */
  /*  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)*/
    private LocalDateTime sendDate =LocalDateTime.now();


     // ------------------消息主体--------------

    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String content;
    /**
     * 其他信息
     */
    private Map<String, Object> extraInfo = new HashMap<>();
    /**
     * 底部信息
     */
    private String foot;

    /**
     * 添加其他信息
     */
    public void addExtraInfo(String key, Object value){
        extraInfo.put(key, value);
    }
}
