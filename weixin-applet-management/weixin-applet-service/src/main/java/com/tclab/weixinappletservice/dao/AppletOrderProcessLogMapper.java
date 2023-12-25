package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletOrderProcessLog;
import com.tclab.weixinappletservice.pojo.AppletOrderProcessLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletOrderProcessLogMapper {
    long countByExample(AppletOrderProcessLogExample example);

    int deleteByExample(AppletOrderProcessLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletOrderProcessLog record);

    int insertSelective(AppletOrderProcessLog record);

    List<AppletOrderProcessLog> selectByExample(AppletOrderProcessLogExample example);

    AppletOrderProcessLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletOrderProcessLog record, @Param("example") AppletOrderProcessLogExample example);

    int updateByExample(@Param("record") AppletOrderProcessLog record, @Param("example") AppletOrderProcessLogExample example);

    int updateByPrimaryKeySelective(AppletOrderProcessLog record);

    int updateByPrimaryKey(AppletOrderProcessLog record);
}