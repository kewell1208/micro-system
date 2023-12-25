package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletPackageSub;
import com.tclab.weixinappletservice.pojo.AppletPackageSubExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackageSubMapper {
    long countByExample(AppletPackageSubExample example);

    int deleteByExample(AppletPackageSubExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackageSub record);

    int insertSelective(AppletPackageSub record);

    List<AppletPackageSub> selectByExample(AppletPackageSubExample example);

    AppletPackageSub selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackageSub record, @Param("example") AppletPackageSubExample example);

    int updateByExample(@Param("record") AppletPackageSub record, @Param("example") AppletPackageSubExample example);

    int updateByPrimaryKeySelective(AppletPackageSub record);

    int updateByPrimaryKey(AppletPackageSub record);
}