package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AppletGood {
    private Integer id;

    private String orderNo;

    private String goodNo;

    private String userId;

    private String participantId;

    private String packageId;

    private String packageName;

    private Integer packageNum;

    private String acquisitionId;

    private String acquisitionName;

    private Date goodApplyDate;

    private Date goodCurrentApplyDate;

    private Date goodCompleteApplyDate;

    private String staffId;

    private String staffPhone;

    private String staffName;

    private BigDecimal costStaffCommission;

    private String acquisitionDepartmentId;

    private String acquisitionDepartmentName;

    private String costDepartmentCommission;

    private String recommeddOrganizationId;

    private String recommeddOrganizationName;

    private BigDecimal costOrganizationCommission;

    private BigDecimal costAcquisitionCharge;

    private BigDecimal payAmount;

    private BigDecimal discountAmount;

    private BigDecimal totalAmount;

    private Integer serviceType;

    private String sampleNo;

    private Date sampleCollectDate;

    private Integer reportType;

    private BigDecimal reportCost;

    private String reportImg;

    private Date reportDate;

    private String doctorName;

    private String doctorPhone;

    private Integer goodStatus;

    private Integer exceptionStatus;

    private Integer exceptionReason;

    private Integer exceptionSolution;

    private Date exceptionSolveTime;

    private Integer refundStatus;

    private Integer refundReason;

    private Integer refundAmount;

    private String refundRemark;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private String collectorStaffId;

    private String pdfUrl;

    private String pdfMergeUrl;

    private String messageStatus;

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
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo == null ? null : goodNo.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId == null ? null : participantId.trim();
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId == null ? null : packageId.trim();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
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
        this.acquisitionId = acquisitionId == null ? null : acquisitionId.trim();
    }

    public String getAcquisitionName() {
        return acquisitionName;
    }

    public void setAcquisitionName(String acquisitionName) {
        this.acquisitionName = acquisitionName == null ? null : acquisitionName.trim();
    }

    public Date getGoodApplyDate() {
        return goodApplyDate;
    }

    public void setGoodApplyDate(Date goodApplyDate) {
        this.goodApplyDate = goodApplyDate;
    }

    public Date getGoodCurrentApplyDate() {
        return goodCurrentApplyDate;
    }

    public void setGoodCurrentApplyDate(Date goodCurrentApplyDate) {
        this.goodCurrentApplyDate = goodCurrentApplyDate;
    }

    public Date getGoodCompleteApplyDate() {
        return goodCompleteApplyDate;
    }

    public void setGoodCompleteApplyDate(Date goodCompleteApplyDate) {
        this.goodCompleteApplyDate = goodCompleteApplyDate;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public BigDecimal getCostStaffCommission() {
        return costStaffCommission;
    }

    public void setCostStaffCommission(BigDecimal costStaffCommission) {
        this.costStaffCommission = costStaffCommission;
    }

    public String getAcquisitionDepartmentId() {
        return acquisitionDepartmentId;
    }

    public void setAcquisitionDepartmentId(String acquisitionDepartmentId) {
        this.acquisitionDepartmentId = acquisitionDepartmentId == null ? null : acquisitionDepartmentId.trim();
    }

    public String getAcquisitionDepartmentName() {
        return acquisitionDepartmentName;
    }

    public void setAcquisitionDepartmentName(String acquisitionDepartmentName) {
        this.acquisitionDepartmentName = acquisitionDepartmentName == null ? null : acquisitionDepartmentName.trim();
    }

    public String getCostDepartmentCommission() {
        return costDepartmentCommission;
    }

    public void setCostDepartmentCommission(String costDepartmentCommission) {
        this.costDepartmentCommission = costDepartmentCommission == null ? null : costDepartmentCommission.trim();
    }

    public String getRecommeddOrganizationId() {
        return recommeddOrganizationId;
    }

    public void setRecommeddOrganizationId(String recommeddOrganizationId) {
        this.recommeddOrganizationId = recommeddOrganizationId == null ? null : recommeddOrganizationId.trim();
    }

    public String getRecommeddOrganizationName() {
        return recommeddOrganizationName;
    }

    public void setRecommeddOrganizationName(String recommeddOrganizationName) {
        this.recommeddOrganizationName = recommeddOrganizationName == null ? null : recommeddOrganizationName.trim();
    }

    public BigDecimal getCostOrganizationCommission() {
        return costOrganizationCommission;
    }

    public void setCostOrganizationCommission(BigDecimal costOrganizationCommission) {
        this.costOrganizationCommission = costOrganizationCommission;
    }

    public BigDecimal getCostAcquisitionCharge() {
        return costAcquisitionCharge;
    }

    public void setCostAcquisitionCharge(BigDecimal costAcquisitionCharge) {
        this.costAcquisitionCharge = costAcquisitionCharge;
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

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo == null ? null : sampleNo.trim();
    }

    public Date getSampleCollectDate() {
        return sampleCollectDate;
    }

    public void setSampleCollectDate(Date sampleCollectDate) {
        this.sampleCollectDate = sampleCollectDate;
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

    public String getReportImg() {
        return reportImg;
    }

    public void setReportImg(String reportImg) {
        this.reportImg = reportImg == null ? null : reportImg.trim();
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone == null ? null : doctorPhone.trim();
    }

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public Integer getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(Integer exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public Integer getExceptionReason() {
        return exceptionReason;
    }

    public void setExceptionReason(Integer exceptionReason) {
        this.exceptionReason = exceptionReason;
    }

    public Integer getExceptionSolution() {
        return exceptionSolution;
    }

    public void setExceptionSolution(Integer exceptionSolution) {
        this.exceptionSolution = exceptionSolution;
    }

    public Date getExceptionSolveTime() {
        return exceptionSolveTime;
    }

    public void setExceptionSolveTime(Date exceptionSolveTime) {
        this.exceptionSolveTime = exceptionSolveTime;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(Integer refundReason) {
        this.refundReason = refundReason;
    }

    public Integer getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Integer refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundRemark() {
        return refundRemark;
    }

    public void setRefundRemark(String refundRemark) {
        this.refundRemark = refundRemark == null ? null : refundRemark.trim();
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

    public String getCollectorStaffId() {
        return collectorStaffId;
    }

    public void setCollectorStaffId(String collectorStaffId) {
        this.collectorStaffId = collectorStaffId == null ? null : collectorStaffId.trim();
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl == null ? null : pdfUrl.trim();
    }

    public String getPdfMergeUrl() {
        return pdfMergeUrl;
    }

    public void setPdfMergeUrl(String pdfMergeUrl) {
        this.pdfMergeUrl = pdfMergeUrl == null ? null : pdfMergeUrl.trim();
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus == null ? null : messageStatus.trim();
    }
}