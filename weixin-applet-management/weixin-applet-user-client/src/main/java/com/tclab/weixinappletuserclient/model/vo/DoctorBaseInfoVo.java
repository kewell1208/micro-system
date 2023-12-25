package com.tclab.weixinappletuserclient.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
public class DoctorBaseInfoVo {

    private String doctorId;

    private String doctorName;

    private String hospitalId;

    private String hospitalName;

    private String doctorDepartmentId;

    private String departmentName;

    private String doctorRank;

    private String doctorLogo;

    private Double doctorScore;

    private BigDecimal doctorInquiryPrice;

    private BigDecimal doctorInquiryImagePrice;

    private BigDecimal doctorInquiryPhonePrice;

    private BigDecimal doctorInterpretPrice;

    private String doctorIntroduction;

    private String doctorExpert;

}
