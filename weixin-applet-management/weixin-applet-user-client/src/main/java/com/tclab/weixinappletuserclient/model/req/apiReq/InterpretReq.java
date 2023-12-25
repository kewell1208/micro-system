package com.tclab.weixinappletuserclient.model.req.apiReq;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



@Data
@ApiModel(value = "报告解读上传参数", description = "报告解读上传参数")
public class InterpretReq {

    //private Integer payType;
    //private String reportId;
    @ApiModelProperty(value = "患者描述内容", required = true)
    private String describe;
    @ApiModelProperty(value = "患者检验细项报告单号，以逗号隔开的字符串")
    private String goodnos;
    @ApiModelProperty(value = "患者自己提供的报告单图片，以逗号隔开的字符串")
    private String srcUrls;
    @ApiModelProperty(value = "患者订单号")
    private String orderno;
    @ApiModelProperty(value = "登陆用户id")
    private String userId;
    @ApiModelProperty(value = "登陆用户id所选参检人id")
    private String participantId;
    @ApiModelProperty(value = "医生编号")
    private String doctorId;
    @ApiModelProperty(value = "解读类型0自身患者1他人解读患者")
    private String type;
    @ApiModelProperty(value = "解读费用")
    private String cost;
   /* @ApiModelProperty(value = "interpret表主键，非查询方法该参数默认为空")
    private String interpret;*/


}
