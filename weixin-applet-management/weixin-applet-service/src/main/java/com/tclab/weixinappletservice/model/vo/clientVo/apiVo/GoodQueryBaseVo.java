package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo
 * @Class：GoodQueryBaseVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/25 4:28 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class GoodQueryBaseVo {

  private Integer id;

  private String orderNo;

  private String goodNo;

  private String userId;

  private String participantId;

  private String packageId;

  private String packageName;

  private Integer packageNum;

  private String acquisitionId;

  private String acquisitionName;

  private String goodApplyDate;

  private String goodCurrentApplyDate;

  private String goodCompleteApplyDate;

  private String staffId;

  private String staffPhone;

  private String staffName;

  private BigDecimal costStaffCommission;

  private String acquisitionDepartmentId;

  private String acquisitionDepartmentName;

  private String costDepartmentCommission;

  private String recommeddOrganizationId;

  private String recommeddOrganizationName;

  private BigDecimal costOrganizationCommission;

  private BigDecimal costAcquisitionCharge;

  private BigDecimal payAmount;

  private BigDecimal discountAmount;

  private BigDecimal totalAmount;

  private Integer serviceType;

  private String sampleNo;

  private String sampleCollectDate;

  private Integer reportType;

  private BigDecimal reportCost;

  private String reportImg;

  private String reportDate;

  private String doctorName;

  private String doctorPhone;

  private Integer goodStatus;

  private Integer exceptionStatus;

  private Integer exceptionReason;

  private Integer exceptionSolution;

  private String exceptionSolveTime;

  private Integer refundStatus;

  private Integer refundReason;

  private Integer refundAmount;

  private String refundRemark;

  private Integer delFlag;

  private String createDate;

  private String updateDate;

  private String collectorStaffId;

  private String pdfUrl;

  private String pdfMergeUrl;
//解读商品状态
  public Integer status;
}
