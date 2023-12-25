package com.tclab.weixinappletservice.service.clientService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.MessageConstants;
import com.tclab.weixinappletservice.dao.AppletMessageMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.MessageVo;
import com.tclab.weixinappletservice.pojo.AppletMessage;
import com.tclab.weixinappletservice.pojo.AppletMessageExample;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
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
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    private AppletMessageMapper messageMapper;

    public List<MessageVo> getMessageByUserIdAndStatus(String userId, Integer messageStatus, Integer pageNo, Integer pageSize){
        AppletMessageExample example = new AppletMessageExample();
        AppletMessageExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andUserIdEqualTo(userId);
        if (messageStatus!=null)
        criteria.andMessageStatusEqualTo(messageStatus);
        example.setOrderByClause("create_date DESC");
        PageHelper.startPage(pageNo,pageSize);
        List<AppletMessage> result = messageMapper.selectByExample(example);
        PageInfo<AppletMessage> messagePageInfo = new PageInfo<>(result);
        List<AppletMessage> messages = messagePageInfo.getList();
        List<MessageVo> messageVos = new ArrayList<>();
        for (AppletMessage message:messages) {
            MessageVo vo = new MessageVo();
            BeanUtils.copyProperties(message,vo);
            vo.setMessageDate(DateUtils.convertToSlashAndMinDate(message.getMessageDate()));
            messageVos.add(vo);
        }
        return messageVos;
    }

    public List<MessageVo> getMessageByAcquisitionIdAndStatus(String acquisitionId, Integer messageStatus, Integer pageNo, Integer pageSize){
        AppletMessageExample example = new AppletMessageExample();
        AppletMessageExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
//        criteria.andSourceTypeEqualTo(MessageConstants.SOURCE_TYPE_ACQUISITION);
        criteria.andSourceIdEqualTo(acquisitionId);
        if (messageStatus!=null)
            criteria.andMessageStatusEqualTo(messageStatus);
        example.setOrderByClause("create_date DESC");
        PageHelper.startPage(pageNo,pageSize);
        List<AppletMessage> result = messageMapper.selectByExample(example);
        PageInfo<AppletMessage> messagePageInfo = new PageInfo<>(result);
        List<AppletMessage> messages = messagePageInfo.getList();
        List<MessageVo> messageVos = new ArrayList<>();
        for (AppletMessage message:messages) {
            MessageVo vo = new MessageVo();
            BeanUtils.copyProperties(message,vo);
            vo.setMessageDate(DateUtils.convertToSlashAndMinDate(message.getMessageDate()));
            messageVos.add(vo);
        }
        return messageVos;
    }

    public boolean readMessage(String messageId){
        AppletMessageExample example = new AppletMessageExample();
        AppletMessageExample.Criteria criteria = example.createCriteria();
        criteria.andDelFlagEqualTo(CommonConstants.INIT);
        criteria.andMessageIdEqualTo(messageId);

        AppletMessage message = new AppletMessage();
        message.setMessageStatus(CommonConstants.ENABLE);
        message.setUpdateDate(new Date());
        int result = messageMapper.updateByExampleSelective(message,example);
        if (result==0){
            return false;
        } else {
            logger.info("采集点已读消息: "+messageId);
            return true;
        }

    }

    @Transactional
    public boolean createMessageByAcquisition(String acquisitionId,String head,String content){
        AppletMessage message = new AppletMessage();
        message.setUpdateDate(new Date());
        message.setMessageStatus(CommonConstants.INIT);
        message.setCreateDate(new Date());
        message.setDelFlag(CommonConstants.INIT);
        message.setMessageContent(content);
        message.setMessageDate(new Date());
        message.setMessageHead(head);
        message.setSourceId(acquisitionId);
        message.setSourceType(MessageConstants.SOURCE_TYPE_ACQUISITION);
        message.setMessageId(NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_MESSAGE));
        int i = messageMapper.insertSelective(message);
        if (i==0)
            throw new RuntimeException("物流消息生成失败失败");
        return true;
    }

    @Transactional
    public boolean createMessageByUser(String userId,String head,String content){
        AppletMessage message = new AppletMessage();
        message.setUpdateDate(new Date());
        message.setMessageStatus(CommonConstants.INIT);
        message.setCreateDate(new Date());
        message.setDelFlag(CommonConstants.INIT);
        message.setMessageContent(content);
        message.setMessageDate(new Date());
        message.setMessageHead(head);
        message.setSourceType(MessageConstants.SOURCE_TYPE_USER);
        message.setUserId(userId);
        message.setMessageId(NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_MESSAGE));
        int i = messageMapper.insertSelective(message);
        if (i==0)
            throw new RuntimeException("物流消息生成失败失败");
        return true;
    }

}
