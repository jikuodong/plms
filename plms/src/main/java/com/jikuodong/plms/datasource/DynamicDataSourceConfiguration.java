package com.jikuodong.plms.datasource;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * 多数据源配置
 * @author JKD
 * @version 1.0.0
 * @ClassName DynamicDataSourceConfiguration.java
 * @createTime 2019年03月21日 11:36:00
 */
@Configuration
public class DynamicDataSourceConfiguration {

    @Value("${mybatis-plus.mapper-locations}")
    private String mapperLocation;

    @Value("${mybatis-plus.type-aliases-package}")
    private String typeAliases;

    @Value("${mybatis-plus.config-location}")
    private String configLocation;

    /**
     * Master 库配置，有配置文件读取
     * @method dbMaster
     * @author JKD
     * @return javax.sql.DataSource
     * @data 2019/3/21 11:42
     */
    @Bean
    @ConfigurationProperties(prefix = "multiple.datasource.druid.master")
    public DataSource dbMaster() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     * Slave 库配置， 由配置文件读取
     * @method dbSlave
     * @author JKD
     * @return javax.sql.DataSource
     * @data 2019/3/21 11:44
     */
    @Bean
    @ConfigurationProperties(prefix = "multiple.datasource.druid.slave")
    public DataSource dbSlave() {
        return DruidDataSourceBuilder.create().build();
    }

    /**
     *  配置后的核心动态数据源
     * @method dynamicDataSource
     * @author JKD
     * @return javax.sql.DataSource
     * @data 2019/3/21 11:53
     */
    @Bean
    public DataSource dynamicDataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        // 设置默认数据源
        dataSource.setDefaultTargetDataSource(dbMaster());
        // 设置其他数据源
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceKey.DB_MASTER, dbMaster());
        targetDataSources.put(DataSourceKey.DB_SLAVE, dbSlave());
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }

    /**
     *  SqlSessionFactory 注入数据源
     * @method SqlSessionFactory
     * @author JKD
     * @return org.apache.ibatis.session.SqlSessionFactory
     * @data 2019/3/21 12:00
     */
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dynamicDataSource());
        // 设置mapper路径资源
        factory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocation));
        // 设置别名路径
        factory.setTypeAliasesPackage(typeAliases);
        // 设置配置文件路径资源
        factory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(configLocation));
        return factory.getObject();
    }

    /**
     * SqlSessionTemplate 配置
     * @author JKD
     * @data 2019/3/21 12:02
     */
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory());
    }

    /**
     *  配置动态数据源事务管理器
     * @method transactionManager
     * @author JKD
     * @return org.springframework.jdbc.datasource.DataSourceTransactionManager
     * @data 2019/3/21 13:07
     */
    @Bean
    public DataSourceTransactionManager transactionManager() {
        return new DataSourceTransactionManager(dynamicDataSource());
    }

    public void setMapperLocation(String mapperLocation) {
        this.mapperLocation = mapperLocation;
    }

    public void setConfigLocation(String configLocation) {
        this.configLocation = configLocation;
    }
}
