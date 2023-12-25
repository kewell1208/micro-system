package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "员工查询参数",description = "员工查询参数")
public class QueryAcquisitionStaffReq {

    @ApiModelProperty(value = "员工姓名",required = false)
    private String staffName;
    @ApiModelProperty(value = "员工手机号",required = false)
    private String staffPhone;
    @ApiModelProperty(value = "机构编号",required = false)
    private String acquisitionId;
    @ApiModelProperty(value = "员工类别",required = false)
    private Integer staffType;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;

}
