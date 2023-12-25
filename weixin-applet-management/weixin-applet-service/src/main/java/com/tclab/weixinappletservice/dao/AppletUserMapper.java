package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletUser;
import com.tclab.weixinappletservice.pojo.AppletUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletUserMapper {
    long countByExample(AppletUserExample example);

    int deleteByExample(AppletUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletUser record);

    int insertSelective(AppletUser record);

    List<AppletUser> selectByExample(AppletUserExample example);

    AppletUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletUser record, @Param("example") AppletUserExample example);

    int updateByExample(@Param("record") AppletUser record, @Param("example") AppletUserExample example);

    int updateByPrimaryKeySelective(AppletUser record);

    int updateByPrimaryKey(AppletUser record);
}