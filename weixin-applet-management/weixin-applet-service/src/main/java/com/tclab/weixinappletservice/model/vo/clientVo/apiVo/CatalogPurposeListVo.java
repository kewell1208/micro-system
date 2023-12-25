package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class CatalogPurposeListVo {

    private String packageCatalogId;

    private String packageCatalogName;

    private List<PurposeListVo> purposeListVoList = new ArrayList<>();

    @Override
    public String toString() {
        return "CatalogPurposeListVo{" +
                "packageCatalogId='" + packageCatalogId + '\'' +
                ", packageCatalogName='" + packageCatalogName + '\'' +
                ", purposeListVoList=" + purposeListVoList +
                '}';
    }

    public String getPackageCatalogId() {
        return packageCatalogId;
    }

    public void setPackageCatalogId(String packageCatalogId) {
        this.packageCatalogId = packageCatalogId;
    }

    public String getPackageCatalogName() {
        return packageCatalogName;
    }

    public void setPackageCatalogName(String packageCatalogName) {
        this.packageCatalogName = packageCatalogName;
    }

    public List<PurposeListVo> getPurposeListVoList() {
        return purposeListVoList;
    }

    public void setPurposeListVoList(List<PurposeListVo> purposeListVoList) {
        this.purposeListVoList = purposeListVoList;
    }
}
