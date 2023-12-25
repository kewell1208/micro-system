package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class PackageStepVo {

    private List<StepVo> steps = new ArrayList<>();

    public List<StepVo> getSteps() {
        return steps;
    }

    public void setSteps(List<StepVo> steps) {
        this.steps = steps;
    }
}
