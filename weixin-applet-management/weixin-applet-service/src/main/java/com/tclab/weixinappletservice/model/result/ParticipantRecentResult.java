package com.tclab.weixinappletservice.model.result;

import java.util.Date;

public class ParticipantRecentResult {

    private String participantId;

    private String participantName;

    private String participantIdCard;

    private String participantPhone;

    private String participantAddress;

    private Date maxOrderCompleteApplyDate;

    public String getParticipantAddress() {
        return participantAddress;
    }

    public void setParticipantAddress(String participantAddress) {
        this.participantAddress = participantAddress;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getParticipantName() {
        return participantName;
    }

    public void setParticipantName(String participantName) {
        this.participantName = participantName;
    }

    public String getParticipantIdCard() {
        return participantIdCard;
    }

    public void setParticipantIdCard(String participantIdCard) {
        this.participantIdCard = participantIdCard;
    }

    public String getParticipantPhone() {
        return participantPhone;
    }

    public void setParticipantPhone(String participantPhone) {
        this.participantPhone = participantPhone;
    }

    public Date getMaxOrderCompleteApplyDate() {
        return maxOrderCompleteApplyDate;
    }

    public void setMaxOrderCompleteApplyDate(Date maxOrderCompleteApplyDate) {
        this.maxOrderCompleteApplyDate = maxOrderCompleteApplyDate;
    }
}
