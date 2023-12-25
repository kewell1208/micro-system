package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.QueryUserReq;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.QueryUserReqVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.UserDetailVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.UserPageVo;
import com.tclab.weixinappletservice.service.adminService.AdminUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Package：com.tclab.wxmabackapi.controller
 * @Class：UserController
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/8 9:49
 * @Company:
 * @Version：
 * @Modified By:
 */
@Api(description = "用户管理模块",tags = "后台-用户管理")
@RestController
@RequestMapping(value = "/back/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private AdminUserService adminUserService;

    @ApiOperation(value = "查询用户列表" ,  notes="用户列表")
    @RequestMapping(value="/queryList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<UserPageVo> queryUserList(@ApiParam(name="QueryUserReq",value="用户查询参数",required=true) QueryUserReq req){
        logger.info("后台查询套餐列表: "+ req.toString());

        QueryUserReqVo reqVo = new QueryUserReqVo();
        BeanUtils.copyProperties(req,reqVo);

        UserPageVo userPageVo = adminUserService.getUserPageVoByQueryReq(reqVo);
        return JsonResNewVo.buildSuccess(userPageVo);
    }

    @ApiOperation(value = "查询用户详情" ,  notes="用户详情")
    @ApiImplicitParam(paramType = "path",name = "userId", value = "用户Id", required = true, dataType = "String")
    @RequestMapping(value="/queryDetail", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<UserDetailVo> queryUserDetail(@RequestParam String userId){
        logger.info("后台查询用户详情: "+ userId);
        if (StringUtils.isBlank(userId)){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"用户编号为空");
        }
        return JsonResNewVo.buildSuccess(adminUserService.getUserDetailById(userId));
    }

    @ApiOperation(value = "停用用户" ,  notes="停用用户")
    @ApiImplicitParam(paramType = "path",name = "userIds", value = "用户Id", required = true, dataType = "List<String>")
    @RequestMapping(value="/stopUser", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResNewVo stopUser(@RequestParam List<String> userIds){
        logger.info("停用用户: "+ userIds);
        if (userIds == null || userIds.size() == 0){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"用户编号为空");
        }
        return JsonResNewVo.buildSuccess(adminUserService.stopUser(userIds));
    }
}
