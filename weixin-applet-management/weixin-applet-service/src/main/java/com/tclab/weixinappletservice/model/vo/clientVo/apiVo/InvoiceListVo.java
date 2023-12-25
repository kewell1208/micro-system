package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;

public class InvoiceListVo {

    private String applyId;

    private String applyDate;

    private Integer dealStatus;

    private String userId;

    private BigDecimal invoiceAmount;

    @Override
    public String toString() {
        return "InvoiceListVo{" +
                "applyId='" + applyId + '\'' +
                ", applyDate=" + applyDate +
                ", dealStatus=" + dealStatus +
                ", userId='" + userId + '\'' +
                ", invoiceAmount=" + invoiceAmount +
                '}';
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public Integer getDealStatus() {
        return dealStatus;
    }

    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }
}
