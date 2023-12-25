package com.tclab.weixinappletuserclient.model.req.apiReq;

import java.util.Date;

public class ParticipantBaseReq {

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

    @Override
    public String toString() {
        return "ParticipantBaseReq{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", participantId='" + participantId + '\'' +
                ", participantName='" + participantName + '\'' +
                ", participantPhone='" + participantPhone + '\'' +
                ", participantSex=" + participantSex +
                ", participantAge=" + participantAge +
                ", participantIdCard='" + participantIdCard + '\'' +
                ", participantRelationship='" + participantRelationship + '\'' +
                ", participantAddress='" + participantAddress + '\'' +
                ", participantMedicalHistory='" + participantMedicalHistory + '\'' +
                ", participantRemark='" + participantRemark + '\'' +
                ", participantRecentAcquisitionDate=" + participantRecentAcquisitionDate +
                ", verifyFlag=" + verifyFlag +
                ", defaultFlag=" + defaultFlag +
                ", delFlag=" + delFlag +
                '}';
    }

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
    }

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
        this.userId = userId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantPhone() {
        return participantPhone;
    }

    public void setParticipantPhone(String participantPhone) {
        this.participantPhone = participantPhone;
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
        this.participantIdCard = participantIdCard;
    }

    public String getParticipantRelationship() {
        return participantRelationship;
    }

    public void setParticipantRelationship(String participantRelationship) {
        this.participantRelationship = participantRelationship;
    }

    public String getParticipantAddress() {
        return participantAddress;
    }

    public void setParticipantAddress(String participantAddress) {
        this.participantAddress = participantAddress;
    }

    public String getParticipantMedicalHistory() {
        return participantMedicalHistory;
    }

    public void setParticipantMedicalHistory(String participantMedicalHistory) {
        this.participantMedicalHistory = participantMedicalHistory;
    }

    public String getParticipantRemark() {
        return participantRemark;
    }

    public void setParticipantRemark(String participantRemark) {
        this.participantRemark = participantRemark;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }
}
