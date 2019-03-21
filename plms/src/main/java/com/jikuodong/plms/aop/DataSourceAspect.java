package com.jikuodong.plms.aop;

import com.jikuodong.plms.annotation.TargetDB;
import com.jikuodong.plms.datasource.DataSourceKey;
import com.jikuodong.plms.datasource.DynamicDataSourceContextHolder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 数据源切面AOP
 * @author JKD
 * @version 1.0.0
 * @ClassName DataSourceAspect.java
 * @createTime 2019年03月21日 11:00:00
 */
@Aspect
@Order(0)
@Component
public class DataSourceAspect {
    private static final Logger LOG = LogManager.getLogger(DataSourceAspect.class);

    /**
     *  方法之前，设置当前数据源
     * @method doBefore
     * @author JKD
     * @return void
     * @data 2019/3/21 11:10
     */
    @Before("@annotation(targetDB)")
    public void doBefore(JoinPoint joinPoint, TargetDB targetDB) {
        DataSourceKey key = targetDB.value();
        LOG.info("设置数据源为：{}", key);
        DynamicDataSourceContextHolder.setDataSource(key);
    }

    /**
     * 方法执行完毕后，清除设置的数据源，让默认的数据源不受影响
     * @method doAfter
     * @author JKD
     * @return void
     * @data 2019/3/21 11:30
     */
    @After("@annotation(targetDB)")
    public void doAfter(JoinPoint joinPoint, TargetDB targetDB) {
        DataSourceKey key = targetDB.value();
        LOG.info("清理当前数据源：{}", key);
        DynamicDataSourceContextHolder.clear();
    }
}
