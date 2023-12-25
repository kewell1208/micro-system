package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "后台退款请求对象",description = "后台退款请求对象")
public class RefundReq {

    @ApiModelProperty(value = "订单号",required = true)
    private String orderNo;
    @ApiModelProperty(value = "商品号",required = false)
    private String goodNo;
    @ApiModelProperty(value = "退款金额",required = true)
    private BigDecimal refundAmount;
    @ApiModelProperty(value = "退款原因",required = false)
    private Integer refundReason;


}
