package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "样本类型",description = "样本类型列表项")
public class SampleTypeListVo {

    @ApiModelProperty(value = "样本类型ID",required = false)
    private Integer id;
    @ApiModelProperty(value = "样本类型名称",required = false)
    private String name;

}
