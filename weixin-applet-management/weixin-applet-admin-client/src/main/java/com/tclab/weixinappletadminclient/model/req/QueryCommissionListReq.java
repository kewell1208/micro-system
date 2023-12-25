package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "提成列表参数",description = "提成列表参数")
public class QueryCommissionListReq {

    @ApiModelProperty(value = "物流编号",required = false)
    private String acquisitionId;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;

}
