package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletPackagePopulationMapper;
import com.tclab.weixinappletservice.pojo.AppletPackagePopulation;
import com.tclab.weixinappletservice.pojo.AppletPackagePopulationExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PopulationService {

    @Autowired
    private AppletPackagePopulationMapper populationMapper;

    public List<AppletPackagePopulation> getAllPopulation(){
        AppletPackagePopulationExample example = new AppletPackagePopulationExample();
        AppletPackagePopulationExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletPackagePopulation> result = populationMapper.selectByExample(example);
        return result;
    }

}
