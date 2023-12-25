package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.PackageQueryParam;
import com.tclab.weixinappletservice.model.query.QueryIdParam;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PackageVo;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.pojo.AppletPackageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackageMapper {
    long countByExample(AppletPackageExample example);

    int deleteByExample(AppletPackageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackage record);

    int insertSelective(AppletPackage record);

    List<AppletPackage> selectByExample(AppletPackageExample example);

    AppletPackage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackage record, @Param("example") AppletPackageExample example);

    int updateByExample(@Param("record") AppletPackage record, @Param("example") AppletPackageExample example);

    int updateByPrimaryKeySelective(AppletPackage record);

    int updateByPrimaryKey(AppletPackage record);

  List<AppletPackage> queryPackageByParam(PackageQueryParam param);

  int updatePackageRecommendForAll();

  List<AppletPackage> selectByTag(QueryIdParam param);

  List<PackageVo> selectByImRecommendListId(String imRecommendListId);

}