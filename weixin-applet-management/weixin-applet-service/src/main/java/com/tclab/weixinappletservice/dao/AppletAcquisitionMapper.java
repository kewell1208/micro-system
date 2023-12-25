package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.AcquisitionDistanceOrderParam;
import com.tclab.weixinappletservice.pojo.AppletAcquisition;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletAcquisitionMapper {
    long countByExample(AppletAcquisitionExample example);

    int deleteByExample(AppletAcquisitionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletAcquisition record);

    int insertSelective(AppletAcquisition record);

    List<AppletAcquisition> selectByExample(AppletAcquisitionExample example);

    AppletAcquisition selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletAcquisition record, @Param("example") AppletAcquisitionExample example);

    int updateByExample(@Param("record") AppletAcquisition record, @Param("example") AppletAcquisitionExample example);

    int updateByPrimaryKeySelective(AppletAcquisition record);

    int updateByPrimaryKey(AppletAcquisition record);

  void updateAcquisitionRecommendForAll();

  List<AppletAcquisition> selectOrderAcquisitionByDistance(AcquisitionDistanceOrderParam param);


}