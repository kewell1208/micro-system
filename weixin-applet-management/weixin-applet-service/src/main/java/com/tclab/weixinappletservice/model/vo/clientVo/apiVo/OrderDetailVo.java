package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailVo {

    private String orderNo;

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


    private String orderApplyDate;


    private BigDecimal payAmount;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private Integer orderStatus;

    private Integer verifyStatus;

    private Integer payStatus;

    private String payNo;



    private String payDate;



    private Integer refundStatus;

    private String refundNo;

    private Integer logisticsStatus;

    private Integer logisticsType;

    private String logisticsId;

    private Integer writeOffStatus;

    private String writeOffCode;


    private String writeOffDate;


    private String orderRemark;

    private Integer orderExceptionStatus;

    private Integer orderExceptionReason;

    private Integer orderCancelStatus;

    private Integer orderCancelType;

    private Integer orderCancelReason;

    private BigDecimal costReportChargeAmount;

    private String auditorStaff;

    private String verifyDate;

    public String getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(String verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getAuditorStaff() {
        return auditorStaff;
    }

    public void setAuditorStaff(String auditorStaff) {
        this.auditorStaff = auditorStaff;
    }

    private List<GoodBaseVo> goods = new ArrayList<>();

    public List<GoodBaseVo> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodBaseVo> goods) {
        this.goods = goods;
    }

    public String getOrderApplyDate() {
        return orderApplyDate;
    }

    public void setOrderApplyDate(String orderApplyDate) {
        this.orderApplyDate = orderApplyDate;
    }

    public String getWriteOffDate() {
        return writeOffDate;
    }

    public void setWriteOffDate(String writeOffDate) {
        this.writeOffDate = writeOffDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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
        this.acquisitionId = acquisitionId;
    }

    public String getAcquisitionName() {
        return acquisitionName;
    }

    public void setAcquisitionName(String acquisitionName) {
        this.acquisitionName = acquisitionName;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getServiceInfoId() {
        return serviceInfoId;
    }

    public void setServiceInfoId(String serviceInfoId) {
        this.serviceInfoId = serviceInfoId;
    }

    public String getServiceInfoAddress() {
        return serviceInfoAddress;
    }

    public void setServiceInfoAddress(String serviceInfoAddress) {
        this.serviceInfoAddress = serviceInfoAddress;
    }

    public String getServiceInfoPerson() {
        return serviceInfoPerson;
    }

    public void setServiceInfoPerson(String serviceInfoPerson) {
        this.serviceInfoPerson = serviceInfoPerson;
    }

    public String getServiceInfoPhone() {
        return serviceInfoPhone;
    }

    public void setServiceInfoPhone(String serviceInfoPhone) {
        this.serviceInfoPhone = serviceInfoPhone;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
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

    public String getParticipantIdCard() {
        return participantIdCard;
    }

    public void setParticipantIdCard(String participantIdCard) {
        this.participantIdCard = participantIdCard;
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

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayNo() {
        return payNo;
    }

    public void setPayNo(String payNo) {
        this.payNo = payNo;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getRefundNo() {
        return refundNo;
    }

    public void setRefundNo(String refundNo) {
        this.refundNo = refundNo;
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
        this.logisticsId = logisticsId;
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
        this.writeOffCode = writeOffCode;
    }

    public String getOrderRemark() {
        return orderRemark;
    }

    public void setOrderRemark(String orderRemark) {
        this.orderRemark = orderRemark;
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

    public BigDecimal getCostReportChargeAmount() {
        return costReportChargeAmount;
    }

    public void setCostReportChargeAmount(BigDecimal costReportChargeAmount) {
        this.costReportChargeAmount = costReportChargeAmount;
    }
}
