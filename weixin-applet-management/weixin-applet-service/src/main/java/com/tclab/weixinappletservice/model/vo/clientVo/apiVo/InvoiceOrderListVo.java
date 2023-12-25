package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;

public class InvoiceOrderListVo {

    private String orderNo;

    private String participantName;

    private BigDecimal payAmount;

    private String payDate;

    private Integer invoiceStatus;

    @Override
    public String toString() {
        return "InvoiceOrderListVo{" +
                "orderNo='" + orderNo + '\'' +
                ", participantName='" + participantName + '\'' +
                ", payAmount=" + payAmount +
                ", payDate='" + payDate + '\'' +
                ", invoiceStatus=" + invoiceStatus +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
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

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}
