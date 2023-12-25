package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "子套餐编辑项",description = "套餐添加、编辑、停用")
public class SubPackageVo {

    @ApiModelProperty(value = "套餐ID",required = false)
    private String packageId;
    @ApiModelProperty(value = "子套餐名称",required = false)
    private String subPackageName;

}
