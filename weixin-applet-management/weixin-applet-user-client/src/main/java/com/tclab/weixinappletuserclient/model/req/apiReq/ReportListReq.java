package com.tclab.weixinappletuserclient.model.req.apiReq;

public class ReportListReq {

    private String packageName;

    private String userId;

    private Integer reportStatus;

    private Integer interpretStatus;

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    private String orderNo;

    @Override
    public String toString() {
        return "ReportListReq{" +
                "packageName='" + packageName + '\'' +
                ", userId='" + userId + '\'' +
                ", reportStatus=" + reportStatus +
                ", interpretStatus=" + interpretStatus +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getInterpretStatus() {
        return interpretStatus;
    }

    public void setInterpretStatus(Integer interpretStatus) {
        this.interpretStatus = interpretStatus;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }
}
