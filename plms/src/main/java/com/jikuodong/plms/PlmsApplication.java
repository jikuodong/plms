package com.jikuodong.plms;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class) // 关闭Druid数据源自动配置
@MapperScan("com.jikuodong.plms.mapper") // 将项目中对应的mapper类的路径加进来就可以了
public class PlmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlmsApplication.class, args);
    }
}
