package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "OrderListVo",description = "JsonResNewVo泛型")
public class OrderListVo {

    @ApiModelProperty(value = "订单号",required = true)
    private String orderNo;
    @ApiModelProperty(value = "用户ID",required = true)
    private String userId;
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(value = "参检人ID",required = true)
    private String participantId;
    @ApiModelProperty(value = "参检人名",required = true)
    private String participantName;
    @ApiModelProperty(value = "参检人手机",required = true)
    private String participantPhone;

    @ApiModelProperty(value = "采集点ID",required = true)
    private String acquisitionId;
    @ApiModelProperty(value = "采集点名称",required = true)
    private String acquisitionName;

    @ApiModelProperty(value = "付款金额",required = true)
    private BigDecimal payAmount;
    @ApiModelProperty(value = "订单综合状态区分异常和自采0正常1异常2自采",required = true)
    private Integer comStats;
    @ApiModelProperty(value = "下单日期",required = true)
    private String createDate;
    @ApiModelProperty(value = "订单下套餐数量",required = true)
    private Long goodNum;

    @ApiModelProperty(value = "订单状态",required = true)
    private Integer orderStatus;
    @ApiModelProperty(value = "审核状态",required = true)
    private Integer verifyStatus;
    @ApiModelProperty(value = "支付状态",required = true)
    private Integer payStatus;
    @ApiModelProperty(value = "退款状态",required = true)
    private Integer refundStatus;
    @ApiModelProperty(value = "物流状态",required = true)
    private Integer logisticsStatus;
    @ApiModelProperty(value = "核销状态",required = true)
    private Integer writeOffStatus;
    @ApiModelProperty(value = "异常状态",required = true)
    private Integer orderExceptionStatus;
    @ApiModelProperty(value = "取消状态",required = true)
    private Integer orderCancelStatus;
    @ApiModelProperty(value = "取消原因",required = true)
    private Integer orderCancelReason;

    @ApiModelProperty(value = "解读状态",required = true)
    private Integer interpretStatus;

    @ApiModelProperty(value = "订单完成预约时间",required = true)
    private String orderCompleteApplyDate;
    @ApiModelProperty(value = "解读人ID",required = true)
    private String interpretStaffId;
    @ApiModelProperty(value = "解读人名",required = true)
    private String interpretStaffName;
    @ApiModelProperty(value = "解读人所在医院",required = true)
    private String interpretStaffHospitalName;
    @ApiModelProperty(value = "解读人所在部门",required = true)
    private String interpretStaffDepartmentName;
    @ApiModelProperty(value = "解读人职称",required = true)
    private String interpretStaffRank;
    @ApiModelProperty(value = "解读人职称",required = true)
    private String interpretStaffLogo;

    @ApiModelProperty(value = "解读ID",required = true)
    private String interpretId;
    @ApiModelProperty(value = "是否填写问诊意见(0否1是)",required = true)
    private Integer isSuggestion;

}
