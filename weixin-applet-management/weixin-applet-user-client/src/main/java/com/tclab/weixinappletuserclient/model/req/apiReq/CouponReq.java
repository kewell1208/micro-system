package com.tclab.weixinappletuserclient.model.req.apiReq;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletuserclient.model.req.apiReq
 * @Class：CouponReq
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/10/16 10:20 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
@ApiModel(value = "查询优惠卷参数",description = "查询优惠卷参数")
public class CouponReq {

  @ApiModelProperty(value = "用户id",required = true)
  private String userId;

}
