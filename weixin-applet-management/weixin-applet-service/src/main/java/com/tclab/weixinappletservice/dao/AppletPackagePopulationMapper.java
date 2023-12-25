package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletPackagePopulation;
import com.tclab.weixinappletservice.pojo.AppletPackagePopulationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackagePopulationMapper {
    long countByExample(AppletPackagePopulationExample example);

    int deleteByExample(AppletPackagePopulationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackagePopulation record);

    int insertSelective(AppletPackagePopulation record);

    List<AppletPackagePopulation> selectByExample(AppletPackagePopulationExample example);

    AppletPackagePopulation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackagePopulation record, @Param("example") AppletPackagePopulationExample example);

    int updateByExample(@Param("record") AppletPackagePopulation record, @Param("example") AppletPackagePopulationExample example);

    int updateByPrimaryKeySelective(AppletPackagePopulation record);

    int updateByPrimaryKey(AppletPackagePopulation record);
}