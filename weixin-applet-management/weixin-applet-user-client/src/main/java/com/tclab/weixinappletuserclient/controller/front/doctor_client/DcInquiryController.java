package com.tclab.weixinappletuserclient.controller.front.doctor_client;

import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.DcRecommendListUpdateReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.ImRecommendListQueryReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.ImRecordQueryReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.ImRecordUpdateReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.PackageListQueryReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.RecommendListSaveReqVo;
import com.tclab.weixinappletservice.service.clientService.ImRecommendListItemService;
import com.tclab.weixinappletservice.service.clientService.ImRecommendListService;
import com.tclab.weixinappletservice.service.clientService.ImRecordService;
import com.tclab.weixinappletservice.service.clientService.MessageService;
import com.tclab.weixinappletservice.service.clientService.PackageService;
import com.tclab.weixinappletservice.service.clientService.PackageSourceService;
import com.tclab.weixinappletservice.service.clientService.ParticipantService;
import com.tclab.weixinappletuserclient.model.req.apiReq.QueryMessageReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcImQueryReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcImRecordUpdateReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcMyParticipantQueryReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcPackageListQueryReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcParticipantListQueryReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcParticipantQueryReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcRecommendListItemQueryReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcRecommendListQueryReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcRecommendListSaveReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcRecommendListUpdateReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcSuggestionReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package：com.tclab.weixinappletuserclient.controller.front.doctor_client
 * @Class：DcInquiryController
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/5 9:34 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Api(tags = "患者问诊")
@RestController
@RequestMapping("/doctor/inquiry")
public class DcInquiryController {

  private static final Logger logger = LoggerFactory.getLogger(DcInquiryController.class);

  @Autowired
  private ParticipantService participantService;
  @Autowired
  private ImRecordService imRecordService;
  @Autowired
  private MessageService messageService;
  @Autowired
  private ImRecommendListService imRecommendListService;
  @Autowired
  private ImRecommendListItemService imRecommendListItemService;
  @Autowired
  private PackageService packageService;
  @Autowired
  private PackageSourceService packageSourceService;

  @ApiOperation(value = "查询患者列表", notes = "根据医生Id查询患者列表")
  @RequestMapping(value = "/query/participantList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryParticipantList(@RequestBody @ApiParam(name = "DcParticipantListQueryReq", value = "患者列表查询参数", required = true) DcParticipantListQueryReq req) {
    logger.info("医生端根据医生查询患者列表:" + req.toString());
    ImRecordQueryReqVo vo = new ImRecordQueryReqVo();
    BeanUtils.copyProperties(req, vo);
    return JsonResNewVo.buildSuccess(imRecordService.getListByDoctor(vo));
  }

  @ApiOperation(value = "查询单个患者信息", notes = "根据患者id查询患者信息")
  @RequestMapping(value = "/query/participant", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryParticipant(@RequestBody @ApiParam(name = "DcParticipantQueryReq", value = "患者信息查询参数", required = true) DcParticipantQueryReq req) {
    logger.info("医生端查询患者信息:" + req.toString());
    return JsonResNewVo.buildSuccess(participantService.getParticipantByParticipantId(req.getParticipantId()));
  }

  @ApiOperation(value = "查询IM即时通讯记录", notes = "根据即时通讯id查询IM聊天记录")
  @RequestMapping(value = "/query/imRecord", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryImRecord(@RequestBody @ApiParam(name = "DcImQueryReq", value = "IM即时通讯记录参数", required = true) DcImQueryReq req) {
    logger.info("医生端查询IM即时通讯记录:" + req.toString());
    return JsonResNewVo.buildSuccess(imRecordService.getImRecordById(req.getImRecordId()));
  }

  @ApiOperation(value = "获取消息列表", notes = "首页最新消息列表")
  @RequestMapping(value = "/query/messageList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryMessageList(@RequestBody @ApiParam(name = "QueryMessageReq", value = "获取消息列表参数", required = true) QueryMessageReq req) {
    logger.info("医生端获取消息列表:" + req.toString());
    return JsonResNewVo.buildSuccess(messageService.getMessageByUserIdAndStatus(req.getUserId(), req.getMessageStatus(), req.getPageNo(), req.getPageSize()));
  }

  @ApiOperation(value = "获取患者检验清单", notes = "根据医生id获取检验清单条目")
  @RequestMapping(value = "/query/imRecommendList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryImRecommendList(@RequestBody @ApiParam(name = "DcRecommendListQueryReq", value = "患者检验清单参数", required = true) DcRecommendListQueryReq req) {
    logger.info("医生端获取患者检验列表:" + req.toString());
    ImRecommendListQueryReqVo vo = new ImRecommendListQueryReqVo();
    BeanUtils.copyProperties(req, vo);
    return JsonResNewVo.buildSuccess(imRecommendListService.getItemList(vo));
  }

  @ApiOperation(value = "获取单个检验清单明细信息", notes = "根据检验清单号获取检验清单明细信息")
  @RequestMapping(value = "/query/imRecommendListItem", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryImRecommendListItem(@RequestBody @ApiParam(name = "DcRecommendListItemQueryReq", value = "单个检验清单参数", required = true) DcRecommendListItemQueryReq req) {
    logger.info("医生端获取单个检验清单:" + req.toString());
    return JsonResNewVo.buildSuccess(imRecommendListItemService.getPackageListByImRecommendListId(req.getImRecommendListId()));
  }

  @ApiOperation(value = "获取检验清单列表", notes = "检验清单列表")
  @RequestMapping(value = "/query/testPurposeList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryTestPurposeList(@RequestBody @ApiParam(name = "DcPackageListQueryReq", value = "检验套餐查询参数", required = true) DcPackageListQueryReq req) {
    logger.info("医生端获取检验项目列表:" + req.toString());
    PackageListQueryReqVo vo = new PackageListQueryReqVo();
    BeanUtils.copyProperties(req, vo);
    return JsonResNewVo.buildSuccess(packageService.getPackageList(vo));
  }

  @ApiOperation(value = "生成检验单", notes = "生成检验单")
  @RequestMapping(value = "/save/imRecommendList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo saveImRecommendList(@RequestBody @ApiParam(name = "DcRecommendListSaveReq", value = "保存检验单参数", required = true) DcRecommendListSaveReq req) {
    logger.info("医生端保存检验单:" + req.toString());
    RecommendListSaveReqVo vo = new RecommendListSaveReqVo();
    BeanUtils.copyProperties(req, vo);
    String imRecommendListId = imRecommendListService.saveImRecommendList(vo);
    return JsonResNewVo.buildSuccess(imRecommendListItemService.getReInquiryInfo(imRecommendListId));
  }

  @ApiOperation(value = "医生审核确认检验清单", notes = "医生审核确认检验清单")
  @RequestMapping(value = "/update/imRecommendList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo updateImRecommendList(@RequestBody @ApiParam(name = "DcRecommendListUpdateReq", value = "修改检验单参数", required = true) DcRecommendListUpdateReq req) {
    logger.info("医生端保存检验单:" + req.toString());
    DcRecommendListUpdateReqVo vo = new DcRecommendListUpdateReqVo();
    BeanUtils.copyProperties(req, vo);
    imRecommendListService.updateImRecommendList(vo);
    return JsonResNewVo.buildSuccess(imRecommendListItemService.getReInquiryInfo(vo.getImRecommendListIds()));
  }

  @ApiOperation(value = "更新im沟通状态", notes = "更新im沟通状态")
  @RequestMapping(value = "/update/imStatus", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo updateImStatus(@RequestBody @ApiParam(name = "DcImRecordUpdateReq", value = "im沟通记录状态参数", required = true) DcImRecordUpdateReq req) {
    logger.info("医生端更新im沟通状态:" + req.toString());
    ImRecordUpdateReqVo vo = new ImRecordUpdateReqVo();
    BeanUtils.copyProperties(req, vo);
    imRecordService.updateImRecordStatus(vo);
    return JsonResNewVo.buildSuccess(imRecordService.getImRecordById(vo.getImRecordId()));
  }

  @ApiOperation(value = "获取套餐来源列表", notes = "套餐来源列表")
  @RequestMapping(value = "/query/packageSourceList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryPackageSourceList() {
    logger.info("获取套餐来源列表");
    return JsonResNewVo.buildSuccess(packageSourceService.getList());
  }

  @ApiOperation(value = "复诊开单页面参数", notes = "复诊开单页面参数")
  @RequestMapping(value = "/query/reInquiryInfo", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryReInquiryInfo(@RequestBody @ApiParam(name = "DcRecommendListItemQueryReq", value = "单个检验清单参数", required = true) DcRecommendListItemQueryReq req) {
    logger.info("医生端复诊开单页面参数:" + req.toString());
    return JsonResNewVo.buildSuccess(imRecommendListItemService.getReInquiryInfo(req.getImRecommendListId()));
  }

  @ApiOperation(value = "医生填写问诊意见", notes = "医生填写问诊意见")
  @RequestMapping(value = "/update/doctorSuggestion", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo updateDoctorSuggestion(@RequestBody @ApiParam(name = "DcSuggestionReq", value = "医生填写问诊意见参数", required = true) DcSuggestionReq req) {
    logger.info("医生端填写问诊意见:" + req.toString());
    ImRecordUpdateReqVo vo = new ImRecordUpdateReqVo();
    BeanUtils.copyProperties(req, vo);
    return JsonResNewVo.buildSuccess(imRecordService.updateDoctorSuggestion(vo));
  }

  @ApiOperation(value = "查询是否有新的问诊解读记录", notes = "根据医生Id查询患者列表")
  @RequestMapping(value = "/query/haveNewRecord", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryHaveNewRecord(@RequestBody @ApiParam(name = "DcMyParticipantQueryReq", value = "我的患者信息查询参数", required = true) DcMyParticipantQueryReq req) {
    logger.info("查询是否有新的问诊解读记录:" + req.toString());
    return JsonResNewVo.buildSuccess(imRecordService.queryHaveNewRecord(req.getDoctorId()));
  }

}
