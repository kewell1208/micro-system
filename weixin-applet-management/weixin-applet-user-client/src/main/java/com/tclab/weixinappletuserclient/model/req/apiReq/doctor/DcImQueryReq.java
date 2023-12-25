package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcImQueryReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/21 2:45 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "IM即时通讯记录参数",description = "IM聊天记录参数")
public class DcImQueryReq {

  @ApiModelProperty(value = "即时通讯id",required = true)
  private String imRecordId;
}
