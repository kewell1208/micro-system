package com.tclab.weixinappletscheduler.scheduler;

import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CheckIpSchedulerNew {

    @Autowired
    private RedisUtils redisUtils;

    private static final Logger logger = LoggerFactory.getLogger(CheckIpSchedulerNew.class);

    @Scheduled(cron = "0 3 0 * * ?")
    public void delIPPool() {

        logger.info("定时器每日删除正常的IP记录");

        try {
            redisUtils.removePattern(RedisConstants.IPCOUNT+":*");
            logger.info("删除正常的IP记录成功");
        } catch (Exception e){
            logger.info("定时器每日删除正常的IP记录失败");
            logger.info(e.getMessage());
        }
    }

}
