package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletLogistics {
    private Integer id;

    private String logisticsId;

    private Integer logisticsType;

    private String sourceId;

    private String sourceName;

    private String operatorId;

    private String operatorName;

    private Integer orderNum;

    private String logisticsRemark;

    private Integer logisticsStatus;

    private String expressName;

    private String waybillNo;

    private String expressImage;

    private String clerkId;

    private String clerkName;

    private String clerkPhone;

    private Date logisticsApplyDate;

    private Date logisticsPickDate;

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

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId == null ? null : logisticsId.trim();
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId == null ? null : sourceId.trim();
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName == null ? null : sourceName.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getLogisticsRemark() {
        return logisticsRemark;
    }

    public void setLogisticsRemark(String logisticsRemark) {
        this.logisticsRemark = logisticsRemark == null ? null : logisticsRemark.trim();
    }

    public Integer getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName == null ? null : expressName.trim();
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo == null ? null : waybillNo.trim();
    }

    public String getExpressImage() {
        return expressImage;
    }

    public void setExpressImage(String expressImage) {
        this.expressImage = expressImage == null ? null : expressImage.trim();
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId == null ? null : clerkId.trim();
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName == null ? null : clerkName.trim();
    }

    public String getClerkPhone() {
        return clerkPhone;
    }

    public void setClerkPhone(String clerkPhone) {
        this.clerkPhone = clerkPhone == null ? null : clerkPhone.trim();
    }

    public Date getLogisticsApplyDate() {
        return logisticsApplyDate;
    }

    public void setLogisticsApplyDate(Date logisticsApplyDate) {
        this.logisticsApplyDate = logisticsApplyDate;
    }

    public Date getLogisticsPickDate() {
        return logisticsPickDate;
    }

    public void setLogisticsPickDate(Date logisticsPickDate) {
        this.logisticsPickDate = logisticsPickDate;
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