package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.GoodStaffParam;
import com.tclab.weixinappletservice.model.query.QueryDoctorRecommendNumParam;
import com.tclab.weixinappletservice.model.query.QueryNoParam;
import com.tclab.weixinappletservice.model.result.*;

import com.tclab.weixinappletservice.pojo.AppletGood;
import com.tclab.weixinappletservice.pojo.AppletGoodExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletGoodMapper {
    long countByExample(AppletGoodExample example);

    int deleteByExample(AppletGoodExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletGood record);

    int insertSelective(AppletGood record);

    List<AppletGood> selectByExample(AppletGoodExample example);

    AppletGood selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletGood record, @Param("example") AppletGoodExample example);

    int updateByExample(@Param("record") AppletGood record, @Param("example") AppletGoodExample example);

    int updateByPrimaryKeySelective(AppletGood record);

    int updateByPrimaryKey(AppletGood record);


    //自写方法
    List<GoodInfoByNoResult> selectOutGoodPackageByNo(QueryNoParam param);

    List<GoodInfoByNoResult> selectGoodPackageByNo(QueryNoParam param);

    List<GoodExtendBaseVo> getGoodExtendVoWithParticipant(GoodStaffParam param);

    List<DoctorRecommendResult> selectDoctorRecommendNumByDate(QueryDoctorRecommendNumParam param);

    List<AppletGood> selectDoctorRecommendByDate(QueryDoctorRecommendNumParam param);

    List<ShulanParticipantListVo> selectDoctorRecommendByDateNew(QueryDoctorRecommendNumParam param);

    List<ShulanRecommendListNewVo> selectReportList(QueryDoctorRecommendNumParam param);

    List<AppletGood> selectTestingGood();

    List<AppletGood> checkBindGood(QueryNoParam param);

    List<AppletGood> checkCancelGood(QueryNoParam param);

    List<AppletGood> checkDelayGood(QueryNoParam param);

    List<AppletGood> selectByInterpretId(String interpretId);
}