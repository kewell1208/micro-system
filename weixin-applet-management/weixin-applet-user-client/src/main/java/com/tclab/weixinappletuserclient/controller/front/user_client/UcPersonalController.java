package com.tclab.weixinappletuserclient.controller.front.user_client;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.IDCardUtils;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.*;
import com.tclab.weixinappletservice.pojo.*;
import com.tclab.weixinappletservice.service.clientService.*;
import com.tclab.weixinappletuserclient.model.req.apiReq.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user/person")
public class UcPersonalController {

    private static final Logger logger = LoggerFactory.getLogger(UcPersonalController.class);


    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;
    @Autowired
    private ParticipantService participantService;
    @Autowired
    private ServiceInfoService serviceInfoService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private InvoiceService invoiceService;

    /**
     * 查询消息
     * @param req
     * @return
     */
    @RequestMapping(value="/query/message", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryMessage(QueryMessageReq req){

        logger.info("客户端查询消息 "+req.toString());

        if (StringUtils.isBlank(req.getUserId())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        return JsonResVo.buildSuccess(messageService.getMessageByUserIdAndStatus(req.getUserId(),req.getMessageStatus(),req.getPageNo(),req.getPageSize()));
    }

    /**
     * 消息已读
     * @param messageId
     * @return
     */
    @RequestMapping(value="/read/message", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo readMessage(@RequestParam String messageId){

        logger.info("客户端读取消息 "+messageId);

        if (StringUtils.isBlank(messageId)){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        boolean i = messageService.readMessage(messageId);
        if (i){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"消息已读");
        }
    }

    /**
     * 查询用户基本信息
     * @param userId
     * @return
     */
    @RequestMapping(value="/query/user", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryUser(@RequestParam String userId){

        logger.info("客户端查询用户基本信息 "+userId);

        if (StringUtils.isBlank(userId)){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        AppletUser user = userService.getUserById(userId);
        if (user!=null){
            UserBaseVo userBaseVo = new UserBaseVo();
            BeanUtils.copyProperties(user,userBaseVo);
            return JsonResVo.buildSuccess(userBaseVo);
        } else {
            return JsonResVo.buildFail(ErrorEnum.USER_NOT_EXIST);
        }
    }

    /**
     * 更新用户基本信息
     * @param req
     * @return
     */
    @RequestMapping(value="/update/user", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo updateUser(@RequestBody UserBaseReq req){

        logger.info("客户端跟新基本用户信息 "+req.toString());

        if (StringUtils.isBlank(req.getUserId())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }

        UserRegisterVo registerVo = new UserRegisterVo();
        BeanUtils.copyProperties(req,registerVo);

        int i = userService.updateUserBaseById(registerVo);
        if (i>0) {
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

    /**
     * 查询参检人员
     * @return
     */
    @RequestMapping(value="/query/participant", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryParticipant(NoReq req){

        logger.info("客户端查询参检人员 "+req.toString());

        if (StringUtils.isBlank(req.getUserId())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        List<ParticipantBaseVo> baseVos = new ArrayList<>();
        List<AppletOrderParticipant> list =  participantService.getParticipantByUserIdAndParticipantId(req.getUserId(),req.getParticipantId());
        for (AppletOrderParticipant participant:list) {
            ParticipantBaseVo baseVo = new ParticipantBaseVo();
            BeanUtils.copyProperties(participant,baseVo);
            baseVo.setParticipantSex(IDCardUtils.getSex(participant.getParticipantIdCard()));
            baseVo.setParticipantAge(IDCardUtils.getAge(participant.getParticipantIdCard()));
            baseVos.add(baseVo);
        }
        return JsonResVo.buildSuccess(baseVos);
    }

    /**
     * 编辑参检人员
     * @param req
     * @return
     */
    @RequestMapping(value="/edit/participant", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editParticipant(@RequestBody ParticipantBaseReq req){

        logger.info("客户端编辑参检人员 "+req.toString());

        if (StringUtils.isBlank(req.getUserId())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        String idcard = req.getParticipantIdCard();
        if (StringUtils.isNotBlank(idcard)){
            if (IDCardUtils.isIdcard(idcard)){
                Map<String,String> info = IDCardUtils.getBirAgeSex(idcard);
                req.setParticipantAge(Integer.parseInt(info.get("age")));
                req.setVerifyFlag(CommonConstants.ENABLE);
            } else {
//                暂时关闭身份验证
                return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"身份证验证失败");
            }
        }
        AppletOrderParticipant participant = new AppletOrderParticipant();
        BeanUtils.copyProperties(req,participant);
        int i = participantService.editParticipant(participant);

        if (i>0){
            List<ParticipantBaseVo> baseVos = new ArrayList<>();
            List<AppletOrderParticipant> list =  participantService.getParticipantByUserIdAndParticipantId(req.getUserId(),null);
            for (AppletOrderParticipant pt:list) {
                ParticipantBaseVo baseVo = new ParticipantBaseVo();
                BeanUtils.copyProperties(pt,baseVo);
                baseVos.add(baseVo);
            }
            return JsonResVo.buildSuccess(baseVos);
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

    /**
     * 删除参检人员
     * @param req
     * @return
     */
    @RequestMapping(value="/delete/participant", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo deleteParticipant(@RequestBody NoReq req){

        logger.info("客户端删除参检人员 "+req.toString());

        if (StringUtils.isBlank(req.getParticipantId())){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }

        AppletOrderParticipant participant = participantService.getParticipantByParticipantId(req.getParticipantId());

        if (participant!=null){
            participantService.deleteParticipant(req.getParticipantId());
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"参检人不存在");
        }
    }

    /**
     * 查询服务信息
     * @param req
     * @return
     */
    @RequestMapping(value="/query/serviceInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryServiceInfo(ServiceInfoQueryReq req){

        logger.info("客户端查询服务信息 "+req.toString());

        List<AppletOrderServiceInfo> serviceInfos = serviceInfoService.getServiceInfoById(req.getUserId(),null,req.getDefaultFlag());
        List<ServiceInfoBaseVo> baseVos = new ArrayList<>();
        for (AppletOrderServiceInfo serviceInfo:serviceInfos) {
            ServiceInfoBaseVo vo = new ServiceInfoBaseVo();
            BeanUtils.copyProperties(serviceInfo,vo);
            baseVos.add(vo);
        }
        return JsonResVo.buildSuccess(baseVos);
    }

    /**
     * 编辑服务信息
     * @param req
     * @return
     */
    @RequestMapping(value="/edit/serviceInfo", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editServiceInfo(@RequestBody ServiceInfoBaseReq req){

        logger.info("客户端编辑服务信息 "+req.toString());

        AppletOrderServiceInfo serviceInfo = new AppletOrderServiceInfo();
        BeanUtils.copyProperties(req,serviceInfo);

        int i = serviceInfoService.editServiceInfo(serviceInfo);
        if (i > 0){

            List<AppletOrderServiceInfo> serviceInfos = serviceInfoService.getServiceInfoById(req.getUserId(),null,null);
            List<ServiceInfoBaseVo> baseVos = new ArrayList<>();
            for (AppletOrderServiceInfo so:serviceInfos) {
                ServiceInfoBaseVo vo = new ServiceInfoBaseVo();
                BeanUtils.copyProperties(so,vo);
                baseVos.add(vo);
            }

            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

    /**
     * 删除服务地址
     * @param req
     * @return
     */
    @RequestMapping(value="/delete/serviceInfo", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo deleteServiceInfo(@RequestBody NoReq req){

        logger.info("客户端删除服务地址 "+req.toString());

        if (StringUtils.isBlank(req.getServiceInfoId())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"服务地址ID不能为空");
        }

        List<AppletOrderServiceInfo> serviceInfo = serviceInfoService.getServiceInfoById(null,req.getServiceInfoId(),null);

        if (serviceInfo!=null&&serviceInfo.size()!=0){
            serviceInfoService.deleteServiceInfo(req.getServiceInfoId());
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"服务地址不存在");
        }
    }

    @RequestMapping(value="/edit/pwd", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo changePassword(@RequestBody NoReq req){

        logger.info("客户端更改密码 "+req.getUserId());

        if (StringUtils.isBlank(req.getPhone())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"手机号码不能为空");
        }


        int i = userService.editPwd(req.getUserId(),req.getPassword(),req.getPhone());
        if (i>0) {
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

    @RequestMapping(value="/invoice/queryOrder", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryInvoiceOrderByStatus(@RequestBody InvoiceReq req){
        logger.info("客户端根据开票状态查询开票订单列表"+req.toString());
//        List<InvoiceOrderListVo> result = orderService.getInvoiceOrderByStatus(req.getUserId(),req.getInvoiceStatus(),req.getDateForMonth(),null);
        List<InvoiceOrderListVo> result = orderService.getInvoiceOrderByStatusAndDate(req.getUserId(),req.getInvoiceStatus(),req.getDateStart(),req.getDateEnd());
        logger.info("客户端根据开票状态查询开票列表结果"+result.toString());
        return JsonResVo.buildSuccess(result);
    }

    @RequestMapping(value="/invoice/queryInvoice", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo queryInvoice(@RequestBody InvoiceReq req){
        logger.info("客户端根据开票状态查询开票记录列表"+req.toString());
        List<AppletOrderInvoice> invoiceList = invoiceService.getInvoiceListByStatus(req.getUserId(),req.getInvoiceStatus());

        List<InvoiceListVo> result = new ArrayList<>();
        for (AppletOrderInvoice invoice:invoiceList) {
            InvoiceListVo listVo = new InvoiceListVo();
            BeanUtils.copyProperties(invoice,listVo);
            listVo.setApplyDate(DateUtils.convertToSlashAndMinDate(invoice.getApplyDate()));
            result.add(listVo);
        }

        logger.info("客户端根据开票状态查询开票记录列表"+result.toString());
        return JsonResVo.buildSuccess(result);
    }

    @RequestMapping(value="/invoice/openInvoice", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo openInvoice(@RequestBody InvoiceEditReq req){

        logger.info("订单开票"+req.toString());

        InvoiceEditVo editVo = new InvoiceEditVo();
        BeanUtils.copyProperties(req,editVo);

        String applyId = invoiceService.openInvoice(editVo);
        logger.info("订单开票工单号"+applyId);
        return JsonResVo.buildSuccess(applyId);
    }

    @RequestMapping(value="/invoice/queryInfo", method = RequestMethod.POST)
    @ResponseBody
    public JsonResVo queryInvoiceInfo(@RequestBody InvoiceReq req){
        logger.info("后台查询开票详情: " + req.toString());

        AppletOrderInvoice invoice = invoiceService.getInvoiceByApplyId(req.getApplyId());
        if (invoice==null){
            logger.info("后台查询开票详情结果为空: " + req.getApplyId());
            return JsonResVo.buildErrorResult(ErrorEnum.OBJECT_ERROR_EMPTY.getErrorCode(),"开票信息为空");
        }
        List<AppletOrder> orderList = invoiceService.getOrderByInvoiceId(req.getApplyId());

        InvoiceInfoVo infoVo = new InvoiceInfoVo();
        BeanUtils.copyProperties(invoice,infoVo);
        infoVo.setApplyDate(DateUtils.convertToSlashAndMinDate(invoice.getApplyDate()));
        List<OrderAmountListVo> orderAmountListVoList = new ArrayList<>();
        for (AppletOrder order:orderList) {
            OrderAmountListVo listVo = new OrderAmountListVo();
            BeanUtils.copyProperties(order,listVo);
            listVo.setCreateDate(DateUtils.convertToSlashAndMinDate(order.getCreateDate()));
            listVo.setPayDate(DateUtils.convertToSlashAndMinDate(order.getPayDate()));
            orderAmountListVoList.add(listVo);
        }
        infoVo.setOrderAmountListVoList(orderAmountListVoList);

        return JsonResVo.buildSuccess(infoVo);
    }

    @RequestMapping(value="/invoice/restart", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo restartInvoice(@RequestBody InvoiceEditReq req){

        logger.info("订单重新开票"+req.toString());
        invoiceService.restartInvoice(req.getApplyId(),req.getReceivePhone(),req.getEmailAddress());
        return JsonResVo.buildSuccess();
    }
}

