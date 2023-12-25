package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class SourceCatalogPurposeListVo {

    private String packageSourceId;

    private String packageSourceName;

    private List<CatalogPurposeListVo> catalogPurposeListVoList = new ArrayList<>();

    @Override
    public String toString() {
        return "SourceCatalogPurposeListVo{" +
                "packageSourceId='" + packageSourceId + '\'' +
                ", packageSourceName='" + packageSourceName + '\'' +
                ", catalogPurposeListVoList=" + catalogPurposeListVoList +
                '}';
    }

    public String getPackageSourceId() {
        return packageSourceId;
    }

    public void setPackageSourceId(String packageSourceId) {
        this.packageSourceId = packageSourceId;
    }

    public String getPackageSourceName() {
        return packageSourceName;
    }

    public void setPackageSourceName(String packageSourceName) {
        this.packageSourceName = packageSourceName;
    }

    public List<CatalogPurposeListVo> getCatalogPurposeListVoList() {
        return catalogPurposeListVoList;
    }

    public void setCatalogPurposeListVoList(List<CatalogPurposeListVo> catalogPurposeListVoList) {
        this.catalogPurposeListVoList = catalogPurposeListVoList;
    }
}
