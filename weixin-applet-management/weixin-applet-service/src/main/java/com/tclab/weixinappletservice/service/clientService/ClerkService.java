package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletservice.dao.AppletClerkMapper;
import com.tclab.weixinappletservice.pojo.AppletClerk;
import com.tclab.weixinappletservice.pojo.AppletClerkExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClerkService {

    @Autowired
    private AppletClerkMapper clerkMapper;

    /**
     * 根据员工手机获取物流员工信息
     * @param clerkId
     * @return
     */
    public AppletClerk getClerkByClerkId(String clerkId){
        AppletClerkExample example = new AppletClerkExample();
        AppletClerkExample.Criteria criteria = example.createCriteria();
        criteria.andClerkIdEqualTo(clerkId);
        List<AppletClerk> clerks = clerkMapper.selectByExample(example);
        if (clerks.size()!=0){
            return clerks.get(0);
        } else {
            return null;
        }
    }

}
