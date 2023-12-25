package com.tclab.weixinappletcommon.utils;

import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import java.text.DecimalFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberGeneratorUtils {

    @Autowired
    private RedisUtils redisUtils;

    private static final Logger logger = LoggerFactory.getLogger(NumberGeneratorUtils.class);

    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);
    private final static Format dateFormat = new SimpleDateFormat("YYYYMMddHHmmssS");
    private final static NumberFormat numberFormat = new DecimalFormat("000");

    public static synchronized String generateIdByType(String type){
        StringBuffer sb1 = new StringBuffer();
        sb1.append(type);

        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb2 = new StringBuffer();
        dateFormat.format(rightNow.getTime(), sb2, HELPER_POSITION);
        numberFormat.format(Math.random()*999, sb2, HELPER_POSITION);

        String result =sb1.append(sb2.toString()).toString();
        return result;
    }

    public static synchronized String generateDate(){
        Calendar rightNow = Calendar.getInstance();
        StringBuffer sb2 = new StringBuffer();
        dateFormat.format(rightNow.getTime(), sb2, HELPER_POSITION);
        numberFormat.format(Math.random()*999, sb2, HELPER_POSITION);
        return sb2.toString();
    }

    public static synchronized String generateSixRandomCode(){
        return String.valueOf((int)((Math.random()*9+1)*100000));
    }

    public synchronized String generateNo(String type,String key){
        logger.info("redisUtils: "+redisUtils);
        String value = redisUtils.get(RedisConstants.GENERATEID+":"+key);
        value = String.format("%06d", value);
        String newValue = String.valueOf(Integer.parseInt(value)+1);
        redisUtils.set(key,newValue);
        String day = redisUtils.get(RedisConstants.DAY);
        return type+day+value;
    }

  public synchronized String generateImRecordId() {
    String imIndexStr = "";
    String imIndex = redisUtils.get(RedisConstants.GENERATEID + ":" + RedisConstants.IM_INDEX);
    if (StringUtils.isNotBlank(imIndex)) {
      Integer index = Integer.parseInt(imIndex);
      index++;
      boolean a = redisUtils.set(RedisConstants.GENERATEID + ":" + RedisConstants.IM_INDEX, index.toString());
      if (!a) {
        throw new RuntimeException("生成IM编号失败");
      }
      imIndexStr = String.format("%06d", index);
    } else {
      redisUtils.set(RedisConstants.GENERATEID + ":" + RedisConstants.IM_INDEX, "1");
      imIndexStr = String.format("%06d", 1);
    }
    String day = redisUtils.get(RedisConstants.DAY);
    if (day == null) {
      day = DateUtils.formatDayString(new Date());
    }
    return CommonConstants.GenerateID_IM + day + imIndexStr;
  }
}
