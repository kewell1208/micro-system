package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class OrderForLogisticsBaseVo {

    private String orderNo;

    private String goodName;

    private String participantId;

    private String participantName;

    private String writeOffDate;

    private String receiveDate;

    public String getReceiveDate() {
        return receiveDate;
    }

    public void setReceiveDate(String receiveDate) {
        this.receiveDate = receiveDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
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

    public String getWriteOffDate() {
        return writeOffDate;
    }

    public void setWriteOffDate(String writeOffDate) {
        this.writeOffDate = writeOffDate;
    }
}
