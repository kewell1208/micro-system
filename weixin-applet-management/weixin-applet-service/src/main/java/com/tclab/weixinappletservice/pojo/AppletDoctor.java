package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AppletDoctor {
    private Integer id;

    private String doctorId;

    private String doctorName;

    private String doctorSex;

    private String doctorPhone;

    private String doctorIdCard;

    private String hospitalId;

    private String hospitalName;

    private String doctorDepartmentId;

    private String doctorDepartmentName;

    private Integer doctorType;

    private String doctorRank;

    private String doctorRankImage;

    private String doctorJobImage;

    private String doctorIntroduction;

    private String doctorExpert;

    private String doctorRemark;

    private Integer verifyFlag;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private Integer doctorStatus;

    private Double doctorScore;

    private String doctorLogo;

    private BigDecimal doctorInquiryPrice;

    private BigDecimal doctorInquiryImagePrice;

    private BigDecimal doctorInquiryPhonePrice;

    private Integer doctorInquiryCount;

    private BigDecimal doctorInterpretPrice;

    private Integer doctorInterpretCount;

    private String doctorLabel;

    private String doctorQrcode;

    private String doctorUuid;

    private String doctorOpenid;

    private String doctorPassword;

    private Integer doctorAuthority;

    private Integer doctorOrderCredentials;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName == null ? null : doctorName.trim();
    }

    public String getDoctorSex() {
        return doctorSex;
    }

    public void setDoctorSex(String doctorSex) {
        this.doctorSex = doctorSex == null ? null : doctorSex.trim();
    }

    public String getDoctorPhone() {
        return doctorPhone;
    }

    public void setDoctorPhone(String doctorPhone) {
        this.doctorPhone = doctorPhone == null ? null : doctorPhone.trim();
    }

    public String getDoctorIdCard() {
        return doctorIdCard;
    }

    public void setDoctorIdCard(String doctorIdCard) {
        this.doctorIdCard = doctorIdCard == null ? null : doctorIdCard.trim();
    }

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId == null ? null : hospitalId.trim();
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName == null ? null : hospitalName.trim();
    }

    public String getDoctorDepartmentId() {
        return doctorDepartmentId;
    }

    public void setDoctorDepartmentId(String doctorDepartmentId) {
        this.doctorDepartmentId = doctorDepartmentId == null ? null : doctorDepartmentId.trim();
    }

    public String getDoctorDepartmentName() {
        return doctorDepartmentName;
    }

    public void setDoctorDepartmentName(String doctorDepartmentName) {
        this.doctorDepartmentName = doctorDepartmentName == null ? null : doctorDepartmentName.trim();
    }

    public Integer getDoctorType() {
        return doctorType;
    }

    public void setDoctorType(Integer doctorType) {
        this.doctorType = doctorType;
    }

    public String getDoctorRank() {
        return doctorRank;
    }

    public void setDoctorRank(String doctorRank) {
        this.doctorRank = doctorRank == null ? null : doctorRank.trim();
    }

    public String getDoctorRankImage() {
        return doctorRankImage;
    }

    public void setDoctorRankImage(String doctorRankImage) {
        this.doctorRankImage = doctorRankImage == null ? null : doctorRankImage.trim();
    }

    public String getDoctorJobImage() {
        return doctorJobImage;
    }

    public void setDoctorJobImage(String doctorJobImage) {
        this.doctorJobImage = doctorJobImage == null ? null : doctorJobImage.trim();
    }

    public String getDoctorIntroduction() {
        return doctorIntroduction;
    }

    public void setDoctorIntroduction(String doctorIntroduction) {
        this.doctorIntroduction = doctorIntroduction == null ? null : doctorIntroduction.trim();
    }

    public String getDoctorExpert() {
        return doctorExpert;
    }

    public void setDoctorExpert(String doctorExpert) {
        this.doctorExpert = doctorExpert == null ? null : doctorExpert.trim();
    }

    public String getDoctorRemark() {
        return doctorRemark;
    }

    public void setDoctorRemark(String doctorRemark) {
        this.doctorRemark = doctorRemark == null ? null : doctorRemark.trim();
    }

    public Integer getVerifyFlag() {
        return verifyFlag;
    }

    public void setVerifyFlag(Integer verifyFlag) {
        this.verifyFlag = verifyFlag;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(Integer doctorStatus) {
        this.doctorStatus = doctorStatus;
    }

    public Double getDoctorScore() {
        return doctorScore;
    }

    public void setDoctorScore(Double doctorScore) {
        this.doctorScore = doctorScore;
    }

    public String getDoctorLogo() {
        return doctorLogo;
    }

    public void setDoctorLogo(String doctorLogo) {
        this.doctorLogo = doctorLogo == null ? null : doctorLogo.trim();
    }

    public BigDecimal getDoctorInquiryPrice() {
        return doctorInquiryPrice;
    }

    public void setDoctorInquiryPrice(BigDecimal doctorInquiryPrice) {
        this.doctorInquiryPrice = doctorInquiryPrice;
    }

    public BigDecimal getDoctorInquiryImagePrice() {
        return doctorInquiryImagePrice;
    }

    public void setDoctorInquiryImagePrice(BigDecimal doctorInquiryImagePrice) {
        this.doctorInquiryImagePrice = doctorInquiryImagePrice;
    }

    public BigDecimal getDoctorInquiryPhonePrice() {
        return doctorInquiryPhonePrice;
    }

    public void setDoctorInquiryPhonePrice(BigDecimal doctorInquiryPhonePrice) {
        this.doctorInquiryPhonePrice = doctorInquiryPhonePrice;
    }

    public Integer getDoctorInquiryCount() {
        return doctorInquiryCount;
    }

    public void setDoctorInquiryCount(Integer doctorInquiryCount) {
        this.doctorInquiryCount = doctorInquiryCount;
    }

    public BigDecimal getDoctorInterpretPrice() {
        return doctorInterpretPrice;
    }

    public void setDoctorInterpretPrice(BigDecimal doctorInterpretPrice) {
        this.doctorInterpretPrice = doctorInterpretPrice;
    }

    public Integer getDoctorInterpretCount() {
        return doctorInterpretCount;
    }

    public void setDoctorInterpretCount(Integer doctorInterpretCount) {
        this.doctorInterpretCount = doctorInterpretCount;
    }

    public String getDoctorLabel() {
        return doctorLabel;
    }

    public void setDoctorLabel(String doctorLabel) {
        this.doctorLabel = doctorLabel == null ? null : doctorLabel.trim();
    }

    public String getDoctorQrcode() {
        return doctorQrcode;
    }

    public void setDoctorQrcode(String doctorQrcode) {
        this.doctorQrcode = doctorQrcode == null ? null : doctorQrcode.trim();
    }

    public String getDoctorUuid() {
        return doctorUuid;
    }

    public void setDoctorUuid(String doctorUuid) {
        this.doctorUuid = doctorUuid == null ? null : doctorUuid.trim();
    }

    public String getDoctorOpenid() {
        return doctorOpenid;
    }

    public void setDoctorOpenid(String doctorOpenid) {
        this.doctorOpenid = doctorOpenid == null ? null : doctorOpenid.trim();
    }

    public String getDoctorPassword() {
        return doctorPassword;
    }

    public void setDoctorPassword(String doctorPassword) {
        this.doctorPassword = doctorPassword == null ? null : doctorPassword.trim();
    }

    public Integer getDoctorAuthority() {
        return doctorAuthority;
    }

    public void setDoctorAuthority(Integer doctorAuthority) {
        this.doctorAuthority = doctorAuthority;
    }

    public Integer getDoctorOrderCredentials() {
        return doctorOrderCredentials;
    }

    public void setDoctorOrderCredentials(Integer doctorOrderCredentials) {
        this.doctorOrderCredentials = doctorOrderCredentials;
    }
}