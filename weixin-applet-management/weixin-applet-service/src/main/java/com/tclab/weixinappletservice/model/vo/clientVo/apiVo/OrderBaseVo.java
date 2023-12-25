package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class OrderBaseVo {

    private String orderNo;

    private String goodName;

    private String participantName;

    private String orderCompleteApplyDate;

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

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getOrderCompleteApplyDate() {
        return orderCompleteApplyDate;
    }

    public void setOrderCompleteApplyDate(String orderCompleteApplyDate) {
        this.orderCompleteApplyDate = orderCompleteApplyDate;
    }
}
