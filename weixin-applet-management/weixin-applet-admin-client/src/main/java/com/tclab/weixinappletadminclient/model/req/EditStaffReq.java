package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.wxmabackapi.model.req
 * @Class：EditPackageReq
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/3 14:17
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "编辑员工信息请求",description = "套餐添加、编辑")
public class EditStaffReq {

    @ApiModelProperty(value = "采集点员工id",required = false)
    private String staffId;
    @ApiModelProperty(value = "员工姓名",required = false)
    private String staffName;
    @ApiModelProperty(value = "员工性别",required = false)
    private String staffSex;
    @ApiModelProperty(value = "员工手机",required = false)
    private String staffPhone;
    @ApiModelProperty(value = "员工身份证号",required = false)
    private String staffIdCard;
    @ApiModelProperty(value = "采集点id",required = false)
    private String acquisitionId;
    @ApiModelProperty(value = "部门id",required = false)
    private String departmentId;
    @ApiModelProperty(value = "员工类别",required = false)
    private Integer staffType;
    @ApiModelProperty(value = "员工职称",required = false)
    private String staffRank;
    @ApiModelProperty(value = "员工职称图片",required = false)
    private String staffRankImage;
    @ApiModelProperty(value = "员工从业执照",required = false)
    private String staffJobImage;
    @ApiModelProperty(value = "员工介绍",required = false)
    private String staffIntroduction;
    @ApiModelProperty(value = "员工擅长专项",required = false)
    private String staffExpert;
    @ApiModelProperty(value = "员工备注",required = false)
    private String staffRemark;
    @ApiModelProperty(value = "验证状态",required = false)
    private Integer verifyFlag;

}
