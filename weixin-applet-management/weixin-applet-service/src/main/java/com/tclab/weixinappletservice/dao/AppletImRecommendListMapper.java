package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.QueryImRecordParam;
import com.tclab.weixinappletservice.pojo.AppletImRecommendList;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletImRecommendListMapper {

  long countByExample(AppletImRecommendListExample example);

  int deleteByExample(AppletImRecommendListExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(AppletImRecommendList record);

  int insertSelective(AppletImRecommendList record);

  List<AppletImRecommendList> selectByExample(AppletImRecommendListExample example);

  AppletImRecommendList selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") AppletImRecommendList record, @Param("example") AppletImRecommendListExample example);

  int updateByExample(@Param("record") AppletImRecommendList record, @Param("example") AppletImRecommendListExample example);

  int updateByPrimaryKeySelective(AppletImRecommendList record);

  int updateByPrimaryKey(AppletImRecommendList record);

  List<AppletImRecommendList> selectImRecommendDoctorByParam(QueryImRecordParam param);

  List<AppletImRecommendList> selectImRecommendByDoctor(QueryImRecordParam param);
}