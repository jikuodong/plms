package com.jikuodong.plms.system;

/**
 * describe
 *
 * @author JKD
 * @version 1.0.0
 * @ClassName SystemConst.java
 * @createTime 2019年03月29日 11:39:00
 */
public class SystemConst {
    /**
     * 通知消息接收对象类型枚举
     *
     */
    public enum NoticeReceiverType {
        USER(1, "wpc.user", "用户"), OUT_DOCTOR(2, "wpc.doctor", "门诊医生"), SALE(3, "wpc.sale", "业务员");

        private int type; // 类型
        private String key; // routing-key 前缀
        private String desc; // 描述

        NoticeReceiverType(int type, String key, String desc) {
            this.type = type;
            this.key = key;
            this.desc = desc;
        }

        public int getType() {
            return type;
        }

        public String getKey() {
            return key;
        }

        public String getDesc() {
            return desc;
        }

    }
}
