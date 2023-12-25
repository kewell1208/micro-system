package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletGoodProcessLog;
import com.tclab.weixinappletservice.pojo.AppletGoodProcessLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletGoodProcessLogMapper {
    long countByExample(AppletGoodProcessLogExample example);

    int deleteByExample(AppletGoodProcessLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletGoodProcessLog record);

    int insertSelective(AppletGoodProcessLog record);

    List<AppletGoodProcessLog> selectByExample(AppletGoodProcessLogExample example);

    AppletGoodProcessLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletGoodProcessLog record, @Param("example") AppletGoodProcessLogExample example);

    int updateByExample(@Param("record") AppletGoodProcessLog record, @Param("example") AppletGoodProcessLogExample example);

    int updateByPrimaryKeySelective(AppletGoodProcessLog record);

    int updateByPrimaryKey(AppletGoodProcessLog record);
}