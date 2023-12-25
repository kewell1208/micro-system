package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletPackageCost;
import com.tclab.weixinappletservice.pojo.AppletPackageCostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackageCostMapper {
    long countByExample(AppletPackageCostExample example);

    int deleteByExample(AppletPackageCostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackageCost record);

    int insertSelective(AppletPackageCost record);

    List<AppletPackageCost> selectByExample(AppletPackageCostExample example);

    AppletPackageCost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackageCost record, @Param("example") AppletPackageCostExample example);

    int updateByExample(@Param("record") AppletPackageCost record, @Param("example") AppletPackageCostExample example);

    int updateByPrimaryKeySelective(AppletPackageCost record);

    int updateByPrimaryKey(AppletPackageCost record);
}