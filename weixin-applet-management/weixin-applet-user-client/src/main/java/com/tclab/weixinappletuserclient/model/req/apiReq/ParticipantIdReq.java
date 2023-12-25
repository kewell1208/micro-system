package com.tclab.weixinappletuserclient.model.req.apiReq;

public class ParticipantIdReq {

    private String acquisitionId;

    private String participantId;

    @Override
    public String toString() {
        return "ParticipantIdReq{" +
                "acquisitionId='" + acquisitionId + '\'' +
                ", participantId='" + participantId + '\'' +
                '}';
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }
}
