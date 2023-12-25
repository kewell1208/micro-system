package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ServiceDateVo;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletOrderParticipantMapper {

  long countByExample(AppletOrderParticipantExample example);

  int deleteByExample(AppletOrderParticipantExample example);

  int deleteByPrimaryKey(Integer id);

  int insert(AppletOrderParticipant record);

  int insertSelective(AppletOrderParticipant record);

  List<AppletOrderParticipant> selectByExample(AppletOrderParticipantExample example);

  AppletOrderParticipant selectByPrimaryKey(Integer id);

  int updateByExampleSelective(@Param("record") AppletOrderParticipant record, @Param("example") AppletOrderParticipantExample example);

  int updateByExample(@Param("record") AppletOrderParticipant record, @Param("example") AppletOrderParticipantExample example);

  int updateByPrimaryKeySelective(AppletOrderParticipant record);

  int updateByPrimaryKey(AppletOrderParticipant record);

  List<AppletOrderParticipant> getImRecordParticipant(@Param("doctorId") String doctorId,@Param("participantQuery") String participantQuery);

  List<ServiceDateVo> getServiceDateList(@Param("doctorId") String doctorId, @Param("participantId") String participantId);

}