package com.tclab.weixinappletuserclient.model.req.apiReq;

import lombok.Data;

@Data
public class QueryImRecommendReq {

    private String imRecommendListId;

    private String doctorId;

    private String doctorName;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private Integer reviewType;

    private String orderNo;

    private Integer recommendStatus;

    private String userId;

    private String queryDate;

    private Integer status;

    private Integer type;

}
