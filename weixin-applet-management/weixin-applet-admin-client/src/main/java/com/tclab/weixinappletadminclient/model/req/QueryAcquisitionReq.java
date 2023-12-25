package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "机构查询参数",description = "机构查询参数")
public class QueryAcquisitionReq {

    @ApiModelProperty(value = "机构姓名",required = false)
    private String acquisitionName;
    @ApiModelProperty(value = "机构手机号",required = false)
    private String acquisitionPhone;
    @ApiModelProperty(value = "机构编号",required = false)
    private String acquisitionId;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;

    @ApiModelProperty(value = "机构负责人",required = false)
    private String directorName;
    @ApiModelProperty(value = "机构负责手机",required = false)
    private String directorPhone;
    @ApiModelProperty(value = "采集方式",required = false)
    private Integer collectType;


}
