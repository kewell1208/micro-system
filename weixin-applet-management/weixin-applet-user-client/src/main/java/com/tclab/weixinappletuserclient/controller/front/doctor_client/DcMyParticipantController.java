package com.tclab.weixinappletuserclient.controller.front.doctor_client;

import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletservice.service.clientService.ParticipantService;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcMyParticipantQueryReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Package：com.tclab.weixinappletuserclient.controller.front.doctor_client
 * @Class：DcMyParticipantController
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/27 10:48 AM
 * @Company:
 * @Version：
 */
@Api(tags = "我的患者")
@RestController
@RequestMapping("/doctor/myParticipant")
public class DcMyParticipantController {

  private static final Logger logger = LoggerFactory.getLogger(DcMyParticipantController.class);

  @Autowired
  private ParticipantService participantService;

  @ApiOperation(value = "查询我的患者列表", notes = "根据医生id查询我的患者列表")
  @RequestMapping(value = "/query/paticipantList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryPaticipantList(@RequestBody @ApiParam(name = "DcMyParticipantQueryReq", value = "我的患者列表查询参数", required = true) DcMyParticipantQueryReq req) {
    logger.info("医生端查询我的患者列表 " + req.toString());
    return JsonResNewVo.buildSuccess(participantService.getListByImDoctorId(req.getDoctorId(),req.getParticipantQuery()));
  }

  @ApiOperation(value = "查询服务记录", notes = "根据医生患者id查询服务记录")
  @RequestMapping(value = "/query/serviceDateList", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryServiceDateList(@RequestBody @ApiParam(name = "DcMyParticipantQueryReq", value = "服务记录查询参数", required = true) DcMyParticipantQueryReq req) {
    logger.info("医生端查询服务记录 " + req.toString());
    return JsonResNewVo.buildSuccess(participantService.getServiceDateList(req.getDoctorId(), req.getParticipantId()));
  }

}
