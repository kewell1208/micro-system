package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcLogin
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/11 10:43 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "登录参数", description = "登录参数")
public class DcLoginReq {

  @ApiModelProperty(value = "用户名", required = true)
  private String username;
  @ApiModelProperty(value = "密码")
  private String password;
  @ApiModelProperty(value = "验证码")
  private String verificationCode;
  @ApiModelProperty(value = "session密匙")
  private String sessionKey;
  @ApiModelProperty(value = "类型1密码登录2验证码登录3免登录", required = true)
  private Integer type;
}
