package com.tclab.weixinappletservice.model.query;

import java.util.ArrayList;
import java.util.List;

public class QueryDoctorRecommendNumParam {

    private String doctorPhone;

    private String packageName;

    private String packageId;

    private String Month;

    private String queryParam;

    private Integer limitNum = 20;

    @Override
    public String toString() {
        return "QueryDoctorRecommendNumParam{" +
                "doctorPhone='" + doctorPhone + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageId='" + packageId + '\'' +
                ", Month='" + Month + '\'' +
                ", queryParam='" + queryParam + '\'' +
                ", limitNum=" + limitNum +
                ", goodStatusList=" + goodStatusList +
                '}';
    }

    private List<Integer> goodStatusList = new ArrayList<>();

    public List<Integer> getGoodStatusList() {
        return goodStatusList;
    }

    public void setGoodStatusList(List<Integer> goodStatusList) {
        this.goodStatusList = goodStatusList;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }
}
