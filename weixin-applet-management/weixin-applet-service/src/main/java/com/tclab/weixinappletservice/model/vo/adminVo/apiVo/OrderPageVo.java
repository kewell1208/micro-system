package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "OrderPageVo",description = "JsonResNewVo泛型")
public class OrderPageVo {

    @ApiModelProperty(value = "总页数",required = true)
    private Integer pageNum;
    @ApiModelProperty(value = "总订单数",required = true)
    private Long orderNum;
    @ApiModelProperty(value = "当前页数",required = true)
    private Integer currentPageNo;
    @ApiModelProperty(value = "订单详情列表",required = true)
    private List<OrderListVo> orderDetailVoList = new ArrayList<>();

}
