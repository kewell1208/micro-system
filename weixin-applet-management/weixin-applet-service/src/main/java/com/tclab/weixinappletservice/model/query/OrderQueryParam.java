package com.tclab.weixinappletservice.model.query;

import lombok.Data;

import java.util.List;

@Data
public class OrderQueryParam {

    private String orderNo;

    private String participantPhone;

    private List<Integer> serviceTypes;

    private String acquisitionId;

    private String acquisitionName;

    private String staffId;

    private String staffName;

    private Integer orderStatus;

    private List<Integer> logisticsStatus;

    private Integer orderExceptionStatus;

    private Integer orderExceptionReason;

    private Integer pageNo = 1;

    private Integer pageSize = 20;

    private String logisticsId;

    private Integer RefundStatus;

}
