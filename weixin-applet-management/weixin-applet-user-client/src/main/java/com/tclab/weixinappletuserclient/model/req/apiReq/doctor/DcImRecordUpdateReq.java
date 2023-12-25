package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcImRecordUpdateReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/10 4:02 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@ApiModel(value = "im沟通记录状态参数", description = "im沟通记录状态参数")
@Data
public class DcImRecordUpdateReq {

  @ApiModelProperty(value = "im沟通记录ID",required = true)
  private String imRecordId;
  @ApiModelProperty(value = "问诊状态 0:初始值;1:新问诊;2:正在问诊;3:问诊结束")
  private String status;

}
