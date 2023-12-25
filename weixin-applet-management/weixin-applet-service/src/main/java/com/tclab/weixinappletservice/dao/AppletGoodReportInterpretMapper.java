package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletGoodReportInterpret;
import com.tclab.weixinappletservice.pojo.AppletGoodReportInterpretExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletGoodReportInterpretMapper {
    long countByExample(AppletGoodReportInterpretExample example);

    int deleteByExample(AppletGoodReportInterpretExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletGoodReportInterpret record);

    int insertSelective(AppletGoodReportInterpret record);

    List<AppletGoodReportInterpret> selectByExample(AppletGoodReportInterpretExample example);

    AppletGoodReportInterpret selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletGoodReportInterpret record, @Param("example") AppletGoodReportInterpretExample example);

    int updateByExample(@Param("record") AppletGoodReportInterpret record, @Param("example") AppletGoodReportInterpretExample example);

    int updateByPrimaryKeySelective(AppletGoodReportInterpret record);

    int updateByPrimaryKey(AppletGoodReportInterpret record);
}