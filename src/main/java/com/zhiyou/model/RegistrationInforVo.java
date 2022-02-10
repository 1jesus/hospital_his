package com.zhiyou.model;

/**
 * @Classname RegistrationInforVo
 * @Date 2021/12/20 17:26
 */
public class RegistrationInforVo extends RegistrationInfor {

    //在患者信息的基础上,加上要关联的其他信息(关联信息比较少的请情况)
    //MyBatis不用使用ResultMap进行多表封装了
    private String doctorName;
    private String sectionName;
    private Integer bedId;     //床位号
    private Double payTheDeposit; //缴费押金
    private String caregiver; //护理
    private String stateIllness; //病情

    @Override
    public String toString() {
        return "RegistrationInforVo{" +
                "doctorName='" + doctorName + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", bedId=" + bedId +
                ", payTheDeposit=" + payTheDeposit +
                ", caregiver='" + caregiver + '\'' +
                ", stateIllness='" + stateIllness + '\'' +
                "} " + super.toString();
    }

    public String getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(String caregiver) {
        this.caregiver = caregiver;
    }

    public String getStateIllness() {
        return stateIllness;
    }

    public void setStateIllness(String stateIllness) {
        this.stateIllness = stateIllness;
    }

    public Double getPayTheDeposit() {
        return payTheDeposit;
    }

    public void setPayTheDeposit(Double payTheDeposit) {
        this.payTheDeposit = payTheDeposit;
    }

    public Integer getBedId() {
        return bedId;
    }

    public void setBedId(Integer bedId) {
        this.bedId = bedId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }
}
