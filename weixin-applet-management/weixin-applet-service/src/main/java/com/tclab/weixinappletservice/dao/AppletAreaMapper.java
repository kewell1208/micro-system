package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletArea;
import com.tclab.weixinappletservice.pojo.AppletAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletAreaMapper {
    long countByExample(AppletAreaExample example);

    int deleteByExample(AppletAreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletArea record);

    int insertSelective(AppletArea record);

    List<AppletArea> selectByExample(AppletAreaExample example);

    AppletArea selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletArea record, @Param("example") AppletAreaExample example);

    int updateByExample(@Param("record") AppletArea record, @Param("example") AppletAreaExample example);

    int updateByPrimaryKeySelective(AppletArea record);

    int updateByPrimaryKey(AppletArea record);
}