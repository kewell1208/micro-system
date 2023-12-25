package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class PurposeListVo {

    private String packagePurposeId;

    private String packagePurposeName;

    @Override
    public String toString() {
        return "PurposeListVo{" +
                "packagePurposeId='" + packagePurposeId + '\'' +
                ", packagePurposeName='" + packagePurposeName + '\'' +
                '}';
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
}
