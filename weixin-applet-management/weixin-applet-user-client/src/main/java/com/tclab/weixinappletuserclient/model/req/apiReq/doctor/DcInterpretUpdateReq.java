package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcInterpretSaveReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/12 2:41 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@ApiModel(value = "报告解读保存参数", description = "报告解读保存参数")
@Data
public class DcInterpretUpdateReq {

  @ApiModelProperty(value = "解读id", required = true)
  private String interpretId;
  @ApiModelProperty(value = "解读内容", required = true)
  private String interpretContent;
  @ApiModelProperty(value = "解读图片地址")
  private String interpretImg;


}
