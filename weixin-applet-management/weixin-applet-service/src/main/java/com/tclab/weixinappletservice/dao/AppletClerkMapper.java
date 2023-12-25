package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletClerk;
import com.tclab.weixinappletservice.pojo.AppletClerkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletClerkMapper {
    long countByExample(AppletClerkExample example);

    int deleteByExample(AppletClerkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletClerk record);

    int insertSelective(AppletClerk record);

    List<AppletClerk> selectByExample(AppletClerkExample example);

    AppletClerk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletClerk record, @Param("example") AppletClerkExample example);

    int updateByExample(@Param("record") AppletClerk record, @Param("example") AppletClerkExample example);

    int updateByPrimaryKeySelective(AppletClerk record);

    int updateByPrimaryKey(AppletClerk record);
}