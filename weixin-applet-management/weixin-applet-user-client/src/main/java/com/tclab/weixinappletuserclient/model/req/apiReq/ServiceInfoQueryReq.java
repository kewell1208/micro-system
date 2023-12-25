package com.tclab.weixinappletuserclient.model.req.apiReq;

public class ServiceInfoQueryReq {

    private String userId;

    private Integer defaultFlag;

    @Override
    public String toString() {
        return "ServiceInfoQueryReq{" +
                "userId='" + userId + '\'' +
                ", defaultFlag=" + defaultFlag +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDefaultFlag() {
        return defaultFlag;
    }

    public void setDefaultFlag(Integer defaultFlag) {
        this.defaultFlag = defaultFlag;
    }
}
