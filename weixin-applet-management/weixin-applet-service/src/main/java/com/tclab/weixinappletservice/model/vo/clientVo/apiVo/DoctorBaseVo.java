package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo
 * @Class：DoctorBaseVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/10/13 3:27 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class DoctorBaseVo {
  private Integer id;

  private String doctorId;

  private String doctorName;

  private String doctorSex;

  private String doctorPhone;

  private String doctorIdCard;

  private String hospitalId;

  private String hospitalName;

  private String doctorDepartmentId;

  private String doctorDepartmentName;

  private Integer doctorType;

  private String doctorRank;

  private String doctorRankImage;

  private String doctorJobImage;

  private String doctorIntroduction;

  private String doctorExpert;

  private String doctorRemark;

  private Integer verifyFlag;

  private Integer delFlag;

  private String createDate;

  private String updateDate;

  private Integer doctorStatus;

  private Double doctorScore;

  private String doctorLogo;

  private BigDecimal doctorInquiryPrice;

  private BigDecimal doctorInquiryImagePrice;

  private BigDecimal doctorInquiryPhonePrice;

  private Integer doctorInquiryCount;

  private BigDecimal doctorInterpretPrice;

  private Integer doctorInterpretCount;

  private String doctorLabel;

  private String doctorQrcode;

  private String doctorUuid;

  private String doctorOpenid;

  private String doctorPassword;

  public Long attentionNum;

  private Integer doctorAuthority;

  private Integer doctorOrderCredentials;
}
