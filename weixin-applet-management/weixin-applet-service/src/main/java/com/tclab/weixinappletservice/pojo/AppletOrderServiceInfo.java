package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletOrderServiceInfo {
    private Integer id;

    private String serviceInfoId;

    private String userId;

    private String addressProvince;

    private String addressCity;

    private String addressRegion;

    private String serviceInfoAddress;

    private String serviceInfoPerson;

    private String serviceInfoPhone;

    private String zipCode;

    private Integer defaultFlag;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceInfoId() {
        return serviceInfoId;
    }

    public void setServiceInfoId(String serviceInfoId) {
        this.serviceInfoId = serviceInfoId == null ? null : serviceInfoId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince == null ? null : addressProvince.trim();
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion == null ? null : addressRegion.trim();
    }

    public String getServiceInfoAddress() {
        return serviceInfoAddress;
    }

    public void setServiceInfoAddress(String serviceInfoAddress) {
        this.serviceInfoAddress = serviceInfoAddress == null ? null : serviceInfoAddress.trim();
    }

    public String getServiceInfoPerson() {
        return serviceInfoPerson;
    }

    public void setServiceInfoPerson(String serviceInfoPerson) {
        this.serviceInfoPerson = serviceInfoPerson == null ? null : serviceInfoPerson.trim();
    }

    public String getServiceInfoPhone() {
        return serviceInfoPhone;
    }

    public void setServiceInfoPhone(String serviceInfoPhone) {
        this.serviceInfoPhone = serviceInfoPhone == null ? null : serviceInfoPhone.trim();
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
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