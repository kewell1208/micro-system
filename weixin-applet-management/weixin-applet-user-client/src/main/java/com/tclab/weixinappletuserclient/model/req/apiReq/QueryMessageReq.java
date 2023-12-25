package com.tclab.weixinappletuserclient.model.req.apiReq;

public class QueryMessageReq {

    private String userId;

    private String acquisitionId;

    private Integer messageStatus;

    private Integer pageNo = 1;

    private Integer pageSize = 5;

    @Override
    public String toString() {
        return "QueryMessageReq{" +
                "userId='" + userId + '\'' +
                ", acquisitionId='" + acquisitionId + '\'' +
                ", messageStatus=" + messageStatus +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(Integer messageStatus) {
        this.messageStatus = messageStatus;
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
}
