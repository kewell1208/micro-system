package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcRecommendListUpdateReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/23 3:55 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@ApiModel(value = "修改检验单参数",description = "修改检验单参数")
@Data
public class DcRecommendListUpdateReq {

  @ApiModelProperty(value = "检验清单id",required = true)
  private String imRecommendListIds;
  @ApiModelProperty(value = "推荐状态0初始状态1已确认2付款推荐成功",required = true)
  private Integer recommendStatus;
  @ApiModelProperty(value = "套餐编号")
  private String packageNos;

}
