package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletPackageTag;
import com.tclab.weixinappletservice.pojo.AppletPackageTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackageTagMapper {
    long countByExample(AppletPackageTagExample example);

    int deleteByExample(AppletPackageTagExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackageTag record);

    int insertSelective(AppletPackageTag record);

    List<AppletPackageTag> selectByExample(AppletPackageTagExample example);

    AppletPackageTag selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackageTag record, @Param("example") AppletPackageTagExample example);

    int updateByExample(@Param("record") AppletPackageTag record, @Param("example") AppletPackageTagExample example);

    int updateByPrimaryKeySelective(AppletPackageTag record);

    int updateByPrimaryKey(AppletPackageTag record);
}