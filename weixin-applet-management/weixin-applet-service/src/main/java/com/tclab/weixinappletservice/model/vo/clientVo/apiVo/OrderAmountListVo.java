package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;

public class OrderAmountListVo {

    private String orderNo;
    private String createDate;
    private BigDecimal payAmount;
    private String payDate;
    private String participantName;

    @Override
    public String toString() {
        return "OrderAmountListVo{" +
                "orderNo='" + orderNo + '\'' +
                ", createDate='" + createDate + '\'' +
                ", payAmount=" + payAmount +
                ", payDate='" + payDate + '\'' +
                ", participantName='" + participantName + '\'' +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getPayDate() {
        return payDate;
    }

    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }
}
