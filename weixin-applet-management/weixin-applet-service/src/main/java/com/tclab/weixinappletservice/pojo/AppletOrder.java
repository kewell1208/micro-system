package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AppletOrder {
    private Integer id;

    private String pid;

    private String orderNo;

    private String merchantId;

    private Integer orderType;

    private Integer serviceType;

    private String acquisitionId;

    private String acquisitionName;

    private String goodName;

    private String userId;

    private String userName;

    private String userPhone;

    private String userIdCard;

    private String serviceInfoId;

    private String serviceInfoAddress;

    private String serviceInfoPerson;

    private String serviceInfoPhone;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private String participantIdCard;

    private Date orderApplyDate;

    private Date orderCurrentApplyDate;

    private Date orderCompleteApplyDate;

    private BigDecimal payAmount;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private Integer discountType;

    private String promotionId;

    private String promotionName;

    private String discountId;

    private String discountName;

    private Integer orderStatus;

    private Integer verifyStatus;

    private Date verifyDate;

    private String auditorId;

    private Integer payStatus;

    private String preNo;

    private String payNo;

    private Date payDate;

    private Integer refundStatus;

    private BigDecimal refundAmount;

    private Integer refundReason;

    private Integer logisticsStatus;

    private Integer logisticsType;

    private String logisticsId;

    private Integer writeOffStatus;

    private String writeOffCode;

    private Date writeOffDate;

    private String costDepartmentCommissionAmount;

    private BigDecimal costOrganizationCommissionAmount;

    private BigDecimal platformCommissionAmount;

    private String orderRemark;

    private Integer orderExceptionStatus;

    private Integer orderExceptionReason;

    private Integer orderCancelStatus;

    private Integer orderCancelType;

    private Integer orderCancelReason;

    private Integer interpretStatus;

    private BigDecimal costReportChargeAmount;

    private BigDecimal costAcquisitionChargeAmount;

    private BigDecimal costStaffCommissionAmount;

    private String staffId;

    private String staffPhone;

    private String staffName;

    private String imRecommendListId;

    private Integer invoiceStatus;

    private String invoiceApplyId;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private String interpretStaffId;

    private String messageStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
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

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName == null ? null : goodName.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard == null ? null : userIdCard.trim();
    }

    public String getServiceInfoId() {
        return serviceInfoId;
    }

    public void setServiceInfoId(String serviceInfoId) {
        this.serviceInfoId = serviceInfoId == null ? null : serviceInfoId.trim();
    }

    public String getServiceInfoAddress() {
        return serviceInfoAddress;
    }

    public void setServiceInfoAddress(String serviceInfoAddress) {
        this.serviceInfoAddress = serviceInfoAddress == null ? null : serviceInfoAddress.trim();
    }

    public String getServiceInfoPerson() {
        return serviceInfoPerson;
    }

    public void setServiceInfoPerson(String serviceInfoPerson) {
        this.serviceInfoPerson = serviceInfoPerson == null ? null : serviceInfoPerson.trim();
    }

    public String getServiceInfoPhone() {
        return serviceInfoPhone;
    }

    public void setServiceInfoPhone(String serviceInfoPhone) {
        this.serviceInfoPhone = serviceInfoPhone == null ? null : serviceInfoPhone.trim();
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId == null ? null : participantId.trim();
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName == null ? null : participantName.trim();
    }

    public String getParticipantPhone() {
        return participantPhone;
    }

    public void setParticipantPhone(String participantPhone) {
        this.participantPhone = participantPhone == null ? null : participantPhone.trim();
    }

    public String getParticipantIdCard() {
        return participantIdCard;
    }

    public void setParticipantIdCard(String participantIdCard) {
        this.participantIdCard = participantIdCard == null ? null : participantIdCard.trim();
    }

    public Date getOrderApplyDate() {
        return orderApplyDate;
    }

    public void setOrderApplyDate(Date orderApplyDate) {
        this.orderApplyDate = orderApplyDate;
    }

    public Date getOrderCurrentApplyDate() {
        return orderCurrentApplyDate;
    }

    public void setOrderCurrentApplyDate(Date orderCurrentApplyDate) {
        this.orderCurrentApplyDate = orderCurrentApplyDate;
    }

    public Date getOrderCompleteApplyDate() {
        return orderCompleteApplyDate;
    }

    public void setOrderCompleteApplyDate(Date orderCompleteApplyDate) {
        this.orderCompleteApplyDate = orderCompleteApplyDate;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getDiscountType() {
        return discountType;
    }

    public void setDiscountType(Integer discountType) {
        this.discountType = discountType;
    }

    public String getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(String promotionId) {
        this.promotionId = promotionId == null ? null : promotionId.trim();
    }

    public String getPromotionName() {
        return promotionName;
    }

    public void setPromotionName(String promotionName) {
        this.promotionName = promotionName == null ? null : promotionName.trim();
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId == null ? null : discountId.trim();
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName == null ? null : discountName.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Date getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(Date verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(String auditorId) {
        this.auditorId = auditorId == null ? null : auditorId.trim();
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPreNo() {
        return preNo;
    }

    public void setPreNo(String preNo) {
        this.preNo = preNo == null ? null : preNo.trim();
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo == null ? null : payNo.trim();
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getRefundReason() {
        return refundReason;
    }

    public void setRefundReason(Integer refundReason) {
        this.refundReason = refundReason;
    }

    public Integer getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId == null ? null : logisticsId.trim();
    }

    public Integer getWriteOffStatus() {
        return writeOffStatus;
    }

    public void setWriteOffStatus(Integer writeOffStatus) {
        this.writeOffStatus = writeOffStatus;
    }

    public String getWriteOffCode() {
        return writeOffCode;
    }

    public void setWriteOffCode(String writeOffCode) {
        this.writeOffCode = writeOffCode == null ? null : writeOffCode.trim();
    }

    public Date getWriteOffDate() {
        return writeOffDate;
    }

    public void setWriteOffDate(Date writeOffDate) {
        this.writeOffDate = writeOffDate;
    }

    public String getCostDepartmentCommissionAmount() {
        return costDepartmentCommissionAmount;
    }

    public void setCostDepartmentCommissionAmount(String costDepartmentCommissionAmount) {
        this.costDepartmentCommissionAmount = costDepartmentCommissionAmount == null ? null : costDepartmentCommissionAmount.trim();
    }

    public BigDecimal getCostOrganizationCommissionAmount() {
        return costOrganizationCommissionAmount;
    }

    public void setCostOrganizationCommissionAmount(BigDecimal costOrganizationCommissionAmount) {
        this.costOrganizationCommissionAmount = costOrganizationCommissionAmount;
    }

    public BigDecimal getPlatformCommissionAmount() {
        return platformCommissionAmount;
    }

    public void setPlatformCommissionAmount(BigDecimal platformCommissionAmount) {
        this.platformCommissionAmount = platformCommissionAmount;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark == null ? null : orderRemark.trim();
    }

    public Integer getOrderExceptionStatus() {
        return orderExceptionStatus;
    }

    public void setOrderExceptionStatus(Integer orderExceptionStatus) {
        this.orderExceptionStatus = orderExceptionStatus;
    }

    public Integer getOrderExceptionReason() {
        return orderExceptionReason;
    }

    public void setOrderExceptionReason(Integer orderExceptionReason) {
        this.orderExceptionReason = orderExceptionReason;
    }

    public Integer getOrderCancelStatus() {
        return orderCancelStatus;
    }

    public void setOrderCancelStatus(Integer orderCancelStatus) {
        this.orderCancelStatus = orderCancelStatus;
    }

    public Integer getOrderCancelType() {
        return orderCancelType;
    }

    public void setOrderCancelType(Integer orderCancelType) {
        this.orderCancelType = orderCancelType;
    }

    public Integer getOrderCancelReason() {
        return orderCancelReason;
    }

    public void setOrderCancelReason(Integer orderCancelReason) {
        this.orderCancelReason = orderCancelReason;
    }

    public Integer getInterpretStatus() {
        return interpretStatus;
    }

    public void setInterpretStatus(Integer interpretStatus) {
        this.interpretStatus = interpretStatus;
    }

    public BigDecimal getCostReportChargeAmount() {
        return costReportChargeAmount;
    }

    public void setCostReportChargeAmount(BigDecimal costReportChargeAmount) {
        this.costReportChargeAmount = costReportChargeAmount;
    }

    public BigDecimal getCostAcquisitionChargeAmount() {
        return costAcquisitionChargeAmount;
    }

    public void setCostAcquisitionChargeAmount(BigDecimal costAcquisitionChargeAmount) {
        this.costAcquisitionChargeAmount = costAcquisitionChargeAmount;
    }

    public BigDecimal getCostStaffCommissionAmount() {
        return costStaffCommissionAmount;
    }

    public void setCostStaffCommissionAmount(BigDecimal costStaffCommissionAmount) {
        this.costStaffCommissionAmount = costStaffCommissionAmount;
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

    public String getImRecommendListId() {
        return imRecommendListId;
    }

    public void setImRecommendListId(String imRecommendListId) {
        this.imRecommendListId = imRecommendListId == null ? null : imRecommendListId.trim();
    }

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public String getInvoiceApplyId() {
        return invoiceApplyId;
    }

    public void setInvoiceApplyId(String invoiceApplyId) {
        this.invoiceApplyId = invoiceApplyId == null ? null : invoiceApplyId.trim();
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

    public String getInterpretStaffId() {
        return interpretStaffId;
    }

    public void setInterpretStaffId(String interpretStaffId) {
        this.interpretStaffId = interpretStaffId == null ? null : interpretStaffId.trim();
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus == null ? null : messageStatus.trim();
    }
}