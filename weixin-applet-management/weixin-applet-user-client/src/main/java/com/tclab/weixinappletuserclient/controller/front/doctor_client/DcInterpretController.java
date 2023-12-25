package com.tclab.weixinappletuserclient.controller.front.doctor_client;

import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.InterpretUpdateReqVo;
import com.tclab.weixinappletservice.service.clientService.InterpretService;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcInterpretQueryReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcInterpretUpdateReq;
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
 * @Class：DcInterpretController
 * @Description：
 * @Author：dcd
 * @Date：Created in 2019/9/10 4:31 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Api(tags = "报告解读")
@RestController
@RequestMapping("/doctor/interpret")
public class DcInterpretController {

  private static final Logger logger = LoggerFactory.getLogger(DcInterpretController.class);

  @Autowired
  private InterpretService interpretService;

  @ApiOperation(value = "查询单个患者报告信息", notes = "根据患者id和医生id查询报告解读")
  @RequestMapping(value = "/query/queryReport", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryReport(@RequestBody @ApiParam(name = "DcInterpretQueryReq", value = "报告解读查询参数", required = true) DcInterpretQueryReq req) {
    logger.info("医生端查询单个患者报告信息:" + req.toString());
    return JsonResNewVo.buildSuccess(interpretService.getInterpretSingle(req.getInterpretId()));
  }

  @ApiOperation(value = "保存报告解读", notes = "保存报告解读")
  @RequestMapping(value = "/query/saveInterpret", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo saveInterpret(@RequestBody @ApiParam(name = "DcInterpretUpdateReq", value = "报告解读保存参数", required = true) DcInterpretUpdateReq req) {
    logger.info("医生端保存报告解读:" + req.toString());
    InterpretUpdateReqVo vo = new InterpretUpdateReqVo();
    BeanUtils.copyProperties(req, vo);
    String result = interpretService.saveInterpret(vo);
    if ("0".equals(result)) {
      return JsonResNewVo.buildSuccess();
    } else {
      return JsonResNewVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(), result);
    }
  }

}
