package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletGoodReportInterpret {
    private Integer id;

    private String userId;

    private Integer payType;

    private String reportId;

    private String goodNo;

    private String doctorId;

    private String doctorName;

    private String doctorDepartment;

    private String doctorRank;

    private String doctorLabel;

    private Integer interpretationStatus;

    private Date interpretationDate;

    private String reportContent;

    private String reportReply;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Integer getPayType() {
        return payType;
    }

    public void setPayType(Integer payType) {
        this.payType = payType;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId == null ? null : reportId.trim();
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo == null ? null : goodNo.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getDoctorDepartment() {
        return doctorDepartment;
    }

    public void setDoctorDepartment(String doctorDepartment) {
        this.doctorDepartment = doctorDepartment == null ? null : doctorDepartment.trim();
    }

    public String getDoctorRank() {
        return doctorRank;
    }

    public void setDoctorRank(String doctorRank) {
        this.doctorRank = doctorRank == null ? null : doctorRank.trim();
    }

    public String getDoctorLabel() {
        return doctorLabel;
    }

    public void setDoctorLabel(String doctorLabel) {
        this.doctorLabel = doctorLabel == null ? null : doctorLabel.trim();
    }

    public Integer getInterpretationStatus() {
        return interpretationStatus;
    }

    public void setInterpretationStatus(Integer interpretationStatus) {
        this.interpretationStatus = interpretationStatus;
    }

    public Date getInterpretationDate() {
        return interpretationDate;
    }

    public void setInterpretationDate(Date interpretationDate) {
        this.interpretationDate = interpretationDate;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
    }

    public String getReportReply() {
        return reportReply;
    }

    public void setReportReply(String reportReply) {
        this.reportReply = reportReply == null ? null : reportReply.trim();
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}