package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.adminVo.apiVo.reqVo
 * @Class：RecommendListReqVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/10 9:23 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class ImRecommendListQueryReqVo {

  private String doctorId;
  private String participantId;
  private String reviewType;
  private String recommendStatus;
  private Integer pageNo;
  private Integer pageSize;
  private String imRecommendListId;
  private String participantQuery;
}
