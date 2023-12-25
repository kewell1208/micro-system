package com.tclab.weixinappletuserclient.model.req.apiReq;

public class NoReq {

    private String userId;

    private String orderNo;

    private String participantId;

    private String serviceInfoId;

    private String password;

    private String phone;

    @Override
    public String toString() {
        return "NoReq{" +
                "userId='" + userId + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", participantId='" + participantId + '\'' +
                ", serviceInfoId='" + serviceInfoId + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getServiceInfoId() {
        return serviceInfoId;
    }

    public void setServiceInfoId(String serviceInfoId) {
        this.serviceInfoId = serviceInfoId;
    }
}
