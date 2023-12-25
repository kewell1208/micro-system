package com.tclab.weixinappletuserclient.model.req.apiReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq
 * @Class：ImLogin
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/11 11:22 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@ApiModel("im登录参数")
@Data
public class ImLoginReq {

  @ApiModelProperty(value = "用户userid", required = true)
  private String userId;
  @ApiModelProperty(value = "sdkAppId", required = true)
  private Long sdkAppId;
  @ApiModelProperty(value = "secretKey", required = true)
  private String secretKey;


}
