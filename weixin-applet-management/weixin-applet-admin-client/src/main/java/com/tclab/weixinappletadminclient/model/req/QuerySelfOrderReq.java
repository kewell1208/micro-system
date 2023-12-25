package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "自采订单查询参数",description = "自采订单查询参数")
public class QuerySelfOrderReq {

    @ApiModelProperty(value = "订单号",required = false)
    private String orderNo;
    @ApiModelProperty(value = "用户手机号",required = false)
    private String userPhone;
    @ApiModelProperty(value = "物流状态",required = false)
    private Integer logisticsStatus;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;

}
