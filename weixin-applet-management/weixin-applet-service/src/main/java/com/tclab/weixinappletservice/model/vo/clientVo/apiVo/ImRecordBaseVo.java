package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.pojo.AppletDoctor;
import java.math.BigDecimal;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo
 * @Class：ImRecordBaserVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/23 11:26 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class ImRecordBaseVo {

  private Integer id;

  private String imRecordId;

  private String doctorId;

  private String userId;

  private String userPhone;

  private String participantId;

  private String participantName;

  private String participantPhone;

  private Integer participantSex;

  private Integer participantAge;

  private Integer status;

  private BigDecimal amount;

  private Integer type;

  private Integer delFlag;

  private String createDate;

  private String updateDate;

  private Integer payStatus;

  private BigDecimal payAmount;

  private String preNo;

  private String payNo;

  private String payDate;

  private String finishDate;

  private AppletDoctor doctorInfo;

  private String interpretIds;

}
