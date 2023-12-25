package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletPackageSourceMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.SourceCatalogPurposeListVo;
import com.tclab.weixinappletservice.pojo.AppletPackageSource;
import com.tclab.weixinappletservice.pojo.AppletPackageSourceExample;
import com.tclab.weixinappletservice.service.clientService.CatalogService;
import com.tclab.weixinappletservice.service.clientService.PurposeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SourceService {

    @Autowired
    private AppletPackageSourceMapper sourceMapper;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private PurposeService purposeService;

    public List<AppletPackageSource> getAllSource(){
        AppletPackageSourceExample example = new AppletPackageSourceExample();
        AppletPackageSourceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        return sourceMapper.selectByExample(example);
    }

    public List<SourceCatalogPurposeListVo> getAllSource2Purpose(){

        List<SourceCatalogPurposeListVo> result = new ArrayList<>();

        List<AppletPackageSource> sourceList = getAllSource();
        for (AppletPackageSource source:sourceList) {
            SourceCatalogPurposeListVo sourceCatalogPurposeListVo = new SourceCatalogPurposeListVo();
            sourceCatalogPurposeListVo.setPackageSourceId(source.getPackageSourceId());
            sourceCatalogPurposeListVo.setPackageSourceName(source.getPackageSourceName());
            sourceCatalogPurposeListVo.setCatalogPurposeListVoList(catalogService.getAllCatalogPurpose(source.getPackageSourceId()));
            result.add(sourceCatalogPurposeListVo);
        }

        return result;
    }

    public AppletPackageSource getSourceById(String sourceId){
        if (StringUtils.isBlank(sourceId)){
            return null;
        }
        AppletPackageSourceExample example = new AppletPackageSourceExample();
        AppletPackageSourceExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andPackageSourceIdEqualTo(sourceId);
        List<AppletPackageSource> sourceList = sourceMapper.selectByExample(example);
        if (sourceList.size()!=0){
            return sourceList.get(0);
        } else {
            return null;
        }
    }
}
