package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletservice.dao.AppletImRelationMapper;
import com.tclab.weixinappletservice.pojo.AppletImRelation;
import com.tclab.weixinappletservice.pojo.AppletImRelationExample;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class IMRelationService {

    @Autowired
    private AppletImRelationMapper relationMapper;

    public List<AppletImRelation> getRelationByDoctor(String doctorId){
        AppletImRelationExample relationExample = new AppletImRelationExample();
        AppletImRelationExample.Criteria criteria = relationExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(doctorId)){
            criteria.andDoctorIdEqualTo(doctorId);
        }
        List<AppletImRelation> resultList = relationMapper.selectByExample(relationExample);
        return resultList;
    }

    public List<AppletImRelation> getAttentionRelationByUser(String userId){
        AppletImRelationExample relationExample = new AppletImRelationExample();
        AppletImRelationExample.Criteria criteria = relationExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andParticipantAttentionFlagEqualTo(CommonConstants.ENABLE);
        if (StringUtils.isNotBlank(userId)){
            criteria.andUserIdEqualTo(userId);
        }
        List<AppletImRelation> resultList = relationMapper.selectByExample(relationExample);
        return resultList;
    }

    public AppletImRelation getAttentionRelationByUserAndDoctor(String userId,String doctorId){
        AppletImRelationExample relationExample = new AppletImRelationExample();
        AppletImRelationExample.Criteria criteria = relationExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(userId)){
            criteria.andUserIdEqualTo(userId);
        }
        if (StringUtils.isNotBlank(doctorId)){
            criteria.andDoctorIdEqualTo(doctorId);
        }
        List<AppletImRelation> resultList = relationMapper.selectByExample(relationExample);
        if (resultList!=null&&resultList.size()!=0){
            return resultList.get(0);
        } else {
            return null;
        }
    }

    @Transactional
    public Integer changeAttention(String userId,String doctorId){

        AppletImRelationExample relationExample = new AppletImRelationExample();
        AppletImRelationExample.Criteria criteria = relationExample.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        if (StringUtils.isNotBlank(userId)){
            criteria.andUserIdEqualTo(userId);
        }
        if (StringUtils.isNotBlank(doctorId)){
            criteria.andDoctorIdEqualTo(doctorId);
        }

        int i = 0;

        AppletImRelation relation = getAttentionRelationByUserAndDoctor(userId,doctorId);
        if (relation!=null){
            if (relation.getParticipantAttentionFlag().equals(CommonConstants.INIT)){
                //如果已有关系未关注点击关注
                AppletImRelation update = new AppletImRelation();
                update.setUpdateDate(new Date());
                update.setParticipantAttentionFlag(CommonConstants.ENABLE);
                i = relationMapper.updateByExampleSelective(update,relationExample);
                if (i==0){
                    throw new RuntimeException("关注失败");
                }
                return CommonConstants.ENABLE;
            } else {
                //如果已关注点击取消关注
                AppletImRelation update = new AppletImRelation();
                update.setUpdateDate(new Date());
                update.setParticipantAttentionFlag(CommonConstants.INIT);
                i = relationMapper.updateByExampleSelective(update,relationExample);
                if (i==0){
                    throw new RuntimeException("取消关注失败");
                }
                return CommonConstants.INIT;
            }
        } else {
            //如果没有记录关系点击关注生成关注关系
            AppletImRelation insert = new AppletImRelation();
            insert.setParticipantAttentionFlag(CommonConstants.ENABLE);
            insert.setUpdateDate(new Date());
            insert.setCreateDate(new Date());
            insert.setDelFlag(CommonConstants.INIT);
            insert.setDoctorId(doctorId);
            insert.setUserId(userId);
            i = relationMapper.insertSelective(insert);
            if (i==0){
                throw new RuntimeException("创建关注失败");
            }
            return CommonConstants.ENABLE;
        }
    }

}
