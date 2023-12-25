package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;

public class OpenInvoiceRequestVo {
    /**
     * ⾝份认证，在诺诺⽹备案后，由诺诺⽹提供，每个企业⼀个
     * 是否必填：必填
     */
    private String identity;
    /**
     * 请求体
     * 是否必填：必填
     */
    private InvoiceBaseVo order;

    @Override
    public String toString() {
        return "OpenInvoiceRequestVo{" +
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

    public InvoiceBaseVo getOrder() {
        return order;
    }

    public void setOrder(InvoiceBaseVo order) {
        this.order = order;
    }
}
