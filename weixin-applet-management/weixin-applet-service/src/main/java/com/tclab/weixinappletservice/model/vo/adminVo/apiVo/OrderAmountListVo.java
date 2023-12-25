package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "OrderAmountListVo",description = "订单金额列表项")
public class OrderAmountListVo {

    @ApiModelProperty(value = "订单号",required = true)
    private String orderNo;
    @ApiModelProperty(value = "订单号",required = true)
    private String createDate;
    @ApiModelProperty(value = "订单号",required = true)
    private BigDecimal payAmount;

}
