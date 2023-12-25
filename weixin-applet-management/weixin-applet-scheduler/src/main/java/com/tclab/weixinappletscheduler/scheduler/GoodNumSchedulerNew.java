package com.tclab.weixinappletscheduler.scheduler;

import com.tclab.weixinappletservice.dao.AppletPackageMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GoodNumSchedulerNew {

    private static final Logger logger = LoggerFactory.getLogger(GoodNumSchedulerNew.class);

    @Autowired
    private AppletPackageMapper packageMapper;

    @Transactional
    @Scheduled(cron = "0 5 0 * * ?")
    public void packageForms(){

        logger.info("定时器每日统计套餐的数量");
        packageMapper.updatePackageRecommendForAll();
        logger.info("定时器每日统计套餐数量成功");
    }

}
