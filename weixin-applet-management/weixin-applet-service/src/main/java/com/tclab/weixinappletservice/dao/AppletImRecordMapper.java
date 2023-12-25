package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.QueryImRecordParam;
import com.tclab.weixinappletservice.pojo.AppletImRecord;
import com.tclab.weixinappletservice.pojo.AppletImRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletImRecordMapper {

  long countByExample(AppletImRecordExample example);

  int deleteByExample(AppletImRecordExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(AppletImRecord record);

  int insertSelective(AppletImRecord record);

  List<AppletImRecord> selectByExample(AppletImRecordExample example);

  AppletImRecord selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") AppletImRecord record, @Param("example") AppletImRecordExample example);

  int updateByExample(@Param("record") AppletImRecord record, @Param("example") AppletImRecordExample example);

  int updateByPrimaryKeySelective(AppletImRecord record);

  int updateByPrimaryKey(AppletImRecord record);

  List<AppletImRecord> selectRecentImRecordByDoctor(@Param("userId") String userId, @Param("doctorId") String doctorId);

  List<String> selectImRecordDoctor(QueryImRecordParam param);

  List<AppletImRecord> selectImRecordByDoctor(QueryImRecordParam param);

  List<AppletImRecord> getListByDoctor(AppletImRecordExample example);

  List<AppletImRecord> checkStartImRecord(QueryImRecordParam param);
}