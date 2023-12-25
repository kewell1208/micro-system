package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.model.query.AcquisitionGetDayPageOrderStatusParam;
import com.tclab.weixinappletservice.model.query.AcquisitionNameOrPhoneQueryParam;
import com.tclab.weixinappletservice.model.query.InvoiceQueryParam;
import com.tclab.weixinappletservice.model.query.QueryNoParam;
import com.tclab.weixinappletservice.model.result.OrderDayGroupResult;
import com.tclab.weixinappletservice.model.result.ParticipantHistoryResult;
import com.tclab.weixinappletservice.model.result.ParticipantRecentResult;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.InvoiceOrderListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderForParticipantVo;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletOrderMapper {
    long countByExample(AppletOrderExample example);

    int deleteByExample(AppletOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletOrder record);

    int insertSelective(AppletOrder record);

    List<AppletOrder> selectByExample(AppletOrderExample example);

    AppletOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletOrder record, @Param("example") AppletOrderExample example);

    int updateByExample(@Param("record") AppletOrder record, @Param("example") AppletOrderExample example);

    int updateByPrimaryKeySelective(AppletOrder record);

    int updateByPrimaryKey(AppletOrder record);

  List<ParticipantRecentResult> selectParticipantAndRecentCollectInfoByNameOrPhone(AcquisitionNameOrPhoneQueryParam param);

  List<ParticipantHistoryResult> selectParticipantHistoryById(AcquisitionNameOrPhoneQueryParam param);

  OrderForParticipantVo selectOrderForParticipantVo(QueryNoParam param);

  List<OrderDayGroupResult> acquisitionGetOrderByStatus(AcquisitionGetDayPageOrderStatusParam param);

  List<InvoiceOrderListVo> selectByInvoiceStatus(InvoiceQueryParam param);

  BigDecimal getSumPayAmount(QueryNoParam param);

  BigDecimal getSumRefundAmount(QueryNoParam param);
}