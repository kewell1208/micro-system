package com.tclab.weixinappletservice.model.result;

import java.util.Date;

public class ShulanRecommendListNewVo {

    private String orderNo;

    private String goodNo;

    private String sampleNo;

    private String sampleCollectDate;

    private String packageId;

    private String packageName;

    private String participantName;

    private String participantPhone;

    private Integer participantSex;

    private Integer participantAge;

    private Integer reportStatus;

    private String interpretName;

    private String interpretPhone;

    private String doctorName;

    private String doctorPhone;

    private String reportImg;

    private String reportDate;

    private Date reportDateForNum;

    private Integer goodStatus;

    @Override
    public String toString() {
        return "ShulanRecommendListVo{" +
                "orderNo='" + orderNo + '\'' +
                ", goodNo='" + goodNo + '\'' +
                ", sampleNo='" + sampleNo + '\'' +
                ", sampleCollectDate='" + sampleCollectDate + '\'' +
                ", packageId='" + packageId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", participantName='" + participantName + '\'' +
                ", participantPhone='" + participantPhone + '\'' +
                ", participantSex=" + participantSex +
                ", participantAge=" + participantAge +
                ", reportStatus=" + reportStatus +
                ", interpretName='" + interpretName + '\'' +
                ", interpretPhone='" + interpretPhone + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorPhone='" + doctorPhone + '\'' +
                ", reportImg='" + reportImg + '\'' +
                ", reportDate='" + reportDate + '\'' +
                ", reportDateForNum=" + reportDateForNum +
                ", goodStatus=" + goodStatus +
                '}';
    }

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public Date getReportDateForNum() {
        return reportDateForNum;
    }

    public void setReportDateForNum(Date reportDateForNum) {
        this.reportDateForNum = reportDateForNum;
    }

    public String getReportImg() {
        return reportImg;
    }

    public void setReportImg(String reportImg) {
        this.reportImg = reportImg;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
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

    public String getInterpretName() {
        return interpretName;
    }

    public void setInterpretName(String interpretName) {
        this.interpretName = interpretName;
    }

    public String getInterpretPhone() {
        return interpretPhone;
    }

    public void setInterpretPhone(String interpretPhone) {
        this.interpretPhone = interpretPhone;
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

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getSampleCollectDate() {
        return sampleCollectDate;
    }

    public void setSampleCollectDate(String sampleCollectDate) {
        this.sampleCollectDate = sampleCollectDate;
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

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantPhone() {
        return participantPhone;
    }

    public void setParticipantPhone(String participantPhone) {
        this.participantPhone = participantPhone;
    }

    public Integer getParticipantSex() {
        return participantSex;
    }

    public void setParticipantSex(Integer participantSex) {
        this.participantSex = participantSex;
    }

    public Integer getParticipantAge() {
        return participantAge;
    }

    public void setParticipantAge(Integer participantAge) {
        this.participantAge = participantAge;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }
}
