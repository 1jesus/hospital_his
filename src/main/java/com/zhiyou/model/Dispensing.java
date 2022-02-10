package com.zhiyou.model;

import java.util.Date;

public class Dispensing {
    private String medicalRecord;

    private String drugId;

    private Integer dispensNum;

    private Integer alreadSendNum;

    private Integer notSendNum;

    private Date time;

    @Override
    public String toString() {
        return "Dispensing{" +
                "medicalRecord='" + medicalRecord + '\'' +
                ", drugId='" + drugId + '\'' +
                ", dispensNum=" + dispensNum +
                ", alreadSendNum=" + alreadSendNum +
                ", notSendNum=" + notSendNum +
                ", time=" + time +
                '}';
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId == null ? null : drugId.trim();
    }

    public Integer getDispensNum() {
        return dispensNum;
    }

    public void setDispensNum(Integer dispensNum) {
        this.dispensNum = dispensNum;
    }

    public Integer getAlreadSendNum() {
        return alreadSendNum;
    }

    public void setAlreadSendNum(Integer alreadSendNum) {
        this.alreadSendNum = alreadSendNum;
    }

    public Integer getNotSendNum() {
        return notSendNum;
    }

    public void setNotSendNum(Integer notSendNum) {
        this.notSendNum = notSendNum;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}