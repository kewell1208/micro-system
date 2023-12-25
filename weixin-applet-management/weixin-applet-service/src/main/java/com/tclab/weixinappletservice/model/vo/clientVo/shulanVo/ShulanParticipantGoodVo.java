package com.tclab.weixinappletservice.model.vo.clientVo.shulanVo;


import com.tclab.weixinappletservice.model.result.ShulanParticipantListVo;

import java.util.ArrayList;
import java.util.List;

public class ShulanParticipantGoodVo {

    private Integer recordNum;

    private List<ShulanParticipantListVo> participantList = new ArrayList<>();

    public Integer getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(Integer recordNum) {
        this.recordNum = recordNum;
    }

    public List<ShulanParticipantListVo> getParticipantList() {
        return participantList;
    }

    public void setParticipantList(List<ShulanParticipantListVo> participantList) {
        this.participantList = participantList;
    }
}
