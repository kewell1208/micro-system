package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcReportReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/11 2:55 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@ApiModel("单个患者报告记录")
@Data
public class DcReportReq {

  @ApiModelProperty(value = "患者id", required = true)
  private String participantId;


}
