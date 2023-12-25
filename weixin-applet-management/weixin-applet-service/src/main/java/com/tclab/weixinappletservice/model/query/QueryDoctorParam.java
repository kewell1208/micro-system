package com.tclab.weixinappletservice.model.query;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class QueryDoctorParam {

    private String hospitalId;
    private String departmentId;
    private String doctorId;
    private String queryParam;
    private List<Integer> doctorAuthorityList = new ArrayList<>();

}
