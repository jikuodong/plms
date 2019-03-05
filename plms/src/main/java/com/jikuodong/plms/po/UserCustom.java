package com.jikuodong.plms.po;

/**
 * user扩展类
 */
public class UserCustom extends User {

    private String reference; // 推荐人姓名
    private String statusName; // 状态名称
    private String roles; // 角色
    private String roleNames; // 角色名称

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(String roleNames) {
        this.roleNames = roleNames;
    }
}
