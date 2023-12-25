package com.tclab.weixinappletuserclient.model.req.apiReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq
 * @Class：QrReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/11/18 3:35 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "小程序码生成参数",description = "小程序码生成参数")
public class QrReq {

  @ApiModelProperty(value = "套餐id",required = true)
  private String packageIds;
  @ApiModelProperty(value = "采集点id",required = true)
  private String acquisitionId;
  @ApiModelProperty(value = "文件名称",required = true)
  private String fileName;
}
