package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "OrderDetailVo",description = "订单详情对象")
public class OrderDetailVo {

    private String orderNo;

    private String userId;

    private String userName;

    private String userPhone;

    private String createDate;

    private String orderApplyDate;

    private String orderCompleteApplyDate;

    private BigDecimal payAmount;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private Integer orderStatus;

    private Integer verifyStatus;

    private String auditorId;

    private Integer payStatus;

    private String payNo;

    private String payDate;

    private Integer refundStatus;

    private BigDecimal refundAmount;

    private Integer logisticsStatus;

    private Integer logisticsType;

    private String logisticsId;

    private Integer writeOffStatus;

    private String writeOffCode;

    private String writeOffDate;

    private String orderRemark;

    private Integer orderExceptionStatus;

    private Integer orderExceptionReason;

    private Integer orderCancelStatus;

    private Integer orderCancelType;

    private Integer orderCancelReason;

    private BigDecimal costReportChargeAmount;

    private BigDecimal costAcquisitionChargeAmount;

    private String staffId;

    private String staffName;

    private Integer delFlag;

    private Integer serviceType;

    @ApiModelProperty(value = "参检人信息",required = true)
    private ParticipantBaseVo participantVo;
    @ApiModelProperty(value = "服务信息",required = true)
    private ServiceInfoBaseVo serviceInfoVo;
    @ApiModelProperty(value = "商品列表",required = true)
    private List<GoodBaseVo> goodBaseVos = new ArrayList<>();
    @ApiModelProperty(value = "异常信息",required = true)
    private List<ExceptionBaseVo> exceptionBaseVo = new ArrayList<>();
    @ApiModelProperty(value = "发送样本采集盒物流信息",required = true)
    private ThirdSelfLogisticsBaseVo thirdSelfLogisticsBaseVo;
    @ApiModelProperty(value = "物流回寄信息",required = true)
    private ThirdLogisticsBaseVo thirdLogisticsBaseVo;

}
