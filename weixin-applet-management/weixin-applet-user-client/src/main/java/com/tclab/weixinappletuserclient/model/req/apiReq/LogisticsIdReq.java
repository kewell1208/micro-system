package com.tclab.weixinappletuserclient.model.req.apiReq;

public class LogisticsIdReq {

    private String logisticsId;

    @Override
    public String toString() {
        return "LogisticsIdReq{" +
                "logisticsId='" + logisticsId + '\'' +
                '}';
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }
}
