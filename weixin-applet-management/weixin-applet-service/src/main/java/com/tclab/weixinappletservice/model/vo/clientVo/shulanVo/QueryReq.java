package com.tclab.weixinappletservice.model.vo.clientVo.shulanVo;

public class QueryReq {

    //接口鉴权加密参数1当前时间戳
    private String curTime;
    //接口鉴权加密参数2签名加校验字符串
    private String sign;

    private String doctorPhone;

    private String status;

    private String pageNo;

    private String pageSize;

    private String date;

    private String goodNo;

    private String packageId;

    private String queryParam;

    @Override
    public String toString() {
        return "QueryReq{" +
                "curTime='" + curTime + '\'' +
                ", sign='" + sign + '\'' +
                ", doctorPhone='" + doctorPhone + '\'' +
                ", status='" + status + '\'' +
                ", pageNo='" + pageNo + '\'' +
                ", pageSize='" + pageSize + '\'' +
                ", date='" + date + '\'' +
                ", goodNo='" + goodNo + '\'' +
                ", packageId='" + packageId + '\'' +
                ", queryParam='" + queryParam + '\'' +
                '}';
    }

    public String getQueryParam() {
        return queryParam;
    }

    public void setQueryParam(String queryParam) {
        this.queryParam = queryParam;
    }

    public String getCurTime() {
        return curTime;
    }

    public void setCurTime(String curTime) {
        this.curTime = curTime;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }
}
