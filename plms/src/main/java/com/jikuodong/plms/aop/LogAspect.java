package com.jikuodong.plms.aop;


import com.jikuodong.plms.annotation.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 以Log 注解为切入点， 记录日志信息
 * @author JKD
 * @version 1.0.0
 * @ClassName LogAspect.java
 * @createTime 2019年03月20日 11:49:00
 */
@Aspect
@Component
public class LogAspect {
    private static final Logger LOGGER = LogManager.getLogger(LogAspect.class);

    @Around(value = "@annotation(log))")
    public Object around(ProceedingJoinPoint pjp, Log log) throws Throwable {
        // 调用方法获取执行结果
        Object result = pjp.proceed();
        // 如果执行成功，则生成日志
        if ((boolean)result) {
            // 获取参数组
            Method method = ((MethodSignature)pjp.getSignature()).getMethod();
            LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();
            String[] parameterNames = discoverer.getParameterNames(method);
            if (parameterNames != null) {
                // 获取是参数组
                Object[] args = pjp.getArgs();
                // 解析出占位符代表的实际参数
                if ("".equals(log.value())) {
                    String value1 = (String) resolvePlaceholder(log.value1(), parameterNames, args);
                    // 将数据插入到数据库中的相关操作
                    addLog(value1);
                } else {
                    String value = (String) resolvePlaceholder(log.value(),parameterNames,args);
                    // 将数据插入到数据库中的相关操作
                    addLog(value);
                }
            }
        }
        return result;
    }

    /**
     *  添加日志信息
     * @method addLog
     * @author JKD
     * @param info
     * @return void
     * @data 2019/3/20 13:53
     * @throws
     */
    private void addLog(String info) {
        LOGGER.info("添加日志相关信息！", info);
        // 根据实际需要自行添加相关信息
        System.out.println("添加信息：" + info);
    }

    /**
     *  将实参根据形参位置映射解析到占位符上
     * @method resolvePlaceholder
     * @author JKD
     * @param placeholder 占位符
     * @param paramNames 形参名称
     * @param args  实参名称
     * @return java.lang.Object
     * @data 2019/3/20 13:49
     * @throws
     */
    private Object resolvePlaceholder(String placeholder, String[] paramNames, Object[] args) {
        Object result = null;
        for (int i = 0; i < paramNames.length; i++) {
            if (paramNames[i].equals(placeholder)) {
                result = args[i];
                break;
            }
        }
        return result;
    }

}
