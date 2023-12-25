package com.tclab.weixinappletadminclient.model.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 后台登陆参数
 */
@Data
@ApiModel(value = "登陆参数",description = "登陆请求")
public class LoginReq {

    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(value = "用户手机号",required = false)
    private String userPhone;
    @ApiModelProperty(value = "用户密码",required = true)
    private String password;

}
