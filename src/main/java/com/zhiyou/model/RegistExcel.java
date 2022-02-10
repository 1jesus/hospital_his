package com.zhiyou.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ContentRowHeight(24)
@HeadRowHeight(30)
@ColumnWidth(25)
public class RegistExcel {

    @ExcelProperty("病历号")
    private Integer medicalRecord;
    @ExcelProperty("患者姓名")
    private String name;
    // 性别,直接是汉字男/女
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty("证件号码")
    private String idNum;
    //certificate_type  一对一身份证类型
    @ExcelProperty("证件类型")
    private String cardtypename;
    @ExcelProperty("社保号")
    private String socialSafeNum;
    //一对一 医生姓名
    @ExcelProperty("医生姓名")
    private String doctorname;
    //一对一 科室名称
    @ExcelProperty("科室")
    private String sectionname;
    @ExcelProperty("手机号")
    private String phone;
    // 是否自费,显示是/否
    @ExcelProperty("是否自费")
    private String selfPaying;
    @ExcelProperty("职业")
    private String career;
    // 初复诊,显示初/复诊
    @ExcelProperty("初复诊")
    private String earlyAppointment;
    @ExcelProperty("状态")
    private String status;
    @ExcelProperty("备注")
    private String noted;
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty("挂号时间")
    private Date time;
    @ExcelProperty("挂号费")
    private Double registrationFee;
}
/*
-- POI技术实现Excel的导入导出
public class RegistExcel {

    private Integer medicalRecord;
    private String name;
    private String sex;
    private Integer age;
    private String idNum;
    //certificate_type  一对一身份证类型
    private String cardtypename;
    private String socialSafeNum;
    //一对一 医生姓名
    private String doctorname;
    //一对一 科室名称
    private String sectionname;
    private String phone;
    private String selfPaying;
    private String career;
    private String earlyAppointment;
    private String status;
    private String noted;
    private Date time;
    private Double registrationFee;

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
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdNum() {
        return idNum;
    }

    public void setIdNum(String idNum) {
        this.idNum = idNum;
    }

    public String getCardtypename() {
        return cardtypename;
    }

    public void setCardtypename(String cardtypename) {
        this.cardtypename = cardtypename;
    }

    public String getSocialSafeNum() {
        return socialSafeNum;
    }

    public void setSocialSafeNum(String socialSafeNum) {
        this.socialSafeNum = socialSafeNum;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getSectionname() {
        return sectionname;
    }

    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSelfPaying() {
        return selfPaying;
    }

    public void setSelfPaying(String selfPaying) {
        this.selfPaying = selfPaying;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getEarlyAppointment() {
        return earlyAppointment;
    }

    public void setEarlyAppointment(String earlyAppointment) {
        this.earlyAppointment = earlyAppointment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNoted() {
        return noted;
    }

    public void setNoted(String noted) {
        this.noted = noted;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getRegistrationFee() {
        return registrationFee;
    }

    public void setRegistrationFee(Double registrationFee) {
        this.registrationFee = registrationFee;
    }


    @Override
    public String toString() {
        return "RegistExcel{" +
                "medicalRecord=" + medicalRecord +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", idNum='" + idNum + '\'' +
                ", cardtypename='" + cardtypename + '\'' +
                ", socialSafeNum='" + socialSafeNum + '\'' +
                ", doctorname='" + doctorname + '\'' +
                ", sectionname='" + sectionname + '\'' +
                ", phone='" + phone + '\'' +
                ", selfPaying='" + selfPaying + '\'' +
                ", career='" + career + '\'' +
                ", earlyAppointment='" + earlyAppointment + '\'' +
                ", status='" + status + '\'' +
                ", noted='" + noted + '\'' +
                ", time=" + time +
                ", registrationFee=" + registrationFee +
                '}';
    }
}
*/