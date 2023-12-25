package com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo;

import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ImRecommendListBaseVo;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListItem;
import java.util.List;
import lombok.Data;

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
public class ImRecommendListVo {

  private ImRecommendListBaseVo imRecommendListBaseVo;
  private List<AppletImRecommendListItem> appletImRecommendListItemList;
}
