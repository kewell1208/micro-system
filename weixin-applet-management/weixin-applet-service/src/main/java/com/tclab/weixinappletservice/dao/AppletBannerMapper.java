package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletBanner;
import com.tclab.weixinappletservice.pojo.AppletBannerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletBannerMapper {
    long countByExample(AppletBannerExample example);

    int deleteByExample(AppletBannerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletBanner record);

    int insertSelective(AppletBanner record);

    List<AppletBanner> selectByExample(AppletBannerExample example);

    AppletBanner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletBanner record, @Param("example") AppletBannerExample example);

    int updateByExample(@Param("record") AppletBanner record, @Param("example") AppletBannerExample example);

    int updateByPrimaryKeySelective(AppletBanner record);

    int updateByPrimaryKey(AppletBanner record);
}