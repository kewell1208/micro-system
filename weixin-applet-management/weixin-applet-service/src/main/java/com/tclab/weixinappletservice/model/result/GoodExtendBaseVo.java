package com.tclab.weixinappletservice.model.result;

import java.math.BigDecimal;

public class GoodExtendBaseVo {

    private String orderNo;

    private String goodNo;

    private String packageId;

    private String packageName;

    private Integer goodStatus;

    private String participantId;

    private String participantName;

    private String participantAge;

    private String participantSex;

    private String participantPhone;

    private String participantIdCard;

//    private Date goodApplyDate;

    private String goodApplyDate;

    private BigDecimal payAmount;

    private Integer orderStatus;

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

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
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

    public String getParticipantAge() {
        return participantAge;
    }

    public void setParticipantAge(String participantAge) {
        this.participantAge = participantAge;
    }

    public String getParticipantSex() {
        return participantSex;
    }

    public void setParticipantSex(String participantSex) {
        this.participantSex = participantSex;
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

//    public Date getGoodApplyDate() {
//        return goodApplyDate;
//    }
//
//    public void setGoodApplyDate(Date goodApplyDate) {
//        this.goodApplyDate = goodApplyDate;
//    }

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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
