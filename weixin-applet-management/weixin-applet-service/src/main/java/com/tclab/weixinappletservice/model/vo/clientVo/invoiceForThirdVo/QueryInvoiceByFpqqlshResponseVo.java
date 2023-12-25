package com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo;

import java.util.List;

public class QueryInvoiceByFpqqlshResponseVo extends InvoiceResponseVo {

    private List<InvoiceResponseInfoListVo> list;

    @Override
    public String toString() {
        return "QueryInvoiceByFpqqlshResponseVo{" +
                "result='" + getResult() + '\'' +
                ", errorMsg='" + getErrorMsg() + '\'' +
                "list=" + list +
                '}';
    }

    public List<InvoiceResponseInfoListVo> getList() {
        return list;
    }

    public void setList(List<InvoiceResponseInfoListVo> list) {
        this.list = list;
    }
}
