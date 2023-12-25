package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletDoctorHospital;
import com.tclab.weixinappletservice.pojo.AppletDoctorHospitalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletDoctorHospitalMapper {
    long countByExample(AppletDoctorHospitalExample example);

    int deleteByExample(AppletDoctorHospitalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletDoctorHospital record);

    int insertSelective(AppletDoctorHospital record);

    List<AppletDoctorHospital> selectByExample(AppletDoctorHospitalExample example);

    AppletDoctorHospital selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletDoctorHospital record, @Param("example") AppletDoctorHospitalExample example);

    int updateByExample(@Param("record") AppletDoctorHospital record, @Param("example") AppletDoctorHospitalExample example);

    int updateByPrimaryKeySelective(AppletDoctorHospital record);

    int updateByPrimaryKey(AppletDoctorHospital record);
}