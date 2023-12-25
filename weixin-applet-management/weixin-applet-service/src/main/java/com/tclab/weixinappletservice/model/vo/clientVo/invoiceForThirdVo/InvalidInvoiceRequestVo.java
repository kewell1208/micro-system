package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;

public class InvalidInvoiceRequestVo {

    private String identity;

    private InvalidInvoiceInfoVo order;

    @Override
    public String toString() {
        return "InvalidInvoiceRequestVo{" +
                "identity='" + identity + '\'' +
                ", order=" + order +
                '}';
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public InvalidInvoiceInfoVo getOrder() {
        return order;
    }

    public void setOrder(InvalidInvoiceInfoVo order) {
        this.order = order;
    }
}
