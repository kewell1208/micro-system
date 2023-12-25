package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletGoodProcessLog {
    private Integer id;

    private String userId;

    private String userName;

    private String userPhone;

    private Integer participantId;

    private String participantName;

    private String participantPhone;

    private String orderNo;

    private String goodNo;

    private Integer goodLastStatus;

    private Integer goodCurrentStatus;

    private String processRemark;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public Integer getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Integer participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName == null ? null : participantName.trim();
    }

    public String getParticipantPhone() {
        return participantPhone;
    }

    public void setParticipantPhone(String participantPhone) {
        this.participantPhone = participantPhone == null ? null : participantPhone.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo == null ? null : goodNo.trim();
    }

    public Integer getGoodLastStatus() {
        return goodLastStatus;
    }

    public void setGoodLastStatus(Integer goodLastStatus) {
        this.goodLastStatus = goodLastStatus;
    }

    public Integer getGoodCurrentStatus() {
        return goodCurrentStatus;
    }

    public void setGoodCurrentStatus(Integer goodCurrentStatus) {
        this.goodCurrentStatus = goodCurrentStatus;
    }

    public String getProcessRemark() {
        return processRemark;
    }

    public void setProcessRemark(String processRemark) {
        this.processRemark = processRemark == null ? null : processRemark.trim();
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