package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletOrderServiceInfo;
import com.tclab.weixinappletservice.pojo.AppletOrderServiceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletOrderServiceInfoMapper {
    long countByExample(AppletOrderServiceInfoExample example);

    int deleteByExample(AppletOrderServiceInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletOrderServiceInfo record);

    int insertSelective(AppletOrderServiceInfo record);

    List<AppletOrderServiceInfo> selectByExample(AppletOrderServiceInfoExample example);

    AppletOrderServiceInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletOrderServiceInfo record, @Param("example") AppletOrderServiceInfoExample example);

    int updateByExample(@Param("record") AppletOrderServiceInfo record, @Param("example") AppletOrderServiceInfoExample example);

    int updateByPrimaryKeySelective(AppletOrderServiceInfo record);

    int updateByPrimaryKey(AppletOrderServiceInfo record);
}