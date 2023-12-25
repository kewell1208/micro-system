package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletClerkMapper;
import com.tclab.weixinappletservice.pojo.AppletClerk;
import com.tclab.weixinappletservice.pojo.AppletClerkExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminClerkService {

    @Autowired
    private AppletClerkMapper clerkMapper;

    public AppletClerk getClerkByClerkId(String clerkId){
        AppletClerkExample clerkExample = new AppletClerkExample();
        AppletClerkExample.Criteria clerkExampleCriteria = clerkExample.createCriteria();
        clerkExampleCriteria.andClerkIdEqualTo(clerkId);
        List<AppletClerk> appletClerkList = clerkMapper.selectByExample(clerkExample);
        if (appletClerkList.size()!=0){
            return appletClerkList.get(0);
        } else {
            return null;
        }
    }

    public List<AppletClerk> getClerkList(String clerkId,boolean status){
        AppletClerkExample clerkExample = new AppletClerkExample();
        AppletClerkExample.Criteria clerkExampleCriteria = clerkExample.createCriteria();
        if (StringUtils.isNotBlank(clerkId))
            clerkExampleCriteria.andClerkIdEqualTo(clerkId);
        if (status){
            clerkExampleCriteria.andStatusEqualTo(CommonConstants.INIT);
            clerkExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        } else {
            clerkExampleCriteria.andDelFlagEqualTo(CommonConstants.ENABLE);
            clerkExampleCriteria.andStatusEqualTo(CommonConstants.ENABLE);
        }
        List<AppletClerk> appletClerkList = clerkMapper.selectByExample(clerkExample);
        return appletClerkList;
    }

}
