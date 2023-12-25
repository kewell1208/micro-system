package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletGoodReport;
import com.tclab.weixinappletservice.pojo.AppletGoodReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletGoodReportMapper {
    long countByExample(AppletGoodReportExample example);

    int deleteByExample(AppletGoodReportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletGoodReport record);

    int insertSelective(AppletGoodReport record);

    List<AppletGoodReport> selectByExample(AppletGoodReportExample example);

    AppletGoodReport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletGoodReport record, @Param("example") AppletGoodReportExample example);

    int updateByExample(@Param("record") AppletGoodReport record, @Param("example") AppletGoodReportExample example);

    int updateByPrimaryKeySelective(AppletGoodReport record);

    int updateByPrimaryKey(AppletGoodReport record);
}