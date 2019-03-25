package com.jikuodong.plms.his;

import com.jikuodong.plms.po.User;
import com.jikuodong.plms.service.user.UserService;
import com.jikuodong.plms.utils.DateUtil;
import com.jikuodong.plms.utils.PropertiesConfigUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Date;
import java.util.List;
import java.util.concurrent.BlockingQueue;


/**
 * @author JKD
 * @version 1.0.0
 * @ClassName DockingReader.java
 * @createTime 2019年03月22日 15:43:00
 */
public class DockingReader implements Runnable {
    private static final Logger LOG = LogManager.getLogger(DockingReader.class);
    // 配置文件中的参数

    private static final String SYNC_LAST = "sync.lasttime";
    private static final String SYNC_INTERVAL = "sync.interval";
    private PropertiesConfigUtil propUtil;

    // 并发队列
    private BlockingQueue<User> queue;
    private UserService userService;

    public DockingReader(BlockingQueue<User> queue, UserService userService) throws Exception {
        this.queue = queue;
        this.userService = userService;
        this.propUtil = new PropertiesConfigUtil("C:\\his1\\his-docking.properties");
    }

    /**
     * 查询从库的值，添加到队列
     * @method run
     * @author JKD
     * @return void
     * @data 2019/3/22 15:58
     */
    @Override
    public void run() {
        // 读取需要同步的列表
        try {
            readerList();
        } catch (InterruptedException e) {
            LOG.error("======================数据同步：Reader 线程中断-{}", e.getMessage());
            // 停止该线程
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  读取需要同步的列表，添加到同步队列
     *
     * @author JKD
     * @data 2019/3/22 16:01
     */

    private void readerList() throws Exception {
        // 获取配置文件中上次同步的时间
        String startStr = propUtil.getProperty(SYNC_LAST);
        Date start = DateUtil.formatDate(startStr,"yyyy-MM-dd HH:mm:ss");
        // 获取当前时间
        Date end = new Date();
        // 获取用户信息列表，添加到同步对列中
        List<User> userList = userService.getUserList(start, end);
        if (!userList.isEmpty()) {
            LOG.info("========================数据同步提示：获取到{}条新记录", userList.size());
            for (User user : userList) {
                queue.put(user);
            }
        }
        // 更新同步结束时间到配置文件
        propUtil.setProperties(SYNC_LAST, DateUtil.dateToString(end,"yyyy-MM-dd HH:mm:ss"));
    }

    /**
     * 获取间隔时间
     * @method getInterval
     * @author JKD
     * @return int
     * @data 2019/3/22 16:18
     */
    public int getInterval() {
        return propUtil.getIntProperty(SYNC_INTERVAL);
    }

}
