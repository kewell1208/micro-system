package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class AlphabetPurposeVo {

    private String alphabet;

    private List<PurposeVo> purposeVos = new ArrayList<>();

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public List<PurposeVo> getPurposeVos() {
        return purposeVos;
    }

    public void setPurposeVos(List<PurposeVo> purposeVos) {
        this.purposeVos = purposeVos;
    }
}
