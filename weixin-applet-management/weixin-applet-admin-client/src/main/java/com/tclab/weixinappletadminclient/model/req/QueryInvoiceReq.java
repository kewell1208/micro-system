package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "查询开票请求",description = "开票服务的所有接口的公用请求参数")
public class QueryInvoiceReq {

    @ApiModelProperty(value = "用户名",required = false)
    private String userName;
    @ApiModelProperty(value = "用户手机",required = false)
    private String userPhone;
    @ApiModelProperty(value = "处理状态",required = false)
    private Integer dealStatus;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 10;
    @ApiModelProperty(value = "工单号",required = false)
    private String applyId;
    @ApiModelProperty(value = "文件路径",required = false)
    private String invoiceUrl;

}
