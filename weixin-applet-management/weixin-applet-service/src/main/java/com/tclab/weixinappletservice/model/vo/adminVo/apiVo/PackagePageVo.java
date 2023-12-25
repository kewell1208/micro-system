package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package：com.tclab.wxmabackapi.model.apiVo
 * @Class：PackagePageVo
 * @Description： 套餐分页对象
 * @Author：yuzh
 * @Date：Created in 2019/4/2 15:48
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "PackagePageVo",description = "JsonResNewVo泛型")
public class PackagePageVo {

    @ApiModelProperty(value = "总页数",required = true)
    private Integer pageNum;
    @ApiModelProperty(value = "总套餐数",required = true)
    private Long packageNum;
    @ApiModelProperty(value = "当前页数",required = true)
    private Integer currentPageNo;
    @ApiModelProperty(value = "套餐详情",required = true)
    private List<PackageListVo> packageListVoList = new ArrayList<>();
}
