package com.tclab.weixinappletuserclient.model.req.apiReq;

import java.util.ArrayList;
import java.util.List;

public class GoodNoReq {

    private String orderNo;

    private String goodNo;

    private String packageId;

    private String barcode;

    private String staffId;

    private String queryParam;

    private String collectorId;

    private List<String> orderNoList = new ArrayList<>();

    @Override
    public String toString() {
        return "GoodNoReq{" +
                "orderNo='" + orderNo + '\'' +
                ", goodNo='" + goodNo + '\'' +
                ", packageId='" + packageId + '\'' +
                ", barcode='" + barcode + '\'' +
                ", staffId='" + staffId + '\'' +
                ", queryParam='" + queryParam + '\'' +
                ", collectorId='" + collectorId + '\'' +
                ", orderNoList=" + orderNoList +
                '}';
    }

    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public List<String> getOrderNoList() {
        return orderNoList;
    }

    public void setOrderNoList(List<String> orderNoList) {
        this.orderNoList = orderNoList;
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

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
