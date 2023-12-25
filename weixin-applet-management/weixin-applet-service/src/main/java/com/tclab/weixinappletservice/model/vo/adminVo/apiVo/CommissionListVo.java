package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "CommissionListVo",description = "JsonResNewVo泛型")
public class CommissionListVo {

    @ApiModelProperty(value = "套餐ID",required = true)
    private String packageId;
    @ApiModelProperty(value = "套餐名",required = true)
    private String packageName;
    @ApiModelProperty(value = "套餐实际价格",required = true)
    private BigDecimal packagePrice;
    @ApiModelProperty(value = "员工提成",required = true)
    private Float costStaffCommission;
    @ApiModelProperty(value = "机构提成",required = true)
    private Float costOrganizationCommission;




}
