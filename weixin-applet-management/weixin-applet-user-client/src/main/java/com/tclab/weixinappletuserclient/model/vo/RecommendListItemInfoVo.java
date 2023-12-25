package com.tclab.weixinappletuserclient.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RecommendListItemInfoVo {

    private String imRecommendListId;

    private String itemId;

    private String packageNo;

    private String packageName;

    private BigDecimal packageCurrentPrice;

    private Integer delFlag;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy/MM/dd HH:mm")
    private Date createDate;

    private Integer recommendStatus;

    private String clinicalSignificance;

}
