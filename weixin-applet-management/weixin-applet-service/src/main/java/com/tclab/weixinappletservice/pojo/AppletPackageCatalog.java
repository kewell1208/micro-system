package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletPackageCatalog {
    private Integer id;

    private String packageCatalogId;

    private String packageCatalogName;

    private String packageCatalogRemark;

    private String packageSourceId;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageCatalogId() {
        return packageCatalogId;
    }

    public void setPackageCatalogId(String packageCatalogId) {
        this.packageCatalogId = packageCatalogId == null ? null : packageCatalogId.trim();
    }

    public String getPackageCatalogName() {
        return packageCatalogName;
    }

    public void setPackageCatalogName(String packageCatalogName) {
        this.packageCatalogName = packageCatalogName == null ? null : packageCatalogName.trim();
    }

    public String getPackageCatalogRemark() {
        return packageCatalogRemark;
    }

    public void setPackageCatalogRemark(String packageCatalogRemark) {
        this.packageCatalogRemark = packageCatalogRemark == null ? null : packageCatalogRemark.trim();
    }

    public String getPackageSourceId() {
        return packageSourceId;
    }

    public void setPackageSourceId(String packageSourceId) {
        this.packageSourceId = packageSourceId == null ? null : packageSourceId.trim();
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