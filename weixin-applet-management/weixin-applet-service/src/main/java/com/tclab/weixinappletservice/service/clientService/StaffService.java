package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletAcquisitionDepartmentMapper;
import com.tclab.weixinappletservice.dao.AppletAcquisitionMapper;
import com.tclab.weixinappletservice.dao.AppletAcquisitionStaffMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.StaffExtendVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.StaffVo;
import com.tclab.weixinappletservice.pojo.*;
import com.tclab.weixinappletservice.service.clientService.AcquisitionService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    private AppletAcquisitionStaffMapper staffMapper;
    @Autowired
    private AppletAcquisitionMapper acquisitionMapper;
    @Autowired
    private AppletAcquisitionDepartmentMapper departmentMapper;
    @Autowired
    private AcquisitionService acquisitionService;

    public StaffVo getStaffVo(String phone){
        AppletAcquisitionStaffExample example = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria criteria = example.createCriteria();
        criteria.andStaffPhoneEqualTo(phone);
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletAcquisitionStaff> staffList = staffMapper.selectByExample(example);
        if (staffList.size()!=0){
            StaffVo staffVo = new StaffVo();

            //员工基本信息
            staffVo.setStaffId(staffList.get(0).getStaffId());
            staffVo.setStaffName(staffList.get(0).getStaffName());
            staffVo.setStaffPhone(staffList.get(0).getStaffPhone());
            staffVo.setStaffRank(staffList.get(0).getStaffRank());
            staffVo.setStaffSex(staffList.get(0).getStaffSex());
            staffVo.setStaffType(staffList.get(0).getStaffType());
            staffVo.setVerifyFlag(staffList.get(0).getVerifyFlag());

            //采集点的基本信息
            if (StringUtils.isNotBlank(staffList.get(0).getAcquisitionId())){
                AppletAcquisitionExample example1 = new AppletAcquisitionExample();
                AppletAcquisitionExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andAcquisitionIdEqualTo(staffList.get(0).getAcquisitionId());
                criteria1.andDelFlagEqualTo(CommonConstants.INIT);
                List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(example1);
                if (acquisitionList.size()!=0){
                    staffVo.setAcquisitionAddress(acquisitionList.get(0).getAcquisitionAddress());
                    staffVo.setAcquisitionId(staffList.get(0).getAcquisitionId());
                    staffVo.setAcquisitionInfo(acquisitionList.get(0).getAcquisitionInfo());
                    staffVo.setAcquisitionLogo(acquisitionList.get(0).getAcquisitionLogo());
                    staffVo.setAcquisitionName(acquisitionList.get(0).getAcquisitionName());
                }
            }

            if (StringUtils.isNotBlank(staffList.get(0).getDepartmentId())){
                AppletAcquisitionDepartmentExample example2 = new AppletAcquisitionDepartmentExample();
                AppletAcquisitionDepartmentExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andDepartmentIdEqualTo(staffList.get(0).getDepartmentId());
                criteria2.andDelFlagEqualTo(CommonConstants.INIT);
                List<AppletAcquisitionDepartment> departmentList = departmentMapper.selectByExample(example2);
                if (departmentList.size()!=0){
                    staffVo.setDepartmentId(staffList.get(0).getDepartmentId());
                    staffVo.setDepartmentName(departmentList.get(0).getDepartmentName());
                }
            }
            return staffVo;
        }else {
            return null;
        }
    }

    public StaffVo getStaffVoById(String staffId){
        AppletAcquisitionStaffExample example = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria criteria = example.createCriteria();
        criteria.andStaffIdEqualTo(staffId);
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletAcquisitionStaff> staffList = staffMapper.selectByExample(example);
        if (staffList.size()!=0){
            StaffVo staffVo = new StaffVo();

            //员工基本信息
            staffVo.setStaffId(staffList.get(0).getStaffId());
            staffVo.setStaffName(staffList.get(0).getStaffName());
            staffVo.setStaffPhone(staffList.get(0).getStaffPhone());
            staffVo.setStaffRank(staffList.get(0).getStaffRank());
            staffVo.setStaffSex(staffList.get(0).getStaffSex());
            staffVo.setStaffType(staffList.get(0).getStaffType());
            staffVo.setVerifyFlag(staffList.get(0).getVerifyFlag());
            staffVo.setStaffLogo(staffList.get(0).getStaffLogo());

            //采集点的基本信息
            if (StringUtils.isNotBlank(staffList.get(0).getAcquisitionId())){
                AppletAcquisitionExample example1 = new AppletAcquisitionExample();
                AppletAcquisitionExample.Criteria criteria1 = example1.createCriteria();
                criteria1.andAcquisitionIdEqualTo(staffList.get(0).getAcquisitionId());
                criteria1.andDelFlagEqualTo(CommonConstants.INIT);
                List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(example1);
                if (acquisitionList.size()!=0){
                    staffVo.setAcquisitionAddress(acquisitionList.get(0).getAcquisitionAddress());
                    staffVo.setAcquisitionId(staffList.get(0).getAcquisitionId());
                    staffVo.setAcquisitionInfo(acquisitionList.get(0).getAcquisitionInfo());
                    staffVo.setAcquisitionLogo(acquisitionList.get(0).getAcquisitionLogo());
                    staffVo.setAcquisitionName(acquisitionList.get(0).getAcquisitionName());
                }
            }

            if (StringUtils.isNotBlank(staffList.get(0).getDepartmentId())){
                AppletAcquisitionDepartmentExample example2 = new AppletAcquisitionDepartmentExample();
                AppletAcquisitionDepartmentExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andDepartmentIdEqualTo(staffList.get(0).getDepartmentId());
                criteria2.andDelFlagEqualTo(CommonConstants.INIT);
                List<AppletAcquisitionDepartment> departmentList = departmentMapper.selectByExample(example2);
                if (departmentList.size()!=0){
                    staffVo.setDepartmentId(staffList.get(0).getDepartmentId());
                    staffVo.setDepartmentName(departmentList.get(0).getDepartmentName());
                }
            }
            return staffVo;
        }else {
            return null;
        }
    }

    public AppletAcquisitionStaff getStaffByStaffIdOrPhone(String staffId,String phone){
        AppletAcquisitionStaffExample example = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(phone)) {
            criteria.andStaffPhoneEqualTo(phone);
        }
        if (StringUtils.isNotBlank(staffId)) {
            criteria.andStaffIdEqualTo(staffId);
        }
        List<AppletAcquisitionStaff> staffList = staffMapper.selectByExample(example);
        if (staffList.size()!=0){
            return staffList.get(0);
        } else {
            return null;
        }
    }

    public AppletAcquisitionStaff getStaffByStaffId(String staffId){

        if (StringUtils.isBlank(staffId)){
            return null;
        }

        AppletAcquisitionStaffExample example = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(staffId)) {
            criteria.andStaffIdEqualTo(staffId);
        }
        List<AppletAcquisitionStaff> staffList = staffMapper.selectByExample(example);
        if (staffList.size()!=0){
            return staffList.get(0);
        } else {
            return null;
        }
    }

    public AppletAcquisitionStaff getStaffByStaffIdOrDoctorId(String id){

        if (StringUtils.isBlank(id)){
            return null;
        }

        AppletAcquisitionStaffExample example = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria criteria = example.createCriteria();
        AppletAcquisitionStaffExample.Criteria criteria2 = example.createCriteria();
        if (StringUtils.isNotBlank(id)) {
            criteria.andStaffIdEqualTo(id);
            criteria2.andDoctorIdEqualTo(id);
        }
        example.or(criteria2);
        List<AppletAcquisitionStaff> staffList = staffMapper.selectByExample(example);
        if (staffList.size()!=0){
            return staffList.get(0);
        } else {
            return null;
        }
    }

    public StaffExtendVo getStaffExtendVoByStaffIdOrPhone(String staffId, String phone){
        AppletAcquisitionStaff staff = getStaffByStaffIdOrPhone(staffId,phone);
        if (staff==null){
            return null;
        }
        StaffExtendVo extendVo = new StaffExtendVo();
        BeanUtils.copyProperties(staff,extendVo);

        if (StringUtils.isNotBlank(staff.getStaffJobImage())){
            extendVo.setStaffJobImage(CommonConstants.ENABLE);
        } else {
            extendVo.setStaffJobImage(CommonConstants.INIT);
        }
        if (StringUtils.isNotBlank(staff.getStaffRankImage())){
            extendVo.setStaffRankImage(CommonConstants.ENABLE);
        } else {
            extendVo.setStaffRankImage(CommonConstants.INIT);

        }

        if (staff!=null){
            if (StringUtils.isNotBlank(staff.getAcquisitionId())){
                AppletAcquisition acquisition = acquisitionService.getAcquisitionByAcquisitionId(staff.getAcquisitionId());
                if (acquisition!=null){
                    extendVo.setAcquisitionName(acquisition.getAcquisitionName());
                }
            }
            if (StringUtils.isNotBlank(staff.getDepartmentId())){
                AppletAcquisitionDepartmentExample example2 = new AppletAcquisitionDepartmentExample();
                AppletAcquisitionDepartmentExample.Criteria criteria2 = example2.createCriteria();
                criteria2.andDepartmentIdEqualTo(staff.getDepartmentId());
                criteria2.andDelFlagEqualTo(CommonConstants.INIT);
                List<AppletAcquisitionDepartment> departmentList = departmentMapper.selectByExample(example2);
                if (departmentList.size()!=0){
                    extendVo.setDepartmentName(departmentList.get(0).getDepartmentName());
                }
            }
            return extendVo;
        } else {
            return null;
        }

    }

    public List<AppletAcquisitionStaff> getStaffByAcquisitionIdAndStaffType(String acquisitionId,Integer staffType){
        AppletAcquisitionStaffExample example = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(acquisitionId))
            criteria.andAcquisitionIdEqualTo(acquisitionId);
        if (staffType!=null)
            criteria.andStaffTypeEqualTo(staffType);
        List<AppletAcquisitionStaff> staffList = staffMapper.selectByExample(example);
        return staffList;
    }

}
