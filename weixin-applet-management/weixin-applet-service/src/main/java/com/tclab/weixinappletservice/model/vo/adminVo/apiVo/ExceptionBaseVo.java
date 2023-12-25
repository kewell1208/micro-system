package com.tclab.weixinappletservice.model.vo.adminVo.apiVo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(value = "ExceptionBaseVo",description = "异常信息")
public class ExceptionBaseVo {

    private Integer id;
    private String goodNo;
    private String orderNo;
    private String goodApplyDate;
    private String packageId;
    private String packageName;
    private String participantId;
    private String participantName;
    private String participantPhone;
    private Integer exceptionReason;
    private Integer exceptionSolution;
    private Integer exceptionStatus;
    private String exceptionSolveTime;
    private String goodDelayApplyDate;
    private Integer delFlag;

}
