package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletImRecommendList {
    private Integer id;

    private String imRecommendListId;

    private String doctorId;

    private String doctorName;

    private String userId;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private Integer participantSex;

    private Integer participantAge;

    private String participantMedicalHistory;

    private String participantIdCard;

    private Integer reviewType;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private String orderNo;

    private Integer recommendStatus;

    private String recommendRemark;

    private String imrecordId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImRecommendListId() {
        return imRecommendListId;
    }

    public void setImRecommendListId(String imRecommendListId) {
        this.imRecommendListId = imRecommendListId == null ? null : imRecommendListId.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
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

    public String getParticipantMedicalHistory() {
        return participantMedicalHistory;
    }

    public void setParticipantMedicalHistory(String participantMedicalHistory) {
        this.participantMedicalHistory = participantMedicalHistory == null ? null : participantMedicalHistory.trim();
    }

    public String getParticipantIdCard() {
        return participantIdCard;
    }

    public void setParticipantIdCard(String participantIdCard) {
        this.participantIdCard = participantIdCard == null ? null : participantIdCard.trim();
    }

    public Integer getReviewType() {
        return reviewType;
    }

    public void setReviewType(Integer reviewType) {
        this.reviewType = reviewType;
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

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public String getRecommendRemark() {
        return recommendRemark;
    }

    public void setRecommendRemark(String recommendRemark) {
        this.recommendRemark = recommendRemark == null ? null : recommendRemark.trim();
    }

    public String getImrecordId() {
        return imrecordId;
    }

    public void setImrecordId(String imrecordId) {
        this.imrecordId = imrecordId == null ? null : imrecordId.trim();
    }
}