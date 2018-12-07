package com.jikuodong.plms.po;

import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class User {
    private String userid;

    private String username;

    private String password;

    private String phone;

    private Boolean isSingleOn;

    private Integer failureTimes;

    private Integer status;

    private Date lastLoginOn;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Boolean getIsSingleOn() {
        return isSingleOn;
    }

    public void setIsSingleOn(Boolean isSingleOn) {
        this.isSingleOn = isSingleOn;
    }

    public Integer getFailureTimes() {
        return failureTimes;
    }

    public void setFailureTimes(Integer failureTimes) {
        this.failureTimes = failureTimes;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLastLoginOn() {
        return lastLoginOn;
    }

    public void setLastLoginOn(Date lastLoginOn) {
        this.lastLoginOn = lastLoginOn;
    }
}