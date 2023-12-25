package com.tclab.weixinappletuserclient.model.req.apiReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "医生列表查询参数", description = "医生列表查询参数")
public class QueryDoctorReq {
    @ApiModelProperty(value = "区域编号", required = false)
    private String areaId;
    @ApiModelProperty(value = "区域名称", required = false)
    private String areaName;
    @ApiModelProperty(value = "医院编号", required = false)
    private String hospitalId;
    @ApiModelProperty(value = "医生部门编号", required = false)
    private String doctorDepartmentId;
    @ApiModelProperty(value = "查询字段", required = false)
    private String queryParam;
    @ApiModelProperty(value = "医生编号", required = false)
    private String doctorId;
    @ApiModelProperty(value = "用户ID", required = false)
    private String userId;
    @ApiModelProperty(value = "医生权限", required = false)
    private Integer doctorAuthority;
}
