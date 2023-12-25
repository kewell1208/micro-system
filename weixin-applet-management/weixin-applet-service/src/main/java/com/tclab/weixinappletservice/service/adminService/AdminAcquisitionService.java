package com.tclab.weixinappletservice.service.adminService;

import static com.tclab.weixinappletcommon.constant.AcquisitionConstants.ACQUISITION_TYPE_INIT;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.AcquisitionConstants;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletservice.dao.AppletAcquisitionMapper;
import com.tclab.weixinappletservice.dao.AppletAcquisitionScheduleMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.*;
import com.tclab.weixinappletservice.pojo.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AdminAcquisitionService {

    private static final Logger logger = LoggerFactory.getLogger(AdminAcquisitionService.class);


    @Autowired
    private AppletAcquisitionMapper acquisitionMapper;
    @Autowired
    private AdminClerkService adminClerkService;
    @Autowired
    private AdminStaffService adminStaffService;
    @Autowired
    private AppletAcquisitionScheduleMapper scheduleMapper;
    @Autowired
    private RedisUtils redisUtils;

    /**
     * 获取提成模块下采集点的信息
     * @param req
     * @return
     */
    public AcquisitionCommissionPageVo getAcquisitionCommissionPageList(QueryAcquisitionCommissionReqVo req){
        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria acquisitionExampleCriteria = acquisitionExample.createCriteria();
        if (StringUtils.isNotBlank(req.getAcquisitionId()))
        acquisitionExampleCriteria.andAcquisitionIdEqualTo(req.getAcquisitionId());
        if (StringUtils.isNotBlank(req.getAcquisitionName()))
        acquisitionExampleCriteria.andAcquisitionNameLike("%"+req.getAcquisitionName()+"%");
        if (req.getCommissionFlag()!=null)
        acquisitionExampleCriteria.andCommissionFlagEqualTo(req.getCommissionFlag());

        acquisitionExampleCriteria.andAcquisitionTypeEqualTo(ACQUISITION_TYPE_INIT);
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(acquisitionExample);
        PageInfo<AppletAcquisition> acquisitionPageInfo = new PageInfo<>(acquisitionList);

        if (acquisitionPageInfo!=null&&acquisitionPageInfo.getList()!=null) {
            AcquisitionCommissionPageVo acquisitionCommissionPageVo = new AcquisitionCommissionPageVo();
            acquisitionCommissionPageVo.setCurrentPageNo(acquisitionPageInfo.getPageNum());
            acquisitionCommissionPageVo.setOrderNum(acquisitionPageInfo.getTotal());
            acquisitionCommissionPageVo.setPageNum(acquisitionPageInfo.getPages());

            List<AcquisitionCommissionListVo> acquisitionCommissionListVoList = new ArrayList<>();
            for (AppletAcquisition acquisition:acquisitionPageInfo.getList()) {
                AcquisitionCommissionListVo acquisitionCommissionListVo = new AcquisitionCommissionListVo();
                acquisitionCommissionListVo.setAcquisitionId(acquisition.getAcquisitionId());
                acquisitionCommissionListVo.setAcquisitionName(acquisition.getAcquisitionName());
                acquisitionCommissionListVo.setAcquisitionPhone(acquisition.getAcquisitionPhone());
                acquisitionCommissionListVo.setClerkId(acquisition.getClerkId());
                acquisitionCommissionListVo.setCommissionFlag(acquisition.getCommissionFlag());
                acquisitionCommissionListVo.setId(acquisition.getId());

                if (acquisition.getClerkId()!=null){
                    AppletClerk clerk = adminClerkService.getClerkByClerkId(acquisition.getClerkId());
                    if (clerk!=null){
                        acquisitionCommissionListVo.setClerkId(clerk.getClerkId());
                        acquisitionCommissionListVo.setClerkPhone(clerk.getClerkPhone());
                        acquisitionCommissionListVo.setClerkName(clerk.getClerkName());
                    }
                }

                acquisitionCommissionListVoList.add(acquisitionCommissionListVo);
            }
            acquisitionCommissionPageVo.setAcquisitionCommissionListVoList(acquisitionCommissionListVoList);

            return acquisitionCommissionPageVo;
        }
        return null;
    }

    public AppletAcquisition getAcquisitionById(String acquisitionId){
        if (StringUtils.isBlank(acquisitionId)){
            return null;
        }
        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria acquisitionExampleCriteria = acquisitionExample.createCriteria();
        acquisitionExampleCriteria.andAcquisitionIdEqualTo(acquisitionId);
        List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(acquisitionExample);
        if (acquisitionList.size()!=0){
            return acquisitionList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 获取和提成有关的采集点信息
     * @param acquisitionId
     * @return
     */
    public AcquisitionCommissionDetailVo getAcquisitionCommission(String acquisitionId){
        if (StringUtils.isBlank(acquisitionId)){
            return null;
        }
        AppletAcquisition acquisition = getAcquisitionById(acquisitionId);
        if (acquisition==null){
            return null;
        }

        AcquisitionCommissionDetailVo acquisitionCommissionDetailVo = new AcquisitionCommissionDetailVo();
        BeanUtils.copyProperties(acquisition,acquisitionCommissionDetailVo);
        acquisitionCommissionDetailVo.setCreateDate(DateUtils.convertToStandardDate(acquisition.getCreateDate()));

        if (acquisition.getClerkId()!=null){
            AppletClerk clerk = adminClerkService.getClerkByClerkId(acquisition.getClerkId());
            if (clerk!=null){
                acquisitionCommissionDetailVo.setClerkId(clerk.getClerkId());
                acquisitionCommissionDetailVo.setClerkPhone(clerk.getClerkPhone());
                acquisitionCommissionDetailVo.setClerkName(clerk.getClerkName());
            }
        }

        return acquisitionCommissionDetailVo;
    }

    /**
     * 更新采集点的提成设置标记
     * @param acquisitionId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean updateCommissionFlag(String acquisitionId){

        if (StringUtils.isBlank(acquisitionId)){
            throw new RuntimeException("更新采集点的提成设置标记失败 acquisitionId为空");
        }

        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria acquisitionExampleCriteria = acquisitionExample.createCriteria();
        acquisitionExampleCriteria.andAcquisitionIdEqualTo(acquisitionId);

        AppletAcquisition update = new AppletAcquisition();
        update.setCommissionFlag(CommonConstants.ENABLE);
        update.setUpdateDate(new Date());

        int i = acquisitionMapper.updateByExampleSelective(update,acquisitionExample);
        if (i==0){
            throw new RuntimeException("更新采集点的提成设置标记失败 acquisitionId: "+acquisitionId);
        }
        return true;
    }

    public AcquisitionPageVo getPageVoByQueryReq(QueryAcquisitionReqVo req) {
        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria criteria = acquisitionExample.createCriteria();
        if (StringUtils.isNotBlank(req.getAcquisitionId())) {
            criteria.andAcquisitionIdEqualTo(req.getAcquisitionId());
        }
        if (StringUtils.isNotBlank(req.getAcquisitionName())) {
            criteria.andAcquisitionNameLike("%" + req.getAcquisitionName()+"%");
        }
        if (StringUtils.isNotBlank(req.getAcquisitionPhone())) {
            criteria.andAcquisitionPhoneLike(req.getAcquisitionPhone()+"%");
        }
        if (StringUtils.isNotBlank(req.getDirectorName())) {
            criteria.andDirectorNameLike("%"+req.getDirectorName()+"%");
        }
        if (StringUtils.isNotBlank(req.getDirectorPhone())) {
            criteria.andDirectorPhoneLike("%"+req.getDirectorPhone()+"%");
        }
        if (req.getCollectType()!=null){
            criteria.andAcquisitionCollectTypeEqualTo(req.getCollectType());
        }
         criteria.andAcquisitionTypeEqualTo(ACQUISITION_TYPE_INIT);
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(acquisitionExample);
        PageInfo<AppletAcquisition> acquisitionPageInfo = new PageInfo<>(acquisitionList);

        if (acquisitionPageInfo != null && acquisitionPageInfo.getList() != null) {
            AcquisitionPageVo acquisitionPageVo = new AcquisitionPageVo();
            acquisitionPageVo.setCurrentPageNo(acquisitionPageInfo.getPageNum());
            acquisitionPageVo.setAcquisitionNum(acquisitionPageInfo.getTotal());
            acquisitionPageVo.setPageNum(acquisitionPageInfo.getPages());

            List<AcquisitionListVo> acquisitionListVoList = new ArrayList<>();
            for (AppletAcquisition appletAcquisition : acquisitionPageInfo.getList()) {
                AcquisitionListVo acquisitionListVo = new AcquisitionListVo();
                BeanUtils.copyProperties(appletAcquisition, acquisitionListVo);
                acquisitionListVoList.add(acquisitionListVo);
            }
            acquisitionPageVo.setAcquisitionListVoList(acquisitionListVoList);
            return acquisitionPageVo;
        }
        return null;
    }

    public AcquisitionDetailVo getDetailById(String acquisitionId) {
        if (StringUtils.isBlank(acquisitionId)){
            return null;
        }
        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria criteria = acquisitionExample.createCriteria();
        criteria.andAcquisitionIdEqualTo(acquisitionId);
        List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(acquisitionExample);
        if (acquisitionList.size() > 0){
            AcquisitionDetailVo acquisitionDetailVo = new AcquisitionDetailVo();
            AppletAcquisition appletAcquisition = acquisitionList.get(0);
            BeanUtils.copyProperties(appletAcquisition, acquisitionDetailVo);
            acquisitionDetailVo.setCreateDate(DateUtils.convertToStandardDate(appletAcquisition.getCreateDate()));
            if (appletAcquisition.getClerkId()!= null){
                AppletClerk clerk = adminClerkService.getClerkByClerkId(appletAcquisition.getClerkId());
                if (clerk!=null){
                    acquisitionDetailVo.setClerkId(clerk.getClerkId());
                    acquisitionDetailVo.setClerkPhone(clerk.getClerkPhone());
                    acquisitionDetailVo.setClerkName(clerk.getClerkName());
                }
            }
            QueryAcquisitionStaffReqVo req = new QueryAcquisitionStaffReqVo();
            req.setAcquisitionId(appletAcquisition.getAcquisitionId());
            AcquisitionStaffPageVo acquisitionStaffPageVo = adminStaffService.getStaffPageVoByQueryReq(req);
            if(acquisitionStaffPageVo != null) {
                acquisitionDetailVo.setStaffPageVo(acquisitionStaffPageVo);
            }
            return acquisitionDetailVo;
        }
        return null;
    }

    public boolean changeAcquisitionStatus(List<String> acquisitionIds,Integer status) {
        AppletAcquisition appletAcquisition = new AppletAcquisition();
        appletAcquisition.setAcquisitionStatus(status);
        appletAcquisition.setUpdateDate(new Date());
        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria criteria = acquisitionExample.createCriteria();
        criteria.andAcquisitionIdIn(acquisitionIds);
        int i = acquisitionMapper.updateByExampleSelective(appletAcquisition, acquisitionExample);
        if (i==0){
            throw new RuntimeException("停用机构失败: " + acquisitionIds);
        }
        return true;
    }

    @Transactional
    public boolean editAcquisition(EditAcquisitionReqVo req) {

        int  i =0;

        AppletAcquisition appletAcquisition = new AppletAcquisition();
        BeanUtils.copyProperties(req, appletAcquisition);
        appletAcquisition.setClerkId(req.getStaffId());
        if (StringUtils.isBlank(req.getAcquisitionId())){
            logger.info("新增采集点开始");
//            String acquisitionId = new NumberGeneratorUtils().generateNo(CommonConstants.GenerateID_ACQUISITION, RedisConstants.ACQUISITIONID_INDEX);
            String key = RedisConstants.GENERATEID+":"+RedisConstants.ACQUISITIONID_INDEX;
            String value = redisUtils.get(key);
            Integer orderNoIndex = Integer.parseInt(value);
            value = String.format("%06d", orderNoIndex);
            String newValue = String.valueOf(Integer.parseInt(value)+1);
            redisUtils.set(key,newValue);
            String day = redisUtils.get(RedisConstants.DAY);
            String acquisitionId = CommonConstants.GenerateID_ACQUISITION+day+value;
            logger.info("redis连接测试成功  "+acquisitionId);
            appletAcquisition.setAcquisitionId(acquisitionId);
            if (req.getAcquisitionCollectType()==null){
                appletAcquisition.setAcquisitionCollectType(AcquisitionConstants.ACQUISITION_SERVICE_TYPE_ONLINE);
            }
            appletAcquisition.setAcquisitionStatus(CommonConstants.INIT);
            appletAcquisition.setDelFlag(CommonConstants.INIT);
            appletAcquisition.setCommissionFlag(CommonConstants.INIT);
            appletAcquisition.setCreateDate(new Date());
            appletAcquisition.setUpdateDate(new Date());

            appletAcquisition.setVerifyFlag(AcquisitionConstants.ACQUISITION_VERIFY_FLAG_REQUIRED);
            appletAcquisition.setLogisticsFlag(AcquisitionConstants.ACQUISITION_LOGISTICS_FLAG_REQUIRED);
            appletAcquisition.setAcquisitionType(ACQUISITION_TYPE_INIT);
            i = acquisitionMapper.insertSelective(appletAcquisition);
            if (i==0){
                logger.info("添加机构失败: " + req.toString());
                throw new RuntimeException("添加机构失败: " + req.toString());
            }

            AppletAcquisitionSchedule schedule = new AppletAcquisitionSchedule();
            schedule.setAcquisitionId(acquisitionId);
            schedule.setCreateDate(new Date());
            schedule.setDelFlag(CommonConstants.INIT);
            schedule.setUpdateDate(new Date());
            schedule.setWorkDay(req.getWorkDay());

            List<String> restDayList = req.getRestDay();
            StringBuffer stringBuffer = new StringBuffer();
            for (String restDay:restDayList) {
//                String restDayNew = restDay.substring(0,10);
                stringBuffer.append(restDay);
                stringBuffer.append(";");
            }
            if (stringBuffer.length()!=0){
                String str = stringBuffer.substring(0,stringBuffer.length()-1);
                schedule.setRestDay(str);
            }

            i=scheduleMapper.insertSelective(schedule);
            if (i==0){
                logger.info("添加预约时间失败: " + acquisitionId);
                throw new RuntimeException("添加预约时间失败: " + acquisitionId);
            }
        } else {
            logger.info("编辑采集点开始");
            appletAcquisition.setUpdateDate(new Date());
            AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
            AppletAcquisitionExample.Criteria criteria = acquisitionExample.createCriteria();
            criteria.andAcquisitionIdEqualTo(appletAcquisition.getAcquisitionId());
            i = acquisitionMapper.updateByExampleSelective(appletAcquisition, acquisitionExample);
            if (i==0){
                logger.info("编辑机构失败: " + req.toString());
                throw new RuntimeException("编辑机构失败: " + req.toString());
            }
            if (StringUtils.isNotBlank(req.getWorkDay())||(req.getRestDay()!=null&&req.getRestDay().size()!=0)){
                AppletAcquisitionScheduleExample scheduleExample = new AppletAcquisitionScheduleExample();
                AppletAcquisitionScheduleExample.Criteria scheduleExampleCriteria = scheduleExample.createCriteria();
                scheduleExampleCriteria.andAcquisitionIdEqualTo(req.getAcquisitionId());
                AppletAcquisitionSchedule schedule = new AppletAcquisitionSchedule();
                schedule.setUpdateDate(new Date());
                schedule.setWorkDay(req.getWorkDay());
                if (req.getRestDay()!=null&&req.getRestDay().size()!=0){
                    List<String> restDayList = req.getRestDay();
                    StringBuffer stringBuffer = new StringBuffer();
                    for (String restDay:restDayList) {
                        stringBuffer.append(restDay);
                        stringBuffer.append(";");
                    }
                    if (stringBuffer.length()!=0){
                        String str = stringBuffer.substring(0,stringBuffer.length()-1);
                        schedule.setRestDay(str);
                    } else {
                        schedule.setRestDay(null);
                    }
                }
                i=scheduleMapper.updateByExampleSelective(schedule,scheduleExample);
                if (i==0){
                    logger.info("编辑机构预约时间失败: " + req.getAcquisitionId());
                    throw new RuntimeException("编辑机构预约时间失败: " + req.getAcquisitionId());
                }
            }
        }
        return true;
    }


    public EditAcquisitionReqVo getAcquisitionInfoById(String acquisitionId) {
        if (StringUtils.isBlank(acquisitionId)){
            return null;
        }
        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria criteria = acquisitionExample.createCriteria();
        criteria.andAcquisitionIdEqualTo(acquisitionId);
        List<AppletAcquisition> acquisitionList = acquisitionMapper.selectByExample(acquisitionExample);
        if (acquisitionList.size() > 0){
            EditAcquisitionReqVo acquisitionInfoVo = new EditAcquisitionReqVo();
            AppletAcquisition appletAcquisition = acquisitionList.get(0);
            BeanUtils.copyProperties(appletAcquisition, acquisitionInfoVo);
            acquisitionInfoVo.setStaffId(appletAcquisition.getClerkId());

            AppletAcquisitionScheduleExample scheduleExample = new AppletAcquisitionScheduleExample();
            AppletAcquisitionScheduleExample.Criteria scheduleExampleCriteria = scheduleExample.createCriteria();
            scheduleExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
            scheduleExampleCriteria.andAcquisitionIdEqualTo(appletAcquisition.getAcquisitionId());
            List<AppletAcquisitionSchedule> scheduleList = scheduleMapper.selectByExample(scheduleExample);
            if (scheduleList!=null&&scheduleList.size()!=0){
                acquisitionInfoVo.setWorkDay(scheduleList.get(0).getWorkDay());
                String restDayStr = scheduleList.get(0).getRestDay();
                if (StringUtils.isNotBlank(restDayStr)){
                    List<String> restDayList = new ArrayList<>();
                    String[] sl = restDayStr.split(";");
                    for (String value:sl) {
                        restDayList.add(value);
                    }
                    acquisitionInfoVo.setRestDay(restDayList);
                }
            }
            return acquisitionInfoVo;
        }
        return null;
    }
}
