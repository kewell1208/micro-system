package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class LogisticsMessageVo {

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

    private String logisticsArrivedDate;

    @Override
    public String toString() {
        return "LogisticsMessageVo{" +
                "logisticsId='" + logisticsId + '\'' +
                ", logisticsType=" + logisticsType +
                ", sourceId='" + sourceId + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", operatorId='" + operatorId + '\'' +
                ", operatorName='" + operatorName + '\'' +
                ", orderNum=" + orderNum +
                ", logisticsRemark='" + logisticsRemark + '\'' +
                ", logisticsStatus=" + logisticsStatus +
                ", expressName='" + expressName + '\'' +
                ", waybillNo='" + waybillNo + '\'' +
                ", expressImage='" + expressImage + '\'' +
                ", clerkId='" + clerkId + '\'' +
                ", clerkName='" + clerkName + '\'' +
                ", clerkPhone='" + clerkPhone + '\'' +
                ", logisticsArrivedDate='" + logisticsArrivedDate + '\'' +
                '}';
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
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
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
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
        this.logisticsRemark = logisticsRemark;
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
        this.expressName = expressName;
    }

    public String getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(String waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getExpressImage() {
        return expressImage;
    }

    public void setExpressImage(String expressImage) {
        this.expressImage = expressImage;
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public String getClerkPhone() {
        return clerkPhone;
    }

    public void setClerkPhone(String clerkPhone) {
        this.clerkPhone = clerkPhone;
    }

    public String getLogisticsArrivedDate() {
        return logisticsArrivedDate;
    }

    public void setLogisticsArrivedDate(String logisticsArrivedDate) {
        this.logisticsArrivedDate = logisticsArrivedDate;
    }
}
