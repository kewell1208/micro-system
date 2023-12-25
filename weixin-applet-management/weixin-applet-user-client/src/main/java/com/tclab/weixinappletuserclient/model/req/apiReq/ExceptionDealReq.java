package com.tclab.weixinappletuserclient.model.req.apiReq;

public class ExceptionDealReq {

    private String orderNo;

    private String goodNo;

    private Integer deal;

    private Integer reason;


    private String goodApplyDate;

    private String packageId;

    private String packageName;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private String goodDelayApplyDate;

    @Override
    public String toString() {
        return "ExceptionDealReq{" +
                "orderNo='" + orderNo + '\'' +
                ", goodNo='" + goodNo + '\'' +
                ", deal=" + deal +
                ", reason=" + reason +
                ", goodApplyDate='" + goodApplyDate + '\'' +
                ", packageId='" + packageId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", participantId='" + participantId + '\'' +
                ", participantName='" + participantName + '\'' +
                ", participantPhone='" + participantPhone + '\'' +
                ", goodDelayApplyDate='" + goodDelayApplyDate + '\'' +
                '}';
    }

    public String getGoodApplyDate() {
        return goodApplyDate;
    }

    public void setGoodApplyDate(String goodApplyDate) {
        this.goodApplyDate = goodApplyDate;
    }

    public String getGoodDelayApplyDate() {
        return goodDelayApplyDate;
    }

    public void setGoodDelayApplyDate(String goodDelayApplyDate) {
        this.goodDelayApplyDate = goodDelayApplyDate;
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

    public Integer getDeal() {
        return deal;
    }

    public void setDeal(Integer deal) {
        this.deal = deal;
    }

    public Integer getReason() {
        return reason;
    }

    public void setReason(Integer reason) {
        this.reason = reason;
    }
}
