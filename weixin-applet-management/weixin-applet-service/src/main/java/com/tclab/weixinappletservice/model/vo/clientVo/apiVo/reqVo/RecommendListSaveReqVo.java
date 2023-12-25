package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo
 * @Class：DcRecommendListSaveReqVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/10 2:51 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class RecommendListSaveReqVo {

  private String imRecommendListId;
  private String doctorId;
  private String doctorName;
  private String imRecordId;
  private String participantId;
  private Integer reviewType;
  private String packageNo;
  private Integer recommendStatus;
  private String userId;
  private List<String> openPackageIdList = new ArrayList<>();
  private List<String> confirmPackageIdList = new ArrayList<>();
  private List<String> payPackageIdList = new ArrayList<>();
  private String recommendRemark;
}
