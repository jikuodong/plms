package com.jikuodong.plms.base;

import com.jikuodong.plms.po.User;
import com.jikuodong.plms.utils.CommonUtils;
import com.jikuodong.plms.utils.PageData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BaseController {
    /** 日志 */
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);

    /** 通信请求 */
    protected HttpServletRequest request;

    /** 通信回复 */
    protected HttpServletResponse response;

    /**
     * 获取完成URL
     *
     * @return
     */
    protected String getFullUrl() {
        String fullUrl = CommonUtils.concat("http://", this.request.getServerName(), ":", this.request.getServerPort(),
                this.request.getContextPath(), this.request.getServletPath());
        String queryString = this.request.getQueryString();
        if (CommonUtils.isNotBlank(queryString))
        {
            fullUrl = CommonUtils.concat(fullUrl, "?", queryString);
        }
        return fullUrl;
    }

    /******************************** Session、cookie处理 start ********************************/
    /**
     * 设置SESSION
     *
     * @param key
     *            key值
     * @param value
     *            key对应的value值
     */
    protected void setSession(String key, Object value) {
        HttpSession session = this.request.getSession();
        session.setAttribute(key, value);
    }

    /**
     * 获取SESSION
     *
     * @param key
     *            key值
     * @return String值
     */
    protected String getSessionStr(String key) {
        return CommonUtils.toString(getSession(key));
    }

    /**
     * 获取SESSION
     *
     * @param key
     *            key值
     * @return session值
     */
    protected int getSessionInt(String key) {
        return CommonUtils.toInt(getSession(key));
    }

    /**
     * 获取SESSION
     *
     * @param key
     *            key值
     * @return long值
     */
    protected long getSessionLong(String key) {
        return CommonUtils.toLong(getSession(key));
    }

    /**
     * 获取SESSION
     *
     * @param key
     *            key值
     * @return session值
     */
    protected Object getSession(String key) {
        HttpSession session = this.request.getSession();
        return session.getAttribute(key);
    }

    /**
     * 删除SESSION
     *
     * @param key
     */
    protected void delSession(String key) {
        HttpSession session = this.request.getSession();
        session.removeAttribute(key);
    }

    /**
     * 清空SESSION
     */
    protected void clearSession() {
        HttpSession session = this.request.getSession();
        session.invalidate();
    }

    /**
     * 对来自请求的客户端添加Cookie
     *
     * @param key
     *            key值
     * @param value
     *            Cookie内容
     * @param maxAge
     *            Cookie时间
     */
  /*  protected void setCookie(String key, String value, int maxAge)
    {
        WebUtil.setCookie(response, key, value, maxAge);
    }*/

    /**
     * 根据名字获取Cookie
     *
     * @param key
     *            key值
     * @return Cookie内容
     */
/*    protected String getCookie(String key)
    {
        return WebUtil.getCookie(request, key);
    }*/

    /******************************** Session、cookie处理 end ********************************/

    /**
     * 得到request对象
     */
    public HttpServletRequest getRequest() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }

    /**
     * 得到PageData
     */
    public PageData getPageData() {
        return new PageData(this.getRequest());
    }

    /**
     *  日志处理
     */
    public static void logBefore(Logger logger, String interfaceName) {
        logger.info("");
        logger.info("start");
        logger.info(interfaceName);
    }

    public static void logAfter(Logger logger) {
        logger.info("end");
        logger.info("");
    }
    /**
     * 从shiro中获取当前用户名，从redis中获取当前用户的实体类
     */
    public User getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        return (User) subject.getPrincipal();
    }

    public void ceshi(){
        System.out.println("测试一下1");
    }
}
