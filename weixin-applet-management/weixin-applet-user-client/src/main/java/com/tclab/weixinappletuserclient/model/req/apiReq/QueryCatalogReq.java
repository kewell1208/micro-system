package com.tclab.weixinappletuserclient.model.req.apiReq;

public class QueryCatalogReq {

    private String sourceId;

    private String sourceName;

    @Override
    public String toString() {
        return "QueryCatalogReq{" +
                "sourceId='" + sourceId + '\'' +
                ", sourceName='" + sourceName + '\'' +
                '}';
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }
}
