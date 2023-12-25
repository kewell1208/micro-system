package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "停用启用请求通用参数",description = "停用启用请求通用对象")
public class StopReq {

    @ApiModelProperty(value = "停用套餐ID列表",required = false)
    private List<String> packageIds;
    @ApiModelProperty(value = "停用采集点ID列表",required = false)
    private List<String> acquisitionIds;
    @ApiModelProperty(value = "设置状态",required = false)
    private Integer status;

}
