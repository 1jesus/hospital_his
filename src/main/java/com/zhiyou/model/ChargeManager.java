package com.zhiyou.model;

import java.util.Date;

public class ChargeManager {
    private Integer id;

    private String medicalRecord;

    private Integer payItemsId;

    private Double chargeMoney;

    private Date chargeTime;

    @Override
    public String toString() {
        return "ChargeManager{" +
                "id=" + id +
                ", medicalRecord='" + medicalRecord + '\'' +
                ", payItemsId=" + payItemsId +
                ", chargeMoney=" + chargeMoney +
                ", chargeTime=" + chargeTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public Integer getPayItemsId() {
        return payItemsId;
    }

    public void setPayItemsId(Integer payItemsId) {
        this.payItemsId = payItemsId;
    }

    public Double getChargeMoney() {
        return chargeMoney;
    }

    public void setChargeMoney(Double chargeMoney) {
        this.chargeMoney = chargeMoney;
    }

    public Date getChargeTime() {
        return chargeTime;
    }

    public void setChargeTime(Date chargeTime) {
        this.chargeTime = chargeTime;
    }
}