package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class OrderForDayAndTimeVo {

    private String orderNo;

    private String packageName;

    private String userName;

    private String participantName;

    private String participantPhone;

    private String appointmentDate;

    private String appointmentTime;

//    private Date orderApplyDate;

    private String orderApplyDate;

    private String orderCurrentApplyDate;

    private String orderCompleteApplyDate;

    public String getOrderCompleteApplyDate() {
        return orderCompleteApplyDate;
    }

    public void setOrderCompleteApplyDate(String orderCompleteApplyDate) {
        this.orderCompleteApplyDate = orderCompleteApplyDate;
    }

    //    public Date getOrderApplyDate() {
//        return orderApplyDate;
//    }
//
//    public void setOrderApplyDate(Date orderApplyDate) {
//        this.orderApplyDate = orderApplyDate;
//    }


    public String getOrderCurrentApplyDate() {
        return orderCurrentApplyDate;
    }

    public void setOrderCurrentApplyDate(String orderCurrentApplyDate) {
        this.orderCurrentApplyDate = orderCurrentApplyDate;
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

    public String getOrderApplyDate() {
        return orderApplyDate;
    }

    public void setOrderApplyDate(String orderApplyDate) {
        this.orderApplyDate = orderApplyDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}
