package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo
 * @Class：LoginReqVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/11 10:49 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class LoginReqVo {
  private String username;
  private String password;
  private Integer userType;
}
