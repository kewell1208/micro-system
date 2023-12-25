package com.tclab.weixinappletservice.model.vo.clientVo.apiVo;

import java.util.ArrayList;
import java.util.List;

public class TopBannerVo {

    private Integer bannerType;

    private List<BannerVo> bannerTypeList = new ArrayList<>();

    public Integer getBannerType() {
        return bannerType;
    }

    public void setBannerType(Integer bannerType) {
        this.bannerType = bannerType;
    }

    public List<BannerVo> getBannerTypeList() {
        return bannerTypeList;
    }

    public void setBannerTypeList(List<BannerVo> bannerTypeList) {
        this.bannerTypeList = bannerTypeList;
    }
}
