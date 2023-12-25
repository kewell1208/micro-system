package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AppletInterpret {
    private Integer id;

    private String interpretId;

    private String imRecordId;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private String doctorId;

    private String interpretImg;

    private String interpretContent;

    private String participantDiagnose;

    private Date interpretDate;

    private Integer interpretType;

    private BigDecimal interpretCost;

    private Date createDate;

    private Date updateDate;

    private Integer delFlag;

    private String participantDescribe;

    private String participantImg;

    private Integer interpretStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInterpretId() {
        return interpretId;
    }

    public void setInterpretId(String interpretId) {
        this.interpretId = interpretId == null ? null : interpretId.trim();
    }

    public String getImRecordId() {
        return imRecordId;
    }

    public void setImRecordId(String imRecordId) {
        this.imRecordId = imRecordId == null ? null : imRecordId.trim();
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

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getInterpretImg() {
        return interpretImg;
    }

    public void setInterpretImg(String interpretImg) {
        this.interpretImg = interpretImg == null ? null : interpretImg.trim();
    }

    public String getInterpretContent() {
        return interpretContent;
    }

    public void setInterpretContent(String interpretContent) {
        this.interpretContent = interpretContent == null ? null : interpretContent.trim();
    }

    public String getParticipantDiagnose() {
        return participantDiagnose;
    }

    public void setParticipantDiagnose(String participantDiagnose) {
        this.participantDiagnose = participantDiagnose == null ? null : participantDiagnose.trim();
    }

    public Date getInterpretDate() {
        return interpretDate;
    }

    public void setInterpretDate(Date interpretDate) {
        this.interpretDate = interpretDate;
    }

    public Integer getInterpretType() {
        return interpretType;
    }

    public void setInterpretType(Integer interpretType) {
        this.interpretType = interpretType;
    }

    public BigDecimal getInterpretCost() {
        return interpretCost;
    }

    public void setInterpretCost(BigDecimal interpretCost) {
        this.interpretCost = interpretCost;
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

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getParticipantDescribe() {
        return participantDescribe;
    }

    public void setParticipantDescribe(String participantDescribe) {
        this.participantDescribe = participantDescribe == null ? null : participantDescribe.trim();
    }

    public String getParticipantImg() {
        return participantImg;
    }

    public void setParticipantImg(String participantImg) {
        this.participantImg = participantImg == null ? null : participantImg.trim();
    }

    public Integer getInterpretStatus() {
        return interpretStatus;
    }

    public void setInterpretStatus(Integer interpretStatus) {
        this.interpretStatus = interpretStatus;
    }
}