package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

public class BannerVo {

    private String bannerId;

    private String bannerName;

    private String bannerImg;

    private Integer bannerIndex;

    public String getBannerId() {
        return bannerId;
    }

    public void setBannerId(String bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerName() {
        return bannerName;
    }

    public void setBannerName(String bannerName) {
        this.bannerName = bannerName;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public Integer getBannerIndex() {
        return bannerIndex;
    }

    public void setBannerIndex(Integer bannerIndex) {
        this.bannerIndex = bannerIndex;
    }
}
