package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.model.result.GoodInfoByNoResult;

import java.util.ArrayList;
import java.util.List;

public class ParticipantOrderAndPackageVo {

    private String orderNo;

    private String orderTime;

    private String participantId;

    private String idCard;

    private String participantName;

    private String telephone;

    private Integer sex;

    private Integer age;

    private String participantRelationship;

    private String participantAddress;

    private String medicalHistory;

    private String feedback;

    private Integer delFlag;

    private Integer orderExceptionStatus;

    private Integer orderCancelStatus;

    private Integer orderStatus;

    private Integer verifyStatus;

    private Integer payStatus;

    private Integer refundStatus;

    private Integer logisticsStatus;

    private Integer writeOffStatus;

    private List<GoodInfoByNoResult> packages = new ArrayList<>();

    public List<GoodInfoByNoResult> getPackages() {
        return packages;
    }

    public void setPackages(List<GoodInfoByNoResult> packages) {
        this.packages = packages;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Integer getOrderExceptionStatus() {
        return orderExceptionStatus;
    }

    public void setOrderExceptionStatus(Integer orderExceptionStatus) {
        this.orderExceptionStatus = orderExceptionStatus;
    }

    public Integer getOrderCancelStatus() {
        return orderCancelStatus;
    }

    public void setOrderCancelStatus(Integer orderCancelStatus) {
        this.orderCancelStatus = orderCancelStatus;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Integer payStatus) {
        this.payStatus = payStatus;
    }

    public Integer getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(Integer refundStatus) {
        this.refundStatus = refundStatus;
    }

    public Integer getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public Integer getWriteOffStatus() {
        return writeOffStatus;
    }

    public void setWriteOffStatus(Integer writeOffStatus) {
        this.writeOffStatus = writeOffStatus;
    }
}
