package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AppletPackage {
    private Integer id;

    private String packageId;

    private String labCode;

    private String packageName;

    private String packageLogo;

    private String packageInfo;

    private String packageLabel;

    private Integer packageRecommendation;

    private Integer packagePriority;

    private String packageCatalogId;

    private String packageMessage;

    private String packagePurposeId;

    private String packagePopulationId;

    private String populationName;

    private String packageSourceId;

    private String packageSourceName;

    private String packageRemark;

    private BigDecimal packagePrimePrice;

    private BigDecimal packageCurrentPrice;

    private Integer packageStatus;

    private Integer packageCollectType;

    private String packageSamplePic;

    private String packageStep;

    private Integer packageReportType;

    private BigDecimal packageReportCharge;

    private String packageReportTime;

    private String reportTimeDesc;

    private String sampleTypeName;

    private Integer sampleType;

    private String packageSpecialRequirement;

    private String packageEquipment;

    private String storageCondition;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private String testObjectId;

    private String clinicalSignificance;

    private String labGroup;

    private String priceCode;

    private Integer pdfNum;

    private Integer logoForm;

    private Integer packageType;

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

    public String getLabCode() {
        return labCode;
    }

    public void setLabCode(String labCode) {
        this.labCode = labCode == null ? null : labCode.trim();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public String getPackageLogo() {
        return packageLogo;
    }

    public void setPackageLogo(String packageLogo) {
        this.packageLogo = packageLogo == null ? null : packageLogo.trim();
    }

    public String getPackageInfo() {
        return packageInfo;
    }

    public void setPackageInfo(String packageInfo) {
        this.packageInfo = packageInfo == null ? null : packageInfo.trim();
    }

    public String getPackageLabel() {
        return packageLabel;
    }

    public void setPackageLabel(String packageLabel) {
        this.packageLabel = packageLabel == null ? null : packageLabel.trim();
    }

    public Integer getPackageRecommendation() {
        return packageRecommendation;
    }

    public void setPackageRecommendation(Integer packageRecommendation) {
        this.packageRecommendation = packageRecommendation;
    }

    public Integer getPackagePriority() {
        return packagePriority;
    }

    public void setPackagePriority(Integer packagePriority) {
        this.packagePriority = packagePriority;
    }

    public String getPackageCatalogId() {
        return packageCatalogId;
    }

    public void setPackageCatalogId(String packageCatalogId) {
        this.packageCatalogId = packageCatalogId == null ? null : packageCatalogId.trim();
    }

    public String getPackageMessage() {
        return packageMessage;
    }

    public void setPackageMessage(String packageMessage) {
        this.packageMessage = packageMessage == null ? null : packageMessage.trim();
    }

    public String getPackagePurposeId() {
        return packagePurposeId;
    }

    public void setPackagePurposeId(String packagePurposeId) {
        this.packagePurposeId = packagePurposeId == null ? null : packagePurposeId.trim();
    }

    public String getPackagePopulationId() {
        return packagePopulationId;
    }

    public void setPackagePopulationId(String packagePopulationId) {
        this.packagePopulationId = packagePopulationId == null ? null : packagePopulationId.trim();
    }

    public String getPopulationName() {
        return populationName;
    }

    public void setPopulationName(String populationName) {
        this.populationName = populationName == null ? null : populationName.trim();
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

    public String getPackageRemark() {
        return packageRemark;
    }

    public void setPackageRemark(String packageRemark) {
        this.packageRemark = packageRemark == null ? null : packageRemark.trim();
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

    public Integer getPackageStatus() {
        return packageStatus;
    }

    public void setPackageStatus(Integer packageStatus) {
        this.packageStatus = packageStatus;
    }

    public Integer getPackageCollectType() {
        return packageCollectType;
    }

    public void setPackageCollectType(Integer packageCollectType) {
        this.packageCollectType = packageCollectType;
    }

    public String getPackageSamplePic() {
        return packageSamplePic;
    }

    public void setPackageSamplePic(String packageSamplePic) {
        this.packageSamplePic = packageSamplePic == null ? null : packageSamplePic.trim();
    }

    public String getPackageStep() {
        return packageStep;
    }

    public void setPackageStep(String packageStep) {
        this.packageStep = packageStep == null ? null : packageStep.trim();
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

    public String getPackageReportTime() {
        return packageReportTime;
    }

    public void setPackageReportTime(String packageReportTime) {
        this.packageReportTime = packageReportTime == null ? null : packageReportTime.trim();
    }

    public String getReportTimeDesc() {
        return reportTimeDesc;
    }

    public void setReportTimeDesc(String reportTimeDesc) {
        this.reportTimeDesc = reportTimeDesc == null ? null : reportTimeDesc.trim();
    }

    public String getSampleTypeName() {
        return sampleTypeName;
    }

    public void setSampleTypeName(String sampleTypeName) {
        this.sampleTypeName = sampleTypeName == null ? null : sampleTypeName.trim();
    }

    public Integer getSampleType() {
        return sampleType;
    }

    public void setSampleType(Integer sampleType) {
        this.sampleType = sampleType;
    }

    public String getPackageSpecialRequirement() {
        return packageSpecialRequirement;
    }

    public void setPackageSpecialRequirement(String packageSpecialRequirement) {
        this.packageSpecialRequirement = packageSpecialRequirement == null ? null : packageSpecialRequirement.trim();
    }

    public String getPackageEquipment() {
        return packageEquipment;
    }

    public void setPackageEquipment(String packageEquipment) {
        this.packageEquipment = packageEquipment == null ? null : packageEquipment.trim();
    }

    public String getStorageCondition() {
        return storageCondition;
    }

    public void setStorageCondition(String storageCondition) {
        this.storageCondition = storageCondition == null ? null : storageCondition.trim();
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

    public String getTestObjectId() {
        return testObjectId;
    }

    public void setTestObjectId(String testObjectId) {
        this.testObjectId = testObjectId == null ? null : testObjectId.trim();
    }

    public String getClinicalSignificance() {
        return clinicalSignificance;
    }

    public void setClinicalSignificance(String clinicalSignificance) {
        this.clinicalSignificance = clinicalSignificance == null ? null : clinicalSignificance.trim();
    }

    public String getLabGroup() {
        return labGroup;
    }

    public void setLabGroup(String labGroup) {
        this.labGroup = labGroup == null ? null : labGroup.trim();
    }

    public String getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(String priceCode) {
        this.priceCode = priceCode == null ? null : priceCode.trim();
    }

    public Integer getPdfNum() {
        return pdfNum;
    }

    public void setPdfNum(Integer pdfNum) {
        this.pdfNum = pdfNum;
    }

    public Integer getLogoForm() {
        return logoForm;
    }

    public void setLogoForm(Integer logoForm) {
        this.logoForm = logoForm;
    }

    public Integer getPackageType() {
        return packageType;
    }

    public void setPackageType(Integer packageType) {
        this.packageType = packageType;
    }
}