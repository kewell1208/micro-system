package com.tclab.weixinappletservice.service.clientService;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.AcquisitionConstants;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.GoodConstants;
import com.tclab.weixinappletcommon.constant.LogisticsConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.constant.SampleTypeEnum;
import com.tclab.weixinappletcommon.utils.CommonHttpClientUtils;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.FileUtils;
import com.tclab.weixinappletcommon.utils.IDCardUtils;
import com.tclab.weixinappletcommon.utils.WxTencentUtils;
import com.tclab.weixinappletservice.dao.AppletDoctorMapper;
import com.tclab.weixinappletservice.dao.AppletGoodMapper;
import com.tclab.weixinappletservice.dao.AppletImRecordMapper;
import com.tclab.weixinappletservice.dao.AppletInterpretGoodMapper;
import com.tclab.weixinappletservice.dao.AppletInterpretMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.dao.AppletPackageMapper;
import com.tclab.weixinappletservice.model.query.GoodStaffParam;
import com.tclab.weixinappletservice.model.query.QueryDoctorRecommendNumParam;
import com.tclab.weixinappletservice.model.query.QueryNoParam;
import com.tclab.weixinappletservice.model.result.DoctorRecommendResult;
import com.tclab.weixinappletservice.model.result.GoodExtendBaseVo;
import com.tclab.weixinappletservice.model.result.GoodInfoByNoResult;
import com.tclab.weixinappletservice.model.result.ShulanParticipantListVo;
import com.tclab.weixinappletservice.model.result.ShulanRecommendListNewVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.GoodBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ReportBaseResultVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ReportBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ReportListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ShulanRecommendListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.StaffRecommendGoodVo;
import com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo.ThirdResponseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo.ThirdSampleInfoVo;
import com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo.UploadReport;
import com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo.UploadReportReturn;
import com.tclab.weixinappletservice.pojo.AppletAcquisition;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionStaff;
import com.tclab.weixinappletservice.pojo.AppletDoctor;
import com.tclab.weixinappletservice.pojo.AppletDoctorExample;
import com.tclab.weixinappletservice.pojo.AppletGood;
import com.tclab.weixinappletservice.pojo.AppletGoodExample;
import com.tclab.weixinappletservice.pojo.AppletInterpretGood;
import com.tclab.weixinappletservice.pojo.AppletInterpretGoodExample;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.pojo.AppletPackageExample;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GoodService {

  @Autowired
  private AppletGoodMapper goodMapper;
  @Autowired
  private AppletOrderMapper orderMapper;
  @Autowired
  private PackageService packageService;
  @Autowired
  private MessageService messageService;
  @Autowired
  private OrderService orderService;
  @Autowired
  private AcquisitionService acquisitionService;
  @Autowired
  private StaffService staffService;
  @Autowired
  private ParticipantService participantService;
  @Autowired
  private ImRecordService recordService;
  @Autowired
  private AppletInterpretMapper interpretMapper;
  @Autowired
  private AppletDoctorMapper appletDoctorMapper;
  @Autowired
  private AppletImRecordMapper appletImRecordMapper;
  @Autowired
  private ImRecommendListService recommendListService;
  @Autowired
  private AppletPackageMapper packageMapper;
  @Autowired
  private ImRecordService imRecordService;
  @Autowired
  private AppletInterpretGoodMapper appletInterpretGoodMapper;


  private static final Logger logger = LoggerFactory.getLogger(GoodService.class);

  /**
   * 根据订单号或者商品号来查询基本商品信息
   */
  public List<GoodInfoByNoResult> getGoodPackageByNo(String orderNo, String goodNo) {
    QueryNoParam param = new QueryNoParam();
    if (StringUtils.isNotBlank(goodNo)) {
      param.setGoodNo(goodNo);
    }
    if (StringUtils.isNotBlank(orderNo)) {
      param.setOrderNo(orderNo);
    }
    return goodMapper.selectGoodPackageByNo(param);
  }

  /**
   * 根据商品id来获得完整商品数据
   */
  public AppletGood getGoodByGoodNo(String goodNo, Integer delFlag) {
    AppletGoodExample example = new AppletGoodExample();
    AppletGoodExample.Criteria criteria = example.createCriteria();
    criteria.andGoodNoEqualTo(goodNo);
    if (delFlag != null) {
      if (delFlag.equals(CommonConstants.INIT)) {
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
      } else {
        criteria.andDelFlagEqualTo(CommonConstants.ENABLE);
      }
    }
    List<AppletGood> goods = goodMapper.selectByExample(example);
    if (goods.size() != 0) {
      return goods.get(0);
    }
    return null;
  }

  @Value("${third.saveMobileSampleInfoToThird.url}")
  private String saveMobileSampleInfoToThirdUrl;
  @Value("${third.revokeMobileSampleInfoToThird.url}")
  private String revokeMobileSampleInfoToThirdUrl;
  @Value("${third.customerId}")
  private String thirdCustomerId;

  /**
   * 绑定条码 可以重新绑定条码
   */
  @Transactional
  public boolean bindBarcode(String orderNo, String goodNo, String barcode, String collectorStaffId) {

    //判断条码是否重复
    AppletGoodExample exampleForCheck = new AppletGoodExample();
    AppletGoodExample.Criteria criteriaForCheck = exampleForCheck.createCriteria();
    criteriaForCheck.andSampleNoEqualTo(barcode);
    List<AppletGood> goodListForCheck = goodMapper.selectByExample(exampleForCheck);
    if (goodListForCheck.size() != 0) {
      logger.info("商品条码重复 商品号: " + goodNo + " 样本码: " + barcode);
      throw new RuntimeException("商品条码重复 商品号: " + goodNo + " 样本码: " + barcode);
    }

    //判断套餐是否可以绑定条码

    //订单可以绑定的条件
    //  订单状态    待采集 已采集
    //  订单支付状态 已支付
    //  订单服务方式 到院采集和上门采集
    //  订单核销状态 未核销（表示用户未到院采集）和核销中（表示订单有多个商品，某些套餐已绑定条码）核销完成
    //  订单退款状态 未退款和部分退款完成
    //  订单物流状态 初始状态状态 或者发起同创物流
    //  订单异常状态 正常
    //  订单取消状态 未取消
    //  订单删除状态 未删除
    //商品的绑定条件
    //  商品服务方式 到院采集和上门采集
    //  商品状态    未采集 已采集 异常
    //  商品异常状态 正常或者异常（订单显示正常，套餐异常）或者已经解决完成
    //  商品退款状态  未退款或者部分退款完成
    //  商品删除状态  未删除

    QueryNoParam param = new QueryNoParam();
    param.setOrderNo(orderNo);
    param.setGoodNo(goodNo);
    List<AppletGood> goodList = goodMapper.checkBindGood(param);
    if (goodList == null || goodList.size() == 0) {
      logger.info("套餐 " + goodNo + " 条码不符合绑定要求");
      throw new RuntimeException("套餐 " + goodNo + " 条码不符合绑定要求");
    }

    AppletGood queryGood = goodList.get(0);
    String originalBarcode = null;
    boolean checkBarcodeExisted = false;
    if (StringUtils.isBlank(queryGood.getSampleNo())) {
      checkBarcodeExisted = false;
    } else {
      checkBarcodeExisted = true;
      originalBarcode = queryGood.getSampleNo();
    }

    //商品的绑定完成后的状态设置
    //  商品状态    已采集
    //  商品异常状态 正常

    AppletGoodExample example = new AppletGoodExample();
    AppletGoodExample.Criteria criteria = example.createCriteria();

    criteria.andOrderNoEqualTo(orderNo);
    criteria.andGoodNoEqualTo(goodNo);

    List<Integer> serviceTypeList = new ArrayList<>();
    serviceTypeList.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
    serviceTypeList.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
    criteria.andServiceTypeIn(serviceTypeList);

    List<Integer> goodStatusList = new ArrayList<>();
    goodStatusList.add(GoodConstants.GOOD_STATUS_UNCOLLECT);
    goodStatusList.add(GoodConstants.GOOD_STATUS_COLLECTED);
    criteria.andGoodStatusIn(goodStatusList);

    List<Integer> refundStatusList = new ArrayList<>();
    refundStatusList.add(GoodConstants.GOOD_REFUND_STATUS_UNPAY);
    refundStatusList.add(GoodConstants.GOOD_REFUND_STATUS_PART_REFUNDED);
    criteria.andRefundStatusIn(refundStatusList);

    criteria.andDelFlagEqualTo(CommonConstants.INIT);

    AppletGood good = new AppletGood();
    good.setUpdateDate(new Date());
    good.setSampleNo(barcode);
    good.setSampleCollectDate(new Date());
    good.setGoodCompleteApplyDate(new Date());
    good.setGoodStatus(GoodConstants.GOOD_STATUS_COLLECTED);
    good.setExceptionStatus(GoodConstants.GOOD_EXCEPTION_STATUS_INIT);
    good.setCollectorStaffId(collectorStaffId);
    int result = goodMapper.updateByExampleSelective(good, example);
    if (result == 0) {
      logger.info("套餐 " + goodNo + " 绑定条码失败 条码号: " + barcode);
      throw new RuntimeException("套餐 " + goodNo + " 绑定条码失败 条码号: " + barcode);
    }

    //查询订单下是否还存在未绑定条码的套餐
    //  如果不存在 表示订单已完成核销，采集完成
    //      订单状态    已采集
    //      订单核销状态  已核销
    //      订单异常状态  正常（订单不会有异常状态了）
    //      订单完成预约时间
    //      订单核销时间
    //  如果依然存在 表示订单未完成核销，订单待采集
    //      订单状态    待采集
    //      订单核销状态 核销中

    example.clear();
    criteria = example.createCriteria();
    criteria.andOrderNoEqualTo(orderNo);
    criteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_UNCOLLECT);
    criteria.andRefundStatusIn(refundStatusList);
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    int num = goodMapper.selectByExample(example).size();

    if (num == 0) {

      AppletOrderExample orderExample = new AppletOrderExample();
      AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
      orderExampleCriteria.andOrderNoEqualTo(orderNo);
      AppletOrder order = new AppletOrder();
      order.setOrderStatus(OrderConstants.ORDER_STATUS_COLLECTED);
      order.setWriteOffStatus(OrderConstants.WRITE_OFF_STATUS_FINISHED);
      order.setOrderExceptionStatus(OrderConstants.ORDER_EXCEPTION_NORMAL);
      order.setWriteOffDate(new Date());
      order.setOrderCompleteApplyDate(new Date());
      order.setUpdateDate(new Date());
      result = orderMapper.updateByExampleSelective(order, orderExample);
      if (result == 0) {
        logger.info("采集点绑定条码: " + "orderNo: " + orderNo + "更新订单核销完成失败");
        throw new RuntimeException("采集点绑定条码: " + "orderNo: " + orderNo + "更新订单核销完成失败");
      }
      //处理树兰检验科套餐
      receiveUnLogisticsPackage(orderNo);
      logger.info("采集点绑定条码: " + "orderNo: " + orderNo + "更新订单核销完成成功");
    } else {
      AppletOrderExample orderExample = new AppletOrderExample();
      AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
      orderExampleCriteria.andOrderNoEqualTo(orderNo);
      AppletOrder order = new AppletOrder();
      order.setOrderStatus(OrderConstants.ORDER_STATUS_UNCOLLECT);
      order.setWriteOffStatus(OrderConstants.WRITE_OFF_STATUS_DEALING);
      order.setUpdateDate(new Date());
      int a = orderMapper.updateByExampleSelective(order, orderExample);
      if (a == 0) {
        logger.info("采集点绑定条码: " + "orderNo: " + orderNo + "更新订单核销中失败");
        throw new RuntimeException("采集点绑定条码: " + "orderNo: " + orderNo + "更新订单核销中失败");
      }
      logger.info("采集点绑定条码: " + "orderNo: " + orderNo + "更新订单核销中成功");
    }

    //对接第三方确认
    if (checkBarcodeExisted) {
      String revokeResult = CommonHttpClientUtils.postMethodClient(revokeMobileSampleInfoToThirdUrl + "?barcode=" + originalBarcode + "&" + "customerId=" + thirdCustomerId);
      logger.info("通知第三方删除原始条码号" + originalBarcode + "返回结果" + revokeResult);
      try {
        if (StringUtils.isNotBlank(revokeResult)) {
          ThirdResponseVo thirdResponseVo = JSON.parseObject(revokeResult, ThirdResponseVo.class);
          if (thirdResponseVo.getState() != null && thirdResponseVo.getState().equals(1)) {
            //正常返回结果
          } else {
            //其余情况都是异常返回
            logger.info("条码号" + barcode + "通知第三方删除条码失败");
            throw new RuntimeException("通知第三方删除条码失败");
          }
        }
      } catch (Exception e) {
        logger.info("条码号" + barcode + "通知第三方删除条码返回结果转换异常");
        throw new RuntimeException("通知第三方删除条码返回结果转换异常");
      }
    }

    //确认第三方
    notifySaveMobileSampleInfoToThird(queryGood, barcode, collectorStaffId);

    return true;

//        //查询订单是否可以绑定
//        AppletOrderExample orderExample = new AppletOrderExample();
//        AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
//        orderExampleCriteria.andOrderNoEqualTo(orderNo);
//        //绑定条码的条件1:订单未删除
//        orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
//        //绑定条码的条件2:订单未采集 已采集
//        //由于出现了可重复绑定的功能所以订单不一定是未采集,订单已采集也可以,可以重复绑定
//        List<Integer> orderStatusList = new ArrayList<>();
//        orderStatusList.add(OrderConstants.ORDER_STATUS_UNCOLLECT);
//        orderStatusList.add(OrderConstants.ORDER_STATUS_COLLECTED);
////        orderExampleCriteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_UNCOLLECT);
//        orderExampleCriteria.andOrderStatusIn(orderStatusList);
//        //绑定条码的条件3:订单服务方式到院采集和上门采集的,绑定条码只接受采集点的服务方式
//        List<Integer> serviceTypes = new ArrayList<>();
//        serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);
//        serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
//        orderExampleCriteria.andServiceTypeIn(serviceTypes);
//        //绑定条码的条件4:订单可以异常,其中某个套餐异常订单显示异常也可以绑定条码
////        orderExampleCriteria.andOrderExceptionStatusEqualTo(CommonConstants.INIT);
//        //绑定条码的条件5:订单未核销 核销完成即采集
//        //如果一笔订单已经完成核销了或者核销中 还可以绑定条码
////        List<Integer> writeOffStatusList = new ArrayList<>();
////        writeOffStatusList.add(OrderConstants.WRITE_OFF_STATUS_DEALING);
////        writeOffStatusList.add(OrderConstants.WRITE_OFF_STATUS_UNFINISH);
////        writeOffStatusList.add(OrderConstants.WRITE_OFF_STATUS_UNFINISH);
////        orderExampleCriteria.andWriteOffStatusIn(writeOffStatusList);
////        orderExampleCriteria.andWriteOffStatusEqualTo(CommonConstants.INIT);
//        //绑定条码的条件6:订单已审核
//        //现在核销订单不需要审核操作
//        //orderExampleCriteria.andVerifyStatusEqualTo(CommonConstants.ENABLE);
//        //绑定条码的条件7:订单未取消
//        orderExampleCriteria.andOrderCancelStatusEqualTo(CommonConstants.INIT);
//        //绑定条码的条件10:订单已付款
//        orderExampleCriteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
//        //绑定条码的条件8:订单未退款或者已部分退款
//        List<Integer> orderRefundStatusList = new ArrayList<>();
//        orderRefundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_PART_REFUNDED);
//        orderRefundStatusList.add(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
//        orderExampleCriteria.andRefundStatusIn(orderRefundStatusList);
////        orderExampleCriteria.andRefundStatusEqualTo(OrderConstants.ORDER_REFUND_STATUS_UNPAY);
//        //绑定条码的条件9:订单未发货
//        List<Integer> logisticsStatus = new ArrayList<>();
//        logisticsStatus.add(LogisticsConstants.LOGISTICS_STATUS_PRESEND);
//        logisticsStatus.add(LogisticsConstants.LOGISTICS_STATUS_UNSEND);
//        orderExampleCriteria.andLogisticsStatusIn(logisticsStatus);
//
//        boolean check = false;
//        List<AppletOrder> orders = orderMapper.selectByExample(orderExample);
//        if (orders.size()!=0){
//            logger.info("采集点绑定条码: "+"orderNo: "+orderNo+"可以被绑定");
//            check = true;
//        }
//
//        //如果订单可以绑定
//        if (check) {
//            //设置商品状态为已采集
//            AppletGoodExample example = new AppletGoodExample();
//            AppletGoodExample.Criteria criteria = example.createCriteria();
//            criteria.andOrderNoEqualTo(orderNo);
//            criteria.andGoodNoEqualTo(goodNo);
//
//            //绑定条码商品的状态只有两种1.未采集2.异常3.已采集（因为可以重复绑定）
//            List<Integer> goodStatusList = new ArrayList<>();
//            goodStatusList.add(GoodConstants.GOOD_STATUS_UNCOLLECT);
//            goodStatusList.add(GoodConstants.GOOD_STATUS_EXCEPTION);
//            goodStatusList.add(GoodConstants.GOOD_STATUS_COLLECTED);
//            criteria.andGoodStatusIn(goodStatusList);
//            AppletGood good = new AppletGood();
//            good.setUpdateDate(new Date());
//            good.setSampleNo(barcode);
//            good.setSampleCollectDate(new Date());
//            good.setGoodCompleteApplyDate(new Date());
//            good.setGoodStatus(GoodConstants.GOOD_STATUS_COLLECTED);
//            int result = goodMapper.updateByExampleSelective(good, example);
//            if (result==0){
//                logger.info("采集点绑定条码: "+"goodNo: "+goodNo+"绑定失败");
//                return false;
//            }
//            logger.info("采集点绑定条码: "+"goodNo: "+goodNo+"绑定成功");
//            //如果订单下的所有套餐都已绑定则设置订单状态为已采集
//            //表示用户已完成预约
//            //订单已完成核销
//            example.clear();
//
//            criteria = example.createCriteria();
//            criteria.andOrderNoEqualTo(orderNo);
//            List<Integer> goodStatusList2 = new ArrayList<>();
//            goodStatusList2.add(GoodConstants.GOOD_STATUS_UNCOLLECT);
//            goodStatusList2.add(GoodConstants.GOOD_STATUS_EXCEPTION);
//            goodStatusList2.add(GoodConstants.GOOD_STATUS_REFUND_PART);
////            criteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_UNCOLLECT);
//            criteria.andGoodStatusIn(goodStatusList2);
//            criteria.andDelFlagEqualTo(CommonConstants.INIT);
//            int num = goodMapper.selectByExample(example).size();
//            //如果未采集的套餐为0则认为已核销订单已采集
//            if (num==0){
//                orderExample.clear();
//                orderExampleCriteria = orderExample.createCriteria();
//                orderExampleCriteria.andOrderNoEqualTo(orderNo);
//                AppletOrder order = new AppletOrder();
//                order.setOrderStatus(OrderConstants.ORDER_STATUS_COLLECTED);
//                order.setWriteOffStatus(OrderConstants.WRITE_OFF_STATUS_FINISHED);
//                //当条码全部绑定完成后就确认该订单已经从异常状态恢复过来了
//                order.setOrderExceptionStatus(OrderConstants.ORDER_EXCEPTION_NORMAL);
//                order.setWriteOffDate(new Date());
//                order.setOrderCompleteApplyDate(new Date());
//                order.setUpdateDate(new Date());
//                int a = orderMapper.updateByExampleSelective(order,orderExample);
//                if (a==0){
//                    logger.info("采集点绑定条码: "+"orderNo: "+orderNo+"更新订单状态失败");
//                    return false;
//                }
//                logger.info("采集点绑定条码: "+"orderNo: "+orderNo+"更新订单状态成功");
//            } else {
//                orderExample.clear();
//                orderExampleCriteria = orderExample.createCriteria();
//                orderExampleCriteria.andOrderNoEqualTo(orderNo);
//                AppletOrder order = new AppletOrder();
//                order.setOrderStatus(OrderConstants.ORDER_STATUS_UNCOLLECT);
//                //设置核销状态为核销中
//                order.setWriteOffStatus(OrderConstants.WRITE_OFF_STATUS_DEALING);
//                //当条码全部绑定完成后就确认该订单已经从异常状态恢复过来了
//                order.setOrderExceptionStatus(OrderConstants.ORDER_EXCEPTION_NORMAL);
//                order.setWriteOffDate(new Date());
//                order.setOrderCompleteApplyDate(new Date());
//                order.setUpdateDate(new Date());
//                int a = orderMapper.updateByExampleSelective(order,orderExample);
//                if (a==0){
//                    logger.info("采集点绑定条码: "+"orderNo: "+orderNo+"更新订单状态失败");
//                    return false;
//                }
//                logger.info("采集点绑定条码: "+"orderNo: "+orderNo+"更新订单状态成功");
//            }
//            return true;
//        } else {
//            logger.info("采集点绑定条码: "+"orderNo: "+orderNo+"不可以被绑定");
//            return false;
//        }

  }

  @Transactional
  public void notifySaveMobileSampleInfoToThird(AppletGood good, String barcode, String collectorStaffId) {
    List<ThirdSampleInfoVo> list = new ArrayList<>();
    ThirdSampleInfoVo vo = new ThirdSampleInfoVo();
    vo.setBarcode(barcode);
    vo.setCustomBarcode(barcode);

    String packageId = good.getPackageId();
    AppletPackage appletPackage = packageService.getPackageById(packageId);
    if (appletPackage != null) {
      logger.info(appletPackage.getPackageId() + "套餐已存在" + appletPackage.getLabCode());
      vo.setSampleType(SampleTypeEnum.getNameById(appletPackage.getSampleType()));
      vo.setTestPurposeId(appletPackage.getLabCode());
      vo.setTestPurposeName(appletPackage.getPackageName());
      vo.setFee(appletPackage.getPackageCurrentPrice().toString());
      vo.setSampleType(SampleTypeEnum.getNameById(appletPackage.getSampleType()));
    } else {
      logger.info("套餐不存在");
    }

    AppletOrderParticipant participant = participantService.getParticipantByParticipantId(good.getParticipantId());
    if (participant != null) {
      logger.info(participant.getParticipantId() + "参检人已存在" + participant.getParticipantIdCard());
      vo.setPatientAddress(participant.getParticipantAddress());
      vo.setPatientPhone(participant.getParticipantPhone());
      vo.setPatientName(participant.getParticipantName());
      if (StringUtils.isNotBlank(participant.getParticipantIdCard())) {
        vo.setPatientIdNumber(participant.getParticipantIdCard());
        Integer age = IDCardUtils.getAge(participant.getParticipantIdCard());
        if (age != null) {
          vo.setAge("" + IDCardUtils.getAge(participant.getParticipantIdCard()));
        }
        vo.setAgeType("岁");
        Integer sex = IDCardUtils.getSex(participant.getParticipantIdCard());
        if (sex != null) {
          vo.setSex(1 + sex);
        }
      }
    }

    vo.setRequester(good.getDoctorName());
    vo.setRequestTime(DateUtils.convertToStandardDate(good.getCreateDate()));

    if (StringUtils.isNotBlank(collectorStaffId)) {
      logger.info("采集人员已存在" + collectorStaffId);
      AppletAcquisitionStaff staff = staffService.getStaffByStaffId(collectorStaffId);
      if (staff != null) {
        vo.setExecutor(staff.getStaffName());
      }
    } else {
      logger.info("采集人员不存在");
    }
    vo.setExecuteTime(DateUtils.convertToStandardDate(new Date()));

    list.add(vo);
    String jsonStr = JSONObject.toJSONString(list);
    logger.info("json对象转换结果" + jsonStr);
    String saveResult = CommonHttpClientUtils.postMethodClient(jsonStr, saveMobileSampleInfoToThirdUrl);
    logger.info("商品号" + good.getGoodNo() + "通知第三方的返回结果" + saveResult);
    try {
      if (StringUtils.isNotBlank(saveResult)) {
        ThirdResponseVo thirdResponseVo = JSON.parseObject(saveResult, ThirdResponseVo.class);
        if (thirdResponseVo.getState() != null && thirdResponseVo.getState().equals(1)) {
          //正常返回结果
        } else {
          //其余情况都是异常返回
          logger.info("条码号" + barcode + "通知第三方绑定条码失败");
          throw new RuntimeException("通知第三方绑定条码失败");
        }
      }
    } catch (Exception e) {
      logger.info("条码号" + barcode + "通知第三方绑定条码返回结果转换异常");
      throw new RuntimeException("通知第三方绑定条码返回结果转换异常");
    }
  }

  /**
   * 树兰检验科套餐全部绑定完成后需要设置物流收件完成
   */
  @Transactional
  public void receiveUnLogisticsPackage(String orderNo) {

    //判断订单采集点是否是不需要物流的
    AppletOrder order = orderService.getOrderByOrderNo(orderNo);
//        if (order==null||!order.getAcquisitionId().equals("A20190722001")){
//            return;
//        }
    if (order != null) {
      AppletAcquisition acquisition = acquisitionService.getAcquisitionByAcquisitionId(order.getAcquisitionId());
      if (acquisition != null) {
        //如果采集点需要物流，则走的是正常物流流程
        if (acquisition.getLogisticsFlag() != null && acquisition.getLogisticsFlag().equals(AcquisitionConstants.ACQUISITION_LOGISTICS_FLAG_REQUIRED)) {
          return;
        }
      } else {
        return;
      }
    } else {
      return;
    }

    logger.info("接收树兰检验科订单 orderNo: " + orderNo);

    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
    orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    orderExampleCriteria.andOrderNoEqualTo(orderNo);

    AppletOrder updateOrder = new AppletOrder();
    updateOrder.setUpdateDate(new Date());
    updateOrder.setLogisticsStatus(LogisticsConstants.LOGISTICS_STATUS_RECEIVED);
    int i = orderMapper.updateByExampleSelective(updateOrder, orderExample);
    if (i == 0) {
      logger.info("接收树兰检验科订单 orderNo: " + orderNo + " 订单状态变更失败");
      throw new RuntimeException("更新订单已接受物流状态失败: orderNo: " + orderNo);
    }

    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andOrderNoEqualTo(orderNo);
    goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

    AppletGood updateGood = new AppletGood();
    updateGood.setGoodStatus(GoodConstants.GOOD_STATUS_TESTING);
    updateGood.setUpdateDate(new Date());
    i = goodMapper.updateByExampleSelective(updateGood, goodExample);
    if (i == 0) {
      logger.info("接收树兰检验科订单 orderNo: " + orderNo + " 商品状态变更失败");
      throw new RuntimeException("更新商品已收货状态失败: orderNo: " + orderNo);
    }
  }

  public List<GoodBaseVo> getBaseVoByOrderNo(String orderNo) {
    if (StringUtils.isBlank(orderNo)) {
      return null;
    }
    AppletGoodExample example = new AppletGoodExample();
    AppletGoodExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    List<AppletGood> goods = goodMapper.selectByExample(example);
    List<GoodBaseVo> goodBaseVos = new ArrayList<>();
    for (AppletGood good : goods) {

      GoodBaseVo goodBaseVo = new GoodBaseVo();
      BeanUtils.copyProperties(good, goodBaseVo);

      Date applyDate = good.getGoodCurrentApplyDate();
      if (applyDate != null) {
//                SimpleDateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
//                SimpleDateFormat df2 = new SimpleDateFormat("HH");
//                String daystr = df1.format(applyDate);
//                String hourstr = df2.format(applyDate);
//                String apm = "";
//                int a = Integer.parseInt(hourstr);
//                if (a >= 0 && a <= 12) {
//                    apm = "上午";
//                }
//                if (a > 12 && a <= 18) {
//                    apm = "上午";
//                }
//
//                goodBaseVo.setGoodApplyDate(daystr + " " + apm);

        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dayStr = df1.format(applyDate);
        goodBaseVo.setGoodApplyDate(dayStr);
        goodBaseVo.setGoodApplyDateForAPMStr(dayStr);
      }
      AppletPackage appletPackage = packageService.getPackageById(good.getPackageId());
      if (appletPackage != null) {
        logger.info("------" + appletPackage.getPackageLogo());
        goodBaseVo.setPackageLogo(appletPackage.getPackageLogo());
        goodBaseVo.setPackageSourceId(appletPackage.getPackageSourceId());
        goodBaseVo.setReportTimeDesc(appletPackage.getReportTimeDesc());
        goodBaseVo.setSpecialRequirement(appletPackage.getPackageSpecialRequirement()); //增加特殊提醒
      }

      goodBaseVos.add(goodBaseVo);
    }
    return goodBaseVos;
  }

  public List<AppletGood> getGoodsByOrderNo(String orderNo) {
    if (StringUtils.isBlank(orderNo)) {
      return null;
    }
    AppletGoodExample example = new AppletGoodExample();
    AppletGoodExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);
    List<AppletGood> goods = goodMapper.selectByExample(example);
    return goods;
  }


  /**
   * 根据参检人查询基本商品信息
   */
  public List<GoodInfoByNoResult> getGoodsByParticipantid(String participantid) {
        /*if (StringUtils.isBlank(participantid)){
            return null;
        }
        AppletGoodExample example = new AppletGoodExample();
        AppletGoodExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andParticipantIdEqualTo(participantid);
        List<AppletGood> goods = goodMapper.selectByExample(example);
        return goods;*/
    QueryNoParam param = new QueryNoParam();
    if (StringUtils.isNotBlank(participantid)) {
      param.setParticipantId(participantid);
    }
    return goodMapper.selectOutGoodPackageByNo(param);
  }


  public List<ReportBaseVo> getReportBaseVoByOrderNo(String orderNo) {
    if (StringUtils.isBlank(orderNo)) {
      return null;
    }

    AppletGoodExample example = new AppletGoodExample();
    AppletGoodExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderNoEqualTo(orderNo);

//        AppletGoodReportInterpretExample interpretExample = new AppletGoodReportInterpretExample();
//        AppletGoodReportInterpretExample.Criteria interpretExampleCriteria = interpretExample.createCriteria();
//        interpretExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
//        interpretExampleCriteria.andPayTypeEqualTo(ReportConstants.PAYTYPE_FREE);

    List<AppletGood> goods = goodMapper.selectByExample(example);
    List<ReportBaseVo> reportBaseVos = new ArrayList<>();
    for (AppletGood good : goods) {
      ReportBaseVo reportBaseVo = new ReportBaseVo();
      BeanUtils.copyProperties(good, reportBaseVo);

//            interpretExampleCriteria.andGoodNoEqualTo(good.getGoodNo());
//            List<AppletGoodReportInterpret> interprets = interpretMapper.selectByExample(interpretExample);
//            if (interprets.size()!=0){
      reportBaseVo.setDoctorName(good.getDoctorName());

      reportBaseVo.setPdfUrl(good.getPdfUrl());
      reportBaseVo.setPdfMergeUrl(good.getPdfMergeUrl());

//            Date applyDate = good.getGoodApplyDate();
      Date applyDate = good.getGoodCurrentApplyDate();
      if (applyDate != null) {
//                SimpleDateFormat df1 = new SimpleDateFormat("yyyy/MM/dd");
//                SimpleDateFormat df2 = new SimpleDateFormat("HH");
//                String daystr = df1.format(applyDate);
//                String hourstr = df2.format(applyDate);
//                String apm = "";
//                int a = Integer.parseInt(hourstr);
//                if (a >= 0 && a <= 12) {
//                    apm = "上午";
//                }
//                if (a > 12 && a <= 18) {
//                    apm = "上午";
//                }

        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String dayStr = df1.format(applyDate);
        reportBaseVo.setGoodApplyDate(dayStr);
        reportBaseVo.setGoodApplyDateForAPMStr(dayStr);

//                reportBaseVo.setGoodApplyDateForAPMStr(daystr + " " + apm);
      }
      AppletPackage appletPackage = packageService.getPackageById(good.getPackageId());
      if (appletPackage != null) {
        logger.info("------" + appletPackage.getPackageLogo());
        reportBaseVo.setPackageLogo(appletPackage.getPackageLogo());
        reportBaseVo.setPackageSourceId(appletPackage.getPackageSourceId());
      }

//            }else {
//                reportBaseVo.setDoctorName(null);
//            }
      reportBaseVos.add(reportBaseVo);
    }
    return reportBaseVos;
  }

  public List<GoodExtendBaseVo> getGoodExtendBaseVos(String staffId, String queryParam) {
    GoodStaffParam param = new GoodStaffParam();
    if (StringUtils.isNotBlank(staffId)) {
      param.setStaffId(staffId);
    }
    if (StringUtils.isNotBlank(queryParam)) {
      param.setQueryParam(queryParam);
    }
    List<GoodExtendBaseVo> result = goodMapper.getGoodExtendVoWithParticipant(param);
    if (result.size() == 0) {
      return null;
    } else {
      return result;
    }
  }

  public List<StaffRecommendGoodVo> goupByGoodExtendBaseVo(List<GoodExtendBaseVo> baseVos) {
    if (baseVos == null) {
      return null;
    }

    List<StaffRecommendGoodVo> recommendGoodVos = new ArrayList<>();

    //首先分出套餐名
    List<String> groupType = new ArrayList<>();

    //遍历结果数据
    for (int i = 0; i < baseVos.size(); i++) {
      boolean check = false;
      //对比结果集中的分组数据如果结果集中存在分组类中的数据，则直接存储
      for (String type : groupType) {
        if (baseVos.get(i).getPackageName().equals(type)) {
          check = true;
          break;
        }
      }
      if (check) {

      } else {
        StaffRecommendGoodVo newStaffRecommendGoodVo = new StaffRecommendGoodVo();
        newStaffRecommendGoodVo.setPackageName(baseVos.get(i).getPackageName());
        recommendGoodVos.add(newStaffRecommendGoodVo);
        groupType.add(baseVos.get(i).getPackageName());
      }

    }

    a:
    for (StaffRecommendGoodVo goodVo : recommendGoodVos) {
      b:
      for (GoodExtendBaseVo otherVo : baseVos) {
        if (goodVo.getPackageName().equals(otherVo.getPackageName())) {
          goodVo.getGoodExtendBaseVos().add(otherVo);
        }
      }
    }

    recommendGoodVos.sort(new Comparator<StaffRecommendGoodVo>() {
      @Override
      public int compare(StaffRecommendGoodVo o1, StaffRecommendGoodVo o2) {
        return o1.getPackageName().compareTo(o2.getPackageName());
      }
    });

    return recommendGoodVos;
  }

  /**
   * 按月获取医生推荐套餐数量汇总
   */
  public List<DoctorRecommendResult> getDoctorRecommendNumListByMonth(String doctorPhone, String month, Integer pageNo, Integer pageSize) {
    QueryDoctorRecommendNumParam param = new QueryDoctorRecommendNumParam();
    param.setDoctorPhone(doctorPhone);
    param.setMonth(month);
    PageHelper.startPage(pageNo, pageSize);
    List<DoctorRecommendResult> recommendResults = goodMapper.selectDoctorRecommendNumByDate(param);
    PageInfo<DoctorRecommendResult> resultPageInfo = new PageInfo<>(recommendResults);
    List<DoctorRecommendResult> resultList = resultPageInfo.getList();
    logger.info("查询统计sql结果: " + resultList.toString());
    for (DoctorRecommendResult item : resultList) {
      AppletPackage appletPackage = packageService.getPackageById(item.getPackageId());
      if (appletPackage != null) {
        item.setPackageName(appletPackage.getPackageName());
      }
    }
    logger.info("查询统计数据处理结果: " + resultList.toString());
    return resultList;
  }

  /**
   * 获取医生推荐解读列表(根据解读状态)
   */
  public List<AppletGood> getGoodByStaff(String doctorPhone, Integer goodStatus, Integer pageNo, Integer pageSize) {

    List<AppletGood> goods = new ArrayList<>();

    if (StringUtils.isBlank(doctorPhone)) {
      return goods;
    }

    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andDoctorPhoneEqualTo(doctorPhone);
    if (goodStatus != null) {
      goodExampleCriteria.andGoodStatusEqualTo(goodStatus);
    } else {
      List<Integer> goodStatusList = new ArrayList<>();
      goodStatusList.add(GoodConstants.GOOD_STATUS_REPORTED);
      goodStatusList.add(GoodConstants.GOOD_STATUS_INTERPRETED);
      goodExampleCriteria.andGoodStatusIn(goodStatusList);
    }
    if (pageSize == null) {
      pageSize = 20;
    }
    PageHelper.startPage(pageNo, pageSize);
    goods = goodMapper.selectByExample(goodExample);
    PageInfo<AppletGood> goodPageInfo = new PageInfo<>(goods);
    return goodPageInfo.getList();
  }

  public List<ShulanRecommendListVo> getGoodByStaffNew(String doctorPhone, Integer goodStatus, String queryParam, Integer pageNo, Integer pageSize) {
    List<ShulanRecommendListNewVo> sqlList = new ArrayList<>();
    List<ShulanRecommendListVo> reportList = new ArrayList<>();
    if (StringUtils.isBlank(doctorPhone)) {
      return reportList;
    }

    QueryDoctorRecommendNumParam param = new QueryDoctorRecommendNumParam();
    param.setDoctorPhone(doctorPhone);
    param.setQueryParam(queryParam);

    List<Integer> goodStatusList = new ArrayList<>();
    if (goodStatus != null) {
      goodStatusList.add(goodStatus);
    } else {
      goodStatusList.add(GoodConstants.GOOD_STATUS_REPORTED);
      goodStatusList.add(GoodConstants.GOOD_STATUS_INTERPRETED);
    }
    param.setGoodStatusList(goodStatusList);

    logger.info("查询参数: " + param.toString());

    PageHelper.startPage(pageNo, pageSize);
    sqlList = goodMapper.selectReportList(param);
    PageInfo<ShulanRecommendListNewVo> goodPageInfo = new PageInfo<>(sqlList);

    logger.info("sql查询结果:" + goodPageInfo.getList().toString());

    List<ShulanRecommendListNewVo> shulanRecommendListVoList = goodPageInfo.getList();
    for (ShulanRecommendListNewVo listVo : shulanRecommendListVoList) {
      ShulanRecommendListVo recommendListVo = new ShulanRecommendListVo();
      BeanUtils.copyProperties(listVo, recommendListVo);
      if (listVo.getGoodStatus() != null) {
        if (listVo.getGoodStatus().equals(GoodConstants.GOOD_STATUS_REPORTED)) {
          recommendListVo.setReportStatus(0);
        } else if (listVo.getGoodStatus().equals(GoodConstants.GOOD_STATUS_INTERPRETED)) {
          recommendListVo.setReportStatus(1);
        }
      }
      recommendListVo.setReportDate(DateUtils.convertToSlashAndDayDate(listVo.getReportDateForNum()));
      reportList.add(recommendListVo);
    }

    logger.info("处理结果" + reportList.toString());
    return reportList;

  }

  /**
   * 根据套餐和月份获取推荐详情列表
   */
  public List<AppletGood> getGoodByStaffAndPackage(String doctorPhone, String packageId, String month, String queryParam, Integer pageNo, Integer pageSize) {

    List<AppletGood> goods = new ArrayList<>();

    if (StringUtils.isBlank(doctorPhone)) {
      return goods;
    }

    QueryDoctorRecommendNumParam param = new QueryDoctorRecommendNumParam();
    param.setPackageId(packageId);
    param.setDoctorPhone(doctorPhone);
    param.setMonth(month);
    param.setQueryParam(queryParam);
    PageHelper.startPage(pageNo, pageSize);
    goods = goodMapper.selectDoctorRecommendByDate(param);
    PageInfo<AppletGood> goodPageInfo = new PageInfo<>(goods);
    return goodPageInfo.getList();
  }

  public List<ShulanParticipantListVo> getGoodByStaffAndPackageNew(String doctorPhone, String packageId, String month, String queryParam, Integer pageNo, Integer pageSize) {

    List<ShulanParticipantListVo> goods = new ArrayList<>();

    if (StringUtils.isBlank(doctorPhone)) {
      return goods;
    }

    QueryDoctorRecommendNumParam param = new QueryDoctorRecommendNumParam();
    param.setPackageId(packageId);
    param.setDoctorPhone(doctorPhone);
    param.setMonth(month);
    param.setQueryParam(queryParam);
    PageHelper.startPage(pageNo, pageSize);
    goods = goodMapper.selectDoctorRecommendByDateNew(param);
    PageInfo<ShulanParticipantListVo> goodPageInfo = new PageInfo<>(goods);
    return goodPageInfo.getList();
  }

  /**
   * 树兰更新已解读状态
   */
  @Transactional
  public boolean norifyByShulan(String goodNo, String doctorName, String doctorPhone) {

    logger.info("开始更新解读状态");

    if (StringUtils.isBlank(goodNo)) {
      throw new RuntimeException("医生端更新解读完成状态失败,商品号为空");
    }
    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andGoodNoEqualTo(goodNo);
    goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    AppletGood good = new AppletGood();
    if (StringUtils.isNotBlank(doctorName)) {
      good.setDoctorName(doctorName);
    }
    if (StringUtils.isNotBlank(doctorPhone)) {
      good.setDoctorPhone(doctorPhone);
    }
    good.setGoodStatus(GoodConstants.GOOD_STATUS_INTERPRETED);
    good.setUpdateDate(new Date());

    logger.info("更新解读状态对象:" + good.toString());

    int i = goodMapper.updateByExampleSelective(good, goodExample);
    if (i == 0) {
      throw new RuntimeException("医生端更新解读完成状态数据库失败");
    }
    return true;
  }

  /**
   * 查询正在实验室检验中的套餐
   */
  public List<AppletGood> getTestingGood(Integer goodNum) {
    if (goodNum != null) {
      PageHelper.startPage(1, goodNum);
      List<AppletGood> goodList = goodMapper.selectTestingGood();
      PageInfo<AppletGood> goodPageInfo = new PageInfo<>(goodList);
      return goodPageInfo.getList();
    } else {
      return goodMapper.selectTestingGood();
    }
  }

  @Value("${third.queryReportPDF.url}")
  private String queryReportPDFUrl;
  @Value("${default.tclab.doctor.phone}")
  private String defaultDoctorPhone;

  /**
   * 更新套餐的报告状态以及订单状态
   */
  @Transactional
  public void setGoodReported(String goodNo, String reportDate, String newpdfUrl, String originalPdfUrl, AppletGood appletGoodbyBarcode) throws Exception {
    //判断只有在报告出全了 才允许改状态
    AppletPackageExample packageExample = new AppletPackageExample();
    AppletPackageExample.Criteria packageExampleCriteria = packageExample.createCriteria();
    packageExampleCriteria.andPackageIdEqualTo(appletGoodbyBarcode.getPackageId());
    packageExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    List<AppletPackage> packageList = packageMapper.selectByExample(packageExample);
    AppletPackage appletPackage = null;
    if (packageList != null && packageList.size() != 0) {
      appletPackage = packageList.get(0);
    } else {
      throw new RuntimeException("AppletPackage找不到: packageId: " + appletGoodbyBarcode.getPackageId());
    }
    Integer pdfsize = appletPackage.getPdfNum(); //获取总和pdf设定数量

    //更新商品状态已出报告
    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andGoodNoEqualTo(goodNo);
    goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    AppletGood good = new AppletGood();
    good.setUpdateDate(new Date());
    if (StringUtils.isBlank(originalPdfUrl)) {
      good.setPdfUrl(newpdfUrl);
    } else {//遍历每个pdf对本次获取的pdf进行比对 不同才允许新增
      String[] oldpdfUrlarr = originalPdfUrl.split("\\;");
      int i = 0;
      for (String oldpdfurl : oldpdfUrlarr) {
        if (!oldpdfurl.equals(newpdfUrl)) {
          i++;
        }
      }
      if (i == oldpdfUrlarr.length) {
        good.setPdfUrl(originalPdfUrl + ";" + newpdfUrl);
      }
    }
    //修改解读记录商品状态
    AppletInterpretGoodExample interpretGoodExample = new AppletInterpretGoodExample();
    AppletInterpretGoodExample.Criteria interpretGoodExampleCriteria = interpretGoodExample.createCriteria();
    interpretGoodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    interpretGoodExampleCriteria.andGoodNoEqualTo(goodNo);
    AppletInterpretGood interpretGood = new AppletInterpretGood();
    //大于设置配置pdf数量才执行更改报告状态
    if (StringUtils.isNotBlank(good.getPdfUrl())) {
      String[] aumUrlarr = good.getPdfUrl().split("\\;");
      if (pdfsize <= aumUrlarr.length || (null != newpdfUrl && pdfsize == 1)) {
        good.setGoodStatus(GoodConstants.GOOD_STATUS_REPORTED);
        good.setReportDate(DateUtils.convertToReportDate(reportDate));
        interpretGood.setStatus(1);
        //更新解读商品表
        appletInterpretGoodMapper.updateByExampleSelective(interpretGood, interpretGoodExample);
      }
    }
    //出全报告后更新该条细项报告状态
    goodMapper.updateByExampleSelective(good, goodExample);
    AppletGood queryGood = getGoodByGoodNo(goodNo, CommonConstants.INIT);//important
    //设置出完报告份数后合并报告
    if (StringUtils.isNotBlank(queryGood.getPdfUrl()) && StringUtils.isBlank(queryGood.getPdfMergeUrl())) {
      String[] aumDataUrlarr = queryGood.getPdfUrl().split("\\;");
      if (pdfsize <= aumDataUrlarr.length && 1 != aumDataUrlarr.length) {
        //************事务开始：合并pdf操作开始 如若有多张pdf则进行 则进行设置合并多张pdf****************
        new Thread(new Runnable() {
          @Override
          public void run() {
            mergepdfUrl(queryGood);
          }
        }).start();
        //************事务结束：合并pdf操作结束****************
      }
    }

    //生成消息
    //messageService.createMessageByUser(good.getUserId(),"已出报告: "+good.getPackageName(),"您购买的"+good.getPackageName()+"套餐检验完成,已生成PDF报告,请您及时前往报告中心查收");
    //检查订单是否全部已出报告
    //订单可能出现的情况，如果订单已出到达查询报告的环节，则说明已经穿过了物流环节
    //未完成  1.一单已出报告，其他几单未出报告
    //未完成  2.一单已出报告，其他几单异常退款，其他几单未出报告
    //未完成  3.一单已出报告，其他几单已出报告，其他几单异常退款，其他几单未出报告
    //已完成  4.一单已出报告，其他几单已出报告，其他几单异常退款
    //已完成  5.一单已出报告，其他几单已出报告
    goodExample.clear();
    //查询是否存在还有未出报告的状态 不存在其他未出报告的订单表示订单可以设置成已完成
    goodExampleCriteria = goodExample.createCriteria();
    List<Integer> goodStatusList = new ArrayList<>();
    goodStatusList.add(GoodConstants.GOOD_STATUS_REPORTED);
    goodExampleCriteria.andGoodStatusNotIn(goodStatusList);
    goodExampleCriteria.andOrderNoEqualTo(queryGood.getOrderNo());
    goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    long count = goodMapper.countByExample(goodExample);

    //查出该条记录主订单 进行状态修正
    AppletOrderExample example = new AppletOrderExample();
    AppletOrderExample.Criteria criteria = example.createCriteria();
    criteria.andOrderNoEqualTo(queryGood.getOrderNo());
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    List<AppletOrder> queryOrderList = orderMapper.selectByExample(example);
    if (count == 0 && OrderConstants.ORDER_STATUS_COMPLETED != queryOrderList.get(0).getOrderStatus()) { //订单所有套餐都完成 和 未分发过时才执行
      //修正套餐状态为3
      AppletOrderExample orderExample = new AppletOrderExample();
      AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
      orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      orderExampleCriteria.andOrderNoEqualTo(queryGood.getOrderNo());
      AppletOrder updateOrder = new AppletOrder();
      updateOrder.setUpdateDate(new Date());
      updateOrder.setOrderStatus(OrderConstants.ORDER_STATUS_COMPLETED);
      orderMapper.updateByExampleSelective(updateOrder, orderExample);
    }
  }

  /**
   * 更新套餐合并后报告库地址字段
   */
  @Transactional
  public void setGoodReported(String goodNo, String pdfmergeurl) throws Exception {
    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andGoodNoEqualTo(goodNo);
    goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

    AppletGood good = new AppletGood();
    good.setPdfMergeUrl(pdfmergeurl);

    //更新操作
    goodMapper.updateByExampleSelective(good, goodExample);
  }

  /**
   * 根据样本号获取样本信息
   */
  public AppletGood getGoodBySampleNo(String sampleNo) {
    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andSampleNoEqualTo(sampleNo);
    goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    List<AppletGood> goodList = goodMapper.selectByExample(goodExample);
    if (goodList.size() != 0) {
      return goodList.get(0);
    } else {
      return null;
    }
  }

  //客户端查询所有报告列表
  public ReportListVo getReportedAndUnReportedGoodByUserId(String userId, Integer reportStatus, Integer interpretStatus, Integer pageNo, Integer pageSize) {

    ReportListVo reportListVo = new ReportListVo();

    if (StringUtils.isBlank(userId)) {
      return reportListVo;
    }

    if (reportStatus == null) {
      reportStatus = 0;
    }
    if (interpretStatus == null) {
      interpretStatus = 0;
    }

    AppletGoodExample goodExample = new AppletGoodExample();
    AppletGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
    goodExampleCriteria.andUserIdEqualTo(userId);

    if (reportStatus.equals(0)) {
      goodExampleCriteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_TESTING);
    } else if (reportStatus.equals(1)) {
      List<Integer> goodStatus = new ArrayList<>();
      goodStatus.add(GoodConstants.GOOD_STATUS_REPORTED);
      goodStatus.add(GoodConstants.GOOD_STATUS_INTERPRETED);
      goodExampleCriteria.andGoodStatusIn(goodStatus);
    }

//        if (reportStatus!=null) {
//            if (reportStatus.equals(0)){
//                //未出报告
//                goodExampleCriteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_TESTING);
//            } else if (reportStatus.equals(1)){
//                //已出报告
//                if (interpretStatus!=null){
//                    if (interpretStatus.equals(0)){
//                        //未解读
//                        goodExampleCriteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_REPORTED);
//                    } else if (interpretStatus.equals(1)){
//                        //已解读
//                        goodExampleCriteria.andGoodStatusEqualTo(GoodConstants.GOOD_STATUS_INTERPRETED);
//                    } else {
//                        //所有已出报告
//                        List<Integer> goodStatus = new ArrayList<>();
//                        goodStatus.add(GoodConstants.GOOD_STATUS_INTERPRETED);
//                        goodStatus.add(GoodConstants.GOOD_STATUS_REPORTED);
//                        goodExampleCriteria.andGoodStatusIn(goodStatus);
//                    }
//                } else {
//                    //所有已出报告
//                    List<Integer> goodStatus = new ArrayList<>();
////                    goodStatus.add(GoodConstants.GOOD_STATUS_INTERPRETED);
//                    goodStatus.add(GoodConstants.GOOD_STATUS_REPORTED);
//                    goodExampleCriteria.andGoodStatusIn(goodStatus);
//                }
//            } else {
//                //查询所有
//                List<Integer> goodStatus = new ArrayList<>();
//                goodStatus.add(GoodConstants.GOOD_STATUS_TESTING);
//                goodStatus.add(GoodConstants.GOOD_STATUS_INTERPRETED);
//                goodStatus.add(GoodConstants.GOOD_STATUS_REPORTED);
//                goodExampleCriteria.andGoodStatusIn(goodStatus);
//            }
//        } else {
//            //查询所有
//            List<Integer> goodStatus = new ArrayList<>();
//            goodStatus.add(GoodConstants.GOOD_STATUS_TESTING);
//            goodStatus.add(GoodConstants.GOOD_STATUS_INTERPRETED);
//            goodStatus.add(GoodConstants.GOOD_STATUS_REPORTED);
//            goodExampleCriteria.andGoodStatusIn(goodStatus);
//        }
    if (pageSize == null) {
      pageSize = 20;
    }
    if (pageNo == null) {
      pageNo = 1;
    }
    PageHelper.startPage(pageNo, pageSize);
    List<AppletGood> goodList = goodMapper.selectByExample(goodExample);
    PageInfo<AppletGood> goodPageInfo = new PageInfo<>(goodList);

    List<ReportBaseResultVo> resultList = new ArrayList<>();
    if (goodList != null) {
      for (AppletGood good : goodPageInfo.getList()) {
        ReportBaseResultVo result = new ReportBaseResultVo();
        result.setAcquisitionName(good.getAcquisitionName());
        result.setGoodNo(good.getGoodNo());
        result.setPackageId(good.getPackageId());
        result.setPackageName(good.getPackageName());
        result.setReportStatus(reportStatus);
        result.setInterpretStatus(interpretStatus);
        result.setGoodStatus(good.getGoodStatus());
        result.setUserId(good.getUserId());
        result.setDoctorName(good.getDoctorName());
        result.setDoctorPhone(good.getDoctorPhone());
        result.setReportDate(DateUtils.convertToSlashAndDayDate(good.getReportDate()));
        result.setReportImg(good.getReportImg());
        result.setParticipantId(good.getParticipantId());
        result.setSampleNo(good.getSampleNo());
        result.setPdfUrl(good.getPdfUrl());
        resultList.add(result);
      }
    }

    reportListVo.setPageNo(pageNo);
    reportListVo.setPageSize(pageSize);
    reportListVo.setPageNum(goodPageInfo.getPages());
    reportListVo.setReportSize(goodPageInfo.getTotal());

    reportListVo.setReportBaseResultList(resultList);
    return reportListVo;
  }


  private void pushWeChatDC(String doctorPhone) {
    if (StringUtils.isNotBlank(doctorPhone)) {
      AppletDoctorExample doctorExample = new AppletDoctorExample();
      AppletDoctorExample.Criteria criteria = doctorExample.createCriteria();
      criteria.andDelFlagEqualTo(CommonConstants.INIT);
      criteria.andDoctorPhoneEqualTo(doctorPhone);
      List<AppletDoctor> doctorList = appletDoctorMapper.selectByExample(doctorExample);
      if (!doctorList.isEmpty() && 0 < doctorList.size()) {
        WxTencentUtils.pushMessage(doctorList.get(0).getDoctorOpenid(), WxTencentUtils.getReportTemplate());
      }
    } else {
      logger.info("报告出结果微信推送参数为空" + doctorPhone);
    }
  }

  private void mergepdfUrl(AppletGood queryGood) {
    try {
      logger.info("pdf合并模块" + queryGood.getGoodNo());
      String pdfurl = queryGood.getPdfUrl();
      String pdfmergeurl = queryGood.getPdfMergeUrl();
      if (null != pdfurl && !"".equals(pdfurl)) {
        pdfurl = pdfurl.replaceAll("@", "/");
        String[] pathArray = pdfurl.split(";");
        if (1 < pathArray.length && (null == pdfmergeurl || "".equals(pdfmergeurl))) { //大于1张 且报告库没合并过 才进行合并操作
          String reportUrl = "http://120.193.21.152:8081/"; //报告库地址 后期取配置文件
          //http 数据流获取 存list 用完关闭
          List<InputStream> inputStreamList = new ArrayList<InputStream>();
          //pdf文件处理获取
          PDFMergerUtility PDFmerger = new PDFMergerUtility();
          String fileSeperator = File.separator;
          String userDir = System.getProperties().getProperty("user.dir");
          String tempBatchDir = userDir + fileSeperator + "pic" + fileSeperator + "batch.pdf";
          PDFmerger.setDestinationFileName(tempBatchDir);
          for (int i = 0; i < pathArray.length; i++) {
            StringBuilder fileUrlBuilder = new StringBuilder(reportUrl).append(pathArray[i]);
            URLConnection con = new URL(fileUrlBuilder.toString()).openConnection();
            con.setConnectTimeout(60 * 1000);
            InputStream is = new URL(fileUrlBuilder.toString()).openConnection().getInputStream();
            inputStreamList.add(is);
            PDFmerger.addSource(is);
          }
          PDFmerger.mergeDocuments();
          for (InputStream is : inputStreamList) {
            is.close();
          }
          //合并后操作
          String base64str = FileUtils.PDFToBase64(new File(tempBatchDir));
          //System.out.println("base64格式文件打印"+base64str);
          //组装参数
          List<UploadReport> fileStreams = new ArrayList<UploadReport>();
          UploadReport uploadReport = new UploadReport();
          uploadReport.setPdfStream(base64str);
          uploadReport.setWordStream(base64str);//防止报错必须有参数  后期报告库接口服务器重启更新后可去掉这行
          fileStreams.add(uploadReport);
          String jsonStr = JSONObject.toJSONString(fileStreams);
          String methodUrl = "http://120.193.21.152:8110/services/report/rest/report/batchUploadFileByStream";//报告库上传文件地址
          //更新合并的pdf地址
          String uploadResult = CommonHttpClientUtils.postMethodClient(jsonStr, methodUrl);
          Map rm = JSON.parseObject(uploadResult);
          //  String uploadResult = "{ \"Message\": [{ \"barcode\": \"\", \"uploadPdfPath\": \"group1/M00/29/43/rBIUC113c7-AT2M0AAMfgKgibs0344.pdf\", \"uploadWordPath\": \"group1/M00/29/43/rBIUC113c7-AXzhVAAMfgKgibs0173.doc\" }], \"State\": 1 }";
          System.out.println("返回的路径地址" + uploadResult);
          if ("1".equals(rm.get("State").toString())) {
            List<UploadReportReturn> dd = JSON.parseArray(rm.get("Message").toString(), UploadReportReturn.class);
            setGoodReported(queryGood.getGoodNo(), dd.get(0).getUploadPdfPath());
          }
        }
      }
    } catch (Exception e) {
      logger.info("pdf合并失败: " + queryGood.getGoodNo());
    }
  }

  public List<AppletGood> getGoodByGoodNos(List<String> goodNos) {
    AppletGoodExample example = new AppletGoodExample();
    AppletGoodExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andGoodNoIn(goodNos);
    List<AppletGood> appletGoodList = goodMapper.selectByExample(example);
    return appletGoodList;
  }

}
