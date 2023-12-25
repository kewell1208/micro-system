package com.tclab.weixinappletuserclient.controller.front.user_client;

import com.tclab.weixinappletcommon.config.WxConfig;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.HttpClientUtil;
import com.tclab.weixinappletcommon.utils.JsonUtils;
import com.tclab.weixinappletcommon.utils.MD5Utils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletcommon.utils.PayUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletcommon.utils.SMSUtils;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.UserLoginVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.UserRegisterVo;
import com.tclab.weixinappletservice.model.vo.clientVo.weixinVo.WXSessionModel;
import com.tclab.weixinappletservice.pojo.AppletUser;
import com.tclab.weixinappletservice.service.clientService.IPService;
import com.tclab.weixinappletservice.service.clientService.UserService;
import com.tclab.weixinappletuserclient.model.req.apiReq.UserLoginReq;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value = "/user/login")
public class UcLoginController {

  private static final Logger logger = LoggerFactory.getLogger(UcLoginController.class);

  @Autowired
  private UserService userService;
  @Autowired
  private RedisUtils redisUtils;
  @Autowired
  private IPService ipService;

  /**
   * 前台登陆
   */
//    @UserLoginToken
  @RequestMapping(value = "/front", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResVo userLogin(@RequestBody UserLoginReq req) {

    logger.info("客户端登陆 " + req.toString());

    AppletUser user = userService.checkLoginByPhone(req.getUserPhone(), MD5Utils.getMD5(req.getPassword()));
    if (user != null) {
      UserLoginVo userLoginVo = new UserLoginVo();
      BeanUtils.copyProperties(user, userLoginVo);
      Map<String, String> packageParams = new HashMap<String, String>();
      packageParams.put("userPhone", req.getUserPhone());
      packageParams.put("userPassword", user.getUserPassword());
      String signStr = PayUtils.createLinkString(packageParams);
      String token = PayUtils.sign(signStr, CommonConstants.sign_key, "utf-8").toUpperCase();
      userLoginVo.setToken(token);
      return JsonResVo.buildSuccess(userLoginVo);
    }
    return JsonResVo.buildErrorResult(ErrorEnum.USER_NOT_EXIST.getErrorCode(), "用户密码错误");
  }

  /**
   * 查询是否有该用户 如果有就返回该用户的用户类型
   */
  @RequestMapping(value = "/check", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResVo userCheck(@RequestBody UserLoginReq req) {

    logger.info("客户端校验用户是否存在 " + req.toString());

    //判断方法一，用手机号判断
    if (StringUtils.isNotBlank(req.getUserPhone())) {
      AppletUser user = userService.getUserByPhone(req.getUserPhone());
      if (user != null) {
        if (StringUtils.isNotBlank(user.getOpenid())) {
          return JsonResVo.buildSuccess(user.getUserType());
        } else {
          return JsonResVo.buildErrorResult(ErrorEnum.USER_NOT_EXIST.getErrorCode(), "用户已存在但是未注册用户端");
        }
      } else {
        return JsonResVo.buildFail(ErrorEnum.USER_NOT_EXIST);
      }
    }
    return JsonResVo.buildFail(ErrorEnum.USER_NOT_EXIST);
  }

  /**
   * 用户注册
   */
  @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResVo userRegister(@RequestBody UserLoginReq req) {

    logger.info("客户端注册用户 " + req.toString());

    AppletUser user = userService.getUserByPhone(req.getUserPhone());
    if (user != null) {
      if (StringUtils.isNotBlank(user.getOpenid())) {
        //如果用户手机已被注册也有openId就相当于用户已在客户端存在
        return JsonResVo.buildErrorResult(ErrorEnum.USER_EXISTED.getErrorCode(), "用户已存在");
      } else {

        //如果用户手机已被注册但是没有openId就相当于医生已被注册但是没有登陆客户端，因此没有openid
        UserRegisterVo userBaseReq = new UserRegisterVo();
        userBaseReq.setUserPhone(req.getUserPhone());
        String password = MD5Utils.getMD5(req.getPassword());
        userBaseReq.setUserPassword(password);
        String userId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_USER);
        userBaseReq.setUserId(userId);

        //根据code获取openid
        if (StringUtils.isNotBlank(req.getCode())) {
          String url = "https://api.weixin.qq.com/sns/jscode2session";
          Map<String, String> param = new HashMap<>();
          param.put("appid", WxConfig.getAppID());
          param.put("secret", WxConfig.getSecret());
          param.put("js_code", req.getCode());
          param.put("grant_type", "authorization_code");

          String wxResult = HttpClientUtil.doGet(url, param);

          logger.info("微信获取openIdApi请求结果: " + wxResult);
          WXSessionModel model = JsonUtils.jsonToPojoNew(wxResult, WXSessionModel.class);
          userBaseReq.setOpenid(model.getOpenid());
        }
        userService.updateUserBaseByUserPhone(userBaseReq);
        if (userId != null) {
          user.setUserId(userId);
          UserLoginVo userLoginVo = new UserLoginVo();
          BeanUtils.copyProperties(user, userLoginVo);
          Map<String, String> packageParams = new HashMap<String, String>();
          packageParams.put("userPhone", req.getUserPhone());
          packageParams.put("userPassword", password);
          String signStr = PayUtils.createLinkString(packageParams);
          String token = PayUtils.sign(signStr, CommonConstants.sign_key, "utf-8").toUpperCase();
          userLoginVo.setToken(token);
          return JsonResVo.buildSuccess(userLoginVo);
        }
        return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(), "更新信息失败");
      }
    }

    //如果用户手机没有被注册过就新增用户
    user = new AppletUser();
    user.setDelFlag(CommonConstants.INIT);
    user.setUserPhone(req.getUserPhone());
    String password = MD5Utils.getMD5(req.getPassword());
    user.setUserPassword(password);
    String userId = userService.addUser(user, req.getCode());
    if (userId != null) {
      user.setUserId(userId);
      UserLoginVo userLoginVo = new UserLoginVo();
      BeanUtils.copyProperties(user, userLoginVo);
      Map<String, String> packageParams = new HashMap<String, String>();
      packageParams.put("userPhone", req.getUserPhone());
      packageParams.put("userPassword", password);
      String signStr = PayUtils.createLinkString(packageParams);
      String token = PayUtils.sign(signStr, CommonConstants.sign_key, "utf-8").toUpperCase();
      userLoginVo.setToken(token);
      long fromDate = DateUtils.convertToMinrApplyDate(redisUtils.get("fromDate")).getTime();
      long toDate = DateUtils.convertToMinrApplyDate(redisUtils.get("toDate")).getTime();
      long now = System.currentTimeMillis();
      if (now >= fromDate && now <= toDate) {
        redisUtils.set("coupon:"+userId, "true");
      }
      return JsonResVo.buildSuccess(userLoginVo);
    }
    return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(), "注册失败");
  }

  /**
   * 发送校验码
   */
  @RequestMapping(value = "/sms", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResVo smsVerify(HttpServletRequest request, @RequestBody UserLoginReq req) {

    logger.info("客户端发送注册验证码 " + req.toString());

    boolean checkIp = ipService.checkIp(request);
    if (!checkIp) {
      return JsonResVo.buildErrorResult(ErrorEnum.USER_CLOSE.getErrorCode(), "IP已被禁止访问,如需解除请联系管理人员");
    }

    if (StringUtils.isBlank(req.getUserPhone())) {
      return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(), "手机号为空");
    }

    String verifyCode = NumberGeneratorUtils.generateSixRandomCode();
    boolean check;

    check = SMSUtils.sendSmsForRegister(req.getUserPhone(), verifyCode);

    if (check) {
      logger.info("短信验证已发送成功 " + req.getUserPhone() + "验证码: " + verifyCode);
      return JsonResVo.buildSuccess(verifyCode);
    } else {
      return JsonResVo.buildErrorResult(ErrorEnum.ERROR_BIZ_FAIL.getErrorCode(), "短信发送失败");
    }
  }

  @RequestMapping(value = "/forget/sms", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResVo forgetSmsVerify(HttpServletRequest request, @RequestBody UserLoginReq req) {

    logger.info("客户端发送注册验证码 " + req.toString());

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
      return JsonResVo.buildSuccess(verifyCode);
    }
  }
  @RequestMapping(value = "/set/fromDate", method = RequestMethod.POST)
  @ResponseBody
  public JsonResVo fromDate(String fromDate ,String toDate) {
    redisUtils.set("fromDate", fromDate);
    redisUtils.set("toDate", toDate);
    redisUtils.get("fromDate");
    redisUtils.get("toDate");
    return JsonResVo.buildSuccess();
  }
}
