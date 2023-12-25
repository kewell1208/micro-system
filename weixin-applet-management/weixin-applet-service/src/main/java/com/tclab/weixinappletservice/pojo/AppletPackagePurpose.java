package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletPackagePurpose {
    private Integer id;

    private String packagePurposeId;

    private String packagePurposeName;

    private String packageCatalogId;

    private String packagePurposeInfo;

    private Integer packagePurposeNum;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackagePurposeId() {
        return packagePurposeId;
    }

    public void setPackagePurposeId(String packagePurposeId) {
        this.packagePurposeId = packagePurposeId == null ? null : packagePurposeId.trim();
    }

    public String getPackagePurposeName() {
        return packagePurposeName;
    }

    public void setPackagePurposeName(String packagePurposeName) {
        this.packagePurposeName = packagePurposeName == null ? null : packagePurposeName.trim();
    }

    public String getPackageCatalogId() {
        return packageCatalogId;
    }

    public void setPackageCatalogId(String packageCatalogId) {
        this.packageCatalogId = packageCatalogId == null ? null : packageCatalogId.trim();
    }

    public String getPackagePurposeInfo() {
        return packagePurposeInfo;
    }

    public void setPackagePurposeInfo(String packagePurposeInfo) {
        this.packagePurposeInfo = packagePurposeInfo == null ? null : packagePurposeInfo.trim();
    }

    public Integer getPackagePurposeNum() {
        return packagePurposeNum;
    }

    public void setPackagePurposeNum(Integer packagePurposeNum) {
        this.packagePurposeNum = packagePurposeNum;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}