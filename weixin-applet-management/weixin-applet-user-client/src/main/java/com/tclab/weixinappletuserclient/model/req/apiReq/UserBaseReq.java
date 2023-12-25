package com.tclab.weixinappletuserclient.model.req.apiReq;

public class UserBaseReq {

    private String userId;

    private String userName;

    private String userIdCard;

    private String userPhone;

    private Integer sex;

    private String userPassword;

    private String openid;

    @Override
    public String toString() {
        return "UserBaseReq{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userIdCard='" + userIdCard + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", sex=" + sex +
                ", userPassword='" + userPassword + '\'' +
                ", openid='" + openid + '\'' +
                '}';
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
