package com.tclab.weixinappletservice.service.clientService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.InvoiceConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletservice.dao.AppletOrderInvoiceMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.model.query.QueryNoParam;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.InvoiceEditVo;
import com.tclab.weixinappletservice.model.vo.clientVo.invoiceForThirdVo.*;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import com.tclab.weixinappletservice.pojo.AppletOrderInvoice;
import com.tclab.weixinappletservice.pojo.AppletOrderInvoiceExample;
import com.tclab.weixinappletcommon.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class InvoiceService {

    private static final Logger logger = LoggerFactory.getLogger(InvoiceService.class);

    @Autowired
    private AppletOrderInvoiceMapper invoiceMapper;
    @Autowired
    private AppletOrderMapper orderMapper;

    @Transactional
    public List<AppletOrderInvoice> getInvoiceListByStatus(String userId,Integer invoiceStatus){

        logger.info("通过开票状态"+invoiceStatus+"查询"+userId+"的开票记录");

        AppletOrderInvoiceExample example = new AppletOrderInvoiceExample();
        AppletOrderInvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(userId))
            criteria.andUserIdEqualTo(userId);
        if (invoiceStatus!=null&&invoiceStatus.equals(CommonConstants.INIT))
            criteria.andDealStatusEqualTo(invoiceStatus);
        if (invoiceStatus!=null&&invoiceStatus.equals(CommonConstants.ENABLE)) {
            List<Integer> dealStatusList = new ArrayList<>();
            dealStatusList.add(CommonConstants.ENABLE);
            dealStatusList.add(CommonConstants.INVALID);
            criteria.andDealStatusIn(dealStatusList);
        }
        criteria.andInvoiceStatusEqualTo(CommonConstants.INIT);
        List<AppletOrderInvoice> result = invoiceMapper.selectByExample(example);

//        if (invoiceStatus.equals(CommonConstants.ENABLE)) {
//            updateInvoiceUrlByInvoiceList(result);
//        }

        logger.info("通过开票状态"+invoiceStatus+"查询"+userId+"的开票记录的结果长度是"+result.size());

        return result;
    }

    @Transactional
    public void updateInvoiceUrlByInvoiceList(List<AppletOrderInvoice> result){
        //查询第三方开票详细结果并将pdf转换成图片
        for (AppletOrderInvoice invoice:result) {
            if (StringUtils.isNotBlank(invoice.getThirdSequenceId())&&(StringUtils.isBlank(invoice.getInvoiceUrl())|| StringUtils.isBlank(invoice.getThirdSequenceRemark()))){

                AppletOrderInvoice updateInvoice = new AppletOrderInvoice();

                QueryInvoiceByFpqqlshResponseVo queryInvoiceByThirdVo = queryInvoiceByThird(invoice.getThirdSequenceId());

                logger.info("查询第三方开票详细结果"+queryInvoiceByThirdVo.getResult());
                logger.info("查询第三方开票详细结果"+queryInvoiceByThirdVo.getErrorMsg());

                if (queryInvoiceByThirdVo.getResult().equals("success")) {
                    logger.info("查询第三方开票pdf地址" + queryInvoiceByThirdVo.getList().get(0).getC_url());
                    logger.info("查询第三方开票发票代码" + queryInvoiceByThirdVo.getList().get(0).getC_fpdm());
                    logger.info("查询第三方开票发票号码" + queryInvoiceByThirdVo.getList().get(0).getC_fphm());
                    logger.info("查询第三方开票图片地址" + queryInvoiceByThirdVo.getList().get(0).getC_jpg_url());

                }
                if (queryInvoiceByThirdVo==null){
                    logger.info("查询第三方流水号"+invoice.getThirdSequenceId()+"结果未能正确显示");
                    throw new RuntimeException("查询第三方流水号"+invoice.getThirdSequenceId()+"结果未能正确显示");
                }

                if (StringUtils.isBlank(invoice.getInvoiceUrl())) {
                    if (queryInvoiceByThirdVo.getResult().equals("success")) {
                        List<InvoiceResponseInfoListVo> resultList = queryInvoiceByThirdVo.getList();
                        if (resultList.size() != 0) {
                            InvoiceResponseInfoListVo infoListVo = resultList.get(0);
                            String pdfUrl = infoListVo.getC_url();
                            if (StringUtils.isNotBlank(pdfUrl)) {
                                try {
//                                    String sign = NumberGeneratorUtils.generateDate();
                                    logger.info("开始pdf转图片");
//                                    List<String> imgList = PdfToImageUtils.pdf2ImgByIcePDF(imageResourcelocation + "/pdf/" + sign, pdfUrl, sign);
                                    List<String> imgList = PdfToImageUtils.pdf2ImgByUrl(invoice.getThirdSequenceId(), imageResourcelocation + "/pdf", "png", pdfUrl);
                                    logger.info("结束pdf转图片");
                                    if (imgList != null && imgList.size() != 0) {
                                        updateInvoice.setInvoiceUrl("/pdf/" + imgList.get(0));
                                    }
                                } catch (Exception e) {
                                    logger.info(e.getMessage());
                                    throw new RuntimeException("流水号" + invoice.getThirdSequenceId() + "转换PDF图片出错");
                                }
                            }
                                InvoiceRemarkVo thirdSequenceRemark = new InvoiceRemarkVo();
                                logger.info("发票代码"+infoListVo.getC_fpdm());
                                thirdSequenceRemark.setFpdm(infoListVo.getC_fpdm());
                                logger.info("发票号码"+infoListVo.getC_fphm());
                                thirdSequenceRemark.setFphm(infoListVo.getC_fphm());
                                String jsonStr = JSONObject.toJSONString(thirdSequenceRemark);
                                updateInvoice.setThirdSequenceRemark(jsonStr);
                        }
                    } else {
                        throw new RuntimeException("流水号" + invoice.getThirdSequenceId() + queryInvoiceByThirdVo.getErrorMsg());
                    }
                }
                updateInvoice.setUpdateDate(new Date());
                AppletOrderInvoiceExample invoiceExample = new AppletOrderInvoiceExample();
                AppletOrderInvoiceExample.Criteria invoiceExampleCriteria = invoiceExample.createCriteria();
                invoiceExampleCriteria.andThirdSequenceIdEqualTo(invoice.getThirdSequenceId());
                int i = invoiceMapper.updateByExampleSelective(updateInvoice,invoiceExample);
                if (i==0){
                    throw new RuntimeException("流水号" + invoice.getThirdSequenceId() +"插入PDF图片地址失败");
                }
            }
        }

    }

    @Transactional
    public String openInvoice(InvoiceEditVo req){
        if (req.getOrderNoList()==null||req.getOrderNoList().size()==0){
            throw new RuntimeException("开票订单数量为空,无法开票");
        }
        logger.info("订单开票: 订单号为"+req.getOrderNoList());
        AppletOrderInvoice invoice = new AppletOrderInvoice();
        BeanUtils.copyProperties(req,invoice);
        invoice.setApplyDate(new Date());
        String applyId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_INVOICE);
        invoice.setApplyId(applyId);
        invoice.setCreateDate(new Date());
        invoice.setDealStatus(CommonConstants.ENABLE);
        invoice.setDelFlag(CommonConstants.INIT);
        invoice.setUpdateDate(new Date());
        invoice.setInvoiceStatus(CommonConstants.INIT);
        invoice.setOrderNum(req.getOrderNoList().size());

        QueryNoParam param = new QueryNoParam();
        param.setOrderNoList(req.getOrderNoList());
        BigDecimal sumPayAmount = orderMapper.getSumPayAmount(param);
        BigDecimal sumRefundAmount = orderMapper.getSumRefundAmount(param);

        if (sumPayAmount==null){
            sumPayAmount = BigDecimal.ZERO;
        }
        if (sumRefundAmount==null){
            sumRefundAmount = BigDecimal.ZERO;
        }

        BigDecimal invoiceAmount = sumPayAmount.subtract(sumRefundAmount);
        if (invoiceAmount.equals(BigDecimal.ZERO)){
            throw new RuntimeException("开票金额不满足要求");
        }
        invoice.setInvoiceAmount(invoiceAmount);

        //第三方开票
        String fpqqlsh = openInvoiceByThird(invoice);
        if (StringUtils.isNotBlank(fpqqlsh)){
            invoice.setThirdSequenceId(fpqqlsh);
        } else {
            logger.info("开票工单"+applyId+"第三方开票失败,开票工单为空");
            throw new RuntimeException("开票工单"+applyId+"第三方开票失败,开票工单为空");
        }

        int i = invoiceMapper.insertSelective(invoice);
        if (i==0){
            logger.info(applyId+"开票工单插入订单开票记录失败");
            throw new RuntimeException(applyId+"工单开票记录失败");
        }
        logger.info(applyId+"开票工单生成成功");

        //更新开票记录为已开票
//        AppletOrderInvoiceExample invoiceExample = new AppletOrderInvoiceExample();
//        AppletOrderInvoiceExample.Criteria invoiceExampleCriteria = invoiceExample.createCriteria();
//        if (StringUtils.isNotBlank(applyId))
//            invoiceExampleCriteria.andApplyIdEqualTo(req.getApplyId());
//        invoiceExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
//        invoiceExampleCriteria.andDealStatusEqualTo(CommonConstants.INIT);
//        invoiceExampleCriteria.andInvoiceStatusEqualTo(CommonConstants.INIT);
//
//        AppletOrderInvoice updateInvoice = new AppletOrderInvoice();
//        updateInvoice.setUpdateDate(new Date());
//        updateInvoice.setDealStatus(CommonConstants.ENABLE);
//        updateInvoice.setThirdSequenceId(fpqqlsh);

//        //查询第三方开票详细结果并将pdf转换成图片
//        QueryInvoiceByFpqqlshResponseVo queryInvoiceByThirdVo = queryInvoiceByThird(fpqqlsh);
//
//        logger.info("查询第三方开票详细结果"+queryInvoiceByThirdVo.getList().get(0).getC_url());
//        logger.info("查询第三方开票详细结果"+queryInvoiceByThirdVo.getList().get(0).getC_fpdm());
//        logger.info("查询第三方开票详细结果"+queryInvoiceByThirdVo.getList().get(0).getC_fphm());
//        logger.info("查询第三方开票详细结果"+queryInvoiceByThirdVo.getList().get(0).getC_jpg_url());
//
//        if (queryInvoiceByThirdVo==null){
//            logger.info("查询第三方流水号"+fpqqlsh+"结果未能正确显示");
//            throw new RuntimeException("查询第三方流水号"+fpqqlsh+"结果未能正确显示");
//        }
//
//        if (queryInvoiceByThirdVo.getResult().equals("success")) {
//            List<InvoiceResponseInfoListVo> resultList = queryInvoiceByThirdVo.getList();
//            if (resultList.size() != 0) {
//                InvoiceResponseInfoListVo infoListVo = resultList.get(0);
//                String pdfUrl = infoListVo.getC_url();
//                if (StringUtils.isNotBlank(pdfUrl)) {
//                    try {
////                    List<String> imgList = PdfToImageUtils.pdf2ImgByUrl(fpqqlsh, imageResourcelocation + "/pdf", "png", pdfUrl);
//                        String sign = NumberGeneratorUtils.generateDate();
//                        List<String> imgList = PdfToImageUtils.pdf2ImgByIcePDF(imageResourcelocation + "/pdf/" + sign, pdfUrl, sign);
//                        if (imgList!=null&&imgList.size()!=0){
//                            updateInvoice.setInvoiceUrl(imgList.get(0));
//                        }
//                    } catch (Exception e) {
//                        logger.info(e.getMessage());
//                        throw new RuntimeException("流水号" + fpqqlsh + "转换PDF图片出错");
//                    }
//                }
//                InvoiceRemarkVo thirdSequenceRemark = new InvoiceRemarkVo();
//                thirdSequenceRemark.setFpdm(infoListVo.getC_fpdm());
//                thirdSequenceRemark.setFphm(infoListVo.getC_fphm());
//                String jsonStr = JSONObject.toJSONString(thirdSequenceRemark);
//                updateInvoice.setThirdSequenceRemark(jsonStr);
//            }
//        } else {
//            throw new RuntimeException("流水号" + fpqqlsh +queryInvoiceByThirdVo.getErrorMsg());
//        }

//        i = invoiceMapper.updateByExampleSelective(updateInvoice,invoiceExample);
//        if (i==0){
//            logger.info(req.getApplyId()+"开票工单更新已开票状态失败");
//            throw new RuntimeException(req.getApplyId()+"开票工单更新已开票状态失败");
//        }

        //更新订单开票记录已开票
        AppletOrderExample example = new AppletOrderExample();
        AppletOrderExample.Criteria criteria = example.createCriteria();
        //订单可以是已开票状态重新开票
//        criteria.andInvoiceStatusEqualTo(CommonConstants.INIT);
        criteria.andDelFlagEqualTo(CommonConstants.INIT);

        List<Integer> orderStatusList = new ArrayList<>();
        orderStatusList.add(OrderConstants.ORDER_STATUS_COLLECTED);
        orderStatusList.add(OrderConstants.ORDER_STATUS_COMPLETED);
        criteria.andOrderStatusIn(orderStatusList);

        List<Integer> refundStatusList = new ArrayList<>();
        refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
        refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
        criteria.andRefundStatusIn(refundStatusList);
        criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
        criteria.andOrderNoIn(req.getOrderNoList());

        AppletOrder order = new AppletOrder();
        order.setInvoiceApplyId(applyId);
        //设置第三方开票系统已开
        order.setInvoiceStatus(CommonConstants.ENABLE);
        i = orderMapper.updateByExampleSelective(order,example);
        if (i==0){
            logger.info("更新订单状态开票失败");
            throw new RuntimeException("更新订单状态开票失败");
        }
        return applyId;
    }

    @Transactional
    public boolean restartInvoice(String invoiceApplyId,String receivePhone,String emailAddress){

        logger.info("重新开票: "+invoiceApplyId);

        //查询原先工单记录
        AppletOrderInvoice originalInvoice = getInvoiceByApplyId(invoiceApplyId);
        if (originalInvoice==null){
            logger.info("原开票工单号"+invoiceApplyId+"不存在");
            throw new RuntimeException("原开票工单号"+invoiceApplyId+"不存在");
        }

        if (originalInvoice.getInvoiceStatus().equals(CommonConstants.ENABLE)){
            logger.info("原开票工单号"+invoiceApplyId+"已作废");
            throw new RuntimeException("原开票工单号"+invoiceApplyId+"已作废");
        }

        //调用第三方发票废弃接口
        String thirdRemark = originalInvoice.getThirdSequenceRemark();
        InvoiceRemarkVo invoiceRemarkVo = null;
        try {
            invoiceRemarkVo = JSON.parseObject(thirdRemark,InvoiceRemarkVo.class);
            logger.info(invoiceRemarkVo.toString());
        } catch (Exception e){
            logger.info("解析开票工单号"+invoiceApplyId+"的发票号码发票代码失败");
            logger.info(e.getMessage());
            throw new RuntimeException("解析开票工单号"+invoiceApplyId+"的发票号码发票代码失败");
        }

        OpenInvoiceResponseVo invalidInvoiceResponseVo = invalidInvoiceByThird(originalInvoice.getThirdSequenceId(),invoiceRemarkVo.getFpdm(),invoiceRemarkVo.getFphm());
        if (invalidInvoiceResponseVo==null){
            logger.info("流水号"+originalInvoice.getThirdSequenceId()+"第三方发票作废返回信息为空");
            throw new RuntimeException("流水号"+originalInvoice.getThirdSequenceId()+"第三方发票作废返回信息为空");
        }

        //正确执行结果
        if (invalidInvoiceResponseVo.getStatus().equals("0000")){
            //设置开票状态为重新开票中
            AppletOrderInvoiceExample invoiceExample = new AppletOrderInvoiceExample();
            AppletOrderInvoiceExample.Criteria invoiceExampleCriteria = invoiceExample.createCriteria();
            if (StringUtils.isNotBlank(invoiceApplyId))
                invoiceExampleCriteria.andApplyIdEqualTo(invoiceApplyId);
            invoiceExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            invoiceExampleCriteria.andDealStatusEqualTo(CommonConstants.ENABLE);

            AppletOrderInvoice invoice = new AppletOrderInvoice();
            invoice.setUpdateDate(new Date());
            invoice.setDealStatus(CommonConstants.INVALID);
            invoice.setInvoiceStatus(CommonConstants.ENABLE);
            invoice.setReceivePhone(receivePhone);
            invoice.setEmailAddress(emailAddress);

            invoiceRemarkVo.setOriginalFpqqlsh(invalidInvoiceResponseVo.getFpqqlsh());
            String jsonStr = JSONObject.toJSONString(invoiceRemarkVo);
            invoice.setThirdSequenceRemark(jsonStr);

            int i = invoiceMapper.updateByExampleSelective(invoice,invoiceExample);
            if (i==0){
                logger.info("重新开票失败: "+invoiceApplyId+"失败原因: 更新失败");
                throw new RuntimeException("重新开票失败: "+invoiceApplyId+"失败原因: 更新失败");
            }
        } else {
            logger.info("重新开票失败: "+invoiceApplyId+"失败原因: "+invalidInvoiceResponseVo.getMessage());
            throw new RuntimeException("重新开票失败: "+invoiceApplyId+"失败原因: "+invalidInvoiceResponseVo.getMessage());
        }

        //新增开票记录
        String applyIdNew = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_INVOICE);
        originalInvoice.setInvoiceUrl("");
        originalInvoice.setId(null);
        originalInvoice.setApplyId(applyIdNew);
        originalInvoice.setInvoiceStatus(CommonConstants.INIT);
        originalInvoice.setDelFlag(CommonConstants.INIT);
        originalInvoice.setDealStatus(CommonConstants.INIT);
        originalInvoice.setReceivePhone(receivePhone);
        originalInvoice.setEmailAddress(emailAddress);
        originalInvoice.setThirdSequenceRemark("");
        originalInvoice.setCreateDate(new Date());
        originalInvoice.setUpdateDate(new Date());
        originalInvoice.setApplyDate(new Date());
        int i = invoiceMapper.insertSelective(originalInvoice);

        if (i==0){
            logger.info("重新开票"+applyIdNew+"开票工单插入订单开票记录失败");
            throw new RuntimeException("重新开票"+applyIdNew+"工单开票记录失败");
        }
        logger.info("重新开票"+applyIdNew+"开票工单生成成功");

        //第三方开票
        String fpqqlshNew = openInvoiceByThird(originalInvoice);

        //更新开票记录为已开票
        AppletOrderInvoiceExample updateInvoiceExample = new AppletOrderInvoiceExample();
        AppletOrderInvoiceExample.Criteria updateInvoiceExampleCriteria = updateInvoiceExample.createCriteria();
        updateInvoiceExampleCriteria.andApplyIdEqualTo(applyIdNew);
        updateInvoiceExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        updateInvoiceExampleCriteria.andDealStatusEqualTo(CommonConstants.INIT);
        updateInvoiceExampleCriteria.andInvoiceStatusEqualTo(CommonConstants.INIT);

        AppletOrderInvoice updateInvoice = new AppletOrderInvoice();
        updateInvoice.setUpdateDate(new Date());
        updateInvoice.setDealStatus(CommonConstants.ENABLE);
        updateInvoice.setThirdSequenceId(fpqqlshNew);

        //查询第三方开票详细结果并将pdf转换成图片
        QueryInvoiceByFpqqlshResponseVo queryInvoiceByThirdVoNew = queryInvoiceByThird(fpqqlshNew);
        if (queryInvoiceByThirdVoNew==null){
            logger.info("查询第三方流水号"+fpqqlshNew+"结果未能正确显示");
            throw new RuntimeException("查询第三方流水号"+fpqqlshNew+"结果未能正确显示");
        }

//        if (queryInvoiceByThirdVoNew.getResult().equals("success")) {
//            List<InvoiceResponseInfoListVo> resultList = queryInvoiceByThirdVoNew.getList();
//            if (resultList.size() != 0) {
//                InvoiceResponseInfoListVo infoListVo = resultList.get(0);
//                String pdfUrl = infoListVo.getC_url();
//                if (StringUtils.isNotBlank(pdfUrl)) {
//                    try {
////                    List<String> imgList = PdfToImageUtils.pdf2ImgByUrl(fpqqlsh, imageResourcelocation + "/pdf", "png", pdfUrl);
//                        String sign = NumberGeneratorUtils.generateDate();
//                        List<String> imgList = PdfToImageUtils.pdf2ImgByIcePDF(imageResourcelocation + "/pdf/" + sign, pdfUrl, sign);
//                        if (imgList!=null&&imgList.size()!=0){
//                            updateInvoice.setInvoiceUrl(imgList.get(0));
//                        }
//                    } catch (Exception e) {
//                        logger.info(e.getMessage());
//                        throw new RuntimeException("流水号" + fpqqlshNew + "转换PDF图片出错");
//                    }
//                }
//                InvoiceRemarkVo thirdSequenceRemark = new InvoiceRemarkVo();
//                thirdSequenceRemark.setFpdm(infoListVo.getC_fpdm());
//                thirdSequenceRemark.setFphm(infoListVo.getC_fphm());
//                String jsonStr = JSONObject.toJSONString(thirdSequenceRemark);
//                updateInvoice.setThirdSequenceRemark(jsonStr);
//            }
//        } else {
//            throw new RuntimeException("流水号" + fpqqlshNew +queryInvoiceByThirdVoNew.getErrorMsg());
//        }

        i = invoiceMapper.updateByExampleSelective(updateInvoice,updateInvoiceExample);
        if (i==0){
            logger.info(applyIdNew+"开票工单更新已开票状态失败");
            throw new RuntimeException(applyIdNew+"开票工单更新已开票状态失败");
        }

        //更新订单新工单号
        AppletOrderExample example = new AppletOrderExample();
        AppletOrderExample.Criteria criteria = example.createCriteria();
        //订单可以是已开票状态重新开票
//        criteria.andInvoiceStatusEqualTo(CommonConstants.INIT);
        criteria.andDelFlagEqualTo(CommonConstants.INIT);

        List<Integer> orderStatusList = new ArrayList<>();
        orderStatusList.add(OrderConstants.ORDER_STATUS_COLLECTED);
        orderStatusList.add(OrderConstants.ORDER_STATUS_COMPLETED);
        criteria.andOrderStatusIn(orderStatusList);

        List<Integer> refundStatusList = new ArrayList<>();
        refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
        refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
        criteria.andRefundStatusIn(refundStatusList);
        criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
        criteria.andInvoiceApplyIdEqualTo(invoiceApplyId);

        AppletOrder order = new AppletOrder();
        order.setInvoiceApplyId(applyIdNew);
        //设置第三方开票系统已开
        order.setInvoiceStatus(CommonConstants.ENABLE);
        i = orderMapper.updateByExampleSelective(order,example);
        if (i==0){
            logger.info("新工单号"+applyIdNew+"更新订单开票工单号失败");
            throw new RuntimeException("新工单号"+applyIdNew+"更新订单开票工单号失败");
        }

        return true;
    }

    public AppletOrderInvoice getInvoiceByApplyId(String applyId){
        AppletOrderInvoiceExample example = new AppletOrderInvoiceExample();
        AppletOrderInvoiceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(applyId))
            criteria.andApplyIdEqualTo(applyId);
        List<AppletOrderInvoice> invoiceList = invoiceMapper.selectByExample(example);
        if (invoiceList.size()!=0){
            AppletOrderInvoice invoice = invoiceList.get(0);
            if (invoice.getDealStatus().equals(CommonConstants.ENABLE)){
                List<AppletOrderInvoice> result = new ArrayList<>();
                result.add(invoice);
                updateInvoiceUrlByInvoiceList(result);
            }
            return invoice;
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

    public BigDecimal getPayAmount(List<String> orderNoList){
        QueryNoParam param = new QueryNoParam();
        param.setOrderNoList(orderNoList);
        return orderMapper.getSumPayAmount(param);

    }
    public BigDecimal getRefundAmount(List<String> orderNoList){
        QueryNoParam param = new QueryNoParam();
        param.setOrderNoList(orderNoList);
        return orderMapper.getSumRefundAmount(param);
    }

    @Value("${invoice.identity}")
    private String invoiceIdentity;
    @Value("${invoice.saletaxnum}")
    private String saletaxnum;
    @Value("${invoice.open.url}")
    private String openInvoiceUrl;
    @Value("${invoice.query.url}")
    private String queryInvoiceUrl;
    @Value("${invoice.invalid.url}")
    private String invalidInvoiceUrl;
    @Value("${image.resource.location}")
    private String imageResourcelocation;


    @Transactional
    protected String openInvoiceByThird(AppletOrderInvoice req){

        OpenInvoiceRequestVo vo = new OpenInvoiceRequestVo();
        vo.setIdentity(invoiceIdentity);

        InvoiceBaseVo order = new InvoiceBaseVo();

        //购方信息
        order.setBuyername(req.getTitleName());
        order.setPhone(req.getReceivePhone());
        order.setOrderno(req.getApplyId());

        try {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String convertDate = simpleDateFormat.format(date);
            order.setInvoicedate(convertDate);
        }catch (Exception e){
            logger.info(req.getApplyId()+"开票工单日期转换出错");
            throw new RuntimeException("日期转换出错");
        }

        if (req.getTitleType().equals(InvoiceConstants.INVOICE_TITLE_TYPE_ENTERPRISE)){
            order.setAddress(req.getCompanyAddress());
            order.setTaxnum(req.getTaxpayerId());
            order.setAccount(req.getAccountId());
            order.setTelephone(req.getCompanyPhone());

        }

        //销方信息
        order.setClerk("林青");
        order.setSaleaccount("3301040160006471802");
        order.setSalephone("0571-81029365");
        order.setSaleaddress("杭州市下城区华中南路672号3幢501室");
//		order.setSaletaxnum("91330103MA28LMXC0C");
		order.setSaletaxnum(saletaxnum);
        order.setKptype("1");
        order.setPayee("刘伟瑛");
        order.setChecker("胡焕青");

        //推送方式
        if (EmailUtils.isEmail(req.getEmailAddress())) {
            order.setEmail(req.getEmailAddress());
            order.setTsfs("2");
        } else {
            order.setTsfs("1");
        }

        //内容部分
        List<InvoiceItemVo> detail = new ArrayList<>();
        InvoiceItemVo itemVo = new InvoiceItemVo();
        itemVo.setGoodsname("检验服务费");
        itemVo.setHsbz("1");
        itemVo.setTaxrate("0.06");
        itemVo.setFphxz("0");

        BigDecimal amount = req.getInvoiceAmount();
        logger.info(req.getApplyId()+"开票工单的含税金额是"+amount);
        itemVo.setTaxamt(amount.toString());

        BigDecimal rate1 = new BigDecimal("0.06");
        BigDecimal rate2 = new BigDecimal("1.06");
        BigDecimal multiply = amount.multiply(rate1);
        BigDecimal divide = multiply.divide(rate2,2,BigDecimal.ROUND_HALF_UP);
        BigDecimal tax = divide.setScale(2,BigDecimal.ROUND_HALF_UP);
        logger.info(req.getApplyId()+"开票工单的税额是"+tax);
        itemVo.setTax(tax.toString());

        BigDecimal last = amount.subtract(tax);
        logger.info(req.getApplyId()+"开票工单的不含税金额是"+last);
        itemVo.setTaxfreeamt(last.toString());

        detail.add(itemVo);
        order.setDetail(detail);
        vo.setOrder(order);

        String jsonStr = JSONObject.toJSONString(vo);
        logger.info(req.getApplyId()+"开票工单请求第三方参数order转换JSON字符串"+jsonStr);

        String orderStr = InvoiceUtils.encrypt(jsonStr);
        Map<String,String> map = new HashMap<>();
        map.put("order",orderStr);

        String responStr = HttpClientUtil.doPost(openInvoiceUrl,map);
        logger.info(req.getApplyId()+"开票工单请求第三方开票结果"+responStr);

        OpenInvoiceResponseVo openInvoiceResponseVo = null;
        try {
            openInvoiceResponseVo = JSON.parseObject(responStr,OpenInvoiceResponseVo.class);
        } catch (Exception e){
            logger.info("开票第三方返回信息出错");
            logger.info(e.getMessage());
            return null;
        }

        if (openInvoiceResponseVo.getStatus()==null||(!openInvoiceResponseVo.getStatus().equals("0000"))){
            throw new RuntimeException(req.getApplyId()+"开票工单请求第三方开票返回结果出错;错误编码"+openInvoiceResponseVo.getStatus());
        }

        return openInvoiceResponseVo.getFpqqlsh();
    }



    protected QueryInvoiceByFpqqlshResponseVo queryInvoiceByThird(String fpqqlsh){

        QueryInvoiceByFpqqlshRequestVo vo = new QueryInvoiceByFpqqlshRequestVo();
        vo.setIdentity(invoiceIdentity);
        List<String> list = new ArrayList<>();
        list.add(fpqqlsh);
        vo.setFpqqlsh(list);

        String jsonStr = JSONObject.toJSONString(vo);

        String SendUrl=queryInvoiceUrl;
        String orderStr =InvoiceUtils.encrypt(jsonStr);
        Map<String,String> map = new HashMap<>();
        map.put("order",orderStr);

        String responStr = HttpClientUtil.doPost(SendUrl,map);

        QueryInvoiceByFpqqlshResponseVo queryInvoiceByFpqqlshResponseVo = null;
        try {
            queryInvoiceByFpqqlshResponseVo = JSON.parseObject(responStr,QueryInvoiceByFpqqlshResponseVo.class);
            logger.info("流水号"+fpqqlsh+"查询第三方开票详情返回信息"+queryInvoiceByFpqqlshResponseVo.toString());
        } catch (Exception e){
            logger.info("流水号"+fpqqlsh+"查询第三方开票详情返回信息出错");
            logger.info(e.getMessage());
            throw new RuntimeException("流水号"+fpqqlsh+"查询第三方开票详情返回信息出错");
        }

        return queryInvoiceByFpqqlshResponseVo;
    }


    protected OpenInvoiceResponseVo invalidInvoiceByThird(String fpqqlsh,String fpdm,String fphm){

        InvalidInvoiceRequestVo vo = new InvalidInvoiceRequestVo();
        vo.setIdentity(invoiceIdentity);
        InvalidInvoiceInfoVo invoiceInfoVo = new InvalidInvoiceInfoVo();
        invoiceInfoVo.setFpqqlsh(fpqqlsh);
        invoiceInfoVo.setFpdm(fpdm);
        invoiceInfoVo.setFphm(fphm);
        vo.setOrder(invoiceInfoVo);

        String jsonStr = JSONObject.toJSONString(vo);
        logger.info("流水号"+fpqqlsh+"废弃发票加密JSON字符串"+jsonStr);

        String SendUrl=invalidInvoiceUrl;
        String orderStr =InvoiceUtils.encrypt(jsonStr);
        Map<String,String> map = new HashMap<>();
        map.put("order",orderStr);

        String responStr = HttpClientUtil.doPost(SendUrl,map);

        OpenInvoiceResponseVo invalidInvoiceResponseVo = null;
        try {
            invalidInvoiceResponseVo = JSON.parseObject(responStr,OpenInvoiceResponseVo.class);
            logger.info(invalidInvoiceResponseVo.toString());
        } catch (Exception e){
            logger.info("流水号"+fpqqlsh+"第三方发票作废返回信息出错");
            logger.info(e.getMessage());
            throw new RuntimeException("流水号"+fpqqlsh+"第三方发票作废返回信息出错");
        }

        return invalidInvoiceResponseVo;
    }
}
