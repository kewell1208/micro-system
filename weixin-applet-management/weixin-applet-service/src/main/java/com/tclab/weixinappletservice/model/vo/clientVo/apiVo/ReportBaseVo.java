package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class ReportBaseVo extends GoodBaseVo {

    private String doctorName;

    private String pdfUrl;

    private String pdfMergeUrl;

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getPdfMergeUrl() {
        return pdfMergeUrl;
    }

    public void setPdfMergeUrl(String pdfMergeUrl) {
        this.pdfMergeUrl = pdfMergeUrl;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
