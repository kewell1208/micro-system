package com.tclab.weixinappletuserclient.model.req.apiReq;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ImRecordReq {

    //Im服务编号
    private String imRecordId;
    //医生ID
    private String doctorId;
    //用户ID
    private String userId;
    //用户openid
    private String openid;
    //用户手机
    private String userPhone;
    //参检人ID
    private String participantId;
    //参检人名
    private String participantName;
    //解读状态
    private Integer status;
    //解读类型
    private Integer type;
    //解读金额
    private BigDecimal amount;
    //IM交流支付状态
    private Integer payStatus;
    //IM交流支付金额
    private BigDecimal payAmount;
    //IM交流支付预订单号（微信支付预订单号）
    private String preNo;
    //IM交流支付完成后流水单号（微信支付回调通知的流水单号）
    private String payNo;
    //IM交流支付完成后的时间日期
    private Date payDate;

    private Date finishDate;

    private String participantPhone;

}
