package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ServiceInfoBaseVo",description = "服务信息")
public class ServiceInfoBaseVo {

    private Integer id;
    @ApiModelProperty(value = "服务地址ID",required = true)
    private String serviceInfoId;
    @ApiModelProperty(value = "关联用户ID",required = true)
    private String userId;
    @ApiModelProperty(value = "省",required = true)
    private String addressProvince;
    @ApiModelProperty(value = "市",required = true)
    private String addressCity;
    @ApiModelProperty(value = "区",required = true)
    private String addressRegion;
    @ApiModelProperty(value = "详细地址",required = true)
    private String serviceInfoAddress;
    @ApiModelProperty(value = "联系人",required = true)
    private String serviceInfoPerson;
    @ApiModelProperty(value = "联系电话",required = true)
    private String serviceInfoPhone;
    @ApiModelProperty(value = "邮编",required = true)
    private String zipCode;
    @ApiModelProperty(value = "是否默认地址",required = true)
    private Integer defaultFlag;

}
