package com.tclab.weixinappletuserclient.model.vo;

import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.OrderListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ReportBaseVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderInterpretBaseVo {

    private OrderListVo orderBaseVo;

    private List<ReportBaseVo> goodInfoByNoResults = new ArrayList<>();

}
