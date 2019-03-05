package com.jikuodong.plms.system;

/**
 * 用户常量
 */
public class UserConst {

	// 用户状态枚举类
	public enum UserStatus {
		NORMAL(1, "正常"), REVIEW(0, "待审核"), LOCKED(-1, "锁定"), DISABLED(-2, "禁用");

		private int value;
		private String desc;

		UserStatus(int value, String desc) {
			this.value = value;
			this.desc = desc;
		}

		public int getValue() {
			return value;
		}

		public String getDesc() {
			return desc;
		}
	}

	// 注册状态
	public class RegisterStatus {
		/**
		 * 注册成功
		 */
		public static final int SUCCESS = 1;
		/**
		 * 用户名已存在
		 */
		public static final int REPEATUSER = -1;
		/**
		 * 电话已存在
		 */
		public static final int REPEATPHONE = -2;

		private RegisterStatus() {
		}
	}
}
