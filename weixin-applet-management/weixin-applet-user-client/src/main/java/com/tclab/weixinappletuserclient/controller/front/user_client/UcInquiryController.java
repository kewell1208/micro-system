package com.tclab.weixinappletuserclient.controller.front.user_client;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.IMConstants;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletcommon.utils.WxTencentUtils;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.GoodPlaceReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ImRecordBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderPlaceReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.UcImRecommendListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.ImReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.RecommendListSaveReqVo;
import com.tclab.weixinappletservice.pojo.AppletDoctor;
import com.tclab.weixinappletservice.pojo.AppletDoctorDepartment;
import com.tclab.weixinappletservice.pojo.AppletDoctorHospital;
import com.tclab.weixinappletservice.pojo.AppletImRecommendList;
import com.tclab.weixinappletservice.pojo.AppletImRecommendListItem;
import com.tclab.weixinappletservice.pojo.AppletImRecord;
import com.tclab.weixinappletservice.pojo.AppletImRelation;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.service.clientService.DoctorDepartmentService;
import com.tclab.weixinappletservice.service.clientService.DoctorService;
import com.tclab.weixinappletservice.service.clientService.HospitalService;
import com.tclab.weixinappletservice.service.clientService.IMRelationService;
import com.tclab.weixinappletservice.service.clientService.ImRecommendListService;
import com.tclab.weixinappletservice.service.clientService.ImRecordService;
import com.tclab.weixinappletservice.service.clientService.PackageService;
import com.tclab.weixinappletservice.service.clientService.ParticipantService;
import com.tclab.weixinappletuserclient.model.req.apiReq.CouponReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.GoodPlaceReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.ImRecordReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.OrderPlaceReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.QueryDoctorReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.QueryImRecommendReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcRecommendListSaveReq;
import com.tclab.weixinappletuserclient.model.vo.DepartmentBaseInfoVo;
import com.tclab.weixinappletuserclient.model.vo.DepartmentItemBaseInfoVo;
import com.tclab.weixinappletuserclient.model.vo.DoctorBaseInfoVo;
import com.tclab.weixinappletuserclient.model.vo.DoctorCommentBaseInfoVo;
import com.tclab.weixinappletuserclient.model.vo.DoctorUcInfoVo;
import com.tclab.weixinappletuserclient.model.vo.HospitalBaseInfoVo;
import com.tclab.weixinappletuserclient.model.vo.ImRecommendInfoVo;
import com.tclab.weixinappletuserclient.model.vo.ImRecommendListBaseVo;
import com.tclab.weixinappletuserclient.model.vo.ImRecordListBaseVo;
import com.tclab.weixinappletuserclient.model.vo.RecommendListItemInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(tags = "专家问诊")
//@RestController
@Controller
@RequestMapping(value = "/user/inquiry")
public class UcInquiryController {

  private static final Logger logger = LoggerFactory.getLogger(UcInquiryController.class);

  @Autowired
  private DoctorService doctorService;
  @Autowired
  private HospitalService hospitalService;
  @Autowired
  private DoctorDepartmentService departmentService;
  @Autowired
  private IMRelationService relationService;
  @Autowired
  private ParticipantService participantService;
  @Autowired
  private ImRecordService imRecordService;
  @Autowired
  private ImRecommendListService imRecommendListService;
  @Autowired
  private PackageService packageService;
  @Autowired
  private RedisUtils redisUtils;


  @Value("${defalut.doctor.hospitalId}")
  private String defaultDoctorHospitalId;

  @ApiOperation(value = "查询医院列表", notes = "查询所有医院")
  @RequestMapping(value = "/query/hospitalList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryHospitalList(@RequestBody QueryDoctorReq req) {

    logger.info("查询医院列表" + req.toString());

    List<AppletDoctorHospital> hospitalList = hospitalService.getHospitalByArea(req.getAreaId(), req.getAreaName());
    List<HospitalBaseInfoVo> result = new ArrayList<>();
    for (AppletDoctorHospital hospital : hospitalList) {
      HospitalBaseInfoVo hospitalBaseInfoVo = new HospitalBaseInfoVo();
      BeanUtils.copyProperties(hospital, hospitalBaseInfoVo);
      result.add(hospitalBaseInfoVo);
    }
    return JsonResNewVo.buildSuccess(result);
  }

  @ApiOperation(value = "查询医院科室列表", notes = "查询所有医院")
  @RequestMapping(value = "/query/departmentList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryHospitalDepartmentList(@RequestBody QueryDoctorReq req) {

    if (StringUtils.isBlank(req.getHospitalId())) {
      req.setHospitalId(defaultDoctorHospitalId);
    }

    List<AppletDoctorDepartment> departmentList = departmentService.getDoctorDepartmentByHospital(req.getHospitalId(), req.getDoctorDepartmentId());
    List<DepartmentBaseInfoVo> baseInfoVoList = new ArrayList<>();
    boolean check = false;
    for (AppletDoctorDepartment department : departmentList) {
      for (DepartmentBaseInfoVo departmentBaseInfoVo : baseInfoVoList) {
        if (StringUtils.isNotBlank(department.getPid())) {
          //如果科室有pid，则表示科室是个子科室
          if (departmentBaseInfoVo.getDepartmentPId().equals(department.getPid())) {
            //如果结果集中的pid和查询中的pid一致,则直接在结果集中添加
            if (StringUtils.isBlank(departmentBaseInfoVo.getDepartmentPidName())) {
              departmentBaseInfoVo.setDepartmentPidName(department.getDepartmentName());
            }
            DepartmentItemBaseInfoVo itemBaseInfoVo = new DepartmentItemBaseInfoVo();
            itemBaseInfoVo.setDepartmentId(department.getDoctorDepartmentId());
            itemBaseInfoVo.setDepartmentName(department.getDepartmentName());
            departmentBaseInfoVo.getItemList().add(itemBaseInfoVo);
            check = true;
          }
        } else {
          //如果科室没有pid，则表示科室是个父科室
          DepartmentBaseInfoVo parentDepartmentBaseInfoVo = new DepartmentBaseInfoVo();
          parentDepartmentBaseInfoVo.setDepartmentPId(department.getDoctorDepartmentId());
          parentDepartmentBaseInfoVo.setDepartmentPidName(department.getDepartmentName());
          baseInfoVoList.add(parentDepartmentBaseInfoVo);
        }
      }
      if (check == false) {
        if (StringUtils.isBlank(department.getPid())) {
          //不存在科室的父ID表示是一个未分类的父类科室
          DepartmentBaseInfoVo departmentBaseInfoVo = new DepartmentBaseInfoVo();
          departmentBaseInfoVo.setDepartmentPId(department.getDoctorDepartmentId());
          departmentBaseInfoVo.setDepartmentPidName(department.getDepartmentName());
          baseInfoVoList.add(departmentBaseInfoVo);
        } else {
          //存在科室的父ID表示是一个未分类的子类科室条目
          DepartmentBaseInfoVo departmentBaseInfoVo = new DepartmentBaseInfoVo();
          departmentBaseInfoVo.setDepartmentPId(department.getPid());
          List<DepartmentItemBaseInfoVo> itemBaseInfoVoList = departmentBaseInfoVo.getItemList();
          DepartmentItemBaseInfoVo infoVo = new DepartmentItemBaseInfoVo();
          infoVo.setDepartmentName(department.getDepartmentName());
          infoVo.setDepartmentId(department.getDoctorDepartmentId());
          itemBaseInfoVoList.add(infoVo);
          baseInfoVoList.add(departmentBaseInfoVo);
        }
      }
    }
    return JsonResNewVo.buildSuccess(baseInfoVoList);
  }

  @ApiOperation(value = "查询医生列表", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/doctorList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryDoctorList(@RequestBody QueryDoctorReq req) {

    logger.info("查询医生列表" + req.toString());

    List<AppletDoctor> queryList = doctorService.getDoctorByParam(null, req.getHospitalId(), req.getDoctorDepartmentId(), req.getQueryParam(),req.getDoctorAuthority());
    List<DoctorBaseInfoVo> resultList = new ArrayList<>();
    for (AppletDoctor doctor : queryList) {
      DoctorBaseInfoVo doctorBaseInfoVo = new DoctorBaseInfoVo();
      BeanUtils.copyProperties(doctor, doctorBaseInfoVo);
      AppletDoctorHospital hospital = hospitalService.getHospitalById(doctor.getHospitalId());
      if (hospital != null) {
        doctorBaseInfoVo.setHospitalName(hospital.getHospitalName());
      }
      AppletDoctorDepartment department = departmentService.getDoctorDepartmentById(doctor.getDoctorDepartmentId());
      if (department != null) {
        doctorBaseInfoVo.setDepartmentName(department.getDepartmentName());
      }
      resultList.add(doctorBaseInfoVo);
    }
    return JsonResNewVo.buildSuccess(resultList);
  }

  @ApiOperation(value = "查询医生详情", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/doctorDetail", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryDoctorDetail(@RequestBody QueryDoctorReq req) {

    logger.info("查询医生详情" + req.toString());

    DoctorUcInfoVo doctorUcInfoVo = new DoctorUcInfoVo();
    AppletDoctor doctor = doctorService.getDoctorByDoctorId(req.getDoctorId());
    if (doctor != null) {
      BeanUtils.copyProperties(doctor, doctorUcInfoVo);
      doctorUcInfoVo.setDoctorScore(doctor.getDoctorScore());
      AppletDoctorHospital hospital = hospitalService.getHospitalById(doctor.getHospitalId());
      if (hospital != null) {
        doctorUcInfoVo.setHospitalName(hospital.getHospitalName());
      }
      AppletDoctorDepartment department = departmentService.getDoctorDepartmentById(doctor.getDoctorDepartmentId());
      if (department != null) {
        doctorUcInfoVo.setDepartmentName(department.getDepartmentName());
      }
    }

    List<DoctorCommentBaseInfoVo> commentVoList = new ArrayList<>();
    List<AppletImRelation> relationList = relationService.getRelationByDoctor(req.getDoctorId());
    for (AppletImRelation relation : relationList) {
      DoctorCommentBaseInfoVo commentBaseInfoVo = new DoctorCommentBaseInfoVo();
      BeanUtils.copyProperties(relation, commentBaseInfoVo);
      AppletOrderParticipant participant = participantService.getParticipantByParticipantId(relation.getParticipantId());
      if (participant != null) {
        commentBaseInfoVo.setParticipantName(participant.getParticipantName());
      }
      commentVoList.add(commentBaseInfoVo);
    }

    doctorUcInfoVo.setCommentList(commentVoList);

    AppletImRelation imRelation = relationService.getAttentionRelationByUserAndDoctor(req.getUserId(), req.getDoctorId());
    if (imRelation == null) {
      doctorUcInfoVo.setAttentionFlag(CommonConstants.INIT);
    } else {
      doctorUcInfoVo.setAttentionFlag(imRelation.getParticipantAttentionFlag());
    }

    return JsonResNewVo.buildSuccess(doctorUcInfoVo);
  }

  @ApiOperation(value = "检查是否可以发起咨询", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/check/startImRecord", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo checkStartImRecord(@RequestBody ImRecordReq req) {
    logger.info("查询是否可以发起咨询请求" + req.toString());
    boolean result = imRecordService.checkStartImRecord(req.getUserId(), req.getDoctorId());
    return JsonResNewVo.buildSuccess(result);
  }

  @ApiOperation(value = "返回检查是否可以发起咨询", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/return/startImRecord", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo returnCheckStartImRecord(@RequestBody ImRecordReq req) {
    logger.info("查询是否可以发起咨询请求" + req.toString());
    AppletImRecord result = imRecordService.returnCheckStartImRecordId(req.getUserId(), req.getDoctorId());
    return JsonResNewVo.buildSuccess(result);
  }

  @ApiOperation(value = "结束咨询", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/end/imRecord", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo endImRecord(@RequestBody ImRecordReq req) {
    logger.info("结束咨询请求" + req.toString());
    ImReqVo reqVo = new ImReqVo();
    BeanUtils.copyProperties(req, reqVo);
    imRecordService.endImRecord(reqVo);
    return JsonResNewVo.buildSuccess(DateUtils.formatSdfForMinDate(new Date()));
  }

  @ApiOperation(value = "查询咨询", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/imRecord", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryImRecord(@RequestBody ImRecordReq req) {
    logger.info("查询咨询" + req.toString());
    return JsonResNewVo.buildSuccess(imRecordService.getImRecordById(req.getImRecordId()));
  }

  @ApiOperation(value = "发起咨询", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/start/imRecord", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo startImRecord(HttpServletRequest request, @RequestBody ImRecordReq req) {
//        logger.info("查询是否可以发起咨询请求"+req.toString());
//        boolean result = imRecordService.checkStartImRecord(req.getUserId(),req.getDoctorId());
//        if (result == false){
//            return JsonResNewVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(),"问诊中请先结束沟通");
//        }

    logger.info("发起咨询请求" + req.toString());
    ImReqVo reqVo = new ImReqVo();
    BeanUtils.copyProperties(req, reqVo);
    Map<String, Object> imRecordPreOrderResult = imRecordService.startImRecord(request, reqVo);
    return JsonResNewVo.buildSuccess(imRecordPreOrderResult);
  }

  @ApiOperation(value = "发起复诊推荐清单", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/start/recommendList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo openRecommendList(@RequestBody DcRecommendListSaveReq req) {
    RecommendListSaveReqVo vo = new RecommendListSaveReqVo();
    BeanUtils.copyProperties(req, vo);
    String imRecommendListId = imRecommendListService.openImRecommendList(vo);
    return JsonResNewVo.buildSuccess(imRecommendListId);
  }

  @ApiOperation(value = "查询推荐清单", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/recommendListById", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryRecommendListById(@RequestBody DcRecommendListSaveReq req) {
    logger.info("查询推荐清单" + req.getImRecommendListId());
    UcImRecommendListVo listVo = imRecommendListService.getListByImRecommedListId(req.getImRecommendListId());
    return JsonResNewVo.buildSuccess(listVo);
  }

  @ApiOperation(value = "确认推荐清单", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/confirm/recommendList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo confirmRecommendList(@RequestBody DcRecommendListSaveReq req) {
    RecommendListSaveReqVo vo = new RecommendListSaveReqVo();
    BeanUtils.copyProperties(req, vo);
    imRecommendListService.confirmImRecommendList(vo);
    return JsonResNewVo.buildSuccess();
  }

  @ApiOperation(value = "下单推荐清单", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/order/recommendList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo orderRecommendList(@RequestBody OrderPlaceReq req) {
    logger.info("下单推荐清单" + req.toString());
    OrderPlaceReqVo vo = new OrderPlaceReqVo();
    BeanUtils.copyProperties(req, vo);
    logger.info("医生ID" + req.getDoctorId());
    vo.setDoctorId(req.getDoctorId());
    List<GoodPlaceReqVo> goodPlaceReqVos = new ArrayList<>();
    List<GoodPlaceReq> goodPlaceReqs = req.getGoods();
    for (GoodPlaceReq placeReq : goodPlaceReqs) {
      GoodPlaceReqVo reqVo = new GoodPlaceReqVo();
      BeanUtils.copyProperties(placeReq, reqVo);
      goodPlaceReqVos.add(reqVo);
    }
    vo.setGoods(goodPlaceReqVos);
    String orderNo = imRecommendListService.orderImRecommendList(vo);
    return JsonResNewVo.buildSuccess(orderNo);
  }

  @ApiOperation(value = "查询医生推荐清单列表", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/recommendListDoctorList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryRecommendListDoctorList(@RequestBody QueryImRecommendReq req) {
    List<AppletImRecommendList> recommendListList = imRecommendListService.getImRecommendListDoctorByParam(req.getUserId(), req.getDoctorId(), req.getParticipantId(), req.getQueryDate());
    List<ImRecommendListBaseVo> recommendListBaseVoList = new ArrayList<>();
    for (AppletImRecommendList recommendList : recommendListList) {
      ImRecommendListBaseVo recommendListBaseVo = new ImRecommendListBaseVo();
      BeanUtils.copyProperties(recommendList, recommendListBaseVo);
      AppletDoctor doctor = doctorService.getDoctorByDoctorId(recommendList.getDoctorId());
      recommendListBaseVo.setDoctorRank(doctor.getDoctorRank());
      recommendListBaseVo.setHospitalId(doctor.getHospitalId());
      if (doctor != null) {
        recommendListBaseVo.setDoctorName(doctor.getDoctorName());
        AppletDoctorHospital hospital = hospitalService.getHospitalById(doctor.getHospitalId());
        AppletDoctorDepartment department = departmentService.getDoctorDepartmentById(doctor.getDoctorDepartmentId());
        if (department != null) {
          recommendListBaseVo.setDepartmentName(department.getDepartmentName());
        }
        if (hospital != null) {
          recommendListBaseVo.setHospitalName(hospital.getHospitalName());
        }
      }
      recommendListBaseVoList.add(recommendListBaseVo);
    }
    return JsonResNewVo.buildSuccess(recommendListBaseVoList);
  }

  @ApiOperation(value = "查询关注医生列表", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/attentionDoctorList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryAttentionDoctorList(@RequestBody QueryImRecommendReq req) {
    List<DoctorBaseInfoVo> result = new ArrayList<>();
    List<AppletImRelation> relationList = relationService.getAttentionRelationByUser(req.getUserId());
    for (AppletImRelation relation : relationList) {
      DoctorBaseInfoVo doctorBaseInfoVo = new DoctorBaseInfoVo();
      AppletDoctor dcotor = doctorService.getDoctorByDoctorId(relation.getDoctorId());
      if (dcotor != null) {
        BeanUtils.copyProperties(dcotor, doctorBaseInfoVo);
        result.add(doctorBaseInfoVo);
      }
    }
    return JsonResNewVo.buildSuccess(result);
  }

  @ApiOperation(value = "关注医生", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/attention/doctor", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo attentionDoctor(@RequestBody QueryImRecommendReq req) {
    logger.info("关注医生" + req.toString());
    Integer result = relationService.changeAttention(req.getUserId(), req.getDoctorId());
    return JsonResNewVo.buildSuccess(result);
  }

  @ApiOperation(value = "查询问诊列表", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/imRecordList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryImRecordList(@RequestBody QueryImRecommendReq req) {
//        List<ImRecordListBaseVo> result = new ArrayList<>();
//        List<AppletImRecord> recordList = imRecordService.getImRecordByParam(req.getUserId(),req.getDoctorId(),req.getParticipantId(),req.getInquiryStatus(),req.getInterpretStatus(),req.getInterpretType());
//        for (AppletImRecord record:recordList) {
//            ImRecordListBaseVo baseVo = new ImRecordListBaseVo();
//            BeanUtils.copyProperties(record,baseVo);
//            AppletDoctor doctor = doctorService.getDoctorByDoctorId(req.getDoctorId());
//            if (doctor!=null){
//                baseVo.setDoctorName(doctor.getDoctorName());
//                baseVo.setDoctorRank(doctor.getDoctorRank());
//            }
//            result.add(baseVo);
//        }
//        List<String> doctorList = imRecordService.getImRecordDoctor(req.getUserId());
//        for (String doctorId:doctorList) {
//            ImRecordListBaseVo baseVo = new ImRecordListBaseVo();
//            BeanUtils.copyProperties(record,baseVo);
//            AppletDoctor doctor = doctorService.getDoctorByDoctorId(req.getDoctorId());
//            if (doctor!=null){
//                baseVo.setDoctorName(doctor.getDoctorName());
//                baseVo.setDoctorRank(doctor.getDoctorRank());
//            }
//            result.add(baseVo);
//        }
//        return JsonResNewVo.buildSuccess(result);

    logger.info("查询问诊列表" + req.toString());

    List<ImRecordListBaseVo> result = new ArrayList<>();
    List<String> doctorList = imRecordService.getImRecordDoctor(req.getUserId());
    for (String doctorId : doctorList) {
      List<AppletImRecord> recordList = imRecordService.selectRecentImRecordByDoctor(req.getUserId(), doctorId);
      AppletImRecord size = recordList.get(0);
      ImRecordListBaseVo baseVo = new ImRecordListBaseVo();
      BeanUtils.copyProperties(size, baseVo);
      AppletDoctor doctor = doctorService.getDoctorByDoctorId(doctorId);
      if (doctor != null) {
        baseVo.setDoctorName(doctor.getDoctorName());
        baseVo.setDoctorRank(doctor.getDoctorRank());
        baseVo.setDoctorHospitalName(doctor.getHospitalName());
        baseVo.setDoctorDepartmentName(doctor.getDoctorDepartmentName());
      }
      result.add(baseVo);
    }
    return JsonResNewVo.buildSuccess(result);
  }

//    @RequestMapping(value = "/test", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
//    @ResponseBody
//    public JsonResNewVo test(@RequestBody QueryImRecommendReq req){
//        return JsonResNewVo.buildSuccess(imRecordService.getImRecordDoctor(req.getUserId()));
//        List<ImRecordListBaseVo> result = new ArrayList<>();
//        List<String> doctorList = imRecordService.getImRecordDoctor(req.getUserId());
//        for (String doctorId:doctorList) {
//            List<AppletImRecord> recordList = imRecordService.selectRecentImRecordByDoctor(doctorId);
//            AppletImRecord size = recordList.get(0);
//            ImRecordListBaseVo baseVo = new ImRecordListBaseVo();
//            BeanUtils.copyProperties(size,baseVo);
//            AppletDoctor doctor = doctorService.getDoctorByDoctorId(req.getDoctorId());
//            if (doctor!=null){
//                baseVo.setDoctorName(doctor.getDoctorName());
//                baseVo.setDoctorRank(doctor.getDoctorRank());
//            }
//            result.add(baseVo);
//        }
//        return JsonResNewVo.buildSuccess(result);
//    }

  @ApiOperation(value = "查询解读列表", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/interpretImRecordList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryInterpretImRecordList(@RequestBody QueryImRecommendReq req) {
    List<ImRecordListBaseVo> result = new ArrayList<>();
    List<AppletImRecord> recordList = imRecordService
        .getImRecordByParam(req.getUserId(), req.getDoctorId(), req.getParticipantId(),  req.getStatus(), IMConstants.IM_INTERPRET_TYPE_SELF);
    for (AppletImRecord record : recordList) {
      ImRecordListBaseVo baseVo = new ImRecordListBaseVo();
      BeanUtils.copyProperties(record, baseVo);
      AppletDoctor doctor = doctorService.getDoctorByDoctorId(req.getDoctorId());
      if (doctor != null) {
        baseVo.setDoctorName(doctor.getDoctorName());
        baseVo.setDoctorRank(doctor.getDoctorRank());
      }
      result.add(baseVo);
    }
    return JsonResNewVo.buildSuccess(result);
  }

  @ApiOperation(value = "查询推荐清单细项列表详情", notes = "按照分类查询所有医生")
  @RequestMapping(value = "/query/recommendListItemInfo", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryRecommendListItemInfo(@RequestBody QueryImRecommendReq req) {
    List<AppletImRecommendListItem> itemList = imRecommendListService.getImRecommendListItemByRecommendListId(req.getImRecommendListId());
    List<RecommendListItemInfoVo> result = new ArrayList<>();
    for (AppletImRecommendListItem item : itemList) {
      RecommendListItemInfoVo itemInfoVo = new RecommendListItemInfoVo();
      BeanUtils.copyProperties(item, itemInfoVo);
      result.add(itemInfoVo);
    }
    return JsonResNewVo.buildSuccess(result);
  }

  @ApiOperation(value = "查询日期分类下的推荐单记录", notes = "查询日期分类下的推荐单记录")
  @RequestMapping(value = "/query/recommendListByDate", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryRecommendListByDate(@RequestBody QueryImRecommendReq req) {

    List<AppletImRecommendList> imRecommendListList = imRecommendListService.getImRecommendListDoctorByParam(req.getUserId(), req.getDoctorId(), req.getParticipantId(), null);
    List<ImRecommendInfoVo> recommendInfoVoList = new ArrayList<>();
    for (AppletImRecommendList imRecommendList : imRecommendListList) {
      ImRecommendInfoVo infoVo = new ImRecommendInfoVo();
      BeanUtils.copyProperties(imRecommendList, infoVo);
      AppletDoctor doctor = doctorService.getDoctorByDoctorId(imRecommendList.getDoctorId());
      if (doctor != null) {
        infoVo.setDoctorRank(doctor.getDoctorRank());
        infoVo.setDepartmentName(doctor.getDoctorDepartmentName());
        infoVo.setHospitalName(doctor.getHospitalName());
        infoVo.setHospitalId(doctor.getHospitalId());
      }
      List<AppletImRecommendListItem> itemList = imRecommendListService.getImRecommendListItemByRecommendListId(imRecommendList.getImRecommendListId());
      List<RecommendListItemInfoVo> itemInfoVoList = new ArrayList<>();
      for (AppletImRecommendListItem item : itemList) {
        RecommendListItemInfoVo itemInfoVo = new RecommendListItemInfoVo();
        BeanUtils.copyProperties(item, itemInfoVo);
        itemInfoVoList.add(itemInfoVo);
      }
      infoVo.setItemInfoVoList(itemInfoVoList);
      infoVo.setCreateDateStr(DateUtils.convertToSlashAndDayDate(imRecommendList.getCreateDate()));
      recommendInfoVoList.add(infoVo);
    }
    return JsonResNewVo.buildSuccess(recommendInfoVoList);
  }

  @ApiOperation(value = "查询最近套餐细项", notes = "查询最近套餐细项")
  @RequestMapping(value = "/query/recentRecommendItem", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryRecentRecommendItem(@RequestBody QueryImRecommendReq req) {

    logger.info("查询最近套餐细项" + req.toString());

    List<AppletImRecommendListItem> itemList = imRecommendListService.getLastImRecommendItemForDoctor2participant(req.getUserId(), req.getDoctorId(), req.getParticipantId());
    List<RecommendListItemInfoVo> result = new ArrayList<>();
    for (AppletImRecommendListItem item : itemList) {
      RecommendListItemInfoVo itemInfoVo = new RecommendListItemInfoVo();
      BeanUtils.copyProperties(item, itemInfoVo);
      AppletPackage appletPackage = packageService.getPackageById(item.getPackageNo());
      if (appletPackage != null) {
        itemInfoVo.setClinicalSignificance(appletPackage.getClinicalSignificance());
      }
      result.add(itemInfoVo);
    }

    Set<RecommendListItemInfoVo> set = new TreeSet<RecommendListItemInfoVo>(new Comparator<RecommendListItemInfoVo>() {
      @Override
      public int compare(RecommendListItemInfoVo a, RecommendListItemInfoVo b) {
        return a.getPackageName().compareTo(b.getPackageName());
      }
    });

    set.addAll(result);

    return JsonResNewVo.buildSuccess(new ArrayList<RecommendListItemInfoVo>(set));
  }

  @ApiOperation(value = "查询我申请的套餐", notes = "查询最近套餐细项")
  @RequestMapping(value = "/query/userApplyRecommend", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryUserApplyRecommend(@RequestBody QueryImRecommendReq req) {

    logger.info("查询我申请的套餐" + req.toString());

    List<AppletImRecommendList> recommendListList = imRecommendListService.getImRecommendListByUser(req.getUserId());
    List<ImRecommendListBaseVo> recommendListBaseVoList = new ArrayList<>();
    for (AppletImRecommendList recommendList : recommendListList) {
      ImRecommendListBaseVo recommendListBaseVo = new ImRecommendListBaseVo();
      BeanUtils.copyProperties(recommendList, recommendListBaseVo);
      AppletDoctor doctor = doctorService.getDoctorByDoctorId(recommendList.getDoctorId());
      recommendListBaseVo.setDoctorRank(doctor.getDoctorRank());
      recommendListBaseVo.setHospitalId(doctor.getHospitalId());
      if (doctor != null) {
        recommendListBaseVo.setDoctorName(doctor.getDoctorName());
        if (StringUtils.isNotBlank(doctor.getDoctorDepartmentId())) {
          AppletDoctorDepartment department = departmentService.getDoctorDepartmentById(doctor.getDoctorDepartmentId());
          if (department != null) {
            recommendListBaseVo.setDepartmentName(department.getDepartmentName());
          }
        }
        if (StringUtils.isNotBlank(doctor.getHospitalId())) {
          AppletDoctorHospital hospital = hospitalService.getHospitalById(doctor.getHospitalId());
          if (hospital != null) {
            recommendListBaseVo.setHospitalName(hospital.getHospitalName());
          }
        }
      }
      recommendListBaseVoList.add(recommendListBaseVo);
    }
    return JsonResNewVo.buildSuccess(recommendListBaseVoList);
  }


  @ApiOperation(value = "查询优惠卷", notes = "查询优惠卷")
  @RequestMapping(value = "/query/coupon", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryCoupon(@RequestBody CouponReq req) {
    String coupon = redisUtils.get("coupon:" + req.getUserId());
    if (StringUtils.isNotBlank(coupon)) {
      return JsonResNewVo.buildSuccess(coupon);
    } else {
      return JsonResNewVo.buildSuccess("false");
    }
  }

  @ApiOperation(value = "查询", notes = "查询")
  @RequestMapping(value = "/query/trueFalse", method = RequestMethod.GET, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo trueFalse() {
    return JsonResNewVo.buildSuccess(redisUtils.get("trueFalse"));
  }

  @ApiOperation(value = "发送IM聊天信息", notes = "您好！请描述您需要咨询的问题。")
  @RequestMapping(value = "/send/helloImMessage", method = RequestMethod.GET)
  @ResponseBody
  public JsonResNewVo sendHelloImMessage(@RequestParam String imRecordId) {
    logger.info("发送IM聊天信息" + imRecordId);
    //医生发送患者消息
    ImRecordBaseVo imRecordBaseVo = imRecordService.getImRecordById(imRecordId);
    Map<String, Object> msgType = new HashMap<>();
    msgType.put("MsgType", "TIMTextElem");
    Map<String, Object> data = new HashMap<>();
    data.put("Text", "您好！请描述您需要咨询的问题。");
    msgType.put("MsgContent", data);
    List<Map<String, Object>> list = new ArrayList<>();
    list.add(msgType);
    WxTencentUtils.sendImMessage(imRecordBaseVo.getUserId(),imRecordBaseVo.getDoctorId() , list);
    return JsonResNewVo.buildSuccess();
  }


}
