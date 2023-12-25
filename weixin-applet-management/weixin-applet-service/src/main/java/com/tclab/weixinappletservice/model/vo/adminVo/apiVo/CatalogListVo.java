package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "CatalogListVo",description = "科室列表项")
public class CatalogListVo {

    @ApiModelProperty(value = "科室ID",required = false)
    private String packageCatalogId;
    @ApiModelProperty(value = "科室名称",required = false)
    private String packageCatalogName;
    @ApiModelProperty(value = "科室来源(和套餐来源相同)",required = false)
    private String packageSourceId;

}
