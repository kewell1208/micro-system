package com.tclab.weixinappletuserclient.model.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RecommendListInfoVo {

    private List<RecommendListItemInfoVo> itemInfoVoList = new ArrayList<>();

    private String imRecommendListId;

    private String doctorId;

    private String doctorName;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private String participantMedicalHistory;

    private String participantIdCard;

    private Integer reviewType;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private String orderNo;

    private Integer recommendStatus;

}
