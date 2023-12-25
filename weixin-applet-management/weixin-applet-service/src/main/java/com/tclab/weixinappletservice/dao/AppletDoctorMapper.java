package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.QueryDoctorParam;
import com.tclab.weixinappletservice.pojo.AppletDoctor;
import com.tclab.weixinappletservice.pojo.AppletDoctorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletDoctorMapper {
    long countByExample(AppletDoctorExample example);

    int deleteByExample(AppletDoctorExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletDoctor record);

    int insertSelective(AppletDoctor record);

    List<AppletDoctor> selectByExample(AppletDoctorExample example);

    AppletDoctor selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletDoctor record, @Param("example") AppletDoctorExample example);

    int updateByExample(@Param("record") AppletDoctor record, @Param("example") AppletDoctorExample example);

    int updateByPrimaryKeySelective(AppletDoctor record);

    int updateByPrimaryKey(AppletDoctor record);

    List<AppletDoctor> selectDoctorByParam(QueryDoctorParam param);
}