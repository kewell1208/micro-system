package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletDoctorHospitalMapper;
import com.tclab.weixinappletservice.pojo.AppletDoctorHospital;
import com.tclab.weixinappletservice.pojo.AppletDoctorHospitalExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    @Autowired
    private AppletDoctorHospitalMapper hospitalMapper;

    public List<AppletDoctorHospital> getHospitalByArea(String areaId,String areaName){
        AppletDoctorHospitalExample hospitalExample = new AppletDoctorHospitalExample();
        AppletDoctorHospitalExample.Criteria criteria = hospitalExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andHospitalStatusEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(areaId)){
            criteria.andAreaIdEqualTo(areaId);
        }
        if (StringUtils.isNotBlank(areaName)) {
            criteria.andAreaNameLike("%" + areaName + "%");
        }
        return hospitalMapper.selectByExample(hospitalExample);
    }

    public AppletDoctorHospital getHospitalById(String hospitalId){
        if (StringUtils.isBlank(hospitalId))
            return null;
        AppletDoctorHospitalExample hospitalExample = new AppletDoctorHospitalExample();
        AppletDoctorHospitalExample.Criteria criteria = hospitalExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(hospitalId)){
            criteria.andHospitalIdEqualTo(hospitalId);
        }
        List<AppletDoctorHospital> hospitalList = hospitalMapper.selectByExample(hospitalExample);
        if (hospitalList.size()!=0){
            return hospitalList.get(0);
        } else {
            return null;
        }
    }

}
