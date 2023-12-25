package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "ThirdLogisticsBaseVo",description = "第三方物流送检信息")
public class ThirdLogisticsBaseVo {

    private Integer id;
    private String logisticsId;
    private Integer logisticsType;
    private String logisticsSourceId;
    private Integer logisticsOrderNum;
    private String logisticsRemark;
    private Integer logisticsStatus;
    private String expressName;
    private String waybillNo;
    private String expressImage;
    private String logisticsArrivedDate;
    private String logisticsApplyDate;
    private Integer delFlag;
    private String createDate;

}
