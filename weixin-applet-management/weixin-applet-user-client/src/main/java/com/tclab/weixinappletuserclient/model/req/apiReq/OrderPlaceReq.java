package com.tclab.weixinappletuserclient.model.req.apiReq;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class OrderPlaceReq {

    private Integer placeType = 0;

    private Integer orderType = 0;

    private Integer serviceType;

    private String acquisitionId;

    private String acquisitionName;

    private String userId;

    private String userName;

    private String userPhone;

    private String userIdCard;

    private String serviceInfoId;

    private String serviceInfoAddress;

    private String serviceInfoPerson;

    private String serviceInfoPhone;

    private String participantId;

    private String participantName;

    private String participantPhone;

    private String participantIdCard;

    private String orderApplyDate;

    private BigDecimal payAmount;

    private BigDecimal totalAmount;

    private BigDecimal discountAmount;

    private String orderRemark;

    private String imRecommendListId;

    private String doctorId;

    List<GoodPlaceReq> goods = new ArrayList<>();

  private Integer isCoupon;
}
