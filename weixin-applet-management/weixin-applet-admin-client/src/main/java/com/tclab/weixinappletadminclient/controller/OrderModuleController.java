package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.QueryOrderReq;
import com.tclab.weixinappletadminclient.model.req.RefundReq;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletservice.model.query.OrderQueryParam;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.OrderDetailVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.OrderPageVo;
import com.tclab.weixinappletservice.service.adminService.AdminGoodService;
import com.tclab.weixinappletservice.service.adminService.AdminOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(description = "订单管理模块",tags = "后台-订单管理")
@Controller
@RequestMapping(value = "/back/order")
public class OrderModuleController {

    private static final Logger logger = LoggerFactory.getLogger(AccountModuleController.class);

    @Autowired
    private AdminOrderService adminOrderService;
    @Autowired
    private AdminGoodService adminGoodService;

    @ApiOperation(value = "查询订单列表" ,  notes="用于订单模块3个查询订单列表")
    @RequestMapping(value="/queryList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<OrderPageVo> queryAllOrder(@ApiParam(name="queryOrderReq",value="订单查询请求参数",required=true) QueryOrderReq req){

        logger.info("后台订单模块查询订单列表: "+req.toString());

        OrderQueryParam param = new OrderQueryParam();

        param.setOrderNo(req.getOrderNo());
        param.setParticipantPhone(req.getParticipantPhone());
        param.setAcquisitionName(req.getAcquisitionName());
        param.setStaffName(req.getStaffName());

        if (req.getOrderType()!=null) {
            List<Integer> serviceTypes = new ArrayList<>();
            serviceTypes.add(req.getOrderType());
            param.setServiceTypes(serviceTypes);
        }

        if (req.getLogisticsStatus()!=null) {
            List<Integer> logisticsStatus = new ArrayList<>();
            logisticsStatus.add(req.getLogisticsStatus());
            param.setServiceTypes(logisticsStatus);
        }

        param.setOrderExceptionStatus(req.getOrderExceptionStatus());
        param.setOrderExceptionReason(req.getOrderExceptionReason());

        param.setPageNo(req.getPageNo());
        param.setPageSize(req.getPageSize());

        OrderPageVo orderPageVo = adminOrderService.queryOrderByParam(param);

        if (orderPageVo!=null) {
            logger.info("后台订单模块查询订单列表结果: " + orderPageVo.toString());
        } else {
            logger.info("后台订单模块查询订单列表结果: null");
        }

        return JsonResNewVo.buildSuccess(orderPageVo);
    }

    @ApiOperation(value = "查询订单详情" ,  notes="查询订单详情")
    @ApiImplicitParam(paramType = "path",name = "orderNo", value = "订单号", required = true, dataType = "String")
    @RequestMapping(value="/queryDetail", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<OrderDetailVo> queryOrderDetail(@RequestParam String orderNo){
        logger.info("查询订单详情");
        return JsonResNewVo.buildSuccess(adminOrderService.getOrderDetailVo(orderNo));
    }

    @ApiOperation(value = "后台退款" ,  notes="只根据订单号和退款金额退单")
    @RequestMapping(value="/refund", method = RequestMethod.POST)
    @ResponseBody
    public JsonResVo backRefund(@ApiParam(name="RefundReq",value="后台退款请求对象",required=true) @RequestBody RefundReq req){
        if (StringUtils.isBlank(req.getGoodNo())){
            return JsonResVo.buildSuccess(adminOrderService.backRefundOrder(req.getOrderNo(),req.getRefundAmount(),req.getRefundReason()));
        } else {
            return JsonResVo.buildSuccess(adminGoodService.backRefundGood(req.getOrderNo(),req.getGoodNo(),req.getRefundAmount(),req.getRefundReason()));
        }
    }

    @ApiOperation(value = "查询申请退款订单列表" ,  notes="查询退款申请订单列表")
    @RequestMapping(value="/queryApplyRefundOrderList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<OrderPageVo> queryApplyRefundOrder(@ApiParam(name="queryOrderReq",value="订单查询请求参数",required=true) QueryOrderReq req){

        logger.info("后台查询申请退款订单列表: "+req.toString());

        OrderQueryParam param = new OrderQueryParam();

        param.setOrderNo(req.getOrderNo());
        param.setParticipantPhone(req.getParticipantPhone());
        param.setAcquisitionName(req.getAcquisitionName());
        param.setStaffName(req.getStaffName());

        if (req.getOrderType()!=null) {
            List<Integer> serviceTypes = new ArrayList<>();
            serviceTypes.add(req.getOrderType());
            param.setServiceTypes(serviceTypes);
        }

        if (req.getLogisticsStatus()!=null) {
            List<Integer> logisticsStatus = new ArrayList<>();
            logisticsStatus.add(req.getLogisticsStatus());
            param.setServiceTypes(logisticsStatus);
        }

        param.setOrderExceptionStatus(req.getOrderExceptionStatus());
        param.setOrderExceptionReason(req.getOrderExceptionReason());

        param.setPageNo(req.getPageNo());
        param.setPageSize(req.getPageSize());

        param.setRefundStatus(OrderConstants.ORDER_REFUND_STATUS_PAYING);

        OrderPageVo orderPageVo = adminOrderService.queryOrderByParam(param);

        if (orderPageVo!=null) {
            logger.info("后台查询申请退款订单列表: " + orderPageVo.toString());
        } else {
            logger.info("后台查询申请退款订单列表: null");
        }

        return JsonResNewVo.buildSuccess(orderPageVo);
    }

}
