package com.tclab.weixinappletuserclient.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "医院基础信息", description = "医院基础信息参数")
public class HospitalBaseInfoVo {

    @ApiModelProperty(value = "医院编号", required = false)
    private String hospitalId;
    @ApiModelProperty(value = "区域ID", required = false)
    private String areaId;
    @ApiModelProperty(value = "区域名", required = false)
    private String areaName;
    @ApiModelProperty(value = "医院名", required = false)
    private String hospitalName;

}
