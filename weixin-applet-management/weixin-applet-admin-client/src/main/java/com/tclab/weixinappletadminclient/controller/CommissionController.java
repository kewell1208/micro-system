package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.EditCommissionReq;
import com.tclab.weixinappletadminclient.model.req.QueryAcquisitionCommissionReq;
import com.tclab.weixinappletadminclient.model.req.QueryCommissionListReq;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.*;
import com.tclab.weixinappletservice.service.adminService.AdminAcquisitionService;
import com.tclab.weixinappletservice.service.adminService.AdminCommissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(description = "提成管理模块",tags = "后台-提成管理")
@Controller
@RequestMapping(value = "/back/commission")
public class CommissionController {

    private static final Logger logger = LoggerFactory.getLogger(CommissionController.class);

    @Autowired
    private AdminAcquisitionService acquisitionService;
    @Autowired
    private AdminCommissionService adminCommissionService;

    @ApiOperation(value = "查询采集点提成列表" ,  notes="采集点提成列表")
    @RequestMapping(value="/queryList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<AcquisitionCommissionPageVo> queryAllAcquisitionCommission(@ApiParam(name="QueryAcquisitionCommissionReq",value="提成查询参数",required=true) QueryAcquisitionCommissionReq req){
        logger.info("后台提成模块查询采集点列表: "+req.toString());

        QueryAcquisitionCommissionReqVo reqVo = new QueryAcquisitionCommissionReqVo();
        BeanUtils.copyProperties(req,reqVo);

        AcquisitionCommissionPageVo commissionPageList = acquisitionService.getAcquisitionCommissionPageList(reqVo);
        return JsonResNewVo.buildSuccess(commissionPageList);
    }

    @ApiOperation(value = "查询采集点详情" ,  notes="查询采集点详情")
    @ApiImplicitParam(paramType = "path",name = "acquisitionId", value = "采集点Id", required = true, dataType = "String")
    @RequestMapping(value="/queryDetail", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<AcquisitionCommissionDetailVo> queryAcquisitionDetail(@RequestParam String acquisitionId){
        logger.info("后台提成模块查询采集点详情: "+acquisitionId);
        if (StringUtils.isBlank(acquisitionId)){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"采集点ID为空");
        }
        return JsonResNewVo.buildSuccess(acquisitionService.getAcquisitionCommission(acquisitionId));
    }

    @ApiOperation(value = "查询提成详情列表" ,  notes="查询采集点提成详情列表")
    @RequestMapping(value="/queryCommissionDetail", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<CommissionPageVo> queryCommissionDetail(@ApiParam(name="QueryAcquisitionCommissionReq",value="提成查询参数",required=true) QueryCommissionListReq req){
        logger.info("后台提成模块查询提成详情列表: "+req.toString());
        if (StringUtils.isBlank(req.getAcquisitionId())){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"采集点ID为空");
        }

        QueryCommissionListReqVo reqVo = new QueryCommissionListReqVo();
        BeanUtils.copyProperties(req,reqVo);

        return JsonResNewVo.buildSuccess(adminCommissionService.getCommissionListVoByAcquisitionId(reqVo));
    }

    @ApiOperation(value = "编辑提成" ,  notes="使用用户名登陆")
    @RequestMapping(value="/editCommission", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editCommission(@RequestBody @ApiParam(name="editCommissionReq",value="编辑提成参数",required=true) EditCommissionReq req){
        logger.info("后台登陆: "+req.toString());
        return JsonResVo.buildSuccess(adminCommissionService.editCommission(req.getPackageId(),req.getAcquisitionId(),req.getCostStaffCommission(),req.getCostOrganizationCommission()));
    }
}
