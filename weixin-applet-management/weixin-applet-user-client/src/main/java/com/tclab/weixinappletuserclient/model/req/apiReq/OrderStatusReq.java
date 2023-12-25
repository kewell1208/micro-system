package com.tclab.weixinappletuserclient.model.req.apiReq;

public class OrderStatusReq {

    private String userId;

    private Integer orderStatus;

    private String param;

    private Integer pageNo = 1;

    private Integer pageSize = 10;

    @Override
    public String toString() {
        return "OrderStatusReq{" +
                "userId='" + userId + '\'' +
                ", orderStatus=" + orderStatus +
                ", param='" + param + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }
}
