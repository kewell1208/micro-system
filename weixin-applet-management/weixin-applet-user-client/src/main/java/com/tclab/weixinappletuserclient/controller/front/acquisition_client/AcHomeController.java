package com.tclab.weixinappletuserclient.controller.front.acquisition_client;

import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ParticipantOrderAndPackageVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ParticipantRecentVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.StaffVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.TodayOrderVo;
import com.tclab.weixinappletservice.service.clientService.AcquisitionClientService;
import com.tclab.weixinappletservice.service.clientService.OrderService;
import com.tclab.weixinappletservice.service.clientService.StaffService;
import com.tclab.weixinappletuserclient.model.req.apiReq.AcquisitionIdReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.AcquisitionParamReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.ParticipantIdReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.PhoneReq;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/acquisition/home", method = RequestMethod.POST)
public class AcHomeController {

    private static final Logger logger = LoggerFactory.getLogger(AcHomeController.class);

    @Autowired
    private AcquisitionClientService acquisitionClientService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private OrderService orderService;

    /**
     * 根据手机号查询采集点的员工的基本信息
     * 员工必须是未删除的
     * @param req
     * @return
     */
    @RequestMapping(value="/query/staff", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryStaff(@RequestBody PhoneReq req){

        logger.info("采集点查询员工的基本信息 "+req.toString());

        StaffVo staffVo = staffService.getStaffVo(req.getPhone());

        if (staffVo!=null){
            return JsonResVo.buildSuccess(staffVo);
        }else {
            return JsonResVo.buildErrorResult(ErrorEnum.OBJECT_ERROR_EMPTY.getErrorCode(),"无法查到相关信息");
        }
    }

    /**
     * 查询当日到采集点的带采集，已采集的上门采集和到院采集的订单，以及所有该采集点的异常未处理的订单
     * 获取最新付款的到该采集点上门采集和到院采集的订单列表
     * 订单必须
     * @param req
     * @return
     */
    @RequestMapping(value="/query/todayOrder", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryTodayOrder(@RequestBody AcquisitionIdReq req){

        logger.info("采集点查询今日订单 "+req.toString());

        TodayOrderVo todayOrderVo = acquisitionClientService.queryTodayOrderCountAndRecentOrderInfo(req.getAcquisitionId());
        return JsonResVo.buildSuccess(todayOrderVo);
    }

    /**
     * 查询采集点的患者信息列表
     * @param req
     * @return
     */
    @RequestMapping(value="/query/customer", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryCustomer(@RequestBody AcquisitionParamReq req){

        logger.info("采集点查询患者列表 "+req.toString());

        List<ParticipantRecentVo> vos = acquisitionClientService.getParticipantHistory(req.getAcquisitionId(),req.getQueryParam());
        return JsonResVo.buildSuccess(vos);
    }

    /**
     * 查询患者订单
     * @param req
     * @return
     */
    @RequestMapping(value="/query/participant", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryParticipant(@RequestBody ParticipantIdReq req){

        logger.info("采集点查询患者订单 "+req.toString());

        List<ParticipantOrderAndPackageVo> result = acquisitionClientService.getParticipantOrderAndPackage(req.getAcquisitionId(),req.getParticipantId());
        return JsonResVo.buildSuccess(result);
    }

    @RequestMapping(value="/query/writeOffCode", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryWriteOffCode(@RequestParam String writeOffCode, @RequestParam String acquisitionId){

        logger.info("采集点根据核销码查询订单 "+writeOffCode);

        String orderNo = orderService.acquisitionWriteOffOrder(writeOffCode,acquisitionId);

        if (StringUtils.isBlank(orderNo)){
            return JsonResVo.buildErrorResult(ErrorEnum.USER_NOT_EXIST.getErrorCode(),"核销码绑定的订单号不存在或者不可再进行核销");
        }

        return JsonResVo.buildSuccess(orderNo);
    }

}
