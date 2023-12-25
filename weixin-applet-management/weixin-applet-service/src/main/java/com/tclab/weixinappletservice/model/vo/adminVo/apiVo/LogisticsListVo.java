package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "LogisticsListVo",description = "JsonResNewVo泛型")
public class LogisticsListVo {

    @ApiModelProperty(value = "物流单号",required = true)
    private String logisticId;
    @ApiModelProperty(value = "来源编号",required = true)
    private String sourceId;
    @ApiModelProperty(value = "来源",required = true)
    private String sourceName;
    @ApiModelProperty(value = "物流状态",required = true)
    private Integer LogisticsStatus;
    @ApiModelProperty(value = "物流创建时间",required = true)
    private String createDate;
    @ApiModelProperty(value = "订单号",required = true)
    private String orderNo;
    @ApiModelProperty(value = "参检人名",required = true)
    private String participantName;
    @ApiModelProperty(value = "参检人手机",required = true)
    private String participantPhone;
    @ApiModelProperty(value = "付款金额",required = true)
    private BigDecimal payAmount;
    @ApiModelProperty(value = "订单创建时间",required = true)
    private String orderDate;
    @ApiModelProperty(value = "快递名",required = true)
    private String expressName;
    @ApiModelProperty(value = "运单号",required = true)
    private String waybillNo;

}
