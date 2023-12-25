package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcRecommendListSaveReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/10 2:38 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "保存检验单参数",description = "保存检验单参数")
public class DcRecommendListSaveReq {

  @ApiModelProperty(value = "推荐单ID",required = false)
  private String imRecommendListId;
  @ApiModelProperty(value = "医生id",required = false)
  private String doctorId;
  @ApiModelProperty(value = "医生姓名",required = false)
  private String doctorName;
  @ApiModelProperty(value = "IM即时通讯id",required = true)
  private String imRecordId;
  @ApiModelProperty(value = "患者id",required = true)
  private String participantId;
  @ApiModelProperty(value = "复诊状态0初诊开单1复诊审核",required = false)
  private Integer reviewType;
  @ApiModelProperty(value = "套餐id",required = false)
  private String packageNo;
  @ApiModelProperty(value = "推荐状态0已开单1已确认2已付款",required = true)
  private Integer recommendStatus;
  @ApiModelProperty(value = "用户id",required = false)
  private String userId;
  @ApiModelProperty(value = "开单套餐id列表",required = false)
  private List<String> openPackageIdList;
  @ApiModelProperty(value = "确认套餐id列表",required = false)
  private List<String> confirmPackageIdList;
  @ApiModelProperty(value = "支付套餐id列表",required = false)
  private List<String> payPackageIdList;
  @ApiModelProperty(value = "推荐单备注",required = false)
  private String recommendRemark;
}
