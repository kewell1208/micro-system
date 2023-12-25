package com.tclab.weixinappletservice.model.query;

import lombok.Data;

@Data
public class QueryImRecordParam {

    private String userId;
    private String doctorId;
    private String participantId;
    private String queryDate;
    private Integer status;
    private Integer type;

}
