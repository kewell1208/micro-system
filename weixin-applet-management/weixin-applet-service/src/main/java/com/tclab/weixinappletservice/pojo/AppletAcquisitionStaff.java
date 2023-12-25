package com.tclab.weixinappletservice.pojo;

import java.util.Date;

public class AppletAcquisitionStaff {
    private Integer id;

    private String staffId;

    private String staffName;

    private String staffSex;

    private String staffPhone;

    private String staffIdCard;

    private String acquisitionId;

    private String departmentId;

    private Integer staffType;

    private String staffRank;

    private String staffRankImage;

    private String staffJobImage;

    private String staffIntroduction;

    private String staffExpert;

    private String staffRemark;

    private Integer verifyFlag;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private Integer staffStatus;

    private String staffLogo;

    private String doctorId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId == null ? null : staffId.trim();
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName == null ? null : staffName.trim();
    }

    public String getStaffSex() {
        return staffSex;
    }

    public void setStaffSex(String staffSex) {
        this.staffSex = staffSex == null ? null : staffSex.trim();
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone == null ? null : staffPhone.trim();
    }

    public String getStaffIdCard() {
        return staffIdCard;
    }

    public void setStaffIdCard(String staffIdCard) {
        this.staffIdCard = staffIdCard == null ? null : staffIdCard.trim();
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId == null ? null : acquisitionId.trim();
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId == null ? null : departmentId.trim();
    }

    public Integer getStaffType() {
        return staffType;
    }

    public void setStaffType(Integer staffType) {
        this.staffType = staffType;
    }

    public String getStaffRank() {
        return staffRank;
    }

    public void setStaffRank(String staffRank) {
        this.staffRank = staffRank == null ? null : staffRank.trim();
    }

    public String getStaffRankImage() {
        return staffRankImage;
    }

    public void setStaffRankImage(String staffRankImage) {
        this.staffRankImage = staffRankImage == null ? null : staffRankImage.trim();
    }

    public String getStaffJobImage() {
        return staffJobImage;
    }

    public void setStaffJobImage(String staffJobImage) {
        this.staffJobImage = staffJobImage == null ? null : staffJobImage.trim();
    }

    public String getStaffIntroduction() {
        return staffIntroduction;
    }

    public void setStaffIntroduction(String staffIntroduction) {
        this.staffIntroduction = staffIntroduction == null ? null : staffIntroduction.trim();
    }

    public String getStaffExpert() {
        return staffExpert;
    }

    public void setStaffExpert(String staffExpert) {
        this.staffExpert = staffExpert == null ? null : staffExpert.trim();
    }

    public String getStaffRemark() {
        return staffRemark;
    }

    public void setStaffRemark(String staffRemark) {
        this.staffRemark = staffRemark == null ? null : staffRemark.trim();
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

    public Integer getStaffStatus() {
        return staffStatus;
    }

    public void setStaffStatus(Integer staffStatus) {
        this.staffStatus = staffStatus;
    }

    public String getStaffLogo() {
        return staffLogo;
    }

    public void setStaffLogo(String staffLogo) {
        this.staffLogo = staffLogo == null ? null : staffLogo.trim();
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId == null ? null : doctorId.trim();
    }
}