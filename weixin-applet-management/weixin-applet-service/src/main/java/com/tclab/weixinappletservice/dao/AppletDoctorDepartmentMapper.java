package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletDoctorDepartment;
import com.tclab.weixinappletservice.pojo.AppletDoctorDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletDoctorDepartmentMapper {
    long countByExample(AppletDoctorDepartmentExample example);

    int deleteByExample(AppletDoctorDepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletDoctorDepartment record);

    int insertSelective(AppletDoctorDepartment record);

    List<AppletDoctorDepartment> selectByExample(AppletDoctorDepartmentExample example);

    AppletDoctorDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletDoctorDepartment record, @Param("example") AppletDoctorDepartmentExample example);

    int updateByExample(@Param("record") AppletDoctorDepartment record, @Param("example") AppletDoctorDepartmentExample example);

    int updateByPrimaryKeySelective(AppletDoctorDepartment record);

    int updateByPrimaryKey(AppletDoctorDepartment record);
}