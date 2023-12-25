package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;

public class InvalidInvoiceInfoVo {

    private String fpdm;

    private String fphm;

    private String fpqqlsh;

    @Override
    public String toString() {
        return "InvalidInvoiceInfoVo{" +
                "fpdm='" + fpdm + '\'' +
                ", fphm='" + fphm + '\'' +
                ", fpqqlsh='" + fpqqlsh + '\'' +
                '}';
    }

    public String getFpdm() {
        return fpdm;
    }

    public void setFpdm(String fpdm) {
        this.fpdm = fpdm;
    }

    public String getFphm() {
        return fphm;
    }

    public void setFphm(String fphm) {
        this.fphm = fphm;
    }

    public String getFpqqlsh() {
        return fpqqlsh;
    }

    public void setFpqqlsh(String fpqqlsh) {
        this.fpqqlsh = fpqqlsh;
    }
}
