package com.jikuodong.plms.datasource;

/**
 * 为了解决多线程访问全局变量的问题（当前线程数据源持有对象）
 * 对数据源进行操作
 * @author JKD
 * @version 1.0.0
 * @ClassName DynamicDataSourceContextHolder.java
 * @createTime 2019年03月21日 11:19:00
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<DataSourceKey> currentDataSource = new ThreadLocal<>();

    /**
     *  设置当前数据源
     * @method currentDataSource
     * @author JKD
     * @param dataSource 数据源
     * @return void
     * @data 2019/3/21 11:24
     */
    public static void setDataSource(DataSourceKey dataSource) {
        currentDataSource.set(dataSource);
    }

    /**
     *  获取当前数据源
     * @method getDataSource
     * @author JKD
     * @return com.jikuodong.plms.datasource.DataSourceKey
     * @data 2019/3/21 11:25
     */
    public static DataSourceKey getDataSource() {
        return currentDataSource.get();
    }

    /**
     * 清除当前数据源
     * @method clear
     * @author JKD
     * @return void
     * @data 2019/3/21 11:27
     */
    public static  void clear() {
        currentDataSource.remove();
    }
}
