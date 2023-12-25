package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletMessage;
import com.tclab.weixinappletservice.pojo.AppletMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletMessageMapper {
    long countByExample(AppletMessageExample example);

    int deleteByExample(AppletMessageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletMessage record);

    int insertSelective(AppletMessage record);

    List<AppletMessage> selectByExample(AppletMessageExample example);

    AppletMessage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletMessage record, @Param("example") AppletMessageExample example);

    int updateByExample(@Param("record") AppletMessage record, @Param("example") AppletMessageExample example);

    int updateByPrimaryKeySelective(AppletMessage record);

    int updateByPrimaryKey(AppletMessage record);
}