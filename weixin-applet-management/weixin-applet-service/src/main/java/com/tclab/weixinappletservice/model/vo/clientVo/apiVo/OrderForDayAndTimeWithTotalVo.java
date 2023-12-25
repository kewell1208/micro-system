package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class OrderForDayAndTimeWithTotalVo {

    private List<OrderForDayAndTimeVo> dayAndTimeVoList = new ArrayList<>();

    private Long total = 0L;

    public List<OrderForDayAndTimeVo> getDayAndTimeVoList() {
        return dayAndTimeVoList;
    }

    public void setDayAndTimeVoList(List<OrderForDayAndTimeVo> dayAndTimeVoList) {
        this.dayAndTimeVoList = dayAndTimeVoList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
