package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcRecommendItemReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/9 4:51 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "单个患者检验清单参数", description = "单个患者检验清单参数")
public class DcRecommendListQueryReq {

  @ApiModelProperty(value = "医生id", required = true)
  private String doctorId;
  @ApiModelProperty(value = "患者id")
  private String participantId;
  @ApiModelProperty(value = "复诊状态0初诊开单1复诊审核")
  private String reviewType;
  @ApiModelProperty(value = "推荐状态-1已失效0初始状态1已确认2付款推荐成功")
  private String recommendStatus;
  @ApiModelProperty(value = "检验清单id")
  private String imRecommendListId;
  @ApiModelProperty(value = "患者手机号或姓名")
  private String participantQuery;
  @ApiModelProperty(value = "页码")
  private Integer pageNo;
  @ApiModelProperty(value = "页数")
  private Integer pageSize;

}
