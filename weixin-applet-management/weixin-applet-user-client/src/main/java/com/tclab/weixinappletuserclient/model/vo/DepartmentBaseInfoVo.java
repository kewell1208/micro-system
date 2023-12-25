package com.tclab.weixinappletuserclient.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "医生科室基础信息", description = "医生科室基础信息参数")
public class DepartmentBaseInfoVo {
    @ApiModelProperty(value = "父科室ID", required = false)
    private String departmentPId;
    @ApiModelProperty(value = "父科室名称", required = false)
    private String departmentPidName;
    @ApiModelProperty(value = "子科室列表", required = false)
    private List<DepartmentItemBaseInfoVo> itemList = new ArrayList<>();

}
