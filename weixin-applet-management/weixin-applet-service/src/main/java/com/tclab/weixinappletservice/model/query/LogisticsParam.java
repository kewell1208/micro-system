package com.tclab.weixinappletservice.model.query;

public class LogisticsParam {

    private String acquisitionId;

    private Integer tcLogisticsStatus;

    private Integer pageIndex = 0;

    private Integer pageSize = 10;

    private Integer logisticsType;

    private Integer logisticsStatus;

    private String logisticsSourceId;

    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public Integer getTcLogisticsStatus() {
        return tcLogisticsStatus;
    }

    public void setTcLogisticsStatus(Integer tcLogisticsStatus) {
        this.tcLogisticsStatus = tcLogisticsStatus;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public Integer getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }

    public String getLogisticsSourceId() {
        return logisticsSourceId;
    }

    public void setLogisticsSourceId(String logisticsSourceId) {
        this.logisticsSourceId = logisticsSourceId;
    }
}
