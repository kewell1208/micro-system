package com.tclab.weixinappletuserclient.controller.front.acquisition_client;

import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletservice.model.result.OrderDayGroupResult;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderForDayAndTimeVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderForDayAndTimeWithTotalVo;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.service.clientService.AcquisitionClientService;
import com.tclab.weixinappletservice.service.clientService.GoodService;
import com.tclab.weixinappletservice.service.clientService.OrderService;
import com.tclab.weixinappletuserclient.model.req.apiReq.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Controller
@RequestMapping(value = "/acquisition/order", method = RequestMethod.POST)
public class AcOrderController {

    private static final Logger logger = LoggerFactory.getLogger(AcOrderController.class);

    @Autowired
    private OrderService orderService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private AcquisitionClientService clientService;

    /**
     * 通过订单状态查询订单列表
     * @param req
     * @return
     */
    @RequestMapping(value="/query/orderByStatus", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryStatus(@RequestBody AcquisitionQueryOrderByStatusReq req){

        logger.info("采集点根据状态查询订单列表 "+req.toString());

        if (req.getOrderStatus()==null){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        } else {
            //订单状态非空为未采集

            List<Integer> serviceTypes = new ArrayList<>();
            serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_ACQUISITION);
            serviceTypes.add(OrderConstants.ORDER_SERVICE_TYPE_HOME);

            if (req.getOrderStatus().equals(OrderConstants.ORDER_STATUS_UNCOLLECT)){
                if (req.getOrderExceptionStatus()!=null){
                    //订单状态为未采集异常状态为正常
                    if (req.getOrderExceptionStatus().equals(OrderConstants.ORDER_EXCEPTION_NORMAL)){
                        List<OrderDayGroupResult> groupResults = orderService.acquisitionGetOrder(req.getAcquisitionId(),OrderConstants.ORDER_STATUS_UNCOLLECT,OrderConstants.ORDER_EXCEPTION_NORMAL,null,req.getQueryParam(),req.getDayNum());
                        return JsonResVo.buildSuccess(orderService.acquisitionDeal2BaseDayOrderList(groupResults));
                        //订单状态为未采集异常状态为异常
                    } else if (req.getOrderExceptionStatus().equals(OrderConstants.ORDER_EXCEPTION_ERROR)){
                        List<OrderForDayAndTimeVo> dayAndTimeVos = orderService.acquisitionGetOrderNotByGroup(req.getAcquisitionId(),serviceTypes,req.getQueryParam(),req.getLimitNum());
                        return JsonResVo.buildSuccess(dayAndTimeVos);
                    } else {
                        //订单异常状态码错误
                        return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
                    }
                } else {
                    //订单未采集异常码为空相当于订单状态为所有未采集的订单
//                    List<OrderDayGroupResult> groupResults = orderService.acquisitionGetOrder(req.getAcquisitionId(),OrderConstants.ORDER_STATUS_UNCOLLECT,OrderConstants.ORDER_EXCEPTION_NORMAL,null,req.getQueryParam(),req.getDayNum());
                    List<OrderDayGroupResult> groupResults = orderService.acquisitionGetOrder(req.getAcquisitionId(),OrderConstants.ORDER_STATUS_UNCOLLECT,null,null,req.getQueryParam(),req.getDayNum());
                    return JsonResVo.buildSuccess(orderService.acquisitionDeal2BaseDayOrderList(groupResults));
                }
                //订单状态非空为已采集
            } else if (req.getOrderStatus().equals(OrderConstants.ORDER_STATUS_COLLECTED)){
                List<OrderDayGroupResult> groupResults = orderService.acquisitionGetOrder(req.getAcquisitionId(),OrderConstants.ORDER_STATUS_COLLECTED,null,null,req.getQueryParam(),req.getDayNum());
                return JsonResVo.buildSuccess(orderService.acquisitionDeal2BaseDayOrderList(groupResults));
            } else {
                //订单状态码错误
                return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
            }
        }
    }

    /**
     * 根绝订单服务方式查询订单上门和到院
     * @param req
     * @return
     */
    @RequestMapping(value="/query/OrderByServiceType", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryUnCollectOrderByServiceType(@RequestBody AcquisitionUncollectOrderReq req){

        logger.info("采集点查询未采集的订单根据服务方式 "+req.toString());

        if (StringUtils.isBlank(req.getAcquisitionId())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }

        List<Integer> serviceTypes = new ArrayList<>();
        serviceTypes.add(req.getServiceType());
        OrderForDayAndTimeWithTotalVo dayAndTimeVos = orderService.acquisitionGetOrderNotByGroupNew(req.getAcquisitionId(),serviceTypes,req.getQueryParam(),req.getLimitNum());
        return JsonResVo.buildSuccess(dayAndTimeVos);
    }

    /**
     * 查询订单基本信息
     * 加入采集时弹出采集要求  “空腹采集”之类  packages[0].packageSpecialRequirement
     * @param req
     * @return
     */
    @RequestMapping(value="/query/order", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryOrder(@RequestBody OrderNoReq req){

        logger.info("采集点查询订单详细信息 "+req.toString());

        return JsonResVo.buildSuccess(clientService.getOrderByOrderNo(req.getOrderNo()));
    }

    /**
     * 绑定条码
     * 绑定条码只针对采集点
     * @param req
     * @return
     */
    @RequestMapping(value="/bind/barcode", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo bindBarcode(@RequestBody GoodNoReq req){

        logger.info("采集点绑定条码 "+req.toString());

        boolean check = goodService.bindBarcode(req.getOrderNo(),req.getGoodNo(),req.getBarcode(),req.getCollectorId());
        if (check){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"更新数据为空");
        }
    }

    /**
     * 异常处理
     * @param req
     * @return
     */
    @RequestMapping(value="/exception/deal", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo exceptionDeal(@RequestBody ExceptionDealReq req){

        logger.info("采集点异常处理 "+req.toString());

        boolean check = orderService.exceptionOrder(req.getOrderNo(),req.getGoodNo(),req.getDeal(),req.getReason(),
                                                    req.getGoodApplyDate(),req.getPackageId(),req.getPackageName(),req.getParticipantId(),
                                                    req.getParticipantName(),req.getParticipantPhone(),req.getGoodDelayApplyDate());
        if (check){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"更新失败");
        }
    }

    /**
     * 采集点取消订单
     * @param req
     * @return
     */
    @RequestMapping(value="/cancel/order", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo cancelOrderByAcquisition(@RequestBody ExceptionDealReq req){

        logger.info("采集点取消订单 "+req.toString());

        boolean check = orderService.cancelOrderByAcquisition(req.getOrderNo(),req.getReason());
        if (check){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"更新失败");
        }
    }

    /**
     * 确认开单
     * 确认开单只针对到院采集的人
     * @param req
     * @return
     */
    @RequestMapping(value="/verify/order", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo verifyOrder(@RequestBody GoodNoReq req){

        logger.info("采集点确认开单 "+req.toString());

        boolean check = orderService.verifyOrder(req.getOrderNoList(),req.getStaffId());
        if (check){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"更新数据为空");
        }
    }

    /**
     * 开单列表
     * 区分已开单和未开单根据订单号和参检人查询
     * @param req
     * @return
     */
    @RequestMapping(value="/query/verifyOrderList", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryVerifyOrder(@RequestBody AcquisitionQueryOrderByStatusReq req){

        logger.info("采集点查询确认开单列表 "+req.toString());
        if (req.getVerifyStatus()!=null&&req.getVerifyStatus().equals(CommonConstants.INIT)) {
            List<AppletOrder> orderList = orderService.unVerifyOrderList(req.getAcquisitionId(), req.getVerifyStatus(), req.getQueryParam());
            List<OrderForDayAndTimeVo> dayAndTimeVos = new ArrayList<>();
            for (AppletOrder order:orderList) {
                OrderForDayAndTimeVo dayAndTimeVo = new OrderForDayAndTimeVo();
                dayAndTimeVo.setOrderNo(order.getOrderNo());
                dayAndTimeVo.setPackageName(order.getGoodName());
                dayAndTimeVo.setUserName(order.getUserName());
                dayAndTimeVo.setParticipantName(order.getParticipantName());
                dayAndTimeVo.setParticipantPhone(order.getParticipantPhone());
                dayAndTimeVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderApplyDate()));
                dayAndTimeVo.setAppointmentDate(DateUtils.dateToDay(order.getOrderApplyDate(),"/"));
                dayAndTimeVo.setAppointmentTime(DateUtils.dateToTime(order.getOrderApplyDate()));
                dayAndTimeVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
                dayAndTimeVos.add(dayAndTimeVo);
            }

            dayAndTimeVos.sort(new Comparator<OrderForDayAndTimeVo>() {
                //按日期排序
                @Override
                public int compare(OrderForDayAndTimeVo o1, OrderForDayAndTimeVo o2) {
                    return -o1.getOrderApplyDate().compareTo(o2.getOrderApplyDate());
                }
            });

            return JsonResVo.buildSuccess(dayAndTimeVos);
        } else {
            PageInfo<AppletOrder> orderPageInfo = orderService.verifyedOrderList(req.getAcquisitionId(), req.getVerifyStatus(), req.getQueryParam(), req.getPageNo(), req.getPageSize());
            List<OrderForDayAndTimeVo> dayAndTimeVos = new ArrayList<>();
            for (AppletOrder order : orderPageInfo.getList()) {
                OrderForDayAndTimeVo dayAndTimeVo = new OrderForDayAndTimeVo();
                dayAndTimeVo.setOrderNo(order.getOrderNo());
                dayAndTimeVo.setPackageName(order.getGoodName());
                dayAndTimeVo.setUserName(order.getUserName());
                dayAndTimeVo.setParticipantName(order.getParticipantName());
                dayAndTimeVo.setParticipantPhone(order.getParticipantPhone());
                dayAndTimeVo.setOrderApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderApplyDate()));
                dayAndTimeVo.setAppointmentDate(DateUtils.dateToDay(order.getOrderApplyDate(), "/"));
                dayAndTimeVo.setAppointmentTime(DateUtils.dateToTime(order.getOrderApplyDate()));
                dayAndTimeVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
                dayAndTimeVos.add(dayAndTimeVo);
            }

            dayAndTimeVos.sort(new Comparator<OrderForDayAndTimeVo>() {
                //按日期排序
                @Override
                public int compare(OrderForDayAndTimeVo o1, OrderForDayAndTimeVo o2) {
                    return -o1.getOrderApplyDate().compareTo(o2.getOrderApplyDate());
                }
            });

            OrderForDayAndTimeWithTotalVo result = new OrderForDayAndTimeWithTotalVo();
            result.setDayAndTimeVoList(dayAndTimeVos);
            result.setTotal(orderPageInfo.getTotal());

            return JsonResVo.buildSuccess(result);
        }
    }

}
