package com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo;

public class ThirdResponseVo {

    private String Message;

    private Integer State;

    @Override
    public String toString() {
        return "ThirdResponseVo{" +
                "Message='" + Message + '\'' +
                ", State=" + State +
                '}';
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }
}
