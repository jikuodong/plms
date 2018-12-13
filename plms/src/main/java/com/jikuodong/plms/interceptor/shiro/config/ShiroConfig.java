package com.jikuodong.plms.interceptor.shiro.config;

import com.jikuodong.plms.interceptor.shiro.filter.StateLessFilter;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置类
 * @author JKD
 * @version 1.0.0
 * @ClassName ShiroConfig.java
 * @createTime 2018年12月12日 17:23:00
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        // 获取工厂bean
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
        // 注入安全管理器
        filterFactory.setSecurityManager(securityManager);
        // 注入过滤器链
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("token", new StateLessFilter());
        filterFactory.setFilters(filterMap);
        // 设置未登录URL
        filterFactory.setLoginUrl("/noLogin");
        // 设置无权访问的URL
        filterFactory.setUnauthorizedUrl("/noAuthorize");
        // 设置拦截器，顺序判断
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 授权后面添加
        filterChainDefinitionMap.put("/**", "token,authc");
        filterFactory.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return filterFactory;
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        return securityManager;
    }
}
