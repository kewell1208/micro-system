package com.tclab.weixinappletservice.model.query;

public class InvoiceQueryParam {

    private String dateForMonth;

    private Integer invoiceStatus;

    private String userId;

    private String invoiceApplyId;

    public String getInvoiceApplyId() {
        return invoiceApplyId;
    }

    public void setInvoiceApplyId(String invoiceApplyId) {
        this.invoiceApplyId = invoiceApplyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDateForMonth() {
        return dateForMonth;
    }

    public void setDateForMonth(String dateForMonth) {
        this.dateForMonth = dateForMonth;
    }

    public Integer getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(Integer invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }
}
