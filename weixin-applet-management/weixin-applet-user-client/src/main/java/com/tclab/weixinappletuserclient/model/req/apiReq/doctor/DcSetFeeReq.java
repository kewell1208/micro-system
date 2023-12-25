package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcSetFeeReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/21 11:01 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@ApiModel(value = "设置医生费用参数", description = "设置医生费用参数")
@Data
public class DcSetFeeReq {

  @ApiModelProperty(value = "医生手机号")
  private String doctorPhone;
  @ApiModelProperty(value = "问诊价格")
  private Double inquiryPrice;
  @ApiModelProperty(value = "解读价格")
  private Double interpretPrice;
}
