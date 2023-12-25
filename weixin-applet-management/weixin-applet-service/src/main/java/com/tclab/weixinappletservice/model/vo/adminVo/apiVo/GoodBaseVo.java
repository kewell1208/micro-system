package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel(value = "GoodBaseVo",description = "商品信息")
public class GoodBaseVo {

    private Integer id;

    private String orderNo;

    private String goodNo;

    private String packageId;

    private String packageName;

    private Integer packageNum;

    private String acquisitionId;

    private String acquisitionName;

    private BigDecimal payAmount;

    private BigDecimal goodAmount;

    private BigDecimal discountAmount;

    private BigDecimal totalAmount;

    private Integer reportType;

    private BigDecimal reportCost;

    private Integer goodStatus;

    private Integer delFlag;


}
