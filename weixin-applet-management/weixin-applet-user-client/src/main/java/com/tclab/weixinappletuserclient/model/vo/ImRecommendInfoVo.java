package com.tclab.weixinappletuserclient.model.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ImRecommendInfoVo {

    private String imRecommendListId;

    private String doctorId;

    private String doctorName;

    private String departmentName;

    private String doctorRank;

    private String userId;

    private String participantId;

    private String participantName;

    private Date createDate;

    private String createDateStr;

    private String hospitalId;

    private String hospitalName;

    private List<RecommendListItemInfoVo> itemInfoVoList = new ArrayList<>();

}
