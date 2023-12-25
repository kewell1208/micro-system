package com.tclab.weixinappletuserclient.model.req.apiReq;

public class InvoiceReq {

    private String dateForMonth;

    private Integer invoiceStatus;

    private String userId;

    private String applyId;

    private String dateStart;

    private String dateEnd;

    @Override
    public String toString() {
        return "InvoiceReq{" +
                "dateForMonth='" + dateForMonth + '\'' +
                ", invoiceStatus=" + invoiceStatus +
                ", userId='" + userId + '\'' +
                ", applyId='" + applyId + '\'' +
                ", dateStart='" + dateStart + '\'' +
                ", dateEnd='" + dateEnd + '\'' +
                '}';
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
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
