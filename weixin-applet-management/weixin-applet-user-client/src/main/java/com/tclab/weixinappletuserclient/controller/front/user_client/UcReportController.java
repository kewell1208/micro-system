package com.tclab.weixinappletuserclient.controller.front.user_client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tclab.weixinappletcommon.constant.CommonConstants;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.constant.GoodConstants;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.CommonHttpClientUtils;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.FileUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletservice.dao.AppletInterpretMapper;
import com.tclab.weixinappletservice.model.result.GoodInfoByNoResult;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.OrderListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ReportBaseVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.ReportListVo;
import com.tclab.weixinappletservice.model.vo.clientVo.apiVo.StaffVo;
import com.tclab.weixinappletservice.pojo.*;
import com.tclab.weixinappletservice.service.clientService.*;
import com.tclab.weixinappletuserclient.model.req.apiReq.InterpretReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.ReportListReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.ReportSampleReq;
import com.tclab.weixinappletuserclient.model.req.apiReq.doctor.DcInterpretQueryReq;
import com.tclab.weixinappletuserclient.model.vo.OrderInterpretBaseVo;
import com.tclab.weixinappletuserclient.model.vo.UploadReport;
import com.tclab.weixinappletuserclient.model.vo.UploadReportReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.commons.lang3.StringUtils;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.*;

@Api(tags = "客户端报告模块")
@Controller
@RequestMapping(value = "/user/report")
public class UcReportController {

  private static final Logger logger = LoggerFactory.getLogger(UcReportController.class);

  @Autowired
  private GoodService goodService;
  @Autowired
  private AppletInterpretMapper appletInterpretMapper;
  @Autowired
  private RedisUtils redisUtils;
  @Autowired
  private ParticipantService participantService;
  @Autowired
  private OrderService orderService;
  @Autowired
  private DoctorService doctorService;
  @Autowired
  private StaffService staffService;
  @Autowired
  private InterpretService interpretService;
  @Autowired
  private ImRecordService imRecordService;
  @Autowired
  private InterpretGoodService interpretGoodService;

  /**
   * 传入goodNo  合并对该详单pdf进行合并
   */
  @RequestMapping(value = "/query/reportMorePdfs", method = {RequestMethod.GET})
  @ResponseBody
  public void queryReportPdf(String goodNo) throws Exception {
    logger.info("客户端查询base64 pdf " + goodNo);
    AppletGood good = goodService.getGoodByGoodNo(goodNo, null);
    String pdfurl = good.getPdfUrl();
    String pdfmergeurl = good.getPdfMergeUrl();
    try {
      if (null != pdfurl && !"".equals(pdfurl)) {
        pdfurl = pdfurl.replaceAll("@", "/");
        String[] pathArray = pdfurl.split(";");
        if (1 < pathArray.length && (null == pdfmergeurl || "".equals(pdfmergeurl))) { //大于1张 且报告库没合并过 才进行合并操作
          String reportUrl = "http://120.193.21.152:8081/"; //报告库地址 后期取配置文件
          //http 数据流获取 存list 用完关闭
          List<InputStream> inputStreamList = new ArrayList<InputStream>();
          //pdf文件处理获取
          PDFMergerUtility PDFmerger = new PDFMergerUtility();
          String fileSeperator = File.separator;
          String userDir = System.getProperties().getProperty("user.dir");
          String tempBatchDir = userDir + fileSeperator + "batch.pdf";
          PDFmerger.setDestinationFileName(tempBatchDir);
          for (int i = 0; i < pathArray.length; i++) {
            StringBuilder fileUrlBuilder = new StringBuilder(reportUrl).append(pathArray[i]);
            URLConnection con = new URL(fileUrlBuilder.toString()).openConnection();
            con.setConnectTimeout(60 * 1000);
            InputStream is = new URL(fileUrlBuilder.toString()).openConnection().getInputStream();
            inputStreamList.add(is);
            PDFmerger.addSource(is);
          }
          PDFmerger.mergeDocuments();
          for (InputStream is : inputStreamList) {
            is.close();
          }
          //合并后操作
          String base64str = FileUtils.PDFToBase64(new File(tempBatchDir));
          //System.out.println("base64格式文件打印"+base64str);
          //组装参数
          List<UploadReport> fileStreams = new ArrayList<UploadReport>();
          UploadReport uploadReport = new UploadReport();
          uploadReport.setPdfStream(base64str);
          uploadReport.setWordStream(base64str);//防止报错必须有参数  后期报告库接口服务器重启更新后可去掉这行
          fileStreams.add(uploadReport);
          String jsonStr = JSONObject.toJSONString(fileStreams);
          String methodUrl = "http://120.193.21.152:8110/services/report/rest/report/batchUploadFileByStream";//报告库上传文件地址
          //更新合并的pdf地址
          String uploadResult = CommonHttpClientUtils.postMethodClient(jsonStr, methodUrl);
          Map rm = JSON.parseObject(uploadResult);
          //  String uploadResult = "{ \"Message\": [{ \"barcode\": \"\", \"uploadPdfPath\": \"group1/M00/29/43/rBIUC113c7-AT2M0AAMfgKgibs0344.pdf\", \"uploadWordPath\": \"group1/M00/29/43/rBIUC113c7-AXzhVAAMfgKgibs0173.doc\" }], \"State\": 1 }";
          System.out.println("返回的路径地址" + uploadResult);
          JSONObject jsonObject = JSONObject.parseObject(uploadResult);
          if ("1".equals(rm.get("State").toString())) {
            List<UploadReportReturn> dd = JSON.parseArray(rm.get("Message").toString(), UploadReportReturn.class);
            UploadReportReturn ee = dd.get(0);
            goodService.setGoodReported(good.getGoodNo(), dd.get(0).getUploadPdfPath());
          }
        }
      }
    } catch (Exception e) {
      logger.info("pdf合并失败: " + good.getGoodNo());
    }
       /* //拼装barcode列表
        List<AppletGood> goodList = goodService.getTestingGood(50);
        *//*if (goodList==null||goodList.size()==0){
            logger.info("定时器没有查询到需要检验中的套餐");
            return;
        }*//*
        StringBuffer sb = new StringBuffer();
        AppletGood a = new AppletGood();
        a.setPdfUrl("group1/M00/01/F0/rBIUC11jNTaAGh90AAKZEQJDKck165.pdf");
        AppletGood b = new AppletGood();
        b.setPdfUrl("group1/M00/F0/8D/rBIUC11ZIiKAJrWYAAGnHlvkIhs085.pdf;group1/M00/0C/3A/rBIUC11o3LSATSgTAAF7NE_1DJ8477.pdf");
        goodList.add(a);
        goodList.add(b);
        for (AppletGood good : goodList) {
            try {
                logger.info("pdf合并模块"+good.getGoodNo());
                String pdfurl= good.getPdfUrl();
                String pdfmergeurl= good.getPdfMergeUrl();
                if(null!= pdfurl && !"".equals( pdfurl ) ){
                    pdfurl = pdfurl.replaceAll("@", "/");
                    String[] pathArray = pdfurl.split(";");
                    if(1<pathArray.length &&  ( null== pdfmergeurl || "".equals( pdfmergeurl )  )  ){ //大于1张 且报告库没合并过 才进行合并操作
                        String reportUrl = "http://120.193.21.152:8081/"; //报告库地址 后期取配置文件
                        //http 数据流获取 存list 用完关闭
                        List<InputStream>   inputStreamList = new ArrayList<InputStream>();
                        //pdf文件处理获取
                        PDFMergerUtility PDFmerger = new PDFMergerUtility();
                        String fileSeperator = File.separator;
                        String userDir = System.getProperties().getProperty("user.dir");
                        String tempBatchDir = userDir+fileSeperator+"batch.pdf";
                        PDFmerger.setDestinationFileName(tempBatchDir);
                        for (int i = 0; i < pathArray.length; i++) {
                            StringBuilder fileUrlBuilder = new StringBuilder( reportUrl ).append(pathArray[i]);
                            URLConnection con = new URL(fileUrlBuilder.toString()).openConnection();
                            con.setConnectTimeout( 60*1000 );
                            InputStream  is =  new URL(fileUrlBuilder.toString()).openConnection().getInputStream();
                            inputStreamList.add(is);
                            PDFmerger.addSource(is );
                        }
                        PDFmerger.mergeDocuments();
                        for (InputStream is : inputStreamList){
                            is.close();
                        }
                        //合并后操作
                        String base64str =  FileUtils.PDFToBase64(new File(tempBatchDir) );
                        //System.out.println("base64格式文件打印"+base64str);
                        //组装参数
                        List<UploadReport> fileStreams = new ArrayList<UploadReport>();
                        UploadReport uploadReport =new UploadReport();
                        uploadReport.setPdfStream(base64str);
                        uploadReport.setWordStream(base64str);//防止报错必须有参数  后期报告库接口服务器重启更新后可去掉这行
                        fileStreams.add(uploadReport);
                        String jsonStr = JSONObject.toJSONString(fileStreams);
                        String methodUrl = "http://120.193.21.152:8110/services/report/rest/report/batchUploadFileByStream";//报告库上传文件地址
                        //更新合并的pdf地址
                        String uploadResult = CommonHttpClientUtils.postMethodClient(jsonStr,methodUrl);
                        Map rm = JSON.parseObject(uploadResult);
                      //  String uploadResult = "{ \"Message\": [{ \"barcode\": \"\", \"uploadPdfPath\": \"group1/M00/29/43/rBIUC113c7-AT2M0AAMfgKgibs0344.pdf\", \"uploadWordPath\": \"group1/M00/29/43/rBIUC113c7-AXzhVAAMfgKgibs0173.doc\" }], \"State\": 1 }";
                        System.out.println("返回的路径地址"+uploadResult);
                        JSONObject jsonObject = JSONObject.parseObject(uploadResult);
                        if( "1".equals(rm.get("State").toString())){
                            List<UploadReportReturn> dd =   JSON.parseArray( rm.get("Message").toString(), UploadReportReturn.class);
                            UploadReportReturn  ee=    dd.get(0);
                            goodService.setGoodReported(good.getGoodNo(), dd.get(0).getUploadPdfPath() );
                        }
                    }
                }
            }catch (Exception e){
                logger.info("pdf合并失败: "+good.getGoodNo());
                continue;
            }*/
  }

  public static String PDFToBase64(File file) {
    BASE64Encoder encoder = new BASE64Encoder();
    FileInputStream fin = null;
    BufferedInputStream bin = null;
    org.apache.commons.io.output.ByteArrayOutputStream baos = null;
    BufferedOutputStream bout = null;
    try {
      fin = new FileInputStream(file);
      bin = new BufferedInputStream(fin);
      baos = new ByteArrayOutputStream();
      bout = new BufferedOutputStream(baos);
      byte[] buffer = new byte[1024];
      int len = bin.read(buffer);
      while (len != -1) {
        bout.write(buffer, 0, len);
        len = bin.read(buffer);
      }
      //刷新此输出流并强制写出所有缓冲的输出字节
      bout.flush();
      byte[] bytes = baos.toByteArray();
      return encoder.encodeBuffer(bytes).trim();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      try {
        fin.close();
        bin.close();
        bout.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    return null;
  }


  /**
   * 获取报告图片
   */
  @RequestMapping(value = "/query/reportImg", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResVo queryReportImg(@RequestBody ReportSampleReq req) {

    logger.info("客户端查询报告图片 " + req.toString());

    if (StringUtils.isBlank(req.getSampleNo())) {
      return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
    }
    AppletGood good = goodService.getGoodBySampleNo(req.getSampleNo());
    return JsonResVo.buildSuccess(good.getReportImg());
  }

  @RequestMapping(value = "/query/reportList", method = RequestMethod.GET)
  @ResponseBody
  public JsonResVo queryReportList(ReportListReq req) {

    logger.info("客户端查询报告列表 " + req.toString());

    if (StringUtils.isBlank(req.getUserId())) {
      return JsonResVo.buildFail(ErrorEnum.PARAM_ERROR_EMPTY);
    }

    ReportListVo reportListVo = goodService.getReportedAndUnReportedGoodByUserId(req.getUserId(), req.getReportStatus(), req.getInterpretStatus(), req.getPageNo(), req.getPageSize());

    return JsonResVo.buildSuccess(reportListVo);
  }

  //    @ApiOperation(value = "查询解读订单列表", notes = "查询解读订单列表")
  @RequestMapping(value = "/query/orderReportList", method = RequestMethod.POST)
  @ResponseBody
  public JsonResVo queryOrderReportList(@RequestBody ReportListReq req) {
    logger.info("查询解读订单列表 " + req.toString());
    List<AppletOrder> orderList = orderService.getOrderByInterpretStatus(req.getUserId(), req.getInterpretStatus());
    List<OrderListVo> resultList = new ArrayList<>();
    for (AppletOrder order : orderList) {
      OrderListVo orderListVo = new OrderListVo();
      BeanUtils.copyProperties(order, orderListVo);
      orderListVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
      resultList.add(orderListVo);
    }
    return JsonResVo.buildSuccess(resultList);
  }

  @RequestMapping(value = "/query/orderReportListItemInfo", method = RequestMethod.POST)
  @ResponseBody
  public JsonResVo queryOrderReportListItemInfo(@RequestBody ReportListReq req) {
    logger.info("查询解读订单列表 " + req.toString());
    AppletOrder order = orderService.getOrderByOrderNo(req.getOrderNo());
    OrderInterpretBaseVo result = new OrderInterpretBaseVo();
    if (order != null) {
      OrderListVo orderListVo = new OrderListVo();
      BeanUtils.copyProperties(order, orderListVo);
      orderListVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
      if (StringUtils.isNotBlank(order.getInterpretStaffId()) && order.getInterpretStaffId().substring(0, 1).equals(CommonConstants.GenerateID_STAFF)) {
        StaffVo staff = staffService.getStaffVoById(order.getInterpretStaffId());
        orderListVo.setInterpretStaffId(staff.getStaffId());
        orderListVo.setInterpretStaffLogo(staff.getStaffLogo());
        orderListVo.setInterpretStaffName(staff.getStaffName());
        orderListVo.setInterpretStaffRank(staff.getStaffRank());
        orderListVo.setInterpretStaffDepartmentName(staff.getDepartmentName());
        orderListVo.setInterpretStaffHospitalName(staff.getAcquisitionName());
      } else if (StringUtils.isNotBlank(order.getInterpretStaffId()) && order.getInterpretStaffId().substring(0, 1).equals(CommonConstants.GenerateID_DOCTOR)) {
        AppletDoctor doctor = doctorService.getDoctorByDoctorId(order.getInterpretStaffId());
        orderListVo.setInterpretStaffId(doctor.getDoctorId());
        orderListVo.setInterpretStaffLogo(doctor.getDoctorLogo());
        orderListVo.setInterpretStaffName(doctor.getDoctorName());
        orderListVo.setInterpretStaffRank(doctor.getDoctorRank());
        orderListVo.setInterpretStaffDepartmentName(doctor.getDoctorDepartmentName());
        orderListVo.setInterpretStaffHospitalName(doctor.getHospitalName());
      }

      result.setOrderBaseVo(orderListVo);
      List<ReportBaseVo> goodInfoByNoResultList = goodService.getReportBaseVoByOrderNo(order.getOrderNo());
      result.setGoodInfoByNoResults(goodInfoByNoResultList);
    }
//        List<ReportBaseVo> goodInfoByNoResultList = goodService.getReportBaseVoByOrderNo(order.getOrderNo());
//        result.setGoodInfoByNoResults(goodInfoByNoResultList);

//        for (AppletOrder order:orderList) {
//            OrderInterpretBaseVo baseVo = new OrderInterpretBaseVo();
//            OrderListVo orderListVo = new OrderListVo();
//            BeanUtils.copyProperties(order,orderListVo);
//            orderListVo.setOrderCompleteApplyDate(DateUtils.convertToSlashAndMinDate(order.getOrderCompleteApplyDate()));
//            if (StringUtils.isNotBlank(order.getInterpretStaffId())&&order.getInterpretStaffId().substring(0,1).equals(CommonConstants.GenerateID_STAFF)) {
//                AppletAcquisitionStaff staff = staffService.getStaffByStaffId(order.getInterpretStaffId());
//                orderListVo.set
//            } else if (StringUtils.isNotBlank(order.getInterpretStaffId())&&order.getInterpretStaffId().substring(0,1).equals(CommonConstants.GenerateID_DOCTOR)){
//                AppletDoctor doctor = doctorService.getDoctorByDoctorId(order.getInterpretStaffId());
//            }
//
//            baseVo.setOrderBaseVo(orderListVo);
//            List<ReportBaseVo> goodInfoByNoResultList = goodService.getReportBaseVoByOrderNo(order.getOrderNo());
//            baseVo.setGoodInfoByNoResults(goodInfoByNoResultList);
//            resultList.add(baseVo);
//        }
    return JsonResVo.buildSuccess(result);
  }

//    @RequestMapping(value="/query/goodReportList", method = RequestMethod.POST)
//    @ResponseBody
//    public JsonResVo queryGoodReportList(@RequestBody ReportListReq req){
//        logger.info("查询解读订单列表 "+req.toString());
//        List<GoodInfoByNoResult> goodInfoByNoResultList = goodService.getGoodPackageByNo(req.getUserId(),null);
//        return JsonResVo.buildSuccess(goodInfoByNoResultList);
//    }


  /**
   * 患者申请医生解读自带报告  上传报告图片信息接口
   */
  @ApiOperation(value = "保存客户提交的本地报告图片", notes = "保存客户提交的本地报告图片，返回结果状态map参数图片路径地址")
  @RequestMapping(value = "/uploadreport", method = RequestMethod.POST)
  @ResponseBody
  public JsonResNewVo uploadreport(MultipartFile file, HttpServletRequest request) {
    String desFilePath = "";
    String oriName = "";
    Map<String, String> dataMap = new HashMap<>();
    try {
      // 1.获取原文件名
      oriName = file.getOriginalFilename();
      // 2.获取原文件图片后缀，以最后的.作为截取(.jpg)
      String extName = oriName.substring(oriName.lastIndexOf("."));
      // 3.生成自定义的新文件名，这里以UUID.jpg|png|xxx作为格式（可选操作，也可以不自定义新文件名）
      String uuid = UUID.randomUUID().toString();
      String newName = uuid + extName;
      // 4.获取要保存的路径文件夹
      String fileSeperator = File.separator;
      String userDir = System.getProperties().getProperty("user.dir");
      //String realPath = request.getSession().getServletContext().getRealPath("resources/uploadreport/");
      //4.5 若文件夹不存在则创建
      File filedir = new File(userDir + fileSeperator + "pic" + fileSeperator + "uploadreport");
      if (!filedir.exists()) {
        filedir.mkdirs();
      }
            /*String fileSeperator = File.separator;
            String userDir = System.getProperties().getProperty("user.dir");
            String tempBatchDir = userDir+fileSeperator+"batch.pdf";*/
      // 5.保存
      desFilePath = userDir + fileSeperator + "pic" + fileSeperator + "uploadreport" + fileSeperator + newName;
      File desFile = new File(desFilePath);
      file.transferTo(desFile);
      System.out.println(desFilePath);
      // 6.返回保存结果信息
      dataMap = new HashMap<>();
      dataMap.put("src", "uploadreport/" + newName);
      dataMap.put("code", "0");
      dataMap.put("msg", oriName + "上传成功！");
      return JsonResNewVo.buildSuccess(dataMap);
    } catch (IllegalStateException e) {
      dataMap.put("code", "1");
      dataMap.put("msg", desFilePath + "图片保存失败");
      System.out.println(desFilePath + "图片保存失败");
      return JsonResNewVo.buildSuccess(dataMap);
    } catch (IOException e) {
      dataMap.put("code", "1");
      dataMap.put("msg", desFilePath + "图片保存失败--IO异常");
      System.out.println(desFilePath + "图片保存失败--IO异常");
      return JsonResNewVo.buildSuccess(dataMap);
    }
  }

  /**
   * 存储患者提交的医生咨询信息 describe 患者描述文字 goodnos 以，分隔的id字符串 srcUrls 以，分隔的患者上传图片地址字符串，从上传图片接口获取每张图片返回值 orderno  订单号 userId 用户id participantId  参检人id doctorId  医生id type  解读类型0自身患者1他人解读患者 cost  费用
   */
  @ApiOperation(value = "保存客户提交的报告相关信息", notes = "保存客户提交的报告相关信息，返回结果状态map参数")
  @ResponseBody
  @RequestMapping(value = "savereport", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  public JsonResNewVo saveImgInfo(@RequestBody @ApiParam(name = "InterpretReq", value = "客户提交的报告相关信息", required = true) InterpretReq req) {
        /*JsonResVo jsonResVo= new JsonResVo();
        System.out.println(describe); System.out.println(goodnos); System.out.println(srcUrls);
        String[] goods = goodnos.split(",");
        for (int i = 0; i < goods.length; i++) {
            System.out.println("本院检验报告单goodno："+goods[i]);
        }
        String[] urls = srcUrls.split(",");
        for (int i = 0; i < urls.length; i++) {
            System.out.println("图片名称："+urls[i]);
        }*/
    //获取解析自增序列号
    String interpretNoIndexStr;
    Integer interpretNoIndex = null;
    if (null == redisUtils.get(RedisConstants.GENERATEID + ":" + RedisConstants.INTERPRET_INDEX)) {
      redisUtils.set(RedisConstants.GENERATEID + ":" + RedisConstants.INTERPRET_INDEX, "1");
      interpretNoIndexStr = String.format("%06d", 1);
    } else {
      interpretNoIndex = Integer.parseInt(redisUtils.get(RedisConstants.GENERATEID + ":" + RedisConstants.INTERPRET_INDEX));
      interpretNoIndex++;
      boolean a = redisUtils.set(RedisConstants.GENERATEID + ":" + RedisConstants.INTERPRET_INDEX, interpretNoIndex.toString());
      if (!a) {
        logger.info("医生报告解读标签自增失败: " + interpretNoIndex);
        return null;
      }
      interpretNoIndexStr = String.format("%06d", interpretNoIndex);
    }
    String day = redisUtils.get(RedisConstants.DAY);
    if (day == null) {
      day = DateUtils.formatDayString(new Date());
    }
     String interpretNo = CommonConstants.GenerateID_INTERPRET + day + interpretNoIndexStr;
    //获取参检人信息
    List<AppletOrderParticipant> appletOrderParticipantlist = participantService.getParticipantByUserIdAndParticipantId(req.getUserId(), req.getParticipantId());
    //查询im沟通记录
    AppletImRecord appletImRecord = imRecordService.getOrInsertImRecord(appletOrderParticipantlist.get(0), req.getDoctorId());
    //存数据库
    AppletInterpret appletInterpret = new AppletInterpret();
    appletInterpret.setImRecordId(appletImRecord.getImRecordId());
    appletInterpret.setInterpretId(interpretNo);
    appletInterpret.setParticipantId(req.getParticipantId());
    appletInterpret.setParticipantName(appletOrderParticipantlist.get(0).getParticipantName());
    appletInterpret.setParticipantPhone(appletOrderParticipantlist.get(0).getParticipantPhone());
    appletInterpret.setDoctorId(req.getDoctorId());
    appletInterpret.setParticipantImg(req.getSrcUrls());
    appletInterpret.setInterpretContent("");
    appletInterpret.setInterpretStatus(0);
    appletInterpret.setInterpretType(Integer.valueOf(req.getType()));
    appletInterpret.setInterpretCost(new BigDecimal(req.getCost()));
    appletInterpret.setCreateDate(new Date());
    appletInterpret.setUpdateDate(new Date());
    appletInterpret.setDelFlag(0);
    appletInterpret.setParticipantDescribe(req.getDescribe());
    int result = appletInterpretMapper.insert(appletInterpret);
    if (StringUtils.isNotBlank(req.getGoodnos())) {
      List<String> stringList = Arrays.asList(req.getGoodnos().split(","));
      List<AppletGood> appletGoodList = goodService.getGoodByGoodNos(stringList);
      Map<String, AppletGood> goodMap = new HashMap<>();
      if (appletGoodList != null && appletGoodList.size() > 0) {
        for (AppletGood appletGood : appletGoodList) {
          goodMap.put(appletGood.getGoodNo(), appletGood);
        }
        for (String goodNo : stringList) {
          AppletInterpretGood good = new AppletInterpretGood();
          good.setInterpretId(interpretNo);
          good.setGoodNo(goodNo);
          good.setPackageId(goodMap.get(goodNo).getPackageId());
          good.setPackageName(goodMap.get(goodNo).getPackageName());
          good.setPackageNum(goodMap.get(goodNo).getPackageNum());
          good.setCreateDate(new Date());
          good.setUpdateDate(new Date());
          good.setDelFlag(CommonConstants.INIT);
          if (GoodConstants.GOOD_STATUS_REPORTED == goodMap.get(goodNo).getGoodStatus()) {
            good.setStatus(1);
          }else{
            good.setStatus(0);
          }
          int i = interpretGoodService.insertInterpretGood(good);
        }
      }
    }
    return JsonResNewVo.buildSuccess(interpretNo);
  }


  /**
   * 查询报告解读信息列表
   */
  @ApiOperation(value = "查询报告解读信息", notes = "查询报告解读信息，返回结果List数据")
  @RequestMapping(value = "/query/interpret", method = RequestMethod.POST, consumes = "application/json;charset=UTF-8")
  @ResponseBody
  public JsonResNewVo queryCustomer(@RequestBody @ApiParam(name = "DcInterpretQueryReq", value = "报告解读查询参数", required = true) DcInterpretQueryReq req) {
    logger.info("采集点查询患者列表 " + req.toString());
    AppletInterpretExample example = new AppletInterpretExample();
    AppletInterpretExample.Criteria interpretExampleCriteria = example.createCriteria();
    interpretExampleCriteria.andInterpretIdEqualTo(req.getInterpretId());
    List<AppletInterpret> aitList = appletInterpretMapper.selectByExample(example);
    return JsonResNewVo.buildSuccess(aitList);
  }


  /**
   * 根据参检人查询套餐详细信息  出报告的
   */
  @ApiOperation(value = "查询出报告的套餐详细信息", notes = "根据参检人查询出报告的套餐详细信息，返回结果List数据")
  @RequestMapping(value = "/query/goodsByPid", method = RequestMethod.GET)
  @ResponseBody
  public JsonResNewVo querygoodsByPid(@RequestParam @ApiParam(name = "participantid", value = "参检人查id", required = true) String participantid) {
    logger.info("客户端查询订单详情: " + participantid);
    List<GoodInfoByNoResult> goods = goodService.getGoodsByParticipantid(participantid);
    return JsonResNewVo.buildSuccess(goods);
  }


  /**
   * 根据参检人查询套餐详细信息  出报告的
   */
  @ApiOperation(value = "查询服务器ip", notes = "查询服务器ip")
  @RequestMapping(value = "/query/serviceIp", method = RequestMethod.GET)
  @ResponseBody
  public JsonResNewVo serviceIp() throws UnknownHostException {
    String address = InetAddress.getLocalHost().getHostAddress().toString();
    return JsonResNewVo.buildSuccess(address);
  }


}
