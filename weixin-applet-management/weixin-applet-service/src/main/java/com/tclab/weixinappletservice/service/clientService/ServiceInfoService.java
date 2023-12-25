package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletOrderServiceInfoMapper;
import com.tclab.weixinappletservice.pojo.AppletOrderServiceInfo;
import com.tclab.weixinappletservice.pojo.AppletOrderServiceInfoExample;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ServiceInfoService {

    @Autowired
    private AppletOrderServiceInfoMapper serviceInfoMapper;

    public List<AppletOrderServiceInfo> getServiceInfoById(String userId,String serviceInfoId,Integer defaultFlag){
        AppletOrderServiceInfoExample example = new AppletOrderServiceInfoExample();
        AppletOrderServiceInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(userId)){
            criteria.andUserIdEqualTo(userId);
        }
        if (StringUtils.isNotBlank(serviceInfoId)){
            criteria.andServiceInfoIdEqualTo(serviceInfoId);
        }
        if (defaultFlag!=null){
            criteria.andDefaultFlagEqualTo(defaultFlag);
        }
        List<AppletOrderServiceInfo> result = serviceInfoMapper.selectByExample(example);
        return result;
    }

    public int editServiceInfo(AppletOrderServiceInfo serviceInfo){
        AppletOrderServiceInfoExample example = new AppletOrderServiceInfoExample();
        AppletOrderServiceInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(serviceInfo.getServiceInfoId())){
            criteria.andServiceInfoIdEqualTo(serviceInfo.getServiceInfoId());
            serviceInfo.setUpdateDate(new Date());
            if (serviceInfo.getDefaultFlag()==null){
                serviceInfo.setDefaultFlag(CommonConstants.INIT);
            } else {
                //如果更新的服务地址的状态是初始的
                if (serviceInfo.getDefaultFlag().equals(CommonConstants.INIT)) {
                    serviceInfo.setDefaultFlag(CommonConstants.INIT);
                    //如果更新的服务地址的状态是默认的
                } else if (serviceInfo.getDefaultFlag().equals(CommonConstants.ENABLE)) {
                    recoverDefaultStatus(serviceInfo.getUserId());
                    serviceInfo.setDefaultFlag(CommonConstants.ENABLE);
                }
            }
            return serviceInfoMapper.updateByExampleSelective(serviceInfo,example);
        } else {
            serviceInfo.setServiceInfoId(NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_SERVICEINFO));
            serviceInfo.setCreateDate(new Date());
            serviceInfo.setUpdateDate(new Date());
            serviceInfo.setDelFlag(CommonConstants.INIT);
            if (serviceInfo.getDefaultFlag()==null){
                serviceInfo.setDefaultFlag(CommonConstants.INIT);
            } else {
                if (serviceInfo.getDefaultFlag().equals(CommonConstants.INIT)) {
                    serviceInfo.setDefaultFlag(CommonConstants.INIT);
                } else if (serviceInfo.getDefaultFlag().equals(CommonConstants.ENABLE)) {
                    recoverDefaultStatus(serviceInfo.getUserId());
                    serviceInfo.setDefaultFlag(CommonConstants.ENABLE);
                }
            }
            return serviceInfoMapper.insertSelective(serviceInfo);
        }

    }

    //将用户的所有服务信息的默认状态设置为初始状态
    public int recoverDefaultStatus(String userId) {
        AppletOrderServiceInfoExample example = new AppletOrderServiceInfoExample();
        AppletOrderServiceInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andUserIdEqualTo(userId);
        AppletOrderServiceInfo serviceInfo = new AppletOrderServiceInfo();
        serviceInfo.setDefaultFlag(CommonConstants.INIT);
        return serviceInfoMapper.updateByExampleSelective(serviceInfo,example);
    }

    @Transactional
    public boolean deleteServiceInfo(String serviceInfoId) {
        AppletOrderServiceInfoExample example = new AppletOrderServiceInfoExample();
        AppletOrderServiceInfoExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andServiceInfoIdEqualTo(serviceInfoId);
        AppletOrderServiceInfo serviceInfo = new AppletOrderServiceInfo();
        serviceInfo.setDelFlag(CommonConstants.ENABLE);
        int i = serviceInfoMapper.updateByExampleSelective(serviceInfo,example);
        if (i==0){
            throw new RuntimeException("服务地址删除失败");
        }
        return true;
    }

}
