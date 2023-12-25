package com.tclab.weixinappletservice.service.adminService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tclab.weixinappletcommon.constant.*;
import com.tclab.weixinappletcommon.utils.CommonHttpClientUtils;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.IDCardUtils;
import com.tclab.weixinappletservice.dao.AppletGoodMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.GoodBaseVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.SelfBarcodeVo;
import com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo.ThirdResponseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo.ThirdSampleInfoVo;
import com.tclab.weixinappletservice.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminGoodService {

    private static final Logger logger = LoggerFactory.getLogger(AdminGoodService.class);

    @Autowired
    private AppletGoodMapper goodMapper;
    @Autowired
    private AppletOrderMapper orderMapper;
    @Autowired
    private AdminPackageService adminPackageService;
    @Autowired
    private AdminParticipantService adminParticipantService;
    @Autowired
    private AdminStaffService adminStaffService;
    @Autowired
    private AdminGoodService adminGoodService;

    /**
     * 根据goodNo获取good
     * @param goodNo
     * @return
     */
    public AppletGood getByNo(String goodNo){
        if (StringUtils.isBlank(goodNo)){
            return null;
        }
        AppletGoodExample example = new AppletGoodExample();
        AppletGoodExample.Criteria criteria = example.createCriteria();
        criteria.andGoodNoEqualTo(goodNo);
        List<AppletGood> goods = goodMapper.selectByExample(example);
        if (goods.size()!=0){
            return goods.get(0);
        }
        return null;
    }

    /**
     * 根据orderNo和商品状态获取订单下不同状态的套餐数量
     * @param orderNo
     * @param goodStatus
     * @return
     */
    public long getGoodCountByOrderNoAndGoodStatus(String orderNo,Integer goodStatus){
        AppletGoodExample goodExample = new AppletGoodExample();
        AppletGoodExample.Criteria criteria = goodExample.createCriteria();
        if (StringUtils.isNotBlank(orderNo))
        criteria.andOrderNoEqualTo(orderNo);
        if (goodStatus!=null)
        criteria.andGoodStatusEqualTo(goodStatus);
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        long result = goodMapper.countByExample(goodExample);
        return result;
    }

    /**
     * 获取订单下所有商品
     * @param orderNo
     * @return
     */
    public List<GoodBaseVo> getGoodsByOrderNo(String orderNo){

        if (StringUtils.isBlank(orderNo)){
            return null;
        }

        AppletGoodExample example = new AppletGoodExample();
        AppletGoodExample.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotBlank(orderNo))
        criteria.andOrderNoEqualTo(orderNo);
        List<GoodBaseVo> goodBaseVoList = new ArrayList<>();
        List<AppletGood> goods = goodMapper.selectByExample(example);
        for (AppletGood good:goods) {
            GoodBaseVo goodBaseVo = new GoodBaseVo();
            BeanUtils.copyProperties(good,goodBaseVo);
            if (good.getReportCost()==null){
                goodBaseVo.setReportCost(BigDecimal.ZERO);
            }
            goodBaseVo.setGoodAmount(good.getPayAmount().subtract(goodBaseVo.getReportCost()));
            goodBaseVoList.add(goodBaseVo);
        }
        return goodBaseVoList;
    }

    /**
     * 单商品退款(统计金额按照订单金额计算)
     * @param orderNo
     * @param goodNo
     * @return
     */
    @Transactional
    public boolean backRefundGood(String orderNo, String goodNo, BigDecimal refundAmount,Integer refundReason){

        int i =0;

//        try {
            if (StringUtils.isBlank(orderNo)) {
                throw new IllegalArgumentException("退款订单订单号不能为空");
            }

            //单套餐退款
            logger.info("后台单套餐退款: orderNo: " + orderNo + " goodNo: " + goodNo);

            //查询订单是否可以退款
            AppletOrder order;
            AppletOrderExample orderExample = new AppletOrderExample();
            AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
            orderExampleCriteria.andOrderNoEqualTo(orderNo);
            //支付状态必须是已支付的订单
            orderExampleCriteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
            List<Integer> refundStatusList = new ArrayList<>();
            //退款订单订单必须是未退款或者部分退款的
            refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
            refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
            orderExampleCriteria.andRefundStatusIn(refundStatusList);
            //退款订单的其他条件不做限制由运维自由控制
            List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
            if (orderList != null && orderList.size() != 0) {
                order = orderList.get(0);
            } else {
                throw new RuntimeException("订单不满足退款条件: orderNo: " + orderNo);
            }

            //设置套餐已退款
            AppletGoodExample goodExample = new AppletGoodExample();
            AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
            goodExampleCriteria.andGoodNoEqualTo(goodNo);
            AppletGood updateGood = new AppletGood();
            updateGood.setGoodStatus(GoodConstants.GOOD_STATUS_REFUND);
            updateGood.setUpdateDate(new Date());
            updateGood.setRefundStatus(GoodConstants.GOOD_REFUND_STATUS_PAYED);
            if (refundReason!=null)
                updateGood.setRefundReason(refundReason);
            i = goodMapper.updateByExampleSelective(updateGood, goodExample);

            if (i==0){
                throw new RuntimeException("更新套餐退款失败: goodNo: "+goodNo);
            }

            //更新订单退款
            orderExample.clear();
            orderExampleCriteria = orderExample.createCriteria();

            //判断退款金额是否满足实际可以退的金额
            BigDecimal lastRefundAmount;
            BigDecimal allRefundAmount;
            if (order.getRefundAmount() != null) {
                allRefundAmount = order.getRefundAmount().add(refundAmount);
                lastRefundAmount = order.getPayAmount().subtract(order.getRefundAmount()).subtract(refundAmount);
            } else {
                allRefundAmount = refundAmount;
                lastRefundAmount = order.getPayAmount().subtract(refundAmount);
            }
            int check = lastRefundAmount.compareTo(BigDecimal.ZERO);
            if (check < 0) {
                throw new RuntimeException("订单退款金额超过实际可退款的金额: orderNo: " + orderNo);
            } else {

                //设置订单退款金额
                AppletOrder updateOrder = new AppletOrder();
                updateOrder.setRefundAmount(allRefundAmount);

                //设置订单退款状态
                goodExample.clear();
                goodExampleCriteria = goodExample.createCriteria();
                goodExampleCriteria.andOrderNoEqualTo(orderNo);
                //查询订单下是否有除了退款套餐以外的套餐
                goodExampleCriteria.andGoodStatusNotEqualTo(GoodConstants.GOOD_STATUS_UNCOLLECT);
                goodExampleCriteria.andExceptionStatusEqualTo(GoodConstants.GOOD_EXCEPTION_STATUS_INIT);
                goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
                long result = goodMapper.countByExample(goodExample);
                if (result != 0) {
                    //如果还存在正常未采集的套餐则退款状态显示部分退款
                    updateOrder.setRefundStatus(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
                    if (refundReason!=null)
                        updateOrder.setRefundReason(refundReason);
                } else {
                    //如果不存在正常未采集的套餐
                    updateOrder.setRefundStatus(OrderConstants.ORDER_REFUND_STATUS_PAYED);
                    updateOrder.setOrderStatus(OrderConstants.ORDER_STATUS_COMPLETED);
                    if (refundReason!=null)
                        updateOrder.setRefundReason(refundReason);
                }

                orderExampleCriteria.andOrderNoEqualTo(orderNo);
                updateOrder.setUpdateDate(new Date());
                orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

                i=orderMapper.updateByExampleSelective(updateOrder, orderExample);
                if (i==0){
                    throw new RuntimeException("后台更新订单退款状态失败: orderNo: "+orderNo);
                }
            }

            return true;
//        } catch (Exception e){
//            //手动回滚
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//            return false;
//        }
    }

    /**
     * 修改商品退款状态(统计金额按照订单金额计算)
     * @param orderNo
     * @return
     */
    @Transactional
    public void updateRefundGoodByOrderNo(String orderNo){
        AppletGoodExample goodExample = new AppletGoodExample();
        AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
        //未删除的套餐
        goodExampleCriteria.andOrderNoEqualTo(orderNo);
        goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        //修改套餐状态
        AppletGood updateGood = new AppletGood();
        updateGood.setGoodStatus(GoodConstants.GOOD_STATUS_REFUND);
        updateGood.setRefundStatus(GoodConstants.GOOD_REFUND_STATUS_PAYED);
        updateGood.setUpdateDate(new Date());
        int updateNum = goodMapper.updateByExampleSelective(updateGood,goodExample);
        if (updateNum==0){
            throw new RuntimeException("后台商品退款更新失败");
        }
    }

    /**
     * 更新商品已收货状态
     * @param orderNo
     * @return
     */
    @Transactional
    public boolean updateGoodReceiveStatus(String orderNo){

        if (StringUtils.isBlank(orderNo)){
            throw new RuntimeException("更新商品已收货状态失败: 订单号为空");
        }

        AppletGoodExample goodExample = new AppletGoodExample();
        AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
        goodExampleCriteria.andOrderNoEqualTo(orderNo);
        goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

        AppletGood updateGood = new AppletGood();
        updateGood.setGoodStatus(GoodConstants.GOOD_STATUS_TESTING);
        updateGood.setUpdateDate(new Date());
        int i = goodMapper.updateByExampleSelective(updateGood,goodExample);
        if (i==0){
            throw new RuntimeException("更新商品已收货状态失败: orderNo: "+orderNo);
        }
        return true;
    }

    public Long getGoodCountForOrder(String orderNo){
        if (StringUtils.isBlank(orderNo)){
            return null;
        }
        AppletGoodExample goodExample = new AppletGoodExample();
        AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
        goodExampleCriteria.andOrderNoEqualTo(orderNo);
        return goodMapper.countByExample(goodExample);
    }

    @Transactional
    public boolean bindSelfBarcode(String orderNo, List<SelfBarcodeVo> barcodeVoList, String collectorStaffId) {
        //查询订单是否可以绑定
        AppletOrderExample orderExample = new AppletOrderExample();
        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
        orderExampleCriteria.andOrderNoEqualTo(orderNo);
        //绑定条码的条件1:订单未删除
        orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        //绑定条码的条件3:订单服务方式自采
        orderExampleCriteria.andServiceTypeEqualTo(OrderConstants.ORDER_SERVICE_TYPE_SELF);
        //绑定条码的条件4:订单未异常
        orderExampleCriteria.andOrderExceptionStatusEqualTo(CommonConstants.INIT);
        //绑定条码的条件7:订单未取消
        orderExampleCriteria.andOrderCancelStatusEqualTo(CommonConstants.INIT);
        //绑定条码的条件10:订单已付款
        orderExampleCriteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
        //绑定条码的条件8:订单未退款
        orderExampleCriteria.andRefundStatusEqualTo(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
        //绑定条码的条件9:订单未发货
        orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.ACQUISITION_LOGISTICS_STATUS_UNSEND);

        List<AppletOrder> orders = orderMapper.selectByExample(orderExample);
        if (orders.size() != 0) {
            logger.info("后台绑定条码: " + "orderNo: " + orderNo + "可以被绑定");
        } else {
            logger.info("后台绑定条码: " + "orderNo: " + orderNo + "可以被绑定");
            throw new RuntimeException("自采订单不满足绑定条码的条件");
        }

        //绑定条码

        AppletGoodExample goodExample = new AppletGoodExample();
        AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();

        AppletGood good = new AppletGood();

        //绑定商品条码
        for (SelfBarcodeVo barcodeVo:barcodeVoList) {
            goodExampleCriteria.andOrderNoEqualTo(orderNo);
            goodExampleCriteria.andGoodNoEqualTo(barcodeVo.getGoodNo());
            goodExampleCriteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_UNCOLLECT);
            goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

            good.setSampleNo(barcodeVo.getBarcode());
            good.setCollectorStaffId(collectorStaffId);

            good.setUpdateDate(new Date());

            int i = goodMapper.updateByExampleSelective(good,goodExample);
            if (i==0){
                logger.info("自采用户绑定条码失败: "+"orderNo: "+orderNo+" goodNo: "+barcodeVo.getGoodNo()+" 条码号: "+barcodeVo.getBarcode());
                throw new RuntimeException("自采用户绑定条码失败: "+"orderNo: "+orderNo+" goodNo: "+barcodeVo.getGoodNo()+" 条码号: "+barcodeVo.getBarcode());
            }

            //重置查询条件
            goodExample.clear();
            goodExampleCriteria = goodExample.createCriteria();

            AppletGood queryGood = adminGoodService.getByNo(barcodeVo.getGoodNo());
            notifySaveMobileSampleInfoToThird(queryGood,barcodeVo.getBarcode());
        }

        return true;
    }

    @Value("${third.saveMobileSampleInfoToThird.url}")
    private String saveMobileSampleInfoToThirdUrl;
    @Value("${third.revokeMobileSampleInfoToThird.url}")
    private String revokeMobileSampleInfoToThirdUrl;
    @Value("${third.customerId}")
    private String thirdCustomerId;

    @Transactional
    public void notifySaveMobileSampleInfoToThird(AppletGood good,String barcode){
        List<ThirdSampleInfoVo> list = new ArrayList<>();
        ThirdSampleInfoVo vo = new ThirdSampleInfoVo();
        vo.setBarcode(barcode);
        vo.setCustomBarcode(barcode);

        String packageId = good.getPackageId();
        AppletPackage appletPackage = adminPackageService.getPackageById(packageId);
        if (appletPackage!=null) {
            vo.setSampleType(SampleTypeEnum.getNameById(appletPackage.getSampleType()));
            vo.setTestPurposeId(appletPackage.getLabCode());
            vo.setTestPurposeName(appletPackage.getPackageName());
            vo.setFee(appletPackage.getPackageCurrentPrice().toString());
            vo.setSampleType(SampleTypeEnum.getNameById(appletPackage.getSampleType()));
        }

        AppletOrderParticipant participant = adminParticipantService.getParticipantByParticipantIdNew(good.getParticipantId());
        if (participant!=null) {
            vo.setPatientAddress(participant.getParticipantAddress());
            vo.setPatientPhone(participant.getParticipantPhone());
            vo.setPatientName(participant.getParticipantName());
            if (StringUtils.isNotBlank(participant.getParticipantIdCard())) {
                vo.setPatientIdNumber(participant.getParticipantIdCard());
                Integer age = IDCardUtils.getAge(participant.getParticipantIdCard());
                if (age!=null) {
                    vo.setAge("" + IDCardUtils.getAge(participant.getParticipantIdCard()));
                }
                vo.setAgeType("岁");
                Integer sex = IDCardUtils.getSex(participant.getParticipantIdCard());
                if (sex!=null) {
                    vo.setSex(1 + sex);
                }
            }
        }

        vo.setRequester(good.getDoctorName());
        vo.setRequestTime(DateUtils.convertToStandardDate(good.getCreateDate()));

        if (StringUtils.isNotBlank(good.getCollectorStaffId())){
            AppletAcquisitionStaff staff = adminStaffService.getStaffById(good.getCollectorStaffId());
            if (staff!=null){
                vo.setExecutor(staff.getStaffName());
            }
        }
        vo.setExecuteTime(DateUtils.convertToStandardDate(new Date()));

        list.add(vo);
        String jsonStr = JSONObject.toJSONString(list);
        logger.info("json对象转换结果"+jsonStr);
        String saveResult = CommonHttpClientUtils.postMethodClient(jsonStr,saveMobileSampleInfoToThirdUrl);
        logger.info("商品号"+good.getGoodNo()+"通知第三方的返回结果"+saveResult);
        try {
            if (StringUtils.isNotBlank(saveResult)) {
                ThirdResponseVo thirdResponseVo = JSON.parseObject(saveResult, ThirdResponseVo.class);
                if (thirdResponseVo.getState()!=null&&thirdResponseVo.getState().equals(1)){
                    //正常返回结果
                } else {
                    //其余情况都是异常返回
                    logger.info("条码号"+barcode+"通知第三方绑定条码失败");
                    throw new RuntimeException("通知第三方绑定条码失败");
                }
            }
        } catch (Exception e){
            logger.info("条码号"+barcode+"通知第三方绑定条码返回结果转换异常");
            throw new RuntimeException("通知第三方绑定条码返回结果转换异常");
        }
    }
}
