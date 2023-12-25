package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ImReqVo {

    private String imRecordId;

    private String doctorId;

    private String userId;

    private String openid;

    private String userPhone;

    private String participantId;

    private String participantName;

    private Integer status;

    private Integer type;

    private BigDecimal amount;

    private Integer payStatus;

    private BigDecimal payAmount;

    private String preNo;

    private String payNo;

    private Date payDate;

    private Date finishDate;

    private String participantPhone;

}
