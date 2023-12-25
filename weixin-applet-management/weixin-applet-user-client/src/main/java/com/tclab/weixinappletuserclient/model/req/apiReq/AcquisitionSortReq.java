package com.tclab.weixinappletuserclient.model.req.apiReq;

import java.util.ArrayList;
import java.util.List;

public class AcquisitionSortReq {

    private Integer type;

//    private String areaId;

    private String cityName;

    private double longitude;

    private double latitude;

    private Integer serviceType;

    private String queryParam;

    private List<String> packageId = new ArrayList<>();

    private Integer pageNo = 1;

    private Integer pageSize = 3;

    @Override
    public String toString() {
        return "AcquisitionSortReq{" +
                "type=" + type +
                ", cityName='" + cityName + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", serviceType=" + serviceType +
                ", queryParam='" + queryParam + '\'' +
                ", packageId=" + packageId +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

    public List<String> getPackageId() {
        return packageId;
    }

    public void setPackageId(List<String> packageId) {
        this.packageId = packageId;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public Integer getServiceType() {
        return serviceType;
    }

    public void setServiceType(Integer serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

//    public String getAreaId() {
//        return areaId;
//    }
//
//    public void setAreaId(String areaId) {
//        this.areaId = areaId;
//    }


    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
