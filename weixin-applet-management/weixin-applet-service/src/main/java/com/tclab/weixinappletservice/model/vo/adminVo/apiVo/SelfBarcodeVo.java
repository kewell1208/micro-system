package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "SelfBarcodeVo",description = "自采用户绑定条码的请求")
public class SelfBarcodeVo {

    @ApiModelProperty(value = "套餐名",required = false)
    private String packageName;
    @ApiModelProperty(value = "商品编号",required = true)
    private String goodNo;
    @ApiModelProperty(value = "二维码",required = true)
    private String barcode;

}
