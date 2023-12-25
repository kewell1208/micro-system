package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package：com.tclab.wxmabackapi.model.apiVo
 * @Class：UserPageVo
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/8 9:31
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "UserPageVo",description = "JsonResNewVo泛型")
public class UserPageVo {

    @ApiModelProperty(value = "总页数",required = true)
    private Integer pageNum;
    @ApiModelProperty(value = "总用户数",required = true)
    private Long userNum;
    @ApiModelProperty(value = "当前页数",required = true)
    private Integer currentPageNo;
    @ApiModelProperty(value = "用户列表",required = true)
    private List<UserListVo> userListVoList = new ArrayList<>();

}
