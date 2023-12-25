package com.tclab.weixinappletuserclient.model.req.apiReq;

public class OrderNoReq {

    private String orderNo;

    private String openid;

    @Override
    public String toString() {
        return "OrderNoReq{" +
                "orderNo='" + orderNo + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
