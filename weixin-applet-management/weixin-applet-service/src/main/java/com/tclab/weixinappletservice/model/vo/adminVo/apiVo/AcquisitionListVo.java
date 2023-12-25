package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AcquisitionListVo",description = "JsonResNewVo泛型")
public class AcquisitionListVo {

    @ApiModelProperty(value = "采集点ID",required = true)
    private String acquisitionId;
    @ApiModelProperty(value = "采集点名",required = true)
    private String acquisitionName;
    @ApiModelProperty(value = "采集点联系方式",required = true)
    private String acquisitionPhone;
    @ApiModelProperty(value = "业务员ID",required = true)
    private String clerkId;
    @ApiModelProperty(value = "业务员名",required = true)
    private String clerkName;
    @ApiModelProperty(value = "业务员手机",required = true)
    private String clerkPhone;
    @ApiModelProperty(value = "机构状态",required = true)
    private Integer acquisitionStatus;

    @ApiModelProperty(value = "负责人名",required = false)
    private String directorName;
    @ApiModelProperty(value = "负责人手机",required = false)
    private String directorPhone;

}
