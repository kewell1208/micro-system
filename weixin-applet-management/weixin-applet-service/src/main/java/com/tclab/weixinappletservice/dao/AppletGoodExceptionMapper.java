package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletGoodException;
import com.tclab.weixinappletservice.pojo.AppletGoodExceptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletGoodExceptionMapper {
    long countByExample(AppletGoodExceptionExample example);

    int deleteByExample(AppletGoodExceptionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletGoodException record);

    int insertSelective(AppletGoodException record);

    List<AppletGoodException> selectByExample(AppletGoodExceptionExample example);

    AppletGoodException selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletGoodException record, @Param("example") AppletGoodExceptionExample example);

    int updateByExample(@Param("record") AppletGoodException record, @Param("example") AppletGoodExceptionExample example);

    int updateByPrimaryKeySelective(AppletGoodException record);

    int updateByPrimaryKey(AppletGoodException record);
}