package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletservice.dao.AppletOrderParticipantMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ServiceDateVo;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipantExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ParticipantService {

  @Autowired
  private AppletOrderParticipantMapper participantMapper;
  @Autowired
  private OrderService orderService;

  public List<AppletOrderParticipant> getParticipantByUserIdAndParticipantId(String userId, String participantId) {

    List<AppletOrderParticipant> participantList = new ArrayList<>();

    if (StringUtils.isBlank(userId)) {
      return participantList;
    }

    AppletOrderParticipantExample example = new AppletOrderParticipantExample();
    AppletOrderParticipantExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andUserIdEqualTo(userId);
    if (StringUtils.isNotBlank(participantId)) {
      criteria.andParticipantIdEqualTo(participantId);
    }
    return participantMapper.selectByExample(example);
  }

  public AppletOrderParticipant getParticipantByParticipantId(String participantId) {

    if (StringUtils.isBlank(participantId)) {
      return null;
    }

    AppletOrderParticipantExample example = new AppletOrderParticipantExample();
    AppletOrderParticipantExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andParticipantIdEqualTo(participantId);
    List<AppletOrderParticipant> participantList = participantMapper.selectByExample(example);
    if (participantList != null && participantList.size() != 0) {
      return participantList.get(0);
    }
    return null;
  }

  @Transactional
  public int editParticipant(AppletOrderParticipant participant) {
    AppletOrderParticipantExample example = new AppletOrderParticipantExample();
    AppletOrderParticipantExample.Criteria criteria = example.createCriteria();

    //预先判断是否是默认参检人
    if (participant.getDefaultFlag() != null && participant.getDefaultFlag().equals(CommonConstants.ENABLE)) {
      //如果参检人是默认参检人，则需要吧其他的参检人信息设置成非默认，然后再改成只一个默认的参检人
      criteria.andUserIdEqualTo(participant.getUserId());
      criteria.andDelFlagEqualTo(CommonConstants.INIT);
      AppletOrderParticipant updateParticipant = new AppletOrderParticipant();
      updateParticipant.setUpdateDate(new Date());
      updateParticipant.setDefaultFlag(CommonConstants.INIT);
      participantMapper.updateByExampleSelective(updateParticipant, example);
    }

    if (StringUtils.isNotBlank(participant.getParticipantId())) {

      example.clear();
      criteria = example.createCriteria();
      criteria.andDelFlagEqualTo(CommonConstants.INIT);
      criteria.andParticipantIdEqualTo(participant.getParticipantId());
      participant.setId(null);
      participant.setUpdateDate(new Date());

      int i = participantMapper.updateByExampleSelective(participant, example);
      return i;
    } else {

      participant.setDelFlag(CommonConstants.INIT);
      participant.setCreateDate(new Date());
      participant.setUpdateDate(new Date());
      participant.setParticipantId(NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_PARTICIPANT));
      participantMapper.insertSelective(participant);
      return participant.getId();
    }
  }

  public AppletOrderParticipant getParticipantByOrderNo(String orderNo) {
    AppletOrder order = orderService.getOrderByOrderNo(orderNo);
    if (StringUtils.isNotBlank(order.getParticipantId())) {
      AppletOrderParticipant participant = getParticipantByParticipantId(order.getParticipantId());
      return participant;
    } else {
      return null;
    }
  }

  @Transactional
  public boolean deleteParticipant(String participantId) {
    AppletOrderParticipantExample example = new AppletOrderParticipantExample();
    AppletOrderParticipantExample.Criteria criteria = example.createCriteria();
    criteria.andParticipantIdEqualTo(participantId);
    criteria.andDelFlagEqualTo(CommonConstants.INIT);

    AppletOrderParticipant participant = new AppletOrderParticipant();
    participant.setDelFlag(CommonConstants.ENABLE);
    participant.setUpdateDate(new Date());

    int i = participantMapper.updateByExampleSelective(participant, example);
    if (i == 0) {
      throw new RuntimeException("参检人删除失败");
    }
    return true;
  }

  public List<AppletOrderParticipant> getListByImDoctorId(String doctorId,String participantQuery) {
    return participantMapper.getImRecordParticipant(doctorId,participantQuery);
  }

  public List<ServiceDateVo> getServiceDateList(String doctorId, String participantId) {
    return participantMapper.getServiceDateList(doctorId, participantId);
  }

}
