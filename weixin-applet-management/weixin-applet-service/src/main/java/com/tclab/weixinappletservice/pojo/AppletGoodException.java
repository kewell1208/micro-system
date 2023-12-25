package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletGoodException {
    private Integer id;

    private String goodNo;

    private String orderNo;

    private Date goodApplyDate;

    private String packageId;

    private String packageName;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private Integer exceptionReason;

    private Integer exceptionSolution;

    private Integer exceptionStatus;

    private Date exceptionSolveTime;

    private Date goodDelayApplyDate;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo == null ? null : goodNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Date getGoodApplyDate() {
        return goodApplyDate;
    }

    public void setGoodApplyDate(Date goodApplyDate) {
        this.goodApplyDate = goodApplyDate;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId == null ? null : packageId.trim();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
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

    public Integer getExceptionReason() {
        return exceptionReason;
    }

    public void setExceptionReason(Integer exceptionReason) {
        this.exceptionReason = exceptionReason;
    }

    public Integer getExceptionSolution() {
        return exceptionSolution;
    }

    public void setExceptionSolution(Integer exceptionSolution) {
        this.exceptionSolution = exceptionSolution;
    }

    public Integer getExceptionStatus() {
        return exceptionStatus;
    }

    public void setExceptionStatus(Integer exceptionStatus) {
        this.exceptionStatus = exceptionStatus;
    }

    public Date getExceptionSolveTime() {
        return exceptionSolveTime;
    }

    public void setExceptionSolveTime(Date exceptionSolveTime) {
        this.exceptionSolveTime = exceptionSolveTime;
    }

    public Date getGoodDelayApplyDate() {
        return goodDelayApplyDate;
    }

    public void setGoodDelayApplyDate(Date goodDelayApplyDate) {
        this.goodDelayApplyDate = goodDelayApplyDate;
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