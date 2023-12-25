package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "通用封装号码请求",description = "用于封装")
public class NoReq {

    @ApiModelProperty(value = "自采用户订单号",required = true)
    private String orderNo;
    @ApiModelProperty(value = "第三方物流号",required = true)
    private String logisticsId;
    @ApiModelProperty(value = "采集点ID",required = false)
    private String acquisitionId;

}
