package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletPackagePurpose;
import com.tclab.weixinappletservice.pojo.AppletPackagePurposeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletPackagePurposeMapper {
    long countByExample(AppletPackagePurposeExample example);

    int deleteByExample(AppletPackagePurposeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletPackagePurpose record);

    int insertSelective(AppletPackagePurpose record);

    List<AppletPackagePurpose> selectByExample(AppletPackagePurposeExample example);

    AppletPackagePurpose selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletPackagePurpose record, @Param("example") AppletPackagePurposeExample example);

    int updateByExample(@Param("record") AppletPackagePurpose record, @Param("example") AppletPackagePurposeExample example);

    int updateByPrimaryKeySelective(AppletPackagePurpose record);

    int updateByPrimaryKey(AppletPackagePurpose record);
}