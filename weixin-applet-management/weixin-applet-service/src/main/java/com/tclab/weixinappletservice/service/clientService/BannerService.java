package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletBannerMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.BannerVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.TopBannerVo;
import com.tclab.weixinappletservice.pojo.AppletBanner;
import com.tclab.weixinappletservice.pojo.AppletBannerExample;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BannerService {

    @Autowired
    private AppletBannerMapper bannerMapper;

    /**
     * 根据不同区域和类型查询banner
     * @param field     0表示首页
     * @param type      0表示顶部banner 1表示图标 2表示中部图标 BannerConstants
     * @return
     */
    public List<AppletBanner> GetBannerByFieldOrType(Integer field,Integer type){

        AppletBannerExample example = new AppletBannerExample();
        AppletBannerExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (field!=null)
            criteria.andBannerFieldEqualTo(field);
        if (type!=null)
            criteria.andBannerTypeEqualTo(type);
        return bannerMapper.selectByExample(example);
    }

    /**
     * 对首页banner列表进行分类
     * @param banners       需要分类的banner列表
     * @return
     */
    public List<TopBannerVo> GetTopBannerVo(List<AppletBanner> banners){
        if (banners==null){
            return null;
        }

        List<TopBannerVo> topBannerVos = new ArrayList<>();
        Map<Integer,List<AppletBanner>> map = banners.stream().collect(Collectors.groupingBy(AppletBanner::getBannerType));

        Iterator<Map.Entry<Integer,List<AppletBanner>>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer,List<AppletBanner>> entry = it.next();
            TopBannerVo topBannerVo = new TopBannerVo();
            topBannerVo.setBannerType(entry.getKey());
            List<BannerVo> bannerVos = new ArrayList<>();
            for (AppletBanner banner:entry.getValue()) {
                BannerVo bannerVo = new BannerVo();
                BeanUtils.copyProperties(banner,bannerVo);
                bannerVos.add(bannerVo);
            }
            topBannerVo.setBannerTypeList(bannerVos);
            topBannerVos.add(topBannerVo);
        }
        return topBannerVos;
    }

}
