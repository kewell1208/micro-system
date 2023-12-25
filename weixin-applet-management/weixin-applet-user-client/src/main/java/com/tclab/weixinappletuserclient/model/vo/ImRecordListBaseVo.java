package com.tclab.weixinappletuserclient.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import lombok.Data;

@Data
public class ImRecordListBaseVo {

  private String imRecordId;

  private String doctorId;

  private String doctorName;

  private String doctorRank;

  private String userId;

  private String userPhone;

  private String participantId;

  private String participantName;

  @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm")
  private Date createDate;

  private Integer payStatus;

  private Integer status;

  private Integer type;

  @JsonFormat(timezone = "GMT+8", pattern = "yyyy/MM/dd HH:mm")
  private Date interpretFinishDate;

  private String doctorHospitalName;

  private String doctorDepartmentName;

}
