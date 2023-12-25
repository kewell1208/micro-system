package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletservice.dao.AppletOrderServiceInfoMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.ServiceInfoBaseVo;
import com.tclab.weixinappletservice.pojo.AppletOrderServiceInfo;
import com.tclab.weixinappletservice.pojo.AppletOrderServiceInfoExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceInfoService {

    @Autowired
    private AppletOrderServiceInfoMapper serviceInfoMapper;

    public ServiceInfoBaseVo getServiceInfoByServiceInfoId(String serviceInfoId){

        if (StringUtils.isBlank(serviceInfoId)){
            return null;
        }

        AppletOrderServiceInfoExample serviceInfoExample = new AppletOrderServiceInfoExample();
        AppletOrderServiceInfoExample.Criteria serviceInfoExampleCriteria = serviceInfoExample.createCriteria();
        serviceInfoExampleCriteria.andServiceInfoIdEqualTo(serviceInfoId);
        List<AppletOrderServiceInfo> serviceInfoList = serviceInfoMapper.selectByExample(serviceInfoExample);
        if (serviceInfoList.size()!=0){
            ServiceInfoBaseVo serviceInfoBaseVo = new ServiceInfoBaseVo();
            BeanUtils.copyProperties(serviceInfoList.get(0),serviceInfoBaseVo);
            return serviceInfoBaseVo;
        } else {
            return null;
        }
    }

    public List<ServiceInfoBaseVo> getServiceInfoByUserId(String userId){
        AppletOrderServiceInfoExample serviceInfoExample = new AppletOrderServiceInfoExample();
        AppletOrderServiceInfoExample.Criteria serviceInfoExampleCriteria = serviceInfoExample.createCriteria();
        serviceInfoExampleCriteria.andUserIdEqualTo(userId);
        List<AppletOrderServiceInfo> serviceInfoList = serviceInfoMapper.selectByExample(serviceInfoExample);
        if (serviceInfoList != null && serviceInfoList.size() != 0){
            List<ServiceInfoBaseVo> serviceInfoBaseVoList = new ArrayList<>();
            for(AppletOrderServiceInfo appletOrderServiceInfo : serviceInfoList) {
                ServiceInfoBaseVo serviceInfoBaseVo = new ServiceInfoBaseVo();
                BeanUtils.copyProperties(appletOrderServiceInfo, serviceInfoBaseVo);
                serviceInfoBaseVoList.add(serviceInfoBaseVo);
            }
            return serviceInfoBaseVoList;
        } else {
            return null;
        }
    }
}
