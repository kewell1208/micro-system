package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcParticipantListReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/5 10:08 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "患者列表查询参数", description = "患者列表查询参数")
public class DcParticipantListQueryReq {

  @ApiModelProperty(value = "医生编号列表", required = true)
  private String doctorIds;
  @ApiModelProperty(value = "用户id")
  private String userIds;
  @ApiModelProperty(value = "状态 0:新沟通;2:正在沟通;3:沟通结束")
  private String status;
  @ApiModelProperty(value = "状态 0:新沟通;1:正在沟通;2:沟通结束")
  private String type;
  @ApiModelProperty(value = "开始时间")
  private String fromDate;
  @ApiModelProperty(value = "结束时间")
  private String toDate;
  @ApiModelProperty(value = "患者手机号或姓名")
  private String participantQuery;
  @ApiModelProperty(value = "页码")
  private Integer pageNo;
  @ApiModelProperty(value = "页数")
  private Integer pageSize;

}
