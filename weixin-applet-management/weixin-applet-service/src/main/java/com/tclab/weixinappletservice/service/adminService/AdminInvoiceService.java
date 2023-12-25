package com.tclab.weixinappletservice.service.adminService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletservice.dao.AppletOrderInvoiceMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.InvoicePageListVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.InvoicePageVo;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import com.tclab.weixinappletservice.pojo.AppletOrderInvoice;
import com.tclab.weixinappletservice.pojo.AppletOrderInvoiceExample;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminInvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(AdminInvoiceService.class);

    @Autowired
    private AppletOrderInvoiceMapper invoiceMapper;
    @Autowired
    private AppletOrderMapper orderMapper;

    public InvoicePageVo getInvoiceApplyList(String userName, String userPhone, Integer dealStatus, Integer pageNo, Integer pageSize){
        AppletOrderInvoiceExample example = new AppletOrderInvoiceExample();
        AppletOrderInvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(userName))
            criteria.andUserNameLike("%"+userName+"%");
        if (StringUtils.isNotBlank(userPhone))
            criteria.andUserPhoneEqualTo(userPhone);
        if (dealStatus!=null&&dealStatus.equals(CommonConstants.ENABLE))
            criteria.andDealStatusEqualTo(dealStatus);
        if (dealStatus!=null&&dealStatus.equals(CommonConstants.PEND)){
            List<Integer> dealStatusList = new ArrayList<>();
            dealStatusList.add(CommonConstants.PEND);
            dealStatusList.add(CommonConstants.INVALID);
            criteria.andDealStatusIn(dealStatusList);
        }

        PageHelper.startPage(pageNo,pageSize);
        List<AppletOrderInvoice> invoiceList = invoiceMapper.selectByExample(example);
        PageInfo<AppletOrderInvoice> invoicePageInfo = new PageInfo<>(invoiceList);

        InvoicePageVo pageVo = new InvoicePageVo();
        pageVo.setCurrentPageNo(invoicePageInfo.getPageNum());
        pageVo.setOrderNum(invoicePageInfo.getTotal());
        pageVo.setPageNum(invoicePageInfo.getPages());

        List<InvoicePageListVo> listVoList = new ArrayList<>();

        invoiceList = invoicePageInfo.getList();
        for (AppletOrderInvoice invoice:invoiceList) {
            InvoicePageListVo listVo = new InvoicePageListVo();
            BeanUtils.copyProperties(invoice,listVo);
            listVo.setApplyDate(DateUtils.convertToSlashAndMinDate(invoice.getApplyDate()));
            listVoList.add(listVo);
        }
        pageVo.setInvoicePageListVoList(listVoList);
        return pageVo;
    }

    public AppletOrderInvoice getInvoiceByApplyId(String applyId){
        AppletOrderInvoiceExample example = new AppletOrderInvoiceExample();
        AppletOrderInvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(applyId))
            criteria.andApplyIdEqualTo(applyId);
        List<AppletOrderInvoice> invoiceList = invoiceMapper.selectByExample(example);
        if (invoiceList.size()!=0){
            return invoiceList.get(0);
        } else {
            return null;
        }
    }

    public List<AppletOrder> getOrderByInvoiceId(String applyId){
        AppletOrderExample example = new AppletOrderExample();
        AppletOrderExample.Criteria criteria = example.createCriteria();
        criteria.andInvoiceApplyIdEqualTo(applyId);
        List<AppletOrder> orderList = orderMapper.selectByExample(example);
        return orderList;
    }

    @Transactional
    public boolean uploadInvoice(String applyId,String url){

        logger.info(applyId+"工单上传发票地址"+url);

        if (StringUtils.isBlank(url)) {
            logger.info(applyId+"工单上传发票地址失败,地址图片为空");
            return false;
        }

        AppletOrderInvoiceExample example = new AppletOrderInvoiceExample();
        AppletOrderInvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(applyId))
            criteria.andApplyIdEqualTo(applyId);

        AppletOrderInvoice invoice = new AppletOrderInvoice();
        invoice.setUpdateDate(new Date());
        invoice.setDealStatus(CommonConstants.ENABLE);
        invoice.setInvoiceUrl(url);

        int i = invoiceMapper.updateByExampleSelective(invoice,example);
        if (i==0){
            logger.info(applyId+"工单上传发票地址失败");
            return false;
        }

        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        orderExampleCriteria.andInvoiceApplyIdEqualTo(applyId);
        orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        AppletOrder order = new AppletOrder();
        order.setUpdateDate(new Date());
        order.setInvoiceStatus(CommonConstants.ENABLE);
        i= orderMapper.updateByExampleSelective(order,orderExample);
        if (i==0){
            logger.info(applyId+"更新订单开票状态失败");
            return false;
        }
        return true;
    }

    @Transactional
    public boolean checkRestartInvoice(String applyId){

        logger.info(applyId+"工单重新确认发票"+applyId);

        if (StringUtils.isBlank(applyId)) {
            throw new RuntimeException("工单号为空");
        }

        AppletOrderInvoiceExample example = new AppletOrderInvoiceExample();
        AppletOrderInvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andDealStatusEqualTo(CommonConstants.INVALID);
        if (StringUtils.isNotBlank(applyId))
            criteria.andApplyIdEqualTo(applyId);

        AppletOrderInvoice invoice = new AppletOrderInvoice();
        invoice.setUpdateDate(new Date());
        invoice.setDealStatus(CommonConstants.ENABLE);

        int i = invoiceMapper.updateByExampleSelective(invoice,example);
        if (i==0){
            logger.info(applyId+"工单重新确认发票失败");
            return false;
        }

        return true;
    }
}
