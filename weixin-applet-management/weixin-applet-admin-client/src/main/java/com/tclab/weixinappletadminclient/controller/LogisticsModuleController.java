package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.NoReq;
import com.tclab.weixinappletadminclient.model.req.QueryLogisticsReq;
import com.tclab.weixinappletadminclient.model.req.QuerySelfOrderReq;
import com.tclab.weixinappletadminclient.model.req.ThirdSelfReq;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.LogisticsDetailVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.LogisticsPageVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.OrderDetailVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.QueryLogisticsReqVo;
import com.tclab.weixinappletservice.service.adminService.AdminLogisticsService;
import com.tclab.weixinappletservice.service.adminService.AdminOrderService;
import com.tclab.weixinappletservice.service.adminService.AdminThirdSelfLogisticsService;
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

@Api(description = "物流管理模块",tags = "后台-物流管理")
@Controller
@RequestMapping(value = "/back/logistics")
public class LogisticsModuleController {

    private static final Logger logger = LoggerFactory.getLogger(LogisticsModuleController.class);

    @Autowired
    private AdminThirdSelfLogisticsService selfLogisticsService;
    @Autowired
    private AdminLogisticsService adminLogisticsService;
    @Autowired
    private AdminOrderService adminOrderService;

    @ApiOperation(value = "后台发送采集盒" ,  notes="采集盒只能使用第三方物流")
    @RequestMapping(value="/sendBox", method = RequestMethod.POST)
    @ResponseBody
    public JsonResNewVo<String> sendBox(@ApiParam(name="ThirdSelfReq",value="后台发送样本盒物流信息",required=true) @RequestBody ThirdSelfReq req){
        logger.info("后台物流模块发送自采采样盒: "+req.toString());
        String logisticsId = selfLogisticsService.sendUserThirdLogistics(req.getOrderNo(),req.getLogisticsGood(),req.getLogisticsRemark(),req.getLogisticsOrderNum(),req.getWaybillNo(),req.getExpressName(),req.getBarcodeVoList(),req.getCollectorStaffId());
        if (StringUtils.isNotBlank(logisticsId)){
            return JsonResNewVo.buildSuccess(logisticsId);
        } else {
            return JsonResNewVo.buildFail(ErrorEnum.ERROR_BIZ_FAIL);
        }
    }

    @ApiOperation(value = "新后台确认收件" ,  notes="同时接收同创和第三方,自采用户只传入orderNo,其他方式传入logisticsId")
    @RequestMapping(value="/receiveLogisticsNew", method = RequestMethod.POST)
    @ResponseBody
    public JsonResVo backReceiveLogisticsNew(@ApiParam(name="NoReq",value="后台接收物流",required=true) @RequestBody NoReq req){
        logger.info("后台物流模块接收物流: "+req.toString());
        if (StringUtils.isNotBlank(req.getOrderNo())&& StringUtils.isBlank(req.getLogisticsId())){
            adminLogisticsService.receiveThirdLogisticsBySelf(req.getOrderNo());
            return JsonResVo.buildSuccess();
        }
        if (StringUtils.isNotBlank(req.getLogisticsId())&& StringUtils.isBlank(req.getOrderNo())){
            if (req.getLogisticsId().substring(0,2).equals(CommonConstants.GenerateID_LOGISTICS_TC)){
                adminLogisticsService.receiveTcLogistics(req.getLogisticsId(),req.getAcquisitionId());
            }
            if (req.getLogisticsId().substring(0,2).equals(CommonConstants.GenerateID_LOGISTICS_THIRD)){
                adminLogisticsService.receiveThirdLogistics(req.getLogisticsId(),req.getAcquisitionId());
            }
            return JsonResVo.buildSuccess();
        }
        return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
    }

    @ApiOperation(value = "查询采集点物流单列表" ,  notes="查询同创和第三方物流")
    @RequestMapping(value="/queryList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<LogisticsPageVo> queryAllLogistics(@ApiParam(name="QueryLogisticsReq",value="物流查询参数",required=true) QueryLogisticsReq req){
        logger.info("后台物流模块查询物流列表: "+req.toString());

        QueryLogisticsReqVo reqVo = new QueryLogisticsReqVo();
        BeanUtils.copyProperties(req,reqVo);

        return JsonResNewVo.buildSuccess(adminLogisticsService.queryLogisticsPageVoByQueryReq(reqVo));
    }

    @ApiOperation(value = "查询自采订单列表" ,  notes="查询自采物流单列表")
    @RequestMapping(value="/querySelfOrderList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<LogisticsPageVo> querySelfOrder(@ApiParam(name="QueryLogisticsReq",value="物流查询参数",required=true) QuerySelfOrderReq req){
        logger.info("后台物流模块查询物流列表: "+req.toString());
        return JsonResNewVo.buildSuccess(adminOrderService.querySelfOrderList(req.getOrderNo(),req.getUserPhone(),req.getLogisticsStatus(),req.getPageNo(),req.getPageSize()));
    }

    @ApiOperation(value = "查询采集点物流单详情" ,  notes="查询同创和第三方物流")
    @ApiImplicitParam(paramType = "path",name = "logisticsId", value = "物流单号", required = true, dataType = "String")
    @RequestMapping(value="/queryDetail", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<LogisticsDetailVo> queryLogisticsDetail(@RequestParam String logisticsId, @RequestParam String acquisitionId){
        logger.info("后台物流模块查询物流详情: "+logisticsId);
        return JsonResNewVo.buildSuccess(adminLogisticsService.queryLogisticsDetailById(logisticsId,acquisitionId));
    }

    @ApiOperation(value = "查询自采订单详情" ,  notes="查询自采订单详情")
    @ApiImplicitParam(paramType = "path",name = "orderNo", value = "订单号", required = true, dataType = "String")
    @RequestMapping(value="/querySelfDetail", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<OrderDetailVo> queryOrderDetail(@RequestParam String orderNo){
        return JsonResNewVo.buildSuccess(adminOrderService.getSelfOrderDetailVo(orderNo));
    }

}
