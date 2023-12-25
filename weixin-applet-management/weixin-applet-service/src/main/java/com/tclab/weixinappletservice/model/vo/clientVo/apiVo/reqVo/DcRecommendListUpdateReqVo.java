package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo
 * @Class：DcRecommendListUpdateReqVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/23 4:32 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class DcRecommendListUpdateReqVo {

  private String imRecommendListIds;
  private Integer recommendStatus;
  private String packageNos;
}
