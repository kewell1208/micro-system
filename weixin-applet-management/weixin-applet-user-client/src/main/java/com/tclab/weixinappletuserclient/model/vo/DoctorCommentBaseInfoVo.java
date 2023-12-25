package com.tclab.weixinappletuserclient.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class DoctorCommentBaseInfoVo {

    private String doctorId;

    private String participantId;

    private String participantName;

    private String participantComment;

    private Double participantScore;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy/MM/dd HH:mm")
    private Date createDate;

}
