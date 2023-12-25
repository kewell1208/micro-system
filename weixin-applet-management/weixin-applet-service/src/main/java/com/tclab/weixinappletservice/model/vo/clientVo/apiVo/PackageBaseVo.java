package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;

public class PackageBaseVo {

    private int num;

    private String packageId;

    private String packageName;

    private String packageRemark;

    private String packageLogo;

    private BigDecimal packagePrimePrice;

    private BigDecimal packageCurrentPrice;

    private String packageSpecialRequirement;

    private String packageMessage;

    private String packageLabel;

    private Integer packageRecommendation;

    private Integer packageReportType;

    private BigDecimal packageReportCharge;

    private String packageSourceId;

    private String clinicalSignificance;

    private Integer packagePriority;

    private Integer logoForm;

    private String sourcePic;

    public String getSourcePic() {
        return sourcePic;
    }

    public void setSourcePic(String sourcePic) {
        this.sourcePic = sourcePic;
    }

    public Integer getLogoForm() {
        return logoForm;
    }

    public void setLogoForm(Integer logoForm) {
        this.logoForm = logoForm;
    }

    public Integer getPackagePriority() {
        return packagePriority;
    }

    public void setPackagePriority(Integer packagePriority) {
        this.packagePriority = packagePriority;
    }

    public String getClinicalSignificance() {
        return clinicalSignificance;
    }

    public void setClinicalSignificance(String clinicalSignificance) {
        this.clinicalSignificance = clinicalSignificance;
    }

    public String getPackageSourceId() {
        return packageSourceId;
    }

    public void setPackageSourceId(String packageSourceId) {
        this.packageSourceId = packageSourceId;
    }

    public Integer getPackageReportType() {
        return packageReportType;
    }

    public void setPackageReportType(Integer packageReportType) {
        this.packageReportType = packageReportType;
    }

    public BigDecimal getPackageReportCharge() {
        return packageReportCharge;
    }

    public void setPackageReportCharge(BigDecimal packageReportCharge) {
        this.packageReportCharge = packageReportCharge;
    }

    public String getPackageLogo() {
        return packageLogo;
    }

    public void setPackageLogo(String packageLogo) {
        this.packageLogo = packageLogo;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPackageLabel() {
        return packageLabel;
    }

    public void setPackageLabel(String packageLabel) {
        this.packageLabel = packageLabel;
    }

    public Integer getPackageRecommendation() {
        return packageRecommendation;
    }

    public void setPackageRecommendation(Integer packageRecommendation) {
        this.packageRecommendation = packageRecommendation;
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

    public String getPackageRemark() {
        return packageRemark;
    }

    public void setPackageRemark(String packageRemark) {
        this.packageRemark = packageRemark;
    }

    public BigDecimal getPackagePrimePrice() {
        return packagePrimePrice;
    }

    public void setPackagePrimePrice(BigDecimal packagePrimePrice) {
        this.packagePrimePrice = packagePrimePrice;
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

    public String getPackageMessage() {
        return packageMessage;
    }

    public void setPackageMessage(String packageMessage) {
        this.packageMessage = packageMessage;
    }
}
