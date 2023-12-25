package com.tclab.weixinappletuserclient.controller.front.acquisition_client;

import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.constant.LogisticsConstants;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.OrderForLogisticsBaseVo;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.service.clientService.LogisticsService;
import com.tclab.weixinappletservice.service.clientService.MessageService;
import com.tclab.weixinappletservice.service.clientService.OrderService;
import com.tclab.weixinappletuserclient.model.req.apiReq.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@EnableConfigurationProperties
@RequestMapping(value = "/acquisition/logistics", method = RequestMethod.POST)
public class AcLogisticsController {

    private static final Logger logger = LoggerFactory.getLogger(AcLogisticsController.class);

    @Autowired
    private OrderService orderService;
    @Autowired
    private LogisticsService logisticsService;
    @Autowired
    private MessageService messageService;

    /**
     * 查询按照状态查询
     * @param req
     * @return
     */
    @RequestMapping(value="/query/byLogisticsType", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo querySendOrderByStatus(@RequestBody LogisticsStatusReq req){

        logger.info("采集点查询物流单列表 "+req.toString());

        List<AppletOrder> orders = orderService.getOrderByLogisticsType(req.getAcquisitionId(),req.getLogisticsType(),req.getQueryParam(),req.getPageSize());
        return JsonResVo.buildSuccess(orderService.acquisitionGroupByAppletOrderByDay(orders));
    }

    /**
     * 查询未送检的物流单
     * @param req
     * @return
     */
    @RequestMapping(value="/query/UnSendOrder", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryUnSendOrder(@RequestBody LogisticsStatusReq req){

        logger.info("采集点查询未送检订单 "+req.toString());

        List<AppletOrder> orders = orderService.getOrderByLogisticsType(req.getAcquisitionId(), LogisticsConstants.ACQUISITION_LOGISTICS_STATUS_UNSEND,req.getQueryParam(),req.getPageSize());
        List<OrderForLogisticsBaseVo> baseVoList = new ArrayList<>();
        for (AppletOrder order:orders) {
            OrderForLogisticsBaseVo baseVo = new OrderForLogisticsBaseVo();
            BeanUtils.copyProperties(order,baseVo);
            baseVo.setWriteOffDate(DateUtils.convertToSlashAndMinDate(order.getWriteOffDate()));
            baseVoList.add(baseVo);
        }
        return JsonResVo.buildSuccess(baseVoList);
    }

    /**
     * 查询送检中的物流单
     * @param req
     * @return
     */
    @RequestMapping(value="/query/sendingOrder", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo querySendingOrder(@RequestBody LogisticsStatusReq req){

        logger.info("采集点查询送检中订单 "+req.toString());

        return JsonResVo.buildSuccess(logisticsService.getSendingLogisticsOrderNew(req.getAcquisitionId()));
    }

    /**
     * 采集点订单送检
     * @param req
     * @return
     */
    @RequestMapping(value="/sendOrder", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo sendOrder(@RequestBody SendOrderReq req){

        logger.info("采集点送检: "+req.toString());

        int i =logisticsService.sendOrderToTc(req.getExpressImages(),req.getLogisticsType(),req.getAcquisitionId(),null,req.getExpressName(),req.getWaybillNo(),req.getOrderNos(),req.getStaffId());

        if (i!=0){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

    /**
     * 查询同创物流送检中物流单
     * @param req
     * @return
     */
    @RequestMapping(value="/query/tcLogistics", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryTcLogistics(@RequestBody LogisticsIdReq req){

        logger.info("采集点查询同创物流详情 "+req.toString());

        return JsonResVo.buildSuccess(logisticsService.getTcLogisticsOrderNew(req.getLogisticsId()));
    }

    /**
     * 查询第三方物流送检中物流单
     * @param req
     * @return
     */
    @RequestMapping(value="/query/thirdLogistics", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryThirdLogistics(@RequestBody LogisticsIdReq req){

        logger.info("采集点查询第三方物流详情 "+req.toString());

        return JsonResVo.buildSuccess(logisticsService.getThirdByIdNew(req.getLogisticsId()));
    }

    /**
     * 物流操作
     * @param req
     * @return
     */
    @RequestMapping(value="/actOrder", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo actOrder(@RequestBody LogisticsActionReq req){

        logger.info("采集点物流操作 "+req.toString());

        boolean check = false;
        if (req.getLogisticsAction().equals(LogisticsConstants.LOGISTICS_ACTION_ADD)){
            check = logisticsService.addSendLogisticsNew(req.getLogisticsType(),req.getLogisticsId(),req.getOrderNos());
        } else if (req.getLogisticsAction().equals(LogisticsConstants.LOGISTICS_ACTION_CANCEL)){
            check = logisticsService.cancelSendLogisticsNew(LogisticsConstants.LOGISTICS_TYPE_TC,req.getLogisticsId());
        } else if (req.getLogisticsAction().equals(LogisticsConstants.LOGISTICS_ACTION_CHECK)){
            check = logisticsService.finishLogisticsNew(LogisticsConstants.LOGISTICS_TYPE_TC,req.getLogisticsId());
        } else if (req.getLogisticsAction().equals(LogisticsConstants.LOGISTICS_ACTION_DELETE)){
            check = logisticsService.deleteLogisticsOrderNew(LogisticsConstants.LOGISTICS_TYPE_TC,req.getLogisticsId(),req.getOrderNos());
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_NOT_SUPPORT);
        }
        if (check){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.ERROR_BIZ_FAIL);
        }
    }

    /**
     * 查询消息
     * @param req
     * @return
     */
    @RequestMapping(value="/query/logisticsMessage", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryLogisticsMessage(QueryMessageReq req){

        logger.info("采集点查询物流消息 "+req.toString());

        if (StringUtils.isBlank(req.getAcquisitionId())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        return JsonResVo.buildSuccess(logisticsService.getMessageByAcquisitionIdAndStatus(req.getAcquisitionId(),req.getPageNo(),req.getPageSize()));
    }

}
