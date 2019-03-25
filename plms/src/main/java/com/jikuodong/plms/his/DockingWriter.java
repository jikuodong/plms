package com.jikuodong.plms.his;

import com.jikuodong.plms.po.User;
import com.jikuodong.plms.service.user.UserService;
import com.jikuodong.plms.utils.PropertiesConfigUtil;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingQueue;

/**
 * 将数据插入到主库的任务类
 * @author JKD
 * @version 1.0.0
 * @ClassName DockingWriter.java
 * @createTime 2019年03月22日 16:22:00
 */
public class DockingWriter implements Runnable {
    private  static final Logger LOG = LogManager.getLogger(DockingWriter.class);
    // 获取配置文件工具类
    private PropertiesConfigUtil propUtil;
    // 待同步的阻塞队列
    private BlockingQueue<User> queue;
    private UserService userService;

    public DockingWriter(BlockingQueue<User> queue, UserService userService) throws ConfigurationException {
        this.queue = queue;
        this.userService = userService;
        this.propUtil = new PropertiesConfigUtil("C:\\his1\\his-docking.properties");
    }


    /**
     * 获取阻塞队列中的值，同步到主库
     * @method run
     * @author JKD
     * @return void
     * @data 2019/3/22 16:35
     */
    @Override
    public void run() {
        // 判断当前线程是否已经中断
        try {
            while (!Thread.interrupted()){
                // 写入信息到主库
                writeInfo();
            }
        } catch (InterruptedException e) {
            LOG.error("=====================数据同步：Writer 线程中断-{}", e.getMessage());
            Thread.currentThread().interrupt(); // 停止该线程
        }
    }

    /**
     * 写入信息到主库
     * @method writeInfo
     * @author JKD
     * @return void
     * @data 2019/3/22 16:50
     */
    private  void writeInfo() throws InterruptedException {
        // 如果没有会一直阻塞
        User user = queue.take();
        System.out.println("此处添加数据相关操作");
        LOG.info("=============== 数据同步：病理号[{}] -> 同步成功", user.getUserName());
    }
}
