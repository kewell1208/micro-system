package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletAcquisitionStaff;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionStaffExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletAcquisitionStaffMapper {
    long countByExample(AppletAcquisitionStaffExample example);

    int deleteByExample(AppletAcquisitionStaffExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletAcquisitionStaff record);

    int insertSelective(AppletAcquisitionStaff record);

    List<AppletAcquisitionStaff> selectByExample(AppletAcquisitionStaffExample example);

    AppletAcquisitionStaff selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletAcquisitionStaff record, @Param("example") AppletAcquisitionStaffExample example);

    int updateByExample(@Param("record") AppletAcquisitionStaff record, @Param("example") AppletAcquisitionStaffExample example);

    int updateByPrimaryKeySelective(AppletAcquisitionStaff record);

    int updateByPrimaryKey(AppletAcquisitionStaff record);
}