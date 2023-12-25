package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.LoginReq;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.UserLoginVo;
import com.tclab.weixinappletservice.service.adminService.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "账户管理模块",tags = "后台-账户管理")
@RestController
@RequestMapping(value = "/back/account")
public class AccountModuleController {

    private static final Logger logger = LoggerFactory.getLogger(AccountModuleController.class);

    @Autowired
    private AdminUserService adminUserService;

    @ApiOperation(value = "用户登陆" ,  notes="使用用户名登陆")
    @RequestMapping(value="/login", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResNewVo<UserLoginVo> backLogin(@RequestBody @ApiParam(name="loginReq",value="登陆参数",required=true) LoginReq req){

        logger.info("后台登陆: "+req.toString());

        UserLoginVo vo = adminUserService.login(req.getUserName(),req.getUserPhone(),req.getPassword());
        if (vo!=null){
            logger.info("后台登陆结果成功: "+vo.toString());
            return JsonResNewVo.buildSuccess(vo);
        } else {
            logger.info("后台登陆失败: "+req.toString());
            return JsonResNewVo.buildFail(ErrorEnum.USER_NOT_EXIST);
        }
    }

}
