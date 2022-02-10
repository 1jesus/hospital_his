package com.zhiyou.model;

import java.util.Date;

/**
 * @Classname Aoplog
 * @Date 2021/12/17 22:15
 */
public class Aoplog {
    private Integer id;
    private String ip;
    private String user;
    private String desc;
    private String methodname;
    private Date date;

    @Override
    public String toString() {
        return "Aoplog{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", user='" + user + '\'' +
                ", desc='" + desc + '\'' +
                ", methodname='" + methodname + '\'' +
                ", date=" + date +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getMethodname() {
        return methodname;
    }

    public void setMethodname(String methodname) {
        this.methodname = methodname;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
