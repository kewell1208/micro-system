package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.pojo.AppletPackageCatalog;

import java.util.List;

public class CatalogListVo {

    private String packageSourceName;

    private List<AppletPackageCatalog> catalogList;

    public String getPackageSourceName() {
        return packageSourceName;
    }

    public void setPackageSourceName(String packageSourceName) {
        this.packageSourceName = packageSourceName;
    }

    public List<AppletPackageCatalog> getCatalogList() {
        return catalogList;
    }

    public void setCatalogList(List<AppletPackageCatalog> catalogList) {
        this.catalogList = catalogList;
    }
}
