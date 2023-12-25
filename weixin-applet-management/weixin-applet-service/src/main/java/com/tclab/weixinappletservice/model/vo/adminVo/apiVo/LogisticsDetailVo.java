package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel(value = "LogisticsDetailVo",description = "JsonResNewVo泛型")
public class LogisticsDetailVo {

    private Integer id;

    private String logisticsId;

    private Integer logisticsType;

    private String sourceId;

    private String sourceName;

    private Integer orderNum;

    private String logisticsRemark;

    private Integer logisticsStatus;

    private String expressName;

    private String waybillNo;

    private String expressImage;

    private String clerkId;

    private String clerkName;

    private String clerkPhone;

    private String logisticsApplyDate;

    private String logisticsPickDate;

    private String logisticsArrivedDate;

    private Integer delFlag;

    private String createDate;

    private String acquisitionId;

    private String acquisitionName;

    private String acquisitionAddress;

    private String operatorId;

    private String operatorName;

    private String operatorPhone;

    private List<OrderBaseVo> orderBaseVoList = new ArrayList<>();

}
