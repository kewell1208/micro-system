package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo
 * @Class：ImRecommendListBaseVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/23 3:08 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class ImRecommendListBaseVo {

  private Integer id;

  private String imRecommendListId;

  private String doctorId;

  private String doctorName;

  private String userId;

  private String participantId;

  private String participantName;

  private Integer participantSex;

  private Integer participantAge;

  private String participantPhone;

  private String participantMedicalHistory;

  private String participantIdCard;

  private Integer reviewType;

  private Integer delFlag;

  private String createDate;

  private String updateDate;

  private String orderNo;

  private Integer recommendStatus;
}
