package com.jikuodong.plms.annotation;

import com.jikuodong.plms.datasource.DataSourceKey;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * AOP 切换数据注解
 * @author JKD
 * @version 1.0.0
 * @ClassName TargetDB.java
 * @createTime 2019年03月21日 10:50:00
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TargetDB {

    // 默认Master 数据源
    DataSourceKey value() default DataSourceKey.DB_MASTER;
}
