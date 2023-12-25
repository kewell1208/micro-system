package com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultVo {

    private List<MessageListVo> Message;
    private int State;

    @Override
    public String toString() {
        return "ResultVo{" +
                "Message=" + Message +
                ", State=" + State +
                '}';
    }

    public void setMessage(List<MessageListVo> Message) {
        this.Message = Message;
    }

    public List<MessageListVo> getMessage() {
        return Message;
    }

    public void setState(int State) {
        this.State = State;
    }

    public int getState() {
        return State;
    }
}
