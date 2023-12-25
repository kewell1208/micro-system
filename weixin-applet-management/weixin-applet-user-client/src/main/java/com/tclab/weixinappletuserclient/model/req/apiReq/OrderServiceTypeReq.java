package com.tclab.weixinappletuserclient.model.req.apiReq;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceTypeReq {

    private String acquisitionId;

    private List<String> packageId = new ArrayList<>();

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public List<String> getPackageId() {
        return packageId;
    }

    public void setPackageId(List<String> packageId) {
        this.packageId = packageId;
    }
}
