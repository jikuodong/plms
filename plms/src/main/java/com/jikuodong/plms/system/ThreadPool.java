package com.jikuodong.plms.system;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @author JKD
 * @version 1.0.0
 * @ClassName ThreadPool.java
 * @createTime 2019年03月22日 15:12:00
 */
public class ThreadPool {
    private ThreadPool() {}

    // 可缓存的线程池
    private static ExecutorService executorService = Executors.newCachedThreadPool();

    // 定时任务线程池 指定线程池中的线程数。若线程数小于需要线程数，则需要等待前面线程执行完成后再执行
    private static ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(5);

    // 获取线程池ThreadPoolExecutor
    public static ExecutorService getExecutorService() {
        return executorService;
    }

    // 获取定时任务线程池
    public static ScheduledExecutorService getScheduledThreadExecutor() {
        return scheduledExecutor;
    }

}
