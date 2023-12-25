package com.tclab.weixinappletuserclient.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class ImRecommendListBaseVo {

    private String imRecommendListId;

    private String doctorId;

    private String doctorName;

    private String hospitalId;

    private String hospitalName;

    private String departmentName;

    private String doctorRank;

    private String userId;

    private String participantId;

    private String participantName;

    @JsonFormat(timezone = "GMT+8",pattern = "yyyy/MM/dd HH:mm")
    private Date createDate;

    private Integer recommendStatus;

}
