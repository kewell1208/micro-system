package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo
 * @Class：ImRecordUpdateReqVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/10 4:07 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class ImRecordUpdateReqVo {

  private String interpretId;
  private String imRecordId;
  private String userId;
  private String doctorId;
  private String participantId;
  private String status;
  private String interpretContent;
  private String participantDiagnose;
  private String imgUrl;

}
