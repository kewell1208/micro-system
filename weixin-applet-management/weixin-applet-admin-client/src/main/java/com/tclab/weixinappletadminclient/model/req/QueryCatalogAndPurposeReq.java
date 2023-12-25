package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "查询科室或检验目的信息请求",description = "科室检验目的查询")
public class QueryCatalogAndPurposeReq {

    @ApiModelProperty(value = "套餐来源",required = false)
    private String sourceId;
    @ApiModelProperty(value = "科室ID",required = false)
    private String catalogId;
    @ApiModelProperty(value = "检验目的ID",required = false)
    private String purposeId;
    @ApiModelProperty(value = "查询参数",required = false)
    private String queryParam;

}
