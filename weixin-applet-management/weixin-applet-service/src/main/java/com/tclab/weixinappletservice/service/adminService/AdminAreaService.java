package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletAreaMapper;
import com.tclab.weixinappletservice.pojo.AppletArea;
import com.tclab.weixinappletservice.pojo.AppletAreaExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminAreaService {

    @Autowired
    private AppletAreaMapper clerkMapper;

    public List<AppletArea> getAreaList(String areaId, boolean status){
        AppletAreaExample areaExample = new AppletAreaExample();
        AppletAreaExample.Criteria areaExampleCriteria = areaExample.createCriteria();
        if (StringUtils.isNotBlank(areaId))
            areaExampleCriteria.andAreaIdEqualTo(areaId);
        if (status){
            areaExampleCriteria.andAreaStatusEqualTo(CommonConstants.INIT);
            areaExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        } else {
            areaExampleCriteria.andDelFlagEqualTo(CommonConstants.ENABLE);
            areaExampleCriteria.andAreaStatusEqualTo(CommonConstants.ENABLE);
        }
        List<AppletArea> appletAreaList = clerkMapper.selectByExample(areaExample);
        return appletAreaList;
    }

}
