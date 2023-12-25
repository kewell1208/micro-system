package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Package：com.tclab.wxmabackapi.model.req
 * @Class：QueryPackageReq
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/2 15:59
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "用户列表参数",description = "用户列表参数")
public class QueryUserReqVo {

    @ApiModelProperty(value = "用户姓名",required = false)
    private String nickname;
    @ApiModelProperty(value = "用户联系方式",required = false)
    private String userPhone;
    @ApiModelProperty(value = "注册时间",required = false)
    private List<String> createDate;
    @ApiModelProperty(value = "页码",required = false)
    private Integer pageNo = 1;
    @ApiModelProperty(value = "每页大小",required = false)
    private Integer pageSize = 20;
}
