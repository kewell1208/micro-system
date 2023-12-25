package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletPackagePurposeMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.AlphabetPurposeVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PurposeListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.PurposeVo;
import com.tclab.weixinappletservice.pojo.AppletPackagePurpose;
import com.tclab.weixinappletservice.pojo.AppletPackagePurposeExample;
import com.tclab.weixinappletcommon.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PurposeService {

    @Autowired
    private AppletPackagePurposeMapper purposeMapper;

    public List<AppletPackagePurpose> getPurpose(String purposeId,String catalogId){
        AppletPackagePurposeExample example = new AppletPackagePurposeExample();
        AppletPackagePurposeExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(purposeId)){
            criteria.andPackagePurposeIdEqualTo(purposeId);
        }
        if (org.apache.commons.lang3.StringUtils.isNotBlank(catalogId)){
            criteria.andPackageCatalogIdEqualTo(catalogId);
        }
        List<AppletPackagePurpose> result = purposeMapper.selectByExample(example);
        return result;
    }

    public List<AlphabetPurposeVo> groupByPurpose(List<AppletPackagePurpose> purposes){
        List<String> alphabets = new ArrayList<>();
        List<AlphabetPurposeVo> alphabetPurposeVos = new ArrayList<>();
        boolean check = false;
        a:for (int i=0;i<purposes.size();i++) {
            String alphabet = StringUtils.getFirstBigAlphabet(purposes.get(i).getPackagePurposeName());
            b:for (String str:alphabets) {
                if (str.equals(alphabet)){
                    check = true;
                    break b;
                }
            }
            if (check){
                for (AlphabetPurposeVo vo:alphabetPurposeVos) {
                    if (vo.getAlphabet().equals(alphabet)){
                        PurposeVo purposeVo = new PurposeVo();
                        BeanUtils.copyProperties(purposes.get(i),purposeVo);
                        vo.getPurposeVos().add(purposeVo);
                    }
                }
            } else {
                alphabets.add(alphabet);
                AlphabetPurposeVo alphabetPurposeVo = new AlphabetPurposeVo();
                alphabetPurposeVo.setAlphabet(alphabet);
                PurposeVo purposeVo = new PurposeVo();
                BeanUtils.copyProperties(purposes.get(i),purposeVo);
                alphabetPurposeVo.getPurposeVos().add(purposeVo);
                alphabetPurposeVos.add(alphabetPurposeVo);
            }
        }
        return alphabetPurposeVos;
    }

    public List<PurposeListVo> getPurposeListVoList(String catalogId){

        List<PurposeListVo> result = new ArrayList<>();

        AppletPackagePurposeExample example = new AppletPackagePurposeExample();
        AppletPackagePurposeExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (org.apache.commons.lang3.StringUtils.isNotBlank(catalogId)){
            criteria.andPackageCatalogIdEqualTo(catalogId);
        }
        List<AppletPackagePurpose> queryResult = purposeMapper.selectByExample(example);
        for (AppletPackagePurpose purpose:queryResult) {
            PurposeListVo purposeListVo = new PurposeListVo();
            purposeListVo.setPackagePurposeId(purpose.getPackagePurposeId());
            purposeListVo.setPackagePurposeName(purpose.getPackagePurposeName());
            result.add(purposeListVo);
        }

        return result;
    }

}
