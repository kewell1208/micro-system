package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.QueryIdParam;
import com.tclab.weixinappletservice.model.result.PackageListForDoctorVo;
import com.tclab.weixinappletservice.pojo.AppletPackagePurposeFilter;
import com.tclab.weixinappletservice.pojo.AppletPackagePurposeFilterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackagePurposeFilterMapper {
    long countByExample(AppletPackagePurposeFilterExample example);

    int deleteByExample(AppletPackagePurposeFilterExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackagePurposeFilter record);

    int insertSelective(AppletPackagePurposeFilter record);

    List<AppletPackagePurposeFilter> selectByExample(AppletPackagePurposeFilterExample example);

    AppletPackagePurposeFilter selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackagePurposeFilter record, @Param("example") AppletPackagePurposeFilterExample example);

    int updateByExample(@Param("record") AppletPackagePurposeFilter record, @Param("example") AppletPackagePurposeFilterExample example);

    int updateByPrimaryKeySelective(AppletPackagePurposeFilter record);

    int updateByPrimaryKey(AppletPackagePurposeFilter record);

    List<PackageListForDoctorVo> selectPackageListResult(QueryIdParam param);
}