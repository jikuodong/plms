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

    // 定时任务线程池
    private static ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(5);

    // 获取线程池
    public static ExecutorService getExecutorService() {
        return executorService;
    }

    // 获取定时任务线程池
    public static ScheduledExecutorService getScheduledThreadExecutor() {
        return scheduledExecutor;
    }

}
