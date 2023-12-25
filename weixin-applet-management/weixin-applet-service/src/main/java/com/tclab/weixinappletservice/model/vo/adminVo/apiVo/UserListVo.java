package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Package：com.tclab.wxmabackapi.model.apiVo
 * @Class：UserListVo
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/8 9:30
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "UserListVo",description = "JsonResNewVo泛型")
public class UserListVo {

    private Integer id;
    @ApiModelProperty(value = "用户ID",required = true)
    private String userId;
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(value = "别名",required = false)
    private String nickname;
    @ApiModelProperty(value = "手机号",required = true)
    private String userPhone;
    @ApiModelProperty(value = "用户类型",required = true)
    private Integer userType;
    @ApiModelProperty(value = "用户性别",required = false)
    private Integer sex;
    @ApiModelProperty(value = "用户年龄",required = false)
    private Integer age;
    @ApiModelProperty(value = "备注",required = false)
    private String userRemark;
    @ApiModelProperty(value = "注册时间",required = true)
    private Date createDate;
    @ApiModelProperty(value = "身份证号",required = false)
    private String userIdCard;



}
