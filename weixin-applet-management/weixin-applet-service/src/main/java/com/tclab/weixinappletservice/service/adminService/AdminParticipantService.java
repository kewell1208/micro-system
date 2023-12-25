package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletservice.dao.AppletOrderParticipantMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.ParticipantBaseVo;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipantExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdminParticipantService {

    @Autowired
    private AppletOrderParticipantMapper participantMapper;

    public ParticipantBaseVo getParticipantByParticipantId(String participantId){

        if (StringUtils.isBlank(participantId)){
            return null;
        }

        AppletOrderParticipantExample participantExample = new AppletOrderParticipantExample();
        AppletOrderParticipantExample.Criteria participantExampleCriteria = participantExample.createCriteria();
        participantExampleCriteria.andParticipantIdEqualTo(participantId);
        List<AppletOrderParticipant> participantList = participantMapper.selectByExample(participantExample);
        if (participantList.size()!=0){
            ParticipantBaseVo participantBaseVo = new ParticipantBaseVo();
            BeanUtils.copyProperties(participantList.get(0),participantBaseVo);
            return participantBaseVo;
        } else {
            return null;
        }

    }

    public AppletOrderParticipant getParticipantByParticipantIdNew(String participantId){

        if (StringUtils.isBlank(participantId)){
            return null;
        }

        AppletOrderParticipantExample participantExample = new AppletOrderParticipantExample();
        AppletOrderParticipantExample.Criteria participantExampleCriteria = participantExample.createCriteria();
        participantExampleCriteria.andParticipantIdEqualTo(participantId);
        List<AppletOrderParticipant> participantList = participantMapper.selectByExample(participantExample);
        if (participantList.size()!=0){
            return participantList.get(0);
        } else {
            return null;
        }

    }

    public List<ParticipantBaseVo> getParticipantByUserId(String userId){
        AppletOrderParticipantExample participantExample = new AppletOrderParticipantExample();
        AppletOrderParticipantExample.Criteria participantExampleCriteria = participantExample.createCriteria();
        participantExampleCriteria.andUserIdEqualTo(userId);
        List<AppletOrderParticipant> participantList = participantMapper.selectByExample(participantExample);
        if (participantList != null && participantList.size() != 0){
            List<ParticipantBaseVo> participantBaseVoList = new ArrayList<>();
            for(AppletOrderParticipant appletOrderParticipant : participantList) {
                ParticipantBaseVo participantBaseVo = new ParticipantBaseVo();
                BeanUtils.copyProperties(appletOrderParticipant, participantBaseVo);
                participantBaseVoList.add(participantBaseVo);
            }
            return participantBaseVoList;
        } else {
            return null;
        }

    }

}
