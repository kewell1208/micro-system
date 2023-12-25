package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcInterpretQueryReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/12 10:57 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@ApiModel(value = "报告解读查询参数", description = "报告解读查询参数")
@Data
public class DcInterpretQueryReq {

  @ApiModelProperty(value = "解读id", required = true)
  private String interpretId;


}
