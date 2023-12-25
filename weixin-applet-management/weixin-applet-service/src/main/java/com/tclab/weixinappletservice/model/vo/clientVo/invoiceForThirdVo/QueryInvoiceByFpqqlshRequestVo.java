package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;

import java.util.List;

public class QueryInvoiceByFpqqlshRequestVo {

    private String identity;

    private List<String> fpqqlsh;

    @Override
    public String toString() {
        return "QueryInvoiceByFpqqlshRequestVo{" +
                "identity='" + identity + '\'' +
                ", fpqqlsh=" + fpqqlsh +
                '}';
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public List<String> getFpqqlsh() {
        return fpqqlsh;
    }

    public void setFpqqlsh(List<String> fpqqlsh) {
        this.fpqqlsh = fpqqlsh;
    }
}
