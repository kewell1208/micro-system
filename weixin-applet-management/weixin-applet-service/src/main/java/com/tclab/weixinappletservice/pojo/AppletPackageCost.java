package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AppletPackageCost {
    private Integer id;

    private String packageId;

    private String acquisitionId;

    private String areaId;

    private Integer commissionType;

    private BigDecimal costAcquisitionCharge;

    private Float costStaffCommission;

    private String costDepartmentCommission;

    private Float costOrganizationCommission;

    private Float platformCommission;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId == null ? null : packageId.trim();
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId == null ? null : acquisitionId.trim();
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public Integer getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(Integer commissionType) {
        this.commissionType = commissionType;
    }

    public BigDecimal getCostAcquisitionCharge() {
        return costAcquisitionCharge;
    }

    public void setCostAcquisitionCharge(BigDecimal costAcquisitionCharge) {
        this.costAcquisitionCharge = costAcquisitionCharge;
    }

    public Float getCostStaffCommission() {
        return costStaffCommission;
    }

    public void setCostStaffCommission(Float costStaffCommission) {
        this.costStaffCommission = costStaffCommission;
    }

    public String getCostDepartmentCommission() {
        return costDepartmentCommission;
    }

    public void setCostDepartmentCommission(String costDepartmentCommission) {
        this.costDepartmentCommission = costDepartmentCommission == null ? null : costDepartmentCommission.trim();
    }

    public Float getCostOrganizationCommission() {
        return costOrganizationCommission;
    }

    public void setCostOrganizationCommission(Float costOrganizationCommission) {
        this.costOrganizationCommission = costOrganizationCommission;
    }

    public Float getPlatformCommission() {
        return platformCommission;
    }

    public void setPlatformCommission(Float platformCommission) {
        this.platformCommission = platformCommission;
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