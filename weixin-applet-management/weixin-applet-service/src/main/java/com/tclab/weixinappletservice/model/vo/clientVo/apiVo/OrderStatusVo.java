package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderStatusVo {

    private Integer id;

    private String orderNo;

    private Integer orderType;

    private Integer serviceType;

    private String acquisitionId;

    private String acquisitionName;

    private String goodName;

    private BigDecimal payAmount;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private String participantIdCard;

    private Integer orderStatus;

    private Integer verifyStatus;

    private Integer payStatus;

    private Integer refundStatus;

    private Integer logisticsStatus;

    private Integer writeOffStatus;

    private Integer orderExceptionStatus;

    private Integer orderCancelStatus;

    private Integer orderCancelReason;

    private List<GoodBaseVo> goodBaseVos = new ArrayList<>();

    public List<GoodBaseVo> getGoodBaseVos() {
        return goodBaseVos;
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

    public void setGoodBaseVos(List<GoodBaseVo> goodBaseVos) {
        this.goodBaseVos = goodBaseVos;
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

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public Integer getWriteOffStatus() {
        return writeOffStatus;
    }

    public void setWriteOffStatus(Integer writeOffStatus) {
        this.writeOffStatus = writeOffStatus;
    }

    public Integer getOrderExceptionStatus() {
        return orderExceptionStatus;
    }

    public void setOrderExceptionStatus(Integer orderExceptionStatus) {
        this.orderExceptionStatus = orderExceptionStatus;
    }

    public Integer getOrderCancelStatus() {
        return orderCancelStatus;
    }

    public void setOrderCancelStatus(Integer orderCancelStatus) {
        this.orderCancelStatus = orderCancelStatus;
    }

    public Integer getOrderCancelReason() {
        return orderCancelReason;
    }

    public void setOrderCancelReason(Integer orderCancelReason) {
        this.orderCancelReason = orderCancelReason;
    }

}
