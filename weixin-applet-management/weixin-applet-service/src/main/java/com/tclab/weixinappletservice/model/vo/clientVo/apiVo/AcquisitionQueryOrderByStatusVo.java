package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class AcquisitionQueryOrderByStatusVo {

    private String acquisitionId;

    private String queryParam;

    private Integer orderStatus;

    private Integer orderExceptionStatus;

    private Integer verifyStatus;

    private Integer dayNum = 1;

    private Integer limitNum = 30;

    private Integer pageNo = 1;

    private Integer pageSize = 10;

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

    @Override
    public String toString() {
        return "AcquisitionQueryOrderByStatusVo{" +
                "acquisitionId='" + acquisitionId + '\'' +
                ", queryParam='" + queryParam + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderExceptionStatus=" + orderExceptionStatus +
                ", verifyStatus=" + verifyStatus +
                ", dayNum=" + dayNum +
                ", limitNum=" + limitNum +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public Integer getOrderExceptionStatus() {
        return orderExceptionStatus;
    }

    public void setOrderExceptionStatus(Integer orderExceptionStatus) {
        this.orderExceptionStatus = orderExceptionStatus;
    }

    public Integer getDayNum() {
        return dayNum;
    }

    public void setDayNum(Integer dayNum) {
        this.dayNum = dayNum;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
