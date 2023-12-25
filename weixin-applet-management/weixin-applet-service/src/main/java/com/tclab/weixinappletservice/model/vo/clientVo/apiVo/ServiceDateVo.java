package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo
 * @Class：ServiceDateVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/27 2:23 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class ServiceDateVo {

  private String serviceDate;
  private String serviceId;
  /**
   * 1：患者问诊 2：开检验清单 3：报告解读
   */
  private Integer type;

}
