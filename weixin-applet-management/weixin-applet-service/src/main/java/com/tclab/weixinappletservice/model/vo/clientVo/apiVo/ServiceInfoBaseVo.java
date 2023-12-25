package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class ServiceInfoBaseVo {

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

    public String getAddressProvince() {
        return addressProvince;
    }

    public void setAddressProvince(String addressProvince) {
        this.addressProvince = addressProvince;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressRegion() {
        return addressRegion;
    }

    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

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
        this.serviceInfoId = serviceInfoId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getServiceInfoAddress() {
        return serviceInfoAddress;
    }

    public void setServiceInfoAddress(String serviceInfoAddress) {
        this.serviceInfoAddress = serviceInfoAddress;
    }

    public String getServiceInfoPerson() {
        return serviceInfoPerson;
    }

    public void setServiceInfoPerson(String serviceInfoPerson) {
        this.serviceInfoPerson = serviceInfoPerson;
    }

    public String getServiceInfoPhone() {
        return serviceInfoPhone;
    }

    public void setServiceInfoPhone(String serviceInfoPhone) {
        this.serviceInfoPhone = serviceInfoPhone;
    }

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
    }
}
