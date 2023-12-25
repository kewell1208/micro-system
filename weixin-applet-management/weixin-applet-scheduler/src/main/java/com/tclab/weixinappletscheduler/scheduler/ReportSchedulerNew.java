package com.tclab.weixinappletscheduler.scheduler;


import com.alibaba.fastjson.JSON;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.OrderConstants;
import com.tclab.weixinappletcommon.utils.HttpClientUtil;
import com.tclab.weixinappletcommon.utils.SMSUtils;
import com.tclab.weixinappletcommon.utils.WxTencentUtils;
import com.tclab.weixinappletservice.dao.AppletInterpretMapper;
import com.tclab.weixinappletservice.dao.AppletOrderMapper;
import com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo.MessageListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo.ResultVo;
import com.tclab.weixinappletservice.pojo.AppletGood;
import com.tclab.weixinappletservice.pojo.AppletInterpret;
import com.tclab.weixinappletservice.pojo.AppletInterpretExample;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderExample;
import com.tclab.weixinappletservice.pojo.AppletOrderExample.Criteria;
import com.tclab.weixinappletservice.service.clientService.GoodService;
import com.tclab.weixinappletservice.service.clientService.ImRecommendListService;
import com.tclab.weixinappletservice.service.clientService.ImRecordService;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ReportSchedulerNew {

  private static final Logger logger = LoggerFactory.getLogger(ReportSchedulerNew.class);

  @Autowired
  private GoodService goodService;
  @Autowired
  private AppletOrderMapper appletOrderMapper;
  @Autowired
  private ImRecommendListService recommendListService;
  @Autowired
  private ImRecordService imRecordService;
  @Autowired
  private AppletInterpretMapper appletInterpretMapper;

  @Value("${image.resource.location}")
  private String imageResourcelocation;
  @Value("${third.queryReportBarcode.url}")
  private String queryReportBarcodeUrl;

  @Transactional
  @Scheduled(cron = "0 0/15 * * * ?")
  public void testTasks() {

    logger.info("定时器每隔15分钟获取报告状态并将pdf文件转换成jpg");

    //url请求地址
//        String url = "http://120.193.21.152:8110/services/report/rest/report/getReportlibSampleInfoListByBarCodes";
    String url = queryReportBarcodeUrl;

    //拼装barcode列表
    List<AppletGood> goodList = goodService.getTestingGood(50);
    if (goodList == null || goodList.size() == 0) {
      logger.info("定时器没有查询到需要检验中的套餐");
      return;
    }
    StringBuffer sb = new StringBuffer();
    for (AppletGood good : goodList) {
      if (StringUtils.isNotBlank(good.getSampleNo())) {
        sb.append("\'" + good.getSampleNo() + "\'" + ",");
      }
    }
    String sbstr = "";
    if (sb.length() != 0) {
      sbstr = sb.substring(0, sb.length() - 1);
    }
    logger.info("定时器请求的样本号请求拼接字符串: " + sbstr);

    //发送get请求
    Map<String, String> param = new HashMap<>();
    param.put("barcode", sbstr);
    Date startDate = new Date();
    String reportResult = HttpClientUtil.doGet(url, param);
    Date endDate = new Date();
    logger.info("报告库请求用时" + (endDate.getTime() - startDate.getTime()));

    //处理返回结果
    reportResult = reportResult.substring(13, reportResult.length() - 1);
    logger.info("查询报告库结果" + reportResult);
    ResultVo model = null;
    try {
      model = JSON.parseObject(reportResult, ResultVo.class);
    } catch (Exception e) {
      logger.info("报告库返回信息出错");
      logger.info(e.getMessage());
      return;
    }
    if (model == null) {
      logger.info("报告库结果信息转JSON为空");
      return;
    }
    Integer status = model.getState();

    AppletGood good;
    //处理正常返回结果
    if (status == 1) {
      List<MessageListVo> messageListVoList = model.getMessage();
      logger.info("报告库列表长度" + messageListVoList.size());
      a:
      for (MessageListVo messageListVo : messageListVoList) {
        //设置套餐已解读以及pdf生成的图片
        good = goodService.getGoodBySampleNo(messageListVo.getBarcode());

        //List<String> imgList = new ArrayList<>();
        if (good != null) {
          try {
            logger.info("pdf转图片开始: " + good.getGoodNo());
            logger.info("pdf地址: " + messageListVo.getReporturl());
            // imgList = PdfToImageUtils.pdf2Img(good.getGoodNo(),imageResourcelocation+"/pdf","png",messageListVo.getReporturl());
                        /*if (imgList==null){
                            logger.info("pdf转图片文件地址无效: "+good.getGoodNo());
                            continue a;
                        }*/
            logger.info("GoodNo: " + good.getGoodNo());
            logger.info("商品原始报告图片地址" + good.getReportImg());
            logger.info("商品原始PDF地址" + good.getPdfUrl());
            goodService.setGoodReported(good.getGoodNo(), messageListVo.getChecktime(), messageListVo.getReporturl(), good.getPdfUrl(), good);
            logger.info("设置商品已出报告状态成功: " + good.getGoodNo());
          } catch (Exception e) {
            logger.info("设置套餐已出报告失败: " + good.getGoodNo());
            logger.info("报错内容：" + e);
            continue;
          }


        }
      }
    } else {
      //处理异常返回结果
      logger.info("查询报告库结果出错");
      return;
    }

  }

  @Scheduled(cron = "0 0/15 * * * ?")
  public void sendMessage() {
    AppletOrderExample example = new AppletOrderExample();
    Criteria criteria = example.createCriteria();
    criteria.andDelFlagEqualTo(CommonConstants.INIT);
    criteria.andOrderStatusEqualTo(OrderConstants.ORDER_STATUS_COMPLETED);
    criteria.andOrderCancelStatusEqualTo(CommonConstants.INIT);//订单未取消状态
    criteria.andMessageStatusIsNull();
    List<AppletOrder> appletOrderList = appletOrderMapper.selectByExample(example);
    if (appletOrderList != null && appletOrderList.size() > 0) {
      for (AppletOrder appletOrder : appletOrderList) {
        //所有条件都达成 报告收全 进行消息分发 状态值更改
        //***************事务开始 推送出报告信息 发短信给参检人  发推送给参检医生********************
        String pt = sendSmsPT(appletOrder.getOrderNo(), appletOrder.getParticipantPhone());
        String dc = sendSmsDC(appletOrder.getStaffPhone(), appletOrder.getParticipantName(), appletOrder.getParticipantPhone());
        //***************事务结束 推送出报告信息 发短信给参检人  发推送给参检医生********************
        //发送聊天信息
        String im = "0";
        AppletInterpretExample interpretExample = new AppletInterpretExample();
        interpretExample.setOrderByClause(" create_date desc");
        AppletInterpretExample.Criteria interpretExampleCriteria = interpretExample.createCriteria();
        interpretExampleCriteria.andDelFlagEqualTo(CommonConstants.INIT);
        interpretExampleCriteria.andDoctorIdEqualTo(appletOrder.getInterpretStaffId());
        interpretExampleCriteria.andParticipantIdEqualTo(appletOrder.getParticipantId());
        List<AppletInterpret> appletInterpretList = appletInterpretMapper.selectByExample(interpretExample);
        if (appletInterpretList != null && appletInterpretList.size() > 0) {
          Map<String, Object> msgType = new HashMap<>();
          msgType.put("MsgType", "TIMCustomElem");
          Map<String, Object> data = new HashMap<>();
          data.put("Data", appletInterpretList.get(0).getInterpretId());
          data.put("Desc", "report");
          data.put("Ext", "");
          msgType.put("MsgContent", data);
          List<Map<String, Object>> list = new ArrayList<>();
          list.add(msgType);
          im = WxTencentUtils.sendImMessage(appletOrder.getInterpretStaffId(), appletOrder.getUserId(), list);
        }
        //更新数据库为已发送消息
        appletOrder.setMessageStatus(pt + dc + im);
        appletOrderMapper.updateByPrimaryKey(appletOrder);
      }
    }
  }

  private String sendSmsDC(String doctorphone, String participantname, String participantphone) {
    if (!"".equals(participantname) && !"".equals(participantphone) && null != participantname && null != participantphone) {
      Map<String, String> map = new HashMap<>();
      map.put("participantname", participantname);
      map.put("participantphone", participantphone);
      boolean result = SMSUtils.sendSms(doctorphone, map, SMSUtils.templateCodeOutOrderDoc);
      if (result) {
        return "1";
      } else {
        return "0";
      }

    } else {
      logger.info("报告出结果发送失败参数为空" + participantname + "+" + participantphone);
      return "0";
    }
  }

  private String sendSmsPT(String orderNo, String phone) {
    if (!"".equals(orderNo) && !"".equals(phone) && null != orderNo && null != phone) {
      Map<String, String> map = new HashMap<>();
      map.put("orderNo", orderNo);
      boolean result = SMSUtils.sendSms(phone, map, SMSUtils.templateCodeOutOrder);
      if (result) {
        return "1";
      } else {
        return "0";
      }
    } else {
      logger.info("报告出结果发送失败参数为空" + orderNo + "+" + orderNo);
      return "0";
    }
  }
}
