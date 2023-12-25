package com.tclab.weixinappletuserclient.model.req.apiReq;

public class AcquisitionIdReq {

    private String acquisitionId;

    @Override
    public String toString() {
        return "AcquisitionIdReq{" +
                "acquisitionId='" + acquisitionId + '\'' +
                '}';
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }
}
