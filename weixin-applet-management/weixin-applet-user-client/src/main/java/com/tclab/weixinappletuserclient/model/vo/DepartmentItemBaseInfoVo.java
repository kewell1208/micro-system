package com.tclab.weixinappletuserclient.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "科室细项基础信息", description = "科室细项基础信息参数")
public class DepartmentItemBaseInfoVo {
    @ApiModelProperty(value = "子科室ID", required = false)
    private String DepartmentId;
    @ApiModelProperty(value = "子科室名称", required = false)
    private String departmentName;
}
