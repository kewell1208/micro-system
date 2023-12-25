package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletservice.dao.AppletPackageTagFilterMapper;
import com.tclab.weixinappletservice.dao.AppletPackageTagMapper;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.TagVo;
import com.tclab.weixinappletservice.pojo.AppletPackageTag;
import com.tclab.weixinappletservice.pojo.AppletPackageTagExample;
import com.tclab.weixinappletservice.pojo.AppletPackageTagFilter;
import com.tclab.weixinappletservice.pojo.AppletPackageTagFilterExample;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AdminTagService {

    private static final Logger logger = LoggerFactory.getLogger(AdminTagService.class);

    @Autowired
    private AppletPackageTagMapper tagMapper;
    @Autowired
    private AppletPackageTagFilterMapper tagFilterMapper;

    public List<AppletPackageTag> getPackageTagListBySource(String sourceId){
        logger.info("查询"+sourceId+"的分类标签");
        AppletPackageTagExample tagExample = new AppletPackageTagExample();
        AppletPackageTagExample.Criteria tagExampleCriteria = tagExample.createCriteria();
        tagExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(sourceId)){
            tagExampleCriteria.andSourceIdEqualTo(sourceId);
        }
        List<AppletPackageTag> tagList = tagMapper.selectByExample(tagExample);
        logger.info("查询"+sourceId+"的分类标签的结果长度"+tagList.size());
        return tagList;
    }

    public List<AppletPackageTagFilter> getPackageTagFilterListByPackageId(String packageId){
        logger.info("查询套餐"+packageId+"的分类标签");
        AppletPackageTagFilterExample tagFilterExample = new AppletPackageTagFilterExample();
        AppletPackageTagFilterExample.Criteria tagFilterExampleCriteria = tagFilterExample.createCriteria();
        tagFilterExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(packageId)){
            tagFilterExampleCriteria.andPackageIdEqualTo(packageId);
        }
        List<AppletPackageTagFilter> tagFilterList = tagFilterMapper.selectByExample(tagFilterExample);
        logger.info("查询套餐"+packageId+"的分类标签的结果长度"+tagFilterList.size());
        return tagFilterList;
    }

    public AppletPackageTag getPackageTagById(String tagId){
        logger.info("查询"+tagId+"的分类标签");
        AppletPackageTagExample tagExample = new AppletPackageTagExample();
        AppletPackageTagExample.Criteria tagExampleCriteria = tagExample.createCriteria();
        tagExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(tagId)){
            tagExampleCriteria.andTagIdEqualTo(tagId);
        }
        List<AppletPackageTag> tagList = tagMapper.selectByExample(tagExample);
        logger.info("查询"+tagId+"的分类标签的结果长度"+tagList.size());
        if (tagList.size()==0){
            return null;
        } else {
            return tagList.get(0);
        }
    }

    @Transactional
    public boolean editTag(TagVo tagVo){
        int i = 0;
        if (StringUtils.isBlank(tagVo.getTagId())) {
            AppletPackageTag editObj = new AppletPackageTag();
            editObj.setCreateDate(new Date());
            editObj.setUpdateDate(new Date());
            editObj.setDelFlag(CommonConstants.INIT);
            if (StringUtils.isNotBlank(tagVo.getRemark()))
                editObj.setRemark(tagVo.getRemark());
            if (StringUtils.isNotBlank(tagVo.getSourceId()))
                editObj.setSourceId(tagVo.getSourceId());
            if (StringUtils.isNotBlank(tagVo.getTagName()))
                editObj.setTagName(tagVo.getTagName());
            editObj.setTagId(NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_TAG));
            i=tagMapper.insertSelective(editObj);
        } else {
            AppletPackageTag editObj = new AppletPackageTag();
            BeanUtils.copyProperties(tagVo,editObj);
            editObj.setUpdateDate(new Date());
            AppletPackageTagExample tagExample = new AppletPackageTagExample();
            AppletPackageTagExample.Criteria tagExampleCriteria = tagExample.createCriteria();
            tagExampleCriteria.andTagIdEqualTo(tagVo.getTagId());
            i=tagMapper.updateByExampleSelective(editObj,tagExample);
        }
        if (i>0){
            return true;
        } else {
            return false;
        }
    }
}
