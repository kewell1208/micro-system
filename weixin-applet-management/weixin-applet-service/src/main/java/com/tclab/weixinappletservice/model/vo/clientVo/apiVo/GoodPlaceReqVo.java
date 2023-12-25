package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;

public class GoodPlaceReqVo {

    private String packageId;

    private String packageName;

    private Integer packageNum = 1;

    private String acquisitionId;

    private String acquisitionName;

    private String goodApplyDate;

    private BigDecimal payAmount;

    private BigDecimal discountAmount;

    private BigDecimal totalAmount;

    private Integer reportType;

    private BigDecimal reportCost;

    private String doctorName;

    private String doctorPhone;

    private String imRecommendListId;

    @Override
    public String toString() {
        return "GoodPlaceReqVo{" +
                "packageId='" + packageId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageNum=" + packageNum +
                ", acquisitionId='" + acquisitionId + '\'' +
                ", acquisitionName='" + acquisitionName + '\'' +
                ", goodApplyDate='" + goodApplyDate + '\'' +
                ", payAmount=" + payAmount +
                ", discountAmount=" + discountAmount +
                ", totalAmount=" + totalAmount +
                ", reportType=" + reportType +
                ", reportCost=" + reportCost +
                ", doctorName='" + doctorName + '\'' +
                ", doctorPhone='" + doctorPhone + '\'' +
                ", imRecommendListId='" + imRecommendListId + '\'' +
                '}';
    }

    public String getImRecommendListId() {
        return imRecommendListId;
    }

    public void setImRecommendListId(String imRecommendListId) {
        this.imRecommendListId = imRecommendListId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getPackageNum() {
        return packageNum;
    }

    public void setPackageNum(Integer packageNum) {
        this.packageNum = packageNum;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getAcquisitionName() {
        return acquisitionName;
    }

    public void setAcquisitionName(String acquisitionName) {
        this.acquisitionName = acquisitionName;
    }

    public String getGoodApplyDate() {
        return goodApplyDate;
    }

    public void setGoodApplyDate(String goodApplyDate) {
        this.goodApplyDate = goodApplyDate;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getReportType() {
        return reportType;
    }

    public void setReportType(Integer reportType) {
        this.reportType = reportType;
    }

    public BigDecimal getReportCost() {
        return reportCost;
    }

    public void setReportCost(BigDecimal reportCost) {
        this.reportCost = reportCost;
    }
}
