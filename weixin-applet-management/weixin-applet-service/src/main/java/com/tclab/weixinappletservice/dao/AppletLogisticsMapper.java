package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletLogistics;
import com.tclab.weixinappletservice.pojo.AppletLogisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletLogisticsMapper {
    long countByExample(AppletLogisticsExample example);

    int deleteByExample(AppletLogisticsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletLogistics record);

    int insertSelective(AppletLogistics record);

    List<AppletLogistics> selectByExample(AppletLogisticsExample example);

    AppletLogistics selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletLogistics record, @Param("example") AppletLogisticsExample example);

    int updateByExample(@Param("record") AppletLogistics record, @Param("example") AppletLogisticsExample example);

    int updateByPrimaryKeySelective(AppletLogistics record);

    int updateByPrimaryKey(AppletLogistics record);
}