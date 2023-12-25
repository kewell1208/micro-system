package com.tclab.weixinappletuserclient.model.req.apiReq;

public class LogisticsStatusReq {

    private String acquisitionId;

    private Integer logisticsType;

    private Integer logisticsStatus;

    private String queryParam;

    private Integer pageNo = 1;

    private Integer pageSize = 30;

    @Override
    public String toString() {
        return "LogisticsStatusReq{" +
                "acquisitionId='" + acquisitionId + '\'' +
                ", logisticsType=" + logisticsType +
                ", logisticsStatus=" + logisticsStatus +
                ", queryParam='" + queryParam + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
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

    public Integer getLogisticsType() {
        return logisticsType;
    }

    public void setLogisticsType(Integer logisticsType) {
        this.logisticsType = logisticsType;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public Integer getLogisticsStatus() {
        return logisticsStatus;
    }

    public void setLogisticsStatus(Integer logisticsStatus) {
        this.logisticsStatus = logisticsStatus;
    }
}
