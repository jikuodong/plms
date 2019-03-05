package com.jikuodong.plms.interceptor.shiro.config;

import com.jikuodong.plms.interceptor.shiro.cache.RedisCacheManager;
import com.jikuodong.plms.interceptor.shiro.filter.StateLessFilter;
import com.jikuodong.plms.interceptor.shiro.realm.RealmCustom;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.DefaultSubjectFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
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
        // 设置拦截器，顺序判断
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 开放URL
        filterChainDefinitionMap.put("/login", "anon");
        // 未授权需要登录后，才可以访问到
        filterChainDefinitionMap.put("/noAuthorize", "authc");
        // 授权后面添加
        filterChainDefinitionMap.put("/**", "token,authc");
        filterFactory.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return filterFactory;
    }

    /**
     * shiro安全管理器
     * 主要是身份认证的管理，缓存管理，cookie管理
     * @return
     */
    @Bean
    public SecurityManager securityManager() {
        // 创建安全管理器
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 注入无状态SubjectFactory
         securityManager.setSubjectFactory(subjectFactory());
        // 注入session管理器
         securityManager.setSessionManager(sessionManager());
        // 注入缓存管理器
         securityManager.setCacheManager(redisCacheManager());
        // 禁止使用Sessions作为存储策略实现
        ((DefaultSessionStorageEvaluator)((DefaultSubjectDAO)securityManager.getSubjectDAO()).getSessionStorageEvaluator()).setSessionStorageEnabled(false);
        // 注入自定义Realm
        securityManager.setRealm(customRealm());
        return securityManager;
    }

    /**
     * 关闭了session创建的SubjectFactory
     */
    @Bean
    public DefaultSubjectFactory subjectFactory() {
        return new StateLessDefaultSubjectFactory();
    }

    /**
     * session管理器
     *
     *      因为禁用了Session会话，所以无需调度会话，禁用掉即可
     */
    @Bean
    public DefaultSessionManager sessionManager() {
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(false);
        return sessionManager;
    }

    /**
     *
     * describe 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
     * @author xmc
     * @date 2018/10/22 16:36
     * @param  * @param securityManager
     * @return org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

    /**
     * 自定义认证realm
     * @return
     */
    @Bean
    public RealmCustom customRealm() {
        return new RealmCustom();
    }

    /**
     * 自定义Redis缓存管理器
     *
     */
    @Bean
    public RedisCacheManager redisCacheManager() {
        return new RedisCacheManager();
    }
}
