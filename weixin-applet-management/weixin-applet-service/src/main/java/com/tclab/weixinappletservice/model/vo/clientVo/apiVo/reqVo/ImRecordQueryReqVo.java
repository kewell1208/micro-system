package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.adminVo.apiVo
 * @Class：ImRecordReqVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/9 9:55 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class ImRecordQueryReqVo {

  private String doctorIds;
  private String userIds;
  private String status;
  private String type;
  private String fromDate;
  private String toDate;
  private Integer pageNo;
  private Integer pageSize;
  private String participantQuery;

}
