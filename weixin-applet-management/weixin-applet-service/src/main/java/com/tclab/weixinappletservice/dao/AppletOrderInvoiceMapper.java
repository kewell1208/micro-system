package com.tclab.weixinappletservice.dao;

import com.tclab.weixinappletservice.pojo.AppletOrderInvoice;
import com.tclab.weixinappletservice.pojo.AppletOrderInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppletOrderInvoiceMapper {
    long countByExample(AppletOrderInvoiceExample example);

    int deleteByExample(AppletOrderInvoiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AppletOrderInvoice record);

    int insertSelective(AppletOrderInvoice record);

    List<AppletOrderInvoice> selectByExample(AppletOrderInvoiceExample example);

    AppletOrderInvoice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AppletOrderInvoice record, @Param("example") AppletOrderInvoiceExample example);

    int updateByExample(@Param("record") AppletOrderInvoice record, @Param("example") AppletOrderInvoiceExample example);

    int updateByPrimaryKeySelective(AppletOrderInvoice record);

    int updateByPrimaryKey(AppletOrderInvoice record);
}