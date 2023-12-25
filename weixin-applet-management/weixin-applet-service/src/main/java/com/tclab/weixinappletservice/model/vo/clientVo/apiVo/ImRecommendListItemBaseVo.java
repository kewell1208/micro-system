package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo
 * @Class：ImRecommendListItemBaseVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/23 3:09 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class ImRecommendListItemBaseVo {
  private Integer id;

  private String imRecommendListId;

  private String itemId;

  private String packageNo;

  private String packageName;

  private BigDecimal packageCurrentPrice;

  private Integer delFlag;

  private String createDate;

  private String updateDate;

  private Integer recommendStatus;

  private String goodNo;

}
