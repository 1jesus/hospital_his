package com.zhiyou.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

public class RegistrationInfor {
    private Integer medicalRecord;

    @NotNull(message = "用户名不能为空")
    @Size(min = 2, max = 6, message = "用户名的长度错误,请填写2-6位")
    private String name;

    private Integer certificateType;

    private String idNum;

    private String socialSafeNum;

    private String phone;

    private Integer selfPaying;

    private Integer sex;

    private String career;

    private Integer earlyAppointment;

    private Integer doctorId;

    private Integer status;

    private String noted;

    private Date time;

    private Integer sectionId;

    private Integer age;

    private Double registrationFee;

    @Override
    public String toString() {
        return "RegistrationInfor{" +
                "medicalRecord=" + medicalRecord +
                ", name='" + name + '\'' +
                ", certificateType=" + certificateType +
                ", idNum='" + idNum + '\'' +
                ", socialSafeNum='" + socialSafeNum + '\'' +
                ", phone='" + phone + '\'' +
                ", selfPaying=" + selfPaying +
                ", sex=" + sex +
                ", career='" + career + '\'' +
                ", earlyAppointment=" + earlyAppointment +
                ", doctorId=" + doctorId +
                ", status=" + status +
                ", noted='" + noted + '\'' +
                ", time=" + time +
                ", sectionId=" + sectionId +
                ", age=" + age +
                ", registrationFee=" + registrationFee +
                '}';
    }

    public Integer getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(Integer medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum == null ? null : idNum.trim();
    }

    public String getSocialSafeNum() {
        return socialSafeNum;
    }

    public void setSocialSafeNum(String socialSafeNum) {
        this.socialSafeNum = socialSafeNum == null ? null : socialSafeNum.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Integer getSelfPaying() {
        return selfPaying;
    }

    public void setSelfPaying(Integer selfPaying) {
        this.selfPaying = selfPaying;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career == null ? null : career.trim();
    }

    public Integer getEarlyAppointment() {
        return earlyAppointment;
    }

    public void setEarlyAppointment(Integer earlyAppointment) {
        this.earlyAppointment = earlyAppointment;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getNoted() {
        return noted;
    }

    public void setNoted(String noted) {
        this.noted = noted == null ? null : noted.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }
}