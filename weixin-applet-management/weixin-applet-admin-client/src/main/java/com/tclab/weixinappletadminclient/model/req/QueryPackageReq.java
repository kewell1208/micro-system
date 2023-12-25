package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.wxmabackapi.model.req
 * @Class：QueryPackageReq
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/2 15:59
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "套餐列表参数",description = "套餐列表参数")
public class QueryPackageReq {

    @ApiModelProperty(value = "套餐编号",required = false)
    private String packageId;
    @ApiModelProperty(value = "套餐名称",required = false)
    private String packageName;
    @ApiModelProperty(value = "疾病分类",required = false)
    private String packagePurposeId;
    @ApiModelProperty(value = "科室分类",required = false)
    private String packageCatalogId;
    @ApiModelProperty(value = "人群分类",required = false)
    private String packagePopulationId;
    @ApiModelProperty(value = "套餐来源",required = false)
    private String sourceId;
    @ApiModelProperty(value = "分类标签ID",required = false)
    private String tagId;
    @ApiModelProperty(value = "查询参数",required = false)
    private String queryParam;
    @ApiModelProperty(value = "样本类型",required = false)
    private Integer sampleType;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;
}
