package com.tclab.weixinappletadminclient.model.req;


import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.SubPackageVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.TagVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
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
@ApiModel(value = "编辑套餐请求",description = "套餐添加、编辑、停用")
public class EditPackageReq {

    @ApiModelProperty(value = "套餐编号",required = false)
    private String packageId;
    @ApiModelProperty(value = "套餐名称",required = false)
    private String packageName;
    @ApiModelProperty(value = "套餐logo",required = false)
    private String packageLogo;
    @ApiModelProperty(value = "套餐简介",required = false)
    private String packageInfo;
    @ApiModelProperty(value = "套餐标签",required = false)
    private String packageLabel;
    @ApiModelProperty(value = "套餐推荐等级",required = false)
    private Integer packagePriority;
    @ApiModelProperty(value = "套餐信息",required = false)
    private String packageMessage;

    @ApiModelProperty(value = "套餐人群分类编号",required = false)
    private String packagePopulationId;
    @ApiModelProperty(value = "套餐人群名称(有些套餐没有明确的人群)",required = false)
    private String populationName;

    @ApiModelProperty(value = "套餐来源ID",required = false)
    private String packageSourceId;
    @ApiModelProperty(value = "套餐来源名称",required = false)
    private String packageSourceName;

    @ApiModelProperty(value = "套餐备注",required = false)
    private String packageRemark;
    @ApiModelProperty(value = "套餐原价",required = false)
    private BigDecimal packagePrimePrice;
    @ApiModelProperty(value = "套餐现价",required = false)
    private BigDecimal packageCurrentPrice;
    @ApiModelProperty(value = "套餐状态",required = false)
    private Integer packageStatus;
    @ApiModelProperty(value = "套餐提供的采集方式",required = false)
    private Integer packageCollectType;
    @ApiModelProperty(value = "套餐的标本示意图",required = false)
    private String packageSamplePic;
    @ApiModelProperty(value = "套餐步骤",required = false)
    private String packageStep;
    @ApiModelProperty(value = "选择套餐报告形式",required = false)
    private Integer packageReportType;
    @ApiModelProperty(value = "收费报告费用",required = false)
    private BigDecimal packageReportCharge;
    @ApiModelProperty(value = "套餐特殊需求",required = false)
    private String packageSpecialRequirement;
    @ApiModelProperty(value = "套餐采集器材",required = false)
    private String packageEquipment;
    @ApiModelProperty(value = "套餐科室分类id",required = false)
    private String packageCatalogId;
    @ApiModelProperty(value = "套餐疾病分类编号",required = false)
    private String packagePurposeId;

    @ApiModelProperty(value = "临床意义",required = false)
    private String clinicalSignificance;
    @ApiModelProperty(value = "实验室分组",required = false)
    private String labGroup;
    @ApiModelProperty(value = "物价编码",required = false)
    private String priceCode;

    @ApiModelProperty(value = "报告时间",required = false)
    private String packageReportTime;
    @ApiModelProperty(value = "报告时间简述",required = false)
    private String reportTimeDesc;
    @ApiModelProperty(value = "样本名称",required = false)
    private String sampleTypeName;
    @ApiModelProperty(value = "样本类型",required = false)
    private Integer sampleType;

    @ApiModelProperty(value = "套餐子项目列表",required = false)
    private List<SubPackageVo> subPackageVoList = new ArrayList<>();
    @ApiModelProperty(value = "分类标签列表",required = false)
    private List<TagVo> tagVoList = new ArrayList<>();

    @ApiModelProperty(value = "套餐样本存储条件",required = false)
    private String storageCondition;
    @ApiModelProperty(value = "套餐子项目名称列表",required = false)
    private List<String> subPackageStrList = new ArrayList<>();

}
