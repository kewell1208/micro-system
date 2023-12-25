package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.QueryImRecordParam;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListItem;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletImRecommendListItemMapper {
    long countByExample(AppletImRecommendListItemExample example);

    int deleteByExample(AppletImRecommendListItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletImRecommendListItem record);

    int insertSelective(AppletImRecommendListItem record);

    List<AppletImRecommendListItem> selectByExample(AppletImRecommendListItemExample example);

    AppletImRecommendListItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletImRecommendListItem record, @Param("example") AppletImRecommendListItemExample example);

    int updateByExample(@Param("record") AppletImRecommendListItem record, @Param("example") AppletImRecommendListItemExample example);

    int updateByPrimaryKeySelective(AppletImRecommendListItem record);

    int updateByPrimaryKey(AppletImRecommendListItem record);

    List<AppletImRecommendListItem> selectLastImRecommendItemForDoctor2participant(QueryImRecordParam param);

    Integer insertBatch(@Param("appletImRecommendListItemList") List<AppletImRecommendListItem> appletImRecommendListItemList);

    Integer updateBatch(@Param("appletImRecommendListItemList") List<AppletImRecommendListItem> appletImRecommendListItemList);

}