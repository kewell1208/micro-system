package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletservice.dao.AppletGoodMapper;
import com.tclab.weixinappletservice.dao.AppletInterpretGoodMapper;
import com.tclab.weixinappletservice.dao.AppletInterpretMapper;
import com.tclab.weixinappletservice.dao.AppletOrderParticipantMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.GoodQueryBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.InterpretSingleVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.InterpretUpdateReqVo;
import com.tclab.weixinappletservice.pojo.AppletGood;
import com.tclab.weixinappletservice.pojo.AppletGoodExample;
import com.tclab.weixinappletservice.pojo.AppletInterpret;
import com.tclab.weixinappletservice.pojo.AppletInterpretExample;
import com.tclab.weixinappletservice.pojo.AppletInterpretExample.Criteria;
import com.tclab.weixinappletservice.pojo.AppletInterpretGood;
import com.tclab.weixinappletservice.pojo.AppletInterpretGoodExample;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipant;
import com.tclab.weixinappletservice.pojo.AppletOrderParticipantExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package：com.tclab.weixinappletservice.service.clientService
 * @Class：InterpretService
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/12 10:48 AM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Service
public class InterpretService {

  private static final Logger logger = LoggerFactory.getLogger(InterpretService.class);

  @Autowired
  private AppletInterpretMapper appletInterpretMapper;
  @Autowired
  private AppletGoodMapper appletGoodMapper;
  @Autowired
  private AppletOrderParticipantMapper appletOrderParticipantMapper;
  @Autowired
  private AppletInterpretGoodMapper appletInterpretGoodMapper;

  public InterpretSingleVo getInterpretSingle(String interpretId) {
    InterpretSingleVo vo = new InterpretSingleVo();
    AppletInterpretExample example = new AppletInterpretExample();
    Criteria criteria = example.createCriteria();
    criteria.andInterpretIdEqualTo(interpretId);
    List<AppletInterpret> appletInterprets = appletInterpretMapper.selectByExample(example);
    if (appletInterprets != null && appletInterprets.size() > 0) {
      AppletInterpret appletInterpret = appletInterprets.get(0);
      //报告解读患者上传信息
      vo.setInterpretImg(appletInterpret.getInterpretImg());
      vo.setInterpretContent(appletInterpret.getInterpretContent());
      vo.setParticipantImg(appletInterpret.getParticipantImg());
      vo.setParticipantDiagnose(appletInterpret.getParticipantDiagnose());
      vo.setParticipantDescribe(appletInterpret.getParticipantDescribe());
      vo.setInterpretDate(DateUtils.formatSdfForMinDate(appletInterpret.getInterpretDate()) );
      //患者信息
      AppletOrderParticipantExample participantExample = new AppletOrderParticipantExample();
      AppletOrderParticipantExample.Criteria participantCriteria = participantExample.createCriteria();
      participantCriteria.andParticipantIdEqualTo(appletInterpret.getParticipantId());
      List<AppletOrderParticipant> participantList = appletOrderParticipantMapper.selectByExample(participantExample);
      if (participantList != null && participantList.size() > 0) {
        vo.setParticipant(participantList.get(0));
      } else {
        throw new RuntimeException("未找到患者信息");
      }
      //商品报告信息
      AppletInterpretGoodExample goodExample = new AppletInterpretGoodExample();
      AppletInterpretGoodExample.Criteria goodExampleCriteria = goodExample.createCriteria();
      goodExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      goodExampleCriteria.andInterpretIdEqualTo(appletInterpret.getInterpretId());
      List<AppletInterpretGood> appletInterpretGoodList = appletInterpretGoodMapper.selectByExample(goodExample);
      if (appletInterpretGoodList != null && appletInterpretGoodList.size() > 0) {
        List<String> goodNoList = new ArrayList<>();
        Map<String, AppletInterpretGood> goodMap = new HashMap<>();
        for (AppletInterpretGood interpretGood : appletInterpretGoodList) {
          goodNoList.add(interpretGood.getGoodNo());
          goodMap.put(interpretGood.getGoodNo(), interpretGood);
        }
        AppletGoodExample appletGoodExample = new AppletGoodExample();
        AppletGoodExample.Criteria exampleCriteria = appletGoodExample.createCriteria();
        exampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        exampleCriteria.andGoodNoIn(goodNoList);
        List<AppletGood> appletGoodList = appletGoodMapper.selectByExample(appletGoodExample);
        List<GoodQueryBaseVo> goodQueryBaseVoList = new ArrayList<>();
        if (appletGoodList != null && appletGoodList.size() > 0) {
          for (AppletGood appletGood : appletGoodList) {
            GoodQueryBaseVo baseVo = new GoodQueryBaseVo();
            BeanUtils.copyProperties(appletGood, baseVo);
            baseVo.setReportDate(DateUtils.formatSdfForMinDate(appletGood.getReportDate()));
            baseVo.setCreateDate(DateUtils.formatSdfForMinDate(appletGood.getCreateDate()));
            baseVo.setUpdateDate(DateUtils.formatSdfForMinDate(appletGood.getUpdateDate()));
            baseVo.setStatus(goodMap.get(appletGood.getGoodNo()).getStatus());
            goodQueryBaseVoList.add(baseVo);
          }
          vo.setGoodList(goodQueryBaseVoList);
        }
      }
      return vo;
    }
    return null;
  }

  public String saveInterpret(InterpretUpdateReqVo vo) {
    if(null==vo.getInterpretId() || "".equals( vo.getInterpretId() )){
      return "InterpretId不能为空";
    }
    AppletInterpretExample example = new AppletInterpretExample();
    Criteria criteria = example.createCriteria();
    criteria.andInterpretIdEqualTo(vo.getInterpretId());
    AppletInterpret appletInterpret = new AppletInterpret();
    appletInterpret.setInterpretImg(vo.getInterpretImg());
    appletInterpret.setInterpretContent(vo.getInterpretContent());
    appletInterpret.setUpdateDate(new Date());
    appletInterpret.setInterpretStatus(1);
    appletInterpret.setInterpretDate(new Date());
    int i = appletInterpretMapper.updateByExampleSelective(appletInterpret, example);

    if (i == 0) {
      return "保存失败";
    }
    return "0";
  }
}
