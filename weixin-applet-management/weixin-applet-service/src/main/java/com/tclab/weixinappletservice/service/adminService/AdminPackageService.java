package com.tclab.weixinappletservice.service.adminService;

import static com.tclab.weixinappletcommon.constant.PackageConstants.PACKAGE_TYPE_INIT;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.PackageConstants;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletservice.dao.*;
import com.tclab.weixinappletservice.model.query.PackageQueryParam;
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
public class AdminPackageService {

    private static final Logger logger = LoggerFactory.getLogger(AdminPackageService.class);


    @Autowired
    private AppletPackageMapper packageMapper;
    @Autowired
    private AppletPackageCatalogMapper catalogMapper;
    @Autowired
    private AppletPackagePurposeMapper purposeMapper;
    @Autowired
    private AppletPackagePopulationMapper populationMapper;
    @Autowired
    private AppletPackageSubMapper subMapper;
    @Autowired
    private AppletPackagePurposeFilterMapper purposeFilterMapper;
    @Autowired
    private AppletPackageTagFilterMapper tagFilterMapper;
    @Autowired
    private AdminTagService adminTagService;
    @Autowired
    private RedisUtils redisUtils;

    public AppletPackage getPackageById(String packageId){

        if (StringUtils.isBlank(packageId)){
            return null;
        }

        AppletPackageExample packageExample = new AppletPackageExample();
        AppletPackageExample.Criteria packageExampleCriteria = packageExample.createCriteria();
        packageExampleCriteria.andPackageIdEqualTo(packageId);
        packageExampleCriteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
        List<AppletPackage> packageList = packageMapper.selectByExample(packageExample);
        if (packageList.size()!=0){
            return packageList.get(0);
        } else {
            return null;
        }
    }

    public EditPackageReqVo getPackageEditInfoById(String packageId){
        AppletPackage appletPackage = getPackageById(packageId);
        if (appletPackage==null){
            throw new RuntimeException(packageId+"套餐不存在");
        }
        EditPackageReqVo editPackageReq = new EditPackageReqVo();
        BeanUtils.copyProperties(appletPackage,editPackageReq);

        List<TagVo> tagVoList = new ArrayList<>();
        List<AppletPackageTagFilter> tagFilterList = adminTagService.getPackageTagFilterListByPackageId(packageId);
        for (AppletPackageTagFilter tagFilter:tagFilterList) {
            AppletPackageTag tag = adminTagService.getPackageTagById(tagFilter.getTagId());
            if (tag!=null){
                TagVo tagVo = new TagVo();
                BeanUtils.copyProperties(tag,tagVo);
                tagVoList.add(tagVo);
            }
        }
        editPackageReq.setTagVoList(tagVoList);

        AppletPackageSubExample subExample = new AppletPackageSubExample();
        AppletPackageSubExample.Criteria subExampleCriteria = subExample.createCriteria();
        subExampleCriteria.andPackageIdEqualTo(packageId);
        subExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        List<AppletPackageSub> subList = subMapper.selectByExample(subExample);

        List<SubPackageVo> subPackageVoList = new ArrayList<>();
        List<String> subPackageStrList = new ArrayList<>();
        for (AppletPackageSub sub:subList) {
            SubPackageVo subPackageVo = new SubPackageVo();
            BeanUtils.copyProperties(sub,subPackageVo);
            subPackageVoList.add(subPackageVo);
            subPackageStrList.add(sub.getSubPackageName());
        }
        editPackageReq.setSubPackageVoList(subPackageVoList);
        editPackageReq.setSubPackageStrList(subPackageStrList);
        return editPackageReq;
    }

    /**
     * 获取提成模块下采集点的信息
     * @param req
     * @return
     */
    public PackagePageVo getPackagePageVoByQueryReq(QueryPackageReqVo req){
        AppletPackageExample appletPackageExample = new AppletPackageExample();
        AppletPackageExample.Criteria packageExampleCriteria = appletPackageExample.createCriteria();
        if (StringUtils.isNotBlank(req.getPackageId())) {
            packageExampleCriteria.andPackageIdLike("%"+req.getPackageId()+"%");
        }
        if (StringUtils.isNotBlank(req.getPackageName())) {
            packageExampleCriteria.andPackageNameLike("%"+req.getPackageName()+"%");
        }
        if (StringUtils.isNotBlank(req.getPackageCatalogId())) {
            packageExampleCriteria.andPackageCatalogIdEqualTo(req.getPackageCatalogId());
        }
        if (StringUtils.isNotBlank(req.getPackagePurposeId())) {
            packageExampleCriteria.andPackagePurposeIdEqualTo(req.getPackagePurposeId());
        }
        if (StringUtils.isNotBlank(req.getPackagePopulationId())) {
            packageExampleCriteria.andPackagePopulationIdEqualTo(req.getPackagePopulationId());
        }
        if (StringUtils.isNotBlank(req.getSourceId())){
            packageExampleCriteria.andPackageSourceIdEqualTo(req.getSourceId());
        }
        if (req.getSampleType()!=null){
            packageExampleCriteria.andSampleTypeEqualTo(req.getSampleType());
        }
        List<Integer> status = new ArrayList<>();
        status.add(PackageConstants.PACKAGE_STATUS_FINISH);
        status.add(PackageConstants.PACKAGE_STATUS_STOP);
        packageExampleCriteria.andPackageStatusIn(status);
        packageExampleCriteria.andPackageTypeEqualTo(PACKAGE_TYPE_INIT);
        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<AppletPackage> appletPackageList = packageMapper.selectByExample(appletPackageExample);
        PageInfo<AppletPackage> appletPackagePageInfo = new PageInfo<>(appletPackageList);

        if (appletPackagePageInfo != null && appletPackagePageInfo.getList() != null) {
            PackagePageVo packagePageVo = new PackagePageVo();
            packagePageVo.setCurrentPageNo(appletPackagePageInfo.getPageNum());
            packagePageVo.setPackageNum(appletPackagePageInfo.getTotal());
            packagePageVo.setPageNum(appletPackagePageInfo.getPages());

            List<PackageListVo> packageListVoList = new ArrayList<>();
            for (AppletPackage appletPackage : appletPackagePageInfo.getList()) {
                PackageListVo packageListVo = new PackageListVo();
                BeanUtils.copyProperties(appletPackage,packageListVo);
                packageListVoList.add(packageListVo);
            }
            packagePageVo.setPackageListVoList(packageListVoList);
            return packagePageVo;
        }
        return null;
    }

    public PackagePageVo getPackagePageVoByQueryReqNew(QueryPackageReqVo req){

        if (StringUtils.isBlank(req.getTagId())){
            return getPackagePageVoByQueryReq(req);
        }

        PackageQueryParam param = new PackageQueryParam();
        BeanUtils.copyProperties(req,param);

        PageHelper.startPage(req.getPageNo(),req.getPageSize());
        List<AppletPackage> appletPackageList = packageMapper.queryPackageByParam(param);
        PageInfo<AppletPackage> appletPackagePageInfo = new PageInfo<>(appletPackageList);

        List<AppletPackage> packageList= appletPackagePageInfo.getList();

        if (packageList!=null) {
            PackagePageVo packagePageVo = new PackagePageVo();
            packagePageVo.setCurrentPageNo(appletPackagePageInfo.getPageNum());
            packagePageVo.setPackageNum(appletPackagePageInfo.getTotal());
            packagePageVo.setPageNum(appletPackagePageInfo.getPages());

            List<PackageListVo> packageListVoList = new ArrayList<>();
            for (AppletPackage appletPackage : packageList) {
                PackageListVo packageListVo = new PackageListVo();
                BeanUtils.copyProperties(appletPackage,packageListVo);
                packageListVoList.add(packageListVo);
            }
            packagePageVo.setPackageListVoList(packageListVoList);
            return packagePageVo;
        }
        return null;
    }

    public String addPackage(EditPackageReqVo req) {
        AppletPackage appletPackage = new AppletPackage();
        BeanUtils.copyProperties(req, appletPackage);
        if (StringUtils.isBlank(req.getPackageId())){
            req.setPackageId(new NumberGeneratorUtils().generateNo(CommonConstants.GenerateID_PACKAGE, RedisConstants.PACKAGE_INDEX));
            appletPackage.setPackageId(req.getPackageId());
            appletPackage.setPackageStatus(PackageConstants.PACKAGE_STATUS_EDIT);
            appletPackage.setCreateDate(new Date());
            appletPackage.setPackageType(PACKAGE_TYPE_INIT);
            int  i = packageMapper.insertSelective(appletPackage);
            if (i==0){
                throw new RuntimeException("添加套餐失败: " + req.toString());
            }
        } else {
            appletPackage.setUpdateDate(new Date());
            AppletPackageExample appletPackageExample = new AppletPackageExample();
            AppletPackageExample.Criteria packageExampleCriteria = appletPackageExample.createCriteria();
            packageExampleCriteria.andPackageIdEqualTo(appletPackage.getPackageId());
            int  i = packageMapper.updateByExampleSelective(appletPackage, appletPackageExample);
            if (i==0){
                throw new RuntimeException("编辑套餐失败: " + req.toString());
            }
        }
        return appletPackage.getPackageId();
    }

    /**
     * 编辑套餐
     * @param req
     * @return
     */
    @Transactional
    public boolean insertPackage(EditPackageReqVo req) {

        int i = 0;

        String packageId;
        String packageIdIndexStr;
        Integer packageIdIndex = Integer.parseInt(redisUtils.get(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX));
        if (packageIdIndex!=null){
            packageIdIndex++;
            boolean a = redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX,packageIdIndex.toString());
            if (!a){
                logger.info("后台套餐ID标签自增失败: "+packageIdIndex);
                return false;
            }
            packageIdIndexStr = String.format("%06d", packageIdIndex);
        } else {
            redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX,"1");
            packageIdIndexStr = String.format("%04d", 1);
        }
        String day = redisUtils.get(RedisConstants.DAY);
        if (day==null){
            day = DateUtils.formatDayString(new Date());
        }
        packageId = CommonConstants.GenerateID_PACKAGE+day+packageIdIndexStr;

//        String packageId = NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_PACKAGE);
        AppletPackage appletPackage = new AppletPackage();
        BeanUtils.copyProperties(req, appletPackage);
        appletPackage.setPackageId(packageId);
        appletPackage.setPackageStatus(CommonConstants.INIT);
        appletPackage.setDelFlag(CommonConstants.INIT);
        appletPackage.setCreateDate(new Date());
        appletPackage.setUpdateDate(new Date());
        appletPackage.setPackageType(PACKAGE_TYPE_INIT);
        i = packageMapper.insertSelective(appletPackage);
        if (i==0){
            logger.info("添加套餐失败: " + req.getPackageId());
            throw new RuntimeException("添加套餐失败: " + req.toString());
        }

        //添加科室过滤器
        AppletPackagePurposeFilter purposeFilter = new AppletPackagePurposeFilter();
        if (StringUtils.isNotBlank(req.getPackageCatalogId()))
            purposeFilter.setCatalogId(req.getPackageCatalogId());
        if (StringUtils.isNotBlank(req.getPackagePurposeId()))
            purposeFilter.setPurposeId(req.getPackagePurposeId());
        purposeFilter.setPackageId(req.getPackageId());
        purposeFilter.setCreateDate(new Date());
        purposeFilter.setUpdateDate(new Date());
        purposeFilter.setDelFlag(CommonConstants.INIT);
        purposeFilterMapper.insertSelective(purposeFilter);

        //添加子套餐
//        if (req.getSubPackageStrList()!=null&&req.getSubPackageStrList().size()!=0){
//
////            for (SubPackageVo subPackageVo:req.getSubPackageVoList()) {
////                AppletPackageSub insertSub = new AppletPackageSub();
////                insertSub.setCreateDate(new Date());
////                insertSub.setUpdateDate(new Date());
////                insertSub.setDelFlag(CommonConstants.INIT);
////                insertSub.setPackageId(req.getPackageId());
////                insertSub.setSubPackageName(subPackageVo.getSubPackageName());
////
////                i=subMapper.insertSelective(insertSub);
////                if (i==0){
////                    logger.info("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
////                    throw new RuntimeException("编辑套餐失败: " + req.getPackageId()+" 添加子套餐项目失败");
////                }
////            }
//
//            for (String subPackageVo:req.getSubPackageStrList()) {
//                AppletPackageSub insertSub = new AppletPackageSub();
//                insertSub.setCreateDate(new Date());
//                insertSub.setUpdateDate(new Date());
//                insertSub.setDelFlag(CommonConstants.INIT);
//                insertSub.setPackageId(req.getPackageId());
//                insertSub.setSubPackageName(subPackageVo);
//
//                i=subMapper.insertSelective(insertSub);
//                if (i==0){
//                    logger.info("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
//                    throw new RuntimeException("编辑套餐失败: " + req.getPackageId()+" 添加子套餐项目失败");
//                }
//            }
//        }

        for (String subPackageVo:req.getSubPackageStrList()) {
            AppletPackageSub insertSub = new AppletPackageSub();
            insertSub.setCreateDate(new Date());
            insertSub.setUpdateDate(new Date());
            insertSub.setDelFlag(CommonConstants.INIT);
            insertSub.setPackageId(packageId);
            insertSub.setSubPackageName(subPackageVo);

            i=subMapper.insertSelective(insertSub);
            if (i==0){
                logger.info("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
                throw new RuntimeException("编辑套餐失败: " + req.getPackageId()+" 添加子套餐项目失败");
            }
        }

        //添加分类标签过滤器
        if (req.getTagVoList()!=null&&req.getTagVoList().size()>0){
            for (TagVo tagVo:req.getTagVoList()) {
                if (StringUtils.isBlank(tagVo.getTagId())){
                    continue;
                }
                AppletPackageTagFilter tagFilter = new AppletPackageTagFilter();
                tagFilter.setCreateDate(new Date());
                tagFilter.setDelFlag(CommonConstants.INIT);
                tagFilter.setPackageId(packageId);
                tagFilter.setTagId(tagVo.getTagId());
                tagFilterMapper.insertSelective(tagFilter);
            }
        }
        return true;
    }

    /**
     * 编辑套餐
     * @param req
     * @return
     */
    @Transactional
    public boolean editPackageNew(EditPackageReqVo req) {

        int i = 0;

        if (StringUtils.isBlank(req.getPackageId())){
            throw new RuntimeException("套餐编辑失败,套餐编号不能为空");
        }
        AppletPackage appletPackage = new AppletPackage();
        BeanUtils.copyProperties(req, appletPackage);
        if (req.getPackageStatus() == null) {
            req.setPackageStatus(PackageConstants.PACKAGE_STATUS_FINISH);
        }
        appletPackage.setUpdateDate(new Date());
        AppletPackageExample appletPackageExample = new AppletPackageExample();
        AppletPackageExample.Criteria packageExampleCriteria = appletPackageExample.createCriteria();
        packageExampleCriteria.andPackageIdEqualTo(req.getPackageId());
        i = packageMapper.updateByExampleSelective(appletPackage, appletPackageExample);
        if (i==0){
            logger.info("编辑套餐失败: " + req.getPackageId());
            throw new RuntimeException("编辑套餐失败: " + req.toString());
        }

        //编辑过滤器
        AppletPackagePurposeFilter purposeFilter = new AppletPackagePurposeFilter();
        purposeFilter.setUpdateDate(new Date());
        purposeFilter.setDelFlag(CommonConstants.ENABLE);

        AppletPackagePurposeFilterExample purposeFilterExample = new AppletPackagePurposeFilterExample();
        AppletPackagePurposeFilterExample.Criteria criteria = purposeFilterExample.createCriteria();
        criteria.andPackageIdEqualTo(req.getPackageId());
        purposeFilterMapper.updateByExampleSelective(purposeFilter,purposeFilterExample);

        purposeFilter = new AppletPackagePurposeFilter();
        purposeFilter.setCatalogId(req.getPackageCatalogId());
        purposeFilter.setPurposeId(req.getPackagePurposeId());
        purposeFilter.setPackageId(req.getPackageId());
        purposeFilter.setCreateDate(new Date());
        purposeFilter.setUpdateDate(new Date());
        purposeFilter.setDelFlag(CommonConstants.INIT);

        purposeFilterMapper.insertSelective(purposeFilter);

        //删除编辑前的细项
        AppletPackageSubExample subExample = new AppletPackageSubExample();
        AppletPackageSubExample.Criteria subExampleCriteria = subExample.createCriteria();
        subExampleCriteria.andPackageIdEqualTo(req.getPackageId());
        subExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);

        AppletPackageSub updateSub = new AppletPackageSub();
        updateSub.setUpdateDate(new Date());
        updateSub.setDelFlag(CommonConstants.ENABLE);
        subMapper.updateByExampleSelective(updateSub,subExample);
        //如果没有子项就会报错，所以不需要加判断
//        if (i==0){
//            logger.info("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
//            throw new RuntimeException("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
//        }

        //添加新的细项
        for (String subPackageStr:req.getSubPackageStrList()) {
            AppletPackageSub insertSub = new AppletPackageSub();
            insertSub.setCreateDate(new Date());
            insertSub.setUpdateDate(new Date());
            insertSub.setDelFlag(CommonConstants.INIT);
            insertSub.setPackageId(req.getPackageId());
            insertSub.setSubPackageName(subPackageStr);

            i=subMapper.insertSelective(insertSub);
            if (i==0){
                logger.info("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
                throw new RuntimeException("编辑套餐失败: " + req.getPackageId()+" 添加子套餐项目失败");
            }
        }

        //编辑子套餐
//        if (req.getSubPackageVoList()!=null&&req.getSubPackageVoList().size()!=0){
//            AppletPackageSubExample subExample = new AppletPackageSubExample();
//            AppletPackageSubExample.Criteria subExampleCriteria = subExample.createCriteria();
//            subExampleCriteria.andPackageIdEqualTo(req.getPackageId());
//
//            AppletPackageSub updateSub = new AppletPackageSub();
//            updateSub.setPackageId(req.getPackageId());
//            updateSub.setUpdateDate(new Date());
//            updateSub.setDelFlag(CommonConstants.ENABLE);
//            i=subMapper.updateByExampleSelective(updateSub,subExample);
//            if (i==0){
//                logger.info("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
//                throw new RuntimeException("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
//            }
//
//            for (String subPackageStr:req.getSubPackageStrList()) {
//                AppletPackageSub insertSub = new AppletPackageSub();
//                insertSub.setCreateDate(new Date());
//                insertSub.setUpdateDate(new Date());
//                insertSub.setDelFlag(CommonConstants.INIT);
//                insertSub.setPackageId(req.getPackageId());
//                insertSub.setSubPackageName(subPackageStr);
//
//                i=subMapper.insertSelective(insertSub);
//                if (i==0){
//                    logger.info("编辑套餐失败: " + req.getPackageId()+" 删除子套餐项目失败");
//                    throw new RuntimeException("编辑套餐失败: " + req.getPackageId()+" 添加子套餐项目失败");
//                }
//            }
//        }

        //编辑分类标签
        if (req.getTagVoList()!=null&&req.getTagVoList().size()>0){


            AppletPackageTagFilter deleteObj = new AppletPackageTagFilter();
            deleteObj.setUpdateDate(new Date());
            deleteObj.setDelFlag(CommonConstants.ENABLE);

            AppletPackageTagFilterExample tagFilterExample = new AppletPackageTagFilterExample();
            AppletPackageTagFilterExample.Criteria tagFilterExampleCriteria = tagFilterExample.createCriteria();
            tagFilterExampleCriteria.andPackageIdEqualTo(req.getPackageId());
            tagFilterMapper.updateByExampleSelective(deleteObj,tagFilterExample);

            for (TagVo tagVo:req.getTagVoList()) {
                if (StringUtils.isBlank(tagVo.getTagId())){
                    continue;
                }
                AppletPackageTagFilter tagFilter = new AppletPackageTagFilter();
                tagFilter.setCreateDate(new Date());
                tagFilter.setDelFlag(CommonConstants.INIT);
                tagFilter.setPackageId(req.getPackageId());
                tagFilter.setTagId(tagVo.getTagId());
                tagFilterMapper.insertSelective(tagFilter);
            }
        }

        return true;
    }

    @Transactional
    public boolean stopPackage(List<String> packageIds,Integer status) {
        AppletPackage appletPackage = new AppletPackage();
        appletPackage.setPackageStatus(status);
        appletPackage.setUpdateDate(new Date());
        AppletPackageExample appletPackageExample = new AppletPackageExample();
        AppletPackageExample.Criteria packageExampleCriteria = appletPackageExample.createCriteria();
        packageExampleCriteria.andPackageIdIn(packageIds);
        int  i = packageMapper.updateByExampleSelective(appletPackage, appletPackageExample);
        if (i==0){
            throw new RuntimeException("停用套餐失败: " + packageIds);
        }
        return true;
    }

    public List<CatalogListVo> queryCatalogList(String sourceId){
        AppletPackageCatalogExample example = new AppletPackageCatalogExample();
        AppletPackageCatalogExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(sourceId)) {
            criteria.andPackageSourceIdEqualTo(sourceId);
        }
        List<AppletPackageCatalog> catalogList = catalogMapper.selectByExample(example);
        List<CatalogListVo> result = new ArrayList<>();
        for (AppletPackageCatalog catalog:catalogList) {
            CatalogListVo listVo = new CatalogListVo();
            BeanUtils.copyProperties(catalog,listVo);
            result.add(listVo);
        }
        return result;
    }

    public List<PurposeListVo> queryPurposeList(String catalogId){
        AppletPackagePurposeExample example = new AppletPackagePurposeExample();
        AppletPackagePurposeExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(catalogId)) {
            criteria.andPackageCatalogIdEqualTo(catalogId);
        }
        List<AppletPackagePurpose> purposeList = purposeMapper.selectByExample(example);
        List<PurposeListVo> result = new ArrayList<>();
        for (AppletPackagePurpose purpose:purposeList) {
            PurposeListVo listVo = new PurposeListVo();
            BeanUtils.copyProperties(purpose,listVo);
            result.add(listVo);
        }
        return result;
    }

    @Transactional
    public boolean editCatalog(AppletPackageCatalog editObj){

        int i = 0;

        if (StringUtils.isBlank(editObj.getPackageCatalogId())) {
            editObj.setCreateDate(new Date());
            editObj.setUpdateDate(new Date());
            editObj.setDelFlag(CommonConstants.INIT);
            i=catalogMapper.insertSelective(editObj);
        } else {
            AppletPackageCatalogExample example = new AppletPackageCatalogExample();
            AppletPackageCatalogExample.Criteria criteria = example.createCriteria();
            criteria.andPackageCatalogIdEqualTo(editObj.getPackageCatalogId());
            editObj.setUpdateDate(new Date());
            i=catalogMapper.updateByExampleSelective(editObj,example);
        }
        if (i>0){
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public boolean editPurpose(AppletPackagePurpose editObj){
        int i = 0;

        if (StringUtils.isBlank(editObj.getPackagePurposeId())) {
            editObj.setCreateDate(new Date());
            editObj.setUpdateDate(new Date());
            editObj.setDelFlag(CommonConstants.INIT);
            i=purposeMapper.insertSelective(editObj);
        } else {
            AppletPackagePurposeExample example = new AppletPackagePurposeExample();
            AppletPackagePurposeExample.Criteria criteria = example.createCriteria();
            criteria.andPackagePurposeIdEqualTo(editObj.getPackagePurposeId());
            editObj.setUpdateDate(new Date());
            i=purposeMapper.updateByExampleSelective(editObj,example);
        }
        if (i>0){
            return true;
        } else {
            return false;
        }
    }

    public List<TagVo> queryTagList(String sourceId){
        List<TagVo> tagVoList = new ArrayList<>();
        if (StringUtils.isNotBlank(sourceId)){
            List<AppletPackageTag> tagList = adminTagService.getPackageTagListBySource(sourceId);
            for (AppletPackageTag tag:tagList) {
                TagVo tagVo = new TagVo();
                tagVo.setTagId(tag.getTagId());
                tagVo.setTagName(tag.getTagName());
                tagVo.setSourceId(tag.getSourceId());
                tagVoList.add(tagVo);
            }
        }
        return tagVoList;
    }

    @Transactional
    public boolean insertByObj(AppletPackage appletPackage){
        int i = packageMapper.insertSelective(appletPackage);
        if (i==0){
            return false;
        }
        return true;
    }

    @Transactional
    public boolean insertSub(List<AppletPackageSub> subList){
        int i = 0;
        for (AppletPackageSub sub:subList) {
            i = subMapper.insertSelective(sub);
            if (i==0){
                return false;
            }
        }
        return true;
    }
}
