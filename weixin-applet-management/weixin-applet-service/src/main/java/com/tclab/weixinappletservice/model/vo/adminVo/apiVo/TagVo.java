package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "套餐分类标签编辑项",description = "套餐添加、编辑、停用")
public class TagVo {

    @ApiModelProperty(value = "分类标签ID",required = false)
    private String tagId;
    @ApiModelProperty(value = "分类标签名称",required = false)
    private String tagName;
    @ApiModelProperty(value = "分类标签来源",required = false)
    private String sourceId;
    @ApiModelProperty(value = "分类标签备注",required = false)
    private String remark;

}
