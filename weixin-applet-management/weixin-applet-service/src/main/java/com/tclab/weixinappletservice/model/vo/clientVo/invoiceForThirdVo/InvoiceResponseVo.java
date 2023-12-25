package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;


public class InvoiceResponseVo {

    private String result;

    private String errorMsg;

    @Override
    public String toString() {
        return "InvoiceResponseVo{" +
                "result='" + result + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
