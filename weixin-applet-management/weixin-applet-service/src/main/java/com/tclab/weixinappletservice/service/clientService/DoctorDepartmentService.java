package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletDoctorDepartmentMapper;
import com.tclab.weixinappletservice.pojo.AppletDoctorDepartment;
import com.tclab.weixinappletservice.pojo.AppletDoctorDepartmentExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorDepartmentService {

    @Autowired
    private AppletDoctorDepartmentMapper doctorDepartmentMapper;

    public List<AppletDoctorDepartment> getDoctorDepartmentByHospital(String hospitalId,String hospitalDepartmentId){
        AppletDoctorDepartmentExample doctorDepartmentExample = new AppletDoctorDepartmentExample();
        AppletDoctorDepartmentExample.Criteria criteria = doctorDepartmentExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andDepartmentStatusEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(hospitalId)){
            criteria.andHospitalIdEqualTo(hospitalId);
        }
        if (StringUtils.isNotBlank(hospitalDepartmentId)){
            criteria.andDoctorDepartmentIdEqualTo(hospitalDepartmentId);
        }
        List<AppletDoctorDepartment> departmentList = doctorDepartmentMapper.selectByExample(doctorDepartmentExample);
        return departmentList;
    }

    public AppletDoctorDepartment getDoctorDepartmentById(String hospitalDepartmentId){
        if (StringUtils.isBlank(hospitalDepartmentId))
            return null;
        AppletDoctorDepartmentExample doctorDepartmentExample = new AppletDoctorDepartmentExample();
        AppletDoctorDepartmentExample.Criteria criteria = doctorDepartmentExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(hospitalDepartmentId)){
            criteria.andDoctorDepartmentIdEqualTo(hospitalDepartmentId);
        }
        List<AppletDoctorDepartment> departmentList = doctorDepartmentMapper.selectByExample(doctorDepartmentExample);
        if (departmentList.size()!=0){
            return departmentList.get(0);
        } else {
            return null;
        }
    }

}
