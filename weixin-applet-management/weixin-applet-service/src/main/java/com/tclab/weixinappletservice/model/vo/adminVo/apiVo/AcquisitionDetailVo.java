package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
@ApiModel(value = "AcquisitionDetailVo",description = "JsonResNewVo泛型")
public class AcquisitionDetailVo {

    @ApiModelProperty(value = "采集点ID",required = true)
    private String acquisitionId;
    @ApiModelProperty(value = "采集点名",required = true)
    private String acquisitionName;
    @ApiModelProperty(value = "采集点联系方式",required = false)
    private String acquisitionPhone;
    @ApiModelProperty(value = "采集点地址",required = false)
    private String acquisitionAddress;
    @ApiModelProperty(value = "采集点介绍",required = false)
    private String acquisitionMessage;
    @ApiModelProperty(value = "业务员ID",required = false)
    private String clerkId;
    @ApiModelProperty(value = "业务员名",required = false)
    private String clerkName;
    @ApiModelProperty(value = "业务员手机",required = false)
    private String clerkPhone;
    @ApiModelProperty(value = "创建时间",required = false)
    private String createDate;
    @ApiModelProperty(value = "许可证",required = false)
    private String acquisitionLicense;
    @ApiModelProperty(value = "营业执照",required = false)
    private String acquisitionBusinessLicence;
    @ApiModelProperty(value = "机构员工信息",required = true)
    private AcquisitionStaffPageVo staffPageVo;
}
