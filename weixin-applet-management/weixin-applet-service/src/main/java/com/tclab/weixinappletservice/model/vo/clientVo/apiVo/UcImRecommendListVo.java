package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.pojo.AppletImRecommendListItem;
import lombok.Data;

import java.util.List;

/**
 * @Package：com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo
 * @Class：ImRecommendListVo
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/20 3:23 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Data
public class UcImRecommendListVo {

  private ImRecommendListBaseVo imRecommendListBaseVo;
  private List<AppletImRecommendListItemVo> appletImRecommendListItemList;
}
