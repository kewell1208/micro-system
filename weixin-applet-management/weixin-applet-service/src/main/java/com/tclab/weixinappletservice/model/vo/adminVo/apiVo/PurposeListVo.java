package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "PurposeListVo",description = "检验目的列表项")
public class PurposeListVo {

    @ApiModelProperty(value = "检验目的ID",required = false)
    private String packagePurposeId;
    @ApiModelProperty(value = "检验目的名称",required = false)
    private String packagePurposeName;
    @ApiModelProperty(value = "科室ID",required = false)
    private String packageCatalogId;

}
