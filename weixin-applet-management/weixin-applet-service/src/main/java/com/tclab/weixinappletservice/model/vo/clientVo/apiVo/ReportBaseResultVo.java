package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class ReportBaseResultVo {

    private String userId;

    private String reportId;

    private String acquisitionName;

    private String doctorName;

    private String doctorPhone;

    private String reportImg;

    private String goodNo;

    private String packageId;

    private String packageName;

    private Integer reportStatus;

    private Integer interpretStatus;

    private Integer goodStatus;

    private String reportDate;

    private String participantId;

    private String sampleNo;

    private String pdfUrl;

    private String pdfMergeUrl;


    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public Integer getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(Integer goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getSampleNo() {
        return sampleNo;
    }

    public void setSampleNo(String sampleNo) {
        this.sampleNo = sampleNo;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }


    public String getReportImg() {
        return reportImg;
    }

    public void setReportImg(String reportImg) {
        this.reportImg = reportImg;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getInterpretStatus() {
        return interpretStatus;
    }

    public void setInterpretStatus(Integer interpretStatus) {
        this.interpretStatus = interpretStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getReportId() {
        return reportId;
    }

    public void setReportId(String reportId) {
        this.reportId = reportId;
    }

    public String getAcquisitionName() {
        return acquisitionName;
    }

    public void setAcquisitionName(String acquisitionName) {
        this.acquisitionName = acquisitionName;
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo;
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Integer getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Integer reportStatus) {
        this.reportStatus = reportStatus;
    }

    public String getPdfMergeUrl() {
        return pdfMergeUrl;
    }

    public void setPdfMergeUrl(String pdfMergeUrl) {
        this.pdfMergeUrl = pdfMergeUrl;
    }
}
