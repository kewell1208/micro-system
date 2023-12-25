package com.tclab.weixinappletscheduler.scheduler;

import com.tclab.weixinappletservice.service.clientService.ImRecommendListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Package：com.tclab.weixinappletservice.Scheduler
 * @Class：RecommendListScheduler
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/10/9 3:37 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Component
public class RecommendListSchedulerNew {

  private static final Logger logger = LoggerFactory.getLogger(RecommendListSchedulerNew.class);

  @Autowired
  private ImRecommendListService imRecommendListService;

  /**
   * 每小时执行一次，未付款成功的初诊检验清单自动失效
   */
  @Scheduled(cron = "0 0 0/1 * * ? ")
  public void firstRecommendListInvalid() {
    int i = imRecommendListService.invalidRecommendList(0);
    if (i == 0) {
      logger.error("定时器每小时自动失效初诊检验清单失败");
    }
  }

  /**
   * 每天执行一次，未付款成功的复诊检验清单自动失效
   */
  @Scheduled(cron = "0 0 0 1/1 * ? ")
  public void secondRecommendListInvalid() {
    int i = imRecommendListService.invalidRecommendList(1);
    if (i == 0) {
      logger.error("定时器每天自动失效复诊检验清单失败");
    }
  }
}
