package com.zhiyou.model;

public class Permission {
    private Integer id;

    private String resourceName;

    private String resourceUrl;

    private Integer superResourceId;

    private Integer status;

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", resourceName='" + resourceName + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", superResourceId=" + superResourceId +
                ", status=" + status +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName == null ? null : resourceName.trim();
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    public Integer getSuperResourceId() {
        return superResourceId;
    }

    public void setSuperResourceId(Integer superResourceId) {
        this.superResourceId = superResourceId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}