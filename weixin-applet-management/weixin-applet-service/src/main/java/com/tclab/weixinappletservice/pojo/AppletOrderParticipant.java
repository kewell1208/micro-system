package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletOrderParticipant {
    private Integer id;

    private String userId;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private Integer participantSex;

    private Integer participantAge;

    private String participantIdCard;

    private String participantRelationship;

    private String participantAddress;

    private String participantMedicalHistory;

    private String participantRemark;

    private Date participantRecentAcquisitionDate;

    private Integer verifyFlag;

    private Integer defaultFlag;

    private Integer delFlag;

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

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId == null ? null : participantId.trim();
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

    public Integer getParticipantSex() {
        return participantSex;
    }

    public void setParticipantSex(Integer participantSex) {
        this.participantSex = participantSex;
    }

    public Integer getParticipantAge() {
        return participantAge;
    }

    public void setParticipantAge(Integer participantAge) {
        this.participantAge = participantAge;
    }

    public String getParticipantIdCard() {
        return participantIdCard;
    }

    public void setParticipantIdCard(String participantIdCard) {
        this.participantIdCard = participantIdCard == null ? null : participantIdCard.trim();
    }

    public String getParticipantRelationship() {
        return participantRelationship;
    }

    public void setParticipantRelationship(String participantRelationship) {
        this.participantRelationship = participantRelationship == null ? null : participantRelationship.trim();
    }

    public String getParticipantAddress() {
        return participantAddress;
    }

    public void setParticipantAddress(String participantAddress) {
        this.participantAddress = participantAddress == null ? null : participantAddress.trim();
    }

    public String getParticipantMedicalHistory() {
        return participantMedicalHistory;
    }

    public void setParticipantMedicalHistory(String participantMedicalHistory) {
        this.participantMedicalHistory = participantMedicalHistory == null ? null : participantMedicalHistory.trim();
    }

    public String getParticipantRemark() {
        return participantRemark;
    }

    public void setParticipantRemark(String participantRemark) {
        this.participantRemark = participantRemark == null ? null : participantRemark.trim();
    }

    public Date getParticipantRecentAcquisitionDate() {
        return participantRecentAcquisitionDate;
    }

    public void setParticipantRecentAcquisitionDate(Date participantRecentAcquisitionDate) {
        this.participantRecentAcquisitionDate = participantRecentAcquisitionDate;
    }

    public Integer getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(Integer verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
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