package com.tclab.weixinappletuserclient.model.req.apiReq;

public class CancelOrderReq {

    private String orderNo;

    private Integer reasonId;

    @Override
    public String toString() {
        return "CancelOrderReq{" +
                "orderNo='" + orderNo + '\'' +
                ", reasonId=" + reasonId +
                '}';
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getReasonId() {
        return reasonId;
    }

    public void setReasonId(Integer reasonId) {
        this.reasonId = reasonId;
    }
}
