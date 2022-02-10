package com.zhiyou.model;

import java.util.Date;

public class Log {
    private Integer id;

    private String opeIp;

    private String opeName;

    private String opeMethod;

    private String opeDesc;

    private Date opeDate;

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", opeIp='" + opeIp + '\'' +
                ", opeName='" + opeName + '\'' +
                ", opeMethod='" + opeMethod + '\'' +
                ", opeDesc='" + opeDesc + '\'' +
                ", opeDate=" + opeDate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOpeIp() {
        return opeIp;
    }

    public void setOpeIp(String opeIp) {
        this.opeIp = opeIp == null ? null : opeIp.trim();
    }

    public String getOpeName() {
        return opeName;
    }

    public void setOpeName(String opeName) {
        this.opeName = opeName == null ? null : opeName.trim();
    }

    public String getOpeMethod() {
        return opeMethod;
    }

    public void setOpeMethod(String opeMethod) {
        this.opeMethod = opeMethod == null ? null : opeMethod.trim();
    }

    public String getOpeDesc() {
        return opeDesc;
    }

    public void setOpeDesc(String opeDesc) {
        this.opeDesc = opeDesc == null ? null : opeDesc.trim();
    }

    public Date getOpeDate() {
        return opeDate;
    }

    public void setOpeDate(Date opeDate) {
        this.opeDate = opeDate;
    }
}