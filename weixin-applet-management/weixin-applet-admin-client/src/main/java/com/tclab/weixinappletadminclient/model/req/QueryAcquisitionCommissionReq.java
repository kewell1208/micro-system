package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "提成查询参数",description = "提成查询参数")
public class QueryAcquisitionCommissionReq {

    @ApiModelProperty(value = "物流编号",required = false)
    private String acquisitionId;
    @ApiModelProperty(value = "采集点名",required = false)
    private String acquisitionName;
    @ApiModelProperty(value = "区域名",required = false)
    private String areaName;
    @ApiModelProperty(value = "提成设置标识",required = false)
    private Integer commissionFlag;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;

}
