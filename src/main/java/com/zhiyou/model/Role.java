package com.zhiyou.model;

public class Role {
    private Integer id;

    private String roleNum;

    private String roleName;

    private Integer status;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleNum='" + roleNum + '\'' +
                ", roleName='" + roleName + '\'' +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleNum() {
        return roleNum;
    }

    public void setRoleNum(String roleNum) {
        this.roleNum = roleNum == null ? null : roleNum.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}