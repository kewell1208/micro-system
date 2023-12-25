package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo
 * @Class：DoctorFeeReqVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/21 11:07 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class DoctorFeeReqVo {

  private String doctorPhone;
  private Double inquiryPrice;
  private Double interpretPrice;

}
