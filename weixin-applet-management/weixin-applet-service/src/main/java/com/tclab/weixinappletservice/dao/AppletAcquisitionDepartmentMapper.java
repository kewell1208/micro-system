package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletAcquisitionDepartment;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionDepartmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletAcquisitionDepartmentMapper {
    long countByExample(AppletAcquisitionDepartmentExample example);

    int deleteByExample(AppletAcquisitionDepartmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletAcquisitionDepartment record);

    int insertSelective(AppletAcquisitionDepartment record);

    List<AppletAcquisitionDepartment> selectByExample(AppletAcquisitionDepartmentExample example);

    AppletAcquisitionDepartment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletAcquisitionDepartment record, @Param("example") AppletAcquisitionDepartmentExample example);

    int updateByExample(@Param("record") AppletAcquisitionDepartment record, @Param("example") AppletAcquisitionDepartmentExample example);

    int updateByPrimaryKeySelective(AppletAcquisitionDepartment record);

    int updateByPrimaryKey(AppletAcquisitionDepartment record);
}