package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletPackageTagFilterMapper;
import com.tclab.weixinappletservice.dao.AppletPackageTagMapper;
import com.tclab.weixinappletservice.pojo.AppletPackageTag;
import com.tclab.weixinappletservice.pojo.AppletPackageTagExample;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    private static final Logger logger = LoggerFactory.getLogger(TagService.class);

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

}
