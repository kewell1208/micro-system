package com.tclab.weixinappletservice.service.adminService;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.MessageConstants;
import com.tclab.weixinappletcommon.utils.NumberGeneratorUtils;
import com.tclab.weixinappletservice.dao.AppletMessageMapper;
import com.tclab.weixinappletservice.pojo.AppletMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AdminMessageService {

    private static final Logger logger = LoggerFactory.getLogger(AdminMessageService.class);

    @Autowired
    private AppletMessageMapper messageMapper;

    @Transactional
    public boolean createMessageByBack(String acquisitionId,String head,String content){
        AppletMessage message = new AppletMessage();
        message.setUpdateDate(new Date());
        message.setMessageStatus(CommonConstants.INIT);
        message.setCreateDate(new Date());
        message.setDelFlag(CommonConstants.INIT);
        message.setMessageContent(content);
        message.setMessageDate(new Date());
        message.setMessageHead(head);
        message.setSourceId(acquisitionId);
        message.setSourceType(MessageConstants.SOURCE_TYPE_BACK);
        message.setMessageId(NumberGeneratorUtils.generateIdByType(CommonConstants.GenerateID_MESSAGE));
        int i = messageMapper.insertSelective(message);
        if (i==0)
            throw new RuntimeException("物流收件消息生成失败失败");
        return true;
    }

}
