package com.jikuodong.plms.interceptor.shiro.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 无状态过滤器 (AccessControlFilter访问控制过滤器)
 * @author JKD
 * @version 1.0.0
 * @ClassName StateLessFilter.java
 * @createTime 2018年12月12日 16:56:00
 */
public class StateLessFilter extends AccessControlFilter {

    // 定义logger
    private final Logger logger = LogManager.getLogger(StateLessFilter.class);

    /**
     * 表示是否允许访问；mappedValue就是[urls]配置中拦截器参数部分，如果允许访问返回true，否则false；
     * (感觉这里应该是对白名单（不需要登录的接口）放行的)
     * 如果isAccessAllowed返回true则onAccessDenied方法不会继续执行
     * 这里可以用来判断一些不被通过的链接（个人备注）
     * * 表示是否允许访问 ，如果允许访问返回true，否则false；
     * @param servletRequest
     * @param servletResponse
     * @param object 表示写在拦截器中括号里面的字符串 mappedValue 就是 [urls] 配置中拦截器参数部分
     * @return
     * @throws Exception
     * */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        // Subject subject = getSubject(servletRequest,servletResponse);
        // String url = getPathWithinApplication(servletRequest);
        // logger.info("当前用户正在访问的 url => " + url);
        // logger.info("subject.isPermitted(url);"+subject.isPermitted(url));
        return false;
    }
    /**
     * 表示当访问拒绝时是否已经处理了；如果返回true表示需要继续处理；如果返回false表示该拦截器实例已经处理了，将直接返回即可。
     * onAccessDenied是否执行取决于isAccessAllowed的值 ，如果返回true则onAccessDenied不会执行；如果返回false，执行onAccessDenied
     * 如果onAccessDenied也返回false，则直接返回，不会进入请求的方法（只有isAccessAllowed和onAccessDenied的情况下）
     * @method onAccessDenied
     * @author JKD
     * @param [servletRequest, servletResponse]
     * @return boolean
     * @data 2018/12/12 17:07
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        // HttpServletRequest 继承自ServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // HttpServletResponse 继承自ServletResponse
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // token验证
        return tokenValidator(request, response);
    }

    /**
     * 验证是否存在token
     * @method tokenValidator
     * @author JKD
     * @param [request, response]
     * @return java.lang.Boolean
     * @data 2018/12/12 17:58
     */
    private Boolean tokenValidator(HttpServletRequest request, HttpServletResponse response){
        logger.info("拦截到url:" +request.getRequestURL().toString());
        return true;
    }
}
