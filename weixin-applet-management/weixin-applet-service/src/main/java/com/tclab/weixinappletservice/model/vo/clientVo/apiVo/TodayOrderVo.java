package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class TodayOrderVo {

    private Long countForUnCollect;

    private Long countForCollected;

    private Long countForException;

    public Long getCountForUnCollect() {
        return countForUnCollect;
    }

    public void setCountForUnCollect(Long countForUnCollect) {
        this.countForUnCollect = countForUnCollect;
    }

    public Long getCountForCollected() {
        return countForCollected;
    }

    public void setCountForCollected(Long countForCollected) {
        this.countForCollected = countForCollected;
    }

    public Long getCountForException() {
        return countForException;
    }

    public void setCountForException(Long countForException) {
        this.countForException = countForException;
    }

    private List<RecentOrderInfoVo> todayOrderInfos = new ArrayList<>();

    public List<RecentOrderInfoVo> getTodayOrderInfos() {
        return todayOrderInfos;
    }

    public void setTodayOrderInfos(List<RecentOrderInfoVo> todayOrderInfos) {
        this.todayOrderInfos = todayOrderInfos;
    }
}
