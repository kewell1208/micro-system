package com.tclab.weixinappletservice.service.clientService;

import static com.tclab.weixinappletcommon.constant.IMConstants.IM_INTERPRET_STATUS_END;
import static com.tclab.weixinappletcommon.constant.IMConstants.IM_INTERPRET_TYPE_OTHER;
import static com.tclab.weixinappletcommon.constant.IMConstants.IM_INTERPRET_TYPE_SELF;
import static com.tclab.weixinappletcommon.constant.IMConstants.IM_STATUS_END;
import static com.tclab.weixinappletcommon.constant.IMConstants.IM_STATUS_START;
import static com.tclab.weixinappletcommon.constant.OrderConstants.ORDER_STATUS_COMPLETED;

import com.github.pagehelper.PageHelper;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.IDCardUtils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletcommon.utils.SMSUtils;
import com.tclab.weixinappletservice.dao.AppletDoctorMapper;
import com.tclab.weixinappletservice.dao.AppletImRecommendListItemMapper;
import com.tclab.weixinappletservice.dao.AppletImRecommendListMapper;
import com.tclab.weixinappletservice.dao.AppletImRecordMapper;
import com.tclab.weixinappletservice.dao.AppletInterpretGoodMapper;
import com.tclab.weixinappletservice.dao.AppletInterpretMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.model.query.QueryImRecordParam;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ImRecordBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.ImRecordQueryReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.ImRecordUpdateReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.ImReqVo;
import com.tclab.weixinappletservice.pojo.AppletDoctor;
import com.tclab.weixinappletservice.pojo.AppletDoctorExample;
import com.tclab.weixinappletservice.pojo.AppletImRecommendList;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListExample;
import com.tclab.weixinappletservice.pojo.AppletImRecord;
import com.tclab.weixinappletservice.pojo.AppletImRecordExample;
import com.tclab.weixinappletservice.pojo.AppletImRecordExample.Criteria;
import com.tclab.weixinappletservice.pojo.AppletInterpret;
import com.tclab.weixinappletservice.pojo.AppletInterpretExample;
import com.tclab.weixinappletservice.pojo.AppletInterpretGood;
import com.tclab.weixinappletservice.pojo.AppletInterpretGoodExample;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletUser;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Package：com.tclab.weixinappletservice.service.clientService
 * @Class：ImRecordService
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/10 9:47 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Service
public class ImRecordService {

  private static final Logger logger = LoggerFactory.getLogger(ImRecordService.class);

  @Autowired
  private AppletImRecordMapper appletImRecordMapper;
  @Autowired
  private PayService payService;
  @Autowired
  private AppletInterpretMapper appletInterpretMapper;
  @Autowired
  private RedisUtils redisUtils;
  @Autowired
  private AppletDoctorMapper appletDoctorMapper;
  @Autowired
  private ParticipantService participantService;
  @Autowired
  private UserService userService;
  @Autowired
  private AppletImRecommendListMapper appletImRecommendListMapper;
  @Autowired
  private AppletImRecommendListItemMapper appletImRecommendListItemMapper;
  @Autowired
  private ImRecommendListService recommendListService;
  @Autowired
  private ImRecordService imRecordService;
  @Autowired
  private AppletOrderMapper appletOrderMapper;
  @Autowired
  private NumberGeneratorUtils numberGeneratorUtils;
  @Autowired
  private AppletInterpretGoodMapper interpretGoodMapper;

  public List<ImRecordBaseVo> getListByDoctor(ImRecordQueryReqVo vo) {
    List<ImRecordBaseVo> list = new ArrayList<>();
    AppletImRecordExample example = new AppletImRecordExample();
    example.setOrderByClause(" create_date desc");
    Criteria criteria = example.createCriteria();

    criteria.andDoctorIdEqualTo(vo.getDoctorIds());

    if (StringUtils.isNotBlank(vo.getParticipantQuery())) {
      String regex = "^[0-9]*$";
      if (vo.getParticipantQuery().matches(regex)) {
        criteria.andParticipantPhoneLike("%" + vo.getParticipantQuery() + "%");
      } else {
        criteria.andParticipantNameLike("%" + vo.getParticipantQuery() + "%");
      }
    }

    if (StringUtils.isNotBlank(vo.getUserIds())) {
      List<String> ids = new ArrayList<>();
      ids = Arrays.asList(vo.getUserIds().split(","));
      criteria.andUserIdIn(ids);
    }
    if (StringUtils.isNotBlank(vo.getStatus())) {
      List<String> stringList = Arrays.asList(vo.getStatus().split(","));
      List<Integer> statusList = new ArrayList<>();
      for (String s : stringList) {
        statusList.add(Integer.parseInt(s));
      }
      criteria.andStatusIn(statusList);
    }
    if (StringUtils.isNotBlank(vo.getType())) {
      List<String> stringList = Arrays.asList(vo.getType().split(","));
      List<Integer> typeList = new ArrayList<>();
      for (String s : stringList) {
        typeList.add(Integer.parseInt(s));
      }
      criteria.andTypeIn(typeList);
    }
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (vo.getPageNo() != null && vo.getPageSize() != null) {
      PageHelper.startPage(vo.getPageNo(), vo.getPageSize());
    }
    List<AppletImRecord> appletImRecordList = appletImRecordMapper.getListByDoctor(example);
    for (AppletImRecord appletImRecord : appletImRecordList) {
      ImRecordBaseVo imRecordBaseVo = new ImRecordBaseVo();
      BeanUtils.copyProperties(appletImRecord, imRecordBaseVo);
      imRecordBaseVo.setCreateDate(DateUtils.formatSdfForMinDate(appletImRecord.getCreateDate()));
      imRecordBaseVo.setPayDate(DateUtils.formatSdfForMinDate(appletImRecord.getPayDate()));
      imRecordBaseVo.setUpdateDate(DateUtils.formatSdfForMinDate(appletImRecord.getUpdateDate()));
      list.add(imRecordBaseVo);
    }

    return list;
  }

  public void updateImRecordStatus(ImRecordUpdateReqVo vo) {
    AppletImRecordExample example = new AppletImRecordExample();
    Criteria criteria = example.createCriteria();
    criteria.andImRecordIdEqualTo(vo.getImRecordId());
    List<AppletImRecord> appletImRecordList = appletImRecordMapper.selectByExample(example);
    if (appletImRecordList == null || appletImRecordList.size() == 0) {
      throw new RuntimeException("未找到IM即时通讯信息");
    }
    AppletImRecord record = new AppletImRecord();
    if (StringUtils.isNotBlank(vo.getStatus())) {
      record.setStatus(Integer.parseInt(vo.getStatus()));
      if ((IM_STATUS_END + "").equals(vo.getStatus())) {
        imRecordService.canFinish(vo.getImRecordId());
        record.setFinishDate(new Date());
      }
    }
    record.setUpdateDate(new Date());
    Integer i = appletImRecordMapper.updateByExampleSelective(record, example);
    if (i == 0) {
      throw new RuntimeException("保存失败");
    }
  }

  public String updateDoctorSuggestion(ImRecordUpdateReqVo vo) {
    AppletInterpret appletInterpret = new AppletInterpret();
    ImRecordBaseVo imRecord = imRecordService.getImRecordById(vo.getImRecordId());
    if (imRecord == null) {
      throw new RuntimeException("未找到IM即时通讯记录");
    }
    if (StringUtils.isNotBlank(vo.getInterpretId())) {
      AppletInterpretExample interpretExample = new AppletInterpretExample();
      AppletInterpretExample.Criteria interpretExampleCriteria = interpretExample.createCriteria();
      interpretExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      interpretExampleCriteria.andInterpretIdEqualTo(vo.getInterpretId());
      appletInterpret.setInterpretImg(vo.getImgUrl());
      appletInterpret.setParticipantDiagnose(vo.getParticipantDiagnose());
      appletInterpret.setInterpretContent(vo.getInterpretContent());
      appletInterpret.setInterpretDate(new Date());
      appletInterpret.setUpdateDate(new Date());
      appletInterpret.setInterpretStatus(1);
      int i = appletInterpretMapper.updateByExampleSelective(appletInterpret, interpretExample);
      if (i == 0) {
        throw new RuntimeException("修改问诊意见失败");
      }
      return vo.getInterpretId();
    } else {
      String interpretId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_INTERPRET);
      appletInterpret.setInterpretId(interpretId);
      appletInterpret.setImRecordId(vo.getImRecordId());
      appletInterpret.setParticipantId(vo.getParticipantId());
      AppletOrderParticipant participant = participantService.getParticipantByParticipantId(imRecord.getParticipantId());
      if (participant != null) {
        appletInterpret.setParticipantName(participant.getParticipantName());
        appletInterpret.setParticipantPhone(participant.getParticipantPhone());
      }
      appletInterpret.setDoctorId(vo.getDoctorId());
      appletInterpret.setInterpretImg(vo.getImgUrl());
      appletInterpret.setParticipantDiagnose(vo.getParticipantDiagnose());
      appletInterpret.setInterpretContent(vo.getInterpretContent());
      appletInterpret.setInterpretDate(new Date());
      appletInterpret.setInterpretType(IM_INTERPRET_TYPE_SELF);
      appletInterpret.setInterpretCost(new BigDecimal(0));
      appletInterpret.setCreateDate(new Date());
      appletInterpret.setUpdateDate(new Date());
      appletInterpret.setDelFlag(CommonConstants.INIT);
      appletInterpret.setInterpretStatus(1);
      int i = appletInterpretMapper.insert(appletInterpret);
      if (i == 0) {
        throw new RuntimeException("插入问诊意见失败");
      }
      return interpretId;
    }
  }

  @Transactional
  public boolean checkStartImRecord(String userId, String doctorId) {

    if (StringUtils.isBlank(userId)) {
      throw new RuntimeException("userId不能为空");
    }
    if (StringUtils.isBlank(doctorId)) {
      throw new RuntimeException("doctorId不能为空");
    }

    QueryImRecordParam param = new QueryImRecordParam();
    param.setUserId(userId);
    param.setDoctorId(doctorId);
    List<AppletImRecord> recordList = appletImRecordMapper.checkStartImRecord(param);

    if (recordList.size() != 0) {
      return false;
    } else {
      return true;
    }
  }

  @Transactional
  public AppletImRecord returnCheckStartImRecordId(String userId, String doctorId) {

    if (StringUtils.isBlank(userId)) {
      throw new RuntimeException("userId不能为空");
    }
    if (StringUtils.isBlank(doctorId)) {
      throw new RuntimeException("doctorId不能为空");
    }

    QueryImRecordParam param = new QueryImRecordParam();
    param.setUserId(userId);
    param.setDoctorId(doctorId);
    List<AppletImRecord> recordList = appletImRecordMapper.checkStartImRecord(param);

    if (recordList.size() != 0) {
      return recordList.get(0);
    } else {
      return null;
    }
  }

  @Transactional
  public Map<String, Object> startImRecord(HttpServletRequest request, ImReqVo reqVo) {

    //判读医生服务是否结束，如果未结束则提示

    Map<String, Object> preResult = new HashMap<>();

    AppletImRecord imRecord = new AppletImRecord();
    BeanUtils.copyProperties(reqVo, imRecord);

    //生成问诊号
    String imRecordId;
    String imIndexStr;
    Integer imIndex = Integer.parseInt(redisUtils.get(RedisConstants.GENERATEID + ":" + RedisConstants.IM_INDEX));
    if (imIndex != null) {
      imIndex++;
      boolean a = redisUtils.set(RedisConstants.GENERATEID + ":" + RedisConstants.IM_INDEX, imIndex.toString());
      if (!a) {
        throw new RuntimeException("生成IM编号失败");
      }
      imIndexStr = String.format("%06d", imIndex);
    } else {
      redisUtils.set(RedisConstants.GENERATEID + ":" + RedisConstants.ORDERNO_INDEX, "1");
      imIndexStr = String.format("%06d", 1);
    }
    String day = redisUtils.get(RedisConstants.DAY);
    if (day == null) {
      day = DateUtils.formatDayString(new Date());
    }
    imRecordId = CommonConstants.GenerateID_IM + day + imIndexStr;
    imRecord.setImRecordId(imRecordId);

    imRecord.setCreateDate(new Date());
    imRecord.setUpdateDate(new Date());
    imRecord.setDelFlag(CommonConstants.INIT);
    imRecord.setPayStatus(OrderConstants.ORDER_PAY_STATUS_UNPAY);

    if (StringUtils.isNotBlank(reqVo.getParticipantId())) {
      AppletOrderParticipant participant = participantService.getParticipantByParticipantId(reqVo.getParticipantId());
      if (participant != null) {
        imRecord.setParticipantPhone(participant.getParticipantPhone());
        imRecord.setParticipantAge(IDCardUtils.getAge(participant.getParticipantIdCard()));
        imRecord.setParticipantSex(IDCardUtils.getSex(participant.getParticipantIdCard()));
      }
    }

    int i = appletImRecordMapper.insertSelective(imRecord);
    if (i == 0) {
      throw new RuntimeException("插入IM失败");
    }

    logger.info("插入IM成功");

    String prepay_id = "";

    if (reqVo.getPayAmount() != null && !reqVo.getPayAmount().equals(BigDecimal.ZERO)) {
      String payAmount = String.valueOf(reqVo.getPayAmount().multiply(new BigDecimal("100")).intValue());
      preResult = payService.wxPay(reqVo.getOpenid(), imRecordId, "IM费用", payAmount, request);
      if (preResult == null) {
        throw new RuntimeException("微信服务器返回支付结果失败");
      }
      prepay_id = (String) preResult.get("prepay_id");
    } else {
      imRecord.setPayStatus(OrderConstants.ORDER_PAY_STATUS_PAYED);
      imRecord.setPayDate(new Date());

      //如果不需要支付则直接发送短信给医生
      ImRecordBaseVo baseVo = getImRecordById(imRecordId);
      if (baseVo != null) {
//      AppletUser user = userService.getUserById(baseVo.getUserId());
//      Map<String, String> map = new HashMap<>();
//      if (user!=null) {
//        map.put("userName",user.getUserName());
//        map.put("userPhone",user.getUserPhone());
//        map.put("userName",imRecord.getParticipantName());
//        map.put("userPhone",imRecord.getParticipantPhone());
//      }

        ImRecordBaseVo queryImRecordVo = getImRecordById(imRecordId);
        Map<String, String> map = new HashMap<>();
        if (queryImRecordVo != null) {
          AppletOrderParticipant participant = participantService.getParticipantByParticipantId(queryImRecordVo.getParticipantId());
          if (participant != null) {
            map.put("userName", participant.getParticipantName());
            map.put("userPhone", participant.getParticipantPhone());
          } else {
            logger.info("参检人信息不存在");
          }
        }

        if (baseVo.getDoctorInfo() != null) {
          boolean check = SMSUtils.sendSms(baseVo.getDoctorInfo().getDoctorPhone(), map, SMSUtils.templateCodeNotifyImRecord2Doctor);
          logger.info("短信通知结果" + check);
        }
      }
    }

    //更新预下单状态
    imRecord = new AppletImRecord();
    imRecord.setUpdateDate(new Date());
    imRecord.setPreNo(prepay_id);
    imRecord.setPayStatus(OrderConstants.ORDER_PAY_STATUS_PAYING);

    AppletImRecordExample recordExample = new AppletImRecordExample();
    Criteria criteria = recordExample.createCriteria();
    criteria.andImRecordIdEqualTo(imRecordId);
    i = appletImRecordMapper.updateByExampleSelective(imRecord, recordExample);
    if (i == 0) {
      throw new RuntimeException("更新IM失败");
    }

    preResult.put("imRecordId", imRecordId);
    return preResult;
  }

  @Transactional
  public void endImRecord(ImReqVo reqVo) {
    AppletImRecordExample example = new AppletImRecordExample();
    Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andImRecordIdEqualTo(reqVo.getImRecordId());
    List<AppletImRecord> appletImRecordList = appletImRecordMapper.selectByExample(example);
    if (appletImRecordList == null || appletImRecordList.size() == 0) {
      throw new RuntimeException("未找到IM即时通讯信息");
    }
    AppletImRecord record = new AppletImRecord();
    record.setUpdateDate(new Date());
    record.setStatus(IM_STATUS_END);
    record.setFinishDate(new Date());
    Integer i = appletImRecordMapper.updateByExampleSelective(record, example);
    if (i == 0) {
      throw new RuntimeException("保存失败");
    }
  }


  @Transactional
  public void notifyImPayStatus(String imRecordId, String transactionId) {
    AppletImRecord imRecord = new AppletImRecord();

    //更新预下单状态
    imRecord = new AppletImRecord();
    imRecord.setUpdateDate(new Date());
    imRecord.setPayStatus(OrderConstants.ORDER_PAY_STATUS_PAYED);
    imRecord.setPayDate(new Date());
    imRecord.setPayNo(transactionId);

    AppletImRecordExample recordExample = new AppletImRecordExample();
    Criteria criteria = recordExample.createCriteria();
    criteria.andImRecordIdEqualTo(imRecordId);
    int i = appletImRecordMapper.updateByExampleSelective(imRecord, recordExample);
    if (i == 0) {
      throw new RuntimeException("更新IM付费失败");
    }

    //更新推荐单
//    AppletImRecommendList imRecommendList = new AppletImRecommendList();
//    imRecommendList.setUpdateDate(new Date());
//    imRecommendList.setRecommendStatus(IMConstants.IM_RECOMMEND_STATUS_PAYED);
//    AppletImRecommendListExample imRecommendListExample = new AppletImRecommendListExample();
//    AppletImRecommendListExample.Criteria imRecommendListExampleCriteria = imRecommendListExample.createCriteria();
//    imRecommendListExampleCriteria.andImrecordIdEqualTo(imRecordId);
//    appletImRecommendListMapper.updateByExampleSelective(imRecommendList,imRecommendListExample);
//
//    //查询推荐单ID
//    recommendListService.getImRecommendListByOrder()
//
//
//    //更新推荐单细项
//    AppletImRecommendListItem imRecommendListItem = new AppletImRecommendListItem();
//    imRecommendListItem.setUpdateDate(new Date());
//    imRecommendListItem.setRecommendStatus(IMConstants.IM_RECOMMEND_STATUS_PAYED);
//    AppletImRecommendListItemExample imRecommendListItemExample = new AppletImRecommendListItemExample();
//    AppletImRecommendListItemExample.Criteria imRecommendListItemExampleCriteria = imRecommendListItemExample.createCriteria();
//    imRecommendListItemExampleCriteria.(imRecordId);
//    appletImRecommendListMapper.updateByExampleSelective(imRecommendList,imRecommendListExample);

    ImRecordBaseVo baseVo = getImRecordById(imRecordId);
    if (baseVo != null) {
//      AppletUser user = userService.getUserById(baseVo.getUserId());
//      Map<String, String> map = new HashMap<>();
//      if (user!=null) {
//        map.put("userName",user.getUserName());
//        map.put("userPhone",user.getUserPhone());
//        map.put("userName",imRecord.getParticipantName());
//        map.put("userPhone",imRecord.getParticipantPhone());
//      }

      ImRecordBaseVo queryImRecordVo = getImRecordById(imRecordId);
      Map<String, String> map = new HashMap<>();
      if (queryImRecordVo != null) {
        AppletOrderParticipant participant = participantService.getParticipantByParticipantId(queryImRecordVo.getParticipantId());
        if (participant != null) {
          map.put("userName", participant.getParticipantName());
          map.put("userPhone", participant.getParticipantPhone());
        } else {
          logger.info("参检人信息不存在");
        }
      }

      if (baseVo.getDoctorInfo() != null) {
        boolean check = SMSUtils.sendSms(baseVo.getDoctorInfo().getDoctorPhone(), map, SMSUtils.templateCodeNotifyImRecord2Doctor);
        logger.info("短信通知结果" + check);
      }
    }
  }

  public List<AppletImRecord> getImRecordByParam(String userId, String doctorId, String participantId, Integer status, Integer type) {
    QueryImRecordParam param = new QueryImRecordParam();
    List<AppletImRecord> result = new ArrayList<>();
    if (StringUtils.isNotBlank(userId)) {
      param.setUserId(userId);
    }
    if (StringUtils.isNotBlank(doctorId)) {
      param.setDoctorId(doctorId);
    }
    if (StringUtils.isNotBlank(participantId)) {
      param.setParticipantId(participantId);
    }
    if (status != null) {
      param.setStatus(status);
    }
    if (type != null) {
      param.setType(type);
    }
//    List<String> doctorIdList = appletImRecordMapper.selectImRecordDoctorByParam(param);
//    for (String doctorStr:doctorIdList) {
//      param = new QueryImRecordParam();
//      param.setDoctorId(doctorStr);
//      List<AppletImRecord> recordList = appletImRecordMapper.selectImRecordByDoctor(param);
//      result.addAll(recordList);
//    }
    result = appletImRecordMapper.selectImRecordByDoctor(param);

    result.sort(new Comparator<AppletImRecord>() {
      @Override
      public int compare(AppletImRecord o1, AppletImRecord o2) {
        return -o1.getCreateDate().compareTo(o2.getCreateDate());
      }
    });
    return result;
  }

  public List<String> getImRecordDoctor(String userId) {
    QueryImRecordParam param = new QueryImRecordParam();
    param.setUserId(userId);
    return appletImRecordMapper.selectImRecordDoctor(param);
  }

  public List<AppletImRecord> selectRecentImRecordByDoctor(String userId, String doctorId) {
    return appletImRecordMapper.selectRecentImRecordByDoctor(userId, doctorId);
  }

  public ImRecordBaseVo getImRecordById(String imRecordId) {
    AppletImRecordExample example = new AppletImRecordExample();
    Criteria criteria = example.createCriteria();
    criteria.andImRecordIdEqualTo(imRecordId);
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    List<AppletImRecord> appletImRecordList = appletImRecordMapper.selectByExample(example);
    if (appletImRecordList != null && appletImRecordList.size() > 0) {
      AppletImRecord appletImRecord = appletImRecordList.get(0);
      ImRecordBaseVo vo = new ImRecordBaseVo();
      BeanUtils.copyProperties(appletImRecord, vo);
      vo.setCreateDate(DateUtils.formatSdfForMinDate(appletImRecord.getCreateDate()));
      vo.setPayDate(DateUtils.formatSdfForMinDate(appletImRecord.getPayDate()));
      vo.setUpdateDate(DateUtils.formatSdfForMinDate(appletImRecord.getUpdateDate()));
      //医生信息
      if (StringUtils.isNotBlank(appletImRecord.getDoctorId())) {
        AppletDoctorExample doctorExample = new AppletDoctorExample();
        AppletDoctorExample.Criteria doctorCriteria = doctorExample.createCriteria();
        doctorCriteria.andDoctorIdEqualTo(appletImRecord.getDoctorId());
        List<AppletDoctor> appletDoctorList = appletDoctorMapper.selectByExample(doctorExample);
        if (appletDoctorList != null && appletDoctorList.size() > 0) {
          vo.setDoctorInfo(appletDoctorList.get(0));
        }
      }
      //解读id
      AppletInterpretExample interpretExample = new AppletInterpretExample();
      interpretExample.setOrderByClause(" create_date desc");
      AppletInterpretExample.Criteria interpretExampleCriteria = interpretExample.createCriteria();
      interpretExampleCriteria.andImRecordIdEqualTo(imRecordId);
      interpretExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      List<AppletInterpret> appletInterpretList = appletInterpretMapper.selectByExample(interpretExample);
      if (appletInterpretList != null && appletInterpretList.size() > 0) {
        String interpretIds = "";
        for (AppletInterpret appletInterpret : appletInterpretList) {
          interpretIds += appletInterpret.getInterpretId() + ",";
        }
        if (StringUtils.isNotBlank(interpretIds)) {
          interpretIds = interpretIds.substring(0, interpretIds.length() - 1);
        }
        vo.setInterpretIds(interpretIds);
      }
      vo.setFinishDate(DateUtils.formatSdfForMinDate(new Date()));
      return vo;
    }
    return null;
  }

  public void canFinish(String imRecordId) {
    ImRecordBaseVo imRecordBaseVo = imRecordService.getImRecordById(imRecordId);
    if (imRecordBaseVo != null) {
      //报告未出不能结束
      AppletOrderExample orderExample = new AppletOrderExample();
      AppletOrderExample.Criteria orderExampleCriteria = orderExample.createCriteria();
      orderExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      orderExampleCriteria.andParticipantIdEqualTo(imRecordBaseVo.getParticipantId());
      orderExampleCriteria.andInterpretStaffIdEqualTo(imRecordBaseVo.getDoctorId());
      orderExampleCriteria.andOrderStatusNotEqualTo(ORDER_STATUS_COMPLETED);
      List<AppletOrder> appletOrderList = appletOrderMapper.selectByExample(orderExample);
      if (appletOrderList != null && appletOrderList.size() > 0) {
        throw new RuntimeException("患者检验报告结果未出，无法结束服务!");
      }
      //未解读不能结束
      AppletInterpretExample interpretExample = new AppletInterpretExample();
      AppletInterpretExample.Criteria interpretExampleCriteria = interpretExample.createCriteria();
      interpretExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      interpretExampleCriteria.andImRecordIdEqualTo(imRecordId);
      List<AppletInterpret> appletInterpretList = appletInterpretMapper.selectByExample(interpretExample);
      List<String> interpretIds = new ArrayList<>();
      if (appletInterpretList != null && appletInterpretList.size() > 0) {
        for (AppletInterpret appletInterpret : appletInterpretList) {
          if (appletInterpret.getInterpretStatus() != IM_INTERPRET_STATUS_END) {
            if (IM_INTERPRET_TYPE_SELF == imRecordBaseVo.getType()) {
              throw new RuntimeException("请先填写问诊建议！");
            } else if (IM_INTERPRET_TYPE_OTHER == imRecordBaseVo.getType()) {
              throw new RuntimeException("请先填写报告解读！");
            }
          }
          interpretIds.add(appletInterpret.getInterpretId());
        }
        //先判断是否出报告
        AppletInterpretGoodExample goodExample = new AppletInterpretGoodExample();
        AppletInterpretGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
        goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        goodExampleCriteria.andInterpretIdIn(interpretIds);
        goodExampleCriteria.andStatusNotEqualTo(1);
        List<AppletInterpretGood> appletInterpretGoodList = interpretGoodMapper.selectByExample(goodExample);
        if (appletInterpretGoodList.size() > 0) {
          throw new RuntimeException("您开的检验单处于有效期内或患者已购买检验服务，请不要结束聊天服务!");
        }
      }else{
        if (IM_INTERPRET_TYPE_SELF == imRecordBaseVo.getType()) {
          throw new RuntimeException("请先填写问诊建议！");
        } else if (IM_INTERPRET_TYPE_OTHER == imRecordBaseVo.getType()) {
          throw new RuntimeException("请先填写报告解读！");
        }
      }
      //24小时不能结束
      AppletImRecommendListExample example = new AppletImRecommendListExample();
      example.setOrderByClause(" create_date desc");
      AppletImRecommendListExample.Criteria criteria = example.createCriteria();
      criteria.andImrecordIdEqualTo(imRecordId);
      List<Integer> status = Arrays.asList(0, 1);
      criteria.andRecommendStatusIn(status);
      List<AppletImRecommendList> appletImRecommendLists = appletImRecommendListMapper.selectByExample(example);
      if (appletImRecommendLists != null && appletImRecommendLists.size() > 0) {
        for (AppletImRecommendList appletImRecommendList : appletImRecommendLists) {
          Date createDate = appletImRecommendList.getCreateDate();
          Long distance = System.currentTimeMillis() - createDate.getTime();
          distance = distance / (24 * 60 * 60 * 1000);
          if (distance < 1) {
            throw new RuntimeException("您开的检验单处于有效期内或患者已购买检验服务，请不要结束聊天服务!");
          }
        }
      }
    } else {
      throw new RuntimeException("未找到IM即时通讯信息");
    }
  }

  public AppletImRecord getOrInsertImRecord(AppletOrderParticipant participant, String doctorId) {
    AppletImRecordExample imRecordExample = new AppletImRecordExample();
    imRecordExample.setOrderByClause("create_date desc");
    Criteria criteria2 = imRecordExample.createCriteria();
    criteria2.andDoctorIdEqualTo(doctorId);
    criteria2.andUserIdEqualTo(participant.getUserId());
    criteria2.andDelFlagEqualTo(CommonConstants.INIT);
    criteria2.andStatusNotEqualTo(IM_STATUS_END);
    List<AppletImRecord> appletImRecordList = appletImRecordMapper.selectByExample(imRecordExample);
    AppletImRecord appletImRecord = new AppletImRecord();
    //如果没有im记录，则生成，如果有，则加入到这个沟通中
    if (appletImRecordList == null || appletImRecordList.size() == 0) {
      String imRocordId = numberGeneratorUtils.generateImRecordId();
      appletImRecord.setImRecordId(imRocordId);
      appletImRecord.setDoctorId(doctorId);
      appletImRecord.setUserId(participant.getUserId());
      AppletUser appletUser = userService.getUserById(participant.getUserId());
      if (appletUser != null) {
        appletImRecord.setUserPhone(appletUser.getUserPhone());
      }
      appletImRecord.setParticipantId(participant.getParticipantId());
      appletImRecord.setParticipantName(participant.getParticipantName());
      appletImRecord.setParticipantPhone(participant.getParticipantPhone());
      appletImRecord.setParticipantSex(participant.getParticipantSex());
      appletImRecord.setParticipantAge(participant.getParticipantAge());
      appletImRecord.setStatus(IM_STATUS_START);
      appletImRecord.setAmount(new BigDecimal(0));
      appletImRecord.setDelFlag(CommonConstants.INIT);
      appletImRecord.setCreateDate(new Date());
      appletImRecord.setUpdateDate(new Date());
      appletImRecord.setType(IM_INTERPRET_TYPE_OTHER);
      appletImRecord.setPayStatus(0);
      appletImRecord.setPayAmount(new BigDecimal(0));
      int i = appletImRecordMapper.insertSelective(appletImRecord);
      if (i == 0) {
        logger.error("插入IM记录失败");
        throw new RuntimeException("插入IM记录失败");
      }
    } else {
      appletImRecord = appletImRecordList.get(0);
    }
    return appletImRecord;
  }

  public Map<String, Integer> queryHaveNewRecord(String doctorId) {
    AppletImRecordExample imRecordExample = new AppletImRecordExample();
    Criteria imRecordExampleCriteria = imRecordExample.createCriteria();
    imRecordExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
    imRecordExampleCriteria.andDoctorIdEqualTo(doctorId);
    List<Integer> statusList = Arrays.asList(0);
    imRecordExampleCriteria.andStatusIn(statusList);
    List<AppletImRecord> appletImRecordList = appletImRecordMapper.selectByExample(imRecordExample);
    Map<String, Integer> map = new HashMap<>(2);
    map.put("newInquiry", 0);
    map.put("newInterpret", 0);
    if (appletImRecordList.size() > 0) {
      int self = 0;
      int other = 0;
      for (AppletImRecord appletImRecord : appletImRecordList) {
        if (appletImRecord.getType() == IM_INTERPRET_TYPE_SELF) {
          self++;
        } else if (appletImRecord.getType() == IM_INTERPRET_TYPE_OTHER) {
          other++;
        }
      }
      map.put("newInquiry", self);
      map.put("newInterpret", other);
      return map;
    }
    return map;
  }
}
