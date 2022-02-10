package com.zhiyou.model;

public class Section {
    private Integer id;

    private String seccpNum;

    private String seccoName;

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", seccpNum='" + seccpNum + '\'' +
                ", seccoName='" + seccoName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSeccpNum() {
        return seccpNum;
    }

    public void setSeccpNum(String seccpNum) {
        this.seccpNum = seccpNum == null ? null : seccpNum.trim();
    }

    public String getSeccoName() {
        return seccoName;
    }

    public void setSeccoName(String seccoName) {
        this.seccoName = seccoName == null ? null : seccoName.trim();
    }
}