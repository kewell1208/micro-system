package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class LogisticsOrderVo {

    private String tcLogisticsId;

    private String acquisitionId;

    private String clerkId;

    private String clerkName;

    private String clerkPhone;

    private Integer tcLogisticsOrderNum;

//    private Date tcLogisticsApplyDate;

    private String tcLogisticsApplyDate;

    private List<OrderBaseVo> orderBaseVos = new ArrayList<>();

    public String getTcLogisticsId() {
        return tcLogisticsId;
    }

    public void setTcLogisticsId(String tcLogisticsId) {
        this.tcLogisticsId = tcLogisticsId;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getClerkId() {
        return clerkId;
    }

    public void setClerkId(String clerkId) {
        this.clerkId = clerkId;
    }

    public String getClerkName() {
        return clerkName;
    }

    public void setClerkName(String clerkName) {
        this.clerkName = clerkName;
    }

    public String getClerkPhone() {
        return clerkPhone;
    }

    public void setClerkPhone(String clerkPhone) {
        this.clerkPhone = clerkPhone;
    }

    public Integer getTcLogisticsOrderNum() {
        return tcLogisticsOrderNum;
    }

    public void setTcLogisticsOrderNum(Integer tcLogisticsOrderNum) {
        this.tcLogisticsOrderNum = tcLogisticsOrderNum;
    }

//    public Date getTcLogisticsApplyDate() {
//        return tcLogisticsApplyDate;
//    }
//
//    public void setTcLogisticsApplyDate(Date tcLogisticsApplyDate) {
//        this.tcLogisticsApplyDate = tcLogisticsApplyDate;
//    }

    public String getTcLogisticsApplyDate() {
        return tcLogisticsApplyDate;
    }

    public void setTcLogisticsApplyDate(String tcLogisticsApplyDate) {
        this.tcLogisticsApplyDate = tcLogisticsApplyDate;
    }

    public List<OrderBaseVo> getOrderBaseVos() {
        return orderBaseVos;
    }

    public void setOrderBaseVos(List<OrderBaseVo> orderBaseVos) {
        this.orderBaseVos = orderBaseVos;
    }
}
