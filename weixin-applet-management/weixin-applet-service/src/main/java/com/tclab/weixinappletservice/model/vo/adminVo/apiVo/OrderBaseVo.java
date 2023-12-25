package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "OrderBaseVo",description = "订单基本对象")
public class OrderBaseVo {

    @ApiModelProperty(value = "订单号",required = true)
    private String orderNo;
    @ApiModelProperty(value = "参检人",required = true)
    private String participantName;
    @ApiModelProperty(value = "参检人手机",required = true)
    private String participantPhone;
    @ApiModelProperty(value = "采集核销时间",required = true)
    private String writeOffDate;
    @ApiModelProperty(value = "套餐数量",required = true)
    private Long packageNum;

}
