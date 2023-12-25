package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletPackageSource;
import com.tclab.weixinappletservice.pojo.AppletPackageSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackageSourceMapper {
    long countByExample(AppletPackageSourceExample example);

    int deleteByExample(AppletPackageSourceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackageSource record);

    int insertSelective(AppletPackageSource record);

    List<AppletPackageSource> selectByExample(AppletPackageSourceExample example);

    AppletPackageSource selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackageSource record, @Param("example") AppletPackageSourceExample example);

    int updateByExample(@Param("record") AppletPackageSource record, @Param("example") AppletPackageSourceExample example);

    int updateByPrimaryKeySelective(AppletPackageSource record);

    int updateByPrimaryKey(AppletPackageSource record);
}