package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Package：com.tclab.wxmabackapi.model.apiVo
 * @Class：PackageVo
 * @Description： 套餐列表对象
 * @Author：yuzh
 * @Date：Created in 2019/4/2 15:35
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "PackageListVo",description = "JsonResNewVo泛型")
public class PackageListVo {

    @ApiModelProperty(value = "套餐编号",required = true)
    private String packageId;
    @ApiModelProperty(value = "套餐名称",required = true)
    private String packageName;
    @ApiModelProperty(value = "套餐原价",required = true)
    private BigDecimal packagePrimePrice;
    @ApiModelProperty(value = "套餐价格",required = true)
    private BigDecimal packageCurrentPrice;
    @ApiModelProperty(value = "套餐状态",required = true)
    private Integer packageStatus;

}
