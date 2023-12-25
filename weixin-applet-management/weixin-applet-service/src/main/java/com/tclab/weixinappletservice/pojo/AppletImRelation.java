package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletImRelation {
    private Integer id;

    private String doctorId;

    private String participantId;

    private String participantComment;

    private Double participantScore;

    private Integer participantAttentionFlag;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private String userId;

    private String userConversationid;

    private String doctorConversationid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId == null ? null : participantId.trim();
    }

    public String getParticipantComment() {
        return participantComment;
    }

    public void setParticipantComment(String participantComment) {
        this.participantComment = participantComment == null ? null : participantComment.trim();
    }

    public Double getParticipantScore() {
        return participantScore;
    }

    public void setParticipantScore(Double participantScore) {
        this.participantScore = participantScore;
    }

    public Integer getParticipantAttentionFlag() {
        return participantAttentionFlag;
    }

    public void setParticipantAttentionFlag(Integer participantAttentionFlag) {
        this.participantAttentionFlag = participantAttentionFlag;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserConversationid() {
        return userConversationid;
    }

    public void setUserConversationid(String userConversationid) {
        this.userConversationid = userConversationid == null ? null : userConversationid.trim();
    }

    public String getDoctorConversationid() {
        return doctorConversationid;
    }

    public void setDoctorConversationid(String doctorConversationid) {
        this.doctorConversationid = doctorConversationid == null ? null : doctorConversationid.trim();
    }
}