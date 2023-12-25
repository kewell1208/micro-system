package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package：com.tclab.wxmabackapi.model.apiVo
 * @Class：UserDetailVo
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/8 9:34
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "UserDetailVo",description = "JsonResNewVo泛型")
public class UserDetailVo {

    private Integer id;
    @ApiModelProperty(value = "用户ID",required = true)
    private String userId;
    @ApiModelProperty(value = "用户名",required = true)
    private String userName;
    @ApiModelProperty(value = "别名",required = false)
    private String nickname;
    @ApiModelProperty(value = "手机号",required = true)
    private String userPhone;
    @ApiModelProperty(value = "用户性别",required = false)
    private Integer sex;
    @ApiModelProperty(value = "参检人信息列表",required = false)
    private List<ParticipantBaseVo> participantBaseVoList = new ArrayList<>();
    @ApiModelProperty(value = "服务地址列表",required = false)
    private List<ServiceInfoBaseVo> serviceInfoBaseVoList = new ArrayList<>();
}
