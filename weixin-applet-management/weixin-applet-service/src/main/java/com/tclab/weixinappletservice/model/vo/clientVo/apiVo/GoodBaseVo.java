package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;

public class GoodBaseVo {

    private Integer id;

    private String orderNo;

    private String goodNo;

    private String packageId;

    private String packageLogo;

    private String packageName;

    private Integer packageNum;

    private String acquisitionId;

    private String acquisitionName;

//    private Date goodApplyDate;

    private String goodApplyDate;

    private String goodApplyDateForAPMStr;

//    private Date goodCurrentApplyDate;

    private String goodCurrentApplyDate;

    private BigDecimal payAmount;

    private BigDecimal discountAmount;

    private BigDecimal totalAmount;

    private Integer goodStatus;

    private Integer reportType;

    private BigDecimal reportCost;

    private String packageSourceId;

    private String reportTimeDesc;

    private String specialRequirement;

    public String getReportTimeDesc() {
        return reportTimeDesc;
    }

    public void setReportTimeDesc(String reportTimeDesc) {
        this.reportTimeDesc = reportTimeDesc;
    }

    public String getPackageSourceId() {
        return packageSourceId;
    }

    public void setPackageSourceId(String packageSourceId) {
        this.packageSourceId = packageSourceId;
    }

    public String getPackageLogo() {
        return packageLogo;
    }

    public void setPackageLogo(String packageLogo) {
        this.packageLogo = packageLogo;
    }

    public String getGoodApplyDateForAPMStr() {
        return goodApplyDateForAPMStr;
    }

    public void setGoodApplyDateForAPMStr(String goodApplyDateForAPMStr) {
        this.goodApplyDateForAPMStr = goodApplyDateForAPMStr;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
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

    public String getGoodCurrentApplyDate() {
        return goodCurrentApplyDate;
    }

    public void setGoodCurrentApplyDate(String goodCurrentApplyDate) {
        this.goodCurrentApplyDate = goodCurrentApplyDate;
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

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getSpecialRequirement() {
        return specialRequirement;
    }

    public void setSpecialRequirement(String specialRequirement) {
        this.specialRequirement = specialRequirement;
    }
}
