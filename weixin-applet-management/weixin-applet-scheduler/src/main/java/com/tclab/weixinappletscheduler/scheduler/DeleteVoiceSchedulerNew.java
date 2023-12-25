package com.tclab.weixinappletscheduler.scheduler;

import com.tclab.weixinappletcommon.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.File;
import java.util.Date;

/**
 * @Package：com.tclab.weixinappletservice.Scheduler
 * @Class：DeleteVoiceScheduler
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/24 3:14 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
public class DeleteVoiceSchedulerNew {

  private static final Logger logger = LoggerFactory.getLogger(DeleteVoiceSchedulerNew.class);

  @Value("${tclab.im.voice.path}")
  private String path;

  @Scheduled(cron = "0 0 0 * * ?")
  public void deleteVoice() {
    logger.info("定时器每日删除7天之外的语音文件");
    try {
      File file = new File(path);
      if (file.exists()) {
        File[] files = file.listFiles();
        for (File file2 : files) {
          if (file2.isDirectory()) {
            Integer yyyyMMdd = Integer.parseInt(DateUtils.formatDate(new Date(), "yyyyMMdd"));
            if (yyyyMMdd - Integer.parseInt(file2.getName()) > 7) {
              deleteDir(file2);
            } else {
              continue;
            }
          }
        }
      } else {
        System.out.println("文件不存在!");
      }
      logger.info("定时器每日删除7天之外的语音文件成功");
    } catch (Exception e) {
      logger.info("定时器每日删除7天之外的语音文件失败");
      logger.info(e.getMessage());
    }
  }

  public static void deleteDir(File dir) {
    if (dir.isDirectory()) {
      File[] files = dir.listFiles();
      for (int i = 0; i < files.length; i++) {
        deleteDir(files[i]);
      }
    }
    dir.delete();
  }
}
