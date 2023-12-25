package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcRecommendListItemQueryReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/21 3:45 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "单个检验清单参数", description = "单个检验清单参数")
public class DcRecommendListItemQueryReq {

  @ApiModelProperty(value = "检验清单id", required = true)
  private String ImRecommendListId;
}
