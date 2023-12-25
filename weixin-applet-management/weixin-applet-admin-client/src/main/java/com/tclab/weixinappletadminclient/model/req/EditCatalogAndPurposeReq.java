package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "编辑科室或检验目的信息请求",description = "科室检验目的添加编辑")
public class EditCatalogAndPurposeReq {

    @ApiModelProperty(value = "科室ID",required = false)
    private String packageCatalogId;
    @ApiModelProperty(value = "科室名称",required = false)
    private String packageCatalogName;
    @ApiModelProperty(value = "科室备注",required = false)
    private String packageCatalogRemark;
    @ApiModelProperty(value = "套餐来源",required = false)
    private String packageSourceId;
    @ApiModelProperty(value = "检验目的ID",required = false)
    private String packagePurposeId;
    @ApiModelProperty(value = "检验目的名称",required = false)
    private String packagePurposeName;

}
