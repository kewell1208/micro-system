package com.tclab.weixinappletcommon.utils;

import org.apache.commons.lang3.StringUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

  private final static SimpleDateFormat sdfForSlash = new SimpleDateFormat("yyyy/MM/dd");
  private final static SimpleDateFormat sdfForMin = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  private final static SimpleDateFormat sdfForSlashAndMin = new SimpleDateFormat("yyyy/MM/dd HH:mm");
  private final static SimpleDateFormat sdfForOrderApplyDate = new SimpleDateFormat("yyyy-MM-dd-HH:mm");
  private final static SimpleDateFormat yearAndMonthSdf = new SimpleDateFormat("yyyy-MM");

  //获取当日的起始时间
  public final static Date getDateStartForThisDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(date);
    calendar.set(Calendar.HOUR, 0);
    calendar.set(Calendar.MINUTE, 0);
    calendar.set(Calendar.SECOND, 0);
    calendar.set(Calendar.MILLISECOND, 0);
    return calendar.getTime();
  }

  //获取当日的截止日期
  public static Date getDateEndForThisDay(Date date) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(Calendar.HOUR_OF_DAY, 23);
    calendar.set(Calendar.MINUTE, 59);
    calendar.set(Calendar.SECOND, 59);
    calendar.set(Calendar.MILLISECOND, 999);
    return calendar.getTime();
  }


  //获取当前周起始时间周日开始
  public final static Date getDateForThisWeek(Date date) {
//        Calendar cal = Calendar.getInstance();
//        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
//        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        return cal.getTime();

    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    cal.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
    cal.set(Calendar.HOUR_OF_DAY, 0);
    cal.set(Calendar.MINUTE, 0);
    cal.set(Calendar.SECOND, 0);
    return cal.getTime();
  }

  //获取当前月份一号开始时间
  public final static Date getDateForThisMonth(Date date) {
    Calendar para = Calendar.getInstance();
    para.setTime(date);
    para.set(Calendar.DATE, para.getActualMinimum(Calendar.DAY_OF_MONTH));
    para.set(Calendar.HOUR_OF_DAY, 0);
    para.set(Calendar.MINUTE, 0);
    para.set(Calendar.SECOND, 0);
    return para.getTime();
  }

  //获取下个月份一号开始时间
  public final static Date getDateForNextMonth(Date date) {
    Calendar para = Calendar.getInstance();
    para.setTime(date);
    para.add(Calendar.MONTH, 1);
    para.set(Calendar.DAY_OF_MONTH, 1);
    return para.getTime();
  }

  public final static Date formatDate(String date) {
    if (date == null || date.equals("")) {
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date convertDate = sdf.parse(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static Date formatDateForAMOrPM(String date) {
    if (date == null || date.equals("")) {
      return null;
    }

    String apm = date.substring(date.lastIndexOf("-") + 1);
    String result = null;

    if (StringUtils.isNotBlank(apm)) {
      if (apm.equals("上午")) {
        result = date.replace("-" + apm, " 12:00:00");
      } else if (apm.equals("下午")) {
        result = date.replace("-" + apm, " 18:00:00");
      } else {
        result = date.replace("-" + apm, " 00:00:00");
      }
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date convertDate = sdf.parse(result);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static Date formatDateForAMOrPMDelay(String date) {
    if (date == null || date.equals("")) {
      return null;
    }

    String apm = date.substring(date.lastIndexOf("-") + 3);
    String result = null;

    if (StringUtils.isNotBlank(apm)) {
      if (apm.equals("上午")) {
        result = date.replace(apm, " 12:00:00");
      } else if (apm.equals("下午")) {
        result = date.replace(apm, " 18:00:00");
      } else {
        result = date.replace(apm, " 00:00:00");
      }
    }

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
      Date convertDate = sdf.parse(result);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static Date formatDateAddOneDay(String date) {
    if (date == null || date.equals("")) {
      return null;
    }
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    try {
      Date convertDate = sdf.parse(date);
      long tms = convertDate.getTime() + 24 * 60 * 60 * 1000;
      Date result = new Date(tms);
      return result;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String dateToDay(Date date, String Separator) {
    if (date == null) {
      return null;
    }
    Calendar cal = Calendar.getInstance();
    cal.setTime(date);
    int year = cal.get(Calendar.YEAR);//获取年份
    int month = cal.get(Calendar.MONTH) + 1;//获取月份，月份从0开始所以要加1
    int day = cal.get(Calendar.DATE);//获取日
    return year + Separator + month + Separator + day;
  }

  public final static String dateToTime(Date date) {
    if (date == null) {
      return null;
    }
    DateFormat df = DateFormat.getTimeInstance();
    return df.format(date);
  }

  /**
   *
   */
  public final static int compareDate(String date1, String date2, SimpleDateFormat sdf) {
    if (date1 == null && date2 != null) {
      return -1;
    }
    if (date1 != null && date2 == null) {
      return 1;
    }
    if (date1 == null && date2 == null) {
      return 0;
    }
    if (date1 != null && date2 != null) {

    }
    try {
      Date convertDate1 = sdf.parse(date1);
      Date convertDate2 = sdf.parse(date2);
      if (convertDate1.getTime() > convertDate2.getTime()) {
        return 1;
      } else if (convertDate1.getTime() == convertDate2.getTime()) {
        return 0;
      } else {
        return -1;
      }
    } catch (Exception e) {
      return 0;
    }
  }

  public final static Date convertToMinDate(String dateStr) {
    if (StringUtils.isBlank(dateStr)) {
      return null;
    }
    try {
      Date convertDate = sdfForSlashAndMin.parse(dateStr);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static Date convertToOrderApplyDate(String dateStr) {
    if (StringUtils.isBlank(dateStr)) {
      return null;
    }
    try {
      Date convertDate = sdfForOrderApplyDate.parse(dateStr);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static Date convertToMinrApplyDate(String dateStr) {
    if (StringUtils.isBlank(dateStr)) {
      return null;
    }
    try {
      Date convertDate = sdfForMin.parse(dateStr);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String convertToSlashAndMinDate(Date date) {
    if (date == null) {
      return null;
    }
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
      String convertDate = simpleDateFormat.format(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String convertToSlashAndDayDate(Date date) {
    if (date == null) {
      return null;
    }
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
      String convertDate = simpleDateFormat.format(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String convertToStandardDate(Date date) {
    if (date == null) {
      return null;
    }
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
      String convertDate = simpleDateFormat.format(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String convertToStandardDateNew(Date date) {
    if (date == null) {
      return null;
    }
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      String convertDate = simpleDateFormat.format(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String formatDayString(Date date) {
    if (date == null) {
      return null;
    }
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
      String convertDate = simpleDateFormat.format(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }


  public final static String dateToStringForOrder(Date date) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat yearDF = new SimpleDateFormat("yyyy");
    String yearstr = yearDF.format(date);
    SimpleDateFormat monDF = new SimpleDateFormat("MM");
    String monstr = monDF.format(date);
    SimpleDateFormat dayDF = new SimpleDateFormat("dd");
    String daystr = dayDF.format(date);
    SimpleDateFormat hourDF = new SimpleDateFormat("HH");
    String hourstr = hourDF.format(date);
    SimpleDateFormat minDF = new SimpleDateFormat("mm");
    String minstr = minDF.format(date);
    String str = yearstr + "年" + monstr + "月" + daystr + "日" + hourstr + "点" + minstr + "分";
    return str;
  }

  public final static String dateToStringForAMOrPM(Date date) {
    if (date == null) {
      return null;
    }

    SimpleDateFormat df = new SimpleDateFormat("HH");
    String str = df.format(date);
    String apm = null;
    int a = Integer.parseInt(str);
    if (a > 6 && a <= 12) {
      apm = "上午";
    }
    if (a > 12 && a <= 18) {
      apm = "下午";
    }
    SimpleDateFormat df2 = new SimpleDateFormat("yyyy-MM-dd");
    str = df2.format(date);
    if (apm != null) {
      return str + "-" + apm;
    } else {
      return str;
    }
  }

  public final static Date convertToReportDate(String dateStr) {
    if (StringUtils.isBlank(dateStr)) {
      return null;
    }
    try {
      SimpleDateFormat sdfForReport = new SimpleDateFormat("yyyy-MM-dd");
      Date convertDate = sdfForReport.parse(dateStr);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static Date convertToMonthDate(String dateStr) {
    if (StringUtils.isBlank(dateStr)) {
      return null;
    }
    try {
      SimpleDateFormat sdfForReport = new SimpleDateFormat("yyyy-MM");
      Date convertDate = sdfForReport.parse(dateStr);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String convertToSlashAndMonthStr(Date date) {
    if (date == null) {
      return null;
    }
    try {
      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
      String convertDate = simpleDateFormat.format(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static Date convertToYearAndMonthDate(String date) {
    if (StringUtils.isBlank(date)) {
      return null;
    }
    try {
      Date convertDate = yearAndMonthSdf.parse(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String formatSdfForMinDate(Date date) {
    if (date == null) {
      return null;
    }
    try {
      String convertDate = sdfForMin.format(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static String formatDate(Date date, String format) {
    if (date == null) {
      return null;
    }
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    try {
      String convertDate = simpleDateFormat.format(date);
      return convertDate;
    } catch (Exception e) {
      return null;
    }
  }

  public final static Date getDistanceDate(Date date, Integer day) {
    Calendar cal = Calendar.getInstance();//使用默认时区和语言环境获得一个日历。
    cal.setTime(date);
    cal.add(Calendar.DATE, day);//取当前日期的前一天.
    return cal.getTime();
  }
}
