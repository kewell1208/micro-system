package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcMyPaticipantQueryReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/27 10:57 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@ApiModel(value = "我的患者信息查询参数", description = "我的患者信息查询参数")
@Data
public class DcMyParticipantQueryReq {

  @ApiModelProperty(value = "医生id", required = true)
  private String doctorId;
  @ApiModelProperty(value = "患者id")
  private String participantId;
  @ApiModelProperty(value = "患者手机号或姓名")
  private String participantQuery;
}
