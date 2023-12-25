package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

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
@ApiModel(value = "机构信息",description = "机构添加、编辑详情信息")
public class EditAcquisitionReq {

    @ApiModelProperty(value = "采集点id",required = false)
    private String acquisitionId;
    @ApiModelProperty(value = "采集点姓名",required = false)
    private String acquisitionName;
    @ApiModelProperty(value = "采集点电话",required = false)
    private String acquisitionPhone;
    @ApiModelProperty(value = "采集点地址",required = false)
    private String acquisitionAddress;
    @ApiModelProperty(value = "采集点Logo",required = false)
    private String acquisitionLogo;
    @ApiModelProperty(value = "采集点许可证",required = false)
    private String acquisitionLicense;
    @ApiModelProperty(value = "采集点营业执照",required = false)
    private String acquisitionBusinessLicence;
    @ApiModelProperty(value = "简介图片",required = false)
    private String acquisitionInfo;
    @ApiModelProperty(value = "采集点介绍",required = false)
    private String acquisitionMessage;
    @ApiModelProperty(value = "营业时间",required = false)
    private String acquisitionOfficeTime;
    @ApiModelProperty(value = "评分",required = false)
    private Float acquisitionScore;
    @ApiModelProperty(value = "采集类型",required = false)
    private Integer acquisitionCollectType;
    @ApiModelProperty(value = "员工备注",required = false)
    private String staffRemark;
    @ApiModelProperty(value = "验证状态",required = false)
    private Integer verifyFlag;
    @ApiModelProperty(value = "业务员ID",required = false)
    private String staffId;
    @ApiModelProperty(value = "物理ID",required = false)
    private Integer id;

    @ApiModelProperty(value = "工作人员ID",required = false)
    private String clerkId;

    @ApiModelProperty(value = "优先级",required = false)
    private Integer acquisitionPriority;
    @ApiModelProperty(value = "经度",required = false)
    private Double longitude;
    @ApiModelProperty(value = "纬度",required = false)
    private Double latitude;
    @ApiModelProperty(value = "区域id",required = false)
    private String areaId;
    @ApiModelProperty(value = "区域名",required = false)
    private String areaName;

    @ApiModelProperty(value = "工作时间",required = false)
    private String workDay;
    @ApiModelProperty(value = "休息时间",required = false)
    private List<String> restDay;

    @ApiModelProperty(value = "负责人名",required = false)
    private String directorName;
    @ApiModelProperty(value = "负责人手机",required = false)
    private String directorPhone;

}
