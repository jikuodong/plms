package com.jikuodong.plms.his;

import com.jikuodong.plms.po.User;
import com.jikuodong.plms.service.user.UserService;
import com.jikuodong.plms.system.ThreadPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.*;

/**
 * 执行任务
 * @author JKD
 * @version 1.0.0
 * @ClassName HisTask.java
 * @createTime 2019年03月22日 10:43:00
 */

@Component
public class HisTask {

    private static final Logger LOG = LogManager.getLogger(HisTask.class);

    private final BlockingQueue<User> queue = new LinkedBlockingDeque<>();

    @Autowired
    private UserService userService;

    @PostConstruct
    public void docking() throws Exception {
        LOG.info("=================执行任务====================");
        // 获取定时任务线程池
        ScheduledExecutorService scheduledExec = ThreadPool.getScheduledThreadExecutor();
        // 读取任务，定时任务
        DockingReader reader = new DockingReader(queue, userService);
        // 定时执行 reader 任务，第一次延迟10秒执行，后面每隔一段时间执行
        scheduledExec.scheduleWithFixedDelay(reader, 10, reader.getInterval(), TimeUnit.SECONDS);
        // 写入任务，阻塞队列执行
        // 获取可缓存线程池
        ExecutorService exec = ThreadPool.getExecutorService();
        // 写任务
        DockingWriter writer = new DockingWriter(queue,userService);
        exec.execute(writer);
    }
}
