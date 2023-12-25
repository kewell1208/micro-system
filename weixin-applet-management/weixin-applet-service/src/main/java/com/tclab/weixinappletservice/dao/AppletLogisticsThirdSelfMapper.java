package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletLogisticsThirdSelf;
import com.tclab.weixinappletservice.pojo.AppletLogisticsThirdSelfExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletLogisticsThirdSelfMapper {
    long countByExample(AppletLogisticsThirdSelfExample example);

    int deleteByExample(AppletLogisticsThirdSelfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletLogisticsThirdSelf record);

    int insertSelective(AppletLogisticsThirdSelf record);

    List<AppletLogisticsThirdSelf> selectByExample(AppletLogisticsThirdSelfExample example);

    AppletLogisticsThirdSelf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletLogisticsThirdSelf record, @Param("example") AppletLogisticsThirdSelfExample example);

    int updateByExample(@Param("record") AppletLogisticsThirdSelf record, @Param("example") AppletLogisticsThirdSelfExample example);

    int updateByPrimaryKeySelective(AppletLogisticsThirdSelf record);

    int updateByPrimaryKey(AppletLogisticsThirdSelf record);
}