package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "AcquisitionPageVo",description = "JsonResNewVo泛型")
public class AcquisitionPageVo {

    @ApiModelProperty(value = "总页数",required = true)
    private Integer pageNum;
    @ApiModelProperty(value = "总机构数",required = true)
    private Long acquisitionNum;
    @ApiModelProperty(value = "当前页数",required = true)
    private Integer currentPageNo;
    @ApiModelProperty(value = "机构信息列表",required = true)
    private List<AcquisitionListVo> acquisitionListVoList = new ArrayList<>();

}
