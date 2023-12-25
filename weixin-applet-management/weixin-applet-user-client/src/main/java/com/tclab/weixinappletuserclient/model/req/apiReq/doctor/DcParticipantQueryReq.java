package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcParticipantReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/9 4:04 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "患者信息查询参数",description = "患者信息查询参数")
public class DcParticipantQueryReq {

  @ApiModelProperty(value = "患者id",required = true)
  private String participantId;


}
