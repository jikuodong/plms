package com.jikuodong.plms.service.notice;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName NoticeService.java
 * @createTime 2019年03月29日 13:46:00
 */
public interface NoticeService {
    /**
     * 订单状态更新通知 [付款成功后，状态更新通知]
     */
    void orderStatusChangeNotice(String orderId) throws Exception;
}
