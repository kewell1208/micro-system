package com.tclab.weixinappletuserclient.model.req.apiReq;

public class AcquisitionParamReq {

    private String acquisitionId;

    private String queryParam;

    @Override
    public String toString() {
        return "AcquisitionParamReq{" +
                "acquisitionId='" + acquisitionId + '\'' +
                ", queryParam='" + queryParam + '\'' +
                '}';
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
}
