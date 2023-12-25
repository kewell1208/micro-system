package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletAreaMapper;
import com.tclab.weixinappletservice.pojo.AppletArea;
import com.tclab.weixinappletservice.pojo.AppletAreaExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {

    @Autowired
    private AppletAreaMapper areaMapper;

    /**
     * 根据ID查询地区
     * @param areaId        地区ID
     * @param areaName      模糊查询地区名关键字
     * @return
     */
    public AppletArea getArea(String areaId, String areaName){

        AppletAreaExample areaExample = new AppletAreaExample();
        AppletAreaExample.Criteria areaExampleCriteria = areaExample.createCriteria();
        AppletAreaExample.Criteria areaExampleCriteria2 = areaExample.createCriteria();
        if (StringUtils.isNotBlank(areaId)) {
            areaExampleCriteria.andAreaIdEqualTo(areaId);
            areaExampleCriteria2.andAreaPidEqualTo(areaId);
        }
        if (StringUtils.isNotBlank(areaName)) {
            areaExampleCriteria.andAreaNameLike("%"+areaName+"%");
            areaExampleCriteria2.andAreaNameLike("%"+areaName+"%");
        }
        areaExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        areaExampleCriteria2.andDelFlagEqualTo(CommonConstants.INIT);
        areaExample.or(areaExampleCriteria2);

        List<AppletArea> appletAreaList = areaMapper.selectByExample(areaExample);
        if (appletAreaList.size()==0){
            return null;
        } else {
            return areaMapper.selectByExample(areaExample).get(0);
        }
    }

}
