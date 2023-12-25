package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.List;

public class SourceCatalogPurposeVo {

    private String packageSourceId;

    private String packageSourceName;

    private List<CatalogPurposeListVo> catalogPurposeListVoList;

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
