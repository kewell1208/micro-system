package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "订单查询参数",description = "订单查询参数")
public class QueryOrderReq {

    @ApiModelProperty(value = "订单号",required = false)
    private String orderNo;
    @ApiModelProperty(value = "参检人手机",required = false)
    private String participantPhone;
    @ApiModelProperty(value = "采集点名",required = false)
    private String acquisitionName;
    @ApiModelProperty(value = "推荐人",required = false)
    private String staffName;
    @ApiModelProperty(value = "订单服务方式",required = false)
    private Integer orderType;
    @ApiModelProperty(value = "物流状态",required = false)
    private Integer logisticsStatus;
    @ApiModelProperty(value = "异常状态",required = false)
    private Integer orderExceptionStatus;
    @ApiModelProperty(value = "异常原因",required = false)
    private Integer orderExceptionReason;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;
}
