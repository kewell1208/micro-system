package com.tclab.weixinappletuserclient.controller.front.acquisition_client;

import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletservice.model.result.GoodExtendBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AcquisitionBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.StaffExtendVo;
import com.tclab.weixinappletservice.pojo.AppletAcquisition;
import com.tclab.weixinappletservice.service.clientService.*;
import com.tclab.weixinappletuserclient.model.req.apiReq.NoReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.QueryMessageReq;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/acquisition/person")
public class AcPersonalController {

    private static final Logger logger = LoggerFactory.getLogger(AcPersonalController.class);

    @Autowired
    private MessageService messageService;
    @Autowired
    private StaffService staffService;
    @Autowired
    private AcquisitionService acquisitionService;
    @Autowired
    private GoodService goodService;
    @Autowired
    private UserService userService;

    /**
     * 查询消息
     * @param req
     * @return
     */
    @RequestMapping(value="/query/message", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryMessage(QueryMessageReq req){

        logger.info("采集点查询消息 "+req.toString());

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
     * 獲取員工信息
     * @param phone
     * @return
     */
    @RequestMapping(value="/query/staff", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryStaff(@RequestParam String phone){

        logger.info("采集点查询员工信息 "+"phone: "+phone);

        if (StringUtils.isBlank(phone)){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        StaffExtendVo staffExtendVo = staffService.getStaffExtendVoByStaffIdOrPhone(null,phone);
        if (staffExtendVo!=null){
            return JsonResVo.buildSuccess(staffExtendVo);
        }else {
            return JsonResVo.buildFail(ErrorEnum.USER_NOT_EXIST);
        }
    }

    /**
     * 查詢采集點
     * @param acquisitionId
     * @return
     */
    @RequestMapping(value="/query/acquisition", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryAcquisition(@RequestParam String acquisitionId){

        logger.info("采集点查询采集点详细信息 "+acquisitionId);

        if (StringUtils.isBlank(acquisitionId)){
            return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
        }
        AppletAcquisition acquisition = acquisitionService.getAcquisitionByAcquisitionId(acquisitionId);

        AcquisitionBaseVo acquisitionBaseVo = new AcquisitionBaseVo();
        if (acquisition!=null){
            BeanUtils.copyProperties(acquisition,acquisitionBaseVo);
            acquisitionBaseVo.setDistance(0);
            acquisitionBaseVo.setAcquisitionPriority(null);
            acquisitionBaseVo.setOrderCount(0);
        } else {
            acquisitionBaseVo = null;
        }

        if (acquisitionBaseVo!=null){
            return JsonResVo.buildSuccess(acquisitionBaseVo);
        }else {
            return JsonResVo.buildFail(ErrorEnum.USER_NOT_EXIST);
        }
    }

    /**
     * 采集点员工查询推荐记录
     * @param staffId
     * @param queryParam
     * @return
     */
    @RequestMapping(value="/query/recommend", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryReport(@RequestParam String staffId,@RequestParam String queryParam ){

        logger.info("采集点查询推荐记录 "+"staffId: "+staffId+"queryParam: "+queryParam);

        List<GoodExtendBaseVo> baseVoResult = goodService.getGoodExtendBaseVos(staffId,queryParam);
        if (baseVoResult==null||baseVoResult.size()==0){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildSuccess(goodService.goupByGoodExtendBaseVo(baseVoResult));
        }
    }

    @RequestMapping(value="/edit/pwd", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo changePassword(@RequestBody NoReq req){

        logger.info("采集点端更改密码 "+req.getUserId());

        if (StringUtils.isBlank(req.getUserId())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"用户ID不能为空");
        }

        int i = userService.editPwd(req.getUserId(),req.getPassword(),req.getPhone());
        if (i>0) {
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.SERVICE_ERROR);
        }
    }

}
