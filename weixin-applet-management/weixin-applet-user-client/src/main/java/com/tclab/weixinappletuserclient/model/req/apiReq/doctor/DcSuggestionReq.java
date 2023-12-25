package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcSuggestionReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/25 11:13 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "医生填写问诊意见参数", description = "医生填写问诊意见参数")
public class DcSuggestionReq {

  @ApiModelProperty(value = "报告解读id", required = true)
  private String interpretId;
  @ApiModelProperty(value = "im即时通讯id", required = true)
  private String imRecordId;
  @ApiModelProperty(value = "意见内容", required = true)
  private String interpretContent;
  @ApiModelProperty(value = "患者诊断", required = true)
  private String participantDiagnose;
  @ApiModelProperty(value = "图片地址", required = true)
  private String imgUrl;
  @ApiModelProperty(value = "医生id")
  private String doctorId;
  @ApiModelProperty(value = "患者id")
  private String participantId;

}
