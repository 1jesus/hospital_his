package com.zhiyou.model;

/**
 * @Classname DoctorVo
 * @Date 2021/12/22 19:43
 */
public class DoctorVo extends Doctor {
    private String certificateName;
    private String sectionName;
    private String educationName;

    @Override
    public String toString() {
        return "DoctorVo{" +
                "certificateName='" + certificateName + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", educationName='" + educationName + '\'' +
                "} " + super.toString();
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }
}
