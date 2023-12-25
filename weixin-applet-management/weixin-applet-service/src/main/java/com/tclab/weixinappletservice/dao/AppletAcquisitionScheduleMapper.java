package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletAcquisitionSchedule;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionScheduleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletAcquisitionScheduleMapper {
    long countByExample(AppletAcquisitionScheduleExample example);

    int deleteByExample(AppletAcquisitionScheduleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletAcquisitionSchedule record);

    int insertSelective(AppletAcquisitionSchedule record);

    List<AppletAcquisitionSchedule> selectByExample(AppletAcquisitionScheduleExample example);

    AppletAcquisitionSchedule selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletAcquisitionSchedule record, @Param("example") AppletAcquisitionScheduleExample example);

    int updateByExample(@Param("record") AppletAcquisitionSchedule record, @Param("example") AppletAcquisitionScheduleExample example);

    int updateByPrimaryKeySelective(AppletAcquisitionSchedule record);

    int updateByPrimaryKey(AppletAcquisitionSchedule record);
}