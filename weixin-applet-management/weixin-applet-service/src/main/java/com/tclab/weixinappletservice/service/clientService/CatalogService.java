package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletPackageCatalogMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.CatalogListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.CatalogPurposeListVo;
import com.tclab.weixinappletservice.pojo.AppletPackageCatalog;
import com.tclab.weixinappletservice.pojo.AppletPackageCatalogExample;
import com.tclab.weixinappletservice.pojo.AppletPackageSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatalogService {

    @Autowired
    private AppletPackageCatalogMapper catalogMapper;
    @Autowired
    private SourceService sourceService;
    @Autowired
    private PurposeService purposeService;

    /**
     * 获取所有的分类目录
     * @return
     */
    public List<AppletPackageCatalog> getAllCatalog(){
        AppletPackageCatalogExample example = new AppletPackageCatalogExample();
        AppletPackageCatalogExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        return catalogMapper.selectByExample(example);
    }

    /**
     * 获取套餐来源机构的目录信息以及下辖的所有检验目的 例如 目录对应内科 内科的检验目的有心血管内科和肾内科
     * @param packageSourceId   套餐来源机构 例如树兰浙一同创
     * @return
     */
    public List<CatalogPurposeListVo> getAllCatalogPurpose(String packageSourceId){

        List<CatalogPurposeListVo> catalogListVoList = new ArrayList<>();

        AppletPackageCatalogExample example = new AppletPackageCatalogExample();
        AppletPackageCatalogExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andPackageSourceIdEqualTo(packageSourceId);

        List<AppletPackageCatalog> catalogList = catalogMapper.selectByExample(example);
        for (AppletPackageCatalog catalog:catalogList) {
            CatalogPurposeListVo catalogPurposeListVo = new CatalogPurposeListVo();
            catalogPurposeListVo.setPackageCatalogId(catalog.getPackageCatalogId());
            catalogPurposeListVo.setPackageCatalogName(catalog.getPackageCatalogName());
            catalogPurposeListVo.setPurposeListVoList(purposeService.getPurposeListVoList(catalog.getPackageCatalogId()));
            catalogListVoList.add(catalogPurposeListVo);
        }

        return catalogListVoList;
    }

    /**
     * 获取所有分类目录转换对象
     * @return
     */
    public List<CatalogListVo> getAllCatalogNew(){

        List<CatalogListVo> catalogListVoList = new ArrayList<>();

        List<AppletPackageSource> sourceList = sourceService.getAllSource();

        AppletPackageCatalogExample example = new AppletPackageCatalogExample();
        AppletPackageCatalogExample.Criteria criteria = example.createCriteria();

        for (AppletPackageSource source:sourceList) {

            CatalogListVo catalogListVo = new CatalogListVo();
            catalogListVo.setPackageSourceName(source.getPackageSourceName());

            criteria.andDelFlagEqualTo(CommonConstants.INIT);
            criteria.andPackageSourceIdEqualTo(source.getPackageSourceId());
            List<AppletPackageCatalog> catalogList = catalogMapper.selectByExample(example);

            catalogListVo.setCatalogList(catalogList);
            catalogListVoList.add(catalogListVo);
            example.clear();
            criteria = example.createCriteria();
        }

        return catalogListVoList;
    }

}
