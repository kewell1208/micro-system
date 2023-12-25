package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "ParticipantBaseVo",description = "参检人信息")
public class ParticipantBaseVo {

    @ApiModelProperty(value = "关联用户ID",required = true)
    private String userId;
    @ApiModelProperty(value = "参检人ID",required = true)
    private String participantId;
    @ApiModelProperty(value = "参检人姓名",required = true)
    private String participantName;
    @ApiModelProperty(value = "参检人联系方式",required = true)
    private String participantPhone;
    @ApiModelProperty(value = "参检人性别",required = true)
    private Integer participantSex;
    @ApiModelProperty(value = "参检人年龄",required = true)
    private Integer participantAge;
    @ApiModelProperty(value = "参检人身份证号",required = true)
    private String participantIdCard;
    @ApiModelProperty(value = "用户关系",required = true)
    private String participantRelationship;
    @ApiModelProperty(value = "服务地址",required = true)
    private String participantAddress;
    @ApiModelProperty(value = "病史",required = true)
    private String participantMedicalHistory;
    @ApiModelProperty(value = "备注",required = true)
    private String participantRemark;
    @ApiModelProperty(value = "认证标记",required = true)
    private Integer verifyFlag;

}
