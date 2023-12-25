package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;

public class OpenInvoiceResponseVo {

    private String status;

    private String message;

    private String fpqqlsh;

    @Override
    public String toString() {
        return "OpenInvoiceResponseVo{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                ", fpqqlsh='" + fpqqlsh + '\'' +
                '}';
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFpqqlsh() {
        return fpqqlsh;
    }

    public void setFpqqlsh(String fpqqlsh) {
        this.fpqqlsh = fpqqlsh;
    }
}
