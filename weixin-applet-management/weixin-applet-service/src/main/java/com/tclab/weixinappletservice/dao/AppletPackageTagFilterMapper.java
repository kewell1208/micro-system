package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletPackageTagFilter;
import com.tclab.weixinappletservice.pojo.AppletPackageTagFilterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackageTagFilterMapper {
    long countByExample(AppletPackageTagFilterExample example);

    int deleteByExample(AppletPackageTagFilterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackageTagFilter record);

    int insertSelective(AppletPackageTagFilter record);

    List<AppletPackageTagFilter> selectByExample(AppletPackageTagFilterExample example);

    AppletPackageTagFilter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackageTagFilter record, @Param("example") AppletPackageTagFilterExample example);

    int updateByExample(@Param("record") AppletPackageTagFilter record, @Param("example") AppletPackageTagFilterExample example);

    int updateByPrimaryKeySelective(AppletPackageTagFilter record);

    int updateByPrimaryKey(AppletPackageTagFilter record);
}