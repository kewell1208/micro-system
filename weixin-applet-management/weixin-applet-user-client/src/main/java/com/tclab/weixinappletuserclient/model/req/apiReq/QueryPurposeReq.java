package com.tclab.weixinappletuserclient.model.req.apiReq;

public class QueryPurposeReq {

    private String catalogId;

    private String purposeId;

    private String sourceId;

    @Override
    public String toString() {
        return "QueryPurposeReq{" +
                "catalogId='" + catalogId + '\'' +
                ", purposeId='" + purposeId + '\'' +
                ", sourceId='" + sourceId + '\'' +
                '}';
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(String catalogId) {
        this.catalogId = catalogId;
    }

    public String getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(String purposeId) {
        this.purposeId = purposeId;
    }
}
