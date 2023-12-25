package com.tclab.weixinappletservice.service.adminService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.constant.StaffConstants;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletservice.dao.AppletAcquisitionStaffMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.AcquisitionStaffListVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.AcquisitionStaffPageVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.EditStaffReqVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.QueryAcquisitionStaffReqVo;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionStaff;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionStaffExample;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Package：com.tclab.wxmabackapi.service
 * @Class：StaffService
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/8 9:49
 * @Company:
 * @Version：
 * @Modified By:
 */
@Service
public class AdminStaffService {

    private static final Logger logger = LoggerFactory.getLogger(AdminStaffService.class);

    @Autowired
    private AppletAcquisitionStaffMapper staffMapper;

    public AcquisitionStaffPageVo getStaffPageVoByQueryReq(QueryAcquisitionStaffReqVo req) {
        AppletAcquisitionStaffExample staffExample = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria staffExampleCriteria = staffExample.createCriteria();
        if (StringUtils.isNotBlank(req.getAcquisitionId())) {
            staffExampleCriteria.andAcquisitionIdEqualTo(req.getAcquisitionId());
        }
        if (StringUtils.isNotBlank(req.getStaffName())) {
            staffExampleCriteria.andStaffNameLike("%" + req.getStaffName()+"%");
        }
        if (StringUtils.isNotBlank(req.getStaffPhone())) {
            staffExampleCriteria.andStaffPhoneLike(req.getStaffPhone()+"%");
        }
        if (req.getStaffType() != null) {
            staffExampleCriteria.andStaffTypeEqualTo(req.getStaffType());
        }
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<AppletAcquisitionStaff> staffList = staffMapper.selectByExample(staffExample);
        PageInfo<AppletAcquisitionStaff> staffPageInfo = new PageInfo<>(staffList);

        if (staffPageInfo != null && staffPageInfo.getList() != null) {
            AcquisitionStaffPageVo staffPageVo = new AcquisitionStaffPageVo();
            staffPageVo.setCurrentPageNo(staffPageInfo.getPageNum());
            staffPageVo.setStaffNum(staffPageInfo.getTotal());
            staffPageVo.setPageNum(staffPageInfo.getPages());

            List<AcquisitionStaffListVo> staffListVoList = new ArrayList<>();
            for (AppletAcquisitionStaff staff : staffPageInfo.getList()) {
                AcquisitionStaffListVo staffListVo = new AcquisitionStaffListVo();
                BeanUtils.copyProperties(staff, staffListVo);
                staffListVoList.add(staffListVo);
            }
            staffPageVo.setStaffListVoList(staffListVoList);
            return staffPageVo;
        }
        return null;
    }

    public AppletAcquisitionStaff getStaffById(String staffId) {
        if (StringUtils.isBlank(staffId)){
            return null;
        }
        AppletAcquisitionStaffExample staffExample = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria staffExampleCriteria = staffExample.createCriteria();
        staffExampleCriteria.andStaffIdEqualTo(staffId);
        List<AppletAcquisitionStaff> staffList = staffMapper.selectByExample(staffExample);
        if (staffList.size()!=0){
            return staffList.get(0);
        } else {
            return null;
        }
    }

    public boolean stopStaff(List<String> staffIds) {
        AppletAcquisitionStaff staff = new AppletAcquisitionStaff();
        staff.setStaffStatus(StaffConstants.STAFF_STATUS_STOP);
        staff.setUpdateDate(new Date());
        AppletAcquisitionStaffExample staffExample = new AppletAcquisitionStaffExample();
        AppletAcquisitionStaffExample.Criteria staffExampleCriteria = staffExample.createCriteria();
        staffExampleCriteria.andStaffIdIn(staffIds);
        int  i = staffMapper.updateByExampleSelective(staff, staffExample);
        if (i==0){
            throw new RuntimeException("停用套餐失败: " + staffIds);
        }
        return true;
    }

    public boolean editStaff(EditStaffReqVo req) {
        AppletAcquisitionStaff staff = new AppletAcquisitionStaff();
        BeanUtils.copyProperties(req, staff);
        if (StringUtils.isBlank(req.getStaffId())){
            req.setStaffId(new NumberGeneratorUtils().generateNo(CommonConstants.GenerateID_STAFF, RedisConstants.STAFFID_INDEX));
            staff.setStaffId(req.getStaffId());
            staff.setStaffStatus(StaffConstants.STAFF_STATUS_FINISH);
            staff.setCreateDate(new Date());
            int  i = staffMapper.insertSelective(staff);
            if (i==0){
                throw new RuntimeException("添加员工失败: " + req.toString());
            }
        } else {
            staff.setUpdateDate(new Date());
            AppletAcquisitionStaffExample staffExample = new AppletAcquisitionStaffExample();
            AppletAcquisitionStaffExample.Criteria staffExampleCriteria = staffExample.createCriteria();
            staffExampleCriteria.andStaffIdEqualTo(staff.getStaffId());
            int  i = staffMapper.updateByExampleSelective(staff, staffExample);
            if (i==0){
                throw new RuntimeException("编辑员工失败: " + req.toString());
            }
        }
        return true;
    }
}
