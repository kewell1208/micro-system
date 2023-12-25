package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletImRelation;
import com.tclab.weixinappletservice.pojo.AppletImRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletImRelationMapper {
    long countByExample(AppletImRelationExample example);

    int deleteByExample(AppletImRelationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletImRelation record);

    int insertSelective(AppletImRelation record);

    List<AppletImRelation> selectByExample(AppletImRelationExample example);

    AppletImRelation selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletImRelation record, @Param("example") AppletImRelationExample example);

    int updateByExample(@Param("record") AppletImRelation record, @Param("example") AppletImRelationExample example);

    int updateByPrimaryKeySelective(AppletImRelation record);

    int updateByPrimaryKey(AppletImRelation record);
}