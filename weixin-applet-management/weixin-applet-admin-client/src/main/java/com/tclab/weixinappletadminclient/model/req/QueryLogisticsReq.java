package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "物流查询参数",description = "物流查询参数")
public class QueryLogisticsReq {

    @ApiModelProperty(value = "物流编号",required = false)
    private String logisticsId;
    @ApiModelProperty(value = "采集点名",required = false)
    private String acquisitionName;
    @ApiModelProperty(value = "物流状态",required = false)
    private Integer logisticsStatus;
    @ApiModelProperty(value = "物流类型",required = false)
    private Integer logisticsType;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;
}
