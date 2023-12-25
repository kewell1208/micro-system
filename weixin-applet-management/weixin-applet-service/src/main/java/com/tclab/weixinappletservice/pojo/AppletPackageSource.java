package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletPackageSource {
    private Integer id;

    private String packageSourceId;

    private String packageSourceName;

    private String packageSourceRemark;

    private String packageSourceDirector;

    private String packageSourcePhone;

    private Integer packageSourceStatus;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private String sourcePic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageSourceId() {
        return packageSourceId;
    }

    public void setPackageSourceId(String packageSourceId) {
        this.packageSourceId = packageSourceId == null ? null : packageSourceId.trim();
    }

    public String getPackageSourceName() {
        return packageSourceName;
    }

    public void setPackageSourceName(String packageSourceName) {
        this.packageSourceName = packageSourceName == null ? null : packageSourceName.trim();
    }

    public String getPackageSourceRemark() {
        return packageSourceRemark;
    }

    public void setPackageSourceRemark(String packageSourceRemark) {
        this.packageSourceRemark = packageSourceRemark == null ? null : packageSourceRemark.trim();
    }

    public String getPackageSourceDirector() {
        return packageSourceDirector;
    }

    public void setPackageSourceDirector(String packageSourceDirector) {
        this.packageSourceDirector = packageSourceDirector == null ? null : packageSourceDirector.trim();
    }

    public String getPackageSourcePhone() {
        return packageSourcePhone;
    }

    public void setPackageSourcePhone(String packageSourcePhone) {
        this.packageSourcePhone = packageSourcePhone == null ? null : packageSourcePhone.trim();
    }

    public Integer getPackageSourceStatus() {
        return packageSourceStatus;
    }

    public void setPackageSourceStatus(Integer packageSourceStatus) {
        this.packageSourceStatus = packageSourceStatus;
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

    public String getSourcePic() {
        return sourcePic;
    }

    public void setSourcePic(String sourcePic) {
        this.sourcePic = sourcePic == null ? null : sourcePic.trim();
    }
}