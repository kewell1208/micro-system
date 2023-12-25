package com.tclab.weixinappletuserclient.model.req.apiReq;

public class QueryPackageReq {

    private String areaId;

    private String sourceId;

    private String sourceName;

    private String purposeId;

    private String populationId;

    private String catalogId;

    private String catalogName;

    private String tagId;

    private Integer pageNo = 1;

    private Integer pageSize = 200;

    private String queryParam;

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    @Override
    public String toString() {
        return "QueryPackageReq{" +
                "areaId='" + areaId + '\'' +
                ", sourceId='" + sourceId + '\'' +
                ", sourceName='" + sourceName + '\'' +
                ", purposeId='" + purposeId + '\'' +
                ", populationId='" + populationId + '\'' +
                ", catalogId='" + catalogId + '\'' +
                ", catalogName='" + catalogName + '\'' +
                ", tagId='" + tagId + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", queryParam='" + queryParam + '\'' +
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

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
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

    public String getPopulationId() {
        return populationId;
    }

    public void setPopulationId(String populationId) {
        this.populationId = populationId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }
}
