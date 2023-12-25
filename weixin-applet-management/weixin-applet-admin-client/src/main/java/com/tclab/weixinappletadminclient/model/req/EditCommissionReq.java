package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "编辑套餐提成请求",description = "登陆请求")
public class EditCommissionReq {

    @ApiModelProperty(value = "套餐Id",required = true)
    private String packageId;
    @ApiModelProperty(value = "采集点Id",required = true)
    private String acquisitionId;
    @ApiModelProperty(value = "员工提成比例",required = true)
    private Float costStaffCommission;
    @ApiModelProperty(value = "采集点提成比例",required = true)
    private Float costOrganizationCommission;

}
