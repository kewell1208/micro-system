package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.config.WxConfig;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.utils.HttpClientUtil;
import com.tclab.weixinappletcommon.utils.JsonUtils;
import com.tclab.weixinappletcommon.utils.MD5Utils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletservice.dao.AppletDoctorMapper;
import com.tclab.weixinappletservice.dao.AppletUserMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.UserRegisterVo;
import com.tclab.weixinappletservice.model.vo.clientVo.weixinVo.WXSessionModel;
import com.tclab.weixinappletservice.pojo.AppletUser;
import com.tclab.weixinappletservice.pojo.AppletUserExample;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

  private static final Logger logger = LoggerFactory.getLogger(UserService.class);

  @Autowired
  private AppletUserMapper userMapper;
  @Autowired
  private AppletDoctorMapper appletDoctorMapper;

  @Transactional
  public String addUser(AppletUser user, String code) {
    user.setUpdateDate(new Date());
    user.setCreateDate(new Date());
    String userId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_USER);
    user.setUserId(userId);
    user.setUserName("新用户");
    //默认用户的登陆权限时普通用户
    user.setUserType(CommonConstants.USER_ROLE_USER);

    //根据code获取openid
    if (StringUtils.isNotBlank(code)) {
      String url = "https://api.weixin.qq.com/sns/jscode2session";
      Map<String, String> param = new HashMap<>();
      param.put("appid", WxConfig.getAppID());
      param.put("secret", WxConfig.getSecret());
      param.put("js_code", code);
      param.put("grant_type", "authorization_code");

      String wxResult = HttpClientUtil.doGet(url, param);

      logger.info("微信获取openIdApi请求结果: " + wxResult);
      WXSessionModel model = JsonUtils.jsonToPojoNew(wxResult, WXSessionModel.class);
      user.setOpenid(model.getOpenid());
    }
    int i = userMapper.insertSelective(user);
    if (i != 0) {
      return userId;
    }
    return null;
  }

  public AppletUser getUserById(String userId) {
    AppletUserExample example = new AppletUserExample();
    AppletUserExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andUserIdEqualTo(userId);
    List<AppletUser> users = userMapper.selectByExample(example);
    if (users.size() != 0) {
      return users.get(0);
    }
    return null;
  }

  public int updateUserBaseById(UserRegisterVo req) {
    AppletUserExample example = new AppletUserExample();
    AppletUserExample.Criteria criteria = example.createCriteria();
    criteria.andUserIdEqualTo(req.getUserId());
    AppletUser user = new AppletUser();
    BeanUtils.copyProperties(req, user);
    user.setUpdateDate(new Date());
    return userMapper.updateByExampleSelective(user, example);
  }

  public int updateUserBaseByUserPhone(UserRegisterVo req) {
    AppletUserExample example = new AppletUserExample();
    AppletUserExample.Criteria criteria = example.createCriteria();
    criteria.andUserPhoneEqualTo(req.getUserPhone());
    AppletUser user = new AppletUser();
    BeanUtils.copyProperties(req, user);
    user.setUpdateDate(new Date());
    return userMapper.updateByExampleSelective(user, example);
  }

  public AppletUser getUserByPhone(String phone) {
    AppletUserExample example = new AppletUserExample();
    AppletUserExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andUserPhoneEqualTo(phone);
    List<AppletUser> user = userMapper.selectByExample(example);
    if (user.size() != 0) {
      return user.get(0);
    }
    return null;
  }

  public AppletUser checkLoginByPhone(String phone, String password) {
    AppletUserExample example = new AppletUserExample();
    AppletUserExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andUserPhoneEqualTo(phone);
    criteria.andUserPasswordEqualTo(password);
    List<AppletUser> user = userMapper.selectByExample(example);
    if (user.size() != 0) {
      return user.get(0);
    }
    return null;
  }

  public int editPwd(String userId, String password, String phone) {
    AppletUserExample example = new AppletUserExample();
    AppletUserExample.Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(userId)) {
      criteria.andUserIdEqualTo(userId);
    }
    if (StringUtils.isNotBlank(phone)) {
      criteria.andUserPhoneEqualTo(phone);
    }
    AppletUser user = new AppletUser();
    user.setUserPassword(MD5Utils.getMD5(password));
    user.setUpdateDate(new Date());
    return userMapper.updateByExampleSelective(user, example);
  }

}
