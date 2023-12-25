package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo
 * @Class：PackageVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/10/9 6:16 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class PackageVo {

  private Integer id;

  private String packageId;

  private String labCode;

  private String packageName;

  private String packageLogo;

  private String packageInfo;

  private String packageLabel;

  private Integer packageRecommendation;

  private Integer packagePriority;

  private String packageCatalogId;

  private String packageMessage;

  private String packagePurposeId;

  private String packagePopulationId;

  private String populationName;

  private String packageSourceId;

  private String packageSourceName;

  private String packageRemark;

  private BigDecimal packagePrimePrice;

  private BigDecimal packageCurrentPrice;

  private Integer packageStatus;

  private Integer packageCollectType;

  private String packageSamplePic;

  private String packageStep;

  private Integer packageReportType;

  private BigDecimal packageReportCharge;

  private String packageReportTime;

  private String reportTimeDesc;

  private String sampleTypeName;

  private Integer sampleType;

  private String packageSpecialRequirement;

  private String packageEquipment;

  private String storageCondition;

  private Integer delFlag;

  private Date createDate;

  private Date updateDate;

  private String testObjectId;

  private String clinicalSignificance;

  private String labGroup;

  private String priceCode;

  private String recommendStatus;

  private String packageType;
}
