package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletPackageCatalog;
import com.tclab.weixinappletservice.pojo.AppletPackageCatalogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackageCatalogMapper {
    long countByExample(AppletPackageCatalogExample example);

    int deleteByExample(AppletPackageCatalogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackageCatalog record);

    int insertSelective(AppletPackageCatalog record);

    List<AppletPackageCatalog> selectByExample(AppletPackageCatalogExample example);

    AppletPackageCatalog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackageCatalog record, @Param("example") AppletPackageCatalogExample example);

    int updateByExample(@Param("record") AppletPackageCatalog record, @Param("example") AppletPackageCatalogExample example);

    int updateByPrimaryKeySelective(AppletPackageCatalog record);

    int updateByPrimaryKey(AppletPackageCatalog record);
}