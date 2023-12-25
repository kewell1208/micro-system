package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletPackageSourceMapper;
import com.tclab.weixinappletservice.pojo.AppletPackageSource;
import com.tclab.weixinappletservice.pojo.AppletPackageSourceExample;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminSourceService {

    private static final Logger logger = LoggerFactory.getLogger(AdminSourceService.class);

    @Autowired
    private AppletPackageSourceMapper sourceMapper;

    public List<AppletPackageSource> getEnablePackageSourceList(){
        AppletPackageSourceExample sourceExample = new AppletPackageSourceExample();
        AppletPackageSourceExample.Criteria criteria = sourceExample.createCriteria();
        criteria.andPackageSourceStatusEqualTo(CommonConstants.INIT);
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletPackageSource> sourceList = sourceMapper.selectByExample(sourceExample);
        return sourceList;
    }

}
