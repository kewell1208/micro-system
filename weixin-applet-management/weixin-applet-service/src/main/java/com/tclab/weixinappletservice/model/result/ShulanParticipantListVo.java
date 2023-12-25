package com.tclab.weixinappletservice.model.result;

import java.util.Date;

public class ShulanParticipantListVo {

    private String participantId;

    private String participantName;

    private String orderNo;

    private String goodNo;

    private String sampleNo;

    private String sampleCollectDate;

    private Date createDate;

    private String dateStr;

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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
}
