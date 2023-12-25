package com.tclab.weixinappletuserclient.model.req.apiReq;

public class AcquisitionUncollectOrderReq {

    private String acquisitionId;

    private Integer serviceType;

    private String queryParam;

    private Integer limitNum = 10;

    @Override
    public String toString() {
        return "AcquisitionUncollectOrderReq{" +
                "acquisitionId='" + acquisitionId + '\'' +
                ", serviceType=" + serviceType +
                ", queryParam='" + queryParam + '\'' +
                ", limitNum=" + limitNum +
                '}';
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }
}
