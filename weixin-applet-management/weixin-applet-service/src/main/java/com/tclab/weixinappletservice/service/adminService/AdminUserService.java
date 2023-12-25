package com.tclab.weixinappletservice.service.adminService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.UserConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.MD5Utils;
import com.tclab.weixinappletservice.dao.AppletUserMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.*;
import com.tclab.weixinappletservice.pojo.AppletUser;
import com.tclab.weixinappletservice.pojo.AppletUserExample;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminUserService {

    private static final Logger logger = LoggerFactory.getLogger(AdminUserService.class);

    @Autowired
    private AppletUserMapper userMapper;
    @Autowired
    private AdminParticipantService adminParticipantService;
    @Autowired
    private AdminServiceInfoService adminServiceInfoService;

    /**
     * 用户登陆校验
     * @param userName
     * @param userPhone
     * @param password
     * @return
     */
    public UserLoginVo login(String userName, String userPhone, String password){

        if (StringUtils.isBlank(userName)&& StringUtils.isBlank(userPhone))
            throw new IllegalArgumentException("用户名或手机未收到");
        if (StringUtils.isBlank(password))
            throw new IllegalArgumentException("密码未输入");

        AppletUserExample userExample = new AppletUserExample();
        AppletUserExample.Criteria criteria = userExample.createCriteria();
        if (StringUtils.isNotBlank(userName))
            criteria.andUserNameEqualTo(userName);
        if (StringUtils.isNotBlank(userPhone))
            criteria.andUserPhoneEqualTo(userPhone);
        criteria.andUserPasswordEqualTo(MD5Utils.getMD5(password));
        List<Integer> userTypes = new ArrayList<>();
        userTypes.add(CommonConstants.USER_ROLE_ADMIN);
        userTypes.add(CommonConstants.USER_ROLE_ACQUISITION_STAFF);
        userTypes.add(CommonConstants.USER_ROLE_VERIFY);
        userTypes.add(CommonConstants.USER_ROLE_ACQUISITION);
        criteria.andUserTypeIn(userTypes);
        List<AppletUser> users = userMapper.selectByExample(userExample);

        if (users.size()!=0){
            AppletUser user = users.get(0);
            UserLoginVo userLoginVo = new UserLoginVo();
            BeanUtils.copyProperties(user,userLoginVo);

            logger.info("后台登陆成功: "+userLoginVo.toString());

            return userLoginVo;
        } else {
            logger.info("后台登陆失败: userName: "+userName+" userPhone "+userPhone+" password "+password);
            return null;
        }
    }

    public UserPageVo getUserPageVoByQueryReq(QueryUserReqVo req) {
        AppletUserExample appletUserExample = new AppletUserExample();
        AppletUserExample.Criteria userExampleCriteria = appletUserExample.createCriteria();
        if (StringUtils.isNotBlank(req.getNickname())) {
            userExampleCriteria.andNicknameLike("%"+req.getNickname()+"%");
        }
        if (StringUtils.isNotBlank(req.getUserPhone())) {
            userExampleCriteria.andUserPhoneLike(req.getUserPhone()+"%");
        }
        if (req.getCreateDate() != null && req.getCreateDate().size() == CommonConstants.TWO) {
            Date from  = DateUtils.convertToYearAndMonthDate(req.getCreateDate().get(0));
            Date to  = DateUtils.convertToYearAndMonthDate(req.getCreateDate().get(1));
            userExampleCriteria.andCreateDateBetween(from, to);
        }
        List<Integer> status = new ArrayList<>();
        status.add(UserConstants.USER_STATUS_FINISH);
        status.add(UserConstants.USER_STATUS_STOP);
        userExampleCriteria.andUserTypeIn(status);
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<AppletUser> appletUserList = userMapper.selectByExample(appletUserExample);
        PageInfo<AppletUser> appletUserPageInfo = new PageInfo<>(appletUserList);

        if (appletUserPageInfo != null && appletUserPageInfo.getList() != null) {
            UserPageVo userPageVo = new UserPageVo();
            userPageVo.setCurrentPageNo(appletUserPageInfo.getPageNum());
            userPageVo.setUserNum(appletUserPageInfo.getTotal());
            userPageVo.setPageNum(appletUserPageInfo.getPages());

            List<UserListVo> userListVoList = new ArrayList<>();
            for (AppletUser appletUser : appletUserPageInfo.getList()) {
                UserListVo userListVo = new UserListVo();
                BeanUtils.copyProperties(appletUser,userListVo);
                userListVoList.add(userListVo);
            }
            userPageVo.setUserListVoList(userListVoList);
            return userPageVo;
        }
        return null;
    }

    public UserDetailVo getUserDetailById(String userId) {
        if (StringUtils.isBlank(userId)){
            return null;
        }
        AppletUserExample userExample = new AppletUserExample();
        AppletUserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andUserIdEqualTo(userId);
        List<AppletUser> userList = userMapper.selectByExample(userExample);
        if (userList.size()!=0){
            AppletUser appletUser = userList.get(0);
            UserDetailVo userDetailVo = new UserDetailVo();
            BeanUtils.copyProperties(appletUser, userDetailVo);
            userDetailVo.setParticipantBaseVoList(adminParticipantService.getParticipantByUserId(userId));
            userDetailVo.setServiceInfoBaseVoList(adminServiceInfoService.getServiceInfoByUserId(userId));
            return userDetailVo;
        }
        return null;
    }

    public boolean stopUser(List<String> userIds) {
        AppletUser appletUser = new AppletUser();
        appletUser.setUserType(UserConstants.USER_STATUS_STOP);
        appletUser.setUpdateDate(new Date());
        AppletUserExample userExample = new AppletUserExample();
        AppletUserExample.Criteria userExampleCriteria = userExample.createCriteria();
        userExampleCriteria.andUserIdIn(userIds);
        int  i = userMapper.updateByExampleSelective(appletUser, userExample);
        if (i==0){
            throw new RuntimeException("停用用户失败: " + userIds);
        }
        return true;
    }
}
