package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletLogisticsThirdSelf {
    private Integer id;

    private String thirdLogisticsId;

    private String orderNo;

    private String logisticsGood;

    private String logisticsRemark;

    private Integer logisticsOrderNum;

    private Integer logisticsStatus;

    private String waybillNo;

    private String expressName;

    private String expressImage;

    private Date logisticsArrivedDate;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThirdLogisticsId() {
        return thirdLogisticsId;
    }

    public void setThirdLogisticsId(String thirdLogisticsId) {
        this.thirdLogisticsId = thirdLogisticsId == null ? null : thirdLogisticsId.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getLogisticsGood() {
        return logisticsGood;
    }

    public void setLogisticsGood(String logisticsGood) {
        this.logisticsGood = logisticsGood == null ? null : logisticsGood.trim();
    }

    public String getLogisticsRemark() {
        return logisticsRemark;
    }

    public void setLogisticsRemark(String logisticsRemark) {
        this.logisticsRemark = logisticsRemark == null ? null : logisticsRemark.trim();
    }

    public Integer getLogisticsOrderNum() {
        return logisticsOrderNum;
    }

    public void setLogisticsOrderNum(Integer logisticsOrderNum) {
        this.logisticsOrderNum = logisticsOrderNum;
    }

    public Integer getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo == null ? null : waybillNo.trim();
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getExpressImage() {
        return expressImage;
    }

    public void setExpressImage(String expressImage) {
        this.expressImage = expressImage == null ? null : expressImage.trim();
    }

    public Date getLogisticsArrivedDate() {
        return logisticsArrivedDate;
    }

    public void setLogisticsArrivedDate(Date logisticsArrivedDate) {
        this.logisticsArrivedDate = logisticsArrivedDate;
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