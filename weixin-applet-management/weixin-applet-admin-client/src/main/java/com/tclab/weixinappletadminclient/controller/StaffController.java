package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.EditStaffReq;
import com.tclab.weixinappletadminclient.model.req.QueryAcquisitionStaffReq;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.AcquisitionStaffPageVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.EditStaffReqVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.QueryAcquisitionStaffReqVo;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionStaff;
import com.tclab.weixinappletservice.service.adminService.AdminStaffService;
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
 * @Class：StaffController
 * @Description： TODO
 * @Author：yuzh
 * @Date：Created in 2019/4/8 15:38
 * @Company:
 * @Version：
 * @Modified By:
 */
@Api(description = "员工管理模块",tags = "后台-员工管理")
@RestController
@RequestMapping(value = "/back/staff")
public class StaffController {


    private static final Logger logger = LoggerFactory.getLogger(StaffController.class);

    @Autowired
    private AdminStaffService adminStaffService;

    @ApiOperation(value = "查询员工列表" ,  notes="员工列表")
    @RequestMapping(value="/queryList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<AcquisitionStaffPageVo> queryUserList(@ApiParam(name="QueryUserReq",value="员工查询参数",required=true) QueryAcquisitionStaffReq req){
        logger.info("后台查询套餐列表: "+ req.toString());

        QueryAcquisitionStaffReqVo reqVo = new QueryAcquisitionStaffReqVo();
        BeanUtils.copyProperties(req,reqVo);

        AcquisitionStaffPageVo acquisitionStaffPageVo = adminStaffService.getStaffPageVoByQueryReq(reqVo);
        return JsonResNewVo.buildSuccess(acquisitionStaffPageVo);
    }

    @ApiOperation(value = "查询员工详情" ,  notes="员工详情")
    @ApiImplicitParam(paramType = "path",name = "userId", value = "员工Id", required = true, dataType = "String")
    @RequestMapping(value="/queryDetail", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<AppletAcquisitionStaff> queryUserDetail(@RequestParam String userId){
        logger.info("后台查询员工详情: "+ userId);
        if (StringUtils.isBlank(userId)){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"用户编号为空");
        }
        return JsonResNewVo.buildSuccess(adminStaffService.getStaffById(userId));
    }

    @ApiOperation(value = "停用员工" ,  notes="停用员工")
    @ApiImplicitParam(paramType = "path",name = "staffIds", value = "员工Id", required = true, dataType = "List<String>")
    @RequestMapping(value="/stopStaff", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResNewVo stopStaff(@RequestParam List<String> staffIds){
        logger.info("停用员工: "+ staffIds);
        if (staffIds == null || staffIds.size() == 0){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"员工编号为空");
        }
        return JsonResNewVo.buildSuccess(adminStaffService.stopStaff(staffIds));
    }

    @ApiOperation(value = "编辑员工" ,  notes="编辑员工")
    @RequestMapping(value="/editStaff", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editStaff(@RequestBody @ApiParam(name="editStaffReq",value="编辑员工参数",required=true) EditStaffReq req){
        logger.info("编辑员工: " + req.toString());

        EditStaffReqVo reqVo = new EditStaffReqVo();
        BeanUtils.copyProperties(req,reqVo);

        return JsonResVo.buildSuccess(adminStaffService.editStaff(reqVo));
    }
}
