package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "UserLoginVo",description = "JsonResNewVo泛型")
public class UserLoginVo {

    @ApiModelProperty(value = "id",required = true)
    private Integer id;
    @ApiModelProperty(value = "uuid",required = true)
    private String uuid;
    @ApiModelProperty(value = "微信小程序openId",required = true)
    private String openid;
    @ApiModelProperty(value = "用户Id",required = true)
    private String userId;
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(value = "昵称",required = true)
    private String nickname;
    @ApiModelProperty(value = "用户身份证",required = true)
    private String userIdCard;
    @ApiModelProperty(value = "用户手机",required = true)
    private String userPhone;
    @ApiModelProperty(value = "用户密码",required = true)
    private String userPassword;
    @ApiModelProperty(value = "用户类型",required = true)
    private Integer userType;
    @ApiModelProperty(value = "性别",required = true)
    private Integer sex;
    @ApiModelProperty(value = "年龄",required = true)
    private Integer age;
    @ApiModelProperty(value = "备注",required = true)
    private String userRemark;

}
