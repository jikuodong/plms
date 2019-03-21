package com.jikuodong.plms.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author JKD
 * @version 1.0.0
 * @ClassName DynamicDataSource.java
 * @createTime 2019年03月21日 11:33:00
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    /**
     *  决定使用哪儿数据库
     * @method determineCurrentLookupKey
     * @author JKD
     * @return java.lang.Object
     * @data 2019/3/21 15:09
     */
    @Override
    protected Object determineCurrentLookupKey() {
        // LOGGER.info("当前数据源：{}", DynamicDataSourceContextHolder.getDataSource() == null ? "默认" : DynamicDataSourceContextHolder.getDataSource());
        System.out.println( DynamicDataSourceContextHolder.getDataSource());
        return DynamicDataSourceContextHolder.getDataSource();
    }
}
