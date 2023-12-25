package com.tclab.weixinappletuserclient.model.req.apiReq;

import java.util.ArrayList;
import java.util.List;

public class SendOrderReq {

    private List<String> orderNos = new ArrayList<>();

    private String orderNo;

    private List<String> expressImages;

    private Integer logisticsType;

    private String acquisitionId;

    private String expressName;

    private String waybillNo;

    private String userId;

    private String staffId;

    @Override
    public String toString() {
        return "SendOrderReq{" +
                "orderNos=" + orderNos +
                ", orderNo='" + orderNo + '\'' +
                ", expressImages=" + expressImages +
                ", logisticsType=" + logisticsType +
                ", acquisitionId='" + acquisitionId + '\'' +
                ", expressName='" + expressName + '\'' +
                ", waybillNo='" + waybillNo + '\'' +
                ", userId='" + userId + '\'' +
                ", staffId='" + staffId + '\'' +
                '}';
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getOrderNos() {
        return orderNos;
    }

    public void setOrderNos(List<String> orderNos) {
        this.orderNos = orderNos;
    }

    public List<String> getExpressImages() {
        return expressImages;
    }

    public void setExpressImages(List<String> expressImages) {
        this.expressImages = expressImages;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }
}
