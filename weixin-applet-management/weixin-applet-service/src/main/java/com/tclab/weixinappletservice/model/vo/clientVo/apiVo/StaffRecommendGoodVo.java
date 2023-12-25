package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import com.tclab.weixinappletservice.model.result.GoodExtendBaseVo;

import java.util.ArrayList;
import java.util.List;

public class StaffRecommendGoodVo {

    private String packageName;

    private List<GoodExtendBaseVo> goodExtendBaseVos = new ArrayList<>();

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public List<GoodExtendBaseVo> getGoodExtendBaseVos() {
        return goodExtendBaseVos;
    }

    public void setGoodExtendBaseVos(List<GoodExtendBaseVo> goodExtendBaseVos) {
        this.goodExtendBaseVos = goodExtendBaseVos;
    }
}
