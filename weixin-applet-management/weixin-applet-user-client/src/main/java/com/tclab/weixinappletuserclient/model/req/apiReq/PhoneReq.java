package com.tclab.weixinappletuserclient.model.req.apiReq;

public class PhoneReq {

    private String phone;

    @Override
    public String toString() {
        return "PhoneReq{" +
                "phone='" + phone + '\'' +
                '}';
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
