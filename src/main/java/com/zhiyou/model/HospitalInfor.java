package com.zhiyou.model;

public class HospitalInfor {
    private String medicalRecord;

    private String caregiver;

    private Integer bedId;

    private Double payTheDeposit;

    private String stateIllness;

    @Override
    public String toString() {
        return "HospitalInfor{" +
                "medicalRecord='" + medicalRecord + '\'' +
                ", caregiver='" + caregiver + '\'' +
                ", bedId=" + bedId +
                ", payTheDeposit=" + payTheDeposit +
                ", stateIllness='" + stateIllness + '\'' +
                '}';
    }

    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord == null ? null : medicalRecord.trim();
    }

    public String getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(String caregiver) {
        this.caregiver = caregiver == null ? null : caregiver.trim();
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public Double getPayTheDeposit() {
        return payTheDeposit;
    }

    public void setPayTheDeposit(Double payTheDeposit) {
        this.payTheDeposit = payTheDeposit;
    }

    public String getStateIllness() {
        return stateIllness;
    }

    public void setStateIllness(String stateIllness) {
        this.stateIllness = stateIllness == null ? null : stateIllness.trim();
    }
}