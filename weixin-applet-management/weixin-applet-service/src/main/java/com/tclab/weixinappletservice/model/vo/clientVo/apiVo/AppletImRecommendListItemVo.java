package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.pojo.AppletImRecommendListItem;
import lombok.Data;

@Data
public class AppletImRecommendListItemVo extends AppletImRecommendListItem {

    private String clinicalSignificance;

    private String packageSpecialRequirement;

}
