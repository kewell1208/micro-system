package com.tclab.weixinappletservice.model.result;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GoodInfoByNoResult {

    private String orderNo;

    private String goodNo;

    private String packageId;

    private String packageName;

    private String packageEquipment;

    private String packageSpecialRequirement;

    private String packageRemark;

    private String barcode;

    private String storageCondition;

    private String packageSourceId;

    private String packageSourceName;

    private String reportTimeDesc;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy/MM/dd HH:mm")
    private Date reportDate;

    private String pdfurl;

    private String pdfmergeurl;

    public String getPdfurl() {
        return pdfurl;
    }

    public void setPdfurl(String pdfurl) {
        this.pdfurl = pdfurl;
    }

    public String getPdfmergeurl() {
        return pdfmergeurl;
    }

    public void setPdfmergeurl(String pdfmergeurl) {
        this.pdfmergeurl = pdfmergeurl;
    }

    public String getPackageSourceName() {
        return packageSourceName;
    }

    public void setPackageSourceName(String packageSourceName) {
        this.packageSourceName = packageSourceName;
    }

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

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
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

    public String getPackageEquipment() {
        return packageEquipment;
    }

    public void setPackageEquipment(String packageEquipment) {
        this.packageEquipment = packageEquipment;
    }

    public String getPackageSpecialRequirement() {
        return packageSpecialRequirement;
    }

    public void setPackageSpecialRequirement(String packageSpecialRequirement) {
        this.packageSpecialRequirement = packageSpecialRequirement;
    }

    public String getPackageRemark() {
        return packageRemark;
    }

    public void setPackageRemark(String packageRemark) {
        this.packageRemark = packageRemark;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
