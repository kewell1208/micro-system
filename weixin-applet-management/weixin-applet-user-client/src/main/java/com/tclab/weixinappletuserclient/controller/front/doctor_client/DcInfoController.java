package com.tclab.weixinappletuserclient.controller.front.doctor_client;

import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.DoctorFeeReqVo;
import com.tclab.weixinappletservice.service.clientService.DoctorService;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcSetFeeReq;
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
 * @Class：DcInfoController
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/21 10:57 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Api(tags = "医生个人中心")
@RestController
@RequestMapping("/doctor/info")
public class DcInfoController {

  private static final Logger logger = LoggerFactory.getLogger(DcInfoController.class);

  @Autowired
  private DoctorService doctorService;

  @ApiOperation(value = "费用设置", notes = "费用设置")
  @RequestMapping(value = "/query/setFee", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo setFee(@RequestBody @ApiParam(name = "DcInterpretUpdateReq", value = "报告解读保存参数", required = true) DcSetFeeReq req) {
    logger.info("医生端费用设置:" + req.toString());
    DoctorFeeReqVo vo = new DoctorFeeReqVo();
    BeanUtils.copyProperties(req, vo);
    return JsonResNewVo.buildSuccess(doctorService.setDoctorFee(vo));
  }


}
