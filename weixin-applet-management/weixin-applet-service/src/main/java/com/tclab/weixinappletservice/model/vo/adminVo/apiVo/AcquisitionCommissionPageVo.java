package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "AcquisitionCommissionPageVo",description = "JsonResNewVo泛型")
public class AcquisitionCommissionPageVo {

    @ApiModelProperty(value = "总页数",required = true)
    private Integer pageNum;
    @ApiModelProperty(value = "总订单数",required = true)
    private Long orderNum;
    @ApiModelProperty(value = "当前页数",required = true)
    private Integer currentPageNo;
    @ApiModelProperty(value = "物流详情页",required = true)
    private List<AcquisitionCommissionListVo> acquisitionCommissionListVoList = new ArrayList<>();

}
