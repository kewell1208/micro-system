package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "InvoicePageListVo",description = "JsonResNewVo泛型")
public class InvoicePageListVo {

    @ApiModelProperty(value = "工单号",required = true)
    private String applyId;
    @ApiModelProperty(value = "申请日期",required = true)
    private String applyDate;
    @ApiModelProperty(value = "申请状态",required = true)
    private Integer dealStatus;
    @ApiModelProperty(value = "客户ID",required = true)
    private String userId;
    @ApiModelProperty(value = "客户手机",required = true)
    private String userPhone;
    @ApiModelProperty(value = "客户名",required = true)
    private String userName;

}
