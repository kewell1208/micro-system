package com.tclab.weixinappletservice.model.result;

public class DoctorRecommendResult {

    private String packageId;

    private String packageName;

    private Long recommendNum;

    @Override
    public String toString() {
        return "DoctorRecommendResult{" +
                "packageId='" + packageId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", recommendNum=" + recommendNum +
                '}';
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

    public Long getRecommendNum() {
        return recommendNum;
    }

    public void setRecommendNum(Long recommendNum) {
        this.recommendNum = recommendNum;
    }
}
