package com.tclab.weixinappletservice.model.query;

import java.util.ArrayList;
import java.util.List;

public class AcquisitionGetDayPageOrderStatusParam {

    private String acquisitionId;

    private Integer orderStatus;

    private Integer orderExceptionStatus;

    private List<Integer> serviceTypes = new ArrayList();

    private String queryParam;

    private Integer orderDayNum;

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderExceptionStatus() {
        return orderExceptionStatus;
    }

    public void setOrderExceptionStatus(Integer orderExceptionStatus) {
        this.orderExceptionStatus = orderExceptionStatus;
    }

    public List<Integer> getServiceTypes() {
        return serviceTypes;
    }

    public void setServiceTypes(List<Integer> serviceTypes) {
        this.serviceTypes = serviceTypes;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public Integer getOrderDayNum() {
        return orderDayNum;
    }

    public void setOrderDayNum(Integer orderDayNum) {
        this.orderDayNum = orderDayNum;
    }
}
