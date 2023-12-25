package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.DoctorConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.MD5Utils;
import com.tclab.weixinappletservice.dao.AppletDoctorMapper;
import com.tclab.weixinappletservice.dao.AppletImRelationMapper;
import com.tclab.weixinappletservice.model.query.QueryDoctorParam;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.DoctorBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.DoctorFeeReqVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.reqVo.LoginReqVo;
import com.tclab.weixinappletservice.pojo.AppletDoctor;
import com.tclab.weixinappletservice.pojo.AppletDoctorExample;
import com.tclab.weixinappletservice.pojo.AppletDoctorExample.Criteria;
import com.tclab.weixinappletservice.pojo.AppletImRelationExample;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package：com.tclab.weixinappletservice.service.clientService
 * @Class：DoctorService
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/11 4:03 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Service
public class DoctorService {

  private static final Logger logger = LoggerFactory.getLogger(DoctorService.class);

  @Autowired
  private AppletDoctorMapper appletDoctorMapper;
  @Autowired
  private AppletImRelationMapper appletImRelationMapper;

  public AppletDoctor getDoctorById(Integer id) {
    return appletDoctorMapper.selectByPrimaryKey(id);
  }

  public AppletDoctor getDoctorByDoctorId(String doctorId) {

    if (StringUtils.isBlank(doctorId)){
      return null;
    }

    AppletDoctorExample doctorExample = new AppletDoctorExample();
    AppletDoctorExample.Criteria criteria = doctorExample.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);

    logger.info("医生ID" + doctorId);

    if (StringUtils.isNotBlank(doctorId)) {
      criteria.andDoctorIdEqualTo(doctorId);
    }
    List<AppletDoctor> doctorList = appletDoctorMapper.selectByExample(doctorExample);
    if (doctorList.size() != 0) {
      return doctorList.get(0);
    } else {
      return null;
    }
  }

  public List<AppletDoctor> getDoctorByParam(String doctorId, String hospitalId, String doctorDepartmentId, String queryParam,Integer doctorAuthority) {
    QueryDoctorParam param = new QueryDoctorParam();
    param.setDepartmentId(doctorDepartmentId);
    param.setDoctorId(doctorId);
    param.setHospitalId(hospitalId);
    param.setQueryParam(queryParam);
    if (doctorAuthority!=null) {
      List<Integer> doctorAuthorityList = new ArrayList<>();
      if (doctorAuthority.equals(DoctorConstants.DOCTOR_AUTHORITY_BOTH)) {
        doctorAuthorityList.add(DoctorConstants.DOCTOR_AUTHORITY_BOTH);
      } else if (doctorAuthority.equals(DoctorConstants.DOCTOR_AUTHORITY_INQUIRY)) {
        doctorAuthorityList.add(DoctorConstants.DOCTOR_AUTHORITY_BOTH);
        doctorAuthorityList.add(DoctorConstants.DOCTOR_AUTHORITY_INQUIRY);
      } else if (doctorAuthority.equals(DoctorConstants.DOCTOR_AUTHORITY_INTERRET)) {
        doctorAuthorityList.add(DoctorConstants.DOCTOR_AUTHORITY_BOTH);
        doctorAuthorityList.add(DoctorConstants.DOCTOR_AUTHORITY_INTERRET);
      }
      param.setDoctorAuthorityList(doctorAuthorityList);
    }
    return appletDoctorMapper.selectDoctorByParam(param);
  }

  public AppletDoctor setDoctorFee(DoctorFeeReqVo vo) {
    AppletDoctor appletDoctor = new AppletDoctor();
    appletDoctor.setDoctorInterpretPrice(new BigDecimal(vo.getInterpretPrice()));
    appletDoctor.setDoctorInquiryPrice(new BigDecimal(vo.getInquiryPrice()));
    AppletDoctorExample example = new AppletDoctorExample();
    Criteria criteria = example.createCriteria();
    criteria.andDoctorPhoneEqualTo(vo.getDoctorPhone());
    int i = appletDoctorMapper.updateByExampleSelective(appletDoctor, example);
    if (i == 0) {
      List<AppletDoctor> appletDoctorList = appletDoctorMapper.selectByExample(example);
      if (appletDoctorList != null && appletDoctorList.size() > 0) {
        return appletDoctorList.get(0);
      }
    }
    return null;
  }

  public DoctorBaseVo checkDoctorLogin(LoginReqVo vo) {
    AppletDoctorExample example = new AppletDoctorExample();
    Criteria criteria = example.createCriteria();
    criteria.andDoctorPhoneEqualTo(vo.getUsername());
    if(StringUtils.isNotBlank(vo.getPassword())){
      criteria.andDoctorPasswordEqualTo(vo.getPassword());
    }
    List<AppletDoctor> list = appletDoctorMapper.selectByExample(example);
    if (list != null && list.size() > 0) {
      AppletDoctor appletDoctor = list.get(0);
      appletDoctor.setDoctorPassword("");
      //统计关注人数
      AppletImRelationExample relationExample = new AppletImRelationExample();
      AppletImRelationExample.Criteria relationExampleCriteria = relationExample.createCriteria();
      relationExampleCriteria.andDoctorIdEqualTo(appletDoctor.getDoctorId());
      relationExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
      long attentionNum = appletImRelationMapper.countByExample(relationExample);
      DoctorBaseVo doctorBaseVo = new DoctorBaseVo();
      BeanUtils.copyProperties(appletDoctor, doctorBaseVo);
      doctorBaseVo.setCreateDate(DateUtils.formatSdfForMinDate(appletDoctor.getCreateDate()));
      doctorBaseVo.setUpdateDate(DateUtils.formatSdfForMinDate(appletDoctor.getUpdateDate()));
      doctorBaseVo.setAttentionNum(attentionNum);
      return doctorBaseVo;
    }
    return null;
  }

  public int editDoctorPwd(String password, String phone) {
    AppletDoctorExample example = new AppletDoctorExample();
    Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    if (StringUtils.isNotBlank(phone)) {
      criteria.andDoctorPhoneEqualTo(phone);
    }
    AppletDoctor doctor = new AppletDoctor();
    doctor.setDoctorPassword(MD5Utils.getMD5(password));
    doctor.setUpdateDate(new Date());
    return appletDoctorMapper.updateByExampleSelective(doctor, example);
  }
}
