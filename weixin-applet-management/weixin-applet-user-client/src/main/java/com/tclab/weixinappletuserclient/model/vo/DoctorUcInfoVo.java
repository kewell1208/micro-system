package com.tclab.weixinappletuserclient.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class DoctorUcInfoVo {

    private String doctorId;

    private String doctorName;

    private String hospitalId;

    private String hospitalName;

    private String doctorDepartmentId;

    private String departmentName;

    private String doctorRank;

    private String doctorIntroduction;

    private String doctorExpert;

    private Integer doctorInquiryCount;

    private Integer doctorInterpretCount;

    private Double doctorScore;

    private String doctorLogo;

    private String doctorLabel;

    private BigDecimal doctorInquiryPrice;

    private BigDecimal doctorInquiryImagePrice;

    private BigDecimal doctorInquiryPhonePrice;

    private BigDecimal doctorInterpretPrice;

    private List<DoctorCommentBaseInfoVo> commentList = new ArrayList<>();

    private Integer attentionFlag;

}
