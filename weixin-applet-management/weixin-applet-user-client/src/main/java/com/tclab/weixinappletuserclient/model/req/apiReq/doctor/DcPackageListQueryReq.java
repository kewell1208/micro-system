package com.tclab.weixinappletuserclient.model.req.apiReq.doctor;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq.doctor
 * @Class：DcPackageListReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/10 2:15 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "检验套餐查询参数", description = "检验套餐查询参数")
public class DcPackageListQueryReq {

  @ApiModelProperty(value = "套餐来源ID", required = true)
  private String packageSourceId;
  @ApiModelProperty(value = "套餐名")
  private String packageName;
  @ApiModelProperty(value = "套餐id")
  private String packageNo;
  @ApiModelProperty(value = "页码")
  private Integer pageNo;
  @ApiModelProperty(value = "页数")
  private Integer pageSize;

}
