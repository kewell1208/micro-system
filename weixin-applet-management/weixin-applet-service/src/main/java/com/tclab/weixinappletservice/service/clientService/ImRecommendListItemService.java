package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletservice.dao.AppletImRecommendListItemMapper;
import com.tclab.weixinappletservice.dao.AppletImRecommendListMapper;
import com.tclab.weixinappletservice.dao.AppletPackageMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PackageVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ReInquiryPageVo;
import com.tclab.weixinappletservice.pojo.AppletImRecommendList;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListExample;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListItemExample;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListItemExample.Criteria;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package：com.tclab.weixinappletservice.service.clientService
 * @Class：ImRecommendListItemService
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/21 3:47 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Service
public class ImRecommendListItemService {

  @Autowired
  private AppletImRecommendListItemMapper imRecommendListItemMapper;
  @Autowired
  private AppletImRecommendListMapper imRecommendListMapper;
  @Autowired
  private AppletPackageMapper appletPackageMapper;

  public List<PackageVo> getPackageListByImRecommendListId(String imRecommendListId) {
    return appletPackageMapper.selectByImRecommendListId(imRecommendListId);
  }

  public List<ReInquiryPageVo> getReInquiryInfo(String imRecommendListIds) {
    List<ReInquiryPageVo> voList = new ArrayList<>();
    AppletImRecommendListExample example = new AppletImRecommendListExample();
    AppletImRecommendListExample.Criteria criteria = example.createCriteria();
    criteria.andImRecommendListIdIn(Arrays.asList(imRecommendListIds.split(",")));
    List<AppletImRecommendList> appletImRecommendLists = imRecommendListMapper.selectByExample(example);
    //检验单备注信息
    if (appletImRecommendLists != null && appletImRecommendLists.size() > 0) {
      for (AppletImRecommendList appletImRecommendList : appletImRecommendLists) {
        ReInquiryPageVo vo = new ReInquiryPageVo();
        vo.setRecommendStatus(appletImRecommendList.getRecommendStatus());
        vo.setRecommendRemark(appletImRecommendList.getRecommendRemark());
        vo.setImRecommendListId(appletImRecommendList.getImRecommendListId());
        vo.setCreateDate(DateUtils.formatSdfForMinDate(appletImRecommendList.getCreateDate()));
        //查询明细数量
        AppletImRecommendListItemExample example1 = new AppletImRecommendListItemExample();
        Criteria criteria1 = example1.createCriteria();
        criteria1.andImRecommendListIdEqualTo(appletImRecommendList.getImRecommendListId());
        Long l = imRecommendListItemMapper.countByExample(example1);
        vo.setItemSize(l.intValue());
        voList.add(vo);
      }
      return voList;
    } else {
      throw new RuntimeException("未找到检验单信息");
    }
  }
}
