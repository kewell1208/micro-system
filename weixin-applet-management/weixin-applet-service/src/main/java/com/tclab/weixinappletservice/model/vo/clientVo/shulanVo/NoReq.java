package com.tclab.weixinappletservice.model.vo.clientVo.shulanVo;

public class NoReq {

    //接口鉴权加密参数1当前时间戳
    private String curTime;
    //接口鉴权加密参数2签名加校验字符串
    private String sign;

    private String goodNo;

    private String doctorName;

    private String doctorPhone;

    @Override
    public String toString() {
        return "NoReq{" +
                "curTime='" + curTime + '\'' +
                ", sign='" + sign + '\'' +
                ", goodNo='" + goodNo + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", doctorPhone='" + doctorPhone + '\'' +
                '}';
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

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }
}
