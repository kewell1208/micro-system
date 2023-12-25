package com.tclab.weixinappletservice.model.vo.clientVo.shulanVo;

import java.math.BigDecimal;

public class PackageListForShulanVo {

    private String packageId;

    private String packageName;

    private Integer packageRecommendationNum;

    private String packageRemark;

    private BigDecimal packageCurrentPrice;

    private String packageSpecialRequirement;

    private String sourceId;

    private String packageLabel;

    private String clinicalSignificance;

    @Override
    public String toString() {
        return "PackageListForShulanVo{" +
                "packageId='" + packageId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", packageRecommendationNum=" + packageRecommendationNum +
                ", packageRemark='" + packageRemark + '\'' +
                ", packageCurrentPrice=" + packageCurrentPrice +
                ", packageSpecialRequirement='" + packageSpecialRequirement + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", packageLabel='" + packageLabel + '\'' +
                ", clinicalSignificance='" + clinicalSignificance + '\'' +
                '}';
    }

    public String getClinicalSignificance() {
        return clinicalSignificance;
    }

    public void setClinicalSignificance(String clinicalSignificance) {
        this.clinicalSignificance = clinicalSignificance;
    }

    public String getPackageLabel() {
        return packageLabel;
    }

    public void setPackageLabel(String packageLabel) {
        this.packageLabel = packageLabel;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
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

    public Integer getPackageRecommendationNum() {
        return packageRecommendationNum;
    }

    public void setPackageRecommendationNum(Integer packageRecommendationNum) {
        this.packageRecommendationNum = packageRecommendationNum;
    }

    public String getPackageRemark() {
        return packageRemark;
    }

    public void setPackageRemark(String packageRemark) {
        this.packageRemark = packageRemark;
    }

    public BigDecimal getPackageCurrentPrice() {
        return packageCurrentPrice;
    }

    public void setPackageCurrentPrice(BigDecimal packageCurrentPrice) {
        this.packageCurrentPrice = packageCurrentPrice;
    }

    public String getPackageSpecialRequirement() {
        return packageSpecialRequirement;
    }

    public void setPackageSpecialRequirement(String packageSpecialRequirement) {
        this.packageSpecialRequirement = packageSpecialRequirement;
    }
}
