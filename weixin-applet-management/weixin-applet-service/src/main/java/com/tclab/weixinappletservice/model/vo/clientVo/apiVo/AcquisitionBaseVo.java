package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class AcquisitionBaseVo {

    private String acquisitionId;

    private String acquisitionLogo;

    private String acquisitionName;

    private String acquisitionPhone;

    private String acquisitionAddress;

    private String acquisitionMessage;

    private String acquisitionOfficeTime;

    private Float acquisitionScore;

    private String acquisitionLabel;

    private Integer acquisitionPriority;

    private String acquisitionCoordinate;

    private long orderCount;

    private double distance;

    private Integer acquisitionStatus;

  public Integer getAcquisitionStatus() {
    return acquisitionStatus;
  }

  public void setAcquisitionStatus(Integer acquisitionStatus) {
    this.acquisitionStatus = acquisitionStatus;
  }

  public String getAcquisitionMessage() {
        return acquisitionMessage;
    }

    public void setAcquisitionMessage(String acquisitionMessage) {
        this.acquisitionMessage = acquisitionMessage;
    }

    public String getAcquisitionLogo() {
        return acquisitionLogo;
    }

    public void setAcquisitionLogo(String acquisitionLogo) {
        this.acquisitionLogo = acquisitionLogo;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public long getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(long orderCount) {
        this.orderCount = orderCount;
    }

    public String getAcquisitionId() {
        return acquisitionId;
    }

    public void setAcquisitionId(String acquisitionId) {
        this.acquisitionId = acquisitionId;
    }

    public String getAcquisitionName() {
        return acquisitionName;
    }

    public void setAcquisitionName(String acquisitionName) {
        this.acquisitionName = acquisitionName;
    }

    public String getAcquisitionPhone() {
        return acquisitionPhone;
    }

    public void setAcquisitionPhone(String acquisitionPhone) {
        this.acquisitionPhone = acquisitionPhone;
    }

    public String getAcquisitionAddress() {
        return acquisitionAddress;
    }

    public void setAcquisitionAddress(String acquisitionAddress) {
        this.acquisitionAddress = acquisitionAddress;
    }

    public String getAcquisitionOfficeTime() {
        return acquisitionOfficeTime;
    }

    public void setAcquisitionOfficeTime(String acquisitionOfficeTime) {
        this.acquisitionOfficeTime = acquisitionOfficeTime;
    }

    public Float getAcquisitionScore() {
        return acquisitionScore;
    }

    public void setAcquisitionScore(Float acquisitionScore) {
        this.acquisitionScore = acquisitionScore;
    }

    public String getAcquisitionLabel() {
        return acquisitionLabel;
    }

    public void setAcquisitionLabel(String acquisitionLabel) {
        this.acquisitionLabel = acquisitionLabel;
    }

    public Integer getAcquisitionPriority() {
        return acquisitionPriority;
    }

    public void setAcquisitionPriority(Integer acquisitionPriority) {
        this.acquisitionPriority = acquisitionPriority;
    }

    public String getAcquisitionCoordinate() {
        return acquisitionCoordinate;
    }

    public void setAcquisitionCoordinate(String acquisitionCoordinate) {
        this.acquisitionCoordinate = acquisitionCoordinate;
    }
}
