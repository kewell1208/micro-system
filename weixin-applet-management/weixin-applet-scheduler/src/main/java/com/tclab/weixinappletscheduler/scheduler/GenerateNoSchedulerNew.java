package com.tclab.weixinappletscheduler.scheduler;

import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenerateNoSchedulerNew {

    @Autowired
    private RedisUtils redisUtils;

    private static final Logger logger = LoggerFactory.getLogger(GenerateNoSchedulerNew.class);

    @Scheduled(cron = "0 1 1 * * ?")
    public void GenerateDateString() {

        logger.info("定时器每日根据时间生成起始编号");

        try {
            String day = DateUtils.formatDayString(new Date());
            boolean a = redisUtils.set(RedisConstants.DAY,day);
            redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.ACQUISITIONID_INDEX,"1");
            redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.LOGISTICSID_INDEX,"1");
            redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.PACKAGE_INDEX,"1");
            redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.ORDERNO_INDEX,"1");
            redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.STAFFID_INDEX,"1");
            redisUtils.set(RedisConstants.GENERATEID+":"+RedisConstants.USERID_INDEX,"1");
            if (a){
                logger.info("定时器每日根据时间生成起始编号成功");
            } else {
                logger.info("定时器每日根据时间生成起始编号失败");
            }
        } catch (Exception e){
            redisUtils.remove(RedisConstants.DAY);
        }

    }

}
