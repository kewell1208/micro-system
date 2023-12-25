package com.tclab.weixinappletservice.service.clientService;

import static com.tclab.weixinappletcommon.constant.IMConstants.IM_INTERPRET_TYPE_OTHER;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.AcquisitionConstants;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.GoodConstants;
import com.tclab.weixinappletcommon.constant.IMConstants;
import com.tclab.weixinappletcommon.constant.LogisticsConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletcommon.utils.SMSUtils;
import com.tclab.weixinappletcommon.utils.WxTencentUtils;
import com.tclab.weixinappletservice.dao.AppletGoodExceptionMapper;
import com.tclab.weixinappletservice.dao.AppletGoodMapper;
import com.tclab.weixinappletservice.dao.AppletInterpretGoodMapper;
import com.tclab.weixinappletservice.dao.AppletInterpretMapper;
import com.tclab.weixinappletservice.dao.AppletLogisticsThirdSelfMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.dao.AppletPackageMapper;
import com.tclab.weixinappletservice.model.query.AcquisitionGetDayPageOrderStatusParam;
import com.tclab.weixinappletservice.model.query.AcquisitionNameOrPhoneQueryParam;
import com.tclab.weixinappletservice.model.query.InvoiceQueryParam;
import com.tclab.weixinappletservice.model.query.QueryNoParam;
import com.tclab.weixinappletservice.model.result.OrderDayGroupResult;
import com.tclab.weixinappletservice.model.result.ParticipantHistoryResult;
import com.tclab.weixinappletservice.model.result.ParticipantRecentResult;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AppletPackageCollectVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.GoodPlaceReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.InvoiceOrderListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderForDayAndTimeVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderForDayAndTimeWithTotalVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderForGroupByDayVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderPlaceReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ParticipantHistoryVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ParticipantRecentVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.RecentOrderInfoVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.SelfCollectPackageVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ThirdLogisticsVo;
import com.tclab.weixinappletservice.pojo.AppletAcquisition;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionStaff;
import com.tclab.weixinappletservice.pojo.AppletDoctor;
import com.tclab.weixinappletservice.pojo.AppletGood;
import com.tclab.weixinappletservice.pojo.AppletGoodExample;
import com.tclab.weixinappletservice.pojo.AppletGoodException;
import com.tclab.weixinappletservice.pojo.AppletImRecord;
import com.tclab.weixinappletservice.pojo.AppletInterpret;
import com.tclab.weixinappletservice.pojo.AppletInterpretExample;
import com.tclab.weixinappletservice.pojo.AppletInterpretGood;
import com.tclab.weixinappletservice.pojo.AppletLogisticsThirdSelf;
import com.tclab.weixinappletservice.pojo.AppletLogisticsThirdSelfExample;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.pojo.AppletPackageExample;
import com.tclab.weixinappletservice.pojo.AppletUser;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  @Autowired
  private AppletOrderMapper orderMapper;
  @Autowired
  private AppletGoodMapper goodMapper;
  @Autowired
  private AppletGoodExceptionMapper exceptionMapper;
  @Autowired
  private LogisticsService logisticsService;
  @Autowired
  private AppletLogisticsThirdSelfMapper thirdSelfMapper;
  @Autowired
  private AppletPackageMapper packageMapper;
  @Autowired
  private UserService userService;
  @Autowired
  private PackageService packageService;
  @Autowired
  private RedisUtils redisUtils;
  @Autowired
  private PayService payService;
  @Autowired
  private AcquisitionService acquisitionService;
  @Autowired
  private OrderService orderService;
  @Autowired
  private StaffService staffService;
  @Autowired
  private ImRecommendListService imRecommendListService;
  @Autowired
  private DoctorService doctorService;
  @Autowired
  private ParticipantService participantService;
  @Autowired
  private ImRecordService imRecordService;
  @Autowired
  private NumberGeneratorUtils numberGeneratorUtils;
  @Autowired
  private AppletInterpretMapper interpretMapper;
  @Autowired
  private AppletInterpretGoodMapper interpretGoodMapper;

  private static final Logger logger = LoggerFactory.getLogger(OrderService.class);

  @Value("${default.tclab.doctor.name}")
  private String defaultTclabDoctorName;
  @Value("${default.tclab.doctor.phone}")
  private String defaultTclabDoctorPhone;
  @Value("${default.tclab.doctor.id}")
  private String defaultTclabDoctorId;
  @Value("${default.tclab.doctor.phone}")
  private String defaultDoctorPhone;

  /**
   * 下单
   */
  @Transactional
  public String placeOrder(OrderPlaceReqVo req) {
    int i = 0;
    String orderNo;
    String orderNoIndexStr;
    Integer orderNoIndex = Integer.parseInt(redisUtils.get(RedisConstants.GENERATEID + ":" + RedisConstants.ORDERNO_INDEX));
    if (orderNoIndex != null) {
      orderNoIndex++;
      boolean a = redisUtils.set(RedisConstants.GENERATEID + ":" + RedisConstants.ORDERNO_INDEX, orderNoIndex.toString());
      if (!a) {
        throw new RuntimeException("缓存读取失败");
      }
      orderNoIndexStr = String.format("%06d", orderNoIndex);
    } else {
      redisUtils.set(RedisConstants.GENERATEID + ":" + RedisConstants.ORDERNO_INDEX, "1");
      orderNoIndexStr = String.format("%06d", 1);
    }
    String day = redisUtils.get(RedisConstants.DAY);
    if (day == null) {
      day = DateUtils.formatDayString(new Date());
    }
    orderNo = CommonConstants.GenerateID_ORDER + day + orderNoIndexStr;

    AppletOrder order = new AppletOrder();
    BeanUtils.copyProperties(req, order);

    AppletUser user = userService.getUserById(req.getUserId());
    if (user == null) {
      throw new RuntimeException("用户不存在");
    }
    order.setUserName(user.getUserName());
    order.setUserIdCard(user.getUserIdCard());
    order.setUserPhone(user.getUserPhone());

    AppletDoctor doctor = new AppletDoctor();

    if (StringUtils.isNotBlank(req.getImRecommendListId()) && StringUtils.isNotBlank(req.getDoctorId())) {
      order.setInterpretStaffId(req.getDoctorId());
      order.setAuditorId(req.getDoctorId());
      order.setStaffId(req.getDoctorId());

      doctor = doctorService.getDoctorByDoctorId(req.getDoctorId());
      if (doctor != null) {
        order.setStaffName(doctor.getDoctorName());
        order.setStaffPhone(doctor.getDoctorPhone());
      }
    } else {
      order.setInterpretStaffId(defaultTclabDoctorId);
      order.setStaffId(defaultTclabDoctorId);
      order.setStaffPhone(defaultTclabDoctorPhone);
      order.setStaffName(defaultTclabDoctorName);
    }

    order.setOrderNo(orderNo);

    order.setOrderApplyDate(DateUtils.convertToOrderApplyDate(req.getOrderApplyDate()));
    order.setOrderCurrentApplyDate(DateUtils.convertToOrderApplyDate(req.getOrderApplyDate()));

    order.setOrderStatus(OrderConstants.ORDER_STATUS_UNPAY);
    order.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_UNSEND);
    order.setPayStatus(OrderConstants.ORDER_PAY_STATUS_UNPAY);
    order.setRefundStatus(CommonConstants.INIT);
    order.setVerifyStatus(CommonConstants.INIT);
    order.setWriteOffStatus(CommonConstants.INIT);
    order.setOrderCancelStatus(CommonConstants.INIT);
    order.setOrderExceptionStatus(CommonConstants.INIT);
    order.setInterpretStatus(CommonConstants.INIT);

    order.setInvoiceStatus(CommonConstants.INIT);

    order.setDelFlag(CommonConstants.INIT);

    order.setUpdateDate(new Date());
    order.setCreateDate(new Date());

    BigDecimal orderPayAmount = new BigDecimal("0");
    BigDecimal orderTotalAmount = new BigDecimal("0");
    BigDecimal orderDiscountedAmount = new BigDecimal("0");

    StringBuffer goodName = new StringBuffer("");
    List<GoodPlaceReqVo> reqVoList = req.getGoods();
    logger.info("reqVo对象" + reqVoList.get(0));
    Set<String> packageIdSet = new HashSet<>();
    boolean isCoupon = false;
    for (GoodPlaceReqVo goodPlaceReqVo : reqVoList) {
      packageIdSet.add(goodPlaceReqVo.getPackageId());
    }
    //优惠卷功能(血常规(五分类),肾功能常规检查,肝功能常规(12项),)
    String coupon = redisUtils.get("coupon:" + req.getUserId());
    logger.info(coupon);
    if (req.getIsCoupon() != null && req.getIsCoupon() == 1
        && StringUtils.isNotBlank(coupon) && "true".equals(coupon)) {
      List<String> couponSet = new ArrayList<>();
      couponSet.add("P201905160006");
      couponSet.add("P201906120025");
      couponSet.add("P201908090003");
      couponSet.add("P201910180022");
      couponSet.add("P201910180021");

      logger.info("设置完成");

      if (packageIdSet.size() == couponSet.size()) {
        isCoupon = true;
        for (String packageId : packageIdSet) {
          logger.info(packageId);
          if (!couponSet.contains(packageId)) {
            isCoupon = false;
            logger.info(packageId + " " + isCoupon);
          }
        }
      }
    }

    logger.info("isCoupon结果" + isCoupon);

    for (GoodPlaceReqVo goodPlaceReqVo : reqVoList) {
      logger.info("开始生成商品号");
      String goodNo = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_GOOD);
      goodName.append(goodPlaceReqVo.getPackageName() + ";");

      AppletGood good = new AppletGood();
      good.setGoodNo(goodNo);
      good.setOrderNo(orderNo);
      BeanUtils.copyProperties(goodPlaceReqVo, good);

      AppletPackage appletPackage = packageService.getPackageById(goodPlaceReqVo.getPackageId());
      if (appletPackage != null) {
        BigDecimal goodPayAmount = appletPackage.getPackageCurrentPrice().multiply(new BigDecimal("1"));
        BigDecimal totalAmount = appletPackage.getPackagePrimePrice().multiply(new BigDecimal("1"));
        BigDecimal discountAmount = totalAmount.subtract(goodPayAmount);
        //有优惠卷 则总价是0.01元
        if (isCoupon) {
          goodPayAmount = new BigDecimal("0.002");
          discountAmount = totalAmount.subtract(goodPayAmount);
        }
        good.setTotalAmount(totalAmount);
        good.setPayAmount(goodPayAmount);
        good.setDiscountAmount(discountAmount);

        orderPayAmount = orderPayAmount.add(goodPayAmount);
        orderTotalAmount = orderTotalAmount.add(totalAmount);
        orderDiscountedAmount = orderDiscountedAmount.add(discountAmount);
      }

      good.setGoodApplyDate(DateUtils.convertToOrderApplyDate(req.getOrderApplyDate()));
      good.setGoodCurrentApplyDate(DateUtils.convertToOrderApplyDate(req.getOrderApplyDate()));

      good.setGoodStatus(GoodConstants.GOOD_STATUS_UNPAY);
      good.setDelFlag(CommonConstants.INIT);
      good.setServiceType(req.getServiceType());

      good.setGoodApplyDate(DateUtils.formatDateForAMOrPM(req.getOrderApplyDate()));
      good.setAcquisitionId(req.getAcquisitionId());
      good.setAcquisitionName(req.getAcquisitionName());

      good.setUserId(order.getUserId());
      good.setParticipantId(order.getParticipantId());

//            if (StringUtils.isNotBlank(goodPlaceReqVo.getDoctorPhone())) {
//                good.setStaffName(goodPlaceReqVo.getDoctorName());
//                good.setStaffPhone(goodPlaceReqVo.getDoctorPhone());
//                good.setDoctorName(goodPlaceReqVo.getDoctorName());
//                good.setDoctorPhone(goodPlaceReqVo.getDoctorPhone());
//            } else {

      if (StringUtils.isNotBlank(req.getDoctorId())) {
        good.setStaffName(doctor.getDoctorName());
        good.setStaffPhone(doctor.getDoctorPhone());
        good.setDoctorName(doctor.getDoctorName());
        good.setDoctorPhone(doctor.getDoctorPhone());
      } else {

        String doctorName = redisUtils.get(RedisConstants.DEFAULT + ":" + RedisConstants.TCLAB_DOCTORNAME);
        String doctorPhone = redisUtils.get(RedisConstants.DEFAULT + ":" + RedisConstants.TCLAB_DOCTORPHONE);

        if (StringUtils.isBlank(doctorPhone)) {
          good.setDoctorName(defaultTclabDoctorName);
          good.setDoctorPhone(defaultTclabDoctorPhone);
//                    order.setInterpretStaffId(defaultTclabDoctorId);
        } else {
          good.setDoctorName(doctorName);
          good.setDoctorPhone(doctorPhone);
//                    order.setInterpretStaffId("D201910130005");
        }
      }

//      good.setDoctorName(defaultTclabDoctorName);
//      good.setDoctorPhone(defaultTclabDoctorPhone);
      good.setExceptionStatus(GoodConstants.GOOD_EXCEPTION_STATUS_INIT);
      good.setRefundStatus(GoodConstants.GOOD_REFUND_STATUS_UNPAY);

      good.setUpdateDate(new Date());
      good.setCreateDate(new Date());
      i = goodMapper.insertSelective(good);
      if (i == 0) {
        throw new RuntimeException("套餐下单生成失败");
      }
    }

    logger.info("orderPayAmount" + orderPayAmount);
    order.setPayAmount(orderPayAmount);
    logger.info("orderTotalAmount" + orderTotalAmount);
    order.setTotalAmount(orderTotalAmount);
    logger.info("orderDiscountedAmount" + orderDiscountedAmount);
    order.setDiscountAmount(orderDiscountedAmount);

    if (reqVoList != null && reqVoList.size() != 0) {
      order.setImRecommendListId(reqVoList.get(0).getImRecommendListId());
    }

    String result = goodName.substring(0, goodName.length() - 1);
    order.setGoodName(result);

    i = orderMapper.insertSelective(order);
    if (i == 0) {
      throw new RuntimeException("订单生成失败");
    } else {
      if (isCoupon) {
        redisUtils.remove("coupon:" + order.getUserId());
      }
      return orderNo;
    }
  }

  /**
   * 发起支付 未支付的订单或者支付失败的订单 自用订单支付后生成核销码 赠送他人订单支付后不生成核销码，直接已完成 自采用户也会生成核销码，自采用户也可以自行到院采集
   */
  @Transactional
  public Map<String, Object> payOrder(HttpServletRequest req, String orderNo, String openid) {

    AppletOrder appletOrder;

    //检查订单是否可以支付
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNPAY);
    criteria.andOrderCancelStatusEqualTo(CommonConstants.INIT);
    List<Integer> payStatusList = new ArrayList<>();
    payStatusList.add(OrderConstants.ORDER_PAY_STATUS_PAYFAILED);
    payStatusList.add(OrderConstants.ORDER_PAY_STATUS_PAYING);
    payStatusList.add(OrderConstants.ORDER_PAY_STATUS_UNPAY);
    criteria.andPayStatusIn(payStatusList);
    List<AppletOrder> orderList = orderMapper.selectByExample(example);
    if (orderList != null && orderList.size() != 0) {
      appletOrder = orderList.get(0);
    } else {
      throw new RuntimeException("客户端订单无法发起支付操作,订单不满足支付要求");
    }

    String prepay_id = "";

    Map<String, Object> preResult = null;

    //如果金额不为0则发起微信支付
    if (!appletOrder.getPayAmount().equals(BigDecimal.ZERO)) {
      String payAmount = String.valueOf(appletOrder.getPayAmount().multiply(new BigDecimal("100")).intValue());
      logger.info("支付金额" + payAmount + "分");
      preResult = payService.wxPay(openid, orderNo, "同创诊合-检验套餐", payAmount, req);
      if (preResult == null) {
        throw new RuntimeException("微信服务器返回支付结果失败");
      }
      prepay_id = (String) preResult.get("prepay_id");
    }

    AppletOrder order = new AppletOrder();

//        order.setPayStatus(OrderConstants.ORDER_PAY_STATUS_PAYED);
//        String writeOffCode= NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_WRITEOFF_CODE);
//        order.setWriteOffCode(writeOffCode);

    order.setPreNo(prepay_id);

    //如果订单类型是赠送他人就直接设置付款完成就订单状态已完成
    if (appletOrder.getOrderType() == OrderConstants.ORDER_TYPE_GIVE) {
      order.setOrderStatus(OrderConstants.ORDER_STATUS_COMPLETED);
      order.setPayStatus(OrderConstants.ORDER_PAY_STATUS_PAYED);
    } else {
      //如果是普通订单则设置为未付款，支付状态支付中
      order.setOrderStatus(OrderConstants.ORDER_STATUS_UNPAY);
      order.setPayStatus(OrderConstants.ORDER_PAY_STATUS_PAYING);
//            String writeOffCode= NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_WRITEOFF_CODE);
//            order.setWriteOffCode(writeOffCode);
    }

    order.setPayDate(new Date());
    order.setUpdateDate(new Date());
    int i = orderMapper.updateByExampleSelective(order, example);
    if (i == 0) {
      return null;
    }

    return preResult;

    //设置商品已付款
    //当微信回调完成后才是已付款
//        AppletGoodExample goodExample = new AppletGoodExample();
//        AppletGoodExample.Criteria criteria1 = goodExample.createCriteria();
//        criteria1.andDelFlagEqualTo(CommonConstants.INIT);
//        criteria1.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_UNPAY);
//        criteria1.andOrderNoEqualTo(orderNo);
//        AppletGood good = new AppletGood();
//        good.setGoodStatus(GoodConstants.GOOD_STATUS_UNCOLLECT);
//        i=goodMapper.updateByExampleSelective(good,goodExample);
//        if (i==0){
//            logger.info("客户端支付失败: "+orderNo);
//            return false;
//        }
//        logger.info("客户端支付成功: "+orderNo);
//        return true;
  }

  @Transactional
  public boolean wxUpdatePayStatusSuccessful(String orderNo, String transactionId) {

    logger.info("更新订单微信支付成功状态: " + orderNo + " 交易单号: " + transactionId);

    //首先更新订单状态
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYING);

    AppletOrder order = new AppletOrder();
    if (StringUtils.isNotBlank(transactionId)) {
      order.setPayNo(transactionId);
    }
    order.setPayStatus(OrderConstants.ORDER_PAY_STATUS_PAYED);
    order.setOrderStatus(OrderConstants.ORDER_STATUS_UNCOLLECT);

    //支付成功后生成核销码
    String writeOffCode = orderNo.substring(1, orderNo.length());
    order.setWriteOffCode(writeOffCode);

    order.setUpdateDate(new Date());

    int i = orderMapper.updateByExampleSelective(order, example);
    if (i == 0) {
      logger.info("更新订单微信支付状态失败");
      throw new RuntimeException("更新订单微信支付状态失败" + orderNo);
    }

    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria criteria1 = goodExample.createCriteria();
    criteria1.andDelFlagEqualTo(CommonConstants.INIT);
    criteria1.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_UNPAY);
    criteria1.andOrderNoEqualTo(orderNo);
    AppletGood good = new AppletGood();
    good.setGoodStatus(GoodConstants.GOOD_STATUS_UNCOLLECT);
    i = goodMapper.updateByExampleSelective(good, goodExample);
    if (i == 0) {
      logger.info("更新商品微信支付状态失败");
      throw new RuntimeException("更新商品微信支付状态失败" + orderNo);
    }
    //当订单的采集点不需要确认的时候直接更新订单已确认
    AppletOrder checkOrder = orderService.getOrderByOrderNo(orderNo);
    if (checkOrder != null && StringUtils.isNotBlank(checkOrder.getAcquisitionId())) {
      AppletAcquisition acquisition = acquisitionService.getAcquisitionByAcquisitionId(checkOrder.getAcquisitionId());
      if (acquisition.getVerifyFlag() != null && acquisition.getVerifyFlag().equals(AcquisitionConstants.ACQUISITION_VERIFY_FLAG_UNREQUIRED)) {
        List<String> orderNoList = new ArrayList<>();
        orderNoList.add(orderNo);
//        List<AppletAcquisitionStaff> staffList = staffService.getStaffByAcquisitionIdAndStaffType(acquisition.getAcquisitionId(), CommonConstants.USER_ROLE_VERIFY_DEFAULT);
//        if (staffList != null && staffList.size() != 0) {
//          verifyOrder(orderNoList, staffList.get(0).getStaffId());
//        }
        verifyOrder(orderNoList, checkOrder.getStaffId());
      }
    }

    logger.info("订单的推荐单号" + checkOrder.getImRecommendListId());

    //当订单关联推荐清单的时候更新推荐清单的状态
    if (StringUtils.isNotBlank(checkOrder.getImRecommendListId())) {

      logger.info("更新推荐单" + checkOrder.getOrderNo() + "--" + checkOrder.getImRecommendListId());

      imRecommendListService.updateImRecommendListPaySuccessful(checkOrder.getImRecommendListId());
    }

    return true;
  }

  @Transactional
  public boolean wxUpdatePayStatusFail(String orderNo, String transactionId) {

    logger.info("更新订单微信支付失败状态: " + orderNo + " 交易单号: " + transactionId);

    //首先更新订单状态
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYING);

    AppletOrder order = new AppletOrder();
    if (StringUtils.isNotBlank(transactionId)) {
      order.setPayNo(transactionId);
    }
    order.setPayStatus(OrderConstants.ORDER_PAY_STATUS_PAYFAILED);
    order.setOrderStatus(OrderConstants.ORDER_STATUS_UNPAY);
    order.setUpdateDate(new Date());

    int i = orderMapper.updateByExampleSelective(order, example);
    if (i == 0) {
      logger.info("更新订单微信支付失败状态失败");
      throw new RuntimeException("更新订单微信支付失败状态失败" + orderNo);
    }
    return true;
  }


  /**
   * 获取当天的带采集已采集和所有的异常订单
   */
  public Map<String, Long> getTodayOrderCountByAcquisitionId(String id) {
    if (StringUtils.isBlank(id)) {
      return null;
    }
    Date today = new Date();
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();

    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderApplyDateBetween(DateUtils.getDateStartForThisDay(today), DateUtils.getDateEndForThisDay(today));
    criteria.andAcquisitionIdEqualTo(id);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
//        criteria.andVerifyStatusEqualTo(CommonConstants.ENABLE);
    criteria.andRefundStatusEqualTo(CommonConstants.INIT);
    Long countForUnCollect = orderMapper.countByExample(example);
    example.clear();

    criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderCompleteApplyDateBetween(DateUtils.getDateStartForThisDay(today), DateUtils.getDateEndForThisDay(today));
    criteria.andAcquisitionIdEqualTo(id);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);
    Long countForCollected = orderMapper.countByExample(example);
    example.clear();

    criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderApplyDateBetween(DateUtils.getDateStartForThisDay(today), DateUtils.getDateEndForThisDay(today));
    criteria.andAcquisitionIdEqualTo(id);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria.andOrderExceptionStatusEqualTo(OrderConstants.ORDER_EXCEPTION_ERROR);
    Long countForException = orderMapper.countByExample(example);
    Map<String, Long> map = new HashMap();
    map.put("countForUnCollect", countForUnCollect);
    map.put("countForCollected", countForCollected);
    map.put("countForException", countForException);
    return map;
  }

  /**
   * 采集点获取最近付款的订单
   */
  public List<RecentOrderInfoVo> getRecentOrderForAcquisitionByAcquisitionId(String id) {
    if (StringUtils.isBlank(id)) {
      return null;
    }
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    criteria.andAcquisitionIdEqualTo(id);
    example.setOrderByClause("pay_date DESC");
    PageHelper.startPage(1, 6);
    List<AppletOrder> result = orderMapper.selectByExample(example);
    PageInfo<AppletOrder> pageInfo = new PageInfo<>(result);

    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodCriteria = goodExample.createCriteria();

    List<RecentOrderInfoVo> infoVos = new ArrayList<>();

    for (AppletOrder order : pageInfo.getList()) {
      RecentOrderInfoVo infoVo = new RecentOrderInfoVo();
//            infoVo.setCreateDate(DateUtils.convertToSlashAndMinDate(order.getPayDate()));
      infoVo.setCreateDate(DateUtils.convertToSlashAndDayDate(order.getPayDate()));
      infoVo.setUserPhone(order.getUserPhone());
      infoVo.setParticipantName(order.getParticipantName());
      goodCriteria.andOrderNoEqualTo(order.getOrderNo());
      List<AppletGood> goods = goodMapper.selectByExample(goodExample);
      if (goods.size() != 0) {
        infoVo.setPackageName(goods.get(0).getPackageName());
      }
      infoVos.add(infoVo);
      goodExample.clear();
    }
    return infoVos;
  }

  /**
   * 采集点获取患者的基本信息包含最近采集历史记录
   */
  public List<ParticipantRecentVo> getParticipantHistory(AcquisitionNameOrPhoneQueryParam param) {
    List<ParticipantRecentResult> result = orderMapper.selectParticipantAndRecentCollectInfoByNameOrPhone(param);
    List<ParticipantRecentVo> a = new ArrayList<>();
    for (ParticipantRecentResult historyResult : result) {
      ParticipantRecentVo vo = new ParticipantRecentVo();
      BeanUtils.copyProperties(historyResult, vo);
      vo.setMaxOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(historyResult.getMaxOrderCompleteApplyDate()));
      a.add(vo);
    }
    return a;
  }

  /**
   * 获取订单详细数据
   */
  public List<ParticipantHistoryVo> getParticipantOrder(AcquisitionNameOrPhoneQueryParam param) {
    List<ParticipantHistoryResult> result = orderMapper.selectParticipantHistoryById(param);
    List<ParticipantHistoryVo> a = new ArrayList<>();
    for (ParticipantHistoryResult historyResult : result) {
      ParticipantHistoryVo vo = new ParticipantHistoryVo();
      BeanUtils.copyProperties(historyResult, vo);
      a.add(vo);
    }
    return a;
  }

  /**
   * 采集点获取不同状态的订单
   */
  public List<AppletOrder> acquisitionGetOrderByStatus(String acquisitionId, Integer orderStatus, String queryParam, Integer dayNum) {
//        OrderStatusParam param = new OrderStatusParam();
//        param.setAcquisitionId(acquisitionId);
//        param.setOrderStatus(orderStatus);
//        param.setQueryParam(queryParam);
//        List serviceType = new ArrayList();
//        serviceType.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
//        serviceType.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
//        param.setServiceType(serviceType);
//        param.setPageIndex(pageIndex);
//        param.setPageSize(pageSize);
//        return orderMapper.getOrderByStatusAndServiceType(param);
    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria criteria1 = orderExample.createCriteria();
    AppletOrderExample.Criteria criteria2 = orderExample.createCriteria();
    AppletOrderExample.Criteria criteria3 = orderExample.createCriteria();

    List<Integer> serviceType = new ArrayList();
    serviceType.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    serviceType.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);

    List<Integer> orderType = new ArrayList<>();
    orderType.add(OrderConstants.ORDER_TYPE_SELF);
    orderType.add(OrderConstants.ORDER_TYPE_RECEIVE);

    if (StringUtils.isNotBlank(acquisitionId)) {
      criteria1.andAcquisitionIdEqualTo(acquisitionId);
      criteria2.andAcquisitionIdEqualTo(acquisitionId);
      criteria3.andAcquisitionIdEqualTo(acquisitionId);
    }

    criteria1.andOrderStatusEqualTo(orderStatus);
    criteria1.andServiceTypeIn(serviceType);
    criteria1.andOrderTypeIn(orderType);
    criteria1.andRefundStatusEqualTo(CommonConstants.INIT);
    criteria1.andOrderApplyDateIsNotNull();

    criteria2.andOrderStatusEqualTo(orderStatus);
    criteria2.andServiceTypeIn(serviceType);
    criteria2.andOrderTypeIn(orderType);
    criteria2.andRefundStatusEqualTo(CommonConstants.INIT);
    criteria2.andOrderApplyDateIsNotNull();

    criteria3.andOrderStatusEqualTo(orderStatus);
    criteria3.andServiceTypeIn(serviceType);
    criteria3.andOrderTypeIn(orderType);
    criteria3.andRefundStatusEqualTo(CommonConstants.INIT);
    criteria3.andOrderApplyDateIsNotNull();

    if (StringUtils.isNotBlank(queryParam)) {
      criteria1.andOrderNoLike("%" + queryParam + "%");
      criteria2.andParticipantPhoneLike("%" + queryParam + "%");
      criteria3.andParticipantNameLike("%" + queryParam + "%");
    } else {
      return orderMapper.selectByExample(orderExample);
    }

    orderExample.or(criteria2);
    orderExample.or(criteria3);

    return orderMapper.selectByExample(orderExample);
  }


  /**
   * 获取根据订单号未被删除的订单
   */
  public AppletOrder getOrderByOrderNo(String orderNo) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    List<AppletOrder> orders = orderMapper.selectByExample(example);
    if (orders.size() != 0) {
      return orders.get(0);
    } else {
      return null;
    }
  }

  /**
   * 计算采集完成的采集点订单数
   */
  public Long getOrderCountByAcquisitionId(String AcquisitionId) {
    if (StringUtils.isBlank(AcquisitionId)) {
      return null;
    }
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andAcquisitionIdEqualTo(AcquisitionId);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);
    Long countForCollected = orderMapper.countByExample(example);
    return countForCollected;
  }

  /**
   * 用户获取订单列表
   */
  public List<AppletOrder> getUserOrderByStatus(String userId, Integer orderStatus, String param, Integer pageNo, Integer pageSize) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(userId)) {
      criteria.andUserIdEqualTo(userId);
    }
    if (orderStatus != null) {
      criteria.andOrderStatusEqualTo(orderStatus);
    }
    if (StringUtils.isNotBlank(param)) {
      criteria.andGoodNameLike("%" + param + "%");
    }
    example.setOrderByClause("id DESC");
    PageHelper.startPage(pageNo, pageSize);
    List<AppletOrder> orders = orderMapper.selectByExample(example);
    PageInfo<AppletOrder> result = new PageInfo<>(orders);

    orders = result.getList();
    return orders;
  }

  /**
   * 删除订单 已完成的订单可以删除
   */
  @Transactional
  public boolean deleteOrder(String orderNo) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COMPLETED);
    AppletOrder order = new AppletOrder();
    order.setDelFlag(CommonConstants.ENABLE);
    order.setUpdateDate(new Date());
    int i = orderMapper.updateByExampleSelective(order, example);
    if (i == 0) {
      return false;
    }

    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andOrderNoEqualTo(orderNo);
    AppletGood good = new AppletGood();
    good.setDelFlag(CommonConstants.ENABLE);
    i = goodMapper.updateByExampleSelective(good, goodExample);
    if (i == 0) {
      return false;
    }

    return true;
  }

  /**
   * 订单申请退款 未采集已支付未退款的订单才可以申请退款 未核销的订单也可以，核销和采集绑定一起 只允许自用用户退款
   */
  @Transactional
  public boolean userApplyRefundOrder(String orderNo) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    criteria.andOrderTypeEqualTo(OrderConstants.ORDER_TYPE_SELF);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    criteria.andRefundStatusEqualTo(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    criteria.andWriteOffStatusEqualTo(OrderConstants.WRITE_OFF_STATUS_UNFINISH);
    AppletOrder order = new AppletOrder();
    order.setRefundStatus(OrderConstants.ORDER_REFUND_STATUS_PAYING);
    order.setUpdateDate(new Date());
    int i = orderMapper.updateByExampleSelective(order, example);
    if (i == 0) {
      return false;
    }

    return true;
  }


  /**
   * 用户自采去采集 订单采集类型为自采已审核已发样本盒未采集 主要展示发送样本盒的信息和套餐采集的信息
   */
  public SelfCollectPackageVo selfCollectOrder(String orderNo, String packageId) {

    SelfCollectPackageVo selfCollectPackageVo = new SelfCollectPackageVo();
    ThirdLogisticsVo thirdLogisticsVo = new ThirdLogisticsVo();
    AppletPackageCollectVo packageCollectVo = new AppletPackageCollectVo();

    //获取样本盒的物流信息
    AppletLogisticsThirdSelfExample thirdSelfExample = new AppletLogisticsThirdSelfExample();
    AppletLogisticsThirdSelfExample.Criteria criteria = thirdSelfExample.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    List<AppletLogisticsThirdSelf> thirdSelfList = thirdSelfMapper.selectByExample(thirdSelfExample);
    if (thirdSelfList.size() == 0) {
      selfCollectPackageVo.setThirdLogisticsVo(null);
    } else {
      BeanUtils.copyProperties(thirdSelfList.get(0), thirdLogisticsVo);
      selfCollectPackageVo.setThirdLogisticsVo(thirdLogisticsVo);
    }

    //获取采集套餐的步骤
    AppletPackageExample packageExample = new AppletPackageExample();
    AppletPackageExample.Criteria packageExampleCriteria = packageExample.createCriteria();
    packageExampleCriteria.andPackageIdEqualTo(packageId);
    List<AppletPackage> packageList = packageMapper.selectByExample(packageExample);
    if (packageList.size() != 0) {
      BeanUtils.copyProperties(packageList.get(0), packageCollectVo);
      selfCollectPackageVo.setPackageCollectVo(packageCollectVo);
    } else {
      selfCollectPackageVo.setPackageCollectVo(null);
    }

    return selfCollectPackageVo;
  }

//    /**
//     * 自采用户送检
//     * 自采，已付款，未退款，带采集的订单
//     * @param expressImages
//     * @param userId
//     * @param expressName
//     * @param waybillNo
//     * @param orderNos
//     * @return
//     */
//    @Transactional
//    public boolean selfSendOrder(List<MultipartFile> expressImages, String userId, String expressName, String waybillNo, String[] orderNos){
//
//        for (String orderNo:orderNos) {
//            AppletOrder order = getOrderByOrderNo(orderNo);
//            if (order==null){
//                logger.info("订单号: "+orderNo+" 不存在");
//                return false;
//            }
//            if (order.getServiceType()!=null&&order.getServiceType().equals(OrderConstants.ORDER_SERVICE_TYPE_SELF)&&
//                    order.getOrderStatus()!=null&&order.getOrderStatus().equals(OrderConstants.ORDER_STATUS_UNCOLLECT)&&
//                    order.getPayStatus()!=null&&order.getPayStatus().equals(OrderConstants.ORDER_PAY_STATUS_PAYED)&&
//                    order.getRefundStatus()!=null&&order.getRefundStatus().equals(OrderConstants.ORDER_REFUND_STATUS_UNPAY)){
//            } else {
//                logger.info("自采订单: "+orderNo+" 不符合回寄要求");
//                return false;
//            }
//        }
//
//        int i = logisticsService.sendOrderToTc(expressImages,LogisticsConstants.LOGISTICS_TYPE_THIRD_SELF,null,userId,expressName,waybillNo,orderNos);
//
//        if (i!=0){
//
//            //更新订单采集状态和物流状态
//            AppletOrderExample example = new AppletOrderExample();
//            AppletOrderExample.Criteria criteria = example.createCriteria();
//            criteria.andDelFlagEqualTo(CommonConstants.INIT);
//
//            //更新商品状态
//            AppletGoodExample goodExample = new AppletGoodExample();
//            AppletGoodExample.Criteria goodExampleCriteria =goodExample.createCriteria();
//
//            for (String orderNo:orderNos) {
//
//                criteria.andOrderNoEqualTo(orderNo);
//                criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COMPLETED);
//                AppletOrder order = new AppletOrder();
//                order.setDelFlag(CommonConstants.ENABLE);
//                order.setUpdateDate(new Date());
//                i = orderMapper.updateByExampleSelective(order,example);
//                if (i==0){
//                    return false;
//                }
//
//
//                goodExampleCriteria.andOrderNoEqualTo(orderNo);
//                AppletGood good = new AppletGood();
//                good.setDelFlag(CommonConstants.ENABLE);
//                i = goodMapper.updateByExampleSelective(good,goodExample);
//                if (i==0){
//                    return false;
//                }
//
//                return true;
//
//
//            }
//            return true;
//        } else {
//            return false;
//        }
//
//    }

//    /**
//     * 自采用户送检
//     * 自采，已付款，未退款，带采集的订单
//     * @param expressImages
//     * @param userId
//     * @param expressName
//     * @param waybillNo
//     * @param orderNos
//     * @return
//     */
//    @Transactional
//    public boolean selfSendOrder(List<String> expressImages, String userId, String expressName, String waybillNo, List<String> orderNos){
//
//        for (String orderNo:orderNos) {
//            AppletOrder order = getOrderByOrderNo(orderNo);
//            if (order==null){
//                logger.info("订单号: "+orderNo+" 不存在");
//                return false;
//            }
//            //自采订单必须是已付款待采集未退款的自采订单
//            if (order.getServiceType()!=null&&order.getServiceType().equals(OrderConstants.ORDER_SERVICE_TYPE_SELF)&&
//                    order.getOrderStatus()!=null&&order.getOrderStatus().equals(OrderConstants.ORDER_STATUS_UNCOLLECT)&&
//                    order.getPayStatus()!=null&&order.getPayStatus().equals(OrderConstants.ORDER_PAY_STATUS_PAYED)&&
//                    order.getRefundStatus()!=null&&order.getRefundStatus().equals(OrderConstants.ORDER_REFUND_STATUS_UNPAY)){
//            } else {
//                logger.info("自采订单: "+orderNo+" 不符合回寄要求");
//                return false;
//            }
//        }
//
//        int i = logisticsService.sendOrderToTc(expressImages,LogisticsConstants.LOGISTICS_TYPE_THIRD_SELF,null,userId,expressName,waybillNo,orderNos);
//
//        if (i!=0){
//
//            //更新订单采集状态和物流状态
//            AppletOrderExample example = new AppletOrderExample();
//            AppletOrderExample.Criteria criteria = example.createCriteria();
//            criteria.andDelFlagEqualTo(CommonConstants.INIT);
//
//            //更新商品状态
//            AppletGoodExample goodExample = new AppletGoodExample();
//            AppletGoodExample.Criteria goodExampleCriteria =goodExample.createCriteria();
//
//            for (String orderNo:orderNos) {
//
//                criteria.andOrderNoEqualTo(orderNo);
//                criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COMPLETED);
//                AppletOrder order = new AppletOrder();
//                order.setDelFlag(CommonConstants.ENABLE);
//                order.setUpdateDate(new Date());
//                i = orderMapper.updateByExampleSelective(order,example);
//                if (i==0){
//                    return false;
//                }
//
//
//                goodExampleCriteria.andOrderNoEqualTo(orderNo);
//                AppletGood good = new AppletGood();
//                good.setDelFlag(CommonConstants.ENABLE);
//                i = goodMapper.updateByExampleSelective(good,goodExample);
//                if (i==0){
//                    return false;
//                }
//
//                return true;
//
//
//            }
//            return true;
//        } else {
//            return false;
//        }
//
//    }

  /**
   * 自采用户送检 自采，已付款，未退款，带采集的订单
   */
  @Transactional
  public boolean selfSendOrder(List<String> expressImages, String userId, String expressName, String waybillNo, List<String> orderNos) {

    for (String orderNo : orderNos) {
      AppletOrder order = getOrderByOrderNo(orderNo);
      if (order == null) {
        logger.info("订单号: " + orderNo + " 不存在");
        return false;
      }
      //自采订单必须是已付款待采集未退款的自采订单
      if (order.getServiceType() != null && order.getServiceType().equals(OrderConstants.ORDER_SERVICE_TYPE_SELF) &&
          order.getOrderStatus() != null && order.getOrderStatus().equals(OrderConstants.ORDER_STATUS_UNCOLLECT) &&
          order.getPayStatus() != null && order.getPayStatus().equals(OrderConstants.ORDER_PAY_STATUS_PAYED) &&
          order.getRefundStatus() != null && order.getRefundStatus().equals(OrderConstants.ORDER_REFUND_STATUS_UNPAY) &&
          order.getLogisticsStatus() != null && order.getLogisticsStatus().equals(LogisticsConstants.LOGISTICS_STATUS_PRESEND)) {
      } else {
        logger.info("自采订单: " + orderNo + " 不符合回寄要求");
        throw new RuntimeException("自采订单: " + orderNo + " 不符合回寄要求");
      }
    }

    int i = logisticsService.sendOrderToTc(expressImages, LogisticsConstants.LOGISTICS_TYPE_THIRD_SELF, null, userId, expressName, waybillNo, orderNos, null);

    if (i != 0) {
      //更新订单采集状态和物流状态
//            AppletOrderExample example = new AppletOrderExample();
//            AppletOrderExample.Criteria criteria = example.createCriteria();
//            criteria.andDelFlagEqualTo(CommonConstants.INIT);
//
//            //更新商品状态
//            AppletGoodExample goodExample = new AppletGoodExample();
//            AppletGoodExample.Criteria goodExampleCriteria =goodExample.createCriteria();
//
//            for (String orderNo:orderNos) {
//
//                criteria.andOrderNoEqualTo(orderNo);
//                criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COMPLETED);
//                AppletOrder order = new AppletOrder();
//                order.setDelFlag(CommonConstants.ENABLE);
//                order.setUpdateDate(new Date());
//                i = orderMapper.updateByExampleSelective(order,example);
//                if (i==0){
//                    return false;
//                }
//
//                goodExampleCriteria.andOrderNoEqualTo(orderNo);
//                AppletGood good = new AppletGood();
//                good.setDelFlag(CommonConstants.ENABLE);
//                i = goodMapper.updateByExampleSelective(good,goodExample);
//                if (i==0){
//                    return false;
//                }
//
//
//            }
      return true;
    } else {
      return false;
    }

  }

  /**
   * 用户取消订单 取消订单仅只适用于未支付和支付失败的订单
   */
  @Transactional
  public boolean userCancelOrder(String orderNo, Integer reasonId) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    //订单状态未支付
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNPAY);
    //订单支付状态未支付和支付失败
    List<Integer> payStatusList = new ArrayList<>();
    payStatusList.add(OrderConstants.ORDER_PAY_STATUS_UNPAY);
    payStatusList.add(OrderConstants.ORDER_PAY_STATUS_PAYFAILED);
    payStatusList.add(OrderConstants.ORDER_PAY_STATUS_PAYING);
    criteria.andPayStatusIn(payStatusList);
    AppletOrder order = new AppletOrder();
    order.setOrderCancelStatus(CommonConstants.ENABLE);
    order.setOrderCancelType(OrderConstants.ORDER_CANCEL_TYPE_SELF);
    order.setOrderCancelReason(reasonId);
    order.setOrderStatus(OrderConstants.ORDER_STATUS_COMPLETED);
    order.setOrderCancelReason(reasonId);
    order.setUpdateDate(new Date());
    int i = orderMapper.updateByExampleSelective(order, example);
    if (i == 0) {
      return false;
    }

    //修改商品状态已取消
    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andOrderNoEqualTo(orderNo);
    goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    AppletGood good = new AppletGood();
    good.setUpdateDate(new Date());
    good.setGoodStatus(GoodConstants.GOOD_STATUS_CANCEL);
    i = goodMapper.updateByExampleSelective(good, goodExample);
    if (i == 0) {
      return false;
    }
    return true;
  }

  /**
   * 审核订单 必须是已付款未审核的订单
   */
  @Transactional
  public boolean verifyOrder(String orderNo) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    criteria.andVerifyStatusEqualTo(CommonConstants.INIT);
    AppletOrder order = new AppletOrder();
    order.setVerifyStatus(CommonConstants.ENABLE);
    order.setUpdateDate(new Date());
    order.setWriteOffDate(new Date());
    int i = orderMapper.updateByExampleSelective(order, example);
    if (i == 0) {
      return false;
    }
    return true;
  }

  /**
   * 用户查看核销码 客户端核销展示核销码即可 展示核销码的前提是已付款，未退款，订单带采集
   */
  @Transactional
  public String userWriteOffOrder(String orderNo) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();

    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    criteria.andRefundStatusEqualTo(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria.andOrderNoEqualTo(orderNo);

    List<AppletOrder> orders = orderMapper.selectByExample(example);

    if (orders.size() != 0) {
      return orders.get(0).getWriteOffCode();
    }
    return null;
  }

  /**
   * 采集点端核销订单 客户端核销展示核销码即可 展示核销码的前提是已付款，未退款，订单带采集
   */
  @Transactional
  public String acquisitionWriteOffOrder(String writeOffCode, String acquisitionId) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();

    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    criteria.andRefundStatusEqualTo(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria.andAcquisitionIdEqualTo(acquisitionId);
    criteria.andWriteOffCodeEqualTo(writeOffCode);

    List<AppletOrder> orders = orderMapper.selectByExample(example);

    if (orders.size() != 0) {
      AppletOrder queryOrder = orders.get(0);

      if (queryOrder.getWriteOffStatus().equals(OrderConstants.WRITE_OFF_STATUS_UNFINISH)) {

        logger.info("订单未核销 " + queryOrder.getOrderNo());

        example.clear();
        criteria = example.createCriteria();
        criteria.andOrderNoEqualTo(queryOrder.getOrderNo());

        AppletOrder updateOrder = new AppletOrder();
        updateOrder.setUpdateDate(new Date());
        updateOrder.setWriteOffDate(new Date());
        updateOrder.setWriteOffStatus(OrderConstants.WRITE_OFF_STATUS_FINISHED);
        orderMapper.updateByExampleSelective(updateOrder, example);
        logger.info("订单核销成功 " + queryOrder.getOrderNo());
      }

      return orders.get(0).getOrderNo();
    }
    return null;
  }

  /**
   * 处理异常订单
   */
  @Transactional(rollbackFor = {Exception.class})
  public boolean exceptionOrder(String orderNo, String goodNo, Integer deal, Integer reason, String goodApplyDate, String packageId, String packageName, String participantId, String participantName,
      String participantPhone, String goodDelayApplyDate) {

    int i = 0;

    //创建异常条目
    AppletGoodException goodException = new AppletGoodException();
    goodException.setCreateDate(new Date());
    goodException.setUpdateDate(new Date());
    goodException.setDelFlag(CommonConstants.INIT);
    goodException.setExceptionReason(reason);
    goodException.setExceptionSolution(deal);
    goodException.setExceptionStatus(GoodConstants.GOOD_EXCEPTION_STATUS_ENABLE);

    goodException.setGoodApplyDate(DateUtils.convertToMinDate(goodApplyDate));
    goodException.setGoodNo(goodNo);
    goodException.setOrderNo(orderNo);
    goodException.setPackageId(packageId);
    goodException.setPackageName(packageName);
    goodException.setParticipantId(participantId);
    goodException.setParticipantName(participantName);
    goodException.setParticipantPhone(participantPhone);

    //如果异常后执行取消操作
    //商品设置成退款中
    //订单的取消原因显示为商品异常
    if (deal == GoodConstants.GOOD_EXCEPTION_DEAL_CANCEL_REFUND) {

      i = exceptionMapper.insertSelective(goodException);
      if (i == 0) {
        throw new RuntimeException("插入异常信息失败");
      }

      //订单取消条件
      //  订单状态    待采集
      //  订单支付状态 已支付
      //  订单服务方式 到院采集和上门采集
      //  订单核销状态 未核销（表示用户未到院采集）和核销中（表示订单有多个商品，某些套餐已绑定条码）
      //  订单退款状态 未退款和部分退款完成
      //  订单物流状态 初始状态状态
      //  订单异常状态 正常和异常（如果有多个套餐也已延期，就不会影响这个套餐的取消操作）
      //  订单取消状态 未取消
      //  订单删除状态 未删除

      //商品的取消条件
      //  商品服务方式 到院采集和上门采集
      //  商品状态    未采集
      //  商品异常状态  正常和异常,异常套餐如果没有来采集依然可以被取消
      //  商品退款状态  未退款或者部分退款完成
      //  商品删除状态  未删除

      //订单下只有单个商品的取消设置订单状态
      //  订单状态    待采集
      //  订单核销状态  未核销
      //  订单退款状态  整单退款中
      //  订单异常状态  不做改变
      //设置商品状态
      //  商品状态    整单退款中
      //  商品异常状态  异常
      //  商品退款状态  整单退款中

      QueryNoParam param = new QueryNoParam();
      param.setOrderNo(orderNo);
      param.setGoodNo(goodNo);
      List<AppletGood> goodList = goodMapper.checkCancelGood(param);

      if (goodList == null || goodList.size() == 0) {
        throw new RuntimeException("套餐 " + goodNo + " 不符合取消退款条件");
      }

      //更新商品异常状态
      AppletGoodExample goodExample = new AppletGoodExample();
      AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();

      goodExampleCriteria.andOrderNoEqualTo(orderNo);
      goodExampleCriteria.andGoodNoEqualTo(goodNo);

      List<Integer> serviceTypeList = new ArrayList<>();
      serviceTypeList.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
      serviceTypeList.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
      goodExampleCriteria.andServiceTypeIn(serviceTypeList);

      List<Integer> goodStatusList = new ArrayList<>();
      goodStatusList.add(GoodConstants.GOOD_STATUS_UNCOLLECT);
      goodExampleCriteria.andGoodStatusIn(goodStatusList);

      List<Integer> refundStatusList = new ArrayList<>();
      refundStatusList.add(GoodConstants.GOOD_REFUND_STATUS_UNPAY);
      refundStatusList.add(GoodConstants.GOOD_REFUND_STATUS_PART_REFUNDED);
      goodExampleCriteria.andRefundStatusIn(refundStatusList);

      List<Integer> goodExceptionStatusList = new ArrayList<>();
      goodExceptionStatusList.add(GoodConstants.GOOD_EXCEPTION_STATUS_INIT);
      goodExceptionStatusList.add(GoodConstants.GOOD_EXCEPTION_STATUS_ENABLE);
      goodExampleCriteria.andExceptionStatusIn(goodExceptionStatusList);

      goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

      AppletGood good = new AppletGood();
      good.setUpdateDate(new Date());
      good.setGoodStatus(GoodConstants.GOOD_STATUS_UNCOLLECT);

      good.setExceptionReason(reason);
      good.setExceptionSolution(GoodConstants.GOOD_EXCEPTION_DEAL_DELAY);
      good.setExceptionStatus(GoodConstants.GOOD_EXCEPTION_STATUS_ENABLE);
      good.setExceptionSolveTime(new Date());

      i = goodMapper.updateByExampleSelective(good, goodExample);
      if (i == 0) {
        throw new RuntimeException("更新商品 " + goodNo + " 延期异常状态失败");
      }

      //更新订单状态
      AppletOrderExample orderExample = new AppletOrderExample();
      AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
      orderExampleCriteria.andOrderNoEqualTo(orderNo);
      orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
      orderExampleCriteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);

      List<Integer> orderServiceTypeList = new ArrayList<>();
      orderServiceTypeList.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
      orderServiceTypeList.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
      orderExampleCriteria.andServiceTypeIn(orderServiceTypeList);

      orderExampleCriteria.andWriteOffStatusEqualTo(CommonConstants.INIT);
      orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);

      //异常状态取消只有在二次绑定条码的时候才可以
      AppletOrder order = new AppletOrder();
      order.setOrderExceptionStatus(CommonConstants.ENABLE);
      order.setOrderExceptionReason(reason);
      order.setUpdateDate(new Date());
      order.setOrderCurrentApplyDate(DateUtils.convertToMinDate(goodDelayApplyDate));
      i = orderMapper.updateByExampleSelective(order, orderExample);
      if (i == 0) {
        throw new RuntimeException("设置订单延期采集失败");
      }

    } else if (deal == GoodConstants.GOOD_EXCEPTION_DEAL_DELAY) {

      QueryNoParam param = new QueryNoParam();
      param.setOrderNo(orderNo);
      param.setGoodNo(goodNo);
      List<AppletGood> goodList = goodMapper.checkDelayGood(param);

      if (goodList == null || goodList.size() == 0) {
        throw new RuntimeException("套餐 " + goodNo + " 不符合延期条件");
      }

      AppletOrderExample orderExample = new AppletOrderExample();
      AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
      orderExampleCriteria.andOrderNoEqualTo(orderNo);
      orderExampleCriteria.andWriteOffStatusEqualTo(CommonConstants.INIT);
      orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
      AppletOrder order = new AppletOrder();
      //异常状态取消只有在二次绑定条码的时候才可以
      order.setOrderExceptionStatus(CommonConstants.ENABLE);
      order.setOrderExceptionReason(reason);
      order.setUpdateDate(new Date());
      order.setOrderCurrentApplyDate(DateUtils.convertToMinrApplyDate(goodDelayApplyDate));
      i = orderMapper.updateByExampleSelective(order, orderExample);
      if (i == 0) {
        throw new RuntimeException("设置订单延期采集失败");
      }

      goodException.setGoodDelayApplyDate(DateUtils.convertToMinrApplyDate(goodDelayApplyDate));
      i = exceptionMapper.insertSelective(goodException);
      if (i == 0) {
        throw new RuntimeException("插入异常信息失败");
      }
      //更新商品异常状态
      AppletGoodExample goodExample = new AppletGoodExample();
      AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
      goodExampleCriteria.andGoodNoEqualTo(goodNo);
      AppletGood good = new AppletGood();
      good.setUpdateDate(new Date());
      good.setGoodStatus(GoodConstants.GOOD_STATUS_UNCOLLECT);

      good.setExceptionReason(reason);
      good.setExceptionSolution(GoodConstants.GOOD_EXCEPTION_DEAL_DELAY);
      good.setExceptionStatus(GoodConstants.GOOD_EXCEPTION_STATUS_ENABLE);
      good.setExceptionSolveTime(new Date());

      good.setGoodCurrentApplyDate(DateUtils.convertToMinrApplyDate(goodDelayApplyDate));

      i = goodMapper.updateByExampleSelective(good, goodExample);
      if (i == 0) {
        throw new RuntimeException("更新商品异常失败");
      }
    } else {
      throw new RuntimeException("不支持除了延期和取消以外的操作");
    }

    return true;
  }


  /**
   * 采集点根据物流状态查询订单
   */
  public List<AppletOrder> getOrderByLogisticsStatus(String acquisitionId, Integer logisticsStatus, Integer pageNo, Integer pageSize) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andAcquisitionIdEqualTo(acquisitionId);
    List<Integer> serviceTypes = new ArrayList<>();
    serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
    criteria.andServiceTypeIn(serviceTypes);
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andLogisticsStatusEqualTo(logisticsStatus);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);
    example.setOrderByClause("pay_date DESC");
    PageHelper.startPage(pageNo, pageSize);
    List<AppletOrder> orders = orderMapper.selectByExample(example);
    PageInfo<AppletOrder> info = new PageInfo<>(orders);
    return info.getList();
  }

  /**
   * 根据物流状态查询订单
   */
  public List<AppletOrder> getOrderByLogisticsType(String acquisitionId, Integer logisticsType, String queryParam, Integer pageSize) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria1 = example.createCriteria();
    AppletOrderExample.Criteria criteria2 = example.createCriteria();
    criteria1.andAcquisitionIdEqualTo(acquisitionId);
    criteria1.andDelFlagEqualTo(CommonConstants.INIT);
    criteria1.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);
    criteria2.andAcquisitionIdEqualTo(acquisitionId);
    criteria2.andDelFlagEqualTo(CommonConstants.INIT);
    criteria2.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);
    List<Integer> serviceTypes = new ArrayList<>();
    serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
    criteria1.andServiceTypeIn(serviceTypes);
    criteria2.andServiceTypeIn(serviceTypes);
    //采集点获取的订单应该是自用或者收到别人的订单
    List<Integer> orderTypes = new ArrayList<>();
    orderTypes.add(OrderConstants.ORDER_TYPE_SELF);
    orderTypes.add(OrderConstants.ORDER_TYPE_RECEIVE);
    criteria1.andOrderTypeIn(orderTypes);
    criteria2.andOrderTypeIn(orderTypes);
    //必须有预约时间
    criteria1.andOrderCompleteApplyDateIsNotNull();
    criteria2.andOrderCompleteApplyDateIsNotNull();

    if (logisticsType != null) {
      //如果物流方式是待发送
      if (logisticsType.equals(LogisticsConstants.ACQUISITION_LOGISTICS_STATUS_UNSEND)) {
        criteria1.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_UNSEND);
        criteria2.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_UNSEND);
        //物流类型是发送中
      } else if (logisticsType.equals(LogisticsConstants.ACQUISITION_LOGISTICS_STATUS_SENDING)) {
        List<Integer> logisticStatus = new ArrayList<>();
        logisticStatus.add(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
        logisticStatus.add(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
        criteria1.andLogisticsStatusIn(logisticStatus);
        criteria2.andLogisticsStatusIn(logisticStatus);
        //物流类型是已确认收到
      } else if (logisticsType.equals(LogisticsConstants.ACQUISITION_LOGISTICS_STATUS_SENDED)) {
        criteria1.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
        criteria2.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
      }
    } else {
      //如果不传入物流查询参数则返回全部订单数据
    }

    if (StringUtils.isNotBlank(queryParam)) {
      criteria1.andParticipantNameLike("%" + queryParam + "%");
      criteria2.andParticipantPhoneLike("%" + queryParam + "%");
    }

    example.or(criteria2);

    example.setOrderByClause("pay_date DESC");
    PageHelper.startPage(1, pageSize);
    List<AppletOrder> orders = orderMapper.selectByExample(example);
    PageInfo<AppletOrder> info = new PageInfo<>(orders);
    return info.getList();
  }

  /**
   * 采集点查询发送完成的订单
   */
  public List<AppletOrder> acquisitionGetSendedOrder(String acquisitionId, String queryParam, Integer pageSize) {
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria1 = example.createCriteria();
    AppletOrderExample.Criteria criteria2 = example.createCriteria();
    criteria1.andAcquisitionIdEqualTo(acquisitionId);
    criteria1.andDelFlagEqualTo(CommonConstants.INIT);
    criteria1.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);
    criteria2.andAcquisitionIdEqualTo(acquisitionId);
    criteria2.andDelFlagEqualTo(CommonConstants.INIT);
    criteria2.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);
    List<Integer> serviceTypes = new ArrayList<>();
    serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
    criteria1.andServiceTypeIn(serviceTypes);
    criteria2.andServiceTypeIn(serviceTypes);
    //采集点获取的订单应该是自用或者收到别人的订单
    List<Integer> orderTypes = new ArrayList<>();
    orderTypes.add(OrderConstants.ORDER_TYPE_SELF);
    orderTypes.add(OrderConstants.ORDER_TYPE_RECEIVE);
    criteria1.andOrderTypeIn(orderTypes);
    criteria2.andOrderTypeIn(orderTypes);
    //必须有预约时间
    criteria1.andOrderCompleteApplyDateIsNotNull();
    criteria2.andOrderCompleteApplyDateIsNotNull();

    //物流类型是已发送
    List<Integer> logisticStatus = new ArrayList<>();
    logisticStatus.add(LogisticsConstants.LOGISTICS_STATUS_SENDEDTOTC);
    criteria1.andLogisticsStatusIn(logisticStatus);
    criteria2.andLogisticsStatusIn(logisticStatus);

    if (StringUtils.isNotBlank(queryParam)) {
      criteria1.andParticipantNameLike("%" + queryParam + "%");
      criteria2.andParticipantPhoneLike("%" + queryParam + "%");
    }

    example.or(criteria2);

    example.setOrderByClause("pay_date DESC");
    PageHelper.startPage(1, pageSize);
    List<AppletOrder> orders = orderMapper.selectByExample(example);
    PageInfo<AppletOrder> info = new PageInfo<>(orders);
    return info.getList();
  }

  /**
   * 根据日期分类
   */
  public List<OrderForGroupByDayVo> acquisitionGroupByAppletOrderByDay(List<AppletOrder> orders) {

    if (orders == null) {
      return null;
    }

    //创建分类目录
    List<String> groupType = new ArrayList<>();
    //创建排序完成后的数据
    List<OrderForGroupByDayVo> otherVos = new ArrayList<>();

    //把查询的订单结果整理成带有时间和日期的vo对象
    List<OrderForDayAndTimeVo> dayAndTimeVos = new ArrayList<>();
    for (AppletOrder order : orders) {
      OrderForDayAndTimeVo exceptionVo = new OrderForDayAndTimeVo();
      exceptionVo.setOrderNo(order.getOrderNo());
      exceptionVo.setPackageName(order.getGoodName());
      exceptionVo.setUserName(order.getUserName());
      exceptionVo.setParticipantName(order.getParticipantName());
      exceptionVo.setParticipantPhone(order.getParticipantPhone());
      exceptionVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
      exceptionVo.setOrderCurrentApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
      exceptionVo.setAppointmentDate(DateUtils.dateToDay(order.getOrderCompleteApplyDate(), "/"));
      exceptionVo.setAppointmentTime(DateUtils.dateToTime(order.getOrderCompleteApplyDate()));
      dayAndTimeVos.add(exceptionVo);
    }

    for (OrderForDayAndTimeVo dayAndTimeVo : dayAndTimeVos) {
      boolean check = false;
      for (String type : groupType) {
        if (dayAndTimeVo.getAppointmentDate() != null) {
          if (dayAndTimeVo.getAppointmentDate().equals(type)) {
            check = true;
            break;
          }
        }
      }
      if (check) {

      } else {
        OrderForGroupByDayVo otherVo = new OrderForGroupByDayVo();
        otherVo.setDate(dayAndTimeVo.getAppointmentDate());
        otherVos.add(otherVo);
        groupType.add(dayAndTimeVo.getAppointmentDate());
      }
    }

    for (OrderForDayAndTimeVo exceptionVo : dayAndTimeVos) {
      for (OrderForGroupByDayVo otherVo : otherVos) {
        if (StringUtils.isNotBlank(exceptionVo.getAppointmentDate())) {
          if (exceptionVo.getAppointmentDate().equals(otherVo.getDate())) {
            otherVo.getDateDetailListc().add(exceptionVo);
          }
        }
      }
    }

    otherVos.sort(new Comparator<OrderForGroupByDayVo>() {
      //按日期排序
      @Override
      public int compare(OrderForGroupByDayVo o1, OrderForGroupByDayVo o2) {
        if (StringUtils.isNotBlank(o1.getDate()) && StringUtils.isNotBlank(o2.getDate())) {
          return -o1.getDate().compareTo(o2.getDate());
        } else if (StringUtils.isNotBlank(o1.getDate()) && StringUtils.isBlank(o2.getDate())) {
          return -1;
        } else if (StringUtils.isBlank(o1.getDate()) && StringUtils.isNotBlank(o2.getDate())) {
          return 1;
        } else if (StringUtils.isBlank(o1.getDate()) && StringUtils.isBlank(o2.getDate())) {
          return 0;
        }
        return 0;
      }
    });

    return otherVos;
  }

  /**
   * 采集点根据订单采集和异常状态获取订单
   */
  public List<OrderDayGroupResult> acquisitionGetOrder(String acquisitionId, Integer orderStatus, Integer orderExceptionStatus, Integer serviceType, String queryParam, Integer orderDayNum) {

    AcquisitionGetDayPageOrderStatusParam param = new AcquisitionGetDayPageOrderStatusParam();
    List<Integer> serviceTypes = new ArrayList<>();
    serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
    serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    param.setServiceTypes(serviceTypes);
    param.setQueryParam(queryParam);
    param.setOrderStatus(orderStatus);
    if (orderExceptionStatus != null) {
      param.setOrderExceptionStatus(orderExceptionStatus);
    }
    param.setOrderDayNum(orderDayNum);
    param.setAcquisitionId(acquisitionId);
    return orderMapper.acquisitionGetOrderByStatus(param);
  }

  /**
   * 采集点将采集状态的订单按天分组
   */
  public List<OrderForDayAndTimeVo> acquisitionDeal2BaseOrderList(List<OrderDayGroupResult> resultList) {

    if (resultList == null) {
      return null;
    }

    //把查询的订单结果整理成带有时间和日期的vo对象
    List<OrderForDayAndTimeVo> dayAndTimeVos = new ArrayList<>();

    for (OrderDayGroupResult result : resultList) {
      OrderForDayAndTimeVo dayAndTimeVo = new OrderForDayAndTimeVo();
      dayAndTimeVo.setOrderNo(result.getOrderNo());
      dayAndTimeVo.setPackageName(result.getGoodName());
      dayAndTimeVo.setUserName(result.getUserName());
      dayAndTimeVo.setParticipantName(result.getParticipantName());
      dayAndTimeVo.setParticipantPhone(result.getParticipantPhone());
      dayAndTimeVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(result.getOrderApplyDate()));
      dayAndTimeVo.setOrderCurrentApplyDate(DateUtils.convertToSlashAndMinDate(result.getOrderApplyDate()));
      dayAndTimeVo.setAppointmentDate(DateUtils.dateToDay(result.getOrderApplyDate(), "/"));
      dayAndTimeVo.setAppointmentTime(DateUtils.dateToTime(result.getOrderApplyDate()));
      dayAndTimeVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(result.getOrderCompleteApplyDate()));
      dayAndTimeVos.add(dayAndTimeVo);
    }

    dayAndTimeVos.sort(new Comparator<OrderForDayAndTimeVo>() {
      //按日期排序
      @Override
      public int compare(OrderForDayAndTimeVo o1, OrderForDayAndTimeVo o2) {
        return o1.getOrderCurrentApplyDate().compareTo(o2.getOrderCurrentApplyDate());
      }
    });
    return dayAndTimeVos;
  }

  /**
   * 采集点将采集状态的订单不是按天分组
   */
  public List<OrderForGroupByDayVo> acquisitionDeal2BaseDayOrderList(List<OrderDayGroupResult> resultList) {

    if (resultList == null) {
      return null;
    }

    //订单数据分组
    List<OrderForGroupByDayVo> groupByDayVos = new ArrayList<>();
    Map<String, List<OrderDayGroupResult>> groupResultMap = resultList.stream().collect(Collectors.groupingBy(OrderDayGroupResult::getOrderday));

    //分类整合
    Iterator<Map.Entry<String, List<OrderDayGroupResult>>> it = groupResultMap.entrySet().iterator();
    while (it.hasNext()) {
      Map.Entry<String, List<OrderDayGroupResult>> entry = it.next();
      OrderForGroupByDayVo groupByDayVo = new OrderForGroupByDayVo();
      groupByDayVo.setDate(entry.getKey());
      List<OrderForDayAndTimeVo> baseVos = acquisitionDeal2BaseOrderList(entry.getValue());
      groupByDayVo.setDateDetailListc(baseVos);
      groupByDayVos.add(groupByDayVo);
    }

    //时间倒序
    groupByDayVos.sort(new Comparator<OrderForGroupByDayVo>() {
      @Override
      public int compare(OrderForGroupByDayVo o1, OrderForGroupByDayVo o2) {
        return -o1.getDate().compareTo(o2.getDate());
      }
    });

    return groupByDayVos;
  }

  /**
   * 采集点获取异常订单
   */
  public List<OrderForDayAndTimeVo> acquisitionGetOrderNotByGroup(String acquisitionId, List<Integer> serviceTypes, String queryParam, Integer limitNum) {

    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria criteria1 = orderExample.createCriteria();
    AppletOrderExample.Criteria criteria2 = orderExample.createCriteria();

    List<Integer> orderType = new ArrayList<>();
    orderType.add(OrderConstants.ORDER_TYPE_SELF);
    orderType.add(OrderConstants.ORDER_TYPE_RECEIVE);

    if (StringUtils.isNotBlank(acquisitionId)) {
      criteria1.andAcquisitionIdEqualTo(acquisitionId);
      criteria2.andAcquisitionIdEqualTo(acquisitionId);
    }

    List<Integer> refundStatus = new ArrayList<>();
    refundStatus.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    refundStatus.add(OrderConstants.ORDER_REFUND_STATUS_PAYING);

    List<Integer> exceptionStatus = new ArrayList<>();
    exceptionStatus.add(OrderConstants.ORDER_EXCEPTION_DEALING);
    exceptionStatus.add(OrderConstants.ORDER_EXCEPTION_ERROR);

    criteria1.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria1.andServiceTypeIn(serviceTypes);
    criteria1.andOrderTypeIn(orderType);
    criteria1.andRefundStatusIn(refundStatus);
    criteria1.andOrderApplyDateIsNotNull();
    criteria1.andOrderExceptionStatusIn(exceptionStatus);

    criteria2.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria2.andServiceTypeIn(serviceTypes);
    criteria2.andOrderTypeIn(orderType);
    criteria2.andRefundStatusIn(refundStatus);
    criteria2.andOrderApplyDateIsNotNull();
    criteria2.andOrderExceptionStatusIn(exceptionStatus);

    if (StringUtils.isNotBlank(queryParam)) {
      criteria1.andParticipantNameLike("%" + queryParam + "%");
      criteria2.andParticipantPhoneLike("%" + queryParam + "%");
    }

    orderExample.or(criteria2);
    //todo 分页有待优化
    PageHelper.startPage(1, limitNum);
    List<AppletOrder> orders = orderMapper.selectByExample(orderExample);
    PageInfo<AppletOrder> pageInfo = new PageInfo<>(orders);
    orders = pageInfo.getList();

    List<OrderForDayAndTimeVo> dayAndTimeVos = new ArrayList<>();

    for (AppletOrder order : orders) {
      OrderForDayAndTimeVo dayAndTimeVo = new OrderForDayAndTimeVo();
      dayAndTimeVo.setOrderNo(order.getOrderNo());
      dayAndTimeVo.setPackageName(order.getGoodName());
      dayAndTimeVo.setUserName(order.getUserName());
      dayAndTimeVo.setParticipantName(order.getParticipantName());
      dayAndTimeVo.setParticipantPhone(order.getParticipantPhone());
      dayAndTimeVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderApplyDate()));
      dayAndTimeVo.setAppointmentDate(DateUtils.dateToDay(order.getOrderApplyDate(), "/"));
      dayAndTimeVo.setAppointmentTime(DateUtils.dateToTime(order.getOrderApplyDate()));
      dayAndTimeVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
      dayAndTimeVos.add(dayAndTimeVo);
    }

    dayAndTimeVos.sort(new Comparator<OrderForDayAndTimeVo>() {
      //按日期排序
      @Override
      public int compare(OrderForDayAndTimeVo o1, OrderForDayAndTimeVo o2) {
        return -o1.getOrderApplyDate().compareTo(o2.getOrderApplyDate());
      }
    });
    return dayAndTimeVos;

  }

  /**
   * 添加了分页参数
   */
  public OrderForDayAndTimeWithTotalVo acquisitionGetOrderNotByGroupNew(String acquisitionId, List<Integer> serviceTypes, String queryParam, Integer limitNum) {
    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria criteria1 = orderExample.createCriteria();
    AppletOrderExample.Criteria criteria2 = orderExample.createCriteria();

    List<Integer> orderType = new ArrayList<>();
    orderType.add(OrderConstants.ORDER_TYPE_SELF);
    orderType.add(OrderConstants.ORDER_TYPE_RECEIVE);

    List<Integer> refundStatus = new ArrayList<>();
    refundStatus.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    refundStatus.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);

    if (StringUtils.isNotBlank(acquisitionId)) {
      criteria1.andAcquisitionIdEqualTo(acquisitionId);
      criteria2.andAcquisitionIdEqualTo(acquisitionId);
    }

    Date today = new Date();

    criteria1.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria1.andServiceTypeIn(serviceTypes);
    criteria1.andOrderTypeIn(orderType);
    criteria1.andRefundStatusEqualTo(CommonConstants.INIT);
    criteria1.andOrderApplyDateIsNotNull();
    criteria1.andOrderApplyDateBetween(DateUtils.getDateStartForThisDay(today), DateUtils.getDateEndForThisDay(today));
    criteria1.andRefundStatusIn(refundStatus);

    criteria2.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    criteria2.andServiceTypeIn(serviceTypes);
    criteria2.andOrderTypeIn(orderType);
    criteria2.andRefundStatusEqualTo(CommonConstants.INIT);
    criteria2.andOrderApplyDateIsNotNull();
    criteria2.andOrderApplyDateBetween(DateUtils.getDateStartForThisDay(today), DateUtils.getDateEndForThisDay(today));
    criteria2.andRefundStatusIn(refundStatus);

    if (StringUtils.isNotBlank(queryParam)) {
      criteria1.andParticipantNameLike("%" + queryParam + "%");
      criteria2.andParticipantPhoneLike("%" + queryParam + "%");
    }

    orderExample.or(criteria2);
    //todo 分页有待优化
    PageHelper.startPage(1, limitNum);
    List<AppletOrder> orders = orderMapper.selectByExample(orderExample);
    PageInfo<AppletOrder> pageInfo = new PageInfo<>(orders);
    orders = pageInfo.getList();

    List<OrderForDayAndTimeVo> dayAndTimeVos = new ArrayList<>();

    for (AppletOrder order : orders) {
      OrderForDayAndTimeVo dayAndTimeVo = new OrderForDayAndTimeVo();
      dayAndTimeVo.setOrderNo(order.getOrderNo());
      dayAndTimeVo.setPackageName(order.getGoodName());
      dayAndTimeVo.setUserName(order.getUserName());
      dayAndTimeVo.setParticipantName(order.getParticipantName());
      dayAndTimeVo.setParticipantPhone(order.getParticipantPhone());
      dayAndTimeVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderApplyDate()));
      dayAndTimeVo.setOrderCurrentApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderApplyDate()));
      dayAndTimeVo.setAppointmentDate(DateUtils.dateToDay(order.getOrderApplyDate(), "/"));
      dayAndTimeVo.setAppointmentTime(DateUtils.dateToTime(order.getOrderApplyDate()));
      dayAndTimeVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
      dayAndTimeVos.add(dayAndTimeVo);
    }

    dayAndTimeVos.sort(new Comparator<OrderForDayAndTimeVo>() {
      //按日期排序
      @Override
      public int compare(OrderForDayAndTimeVo o1, OrderForDayAndTimeVo o2) {
        return -o1.getOrderApplyDate().compareTo(o2.getOrderApplyDate());
      }
    });

    OrderForDayAndTimeWithTotalVo result = new OrderForDayAndTimeWithTotalVo();
    result.setDayAndTimeVoList(dayAndTimeVos);
    result.setTotal(pageInfo.getTotal());

    return result;
  }

  /**
   * 根据运单号获取订单
   */
  public List<OrderBaseVo> getOrderByLogisticsId(String logisticsId) {
    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
    orderExampleCriteria.andLogisticsIdEqualTo(logisticsId);
    orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    List<AppletOrder> orders = orderMapper.selectByExample(orderExample);
    List<OrderBaseVo> orderBaseVos = new ArrayList<>();
    for (AppletOrder order : orders) {
      OrderBaseVo orderBaseVo = new OrderBaseVo();
      orderBaseVo.setOrderNo(order.getOrderNo());
      orderBaseVo.setGoodName(order.getGoodName());
      orderBaseVo.setParticipantName(order.getParticipantName());
      orderBaseVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndDayDate(order.getOrderCompleteApplyDate()));
      orderBaseVos.add(orderBaseVo);
    }
    return orderBaseVos;
  }

  public List<AppletOrder> getTestingOrder(Integer orderNum) {
    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
    orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COLLECTED);
    orderExampleCriteria.andLogisticsStatusEqualTo(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
    if (orderNum == null) {
      orderNum = 50;
    }
    PageHelper.startPage(1, orderNum);
    List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
    PageInfo<AppletOrder> orderPageInfo = new PageInfo<>(orderList);
    return orderPageInfo.getList();
  }

  /**
   * 采集点取消订单
   */
  @Transactional
  public boolean cancelOrderByAcquisition(String orderNo, Integer reason) {

    //订单可以取消退款的条件
    //  订单状态    待采集
    //  订单支付状态 已支付
    //  订单服务方式 到院采集和上门采集
    //  订单核销状态 未核销（表示用户未到院采集）
    //  订单退款状态 未退款和部分退款完成
    //  订单物流状态 初始状态状态
    //  订单异常状态 正常或者异常
    //  订单取消状态 未取消
    //  订单删除状态 未删除

    int i = 0;

    //更新订单取消退款状态
    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
    orderExampleCriteria.andOrderNoEqualTo(orderNo);

    List<Integer> serviceTypeList = new ArrayList<>();
    serviceTypeList.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    serviceTypeList.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
    orderExampleCriteria.andServiceTypeIn(serviceTypeList);

    orderExampleCriteria.andWriteOffStatusEqualTo(CommonConstants.INIT);
    orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    orderExampleCriteria.andOrderCancelStatusEqualTo(CommonConstants.INIT);

    List<Integer> refundStatusList = new ArrayList<>();
    refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
    orderExampleCriteria.andRefundStatusIn(refundStatusList);

    List<Integer> exceptionList = new ArrayList<>();
    exceptionList.add(OrderConstants.ORDER_EXCEPTION_NORMAL);
    exceptionList.add(OrderConstants.ORDER_EXCEPTION_ERROR);
    orderExampleCriteria.andOrderExceptionStatusIn(exceptionList);

    AppletOrder order = new AppletOrder();

    order.setRefundStatus(OrderConstants.ORDER_REFUND_STATUS_PAYING);
    order.setRefundReason(OrderConstants.ORDER_REFUND_REASON_ACQUISITION);
    order.setUpdateDate(new Date());
    i = orderMapper.updateByExampleSelective(order, orderExample);
    if (i == 0) {
      throw new RuntimeException("设置订单取消退款中失败");
    }

    //商品可以取消退款的条件
    //  商品服务方式 到院采集和上门采集
    //  商品状态    未采集 异常
    //  商品异常状态 正常或者异常（订单显示正常，套餐异常）
    //  商品退款状态  未退款或者部分退款完成
    //  商品删除状态  未删除

    AppletGoodExample example = new AppletGoodExample();
    AppletGoodExample.Criteria criteria = example.createCriteria();

    criteria.andOrderNoEqualTo(orderNo);
    criteria.andServiceTypeIn(serviceTypeList);

    List<Integer> goodStatusList = new ArrayList<>();
    goodStatusList.add(GoodConstants.GOOD_STATUS_UNCOLLECT);
    criteria.andGoodStatusIn(goodStatusList);

    List<Integer> goodRefundStatusList = new ArrayList<>();
    goodRefundStatusList.add(GoodConstants.GOOD_REFUND_STATUS_UNPAY);
    goodRefundStatusList.add(GoodConstants.GOOD_REFUND_STATUS_PART_REFUNDED);
    orderExampleCriteria.andRefundStatusIn(goodRefundStatusList);

    criteria.andDelFlagEqualTo(CommonConstants.INIT);

    AppletGood updateGood = new AppletGood();
    updateGood.setUpdateDate(new Date());
    updateGood.setGoodStatus(GoodConstants.GOOD_STATUS_REFUNDING);
    updateGood.setExceptionStatus(GoodConstants.GOOD_EXCEPTION_STATUS_INIT);
    updateGood.setRefundStatus(GoodConstants.GOOD_REFUND_STATUS_PAYING);
    updateGood.setRefundReason(GoodConstants.GOOD_REFUND_REASON_ACQUISITION);
    i = goodMapper.updateByExampleSelective(updateGood, example);
    if (i == 0) {
      throw new RuntimeException("插入异常信息失败");
    }

    return true;
  }

  @Transactional
  public boolean sendSmsForOrder(String orderNo) {

    AppletOrder order = getOrderByOrderNo(orderNo);
    if (order == null) {
      logger.info(orderNo + " 订单不存在");
      return false;
    }
    if (order.getServiceType().equals(OrderConstants.ORDER_SERVICE_TYPE_SELF)) {
      Map<String, String> map = new HashMap<>();
      map.put("orderNo", orderNo);
      return SMSUtils.sendSms(order.getParticipantPhone(), map, SMSUtils.templateCodeSelfOrder);
    } else if (order.getServiceType().equals(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION)) {
      Map<String, String> map = new HashMap<>();
      map.put("date", DateUtils.dateToStringForOrder(order.getOrderApplyDate()));
      if (StringUtils.isNotBlank(order.getAcquisitionId())) {
        AppletAcquisition acquisition = acquisitionService.getAcquisitionByAcquisitionId(order.getAcquisitionId());
        if (StringUtils.isNotBlank(acquisition.getAcquisitionAddress())) {
          map.put("address", acquisition.getAcquisitionName());
        } else {
          map.put("address", order.getAcquisitionName());
        }
      } else {
        map.put("address", order.getAcquisitionName());
      }
      return SMSUtils.sendSms(order.getParticipantPhone(), map, SMSUtils.templateCodeApplyOrder);
    } else {
      //暂时没有该项服务不需要去发送短信
      return true;
    }

  }

  @Transactional
  public boolean verifyOrder(List<String> orderNoList, String staffId) {

    //判断员工是否符合资质
    AppletAcquisitionStaff staff = staffService.getStaffByStaffIdOrDoctorId(staffId);
    AppletDoctor doctor = doctorService.getDoctorByDoctorId(staffId);
    if (staff != null) {
      if (staff.getStaffType().equals(CommonConstants.USER_ROLE_ACQUISITION_DOCTOR_AND_STAFF) ||
          staff.getStaffType().equals(CommonConstants.USER_ROLE_ACQUISITION_DOCTOR) ||
          staff.getStaffType().equals(CommonConstants.USER_ROLE_ACQUISITION_ALL) ||
          staff.getStaffType().equals(CommonConstants.USER_ROLE_VERIFY_DEFAULT) ||
          StringUtils.isNotBlank(staff.getDoctorId())) {
        logger.info("确认开单员工" + staffId + "员工类型" + staff.getStaffType());
      } else {
        logger.info("确认开单的员工不符合开单要求" + staffId + "用户类型" + staff.getStaffType());
        throw new RuntimeException("确认开单的员工不符合开单要求");
      }
    } else {
      if (doctor != null) {
        logger.info("确认开单医生" + staffId);
      } else {
        logger.info("确认开单的医生不存在或者不符合开单资质" + staffId);
        throw new RuntimeException("确认开单的医生不存在" + staffId);
      }
    }

    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
    if (orderNoList != null && orderNoList.size() != 0) {
      orderExampleCriteria.andOrderNoIn(orderNoList);
    }
//        orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    //支付回调可能未回调
//        orderExampleCriteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
//        orderExampleCriteria.andWriteOffStatusEqualTo(OrderConstants.WRITE_OFF_STATUS_UNFINISH);
//        orderExampleCriteria.andVerifyStatusEqualTo(CommonConstants.INIT);
//        orderExampleCriteria.andOrderCancelStatusEqualTo(CommonConstants.INIT);
//        orderExampleCriteria.andOrderExceptionStatusEqualTo(OrderConstants.ORDER_EXCEPTION_NORMAL);
//        List<Integer> refundStatusList = new ArrayList<>();
//        refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
//        refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
//        orderExampleCriteria.andRefundStatusIn(refundStatusList);
//        List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
//        if (orderList==null||(orderList.size()!=1)){
//            throw new RuntimeException(orderNoList+"订单列表内容不符合审核条件");
//        }

    logger.info("订单编号" + orderNoList);

    AppletOrder checkOrder = new AppletOrder();
    AppletOrder updateObj = new AppletOrder();

    for (String orderNo : orderNoList) {
      //检查订单是否存在
      checkOrder = getOrderByOrderNo(orderNo);
      if (checkOrder != null) {
        if (StringUtils.isBlank(checkOrder.getImRecommendListId())) {
          //如果订单不存在推荐单，自主开单，采集点医生开单确认解读
          String staffId2 = "";
          String auditorId = "";
          String staffName = "";
          String staffPhone = "";
          String interpretStaffId = "";
          if (staff != null && StringUtils.isNotBlank(staff.getDoctorId())) {
            //如果医生数据存在关联，则存放医生的ID
            staffId2 = staff.getDoctorId();
            auditorId = staff.getDoctorId();
            staffName = staff.getStaffName();
            staffPhone = staff.getStaffPhone();
            interpretStaffId = staff.getDoctorId();

            //更新商品表中的医生ID
            AppletGoodExample goodExample = new AppletGoodExample();
            AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
            goodExampleCriteria.andOrderNoEqualTo(checkOrder.getOrderNo());

            AppletGood updateGood = new AppletGood();
            updateGood.setUpdateDate(new Date());
            updateGood.setStaffId(staff.getDoctorId());
            updateGood.setStaffName(staff.getStaffName());
            updateGood.setStaffPhone(staff.getStaffPhone());
            updateGood.setDoctorName(staff.getStaffName());
            updateGood.setDoctorPhone(staff.getStaffPhone());
            int j = goodMapper.updateByExampleSelective(updateGood, goodExample);
            logger.info("商品更新次数" + j);
          } else {
            if (staff != null) {
              auditorId = staff.getStaffId();
              staffId2 = defaultTclabDoctorId;
              staffName = defaultTclabDoctorName;
              staffPhone = defaultTclabDoctorPhone;
              interpretStaffId = defaultTclabDoctorId;
            } else if (doctor != null) {
              staffId2 = doctor.getDoctorId();
              auditorId = doctor.getDoctorId();
              staffName = doctor.getDoctorName();
              staffPhone = doctor.getDoctorPhone();
              interpretStaffId = doctor.getDoctorId();
            }
          }
          updateObj.setAuditorId(auditorId);
          updateObj.setStaffId(staffId2);
          updateObj.setStaffName(staffName);
          updateObj.setStaffPhone(staffPhone);
          updateObj.setInterpretStaffId(interpretStaffId);
          updateObj.setVerifyDate(new Date());
          updateObj.setVerifyStatus(CommonConstants.ENABLE);
          updateObj.setUpdateDate(new Date());
          int i = orderMapper.updateByExampleSelective(updateObj, orderExample);
          if (i == 0) {
            throw new RuntimeException(orderNoList + "订单列表审核失败");
          }
          //*********更新IM相关操作***************
          AppletOrderParticipant participant = participantService.getParticipantByParticipantId(checkOrder.getParticipantId());
          updateIm(checkOrder, staffId2, participant);
          //发送im聊天信息
          Map<String, Object> msgType = new HashMap<>();
          msgType.put("MsgType", "TIMTextElem");
          Map<String, Object> data = new HashMap<>();
          data.put("Text", "您已确认患者的检验项目");
          msgType.put("MsgContent", data);
          List<Map<String, Object>> list = new ArrayList<>();
          list.add(msgType);
          WxTencentUtils.sendImMessage(staffId2, participant.getUserId(), list);
        } else {
          AppletOrderParticipant participant = participantService.getParticipantByParticipantId(checkOrder.getParticipantId());
          updateIm(checkOrder, checkOrder.getInterpretStaffId(), participant);
        }
      } else {
        //如果订单有推荐单，说明订单已开单确认过

      }
    }

//        AppletOrder updateObj = new AppletOrder();
//        updateObj.setVerifyStatus(CommonConstants.ENABLE);
//        if (StringUtils.isNotBlank(staff.getDoctorId())) {
//            updateObj.setAuditorId(staff.getDoctorId());
//            updateObj.setStaffId(staff.getDoctorId());
//        } else {
//            updateObj.setAuditorId(staffId);
//        }
//        updateObj.setUpdateDate(new Date());
//        int i = orderMapper.updateByExampleSelective(updateObj,orderExample);
//        if (i==0){
//            throw new RuntimeException(orderNoList+"订单列表审核失败");
//        }

//        AppletOrderExample orderExampleNew = new AppletOrderExample();
//        AppletOrderExample.Criteria orderExampleCriteriaNew = orderExampleNew.createCriteria();
//        AppletOrder updateObjNew = new AppletOrder();
//
//        for (String orderNo:orderNoList) {
//            AppletOrder order = orderService.getOrderByOrderNo(orderNo);
//            if (order != null){
//                if (order!=null&&StringUtils.isBlank(order.getImRecommendListId())){
//                    //如果推荐单ID为空，表示订单是线上订单，由采集点开单医生来检测报告
//                    orderExample.clear();
//                    orderExampleCriteria = orderExample.createCriteria();
//                    orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
//                    orderExampleCriteria.andOrderNoEqualTo(orderNo);
//                    updateObj.setInterpretStaffId();
//                }
//            }
//        }

    return true;
  }

  private void updateIm(AppletOrder order, String staffId, AppletOrderParticipant participant) {
    //支付成功后同时预生成解读的商品记录和解读记录
    String interpretId = "";
    AppletImRecord appletImRecord = imRecordService.getOrInsertImRecord(participant, staffId);
    AppletInterpretExample interpretExample = new AppletInterpretExample();
    AppletInterpretExample.Criteria interpretExampleCriteria = interpretExample.createCriteria();
    interpretExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    interpretExampleCriteria.andImRecordIdEqualTo(appletImRecord.getImRecordId());
    List<AppletInterpret> appletInterpretList = interpretMapper.selectByExample(interpretExample);
    if (appletInterpretList != null && appletInterpretList.size() > 0) {
      interpretId = appletInterpretList.get(0).getInterpretId();
    } else {
      interpretId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_INTERPRET);
      AppletInterpret insertInterpret = new AppletInterpret();
      insertInterpret.setImRecordId(appletImRecord.getImRecordId());
      insertInterpret.setCreateDate(new Date());
      insertInterpret.setUpdateDate(new Date());
      insertInterpret.setDelFlag(CommonConstants.INIT);
      insertInterpret.setDoctorId(staffId);
      insertInterpret.setInterpretId(interpretId);
      insertInterpret.setInterpretStatus(0);
      String imrecommendListId = order.getImRecommendListId();
      if (StringUtils.isNotBlank(imrecommendListId)) {
        insertInterpret.setInterpretType(IMConstants.IM_INTERPRET_TYPE_SELF);
      } else {
        if (StringUtils.isNotBlank(order.getInterpretStaffId()) && order.getStaffPhone().equals(defaultDoctorPhone)) {
//                    insertInterpret.setInterpretType(IMConstants.IM_INTERPRET_TYPE_DEFAULT);
          //默认解读有默认解读的医生，不属于单独的类型
          insertInterpret.setInterpretType(IM_INTERPRET_TYPE_OTHER);
        } else {
          insertInterpret.setInterpretType(IM_INTERPRET_TYPE_OTHER);
        }
      }
      insertInterpret.setParticipantId(participant.getParticipantId());
      insertInterpret.setParticipantName(participant.getParticipantName());
      insertInterpret.setParticipantPhone(participant.getParticipantPhone());
      int i = interpretMapper.insertSelective(insertInterpret);
      if (i == 0) {
        logger.error("插入IM初始化解读目录失败");
        throw new RuntimeException("插入IM初始化解读目录失败");
      }
    }
    AppletGoodExample goodExample1 = new AppletGoodExample();
    AppletGoodExample.Criteria goodExample1Criteria = goodExample1.createCriteria();
    goodExample1Criteria.andDelFlagEqualTo(CommonConstants.INIT);
    goodExample1Criteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_UNCOLLECT);
    goodExample1Criteria.andOrderNoEqualTo(order.getOrderNo());
    List<AppletGood> appletGoodList = goodMapper.selectByExample(goodExample1);
    for (AppletGood appletGood : appletGoodList) {
      AppletInterpretGood interpretGood = new AppletInterpretGood();
      interpretGood.setInterpretId(interpretId);
      interpretGood.setGoodNo(appletGood.getGoodNo());
      interpretGood.setPackageId(appletGood.getPackageId());
      interpretGood.setPackageName(appletGood.getPackageName());
      interpretGood.setPackageNum(appletGood.getPackageNum());
      interpretGood.setCreateDate(new Date());
      interpretGood.setUpdateDate(new Date());
      interpretGood.setDelFlag(CommonConstants.INIT);
      interpretGood.setStatus(0);
      int insert = interpretGoodMapper.insert(interpretGood);
      if (insert == 0) {
        throw new RuntimeException("插入IM初始化解读目录失败");
      }
    }
  }

  @Transactional
  public boolean inquiryVerifyOrder(List<String> orderNoList, String staffId) {

    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();

    logger.info("订单编号" + orderNoList);

    if (orderNoList != null && orderNoList.size() != 0) {
      orderExampleCriteria.andOrderNoIn(orderNoList);
    }
//        orderExampleCriteria.andVerifyStatusEqualTo(CommonConstants.INIT);
    AppletOrder updateObj = new AppletOrder();
    updateObj.setVerifyStatus(CommonConstants.ENABLE);
    updateObj.setAuditorId(staffId);
    updateObj.setUpdateDate(new Date());
    int i = orderMapper.updateByExampleSelective(updateObj, orderExample);
    if (i == 0) {
      throw new RuntimeException(orderNoList + "订单列表审核失败");
    }
    return true;
  }

  public List<AppletOrder> unVerifyOrderList(String acquisitionId, Integer verifyStatus, String queryParam) {
    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
    AppletOrderExample.Criteria orderExampleCriteria2 = orderExample.createCriteria();

    orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    orderExampleCriteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    orderExampleCriteria2.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
    orderExampleCriteria2.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);

    orderExampleCriteria.andOrderCancelStatusEqualTo(CommonConstants.INIT);
    orderExampleCriteria2.andOrderCancelStatusEqualTo(CommonConstants.INIT);

    List<Integer> refundStatusList = new ArrayList<>();
    refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
    orderExampleCriteria.andRefundStatusIn(refundStatusList);
    orderExampleCriteria2.andRefundStatusIn(refundStatusList);

    orderExampleCriteria.andAcquisitionIdEqualTo(acquisitionId);
    orderExampleCriteria2.andAcquisitionIdEqualTo(acquisitionId);
    orderExampleCriteria.andServiceTypeEqualTo(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    orderExampleCriteria2.andServiceTypeEqualTo(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    if (StringUtils.isNotBlank(queryParam)) {
      orderExampleCriteria.andParticipantNameLike("%" + queryParam + "%");
      orderExampleCriteria2.andParticipantPhoneLike("%" + queryParam + "%");
    }

    if (verifyStatus != null) {
      orderExampleCriteria.andVerifyStatusEqualTo(verifyStatus);
      orderExampleCriteria2.andVerifyStatusEqualTo(verifyStatus);
    }

    orderExample.or(orderExampleCriteria2);
    List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
    return orderList;
  }

  public PageInfo<AppletOrder> verifyedOrderList(String acquisitionId, Integer verifyStatus, String queryParam, Integer pageNo, Integer pageSize) {
    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
    AppletOrderExample.Criteria orderExampleCriteria2 = orderExample.createCriteria();
    orderExampleCriteria.andAcquisitionIdEqualTo(acquisitionId);
    orderExampleCriteria2.andAcquisitionIdEqualTo(acquisitionId);
    orderExampleCriteria.andServiceTypeEqualTo(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    orderExampleCriteria2.andServiceTypeEqualTo(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    if (StringUtils.isNotBlank(queryParam)) {
      orderExampleCriteria.andParticipantNameLike("%" + queryParam + "%");
      orderExampleCriteria2.andParticipantPhoneLike("%" + queryParam + "%");
    }

    if (verifyStatus != null) {
      orderExampleCriteria.andVerifyStatusEqualTo(verifyStatus);
      orderExampleCriteria2.andVerifyStatusEqualTo(verifyStatus);
    }

    orderExample.or(orderExampleCriteria2);
    PageHelper.startPage(pageNo, pageSize);
    List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
    PageInfo<AppletOrder> orderPageInfo = new PageInfo<>(orderList);
    return orderPageInfo;
  }


  public List<InvoiceOrderListVo> getInvoiceOrderByStatus(String userId, Integer invoiceStatus, String dateForMonth, String invoiceApplyId) {

    logger.info("根据开票状态" + invoiceStatus + "查询用户" + userId + "的订单");

    InvoiceQueryParam param = new InvoiceQueryParam();
    if (StringUtils.isNotBlank(dateForMonth)) {
      param.setDateForMonth(dateForMonth);
    }
    if (StringUtils.isNotBlank(userId)) {
      param.setUserId(userId);
    }
    if (invoiceStatus != null) {
      param.setInvoiceStatus(invoiceStatus);
    }
    if (StringUtils.isNotBlank(invoiceApplyId)) {
      param.setInvoiceApplyId(invoiceApplyId);
    }

    List<InvoiceOrderListVo> listVoList = orderMapper.selectByInvoiceStatus(param);

    logger.info("根据开票状态" + invoiceStatus + "查询用户" + userId + "的订单的结果长度" + listVoList.size());

    return listVoList;
  }

  public List<InvoiceOrderListVo> getInvoiceOrderByStatusAndDate(String userId, Integer invoiceStatus, String dateStart, String dateEnd) {

    logger.info("根据开票状态" + invoiceStatus + "查询用户" + userId + "的订单");

    Date startDate = DateUtils.convertToMonthDate(dateStart);
    Date endDate = DateUtils.convertToMonthDate(dateEnd);
    endDate = DateUtils.getDateForNextMonth(endDate);

    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    List<Integer> refundStatusList = new ArrayList<>();
    refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    refundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
    criteria.andRefundStatusIn(refundStatusList);
    List<Integer> orderStatusList = new ArrayList<>();
    orderStatusList.add(OrderConstants.ORDER_STATUS_COLLECTED);
    orderStatusList.add(OrderConstants.ORDER_STATUS_COMPLETED);
    criteria.andOrderStatusIn(orderStatusList);
    if (StringUtils.isNotBlank(userId)) {
      criteria.andUserIdEqualTo(userId);
    }
    if (invoiceStatus != null) {
      criteria.andInvoiceStatusEqualTo(invoiceStatus);
    }
    if (startDate != null) {
      criteria.andPayDateGreaterThanOrEqualTo(startDate);
    }
    if (endDate != null) {
      criteria.andPayDateLessThan(endDate);
    }

    List<AppletOrder> orderList = orderMapper.selectByExample(example);
    List<InvoiceOrderListVo> listVoList = new ArrayList<>();

    for (AppletOrder order : orderList) {
      InvoiceOrderListVo invoiceOrderListVo = new InvoiceOrderListVo();
      BeanUtils.copyProperties(order, invoiceOrderListVo);
      invoiceOrderListVo.setPayDate(DateUtils.convertToSlashAndMonthStr(order.getPayDate()));
      listVoList.add(invoiceOrderListVo);
    }

    logger.info("根据开票状态" + invoiceStatus + "查询用户" + userId + "的订单的结果长度" + listVoList.size());

    return listVoList;
  }

  public List<AppletOrder> getOrderByInvoiceNotBySql(String applyId) {

    logger.info("根据开票工单" + applyId + "查询工单包含订单");

    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(applyId)) {
      criteria.andInvoiceApplyIdEqualTo(applyId);
    }
    List<Integer> invoiceStatusList = new ArrayList<>();
    invoiceStatusList.add(CommonConstants.PEND);
    invoiceStatusList.add(CommonConstants.ENABLE);
    criteria.andInvoiceStatusIn(invoiceStatusList);
    List<AppletOrder> orderList = orderMapper.selectByExample(example);

    logger.info("根据开票工单" + applyId + "查询工单包含订单" + orderList.size());

    return orderList;
  }

  public List<AppletOrder> getOrderByInterpretStatus(String userId, Integer interpretStatus) {

    logger.info("根据解读状态查询用户订单" + userId);

    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    criteria.andRefundStatusEqualTo(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
    List<Integer> orderStatusList = new ArrayList<>();
    orderStatusList.add(OrderConstants.ORDER_STATUS_COLLECTED);
    orderStatusList.add(OrderConstants.ORDER_STATUS_COMPLETED);
//    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COMPLETED);
    criteria.andOrderStatusIn(orderStatusList);
    if (StringUtils.isNotBlank(userId)) {
      criteria.andUserIdEqualTo(userId);
    }
    if (interpretStatus != null) {
      criteria.andInterpretStatusEqualTo(interpretStatus);
    }
    List<AppletOrder> orderList = orderMapper.selectByExample(example);

    return orderList;
  }


}
