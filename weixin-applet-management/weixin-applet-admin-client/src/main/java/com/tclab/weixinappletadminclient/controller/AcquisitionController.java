package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.EditAcquisitionReq;
import com.tclab.weixinappletadminclient.model.req.QueryAcquisitionReq;
import com.tclab.weixinappletadminclient.model.req.StopReq;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.AcquisitionDetailVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.AcquisitionPageVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.EditAcquisitionReqVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.QueryAcquisitionReqVo;
import com.tclab.weixinappletservice.pojo.AppletArea;
import com.tclab.weixinappletservice.pojo.AppletClerk;
import com.tclab.weixinappletservice.pojo.AppletPackageSource;
import com.tclab.weixinappletservice.service.adminService.AdminAcquisitionService;
import com.tclab.weixinappletservice.service.adminService.AdminAreaService;
import com.tclab.weixinappletservice.service.adminService.AdminClerkService;
import com.tclab.weixinappletservice.service.adminService.AdminSourceService;
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
@Api(description = "机构管理模块",tags = "后台-机构管理")
@RestController
@RequestMapping(value = "/back/acquisition")
public class AcquisitionController {

    private static final Logger logger = LoggerFactory.getLogger(AcquisitionController.class);

    @Autowired
    private AdminAcquisitionService acquisitionService;
    @Autowired
    private AdminClerkService adminClerkService;
    @Autowired
    private AdminAreaService adminAreaService;
    @Autowired
    private AdminSourceService adminSourceService;

    @ApiOperation(value = "查询采集点列表" ,  notes="采集点列表")
    @RequestMapping(value="/queryList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<AcquisitionPageVo> queryUserList(@ApiParam(name="QueryUserReq",value="员工查询参数",required=true) QueryAcquisitionReq req){
        logger.info("后台查询采集点列表: "+ req.toString());

        QueryAcquisitionReqVo reqVo = new QueryAcquisitionReqVo();
        BeanUtils.copyProperties(req,reqVo);

        AcquisitionPageVo acquisitionPageVo = acquisitionService.getPageVoByQueryReq(reqVo);
        return JsonResNewVo.buildSuccess(acquisitionPageVo);
    }

    @ApiOperation(value = "查询机构员工详情" ,  notes="机构员工详情")
    @ApiImplicitParam(paramType = "path",name = "acquisitionId", value = "机构Id", required = true, dataType = "String")
    @RequestMapping(value="/queryAcquisitionStaff", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<AcquisitionDetailVo> queryUserDetail(@RequestParam String acquisitionId){
        logger.info("后台查询机构详情: "+ acquisitionId);
        if (StringUtils.isBlank(acquisitionId)){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"采集点编号为空");
        }
        return JsonResNewVo.buildSuccess(acquisitionService.getDetailById(acquisitionId));
    }

    @ApiOperation(value = "停用机构" ,  notes="停用机构")
//    @ApiImplicitParam(paramType = "path",name = "staffIds", value = "机构Id", required = true, dataType = "List<String>")
    @RequestMapping(value="/stopStaff", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResNewVo stopAcquisition(@RequestBody @ApiParam(name="stopReq",value="停用套餐参数",required=true) StopReq req){
        logger.info("停用机构: "+ req.getAcquisitionIds());
        if (req.getAcquisitionIds() == null || req.getAcquisitionIds().size() == 0){
            return JsonResNewVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"机构编号为空");
        }
        return JsonResNewVo.buildSuccess(acquisitionService.changeAcquisitionStatus(req.getAcquisitionIds(),req.getStatus()));
    }

    @ApiOperation(value = "编辑机构" ,  notes="编辑机构")
    @RequestMapping(value="/editAcquisition", method = RequestMethod.POST,consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo editAcquisition(@RequestBody @ApiParam(name="editAcquisition",value="编辑机构参数",required=true) EditAcquisitionReq req){
        logger.info("编辑机构: " + req.toString());
        if (req.getLatitude()==null&&req.getLongitude()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"坐标不能为空");
        }
        if (req.getAcquisitionPriority()==null){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"优先级不能为空");
        }

        EditAcquisitionReqVo reqVo = new EditAcquisitionReqVo();
        BeanUtils.copyProperties(req,reqVo);

        return JsonResVo.buildSuccess(acquisitionService.editAcquisition(reqVo));
    }

    @ApiOperation(value = "查询机构详情" ,  notes="用于编辑信息")
    @RequestMapping(value="/queryAcquisitionInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryAcquisitionInfo(@RequestParam String acquisitionId){
        logger.info("编辑机构: " + acquisitionId);
        if (StringUtils.isBlank(acquisitionId)){
            return JsonResVo.buildErrorResult(ErrorEnum.PARAM_ERROR_EMPTY.getErrorCode(),"采集点ID不能为空");
        }
        return JsonResVo.buildSuccess(acquisitionService.getAcquisitionInfoById(acquisitionId));
    }

    @ApiOperation(value = "查询业务人员列表" ,  notes="业务人员列表")
    @RequestMapping(value="/queryClerkList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryClerkList(){
        logger.info("后台查询业务人员列表");
        List<AppletClerk> clerkList = adminClerkService.getClerkList(null,true);
        return JsonResVo.buildSuccess(clerkList);
    }

    @ApiOperation(value = "查询区域列表" ,  notes="区域列表")
    @RequestMapping(value="/queryAreaList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryAreaList(){
        logger.info("后台查询区域列表");
        List<AppletArea> areaList = adminAreaService.getAreaList(null,true);
        return JsonResVo.buildSuccess(areaList);
    }

    @ApiOperation(value = "查询套餐来源列表" ,  notes="套餐来源列表")
    @RequestMapping(value="/querySourceList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo queryPackageSourList(){
        logger.info("后台查询区域列表");
        List<AppletPackageSource> sourceList = adminSourceService.getEnablePackageSourceList();
        return JsonResVo.buildSuccess(sourceList);
    }
}
