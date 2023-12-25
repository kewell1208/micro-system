package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "AcquisitionCommissionDetailVo",description = "JsonResNewVo泛型")
public class AcquisitionCommissionDetailVo {

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
    @ApiModelProperty(value = "业务员手机",required = true)
    private String createDate;
    @ApiModelProperty(value = "创建时间",required = true)
    private String protocolImg;
    @ApiModelProperty(value = "许可证",required = true)
    private String acquisitionLicense;
    @ApiModelProperty(value = "营业执照",required = true)
    private String acquisitionBusinessLicence;

}
