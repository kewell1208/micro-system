package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.List;

public class PurposeVo {

    private String packagePurposeId;

    private String packagePurposeName;

    private String packagePurposeInfo;

    private Integer packagePurposeNum;

    private String packageCatalogId;

    private List<PackageBaseVo> packageBaseVos;

    public String getPackageCatalogId() {
        return packageCatalogId;
    }

    public void setPackageCatalogId(String packageCatalogId) {
        this.packageCatalogId = packageCatalogId;
    }

    public List<PackageBaseVo> getPackageBaseVos() {
        return packageBaseVos;
    }

    public void setPackageBaseVos(List<PackageBaseVo> packageBaseVos) {
        this.packageBaseVos = packageBaseVos;
    }

    public String getPackagePurposeId() {
        return packagePurposeId;
    }

    public void setPackagePurposeId(String packagePurposeId) {
        this.packagePurposeId = packagePurposeId;
    }

    public String getPackagePurposeName() {
        return packagePurposeName;
    }

    public void setPackagePurposeName(String packagePurposeName) {
        this.packagePurposeName = packagePurposeName;
    }

    public String getPackagePurposeInfo() {
        return packagePurposeInfo;
    }

    public void setPackagePurposeInfo(String packagePurposeInfo) {
        this.packagePurposeInfo = packagePurposeInfo;
    }

    public Integer getPackagePurposeNum() {
        return packagePurposeNum;
    }

    public void setPackagePurposeNum(Integer packagePurposeNum) {
        this.packagePurposeNum = packagePurposeNum;
    }
}
