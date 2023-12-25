package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletInterpret;
import com.tclab.weixinappletservice.pojo.AppletInterpretExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletInterpretMapper {
    long countByExample(AppletInterpretExample example);

    int deleteByExample(AppletInterpretExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletInterpret record);

    int insertSelective(AppletInterpret record);

    List<AppletInterpret> selectByExample(AppletInterpretExample example);

    AppletInterpret selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletInterpret record, @Param("example") AppletInterpretExample example);

    int updateByExample(@Param("record") AppletInterpret record, @Param("example") AppletInterpretExample example);

    int updateByPrimaryKeySelective(AppletInterpret record);

    int updateByPrimaryKey(AppletInterpret record);
}