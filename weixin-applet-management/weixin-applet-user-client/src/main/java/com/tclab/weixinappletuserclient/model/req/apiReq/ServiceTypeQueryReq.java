package com.tclab.weixinappletuserclient.model.req.apiReq;

import java.util.List;

public class ServiceTypeQueryReq {

    private List<String> packageId;

    private String acquisitionId;

    public List<String> getPackageId() {
        return packageId;
    }

    public void setPackageId(List<String> packageId) {
        this.packageId = packageId;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }
}
