package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class PackageForParticipantVo {

    private String orderNo;

    private String goodNo;

    private String packageId;

    private String packageEquipment;

    private String packageSpecialRequirement;

    private String packageRemark;

    private String barcode;

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageEquipment() {
        return packageEquipment;
    }

    public void setPackageEquipment(String packageEquipment) {
        this.packageEquipment = packageEquipment;
    }

    public String getPackageSpecialRequirement() {
        return packageSpecialRequirement;
    }

    public void setPackageSpecialRequirement(String packageSpecialRequirement) {
        this.packageSpecialRequirement = packageSpecialRequirement;
    }

    public String getPackageRemark() {
        return packageRemark;
    }

    public void setPackageRemark(String packageRemark) {
        this.packageRemark = packageRemark;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }
}
