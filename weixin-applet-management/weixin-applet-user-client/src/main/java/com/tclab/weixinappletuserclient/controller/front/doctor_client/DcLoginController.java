package com.tclab.weixinappletuserclient.controller.front.doctor_client;

import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.MD5Utils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletcommon.utils.SMSUtils;
import com.tclab.weixinappletcommon.utils.TLSSigAPIv2;
import com.tclab.weixinappletcommon.utils.WxTencentUtils;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.DoctorBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.LoginReqVo;
import com.tclab.weixinappletservice.service.clientService.DoctorService;
import com.tclab.weixinappletservice.service.clientService.IPService;
import com.tclab.weixinappletuserclient.model.req.apiReq.ImLoginReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.UserLoginReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcLoginReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcPasswordReq;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Package：com.tclab.weixinappletuserclient.controller.front.doctor_client
 * @Class：DCLoginController
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/9 11:26 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Api(tags = "登录")
@Controller
@RequestMapping("/doctor")
public class DcLoginController {

  private static final Logger logger = LoggerFactory.getLogger(DcLoginController.class);

  @Autowired
  private WxTencentUtils wxTencentUtils;
  @Autowired
  private RedisUtils redisUtils;
  @Autowired
  private DoctorService doctorService;
  @Autowired
  private IPService ipService;


  @ApiOperation(value = "登录", notes = "根据用户名密码判断登录", consumes = "application/json;charset=UTF-8")
  @RequestMapping(value = "/login", method = RequestMethod.POST)
  @ResponseBody
  public JsonResNewVo login(@RequestBody @ApiParam(name = "DcLoginReq", value = "登陆参数", required = true) DcLoginReq req) {
    logger.info("医生端登录:" + req.toString());
    LoginReqVo vo = new LoginReqVo();
    vo.setUsername(req.getUsername());
    //缓存是否一致，如果一致则直接免登录，否则需重新登录
    if (3 == req.getType()) {
      if (StringUtils.isNotBlank(req.getSessionKey()) && req.getSessionKey().equals(redisUtils.get("sessionKey:" + req.getUsername()))) {
        DoctorBaseVo doctorBaseVo = doctorService.checkDoctorLogin(vo);
        return JsonResNewVo.buildSuccess(doctorBaseVo);
      } else {
        return JsonResNewVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(), "登录已超时，请重新登录");
      }
    }

    if (1 == req.getType()) {
      vo.setPassword(MD5Utils.getMD5(req.getPassword()));
    } else if (2 == req.getType()) {
      //验证码不正确
      if (StringUtils.isBlank(req.getVerificationCode()) || !req.getVerificationCode().equals(redisUtils.get("VerificationCode:" + req.getUsername()))) {
        return JsonResNewVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(), "验证码错误");
      }
    }
    //是否关注公众号
    DoctorBaseVo doctorBaseVo = doctorService.checkDoctorLogin(vo);
    if (doctorBaseVo != null) {
    /*  if (!wxTencentUtils.judgeIsFollow(appletUser.getOpenid())) {
        return JsonResNewVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(), "请先关注公众号");
      }else{*/
      //返回session密匙
      String sessionKey = MD5Utils.getMD5(req.getUsername() + new Date());
      redisUtils.set("sessionKey:" + req.getUsername(), sessionKey, 1296000L);
      return JsonResNewVo.buildErrorResult(ErrorEnum.OK.getErrorCode(), sessionKey, doctorBaseVo);
      /* }*/
    } else {
      return JsonResNewVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(), "用户名密码错误");
    }
  }

  @ApiOperation(value = "im登录", notes = "根据userid登录")
  @RequestMapping(value = "/imLogin", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo imLogin(@RequestBody @ApiParam(name = "ImLoginReq", value = "im登陆参数", required = true) ImLoginReq req) {
    logger.info("医生端腾讯IM登录:" + req.toString());
    //默认30天过期
    String userSig;
    if (StringUtils.isBlank(redisUtils.get("userSig:" + req.getSdkAppId() + req.getSecretKey() + req.getUserId()))) {
      TLSSigAPIv2 tlsSigAPIv2 = new TLSSigAPIv2(req.getSdkAppId(), req.getSecretKey());
      userSig = tlsSigAPIv2.genSig(req.getUserId(), 2592000L);
      redisUtils.set("userSig:"+req.getSdkAppId() + req.getSecretKey() + req.getUserId(), userSig);
    } else {
      userSig = redisUtils.get("userSig:" + req.getSdkAppId() + req.getSecretKey() + req.getUserId());
    }
    return JsonResNewVo.buildSuccess(userSig);
  }

  @ApiOperation(value = "修改密码", notes = "修改密码")
  @RequestMapping(value = "/changePassword", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo changePassword(@RequestBody @ApiParam(name = "DcPasswordReq", value = "修改密码参数", required = true) DcPasswordReq req) {
    logger.info("医生端修改密码 " + req.toString());
    if (StringUtils.isBlank(req.getVerificationCode()) || !req.getVerificationCode().equals(redisUtils.get("VerificationCode:" + req.getUsername()))) {
      return JsonResNewVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(), "验证码错误");
    }
    return JsonResNewVo.buildSuccess(doctorService.editDoctorPwd(req.getNewPassword(), req.getUsername()));
  }

  @ApiOperation(value = "发送短信验证码", notes = "发送短信验证码")
  @RequestMapping(value = "/sendMessage", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResVo sendMessage(HttpServletRequest request, @RequestBody @ApiParam(name = "UserLoginReq", value = "发送短信验证码参数", required = true) UserLoginReq req) {

    logger.info("医生端发送验证码 " + req.toString());

    boolean checkIp = ipService.checkIp(request);
    if (!checkIp) {
      return JsonResVo.buildErrorResult(ErrorEnum.USER_CLOSE.getErrorCode(), "IP已被禁止访问,如需解除请联系管理人员");
    }

    if (StringUtils.isBlank(req.getUserPhone())) {
      return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(), "手机号为空");
    }

    boolean check;
    String verifyCode = NumberGeneratorUtils.generateSixRandomCode();
    Map<String, String> map = new HashMap<>();
    map.put("code", verifyCode);
    check = SMSUtils.sendSms(req.getUserPhone(), map, SMSUtils.templateCodeChangePassword);
    if (!check) {
      logger.info("短信验证已发送失败 " + req.getUserPhone());
      return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(), "验证短信发送失败");
    } else {
      logger.info("短信验证已发送成功 " + req.getUserPhone() + "验证码: " + verifyCode);
      redisUtils.set("VerificationCode:" + req.getUserPhone(), verifyCode, 1800L);
      return JsonResVo.buildSuccess();
    }
  }
}
