package com.tclab.weixinappletservice.service.clientService;

import static com.tclab.weixinappletcommon.constant.IMConstants.IM_REVIEW_TYPE_FIRST_VISIT;
import static com.tclab.weixinappletcommon.constant.IMConstants.IM_STATUS_START;

import com.github.pagehelper.PageHelper;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.IMConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletservice.dao.AppletImRecommendListItemMapper;
import com.tclab.weixinappletservice.dao.AppletImRecommendListMapper;
import com.tclab.weixinappletservice.dao.AppletImRecordMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.dao.AppletPackageMapper;
import com.tclab.weixinappletservice.model.query.QueryImRecordParam;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AppletImRecommendListItemVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.GoodPlaceReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ImRecommendListBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderPlaceReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.UcImRecommendListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.DcRecommendListUpdateReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.ImRecommendListQueryReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.PackageListQueryReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.RecommendListSaveReqVo;
import com.tclab.weixinappletservice.pojo.AppletImRecommendList;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListExample;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListExample.Criteria;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListItem;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListItemExample;
import com.tclab.weixinappletservice.pojo.AppletImRecord;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.pojo.AppletPackageExample;
import com.tclab.weixinappletservice.pojo.AppletUser;
import java.beans.Transient;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package：com.tclab.weixinappletservice.service.doctorService
 * @Class：DcRecommendService
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/9 4:26 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Service
public class ImRecommendListService {

  private static final Logger logger = LoggerFactory.getLogger(ImRecommendListService.class);

  @Autowired
  private AppletImRecommendListMapper recommendListMapper;
  @Autowired
  private AppletImRecommendListItemMapper recommendListItemMapper;
  @Autowired
  private AppletImRecordMapper appletImRecordMapper;
  @Autowired
  private ParticipantService participantService;
  @Autowired
  private PackageService packageService;
  @Autowired
  private AppletPackageMapper appletPackageMapper;
  @Autowired
  private OrderService orderService;
  @Autowired
  private NumberGeneratorUtils numberGeneratorUtils;
  @Autowired
  private AppletOrderMapper orderMapper;
  @Autowired
  private UserService userService;

  public AppletImRecommendList getImRecommendListByRecommendListId(String imRecommendListId) {

    if (StringUtils.isBlank(imRecommendListId)){
      return null;
    }

    AppletImRecommendListExample example = new AppletImRecommendListExample();
    AppletImRecommendListExample.Criteria exampleCriteria = example.createCriteria();
    exampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    exampleCriteria.andImRecommendListIdEqualTo(imRecommendListId);
    List<AppletImRecommendList> list = recommendListMapper.selectByExample(example);

    if (list!=null&&list.size()!=0){
      return list.get(0);
    } else {
      return null;
    }
  }

  public List<ImRecommendListBaseVo> getItemList(ImRecommendListQueryReqVo vo) {
    List<ImRecommendListBaseVo> list = new ArrayList<>();
    AppletImRecommendListExample listExample = new AppletImRecommendListExample();
    Criteria criteria = listExample.createCriteria();
    Criteria criteria1 = listExample.createCriteria();

    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria1.andDelFlagEqualTo(CommonConstants.INIT);

    if (StringUtils.isNotBlank(vo.getDoctorId())) {
      criteria.andDoctorIdEqualTo(vo.getDoctorId());
      criteria1.andDoctorIdEqualTo(vo.getDoctorId());
    }
    if (StringUtils.isNotBlank(vo.getImRecommendListId())) {
      criteria.andImRecommendListIdEqualTo(vo.getImRecommendListId());
      criteria1.andImRecommendListIdEqualTo(vo.getImRecommendListId());
    }
    if (StringUtils.isNotBlank(vo.getParticipantId())) {
      criteria.andParticipantIdEqualTo(vo.getParticipantId());
      criteria1.andParticipantIdEqualTo(vo.getParticipantId());
    }
    if (StringUtils.isNotBlank(vo.getRecommendStatus())) {
      List<String> stringList = Arrays.asList(vo.getRecommendStatus().split(","));
      List<Integer> recommendStatusList = new ArrayList<>();
      for (String s : stringList) {
        recommendStatusList.add(Integer.parseInt(s));
      }
      criteria.andRecommendStatusIn(recommendStatusList);
      criteria1.andRecommendStatusIn(recommendStatusList);
    }
    if (StringUtils.isNotBlank(vo.getReviewType())) {
      List<String> stringList = Arrays.asList(vo.getReviewType().split(","));
      List<Integer> previewTypeList = new ArrayList<>();
      for (String s : stringList) {
        previewTypeList.add(Integer.parseInt(s));
      }
      criteria.andReviewTypeIn(previewTypeList);
      criteria1.andReviewTypeIn(previewTypeList);
    }
    if (StringUtils.isNotBlank(vo.getParticipantQuery())) {
      criteria.andParticipantNameLike("%" + vo.getParticipantQuery() + "%");
      criteria.andParticipantPhoneLike("%" + vo.getParticipantQuery() + "%");
    }
    listExample.or(criteria);
    listExample.or(criteria1);
    if (vo.getPageNo() != null && vo.getPageSize() != null) {
      PageHelper.startPage(vo.getPageNo(), vo.getPageSize());
    }
    List<AppletImRecommendList> appletImRecommendList = recommendListMapper.selectByExample(listExample);
    if (appletImRecommendList != null && appletImRecommendList.size() > 0) {
      for (AppletImRecommendList recommendList : appletImRecommendList) {
        ImRecommendListBaseVo imRecommendListBaseVo = new ImRecommendListBaseVo();
        BeanUtils.copyProperties(recommendList, imRecommendListBaseVo);
        imRecommendListBaseVo.setCreateDate(DateUtils.formatSdfForMinDate(recommendList.getCreateDate()));
        imRecommendListBaseVo.setUpdateDate(DateUtils.formatSdfForMinDate(recommendList.getUpdateDate()));
        list.add(imRecommendListBaseVo);
      }
      return list;
    }
    return null;
  }

  @Transient
  public String saveImRecommendList(RecommendListSaveReqVo vo) {
    AppletImRecommendList recommendList = new AppletImRecommendList();
    List<AppletImRecommendListItem> listItemList = new ArrayList<>();
    //患者信息
    AppletOrderParticipant participant = participantService.getParticipantByParticipantId(vo.getParticipantId());
    if (participant == null) {
      throw new RuntimeException("未找到患者信息");
    }
    //套餐信息
    PackageListQueryReqVo packageListQueryReqVo = new PackageListQueryReqVo();
    if (StringUtils.isBlank(vo.getPackageNo())) {
      throw new RuntimeException("套餐编号参数不能为空");
    }
    packageListQueryReqVo.setPackageNo(vo.getPackageNo());
    List<AppletPackage> packageList = packageService.getPackageList(packageListQueryReqVo);
    if (packageList == null) {
      throw new RuntimeException("未找到检验套餐信息");
    }
    String imRecommendListId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_IM_RECOMMEND);
    recommendList.setImRecommendListId(imRecommendListId);
    recommendList.setDoctorId(vo.getDoctorId());
    recommendList.setDoctorName(vo.getDoctorName());
    recommendList.setParticipantId(vo.getParticipantId());
    recommendList.setParticipantName(participant.getParticipantName());
    recommendList.setParticipantPhone(participant.getParticipantPhone());
    recommendList.setParticipantMedicalHistory(participant.getParticipantMedicalHistory());
    recommendList.setParticipantIdCard(participant.getParticipantIdCard());
    recommendList.setParticipantAge(participant.getParticipantAge());
    recommendList.setParticipantSex(participant.getParticipantSex());
    recommendList.setReviewType(vo.getReviewType());
    recommendList.setDelFlag(CommonConstants.INIT);
    recommendList.setRecommendStatus(vo.getRecommendStatus());
    recommendList.setCreateDate(new Date());
    recommendList.setUserId(vo.getUserId());
    recommendList.setImrecordId(vo.getImRecordId());
    for (AppletPackage appletPackage : packageList) {
      AppletImRecommendListItem item = new AppletImRecommendListItem();
      item.setImRecommendListId(imRecommendListId);
      item.setPackageNo(appletPackage.getPackageId());
      item.setPackageName(appletPackage.getPackageName());
      item.setPackageCurrentPrice(appletPackage.getPackageCurrentPrice());
      item.setDelFlag(CommonConstants.INIT);
      item.setCreateDate(new Date());
      item.setRecommendStatus(vo.getRecommendStatus());
      listItemList.add(item);
    }
    Integer i = recommendListMapper.insertSelective(recommendList);
    if (i == 0) {
      throw new RuntimeException("保存检验清单失败");
    }
    for (AppletImRecommendListItem imRecommendListItem : listItemList) {
      i = recommendListItemMapper.insertSelective(imRecommendListItem);
      if (i == 0) {
        throw new RuntimeException("保存检验清单明细失败");
      }
    }
    return recommendList.getImRecommendListId();
  }

  public UcImRecommendListVo getListByImRecommedListId(String imRecommedListId) {
    AppletImRecommendListExample listExample = new AppletImRecommendListExample();
    Criteria criteria = listExample.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andImRecommendListIdEqualTo(imRecommedListId);
    List<AppletImRecommendList> appletImRecommendLists = recommendListMapper.selectByExample(listExample);
    if (appletImRecommendLists != null && appletImRecommendLists.size() > 0) {
      UcImRecommendListVo vo = new UcImRecommendListVo();
      AppletImRecommendListItemExample itemExample = new AppletImRecommendListItemExample();
      AppletImRecommendListItemExample.Criteria criteria1 = itemExample.createCriteria();
      criteria1.andDelFlagEqualTo(CommonConstants.INIT);
      criteria1.andImRecommendListIdEqualTo(imRecommedListId);
      List<AppletImRecommendListItem> listItemList = recommendListItemMapper.selectByExample(itemExample);
      //时间转换
      List<AppletImRecommendListItemVo> recommendListItemVoList = new ArrayList<>();
      for (AppletImRecommendListItem item : listItemList) {
        AppletImRecommendListItemVo itemVo = new AppletImRecommendListItemVo();
        BeanUtils.copyProperties(item, itemVo);
        AppletPackage appletPackage = packageService.getPackageById(item.getPackageNo());
        if (appletPackage != null) {
          itemVo.setClinicalSignificance(appletPackage.getClinicalSignificance());
          itemVo.setPackageSpecialRequirement(appletPackage.getPackageSpecialRequirement());
        }
        recommendListItemVoList.add(itemVo);
      }
      ImRecommendListBaseVo imRecommendListBaseVo = new ImRecommendListBaseVo();
      BeanUtils.copyProperties(appletImRecommendLists.get(0), imRecommendListBaseVo);
      imRecommendListBaseVo.setCreateDate(DateUtils.formatSdfForMinDate(appletImRecommendLists.get(0).getCreateDate()));
      imRecommendListBaseVo.setUpdateDate(DateUtils.formatSdfForMinDate(appletImRecommendLists.get(0).getUpdateDate()));
      vo.setImRecommendListBaseVo(imRecommendListBaseVo);
      vo.setAppletImRecommendListItemList(recommendListItemVoList);
      return vo;
    }
    return null;
  }

  @Transactional
  public String openImRecommendList(RecommendListSaveReqVo vo) {
    AppletImRecommendList recommendList = new AppletImRecommendList();
    List<AppletImRecommendListItem> listItemList = new ArrayList<>();
    //患者信息
    AppletOrderParticipant participant = participantService.getParticipantByParticipantId(vo.getParticipantId());
    if (participant == null) {
      throw new RuntimeException("未找到患者信息");
    }
    //套餐信息
    PackageListQueryReqVo packageListQueryReqVo = new PackageListQueryReqVo();
    packageListQueryReqVo.setPackageNo(vo.getPackageNo());
    List<AppletPackage> packageList = packageService.getPackageByIdList(vo.getOpenPackageIdList());
    logger.info("查询的套餐数量" + packageList.size());
    if (packageList == null || packageList.size() == 0) {
      throw new RuntimeException("未找到检验套餐信息");
    }
    String imRecommendListId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_IM_RECOMMEND);
    recommendList.setImRecommendListId(imRecommendListId);
    recommendList.setDoctorId(vo.getDoctorId());
    recommendList.setDoctorName(vo.getDoctorName());
    recommendList.setParticipantId(vo.getParticipantId());
    recommendList.setParticipantName(participant.getParticipantName());
    recommendList.setParticipantPhone(participant.getParticipantPhone());
    recommendList.setParticipantMedicalHistory(participant.getParticipantMedicalHistory());
    recommendList.setParticipantIdCard(participant.getParticipantIdCard());
    recommendList.setParticipantAge(participant.getParticipantAge());
    recommendList.setParticipantSex(participant.getParticipantSex());
    recommendList.setReviewType(IMConstants.IM_REVIEW_TYPE_AGAIN_VISIT);
    recommendList.setRecommendStatus(IMConstants.IM_RECOMMEND_STATUS_INIT);
    recommendList.setDelFlag(CommonConstants.INIT);
    recommendList.setCreateDate(new Date());
    recommendList.setUpdateDate(new Date());
    recommendList.setUserId(vo.getUserId());
    recommendList.setRecommendRemark(vo.getRecommendRemark());
    for (AppletPackage appletPackage : packageList) {
      AppletImRecommendListItem item = new AppletImRecommendListItem();

      logger.info("Im编号" + imRecommendListId);

      item.setImRecommendListId(imRecommendListId);
      item.setPackageNo(appletPackage.getPackageId());
      item.setPackageName(appletPackage.getPackageName());
      item.setPackageCurrentPrice(appletPackage.getPackageCurrentPrice());
      item.setDelFlag(CommonConstants.INIT);
      item.setCreateDate(new Date());
      item.setUpdateDate(new Date());
      item.setRecommendStatus(IMConstants.IM_RECOMMEND_STATUS_INIT);
      listItemList.add(item);
    }
    int i = recommendListMapper.insertSelective(recommendList);
    if (i == 0) {
      throw new RuntimeException("保存失败");
    }
    for (AppletImRecommendListItem imRecommendListItem : listItemList) {
      i = recommendListItemMapper.insertSelective(imRecommendListItem);
      if (i == 0) {
        throw new RuntimeException("插入失败");
      }
    }
    return imRecommendListId;
  }

  @Transactional
  public void confirmImRecommendList(RecommendListSaveReqVo vo) {
    AppletImRecommendListItemExample recommendListItemExample = new AppletImRecommendListItemExample();
    AppletImRecommendListItemExample.Criteria recommendListItemExampleCriteria = recommendListItemExample.createCriteria();
    if (StringUtils.isNotBlank(vo.getImRecommendListId())) {
      recommendListItemExampleCriteria.andImRecommendListIdEqualTo(vo.getImRecommendListId());
    }
    recommendListItemExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (vo.getConfirmPackageIdList() != null || vo.getConfirmPackageIdList().size() != 0) {
      recommendListItemExampleCriteria.andPackageNoIn(vo.getConfirmPackageIdList());
    }

    AppletImRecommendListItem updateItem = new AppletImRecommendListItem();
    updateItem.setUpdateDate(new Date());
    updateItem.setRecommendStatus(IMConstants.IM_RECOMMEND_STATUS_CONFIRM);

    int i = recommendListItemMapper.updateByExampleSelective(updateItem, recommendListItemExample);
    if (i == 0) {
      throw new RuntimeException("确认细项失败");
    }

    AppletImRecommendListExample imRecommendListExample = new AppletImRecommendListExample();
    Criteria imRecommendListExampleCriteria = imRecommendListExample.createCriteria();
    if (StringUtils.isNotBlank(vo.getImRecommendListId())) {
      imRecommendListExampleCriteria.andImRecommendListIdEqualTo(vo.getImRecommendListId());
    }
    imRecommendListExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

    AppletImRecommendList updateImRecommendList = new AppletImRecommendList();
    updateImRecommendList.setUpdateDate(new Date());
    updateImRecommendList.setRecommendStatus(IMConstants.IM_RECOMMEND_STATUS_CONFIRM);

    i = recommendListMapper.updateByExampleSelective(updateImRecommendList, imRecommendListExample);
    if (i == 0) {
      throw new RuntimeException("确认推荐单失败");
    }
  }

  @Transactional
  public String orderImRecommendList(OrderPlaceReqVo req) {
    //判断推荐单是否重复
    AppletOrderExample orderExample = new AppletOrderExample();
    AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
    orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    orderExampleCriteria.andImRecommendListIdEqualTo(req.getImRecommendListId());
    orderExampleCriteria.andPayStatusEqualTo(OrderConstants.ORDER_PAY_STATUS_PAYED);
    List<AppletOrder> orderList = orderMapper.selectByExample(orderExample);
    if (orderList!=null&&orderList.size()!=0){
      //订单已生成推荐单并付款，则该订单不可以下单
      logger.info("推荐单只能发起一次");
      throw new RuntimeException("检验清单只能单次支付");
    }
    //如果已存在推荐单但是未付款则取消订单
    orderExample.clear();
    orderExampleCriteria = orderExample.createCriteria();
    orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    orderExampleCriteria.andImRecommendListIdEqualTo(req.getImRecommendListId());
    List<Integer> payStatusList = new ArrayList<>();
    payStatusList.add(OrderConstants.ORDER_PAY_STATUS_UNPAY);
    payStatusList.add(OrderConstants.ORDER_PAY_STATUS_PAYING);
    orderList = orderMapper.selectByExample(orderExample);
    if (orderList!=null&&orderList.size()!=0){
      //对已存在未支付的推荐单订单进行取消删除操作
      for (AppletOrder queryOrder:orderList) {
        orderService.userCancelOrder(queryOrder.getOrderNo(),null);
        logger.info("取消未支付的推荐单订单");
      }
    }

    String orderNo = orderService.placeOrder(req);
    if (StringUtils.isNotBlank(orderNo)) {
      //下单后直接审核订单
      List<String> orderNoList = new ArrayList<>();
      orderNoList.add(orderNo);
      orderService.inquiryVerifyOrder(orderNoList, req.getGoods().get(0).getDoctorName());
      //关联订单号
      AppletImRecommendListExample imRecommendListExample = new AppletImRecommendListExample();
      Criteria imRecommendListExampleCriteria = imRecommendListExample.createCriteria();
      imRecommendListExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      imRecommendListExampleCriteria.andImRecommendListIdEqualTo(req.getImRecommendListId());
      AppletImRecommendList updateImRecommendList = new AppletImRecommendList();
      updateImRecommendList.setUpdateDate(new Date());
      updateImRecommendList.setOrderNo(orderNo);
      recommendListMapper.updateByExampleSelective(updateImRecommendList, imRecommendListExample);

      //更新推荐单细项
      AppletImRecommendListItemExample imRecommendListItemExample = new AppletImRecommendListItemExample();
      AppletImRecommendListItemExample.Criteria imRecommendListItemExampleCriteria = imRecommendListItemExample.createCriteria();
      imRecommendListItemExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      List<String> packageIdList = new ArrayList<>();
      for (GoodPlaceReqVo reqVo:req.getGoods()) {
        packageIdList.add(reqVo.getPackageId());
      }
      imRecommendListItemExampleCriteria.andPackageNoIn(packageIdList);
      imRecommendListItemExampleCriteria.andImRecommendListIdEqualTo(req.getImRecommendListId());

      AppletImRecommendListItem updateImRecommendListItem = new AppletImRecommendListItem();
      updateImRecommendListItem.setUpdateDate(new Date());
      updateImRecommendListItem.setUserConfirmStatus(CommonConstants.ENABLE);
      recommendListItemMapper.updateByExampleSelective(updateImRecommendListItem, imRecommendListItemExample);

      return orderNo;
    } else {
      throw new RuntimeException("下单失败");
    }
  }

  @Transactional
  public void updateImRecommendListPaySuccessful(String imRecommendListId) {
    if (StringUtils.isNotBlank(imRecommendListId)) {
      //更新推荐清单状态
      AppletImRecommendListExample imRecommendListExample = new AppletImRecommendListExample();
      Criteria imRecommendListExampleCriteria = imRecommendListExample.createCriteria();
      imRecommendListExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      imRecommendListExampleCriteria.andImRecommendListIdEqualTo(imRecommendListId);
      AppletImRecommendList updateImRecommendList = new AppletImRecommendList();
      updateImRecommendList.setUpdateDate(new Date());
      updateImRecommendList.setRecommendStatus(IMConstants.IM_RECOMMEND_STATUS_PAYED);
      recommendListMapper.updateByExampleSelective(updateImRecommendList, imRecommendListExample);
//      int i = recommendListMapper.updateByExampleSelective(updateImRecommendList, imRecommendListExample);
//      if (i == 0) {
//        throw new RuntimeException("更新推荐清单状态失败");
//      }
      //更新推荐清单子项状态
      AppletImRecommendListItemExample recommendListItemExample = new AppletImRecommendListItemExample();
      AppletImRecommendListItemExample.Criteria recommendListItemExampleCriteria = recommendListItemExample.createCriteria();
      recommendListItemExampleCriteria.andImRecommendListIdEqualTo(imRecommendListId);
      recommendListItemExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
//      recommendListItemExampleCriteria.andRecommendStatusEqualTo(IMConstants.IM_RECOMMEND_STATUS_CONFIRM);
      recommendListItemExampleCriteria.andUserConfirmStatusEqualTo(CommonConstants.ENABLE);

      AppletImRecommendListItem updateItem = new AppletImRecommendListItem();
      updateItem.setUpdateDate(new Date());
      updateItem.setRecommendStatus(IMConstants.IM_RECOMMEND_STATUS_PAYED);
      recommendListItemMapper.updateByExampleSelective(updateItem, recommendListItemExample);
//      i = recommendListItemMapper.updateByExampleSelective(updateItem, recommendListItemExample);
//      if (i == 0) {
//        throw new RuntimeException("更新推荐清单子项状态失败");
//      }
    }
  }

  public List<AppletImRecommendListItem> getImRecommendListItemByRecommendListId(String imRecommendListId) {
    AppletImRecommendListItemExample itemExample = new AppletImRecommendListItemExample();
    AppletImRecommendListItemExample.Criteria itemExampleCriteria = itemExample.createCriteria();
    itemExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(imRecommendListId)) {
      itemExampleCriteria.andImRecommendListIdEqualTo(imRecommendListId);
    }
    List<AppletImRecommendListItem> itemList = recommendListItemMapper.selectByExample(itemExample);
    return itemList;
  }

  public List<AppletImRecommendList> getImRecommendListDoctorByParam(String userId, String doctorId, String participantId, String queryDate) {
    QueryImRecordParam param = new QueryImRecordParam();
    param.setUserId(userId);
    param.setDoctorId(doctorId);
    param.setParticipantId(participantId);
    param.setQueryDate(queryDate);
    List<AppletImRecommendList> doctorList = recommendListMapper.selectImRecommendDoctorByParam(param);
//    for (String doctorStr : doctorList) {
//      param = new QueryImRecordParam();
//      param.setDoctorId(doctorStr);
//      List<AppletImRecommendList> recommendLists = recommendListMapper.selectImRecommendByDoctor(param);
//      resultList.addAll(recommendLists);
//    }

    doctorList.sort(new Comparator<AppletImRecommendList>() {
      @Override
      public int compare(AppletImRecommendList o1, AppletImRecommendList o2) {
        return -o1.getCreateDate().compareTo(o2.getCreateDate());
      }
    });

    return doctorList;
  }

  public List<AppletImRecommendListItem> getLastImRecommendItemForDoctor2participant(String userId, String doctorId, String participantId) {
    QueryImRecordParam param = new QueryImRecordParam();
    if (StringUtils.isNotBlank(userId)) {
      param.setUserId(userId);
    }
    if (StringUtils.isNotBlank(doctorId)) {
      param.setDoctorId(doctorId);
    }
    if (StringUtils.isNotBlank(participantId)) {
      param.setParticipantId(participantId);
    }
    List<AppletImRecommendListItem> itemList = recommendListItemMapper.selectLastImRecommendItemForDoctor2participant(param);
    return itemList;
  }

  @Transient
  public String updateImRecommendList(DcRecommendListUpdateReqVo vo) {
    AppletImRecommendListExample listExample = new AppletImRecommendListExample();
    Criteria criteria = listExample.createCriteria();
    criteria.andImRecommendListIdIn(Arrays.asList(vo.getImRecommendListIds().split(",")));
    AppletImRecommendList recommendList = new AppletImRecommendList();
    recommendList.setRecommendStatus(vo.getRecommendStatus());
    recommendListMapper.updateByExampleSelective(recommendList, listExample);
    //修改明细信息
    List<AppletImRecommendListItem> updateList = new ArrayList<>();
    List<AppletImRecommendListItem> insertList = new ArrayList<>();
    if (StringUtils.isNotBlank(vo.getPackageNos()) && 1 == vo.getImRecommendListIds().split(",").length) {
      List<String> packageNoList = Arrays.asList(vo.getPackageNos().split(","));
      Set<String> packageNoSet = new HashSet<>();
      for (String s : packageNoList) {
        packageNoSet.add(s);
      }

      AppletImRecommendListItemExample itemExample = new AppletImRecommendListItemExample();
      AppletImRecommendListItemExample.Criteria criteria1 = itemExample.createCriteria();
      criteria1.andImRecommendListIdEqualTo(vo.getImRecommendListIds());
      List<AppletImRecommendListItem> imRecommendListItemList = recommendListItemMapper.selectByExample(itemExample);
      for (AppletImRecommendListItem imRecommendListItem : imRecommendListItemList) {
        //修改
        if (packageNoSet.contains(imRecommendListItem.getPackageNo())) {
          imRecommendListItem.setRecommendStatus(vo.getRecommendStatus());
          imRecommendListItem.setUpdateDate(new Date());
        } else {
          //删除
          imRecommendListItem.setDelFlag(1);
          imRecommendListItem.setUpdateDate(new Date());
        }
        updateList.add(imRecommendListItem);
        packageNoSet.remove(imRecommendListItem.getPackageNo());
      }
      //新增
      List<String> packageNos = new ArrayList<>(packageNoSet);
      if (packageNos.size() > 0) {
        AppletPackageExample example = new AppletPackageExample();
        AppletPackageExample.Criteria criteria2 = example.createCriteria();
        criteria2.andPackageIdIn(packageNos);
        List<AppletPackage> packageList = appletPackageMapper.selectByExample(example);
        for (AppletPackage appletPackage : packageList) {
          AppletImRecommendListItem item = new AppletImRecommendListItem();
          item.setImRecommendListId(vo.getImRecommendListIds());
          item.setPackageNo(appletPackage.getPackageId());
          item.setPackageName(appletPackage.getPackageName());
          item.setPackageCurrentPrice(appletPackage.getPackageCurrentPrice());
          item.setDelFlag(CommonConstants.INIT);
          item.setCreateDate(new Date());
          item.setUpdateDate(new Date());
          item.setRecommendStatus(1);
          insertList.add(item);
        }
      }
      if (insertList.size() > 0) {
        recommendListItemMapper.insertBatch(insertList);
      }
      if (updateList.size() > 0) {
        for (AppletImRecommendListItem imRecommendListItem : updateList) {
          recommendListItemMapper.updateByPrimaryKeySelective(imRecommendListItem);
        }
      }
    } else {
      AppletImRecommendListItemExample listItemExample = new AppletImRecommendListItemExample();
      Criteria criteria1 = listExample.createCriteria();
      criteria1.andImRecommendListIdIn(Arrays.asList(vo.getImRecommendListIds().split(",")));
      AppletImRecommendListItem recommendListItem = new AppletImRecommendListItem();
      recommendList.setRecommendStatus(vo.getRecommendStatus());
      recommendListItemMapper.updateByExampleSelective(recommendListItem, listItemExample);
    }
    //生成imRecord记录
    List<AppletImRecommendList> appletImRecommendLists = recommendListMapper.selectByExample(listExample);
    if (appletImRecommendLists != null && appletImRecommendLists.size() > 0) {
      AppletImRecommendList imRecommend = appletImRecommendLists.get(0);
      String imRocordId = numberGeneratorUtils.generateImRecordId();
      AppletImRecord appletImRecord = new AppletImRecord();
      appletImRecord.setImRecordId(imRocordId);
      appletImRecord.setDoctorId(imRecommend.getDoctorId());
      appletImRecord.setUserId(imRecommend.getUserId());
      AppletUser appletUser = userService.getUserById(imRecommend.getUserId());
      if(appletUser != null){
        appletImRecord.setUserPhone(appletUser.getUserPhone());
      }
      appletImRecord.setParticipantId(imRecommend.getParticipantId());
      appletImRecord.setParticipantName(imRecommend.getParticipantName());
      appletImRecord.setParticipantPhone(imRecommend.getParticipantPhone());
      appletImRecord.setStatus(IM_STATUS_START);
      appletImRecord.setAmount(new BigDecimal(0));
      appletImRecord.setDelFlag(CommonConstants.INIT);
      appletImRecord.setCreateDate(new Date());
      appletImRecord.setUpdateDate(new Date());
      appletImRecord.setType(IM_REVIEW_TYPE_FIRST_VISIT);
      appletImRecord.setPayStatus(0);
      appletImRecord.setPayAmount(new BigDecimal(0));
      appletImRecordMapper.insertSelective(appletImRecord);
    }
    return "";
  }

  public List<AppletImRecommendList> getImRecommendListByUser(String userId) {
    AppletImRecommendListExample recommendListExample = new AppletImRecommendListExample();
    Criteria recommendListExampleCriteria = recommendListExample.createCriteria();
    recommendListExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(userId)) {
      recommendListExampleCriteria.andUserIdEqualTo(userId);
    }
    List<AppletImRecommendList> result = recommendListMapper.selectByExample(recommendListExample);
    return result;
  }

  public List<AppletImRecommendList> getImRecommendListByOrder(String orderNo) {
    if (StringUtils.isBlank(orderNo)) {
      return null;
    }
    AppletImRecommendListExample recommendListExample = new AppletImRecommendListExample();
    Criteria recommendListExampleCriteria = recommendListExample.createCriteria();
    recommendListExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    recommendListExampleCriteria.andOrderNoEqualTo(orderNo);
    List<AppletImRecommendList> result = recommendListMapper.selectByExample(recommendListExample);
    return result;
  }

  /**
   * 自动失效申请单
   */
  public int invalidRecommendList(Integer reviewType) {
    AppletImRecommendListExample example = new AppletImRecommendListExample();
    Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andReviewTypeEqualTo(reviewType);
    if (reviewType == 0) {
      criteria.andCreateDateLessThan(DateUtils.getDistanceDate(new Date(), -1));
    } else if (reviewType == 1) {
      criteria.andCreateDateLessThan(DateUtils.getDistanceDate(new Date(), -7));
    }
    List<Integer> integerList = new ArrayList<>(2);
    integerList.add(0);
    integerList.add(1);
    criteria.andRecommendStatusIn(integerList);
    AppletImRecommendList list = new AppletImRecommendList();
    list.setRecommendStatus(-1);
    return recommendListMapper.updateByExampleSelective(list, example);
  }

}
