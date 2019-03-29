package com.jikuodong.plms.service.notice.impl;

import com.jikuodong.plms.service.notice.NoticeService;
import com.jikuodong.plms.system.SystemConst;
import com.jikuodong.plms.utils.rabbitmq.Notice;
import com.jikuodong.plms.utils.rabbitmq.NoticeUtil;
import com.jikuodong.plms.utils.rabbitmq.sender.MQSender;
import com.jikuodong.plms.utils.rabbitmq.sender.TopicSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName NoticeServiceImpl.java
 * @createTime 2019年03月29日 13:47:00
 */
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
    // 并发线程安全的队列容器，存放封装好的通知
    private static ConcurrentLinkedDeque<MQSender> sendQueue = new ConcurrentLinkedDeque<>();
    // 嵌套类实现线程池
    private static class NoticeProfitExecutor{
        private static int threadCount = 4;
        private static ExecutorService fixedThreadPool = Executors.newFixedThreadPool(threadCount);
    }
    // 静态方法获取线程池
    private static ExecutorService getNoticeProfixExecutor() {
        return NoticeProfitExecutor.fixedThreadPool;
    }

    /**
     * 订单状态更新通知
     * [付款成功后，状态更新通知]
     *
     * @method orderStatusChangeNotice
     * @author JKD
     * @param orderId
     * @return void
     * @data 2019/3/29 13:48
     */
    @Override
    public void orderStatusChangeNotice(String orderId) throws Exception {
        // 病人通知拼接
        Notice patientNotice = new Notice();
        patientNotice.setSenderId("system");
        patientNotice.setSender("系统通知");
        patientNotice.setSendDate(LocalDateTime.now());
        patientNotice.setTitle("检查单状态变更通知");
        patientNotice.setContent("您的检查单状态已更新为：" + "正常");
        patientNotice.setReceiverId("1111111111111"); // 病人所属用户接收人
        patientNotice.setReceiver("测试姓名");
        patientNotice.addExtraInfo("医生姓名", "医生1");
        patientNotice.addExtraInfo("联系电话", "111111111");
        patientNotice.addExtraInfo("所选专家", "专家1");
        patientNotice.addExtraInfo("创建时间", "2019-03-29");
        patientNotice.setFoot("如有疑问，请尽快联系医生");
        MQSender sendPatient = new TopicSender(SystemConst.NoticeReceiverType.USER, patientNotice.getReceiverId(),patientNotice);
        // 存放到容器中
        sendQueue.offer(sendPatient);
        start();
    }

    private void start() {
        getNoticeProfixExecutor().submit(() -> {
           while (!sendQueue.isEmpty()) {
               // 从对头出队
               NoticeUtil.getInstance().sendNotice(sendQueue.poll());
           }
        });
    }
}
