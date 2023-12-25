package com.tclab.weixinappletservice.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class AppletImRecommendListItem {
    private Integer id;

    private String imRecommendListId;

    private String itemId;

    private String packageNo;

    private String packageName;

    private BigDecimal packageCurrentPrice;

    private Integer delFlag;

    private Date createDate;

    private Date updateDate;

    private Integer recommendStatus;

    private Integer userConfirmStatus;

    private String goodNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImRecommendListId() {
        return imRecommendListId;
    }

    public void setImRecommendListId(String imRecommendListId) {
        this.imRecommendListId = imRecommendListId == null ? null : imRecommendListId.trim();
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId == null ? null : itemId.trim();
    }

    public String getPackageNo() {
        return packageNo;
    }

    public void setPackageNo(String packageNo) {
        this.packageNo = packageNo == null ? null : packageNo.trim();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName == null ? null : packageName.trim();
    }

    public BigDecimal getPackageCurrentPrice() {
        return packageCurrentPrice;
    }

    public void setPackageCurrentPrice(BigDecimal packageCurrentPrice) {
        this.packageCurrentPrice = packageCurrentPrice;
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

    public Integer getRecommendStatus() {
        return recommendStatus;
    }

    public void setRecommendStatus(Integer recommendStatus) {
        this.recommendStatus = recommendStatus;
    }

    public Integer getUserConfirmStatus() {
        return userConfirmStatus;
    }

    public void setUserConfirmStatus(Integer userConfirmStatus) {
        this.userConfirmStatus = userConfirmStatus;
    }

    public String getGoodNo() {
        return goodNo;
    }

    public void setGoodNo(String goodNo) {
        this.goodNo = goodNo == null ? null : goodNo.trim();
    }
}