package com.jikuodong.plms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 日志注解
 * @author JKD
 * @version 1.0.0
 * @ClassName Log.java
 * @createTime 2019年03月20日 11:44:00
 */
@Retention(RetentionPolicy.RUNTIME) // 运行时执行
@Target(ElementType.METHOD) // 只支持加方法上
public @interface Log {
    // 日志信息
    String value() default "";
    String value1() default "";
}
