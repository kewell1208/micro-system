package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class OrderForGroupByDayVo {

    private String date;

    private List<OrderForDayAndTimeVo> dateDetailListc = new ArrayList<>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<OrderForDayAndTimeVo> getDateDetailListc() {
        return dateDetailListc;
    }

    public void setDateDetailListc(List<OrderForDayAndTimeVo> dateDetailListc) {
        this.dateDetailListc = dateDetailListc;
    }
}
