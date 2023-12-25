package com.tclab.weixinappletuserclient.model.req.apiReq;

import java.util.ArrayList;
import java.util.List;

public class LogisticsActionReq {

    private String logisticsId;

    private Integer logisticsType = 2;

    private Integer logisticsAction;

    private List<String> orderNos = new ArrayList<>();

    @Override
    public String toString() {
        return "LogisticsActionReq{" +
                "logisticsId='" + logisticsId + '\'' +
                ", logisticsType=" + logisticsType +
                ", logisticsAction=" + logisticsAction +
                ", orderNos=" + orderNos +
                '}';
    }

    public String getLogisticsId() {
        return logisticsId;
    }

    public void setLogisticsId(String logisticsId) {
        this.logisticsId = logisticsId;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public Integer getLogisticsAction() {
        return logisticsAction;
    }

    public void setLogisticsAction(Integer logisticsAction) {
        this.logisticsAction = logisticsAction;
    }

    public List<String> getOrderNos() {
        return orderNos;
    }

    public void setOrderNos(List<String> orderNos) {
        this.orderNos = orderNos;
    }
}
