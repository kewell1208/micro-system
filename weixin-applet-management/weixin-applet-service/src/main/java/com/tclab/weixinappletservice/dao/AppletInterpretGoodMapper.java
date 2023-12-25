package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletInterpretGood;
import com.tclab.weixinappletservice.pojo.AppletInterpretGoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletInterpretGoodMapper {
    long countByExample(AppletInterpretGoodExample example);

    int deleteByExample(AppletInterpretGoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletInterpretGood record);

    int insertSelective(AppletInterpretGood record);

    List<AppletInterpretGood> selectByExample(AppletInterpretGoodExample example);

    AppletInterpretGood selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletInterpretGood record, @Param("example") AppletInterpretGoodExample example);

    int updateByExample(@Param("record") AppletInterpretGood record, @Param("example") AppletInterpretGoodExample example);

    int updateByPrimaryKeySelective(AppletInterpretGood record);

    int updateByPrimaryKey(AppletInterpretGood record);
}