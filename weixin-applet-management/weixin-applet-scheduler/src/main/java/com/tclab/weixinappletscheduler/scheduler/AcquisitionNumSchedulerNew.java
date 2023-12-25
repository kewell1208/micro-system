package com.tclab.weixinappletscheduler.scheduler;

import com.tclab.weixinappletservice.dao.AppletAcquisitionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AcquisitionNumSchedulerNew {

    private static final Logger logger = LoggerFactory.getLogger(AcquisitionNumSchedulerNew.class);

    @Autowired
    private AppletAcquisitionMapper acquisitionMapper;

    @Transactional
    @Scheduled(cron = "0 7 0 * * ?")
    public void packageForms(){

        logger.info("定时器每日统计采集点订单采集的数量");
        acquisitionMapper.updateAcquisitionRecommendForAll();
        logger.info("定时器每日统计采集点订单采集的数量成功");
    }

}
