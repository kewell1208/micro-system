package com.tclab.weixinappletadminclient.model.req;

import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.SelfBarcodeVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(value = "ThirdSelfReq",description = "发送样本盒物流")
public class ThirdSelfReq {

    @ApiModelProperty(value = "订单号",required = true)
    private String orderNo;
    @ApiModelProperty(value = "物流商品名",required = false)
    private String logisticsGood;
    @ApiModelProperty(value = "物流备注",required = true)
    private String logisticsRemark;
    @ApiModelProperty(value = "物流订单数,可以不填",required = false)
    private Integer logisticsOrderNum;
    @ApiModelProperty(value = "运单号",required = true)
    private String waybillNo;
    @ApiModelProperty(value = "快递名",required = true)
    private String expressName;
    @ApiModelProperty(value = "采集盒条码",required = true)
    private List<SelfBarcodeVo> barcodeVoList;
    @ApiModelProperty(value = "操作人员ID",required = true)
    private String collectorStaffId;
}
