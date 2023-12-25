package com.tclab.weixinappletuserclient.controller.front.doctor_client;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.constant.GoodConstants;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.PayUtils;
import com.tclab.weixinappletservice.model.result.DoctorRecommendResult;
import com.tclab.weixinappletservice.model.result.PackageListForDoctorVo;
import com.tclab.weixinappletservice.model.result.ShulanParticipantListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ShulanRecommendListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.shulanVo.NoReq;
import com.tclab.weixinappletservice.model.vo.clientVo.shulanVo.PackageListForShulanVo;
import com.tclab.weixinappletservice.model.vo.clientVo.shulanVo.QueryReq;
import com.tclab.weixinappletservice.model.vo.clientVo.shulanVo.ShulanParticipantGoodVo;
import com.tclab.weixinappletservice.pojo.AppletGood;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletPackage;
import com.tclab.weixinappletservice.service.clientService.GoodService;
import com.tclab.weixinappletservice.service.clientService.PackageService;
import com.tclab.weixinappletservice.service.clientService.ParticipantService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping(value = "/doctor")
public class DcOrderController {

    private static final Logger logger = LoggerFactory.getLogger(DcOrderController.class);

    @Autowired
    private GoodService goodService;
    @Autowired
    private PackageService packageService;
    @Autowired
    private ParticipantService participantService;

    /**
     * 查询解读报告列表
     * @param req
     * @return
     */
    @RequestMapping(value="/queryReportList",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryOrderByOrderNo(QueryReq req){
        logger.info("医生端查询解读报告列表 "+req.toString());

        //校验时间戳
        Date queryDate = new Date(Long.parseLong(req.getCurTime()));
        Date currentDate = new Date();
        if (currentDate.getTime()-queryDate.getTime()>120000){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"请求时间过期");
        }
        //校验签名
        Map<String, String> validParams = new HashMap<>();
        validParams.put("curTime",req.getCurTime());
        validParams.put("doctorPhone",req.getDoctorPhone());
        validParams.put("status",req.getStatus());
        validParams.put("pageNo",req.getPageNo());
        validParams.put("pageSize",req.getPageSize());
        validParams.put("queryParam",req.getQueryParam());

        String validStr = PayUtils.createLinkString(validParams);
        logger.info("拼接字符串"+validStr);
        String sign = PayUtils.sign(validStr, CommonConstants.sign_key, "utf-8").toUpperCase();
        logger.info("签名"+sign);
        if (!sign.equals(req.getSign())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"签名错误");
        }

        if (StringUtils.isBlank(req.getDoctorPhone())){
            throw new RuntimeException("医生端查询解读报告列表错误: 医生手机号位空");
        }

        Integer goodStatus = null;
        if (req.getStatus()!=null){
            if (req.getStatus().equals("0")){
                goodStatus = GoodConstants.GOOD_STATUS_REPORTED;
            } else if (req.getStatus().equals("1")){
                goodStatus = GoodConstants.GOOD_STATUS_INTERPRETED;
            }
        }

        List<ShulanRecommendListVo> shulanRecommendListVoList = new ArrayList<>();

        //转换分页参数
        Integer page = 1;
        if (StringUtils.isNotBlank(req.getPageNo())){
            page = Integer.parseInt(req.getPageNo());
        }
        Integer size = 20;
        if (StringUtils.isNotBlank(req.getPageNo())){
            size = Integer.parseInt(req.getPageSize());
        }

//        List<AppletGood> goodList = goodService.getGoodByStaff(req.getDoctorPhone(),goodStatus,page,size);
        List<ShulanRecommendListVo> goodList = goodService.getGoodByStaffNew(req.getDoctorPhone(),goodStatus,req.getQueryParam(),page,size);

//        if (goodList!=null){
//            for (AppletGood good:goodList) {
//                ShulanRecommendListVo shulanRecommendListVo = new ShulanRecommendListVo();
//                shulanRecommendListVo.setGoodNo(good.getGoodNo());
//                shulanRecommendListVo.setOrderNo(good.getOrderNo());
//                shulanRecommendListVo.setPackageId(good.getPackageId());
//                shulanRecommendListVo.setPackageName(good.getPackageName());
//                shulanRecommendListVo.setSampleCollectDate(DateUtils.convertToStandardDate(good.getSampleCollectDate()));
//                if (good.getGoodStatus().equals(GoodConstants.GOOD_STATUS_REPORTED)){
//                    shulanRecommendListVo.setReportStatus(0);
//                } else if (good.getGoodStatus().equals(GoodConstants.GOOD_STATUS_INTERPRETED)){
//                    shulanRecommendListVo.setReportStatus(1);
//                }
//
//                shulanRecommendListVo.setInterpretName(good.getDoctorName());
//                shulanRecommendListVo.setInterpretPhone(good.getDoctorPhone());
//                shulanRecommendListVo.setDoctorName(good.getDoctorName());
//                shulanRecommendListVo.setDoctorPhone(good.getDoctorPhone());
//
//                shulanRecommendListVo.setReportImg(good.getReportImg());
//                shulanRecommendListVo.setReportDate(DateUtils.convertToSlashAndDayDate(good.getReportDate()));
//
//                shulanRecommendListVo.setSampleNo(good.getSampleNo());
//                AppletOrderParticipant participant = participantService.getParticipantByOrderNo(good.getOrderNo());
//                if (participant!=null){
//                    shulanRecommendListVo.setParticipantName(participant.getParticipantName());
//                    shulanRecommendListVo.setParticipantPhone(participant.getParticipantPhone());
//                    shulanRecommendListVo.setParticipantSex(participant.getParticipantSex());
//                    shulanRecommendListVo.setParticipantAge(participant.getParticipantAge());
//                }
//                shulanRecommendListVoList.add(shulanRecommendListVo);
//            }
//        }
        logger.info("返回结果"+goodList);
        return JsonResVo.buildSuccess(goodList);
    }

    /**
     * 查询套餐列表
     * @param req
     * @return
     */
    @RequestMapping(value="/packageList",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryPackageList(QueryReq req){

        logger.info("医生端查询套餐列表: "+req.toString());

        //校验时间戳
        Date queryDate = new Date(Long.parseLong(req.getCurTime()));
        Date currentDate = new Date();
        if (currentDate.getTime()-queryDate.getTime()>120000){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"请求时间过期");
        }
        //校验签名
        Map<String, String> validParams = new HashMap<>();
        validParams.put("curTime",req.getCurTime());
        validParams.put("pageNo",req.getPageNo());
        validParams.put("pageSize",req.getPageSize());
        validParams.put("queryParam",req.getQueryParam());

        String validStr = PayUtils.createLinkString(validParams);
        logger.info("拼接字符串"+validStr);
        String sign = PayUtils.sign(validStr, CommonConstants.sign_key, "utf-8").toUpperCase();
        logger.info("签名"+sign);
        if (!sign.equals(req.getSign())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"签名错误");
        }

        //转换分页参数
        Integer page = 1;
        if (StringUtils.isNotBlank(req.getPageNo())){
            page = Integer.parseInt(req.getPageNo());
        }
        Integer size = 20;
        if (StringUtils.isNotBlank(req.getPageNo())){
            size = Integer.parseInt(req.getPageSize());
        }

        List<PackageListForDoctorVo> packageListForShulanVoList = packageService.getAllPackageByLimit(req.getQueryParam(),page,size);
        return JsonResVo.buildSuccess(packageListForShulanVoList);
    }

    /**
     * 按月查询医生推荐套餐列表
     * @param req
     * @return
     */
    @RequestMapping(value="/queryRecordPackage",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryRecordPackage(QueryReq req){

        logger.info("医生端按月查询医生推荐套餐列表 "+req.toString());

        //校验时间戳
        Date queryDate = new Date(Long.parseLong(req.getCurTime()));
        Date currentDate = new Date();
        if (currentDate.getTime()-queryDate.getTime()>120000){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"请求时间过期");
        }
        //校验签名
        Map<String, String> validParams = new HashMap<>();
        validParams.put("curTime",req.getCurTime());
        validParams.put("doctorPhone",req.getDoctorPhone());
        validParams.put("pageNo",req.getPageNo());
        validParams.put("pageSize",req.getPageSize());
        validParams.put("date",req.getDate());

        String validStr = PayUtils.createLinkString(validParams);
        logger.info("拼接字符串"+validStr);
        String sign = PayUtils.sign(validStr, CommonConstants.sign_key, "utf-8").toUpperCase();
        logger.info("签名"+sign);
        if (!sign.equals(req.getSign())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"签名错误");
        }

        //转换分页参数
        Integer page = 1;
        if (StringUtils.isNotBlank(req.getPageNo())){
            page = Integer.parseInt(req.getPageNo());
        }
        Integer size = 20;
        if (StringUtils.isNotBlank(req.getPageNo())){
            size = Integer.parseInt(req.getPageSize());
        }

        if (StringUtils.isBlank(req.getDoctorPhone())){
            throw new RuntimeException("医生端按月查询医生推荐套餐列表: 医生手机号位空");
        }

        String month = req.getDate().replace("_","/");

        List<DoctorRecommendResult> result = goodService.getDoctorRecommendNumListByMonth(req.getDoctorPhone(),month,page,size);
        return JsonResVo.buildSuccess(result);
    }

    /**
     * 按月查询医生推荐商品列表
     * @param req
     * @return
     */
    @RequestMapping(value="/queryGoodList",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryGoodList(QueryReq req){

        logger.info("医生端按月查询医生推荐商品列表 "+req.toString());

        //校验时间戳
        Date queryDate = new Date(Long.parseLong(req.getCurTime()));
        Date currentDate = new Date();
        if (currentDate.getTime()-queryDate.getTime()>120000){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"请求时间过期");
        }
        //校验签名
        Map<String, String> validParams = new HashMap<>();
        validParams.put("curTime",req.getCurTime());
        validParams.put("doctorPhone",req.getDoctorPhone());
        validParams.put("pageNo",req.getPageNo());
        validParams.put("pageSize",req.getPageSize());
        validParams.put("date",req.getDate());
        validParams.put("packageId",req.getPackageId());
        validParams.put("queryParam",req.getQueryParam());

        String validStr = PayUtils.createLinkString(validParams);
        logger.info("拼接字符串"+validStr);
        String sign = PayUtils.sign(validStr, CommonConstants.sign_key, "utf-8").toUpperCase();
        logger.info("签名"+sign);
        if (!sign.equals(req.getSign())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"签名错误");
        }

        //转换分页参数
        Integer page = 1;
        if (StringUtils.isNotBlank(req.getPageNo())){
            page = Integer.parseInt(req.getPageNo());
        }
        Integer size = 20;
        if (StringUtils.isNotBlank(req.getPageNo())){
            size = Integer.parseInt(req.getPageSize());
        }

        if (StringUtils.isBlank(req.getDoctorPhone())){
            throw new RuntimeException("医生端按月查询医生推荐商品列表: 医生手机号位空");
        }

        String month = req.getDate().replace("_","/");

        ShulanParticipantGoodVo participantGoodVo = new ShulanParticipantGoodVo();
//        List<AppletGood> goodList = goodService.getGoodByStaffAndPackage(req.getDoctorPhone(),req.getPackageId(),month,req.getQueryParam(),page,size);
//        List<ShulanParticipantListVo> participantListVoList = new ArrayList<>();
//        for (AppletGood good:goodList) {
//            ShulanParticipantListVo shulanParticipantListVo = new ShulanParticipantListVo();
//            shulanParticipantListVo.setGoodNo(good.getGoodNo());
//            shulanParticipantListVo.setOrderNo(good.getOrderNo());
//            shulanParticipantListVo.setSampleCollectDate(DateUtils.convertToStandardDate(good.getSampleCollectDate()));
//            shulanParticipantListVo.setSampleNo(good.getSampleNo());
//            AppletOrderParticipant participant = participantService.getParticipantByOrderNo(good.getOrderNo());
//            if (participant!=null){
//                shulanParticipantListVo.setParticipantId(participant.getParticipantId());
//                shulanParticipantListVo.setParticipantName(participant.getParticipantName());
//            }
//            participantListVoList.add(shulanParticipantListVo);
//        }
        List<ShulanParticipantListVo> participantListVoList = goodService.getGoodByStaffAndPackageNew(req.getDoctorPhone(),req.getPackageId(),month,req.getQueryParam(),page,size);
        for (ShulanParticipantListVo listVo:participantListVoList) {
            listVo.setDateStr(DateUtils.convertToSlashAndMinDate(listVo.getCreateDate()));
        }
        participantGoodVo.setParticipantList(participantListVoList);
        participantGoodVo.setRecordNum(participantListVoList.size());
        return JsonResVo.buildSuccess(participantGoodVo);
    }

    /**
     * 更新解读状态
     * @param req
     * @return
     */
    @RequestMapping(value="/notifyStatus",method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo notifyStatus(@RequestBody NoReq req){

        logger.info("医生端更新解读状态 "+req.toString());

        //校验时间戳
        Date queryDate = new Date(Long.parseLong(req.getCurTime()));
        Date currentDate = new Date();
        if (currentDate.getTime()-queryDate.getTime()>120000){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"请求时间过期");
        }
        //校验签名
        Map<String, String> validParams = new HashMap<>();
        validParams.put("curTime",req.getCurTime());
        validParams.put("goodNo",req.getGoodNo());
        validParams.put("doctorName",req.getDoctorName());
        validParams.put("doctorPhone",req.getDoctorPhone());

        String validStr = PayUtils.createLinkString(validParams);
        logger.info("拼接字符串"+validStr);
        String sign = PayUtils.sign(validStr, CommonConstants.sign_key, "utf-8").toUpperCase();
        logger.info("签名"+sign);
        if (!sign.equals(req.getSign())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"签名错误");
        }

        if (StringUtils.isBlank(req.getGoodNo())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"商品号不存在");
        }

        boolean c = goodService.norifyByShulan(req.getGoodNo(),req.getDoctorName(),req.getDoctorPhone());
        if (c){
            return JsonResVo.buildSuccess();
        } else {
            return JsonResVo.buildFail(ErrorEnum.ERROR_BIZ_FAIL);
        }
    }

    /**
     * 查询报告图片
     * @param req
     * @return
     */
    @RequestMapping(value="/pdfImg",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryReportImg(@RequestBody NoReq req){

        logger.info("医生端查询报告图片 "+req.toString());

        //校验时间戳
        Date queryDate = new Date(Long.parseLong(req.getCurTime()));
        Date currentDate = new Date();
        if (currentDate.getTime()-queryDate.getTime()>120000){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"请求时间过期");
        }
        //校验签名
        Map<String, String> validParams = new HashMap<>();
        validParams.put("curTime",req.getCurTime());
        validParams.put("goodNo",req.getGoodNo());

        String validStr = PayUtils.createLinkString(validParams);
        logger.info("拼接字符串"+validStr);
        String sign = PayUtils.sign(validStr, CommonConstants.sign_key, "utf-8").toUpperCase();
        logger.info("签名"+sign);
        if (!sign.equals(req.getSign())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"签名错误");
        }

        if (StringUtils.isBlank(req.getGoodNo())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"商品号不存在");
        }

        AppletGood good = goodService.getGoodByGoodNo(req.getGoodNo(),null);
        if (good!=null){
            if (good.getGoodStatus().equals(GoodConstants.GOOD_STATUS_REPORTED)||good.getGoodStatus().equals(GoodConstants.GOOD_STATUS_INTERPRETED)){
                if (StringUtils.isNotBlank(good.getReportImg())) {
                    return JsonResVo.buildSuccess(good.getReportImg());
                }
            }
        }
        return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(),"未出套餐报告");
    }

    /**
     * 查询商品详情
     * @param req
     * @return
     */
    @RequestMapping(value="/queryGood",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryGood(NoReq req){

        logger.info("医生端查询商品详情 "+req.toString());

        //校验时间戳
        Date queryDate = new Date(Long.parseLong(req.getCurTime()));
        Date currentDate = new Date();
        if (currentDate.getTime()-queryDate.getTime()>120000){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"请求时间过期");
        }
        //校验签名
        Map<String, String> validParams = new HashMap<>();
        validParams.put("curTime",req.getCurTime());
        validParams.put("goodNo",req.getGoodNo());

        String validStr = PayUtils.createLinkString(validParams);
        logger.info("拼接字符串"+validStr);
        String sign = PayUtils.sign(validStr, CommonConstants.sign_key, "utf-8").toUpperCase();
        logger.info("签名"+sign);
        if (!sign.equals(req.getSign())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"签名错误");
        }

        if (StringUtils.isBlank(req.getGoodNo())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"商品号不存在");
        }

        AppletGood good = goodService.getGoodByGoodNo(req.getGoodNo(),null);
        if (good!=null){
            ShulanRecommendListVo shulanRecommendListVo = new ShulanRecommendListVo();
            shulanRecommendListVo.setGoodNo(good.getGoodNo());
            shulanRecommendListVo.setOrderNo(good.getOrderNo());
            shulanRecommendListVo.setPackageId(good.getPackageId());
            shulanRecommendListVo.setPackageName(good.getPackageName());
            shulanRecommendListVo.setSampleCollectDate(DateUtils.convertToStandardDate(good.getSampleCollectDate()));
            if (good.getGoodStatus().equals(GoodConstants.GOOD_STATUS_REPORTED)){
                shulanRecommendListVo.setReportStatus(0);
            } else if (good.getGoodStatus().equals(GoodConstants.GOOD_STATUS_INTERPRETED)){
                shulanRecommendListVo.setReportStatus(1);
            }

            shulanRecommendListVo.setInterpretName(good.getDoctorName());
            shulanRecommendListVo.setInterpretPhone(good.getDoctorPhone());
            shulanRecommendListVo.setDoctorName(good.getDoctorName());
            shulanRecommendListVo.setDoctorPhone(good.getDoctorPhone());

            shulanRecommendListVo.setSampleNo(good.getSampleNo());
            AppletOrderParticipant participant = participantService.getParticipantByOrderNo(good.getOrderNo());
            if (participant!=null){
                shulanRecommendListVo.setParticipantName(participant.getParticipantName());
                shulanRecommendListVo.setParticipantPhone(participant.getParticipantPhone());
                shulanRecommendListVo.setParticipantSex(participant.getParticipantSex());
                shulanRecommendListVo.setParticipantAge(participant.getParticipantAge());
            }
            return JsonResVo.buildSuccess(shulanRecommendListVo);
        }
        return JsonResVo.buildSuccess();
    }

    /**
     * 查询套餐详情
     * @param req
     * @return
     */
    @RequestMapping(value="/queryPackage",method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryPackageById(QueryReq req){

        logger.info("医生端查询套餐详情");

        if (StringUtils.isBlank(req.getPackageId())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"套餐ID为空");
        }

        //校验时间戳
        Date queryDate = new Date(Long.parseLong(req.getCurTime()));
        Date currentDate = new Date();
        if (currentDate.getTime()-queryDate.getTime()>120000){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"请求时间过期");
        }
        //校验签名
        Map<String, String> validParams = new HashMap<>();
        validParams.put("curTime",req.getCurTime());
        validParams.put("packageId",req.getPackageId());

        String validStr = PayUtils.createLinkString(validParams);
        logger.info("拼接字符串"+validStr);
        String sign = PayUtils.sign(validStr, CommonConstants.sign_key, "utf-8").toUpperCase();
        logger.info("签名"+sign);
        if (!sign.equals(req.getSign())){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"签名错误");
        }

        AppletPackage appletPackage = packageService.getPackageById(req.getPackageId());
        if (appletPackage==null){
            return JsonResVo.buildSuccess();
        }
        PackageListForShulanVo packageListForShulanVo = new PackageListForShulanVo();
        packageListForShulanVo.setPackageSpecialRequirement(appletPackage.getPackageSpecialRequirement());
        packageListForShulanVo.setPackageRemark(appletPackage.getPackageRemark());
        packageListForShulanVo.setPackageName(appletPackage.getPackageName());
        packageListForShulanVo.setPackageId(req.getPackageId());
        packageListForShulanVo.setPackageCurrentPrice(appletPackage.getPackageCurrentPrice());
        packageListForShulanVo.setPackageRecommendationNum(appletPackage.getPackageRecommendation());
        return JsonResVo.buildSuccess(packageListForShulanVo);
    }

}
