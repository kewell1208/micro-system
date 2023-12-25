package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "ThirdSelfLogisticsBaseVo",description = "样本盒物流")
public class ThirdSelfLogisticsBaseVo {

    private Integer id;
    private String thirdLogisticsId;
    private String orderNo;
    private String logisticsGood;
    private String logisticsRemark;
    private Integer logisticsOrderNum;
    private Integer logisticsStatus;
    private String waybillNo;
    private String expressName;
    private String expressImage;
    private String logisticsArrivedDate;
    private Integer delFlag;
    private String createDate;

}
