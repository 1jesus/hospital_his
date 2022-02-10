package com.zhiyou.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Drug {
    private String drugNum;

    private String drugUrl;

    private Double purchasPrice;

    private Double salePrice;

    private String drugName;

    private Integer drugType;

    private String simpleDetail;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date prodecedDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expirationDate;

    private String qualityDate;

    private String detail;

    private String manufacture;

    private String useInfor;

    private Integer totalStock;

    private Integer surplus;

    private Integer status;

    private String noted;

    @Override
    public String toString() {
        return "Drug{" +
                "drugNum='" + drugNum + '\'' +
                ", drugUrl='" + drugUrl + '\'' +
                ", purchasPrice=" + purchasPrice +
                ", salePrice=" + salePrice +
                ", drugName='" + drugName + '\'' +
                ", drugType=" + drugType +
                ", simpleDetail='" + simpleDetail + '\'' +
                ", prodecedDate=" + prodecedDate +
                ", expirationDate=" + expirationDate +
                ", qualityDate='" + qualityDate + '\'' +
                ", detail='" + detail + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", useInfor='" + useInfor + '\'' +
                ", totalStock=" + totalStock +
                ", surplus=" + surplus +
                ", status=" + status +
                ", noted='" + noted + '\'' +
                '}';
    }

    public String getDrugNum() {
        return drugNum;
    }

    public void setDrugNum(String drugNum) {
        this.drugNum = drugNum == null ? null : drugNum.trim();
    }

    public String getDrugUrl() {
        return drugUrl;
    }

    public void setDrugUrl(String drugUrl) {
        this.drugUrl = drugUrl == null ? null : drugUrl.trim();
    }

    public Double getPurchasPrice() {
        return purchasPrice;
    }

    public void setPurchasPrice(Double purchasPrice) {
        this.purchasPrice = purchasPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName == null ? null : drugName.trim();
    }

    public Integer getDrugType() {
        return drugType;
    }

    public void setDrugType(Integer drugType) {
        this.drugType = drugType;
    }

    public String getSimpleDetail() {
        return simpleDetail;
    }

    public void setSimpleDetail(String simpleDetail) {
        this.simpleDetail = simpleDetail == null ? null : simpleDetail.trim();
    }

    public Date getProdecedDate() {
        return prodecedDate;
    }

    public void setProdecedDate(Date prodecedDate) {
        this.prodecedDate = prodecedDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getQualityDate() {
        return qualityDate;
    }

    public void setQualityDate(String qualityDate) {
        this.qualityDate = qualityDate == null ? null : qualityDate.trim();
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture == null ? null : manufacture.trim();
    }

    public String getUseInfor() {
        return useInfor;
    }

    public void setUseInfor(String useInfor) {
        this.useInfor = useInfor == null ? null : useInfor.trim();
    }

    public Integer getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(Integer totalStock) {
        this.totalStock = totalStock;
    }

    public Integer getSurplus() {
        return surplus;
    }

    public void setSurplus(Integer surplus) {
        this.surplus = surplus;
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
}