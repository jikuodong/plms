/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.6.7
 Source Server Type    : MySQL
 Source Server Version : 50528
 Source Host           : localhost:3306
 Source Schema         : wpc

 Target Server Type    : MySQL
 Target Server Version : 50528
 File Encoding         : 65001

 Date: 08/03/2019 10:17:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qrcode
-- ----------------------------
DROP TABLE IF EXISTS `qrcode`;
CREATE TABLE `qrcode`  (
  `uid` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `batch` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `date` datetime NULL DEFAULT NULL,
  `destination` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `username` varchar(100) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Compact;

-- ----------------------------
-- Records of qrcode
-- ----------------------------

-- ----------------------------
-- Table structure for t_bank_info
-- ----------------------------
DROP TABLE IF EXISTS `t_bank_info`;
CREATE TABLE `t_bank_info`  (
  `bank_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bank_type` int(10) NULL DEFAULT NULL COMMENT '银行类型',
  `user_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `bank_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '银行开户行',
  `bank_contact` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系人',
  `card_id` int(50) NULL DEFAULT NULL COMMENT '银行卡号',
  `bank_phone` int(11) NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`bank_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company`  (
  `COMPANY_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '公司ID',
  `COMPANY_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司名称',
  `COMPANY_ADDR` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司地址',
  `COMPANY_PHONE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司电话',
  `COMPANY_LOGO` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司logo',
  `COMPANY_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公司网址',
  `STATUS` int(11) NULL DEFAULT 1 COMMENT '状态：0无效，1有效',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`COMPANY_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '公司信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_company
-- ----------------------------

-- ----------------------------
-- Table structure for t_eps_laboratory
-- ----------------------------
DROP TABLE IF EXISTS `t_eps_laboratory`;
CREATE TABLE `t_eps_laboratory`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '站点实验室ID',
  `LAB_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实验室名称',
  `LAB_PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实验室电话',
  `LAB_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '实验室地址',
  `LAB_STATUS` int(11) NULL DEFAULT NULL COMMENT '实验室状态(0无效，1有效)',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '站点实验室' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_eps_laboratory
-- ----------------------------

-- ----------------------------
-- Table structure for t_eps_order
-- ----------------------------
DROP TABLE IF EXISTS `t_eps_order`;
CREATE TABLE `t_eps_order`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ORDER_FROM` int(11) NULL DEFAULT NULL COMMENT '订单来源(EpsFrom)',
  `ORDER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单ID',
  `BUY_NUM` int(11) NULL DEFAULT NULL COMMENT '购买数量',
  `SERIAL_NUM` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品序列号(多个使用“,” 分隔)',
  `STATUS` int(11) NULL DEFAULT NULL COMMENT '订单状态',
  `SEND_OUT_EXPRESS` int(11) NULL DEFAULT NULL COMMENT '寄出快递',
  `OUT_TRACKING_NUM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寄出单号',
  `OUT_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寄出地址',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1111111112 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '食道筛查订单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_eps_order
-- ----------------------------

-- ----------------------------
-- Table structure for t_eps_sn
-- ----------------------------
DROP TABLE IF EXISTS `t_eps_sn`;
CREATE TABLE `t_eps_sn`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SERIAL_NUM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '产品序列号',
  `ORDER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属订单ID',
  `BIND_USER` int(11) NULL DEFAULT NULL COMMENT '绑定用户ID',
  `USER_NAME` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '使用者姓名',
  `USER_AGE` int(11) NULL DEFAULT NULL COMMENT '使用者年龄',
  `SENDER_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寄件人姓名',
  `SENDER_PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寄件人电话',
  `SENDER_ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寄件人地址',
  `SEND_BACK_EXPRESS` int(11) NULL DEFAULT NULL COMMENT '寄回快递',
  `BACK_TRACKING_NUM` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寄回单号',
  `BACK_LAB` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '寄回站点ID',
  `REPORT_PDF_URL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报告地址',
  `PDF_DOWLOAD_NUM` int(11) NULL DEFAULT 0 COMMENT '报告查看次数',
  `STATUS` int(11) NULL DEFAULT 0 COMMENT '产品状态',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `AK_Key_2`(`SERIAL_NUM`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '食道筛查产品序列表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_eps_sn
-- ----------------------------
-- Table structure for t_eps_sn_log
-- ----------------------------
DROP TABLE IF EXISTS `t_eps_sn_log`;
CREATE TABLE `t_eps_sn_log`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录ID',
  `SN_ID` int(11) NULL DEFAULT NULL COMMENT '产品ID',
  `CHANGE_STATUS` int(11) NULL DEFAULT NULL COMMENT '变更后状态',
  `HANDLE_DATE` datetime NULL DEFAULT NULL COMMENT '操作时间',
  `HANDLE_USER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作人ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品状态变更记录表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_eps_sn_log
-- ----------------------------
INSERT INTO `t_eps_sn_log` VALUES (1, 1, 3, '2019-02-25 14:12:29', 'fbc95f85997743999386160a3008a35b');

-- ----------------------------
-- Table structure for t_eps_user
-- ----------------------------
DROP TABLE IF EXISTS `t_eps_user`;
CREATE TABLE `t_eps_user`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `PHONE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `OPNE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '开放ID',
  `LAST_LOGIN_DATE` datetime NULL DEFAULT NULL COMMENT '上次登陆时间',
  `STATUS` int(11) NULL DEFAULT NULL COMMENT '状态',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '食道筛用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_eps_user_address
-- ----------------------------
DROP TABLE IF EXISTS `t_eps_user_address`;
CREATE TABLE `t_eps_user_address`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` int(11) NULL DEFAULT NULL COMMENT '用户ID',
  `NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `ADDRESS` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `IS_DEFAULT` bit(1) NULL DEFAULT b'0' COMMENT '是否默认',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '食道筛查用户地址表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_hospital
-- ----------------------------
DROP TABLE IF EXISTS `t_hospital`;
CREATE TABLE `t_hospital`  (
  `HOSPITAL_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '医院ID',
  `HOSPITAL_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院名称',
  `HOSPITAL_DEGREE` int(11) NULL DEFAULT NULL COMMENT '医院等级',
  `HOSPITAL_ADDR` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院地址',
  `LONGITUDE` decimal(10, 6) NULL DEFAULT NULL COMMENT '经度',
  `LATITUDE` decimal(10, 6) NULL DEFAULT NULL COMMENT '纬度',
  `HOSPITAL_PHONE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院电话',
  `HOSPITAL_LOGO` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院logo',
  `HOSPITAL_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院网址',
  `STATUS` int(11) NULL DEFAULT 1 COMMENT '状态：0无效，1有效',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`HOSPITAL_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医院信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_hospital
-- ----------------------------
-- ----------------------------
-- Table structure for t_hospital_expert
-- ----------------------------
DROP TABLE IF EXISTS `t_hospital_expert`;
CREATE TABLE `t_hospital_expert`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '专家ID',
  `EXPERT_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专家姓名',
  `SEX` bit(1) NULL DEFAULT NULL COMMENT '专家性别',
  `AGE` int(11) NULL DEFAULT NULL COMMENT '专家年龄',
  `SPECIALITY` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专业技能',
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号',
  `DEGREE` int(11) NULL DEFAULT NULL COMMENT '学位',
  `TITLE` int(11) NULL DEFAULT NULL COMMENT '职称',
  `HOSPITAL_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医院ID',
  `EXPERT_DESC` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '特长描述',
  `CELL_CHARGE` decimal(6, 2) NULL DEFAULT NULL COMMENT '细胞价格',
  `TISSUE_CHARGE` decimal(6, 2) NULL DEFAULT NULL COMMENT '组织价格',
  `HEAD_PIC_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像URL',
  `STATUS` int(11) NOT NULL DEFAULT 1 COMMENT '状态',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新日期',
  `RATE` int(1) NULL DEFAULT 5 COMMENT '医生评级（1-5星）',
  `PRAISE_COUNT` int(50) NULL DEFAULT 0 COMMENT '点赞数量',
  `IS_DEL` tinyint(1) NULL DEFAULT 0 COMMENT '标记删除（1已删除，0未删除）',
  `CONTENT_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专家彩页图文介绍URL',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医院专家信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_hospital_expert
-- ----------------------------
-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message`  (
  `MSG_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `SENDER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发送人',
  `RECEIVER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '接收人',
  `CONTENT` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `SEND_DT` datetime NULL DEFAULT NULL COMMENT '发送日期',
  `STATUS` int(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`MSG_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '消息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_order_detail
-- ----------------------------
DROP TABLE IF EXISTS `t_order_detail`;
CREATE TABLE `t_order_detail`  (
  `ORDER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '订单ID',
  `ORDER_NUM` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单号',
  `PATHOLOGY_TYPE` int(11) NOT NULL COMMENT '病理类型',
  `SAMPLE_TYPE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '样本类型',
  `ORDER_CHARGE` decimal(6, 2) NOT NULL COMMENT '订单价格',
  `ORDER_STATUS` int(11) NOT NULL COMMENT '订单状态',
  `ORDER_NOTE` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '订单备注',
  `REPORT_PDF_URL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '报告PDF地址',
  `PDF_DOWNLOAD_NUM` int(11) NOT NULL DEFAULT 0 COMMENT '报告下载次数',
  `PATIENT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病人ID',
  `PATIENT_CAN_SEE` bit(1) NOT NULL DEFAULT b'1' COMMENT '病人是否可见',
  `OUT_DOCTOR_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '门诊医生ID',
  `OUT_DOCTOR_CAN_SEE` bit(1) NOT NULL DEFAULT b'1' COMMENT '门诊医生是否可见',
  `EXPERT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '专家ID',
  `CREATE_USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人ID',
  `CREATE_DATE` datetime NOT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ORDER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单明细表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_order_detail
-- ----------------------------
-- ----------------------------
-- Table structure for t_order_valuation
-- ----------------------------
DROP TABLE IF EXISTS `t_order_valuation`;
CREATE TABLE `t_order_valuation`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ORDER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `VALUATOR` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `OUT_DOCTOR_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OUT_DOCTOR_SCORE` int(11) NULL DEFAULT NULL,
  `EXPERT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXPERT_SCORE` int(11) NULL DEFAULT NULL,
  `VALUATION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATE_DT` datetime NULL DEFAULT NULL,
  `STATUS` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '订单评价表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_out_doctor
-- ----------------------------
DROP TABLE IF EXISTS `t_out_doctor`;
CREATE TABLE `t_out_doctor`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '门诊医生ID',
  `TRUE_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `SEX` bit(1) NULL DEFAULT NULL COMMENT '性别',
  `AGE` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `ID_NUMBER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `DEGREE` int(11) NULL DEFAULT NULL COMMENT '学位',
  `TITLE` int(11) NULL DEFAULT NULL COMMENT '职称',
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `HOSPITAL_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属医院ID',
  `QR_CODE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二维码地址',
  `IS_DEL` tinyint(1) NULL DEFAULT 0 COMMENT '标记删除（1已删除，0未删除）',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '门诊医生表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_out_doctor
-- ----------------------------
-- ----------------------------
-- Table structure for t_patient
-- ----------------------------
DROP TABLE IF EXISTS `t_patient`;
CREATE TABLE `t_patient`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '病人ID',
  `TRUE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `SEX` bit(1) NULL DEFAULT NULL COMMENT '性别',
  `AGE` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `HEIGHT` double(5, 2) NULL DEFAULT NULL COMMENT '身高',
  `WEIGHT` double(5, 2) NULL DEFAULT NULL COMMENT '体重',
  `ID_NUMBER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `ADDRESS` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '地址',
  `MEDICAL_HISTORY` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病史',
  `PATIENT_DESC` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `IS_DEL` tinyint(1) NULL DEFAULT 0 COMMENT '标记删除（1删除，0未删除）',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `ID_NUMBER`(`ID_NUMBER`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '病人信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_patient
-- ----------------------------
-- ----------------------------
-- Table structure for t_pay_manager
-- ----------------------------
DROP TABLE IF EXISTS `t_pay_manager`;
CREATE TABLE `t_pay_manager`  (
  `pay_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '支付ID',
  `order_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '订单ID',
  `order_type` int(1) NOT NULL COMMENT '订单方式',
  `pay_type` int(2) NOT NULL COMMENT '支付方式',
  `order_status` int(1) NOT NULL DEFAULT 0 COMMENT '订单状态',
  `pay_money` decimal(10, 2) NOT NULL COMMENT '支付金额',
  `pay_status` int(1) NOT NULL DEFAULT 0 COMMENT '支付状态',
  `pay_sus_dt` datetime NULL DEFAULT NULL COMMENT '支付成功时间',
  `biko` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备考',
  `sus_api` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '成功api',
  `sus_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '成功url',
  `fail_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '失败url',
  `pay_manager_recordcol` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用项目',
  `pay_manager_recordcol1` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用项目',
  `pay_manager_recordcol2` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用项目',
  `upd_nm` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新者名',
  `upd_pg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新程序',
  `create_dt` datetime NOT NULL COMMENT '创建时间',
  `upd_dt` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`pay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10010195 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_pay_manager
-- ----------------------------
-- ----------------------------
-- Table structure for t_pep_difficult_sharing
-- ----------------------------
DROP TABLE IF EXISTS `t_pep_difficult_sharing`;
CREATE TABLE `t_pep_difficult_sharing`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '疑难分享ID',
  `SHARING_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分享标题',
  `SEX` int(11) NULL DEFAULT NULL COMMENT '性别',
  `AGE` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `ADDRESS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '居住地',
  `IMAGE_URL` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '分享配图',
  `DIAGNOSTIC_RESULT` varchar(300) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '诊断结果',
  `CARDINAL_SYMPTOM` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '主要症状',
  `THERAPEUTIC_REGIMEN` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '治疗方案',
  `SHARING_CONTENT` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '分享内容',
  `SHARING_STATE` int(11) NULL DEFAULT 1 COMMENT '分享状态（1：有效，0、无效）',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '疑难分享' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_pep_difficult_sharing
-- ----------------------------
-- ----------------------------
-- Table structure for t_pep_meeting
-- ----------------------------
DROP TABLE IF EXISTS `t_pep_meeting`;
CREATE TABLE `t_pep_meeting`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会议id',
  `MEETING_TITLE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议标题',
  `MEETING_START_TIME` datetime NULL DEFAULT NULL COMMENT '会议开始时间',
  `MEETING_END_TIME` datetime NULL DEFAULT NULL COMMENT '会议结束时间',
  `MEETING_PLACE` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议地点',
  `MEETING_SPONSOR` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议主办方',
  `MEETING_CONTACTS` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议联系人',
  `MEETING_PHONE` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `MEETING_CONTENT` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '会议内容',
  `MEETING_SEQUENCE` int(11) NULL DEFAULT NULL COMMENT '会议顺序',
  `MEETING_SOURCE` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会议来源',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `MEETING_STATE` int(11) NULL DEFAULT 1 COMMENT '会议状态(1:有效，2：无效)',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '近期会议' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_pep_meeting
-- ----------------------------
-- ----------------------------
-- Table structure for t_pep_news
-- ----------------------------
DROP TABLE IF EXISTS `t_pep_news`;
CREATE TABLE `t_pep_news`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `NEWS_IMG` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '轮播图片地址',
  `NEWS_TITLE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻标题',
  `NEWS_CONTENT` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '新闻内容',
  `NEWS_KEYWORD` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '新闻关键词',
  `NEWS_TYPE` int(11) NOT NULL DEFAULT 1 COMMENT '新闻类型（1、行业咨询，2、轮播）',
  `NEWS_SEQUENCE` int(11) NULL DEFAULT NULL COMMENT '新闻顺序',
  `RELEASED_DT` datetime NULL DEFAULT NULL COMMENT '发布日期',
  `CREATE_DT` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `UPDATE_DT` datetime NULL DEFAULT NULL COMMENT '更新日期',
  `CREATE_USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `NEWS_STATE` int(11) NULL DEFAULT 1 COMMENT '新闻状态',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_pep_news
-- ----------------------------
-- ----------------------------
-- Table structure for t_sales_info
-- ----------------------------
DROP TABLE IF EXISTS `t_sales_info`;
CREATE TABLE `t_sales_info`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '业务员ID',
  `SALES_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '真实姓名',
  `SEX` bit(1) NULL DEFAULT NULL COMMENT '性别',
  `AGE` int(11) NULL DEFAULT NULL COMMENT '年龄',
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `EMAIL` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮件',
  `COMPANY_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属公司ID',
  `QR_CODE` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '二维码地址',
  `IS_DEL` tinyint(1) NULL DEFAULT 0 COMMENT '标记删除（1已删除，0未删除）',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '业务员信息表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sales_info
-- ----------------------------
-- ----------------------------
-- Table structure for t_share_rule
-- ----------------------------
DROP TABLE IF EXISTS `t_share_rule`;
CREATE TABLE `t_share_rule`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `DOCTOR_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '医生ID',
  `CELL_SHARE_TOTAL` decimal(6, 5) NULL DEFAULT 0.00000 COMMENT '细胞分成占全部订单总份额',
  `TISSUE_SHARE_TOTAL` decimal(6, 5) NULL DEFAULT 0.00000 COMMENT '组织分成占全部订单总份额',
  `DOCTOR_SHARE` decimal(6, 5) NULL DEFAULT NULL COMMENT '医生份额',
  `SALE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '销售ID',
  `SALE_SHARE` decimal(6, 5) NULL DEFAULT NULL COMMENT '销售份额',
  `PARENT_SALE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '上级销售ID',
  `PARENT_SALE_SHARE` decimal(6, 6) NULL DEFAULT NULL COMMENT '上级销售份额',
  `STATUS` int(11) NULL DEFAULT NULL COMMENT '规则状态(1: 有效，0: 禁用)',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE,
  UNIQUE INDEX `AK_Key_2`(`DOCTOR_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '分成规则表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_share_rule
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_element
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_element`;
CREATE TABLE `t_sys_element`  (
  `ELEMENT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `ELEMENT_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ELEMENT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '元素表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_menu`;
CREATE TABLE `t_sys_menu`  (
  `MENU_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单ID',
  `PARENT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父菜单ID',
  `MENU_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `MENU_ICON` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `MENU_URL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单URL',
  `ROUTER_NAME` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路由名称',
  `COMPONENT_PATH` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `REDIRECT` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '重定向',
  `MENU_RIGHT_CODE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单权限CODE',
  `SORT_NUM` int(11) NULL DEFAULT NULL COMMENT '排序字段',
  `STATUS` int(11) NOT NULL DEFAULT 1 COMMENT '状态（0-废弃，1-正常）',
  PRIMARY KEY (`MENU_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_menu
-- ----------------------------

-- ----------------------------
-- Table structure for t_sys_menu_copy1
-- ----------------------------
-- ----------------------------
-- Table structure for t_sys_operation_log
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_operation_log`;
CREATE TABLE `t_sys_operation_log`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LOG_TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `OPERATITOR` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `LOG_TITLE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `FROM_IP` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `URL` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PARAM` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `EXCEPTION` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `OPERATION_DT` datetime NULL DEFAULT NULL,
  `COST_TIME` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统操作日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sys_right
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_right`;
CREATE TABLE `t_sys_right`  (
  `RIGHT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '' COMMENT '权限ID',
  `RIGHT_TYPE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '权限类型',
  `RELATION_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限类型对应的（菜单或元素）ID',
  PRIMARY KEY (`RIGHT_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_right
-- ----------------------------
INSERT INTO `t_sys_right` VALUES ('1', '1', '1');
INSERT INTO `t_sys_right` VALUES ('10', '1', '10');
INSERT INTO `t_sys_right` VALUES ('11', '1', '11');
INSERT INTO `t_sys_right` VALUES ('12', '1', '12');
INSERT INTO `t_sys_right` VALUES ('13', '1', '13');
INSERT INTO `t_sys_right` VALUES ('14', '1', '14');
INSERT INTO `t_sys_right` VALUES ('15', '1', '15');
INSERT INTO `t_sys_right` VALUES ('19', '1', '19');
INSERT INTO `t_sys_right` VALUES ('2', '1', '2');
INSERT INTO `t_sys_right` VALUES ('20', '1', '20');
INSERT INTO `t_sys_right` VALUES ('21', '1', '21');
INSERT INTO `t_sys_right` VALUES ('22', '1', '22');
INSERT INTO `t_sys_right` VALUES ('23', '1', '23');
INSERT INTO `t_sys_right` VALUES ('24', '1', '24');
INSERT INTO `t_sys_right` VALUES ('25', '1', '25');
INSERT INTO `t_sys_right` VALUES ('26', '1', '26');
INSERT INTO `t_sys_right` VALUES ('27', '1', '27');
INSERT INTO `t_sys_right` VALUES ('3', '1', '3');
INSERT INTO `t_sys_right` VALUES ('305c2df72ab54360ac051171d5daa581', '1', '07996244df124f42a08f144f5f122b9d');
INSERT INTO `t_sys_right` VALUES ('3dcb77040af04d1b8a62bfc2cbdab764', '1', '10ab1f41ef5246a2a3de20cbe6c858f9');
INSERT INTO `t_sys_right` VALUES ('4', '1', '4');
INSERT INTO `t_sys_right` VALUES ('40e47ac9523e40edbc28add975fb46f1', '1', '9ed7a163192a4b9395f6c3a69aca5774');
INSERT INTO `t_sys_right` VALUES ('4124e782d94a45dfa92906fff187be38', '1', '83e6d1d8312d4ede8684c21aed37bf02');
INSERT INTO `t_sys_right` VALUES ('438029985e094e699d0f0fc586e9c5b6', '1', 'e66585473ff74c7aa306f877647bacc3');
INSERT INTO `t_sys_right` VALUES ('5', '1', '5');
INSERT INTO `t_sys_right` VALUES ('510694858a4a4c3299013ca55b275039', '1', 'fbf1bf39aaa34186ad5c763b0ebba749');
INSERT INTO `t_sys_right` VALUES ('6', '1', '6');
INSERT INTO `t_sys_right` VALUES ('7', '1', '7');
INSERT INTO `t_sys_right` VALUES ('776147bd42b7493981de576ce1fb0178', '1', '5e09b14ddbfe446ea327183537176424');
INSERT INTO `t_sys_right` VALUES ('8', '1', '8');
INSERT INTO `t_sys_right` VALUES ('820a543ba5224123a9ba3a0100853e1c', '1', '3c4a0966583b49d182f39ab447b06f93');
INSERT INTO `t_sys_right` VALUES ('9', '1', '9');
INSERT INTO `t_sys_right` VALUES ('a182437c56474721b2c2e13f34c830df', '1', '47240f415ce346e59c0d5116963064f2');
INSERT INTO `t_sys_right` VALUES ('bc44db12c91e4de384c9bdb243d13f1b', '1', 'a0d00cfe2ae24b92bcb2dee813071b60');
INSERT INTO `t_sys_right` VALUES ('d611c43536c84037bb73c3074df41ceb', '1', 'd02fedcc1f2b48018dbc65fed76c8ac7');
INSERT INTO `t_sys_right` VALUES ('ef76192cf56248b0a760be17d8fb0c84', '1', '48121e6f9e244473b35812506a0b3727');

-- ----------------------------
-- Table structure for t_sys_right_element_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_right_element_relation`;
CREATE TABLE `t_sys_right_element_relation`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `RIGHT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限ID',
  `ELEMENT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '元素ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限元素关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sys_right_menu_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_right_menu_relation`;
CREATE TABLE `t_sys_right_menu_relation`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `RIGHT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `MENU_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '权限菜单关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
  `ROLE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `PARENT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '父角色ID',
  `ROLE_NAME` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `ROLE_DESC` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色描述',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`ROLE_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统角色表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('1', NULL, '超级管理员', '超级管理员，拥有赋权、查看订单等权限', '2018-09-13 14:17:25');
INSERT INTO `t_sys_role` VALUES ('100', NULL, '医院', '医院，拥有医生和专家', '2018-09-13 15:44:37');
INSERT INTO `t_sys_role` VALUES ('101', NULL, '门诊医生', '门诊医生，可以推荐病人进行注册和支付', '2018-09-13 15:41:07');
INSERT INTO `t_sys_role` VALUES ('102', NULL, '诊断专家', '诊断专家，给用户进行诊断，出具报告', '2018-09-13 15:45:48');
INSERT INTO `t_sys_role` VALUES ('2', NULL, '管理员', '管理员，拥有查看订单等权限', '2018-09-21 13:15:55');
INSERT INTO `t_sys_role` VALUES ('200', NULL, '公司', '业务员销售公司', '2018-09-13 15:44:37');
INSERT INTO `t_sys_role` VALUES ('201', NULL, '业务员', '业务员，可以推荐门诊医生', '2018-09-13 15:45:18');
INSERT INTO `t_sys_role` VALUES ('301', NULL, '普通用户', '普通用户，登录小程序创建检查单', '2018-09-21 13:13:06');
INSERT INTO `t_sys_role` VALUES ('400fbde224c84e67af0c24db31ba4bbc', NULL, '协助管理员', '协助管理员，拥有管理人员的权限', '2018-10-09 15:14:43');
INSERT INTO `t_sys_role` VALUES ('fa29f02cc7ef41f6b07cc6d2390d6b79', NULL, '发布管理员', '发布管理员，进行会议、新闻的发布以及疑难分享', '2018-12-03 09:11:52');

-- ----------------------------
-- Table structure for t_sys_role_right_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role_right_relation`;
CREATE TABLE `t_sys_role_right_relation`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `ROLE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  `RIGHT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 890 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色权限表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_role_right_relation
-- ----------------------------
INSERT INTO `t_sys_role_right_relation` VALUES (428, '101', '20');
INSERT INTO `t_sys_role_right_relation` VALUES (429, '101', '19');
INSERT INTO `t_sys_role_right_relation` VALUES (489, '2', '19');
INSERT INTO `t_sys_role_right_relation` VALUES (490, '2', '20');
INSERT INTO `t_sys_role_right_relation` VALUES (491, '2', '21');
INSERT INTO `t_sys_role_right_relation` VALUES (495, '400fbde224c84e67af0c24db31ba4bbc', '12');
INSERT INTO `t_sys_role_right_relation` VALUES (496, '400fbde224c84e67af0c24db31ba4bbc', '13');
INSERT INTO `t_sys_role_right_relation` VALUES (497, '400fbde224c84e67af0c24db31ba4bbc', '14');
INSERT INTO `t_sys_role_right_relation` VALUES (498, '400fbde224c84e67af0c24db31ba4bbc', '15');
INSERT INTO `t_sys_role_right_relation` VALUES (499, '400fbde224c84e67af0c24db31ba4bbc', '11');
INSERT INTO `t_sys_role_right_relation` VALUES (645, 'fa29f02cc7ef41f6b07cc6d2390d6b79', '4124e782d94a45dfa92906fff187be38');
INSERT INTO `t_sys_role_right_relation` VALUES (646, 'fa29f02cc7ef41f6b07cc6d2390d6b79', 'd611c43536c84037bb73c3074df41ceb');
INSERT INTO `t_sys_role_right_relation` VALUES (647, 'fa29f02cc7ef41f6b07cc6d2390d6b79', '510694858a4a4c3299013ca55b275039');
INSERT INTO `t_sys_role_right_relation` VALUES (648, 'fa29f02cc7ef41f6b07cc6d2390d6b79', '3dcb77040af04d1b8a62bfc2cbdab764');
INSERT INTO `t_sys_role_right_relation` VALUES (854, '1', '1');
INSERT INTO `t_sys_role_right_relation` VALUES (855, '1', '2');
INSERT INTO `t_sys_role_right_relation` VALUES (856, '1', '3');
INSERT INTO `t_sys_role_right_relation` VALUES (857, '1', '4');
INSERT INTO `t_sys_role_right_relation` VALUES (858, '1', '5');
INSERT INTO `t_sys_role_right_relation` VALUES (859, '1', '6');
INSERT INTO `t_sys_role_right_relation` VALUES (860, '1', '7');
INSERT INTO `t_sys_role_right_relation` VALUES (861, '1', '8');
INSERT INTO `t_sys_role_right_relation` VALUES (862, '1', '9');
INSERT INTO `t_sys_role_right_relation` VALUES (863, '1', '10');
INSERT INTO `t_sys_role_right_relation` VALUES (864, '1', '11');
INSERT INTO `t_sys_role_right_relation` VALUES (865, '1', '12');
INSERT INTO `t_sys_role_right_relation` VALUES (866, '1', '13');
INSERT INTO `t_sys_role_right_relation` VALUES (867, '1', '14');
INSERT INTO `t_sys_role_right_relation` VALUES (868, '1', '15');
INSERT INTO `t_sys_role_right_relation` VALUES (869, '1', '21');
INSERT INTO `t_sys_role_right_relation` VALUES (870, '1', '24');
INSERT INTO `t_sys_role_right_relation` VALUES (871, '1', '25');
INSERT INTO `t_sys_role_right_relation` VALUES (872, '1', '26');
INSERT INTO `t_sys_role_right_relation` VALUES (873, '1', '23');
INSERT INTO `t_sys_role_right_relation` VALUES (874, '1', '22');
INSERT INTO `t_sys_role_right_relation` VALUES (875, '1', '27');
INSERT INTO `t_sys_role_right_relation` VALUES (876, '1', '20');
INSERT INTO `t_sys_role_right_relation` VALUES (877, '1', '19');
INSERT INTO `t_sys_role_right_relation` VALUES (878, '1', '4124e782d94a45dfa92906fff187be38');
INSERT INTO `t_sys_role_right_relation` VALUES (879, '1', 'd611c43536c84037bb73c3074df41ceb');
INSERT INTO `t_sys_role_right_relation` VALUES (880, '1', '510694858a4a4c3299013ca55b275039');
INSERT INTO `t_sys_role_right_relation` VALUES (881, '1', '3dcb77040af04d1b8a62bfc2cbdab764');
INSERT INTO `t_sys_role_right_relation` VALUES (882, '1', '438029985e094e699d0f0fc586e9c5b6');
INSERT INTO `t_sys_role_right_relation` VALUES (883, '1', '305c2df72ab54360ac051171d5daa581');
INSERT INTO `t_sys_role_right_relation` VALUES (884, '1', '776147bd42b7493981de576ce1fb0178');
INSERT INTO `t_sys_role_right_relation` VALUES (885, '1', 'a182437c56474721b2c2e13f34c830df');
INSERT INTO `t_sys_role_right_relation` VALUES (886, '1', 'bc44db12c91e4de384c9bdb243d13f1b');
INSERT INTO `t_sys_role_right_relation` VALUES (887, '1', 'ef76192cf56248b0a760be17d8fb0c84');
INSERT INTO `t_sys_role_right_relation` VALUES (888, '1', '820a543ba5224123a9ba3a0100853e1c');
INSERT INTO `t_sys_role_right_relation` VALUES (889, '1', '40e47ac9523e40edbc28add975fb46f1');

-- ----------------------------
-- Table structure for t_sys_user
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user`;
CREATE TABLE `t_sys_user`  (
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `USER_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机号码',
  `OPEN_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信绑定OPEN_ID',
  `IS_SINGLE_ON` bit(1) NULL DEFAULT b'1' COMMENT '是否单点登陆',
  `LAST_LOGIN_DT` datetime NULL DEFAULT NULL COMMENT '上次登陆时间',
  `FAILURE_TIMES` int(11) NULL DEFAULT 0 COMMENT '失败次数',
  `STATUS` int(11) NULL DEFAULT 1 COMMENT '状态',
  `HEAD_PIC_URL` varchar(600) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像地址',
  `REFERENCE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '推荐人',
  `CREATE_DT` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `UPDATE_DT` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `UPDATE_USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`USER_ID`) USING BTREE,
  UNIQUE INDEX `USER_NAME`(`USER_NAME`) USING BTREE,
  UNIQUE INDEX `PHONE`(`PHONE`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_user
-- ----------------------------
INSERT INTO `t_sys_user` VALUES ('fbc95f85997743999386160a3008a35b', 'jkd', '06fe091e2683900faa999caa861839a3705198af', '13125121212', NULL, b'0', '2019-03-08 08:55:25', 0, 1, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for t_sys_user_role_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_user_role_relation`;
CREATE TABLE `t_sys_user_role_relation`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `ROLE_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 57 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_sys_user_role_relation
-- ----------------------------
INSERT INTO `t_sys_user_role_relation` VALUES (1, 'fbc95f85997743999386160a3008a35b', '1');
-- ----------------------------
-- Table structure for t_user_money
-- ----------------------------
DROP TABLE IF EXISTS `t_user_money`;
CREATE TABLE `t_user_money`  (
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `TOTAL_MONEY` decimal(9, 3) NULL DEFAULT NULL COMMENT '总金额',
  `USABLE_MONEY` decimal(9, 3) NULL DEFAULT NULL COMMENT '可用金额',
  `VERSION` int(11) NULL DEFAULT 1 COMMENT '数据版本',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户金额表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_money


-- ----------------------------
-- Table structure for t_user_money_dtl
-- ----------------------------
DROP TABLE IF EXISTS `t_user_money_dtl`;
CREATE TABLE `t_user_money_dtl`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `HANDLE_MONEY` decimal(9, 3) NULL DEFAULT NULL COMMENT '操作金额',
  `USABLE_MONEY` decimal(9, 3) NULL DEFAULT NULL COMMENT '有效金额',
  `REMAINING_MONEY` decimal(9, 3) NULL DEFAULT NULL COMMENT '剩余金额',
  `HANDLE_TYPE` int(11) NULL DEFAULT NULL COMMENT '操作类型',
  `HANDLE_DESC` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `STATUS` int(11) NULL DEFAULT NULL COMMENT '金额状态',
  `MONEY_SOURCE` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '生成日期',
  `HANDLE_DATE` datetime NULL DEFAULT NULL COMMENT '操作日期',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 362 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户金额明细表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_money_dtl

-- ----------------------------
-- Table structure for t_user_patient_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_user_patient_relation`;
CREATE TABLE `t_user_patient_relation`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `PATIENT_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '病人ID',
  `CREATE_DT` datetime NULL DEFAULT NULL COMMENT '创建日期',
  `STATUS` bit(1) NULL DEFAULT b'1' COMMENT '状态',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 195 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户病人关系表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_patient_relation
-- ----------------------------
-- Table structure for t_user_points
-- ----------------------------
DROP TABLE IF EXISTS `t_user_points`;
CREATE TABLE `t_user_points`  (
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户ID',
  `TOTAL_POINTS` int(11) NULL DEFAULT 0 COMMENT '总积分',
  `USABLE_POINTS` int(11) NULL DEFAULT 0 COMMENT '可用积分',
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户积分表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_points
-- ----------------------------
INSERT INTO `t_user_points` VALUES ('1c2ab223d2cd4bec8e5a9748b6fdbdec', 10, 10);

-- ----------------------------
-- Table structure for t_user_points_log
-- ----------------------------
DROP TABLE IF EXISTS `t_user_points_log`;
CREATE TABLE `t_user_points_log`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `HANDLE_POINTS` int(11) NULL DEFAULT NULL COMMENT '操作积分',
  `USABLE_POINTS` int(11) NULL DEFAULT NULL COMMENT '可用积分',
  `HANDLE_TYPE` int(11) NULL DEFAULT NULL COMMENT '操作类型',
  `POINTS_DESC` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '积分操作描述',
  `STATUS` int(11) NULL DEFAULT NULL COMMENT '积分状态',
  `HANDLE_DATE` datetime NULL DEFAULT NULL COMMENT '操作日期',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '积分记录日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_points_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_user_withdraw_dtl
-- ----------------------------
DROP TABLE IF EXISTS `t_user_withdraw_dtl`;
CREATE TABLE `t_user_withdraw_dtl`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `WITHDRAW_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现订单号',
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '申请人ID',
  `WX_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现微信号',
  `WITHDRAW_NAME` varchar(35) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现人姓名',
  `WITHDRAW_PHONE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现手机号',
  `WITHDRAW_MONEY` decimal(9, 3) NULL DEFAULT NULL COMMENT '申请提现金额',
  `ACTUAL_MONEY` decimal(9, 3) NULL DEFAULT NULL COMMENT '实际到账金额',
  `FEE` decimal(9, 3) NULL DEFAULT NULL COMMENT '提现手续费',
  `FREEZE_MONEY_DTL` int(11) NULL DEFAULT NULL COMMENT '资金(冻结)明细ID',
  `AUDIT_OPINION` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '审核意见',
  `WITHDRAW_STATUS` int(11) NULL DEFAULT NULL COMMENT '提现状态',
  `CREATE_USER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `CREATE_DATE` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `UPDATE_USER` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `UPDATE_DATE` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户提现申请明细表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_withdraw_dtl
-- ----------------------------
-- ----------------------------
-- Table structure for t_user_withdraw_log
-- ----------------------------
DROP TABLE IF EXISTS `t_user_withdraw_log`;
CREATE TABLE `t_user_withdraw_log`  (
  `ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ID',
  `WITHDRAW_ID` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现订单号',
  `USER_ID` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户ID',
  `REMARK` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注信息',
  `WITHDRAW_STATUS` int(11) NULL DEFAULT NULL COMMENT '提现状态',
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户提现申请日志表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user_withdraw_log
-- ----------------------------

-- ----------------------------
-- Table structure for t_wx_info
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_info`;
CREATE TABLE `t_wx_info`  (
  `id` int(3) NOT NULL AUTO_INCREMENT COMMENT '微信ID',
  `wx_type` int(1) NULL DEFAULT 0 COMMENT '公众号类型(1:服务号;2:订阅号;3:企业号;4小程序)',
  `app_id` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用ID',
  `app_secret` varchar(170) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '应用密钥',
  `token` varchar(110) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '令牌',
  `encoding_aes_key` varchar(110) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息加解密密钥',
  `en_or_decrypt_mode` int(1) NULL DEFAULT 0 COMMENT '消息加解密方式(0:安全模式;1:兼容模式;2:明文模式;)',
  `wx_account` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信号(非微信登录账号,被动回复用户消息的场合使用,使用原始ID也可以)',
  `mch_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付商户号',
  `pay_sign_key` varchar(110) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付签名密钥',
  `rate` decimal(4, 3) NOT NULL DEFAULT 0.000 COMMENT '费率',
  `name` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `account` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账号',
  `password` varchar(70) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `receive_status` bit(1) NOT NULL DEFAULT b'1' COMMENT '服务器接受状态(true:接收微信服务器转发的消息;false:无视微信服务器转发的消息;)',
  `valid_status` bit(1) NOT NULL DEFAULT b'1' COMMENT '验证状态(true:第一次接入时需要验证;false:不需要验证;)',
  `auth_status` bit(1) NOT NULL DEFAULT b'0' COMMENT '微信号认证状态(true:已认证;false:未认证;)',
  `attention_msg` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '微信关注 消息返回',
  `upd_nm` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新者名',
  `upd_pg` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新程序',
  `create_dt` datetime NOT NULL COMMENT '创建时间',
  `upd_dt` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_wx_info
-- ----------------------------
INSERT INTO `t_wx_info` VALUES (1, 4, 'wxbf95eb88a8ebe6e0', 'd131643a4babb331ea764552fcc61803', NULL, NULL, 0, 'gh_f3baa838473a', '1512790071', '63c983d638b14b8fbaed01f8dd6f0114', 0.006, 'WPC', NULL, NULL, b'0', b'0', b'0', '智慧病理-医生版', 'auto', 'lsy', '2015-09-30 14:09:58', '2018-05-30 11:06:19');
INSERT INTO `t_wx_info` VALUES (2, 4, 'wx78879d2d3db11296', 'ff3a57b2af1a0ed5625cdc3a46936147', NULL, NULL, 0, 'gh_d5e2623bab16', '1512790071', '63c983d638b14b8fbaed01f8dd6f0114', 0.006, 'WPC', NULL, NULL, b'0', b'0', b'0', '智慧病理-用户版', 'auto', 'lsy', '2018-08-20 17:05:20', '2018-08-20 17:05:22');

-- ----------------------------
-- Table structure for t_wx_pay_dtl
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_pay_dtl`;
CREATE TABLE `t_wx_pay_dtl`  (
  `wx_id` int(3) NOT NULL COMMENT '微信ID',
  `out_trade_no` int(11) NOT NULL COMMENT '商户订单号(对应pay_manager.pay_id)',
  `trade_status` int(1) NOT NULL COMMENT '内部交易状态(0:未结算给商家;1:已结算给商家;9:已退款)',
  `device_info` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '设备号',
  `transaction_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信支付订单号',
  `open_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户标识',
  `trade_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '交易类型(JSAPI、JSAPI、NATIVE、APP)',
  `trade_state` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '支付状态',
  `bank_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '付款银行',
  `total_fee` decimal(10, 2) NOT NULL COMMENT '总金额',
  `fee_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '货币种类',
  `cash_fee` decimal(10, 2) NOT NULL COMMENT '现金支付金额',
  `cash_fee_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '现金支付货币类型',
  `real_cash_fee` decimal(10, 2) NOT NULL COMMENT '扣除手续费后实际现金',
  `coupon_fee` decimal(10, 2) NOT NULL DEFAULT 0.00 COMMENT '代金券或立减优惠金额',
  `coupon_count` int(11) NOT NULL DEFAULT 0 COMMENT '代金券或立减优惠使用数量',
  `attach` varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商家数据包',
  `time_end` datetime NOT NULL COMMENT '支付完成时间',
  `trade_state_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '交易状态描述',
  `create_nm` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者名',
  `create_pg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建程序',
  `create_dt` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`wx_id`, `out_trade_no`, `trade_status`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_wx_pay_dtl
-- ----------------------------
-- ----------------------------
-- Table structure for t_wx_pay_refund_dtl
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_pay_refund_dtl`;
CREATE TABLE `t_wx_pay_refund_dtl`  (
  `wx_id` int(3) NOT NULL COMMENT '微信ID',
  `device_info` int(3) NOT NULL COMMENT '设备号',
  `transaction_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信支付订单号',
  `out_trade_no` int(11) NOT NULL COMMENT '商户订单号',
  `out_refund_no` int(11) NOT NULL COMMENT '商户退款单号',
  `refund_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '微信退款单号',
  `refund_channel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '退款渠道',
  `refund_fee` int(11) NULL DEFAULT NULL COMMENT '退款金额',
  `total_fee` int(11) NULL DEFAULT NULL COMMENT '订单总金额',
  `fee_type` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '订单金额货币种类',
  `cash_fee` int(11) NULL DEFAULT NULL COMMENT '现金支付金额',
  `cash_refund_fee` int(11) NULL DEFAULT NULL COMMENT '现金退款金额',
  `coupon_refund_fee` int(11) NULL DEFAULT NULL COMMENT '代金券或立减优惠退款金额',
  `coupon_refund_count` int(11) NULL DEFAULT NULL COMMENT '代金券或立减优惠使用数量',
  `coupon_refund_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '代金券或立减优惠ID',
  `create_nm` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建者名',
  `create_pg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '创建程序',
  `create_dt` datetime NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`wx_id`, `refund_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_wx_template_info
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_template_info`;
CREATE TABLE `t_wx_template_info`  (
  `wx_id` int(3) NOT NULL COMMENT '微信ID',
  `template_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板编号',
  `template_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板ID',
  `title` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板标题',
  `color` char(7) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '#000000' COMMENT '字体颜色',
  `upd_nm` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新者名',
  `upd_pg` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新程序',
  `create_dt` datetime NOT NULL COMMENT '创建时间',
  `upd_dt` datetime NOT NULL COMMENT '更新时间',
  `page` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '跳转页面',
  PRIMARY KEY (`wx_id`, `template_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_wx_template_info
-- ----------------------------
INSERT INTO `t_wx_template_info` VALUES (2, '100001', 'OXOCZVv2Xbg9LwJFr4pzB-y_Xb_OClc6kzMFG8TM_Bs', '订单支付成功通知', '#000000', 'auto', 'auto', '2018-08-24 10:53:09', '2018-08-24 10:53:12', NULL);

-- ----------------------------
-- Table structure for t_wx_template_param
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_template_param`;
CREATE TABLE `t_wx_template_param`  (
  `template_no` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板编号',
  `no` int(1) NOT NULL AUTO_INCREMENT COMMENT '参数序号',
  `param_key` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '关键字',
  `upd_nm` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新者名',
  `upd_pg` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新程序',
  `create_dt` datetime NOT NULL COMMENT '创建时间',
  `upd_dt` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`template_no`, `no`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_wx_template_param
-- ----------------------------
-- ----------------------------
-- Table structure for t_wx_template_send_info
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_template_send_info`;
CREATE TABLE `t_wx_template_send_info`  (
  `wx_id` int(3) NOT NULL COMMENT '微信ID',
  `open_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户OPENID',
  `template_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '模板编号',
  `count` int(1) NOT NULL COMMENT '发送次数',
  `upd_nm` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新者名',
  `upd_pg` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新程序',
  `create_dt` datetime NOT NULL COMMENT '创建时间',
  `upd_dt` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`wx_id`, `open_id`, `template_no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for t_wx_user_info
-- ----------------------------
DROP TABLE IF EXISTS `t_wx_user_info`;
CREATE TABLE `t_wx_user_info`  (
  `wx_id` int(3) NOT NULL COMMENT '微信ID',
  `open_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户的标识，对当前公众号唯一',
  `union_id` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '只有在用户向公众号绑定到微信开放平台账号后，才会出现改字段',
  `group_id` int(11) NOT NULL DEFAULT 0 COMMENT '用户所在的分组ID',
  `subscribe` int(1) NOT NULL DEFAULT 0 COMMENT '户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其他信息',
  `subscribe_time` int(11) NOT NULL DEFAULT 0 COMMENT '用户关注事件，为时间戳。如果用户曾多次关注，则取最后关注时间',
  `nickname` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户的昵称',
  `remark` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注',
  `sex` int(1) NOT NULL DEFAULT 0 COMMENT '用户的性别，值为1时是男性，值为2时是女性，值为0时是未知',
  `country` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在国家',
  `province` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在省份',
  `city` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户所在城市',
  `language` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户的语言，简体中文为zh__CN',
  `head_img_url` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效',
  `wx_user_infocol` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用项目',
  `wx_user_infocol1` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用项目',
  `wx_user_infocol2` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备用项目',
  `upd_nm` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新者名',
  `upd_pg` varchar(45) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '更新程序',
  `create_dt` datetime NOT NULL COMMENT '创建时间',
  `upd_dt` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`wx_id`, `open_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for ts_dic_data
-- ----------------------------
DROP TABLE IF EXISTS `ts_dic_data`;
CREATE TABLE `ts_dic_data`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `DIC_VALUE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DIC_DATA_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DIC_DATA_VALUE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `SORT_NUM` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 172 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典数据明细表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ts_dic_data
-- ----------------------------
INSERT INTO `ts_dic_data` VALUES (1, 'UserStatus', '禁用', '-2', 1);
INSERT INTO `ts_dic_data` VALUES (2, 'UserStatus', '被锁定', '-1', 2);
INSERT INTO `ts_dic_data` VALUES (3, 'UserStatus', '待审核', '0', 3);
INSERT INTO `ts_dic_data` VALUES (4, 'UserStatus', '正常', '1', 4);
INSERT INTO `ts_dic_data` VALUES (5, 'Sex', '女', '0', 1);
INSERT INTO `ts_dic_data` VALUES (6, 'Sex', '男', '1', 2);
INSERT INTO `ts_dic_data` VALUES (7, 'SingleOn', '关闭', '0', 1);
INSERT INTO `ts_dic_data` VALUES (8, 'SingleOn', '开启', '1', 2);
INSERT INTO `ts_dic_data` VALUES (9, 'RightType', '菜单访问权限', '1', 1);
INSERT INTO `ts_dic_data` VALUES (10, 'RightType', '功能模块的操作权限', '2', 2);
INSERT INTO `ts_dic_data` VALUES (11, 'RightType', '文件修改权限', '3', 3);
INSERT INTO `ts_dic_data` VALUES (12, 'RightType', '元素可见性控制', '4', 4);
INSERT INTO `ts_dic_data` VALUES (13, 'MenuStatus', '废弃', '0', 1);
INSERT INTO `ts_dic_data` VALUES (14, 'MenuStatus', '正常', '1', 2);
INSERT INTO `ts_dic_data` VALUES (15, 'DoctorDegree', '医学学士', '1', 1);
INSERT INTO `ts_dic_data` VALUES (16, 'DoctorDegree', '医学硕士', '2', 2);
INSERT INTO `ts_dic_data` VALUES (17, 'DoctorDegree', '医学博士', '3', 3);
INSERT INTO `ts_dic_data` VALUES (18, 'DoctorTitle', '门诊医师', '0', 1);
INSERT INTO `ts_dic_data` VALUES (19, 'DoctorTitle', '住院医师', '1', 2);
INSERT INTO `ts_dic_data` VALUES (20, 'DoctorTitle', '主治医师', '2', 3);
INSERT INTO `ts_dic_data` VALUES (21, 'DoctorTitle', '副主任医师', '3', 4);
INSERT INTO `ts_dic_data` VALUES (22, 'DoctorTitle', '主任医师', '4', 5);
INSERT INTO `ts_dic_data` VALUES (23, 'DoctorStatus', '禁用', '0', 1);
INSERT INTO `ts_dic_data` VALUES (24, 'DoctorStatus', '启用', '1', 2);
INSERT INTO `ts_dic_data` VALUES (25, 'PathologyType', '细胞切片', '1', 1);
INSERT INTO `ts_dic_data` VALUES (26, 'PathologyType', '组织切片', '2', 2);
INSERT INTO `ts_dic_data` VALUES (27, 'PaymentStatus', '退款失败', '-3', 1);
INSERT INTO `ts_dic_data` VALUES (28, 'PaymentStatus', '已退款', '-2', 2);
INSERT INTO `ts_dic_data` VALUES (29, 'PaymentStatus', '退款中', '-1', 3);
INSERT INTO `ts_dic_data` VALUES (30, 'PaymentStatus', '待支付', '0', 4);
INSERT INTO `ts_dic_data` VALUES (31, 'PaymentStatus', '已支付', '1', 5);
INSERT INTO `ts_dic_data` VALUES (32, 'PaymentStatus', '超时未支付', '2', 6);
INSERT INTO `ts_dic_data` VALUES (33, 'OrderStatus', '（退款、未支付等）无效', '-1', 1);
INSERT INTO `ts_dic_data` VALUES (34, 'OrderStatus', '已创建待支付', '0', 2);
INSERT INTO `ts_dic_data` VALUES (35, 'OrderStatus', '已支付待取材', '1', 3);
INSERT INTO `ts_dic_data` VALUES (36, 'OrderStatus', '已取材待扫描', '2', 4);
INSERT INTO `ts_dic_data` VALUES (37, 'OrderStatus', '已扫描待诊断', '3', 5);
INSERT INTO `ts_dic_data` VALUES (38, 'OrderStatus', '待查看报告', '4', 7);
INSERT INTO `ts_dic_data` VALUES (39, 'OrderStatus', '已查看报告', '5', 8);
INSERT INTO `ts_dic_data` VALUES (40, 'MsgStatus', '发送失败', '-2', 1);
INSERT INTO `ts_dic_data` VALUES (41, 'MsgStatus', '已删除', '-1', 2);
INSERT INTO `ts_dic_data` VALUES (42, 'MsgStatus', '未读', '0', 3);
INSERT INTO `ts_dic_data` VALUES (43, 'MsgStatus', '已读', '1', 4);
INSERT INTO `ts_dic_data` VALUES (44, 'HospitalDegree', '未知', '0', 1);
INSERT INTO `ts_dic_data` VALUES (45, 'HospitalDegree', '三级特等', '1', 2);
INSERT INTO `ts_dic_data` VALUES (46, 'HospitalDegree', '三级甲等', '2', 3);
INSERT INTO `ts_dic_data` VALUES (47, 'HospitalDegree', '三级乙等', '3', 4);
INSERT INTO `ts_dic_data` VALUES (48, 'HospitalDegree', '三级丙等', '4', 5);
INSERT INTO `ts_dic_data` VALUES (49, 'HospitalDegree', '二级甲等', '5', 6);
INSERT INTO `ts_dic_data` VALUES (50, 'HospitalDegree', '二级乙等', '6', 7);
INSERT INTO `ts_dic_data` VALUES (51, 'HospitalDegree', '二级丙等', '7', 8);
INSERT INTO `ts_dic_data` VALUES (52, 'HospitalDegree', '一级甲等', '8', 9);
INSERT INTO `ts_dic_data` VALUES (53, 'HospitalDegree', '一级乙等', '9', 10);
INSERT INTO `ts_dic_data` VALUES (54, 'HospitalDegree', '一级丙等', '10', 11);
INSERT INTO `ts_dic_data` VALUES (55, 'PointStatus', '已过期', '-3', 1);
INSERT INTO `ts_dic_data` VALUES (56, 'PointStatus', '冻结扣减', '-2', 2);
INSERT INTO `ts_dic_data` VALUES (57, 'PointStatus', '已扣除', '-1', 3);
INSERT INTO `ts_dic_data` VALUES (58, 'PointStatus', '冻结中', '0', 4);
INSERT INTO `ts_dic_data` VALUES (59, 'PointStatus', '有效', '1', 5);
INSERT INTO `ts_dic_data` VALUES (60, 'PointStatus', '冻结返还', '2', 6);
INSERT INTO `ts_dic_data` VALUES (61, 'PointHandle', '减少', '0', 1);
INSERT INTO `ts_dic_data` VALUES (62, 'PointHandle', '增加', '1', 2);
INSERT INTO `ts_dic_data` VALUES (63, 'SysRole', '超级管理员', '1', 1);
INSERT INTO `ts_dic_data` VALUES (64, 'SysRole', '管理员', '2', 2);
INSERT INTO `ts_dic_data` VALUES (65, 'SysRole', '医院', '100', 3);
INSERT INTO `ts_dic_data` VALUES (66, 'SysRole', '门诊医生', '101', 4);
INSERT INTO `ts_dic_data` VALUES (67, 'SysRole', '诊断专家', '102', 5);
INSERT INTO `ts_dic_data` VALUES (68, 'SysRole', '公司', '200', 6);
INSERT INTO `ts_dic_data` VALUES (69, 'SysRole', '业务员', '201', 7);
INSERT INTO `ts_dic_data` VALUES (70, 'SysRole', '用户', '300', 8);
INSERT INTO `ts_dic_data` VALUES (71, 'SysRole', '普通用户', '301', 9);
INSERT INTO `ts_dic_data` VALUES (72, 'HospitalStatus', '禁用', '0', 1);
INSERT INTO `ts_dic_data` VALUES (73, 'HospitalStatus', '启用', '1', 2);
INSERT INTO `ts_dic_data` VALUES (74, 'WithdrawStatus', '审核失败', '-1', 4);
INSERT INTO `ts_dic_data` VALUES (75, 'WithdrawStatus', '已提交待审核', '0', 1);
INSERT INTO `ts_dic_data` VALUES (76, 'WithdrawStatus', '审核通过等待转账', '1', 2);
INSERT INTO `ts_dic_data` VALUES (77, 'WithdrawStatus', '转账成功', '2', 3);
INSERT INTO `ts_dic_data` VALUES (78, 'MoneyHandle', '减少', '0', 1);
INSERT INTO `ts_dic_data` VALUES (79, 'MoneyHandle', '增加', '1', 1);
INSERT INTO `ts_dic_data` VALUES (80, 'MoneyStatus', '已过期', '-3', 1);
INSERT INTO `ts_dic_data` VALUES (81, 'MoneyStatus', '冻结扣减', '-2', 2);
INSERT INTO `ts_dic_data` VALUES (82, 'MoneyStatus', '已扣除', '-1', 3);
INSERT INTO `ts_dic_data` VALUES (83, 'MoneyStatus', '冻结中', '0', 4);
INSERT INTO `ts_dic_data` VALUES (84, 'MoneyStatus', '有效', '1', 5);
INSERT INTO `ts_dic_data` VALUES (85, 'MoneyStatus', '冻结返还', '2', 6);
INSERT INTO `ts_dic_data` VALUES (86, 'SysRole', 'test', 'cf83335bda4445168890a6e7b608f1e9', 10);
INSERT INTO `ts_dic_data` VALUES (88, 'OrderStatus', '已诊断待审核', '6', 6);
INSERT INTO `ts_dic_data` VALUES (111, 'SysRole', '发布管理员', 'fa29f02cc7ef41f6b07cc6d2390d6b79', 11);
INSERT INTO `ts_dic_data` VALUES (144, 'ExpressPaymentMethod', '寄方付', '1', 1);
INSERT INTO `ts_dic_data` VALUES (145, 'ExpressPaymentMethod', '收方付', '2', 2);
INSERT INTO `ts_dic_data` VALUES (146, 'ExpressPaymentMethod', '第三方付', '3', 3);
INSERT INTO `ts_dic_data` VALUES (150, 'PathologyType', '食道拉网', '3', 3);
INSERT INTO `ts_dic_data` VALUES (151, 'EpsFrom', '智慧病理云', '1', 1);
INSERT INTO `ts_dic_data` VALUES (152, 'EpsFrom', '门店推广', '5', 5);
INSERT INTO `ts_dic_data` VALUES (153, 'EpsFrom', '其他', '10', 10);
INSERT INTO `ts_dic_data` VALUES (154, 'Express', '顺丰快递', '1', 1);
INSERT INTO `ts_dic_data` VALUES (155, 'EpsOrderStatus', '已关闭', '-1', 6);
INSERT INTO `ts_dic_data` VALUES (156, 'EpsOrderStatus', '待付款', '0', 1);
INSERT INTO `ts_dic_data` VALUES (157, 'EpsOrderStatus', '待配货', '1', 2);
INSERT INTO `ts_dic_data` VALUES (158, 'EpsOrderStatus', '待出库', '2', 3);
INSERT INTO `ts_dic_data` VALUES (159, 'EpsOrderStatus', '待收件', '3', 4);
INSERT INTO `ts_dic_data` VALUES (160, 'EpsOrderStatus', '已完成', '4', 5);
INSERT INTO `ts_dic_data` VALUES (166, 'EpsSNStatus', '未绑定', '0', 0);
INSERT INTO `ts_dic_data` VALUES (167, 'EpsSNStatus', '待寄回', '1', 1);
INSERT INTO `ts_dic_data` VALUES (168, 'EpsSNStatus', '寄回中', '2', 2);
INSERT INTO `ts_dic_data` VALUES (169, 'EpsSNStatus', '实验室已收件', '3', 3);
INSERT INTO `ts_dic_data` VALUES (170, 'EpsSNStatus', '样本处理中', '4', 4);
INSERT INTO `ts_dic_data` VALUES (171, 'EpsSNStatus', '检测完毕', '10', 10);

-- ----------------------------
-- Table structure for ts_dic_type
-- ----------------------------
DROP TABLE IF EXISTS `ts_dic_type`;
CREATE TABLE `ts_dic_type`  (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `DIC_NAME` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DIC_VALUE` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '字典类型表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of ts_dic_type
-- ----------------------------
INSERT INTO `ts_dic_type` VALUES (1, '用户状态', 'UserStatus');
INSERT INTO `ts_dic_type` VALUES (2, '性别', 'Sex');
INSERT INTO `ts_dic_type` VALUES (3, '单点登陆', 'SingleOn');
INSERT INTO `ts_dic_type` VALUES (4, '权限类型', 'RightType');
INSERT INTO `ts_dic_type` VALUES (5, '菜单状态', 'MenuStatus');
INSERT INTO `ts_dic_type` VALUES (6, '医生学位', 'DoctorDegree');
INSERT INTO `ts_dic_type` VALUES (7, '医生职称', 'DoctorTitle');
INSERT INTO `ts_dic_type` VALUES (8, '医生状态', 'DoctorStatus');
INSERT INTO `ts_dic_type` VALUES (9, '病理类型', 'PathologyType');
INSERT INTO `ts_dic_type` VALUES (10, '支付状态', 'PaymentStatus');
INSERT INTO `ts_dic_type` VALUES (11, '订单状态', 'OrderStatus');
INSERT INTO `ts_dic_type` VALUES (12, '消息状态', 'MsgStatus');
INSERT INTO `ts_dic_type` VALUES (13, '医院等级', 'HospitalDegree');
INSERT INTO `ts_dic_type` VALUES (14, '积分状态', 'PointStatus');
INSERT INTO `ts_dic_type` VALUES (15, '积分操作', 'PointHandle');
INSERT INTO `ts_dic_type` VALUES (16, '系统角色', 'SysRole');
INSERT INTO `ts_dic_type` VALUES (17, '医院状态', 'HospitalStatus');
INSERT INTO `ts_dic_type` VALUES (18, '提现状态', 'WithdrawStatus');
INSERT INTO `ts_dic_type` VALUES (19, '金额操作', 'MoneyHandle');
INSERT INTO `ts_dic_type` VALUES (20, '金额状态', 'MoneyStatus');
INSERT INTO `ts_dic_type` VALUES (25, '食道筛订单来源', 'EpsFrom');
INSERT INTO `ts_dic_type` VALUES (26, '食道筛订单状态', 'EpsOrderStatus');
INSERT INTO `ts_dic_type` VALUES (27, '食道筛产品状态', 'EpsSNStatus');
INSERT INTO `ts_dic_type` VALUES (28, '快递单位', 'Express');
INSERT INTO `ts_dic_type` VALUES (29, '快递付款方式', 'ExpressPaymentMethod');

-- ----------------------------
-- View structure for v_expert_info
-- ----------------------------
DROP VIEW IF EXISTS `v_expert_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_expert_info` AS select `t`.`ID` AS `ID`,`t`.`EXPERT_NAME` AS `EXPERT_NAME`,`t`.`CONTENT_URL` AS `CONTENT_URL`,`t`.`SPECIALITY` AS `SPECIALITY`,`dic1`.`DIC_DATA_NAME` AS `DOCTOR_TITLE_NAME`,`dic2`.`DIC_DATA_NAME` AS `DOCTOR_DEGREE_NAME`,`t`.`EXPERT_DESC` AS `EXPERT_DESC`,`t`.`CELL_CHARGE` AS `CELL_CHARGE`,`t`.`TISSUE_CHARGE` AS `TISSUE_CHARGE`,`t`.`HEAD_PIC_URL` AS `HEAD_PIC_URL`,`t`.`RATE` AS `RATE`,`t1`.`HOSPITAL_NAME` AS `HOSPITAL_NAME`,`dic3`.`DIC_DATA_NAME` AS `HOSPITAL_DEGREE_NAME`,`t1`.`LONGITUDE` AS `LONGITUDE`,`t1`.`LATITUDE` AS `LATITUDE` from ((((`t_hospital_expert` `t` left join `t_hospital` `t1` on((`t`.`HOSPITAL_ID` = `t1`.`HOSPITAL_ID`))) left join `ts_dic_data` `dic1` on(((`dic1`.`DIC_DATA_VALUE` = `t`.`TITLE`) and (`dic1`.`DIC_VALUE` = 'DoctorTitle')))) left join `ts_dic_data` `dic2` on(((`dic2`.`DIC_DATA_VALUE` = `t`.`DEGREE`) and (`dic2`.`DIC_VALUE` = 'DoctorDegree')))) left join `ts_dic_data` `dic3` on(((`dic3`.`DIC_DATA_VALUE` = `t1`.`HOSPITAL_DEGREE`) and (`dic3`.`DIC_VALUE` = 'HospitalDegree')))) where (`t`.`STATUS` = 1) ;

-- ----------------------------
-- View structure for v_order_detail_data
-- ----------------------------
DROP VIEW IF EXISTS `v_order_detail_data`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_order_detail_data` AS (select `a`.`ORDER_ID` AS `ORDER_ID`,`a`.`ORDER_NUM` AS `ORDER_NUM`,`a`.`ORDER_STATUS` AS `ORDER_STATUS`,`dic1`.`DIC_DATA_NAME` AS `ORDER_STATUS_NAME`,`a`.`PATHOLOGY_TYPE` AS `PATHOLOGY_TYPE`,`dic2`.`DIC_DATA_NAME` AS `PATHOLOGY_TYPE_NAME`,`a`.`ORDER_CHARGE` AS `ORDER_CHARGE`,`dic4`.`DIC_DATA_NAME` AS `PAYMENT_STATUS_NAME`,`b`.`pay_sus_dt` AS `PAYMENT_DATE`,`a`.`CREATE_DATE` AS `ORDER_CREATE_DATE`,`a`.`REPORT_PDF_URL` AS `REPORT_PDF_URL`,`a`.`PDF_DOWNLOAD_NUM` AS `PDF_DOWNLOAD_NUM`,`a`.`PATIENT_CAN_SEE` AS `PATIENT_CAN_SEE`,`a`.`OUT_DOCTOR_CAN_SEE` AS `OUT_DOCTOR_CAN_SEE`,`a`.`ORDER_NOTE` AS `ORDER_NOTE`,`e`.`HOSPITAL_NAME` AS `HOSPITAL_NAME`,`d`.`EXPERT_NAME` AS `EXPERT_NAME`,`dic5`.`DIC_DATA_NAME` AS `EXPERT_SEX`,`d`.`AGE` AS `EXPERT_AGE`,`d`.`SPECIALITY` AS `EXPERT_SPECIALITY`,`d`.`PHONE` AS `EXPERT_PHONE`,`d`.`DEGREE` AS `EXPERT_DEGREE`,`dic6`.`DIC_DATA_NAME` AS `DoctorDegree`,`d`.`TITLE` AS `EXPERT_TITLE`,`d`.`RATE` AS `EXPERT_RATE`,`dic7`.`DIC_DATA_NAME` AS `DoctorTitle`,`f`.`ID` AS `OUT_DOCTOR_ID`,`f`.`TRUE_NAME` AS `OUT_DOCTOR_NAME`,`g`.`HOSPITAL_NAME` AS `OUT_HOSPITAL_NAME`,`dic8`.`DIC_DATA_NAME` AS `OUT_DOCTOR_SEX`,`f`.`AGE` AS `OUT_DOCTOR_AGE`,`f`.`ID_NUMBER` AS `OUT_DOCTOR_ID_NUMBER`,`f`.`PHONE` AS `OUT_DOCTOR_PHONE`,`dic9`.`DIC_DATA_NAME` AS `OUT_DOCTOR_DEGREE`,`dic10`.`DIC_DATA_NAME` AS `OUT_DOCTOR_TITLE`,`f`.`EMAIL` AS `OUT_DOCTOR_EMAIL`,`h`.`pay_type` AS `PAY_TYPE`,`h`.`pay_status` AS `PAY_STATUS`,`h`.`pay_money` AS `PAY_MONEY`,`h`.`pay_sus_dt` AS `PAY_SUC_DT`,`h`.`create_dt` AS `PAY_CREATE_DT`,`c`.`ID` AS `PATIENT_ID`,`c`.`TRUE_NAME` AS `PATIENT_NAME`,`dic3`.`DIC_DATA_NAME` AS `PATIENT_SEX`,`c`.`AGE` AS `PATIENT_AGE`,`c`.`HEIGHT` AS `PATIENT_HEIGHT`,`c`.`WEIGHT` AS `PATIENT_WEIGHT`,`c`.`PHONE` AS `PATIENT_PHONE`,`c`.`CREATE_DATE` AS `PATIENT_CREATE_DATE`,`c`.`ADDRESS` AS `PATIENT_ADDRESS`,`c`.`EMAIL` AS `PATIENT_EMAIL`,`c`.`ID_NUMBER` AS `PATIENT_ID_NUMBER`,`c`.`MEDICAL_HISTORY` AS `PATIENT_MEDICAL_HISTORY`,`k`.`SALES_NAME` AS `SALES_NAME`,`l`.`COMPANY_NAME` AS `COMPANY_NAME` from ((((((((((((((((((((`t_order_detail` `a` left join `t_pay_manager` `b` on((`b`.`order_id` = `a`.`ORDER_ID`))) left join `t_patient` `c` on((`c`.`ID` = `a`.`PATIENT_ID`))) left join `t_hospital_expert` `d` on((`d`.`ID` = `a`.`EXPERT_ID`))) left join `t_hospital` `e` on((`e`.`HOSPITAL_ID` = `d`.`HOSPITAL_ID`))) left join `t_out_doctor` `f` on((`f`.`ID` = `a`.`OUT_DOCTOR_ID`))) left join `t_hospital` `g` on((`g`.`HOSPITAL_ID` = `f`.`HOSPITAL_ID`))) left join `t_pay_manager` `h` on((`h`.`order_id` = `a`.`ORDER_ID`))) left join `t_sys_user` `j` on((`f`.`ID` = `j`.`USER_ID`))) left join `t_sales_info` `k` on((`k`.`ID` = `j`.`REFERENCE_ID`))) left join `t_company` `l` on((`l`.`COMPANY_ID` = `k`.`COMPANY_ID`))) left join `ts_dic_data` `dic1` on(((`dic1`.`DIC_DATA_VALUE` = `a`.`ORDER_STATUS`) and (`dic1`.`DIC_VALUE` = 'OrderStatus')))) left join `ts_dic_data` `dic2` on(((`dic2`.`DIC_DATA_VALUE` = `a`.`PATHOLOGY_TYPE`) and (`dic2`.`DIC_VALUE` = 'PathologyType')))) left join `ts_dic_data` `dic3` on(((`dic3`.`DIC_DATA_VALUE` = `c`.`SEX`) and (`dic3`.`DIC_VALUE` = 'Sex')))) left join `ts_dic_data` `dic4` on(((`dic4`.`DIC_DATA_VALUE` = `h`.`pay_status`) and (`dic4`.`DIC_VALUE` = 'PaymentStatus')))) left join `ts_dic_data` `dic5` on(((`dic5`.`DIC_DATA_VALUE` = `d`.`SEX`) and (`dic5`.`DIC_VALUE` = 'Sex')))) left join `ts_dic_data` `dic6` on(((`dic6`.`DIC_DATA_VALUE` = `d`.`DEGREE`) and (`dic6`.`DIC_VALUE` = 'DoctorDegree')))) left join `ts_dic_data` `dic7` on(((`dic7`.`DIC_DATA_VALUE` = `d`.`TITLE`) and (`dic7`.`DIC_VALUE` = 'DoctorTitle')))) left join `ts_dic_data` `dic8` on(((`dic8`.`DIC_DATA_VALUE` = `f`.`SEX`) and (`dic8`.`DIC_VALUE` = 'Sex')))) left join `ts_dic_data` `dic9` on(((`dic9`.`DIC_DATA_VALUE` = `f`.`DEGREE`) and (`dic9`.`DIC_VALUE` = 'DoctorDegree')))) left join `ts_dic_data` `dic10` on(((`dic10`.`DIC_DATA_VALUE` = `f`.`TITLE`) and (`dic10`.`DIC_VALUE` = 'DoctorTitle'))))) ;

-- ----------------------------
-- View structure for v_order_detail_info
-- ----------------------------
DROP VIEW IF EXISTS `v_order_detail_info`;
CREATE ALGORITHM = UNDEFINED SQL SECURITY DEFINER VIEW `v_order_detail_info` AS (select `a`.`ORDER_ID` AS `ORDER_ID`,`a`.`ORDER_NUM` AS `ORDER_NUM`,`a`.`ORDER_STATUS` AS `ORDER_STATUS`,`dic1`.`DIC_DATA_NAME` AS `ORDER_STATUS_NAME`,`dic2`.`DIC_DATA_NAME` AS `PATHOLOGY_TYPE_NAME`,`a`.`ORDER_CHARGE` AS `ORDER_CHARGE`,`dic4`.`DIC_DATA_NAME` AS `PAYMENT_STATUS_NAME`,`b`.`pay_sus_dt` AS `PAYMENT_DATE`,`a`.`CREATE_DATE` AS `ORDER_CREATE_DATE`,`a`.`REPORT_PDF_URL` AS `REPORT_PDF_URL`,`a`.`PATIENT_CAN_SEE` AS `PATIENT_CAN_SEE`,`a`.`OUT_DOCTOR_CAN_SEE` AS `OUT_DOCTOR_CAN_SEE`,`e`.`HOSPITAL_NAME` AS `HOSPITAL_NAME`,`d`.`ID` AS `EXPERT_ID`,`d`.`EXPERT_NAME` AS `EXPERT_NAME`,`f`.`ID` AS `OUT_DOCTOR_ID`,`f`.`TRUE_NAME` AS `OUT_DOCTOR_NAME`,`f`.`PHONE` AS `OUT_DOCTOR_PHONE`,`g`.`HOSPITAL_NAME` AS `OUT_HOSPITAL_NAME`,`i`.`USER_ID` AS `PATIENT_USER_ID`,`c`.`ID` AS `PATIENT_ID`,`c`.`TRUE_NAME` AS `PATIENT_NAME`,`dic3`.`DIC_DATA_NAME` AS `PATIENT_SEX`,`c`.`AGE` AS `PATIENT_AGE`,`c`.`PHONE` AS `PATIENT_PHONE`,`c`.`ADDRESS` AS `PATIENT_ADDRESS`,`c`.`ID_NUMBER` AS `PATIENT_ID_NUMBER` from ((((((((((((`t_order_detail` `a` left join `t_pay_manager` `b` on((`b`.`order_id` = `a`.`ORDER_ID`))) left join `t_patient` `c` on((`c`.`ID` = `a`.`PATIENT_ID`))) left join `t_hospital_expert` `d` on((`d`.`ID` = `a`.`EXPERT_ID`))) left join `t_hospital` `e` on((`e`.`HOSPITAL_ID` = `d`.`HOSPITAL_ID`))) left join `t_out_doctor` `f` on((`f`.`ID` = `a`.`OUT_DOCTOR_ID`))) left join `t_hospital` `g` on((`g`.`HOSPITAL_ID` = `f`.`HOSPITAL_ID`))) left join `t_pay_manager` `h` on((`h`.`order_id` = `a`.`ORDER_ID`))) left join `t_user_patient_relation` `i` on((`i`.`PATIENT_ID` = `c`.`ID`))) left join `ts_dic_data` `dic1` on(((`dic1`.`DIC_DATA_VALUE` = `a`.`ORDER_STATUS`) and (`dic1`.`DIC_VALUE` = 'OrderStatus')))) left join `ts_dic_data` `dic2` on(((`dic2`.`DIC_DATA_VALUE` = `a`.`PATHOLOGY_TYPE`) and (`dic2`.`DIC_VALUE` = 'PathologyType')))) left join `ts_dic_data` `dic3` on(((`dic3`.`DIC_DATA_VALUE` = `c`.`SEX`) and (`dic3`.`DIC_VALUE` = 'Sex')))) left join `ts_dic_data` `dic4` on(((`dic4`.`DIC_DATA_VALUE` = `h`.`pay_status`) and (`dic4`.`DIC_VALUE` = 'PaymentStatus'))))) ;

SET FOREIGN_KEY_CHECKS = 1;
