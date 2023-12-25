package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcPasswordReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/26 3:02 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "修改密码参数", description = "修改密码参数")
public class DcPasswordReq {

  @ApiModelProperty(value = "用户名", required = true)
  private String username;
  @ApiModelProperty(value = "新密码", required = true)
  private String newPassword;
  @ApiModelProperty(value = "验证码")
  private String verificationCode;
}
