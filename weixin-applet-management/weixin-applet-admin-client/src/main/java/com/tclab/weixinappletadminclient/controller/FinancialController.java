package com.tclab.weixinappletadminclient.controller;

import com.tclab.weixinappletadminclient.model.req.QueryInvoiceReq;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import com.tclab.weixinappletcommon.utils.RedisUtils;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.InvoiceInfoVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.InvoicePageVo;
import com.tclab.weixinappletservice.model.vo.adminVo.apiVo.OrderAmountListVo;
import com.tclab.weixinappletservice.pojo.AppletOrder;
import com.tclab.weixinappletservice.pojo.AppletOrderInvoice;
import com.tclab.weixinappletservice.service.adminService.AdminInvoiceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Api(description = "财务管理模块",tags = "后台-财务管理")
@RestController
@RequestMapping(value = "/back/financial")
public class FinancialController {

    private static final Logger logger = LoggerFactory.getLogger(FinancialController.class);

    @Autowired
    private AdminInvoiceService adminInvoiceService;
    @Autowired
    private RedisUtils redisUtils;

    @ApiOperation(value = "查询开票记录列表" ,  notes="查询开票记录列表")
    @RequestMapping(value="/invoice/queryList", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<InvoicePageVo> queryInvoiceList(@ApiParam(name="queryInvoiceReq",value="查询参数",required=true) QueryInvoiceReq req){
        logger.info("后台查询开票记录: " + req.toString());
        return JsonResNewVo.buildSuccess(adminInvoiceService.getInvoiceApplyList(req.getUserName(),req.getUserPhone(),req.getDealStatus(),req.getPageNo(),req.getPageSize()));
    }

    @ApiOperation(value = "查询开票详情" ,  notes="查询开票详情")
    @RequestMapping(value="/invoice/queryInfo", method = RequestMethod.GET)
    @ResponseBody
    public JsonResNewVo<InvoiceInfoVo> queryInvoiceInfo(@ApiParam(name="queryInvoiceReq",value="查询参数",required=true) QueryInvoiceReq req){
        logger.info("后台查询开票详情: " + req.toString());

        AppletOrderInvoice invoice = adminInvoiceService.getInvoiceByApplyId(req.getApplyId());
        if (invoice==null){
            logger.info("后台查询开票详情结果为空: " + req.getApplyId());
            return JsonResNewVo.buildErrorResult(ErrorEnum.OBJECT_ERROR_EMPTY.getErrorCode(),"开票信息为空");
        }
        List<AppletOrder> orderList = adminInvoiceService.getOrderByInvoiceId(req.getApplyId());

        InvoiceInfoVo infoVo = new InvoiceInfoVo();
        BeanUtils.copyProperties(invoice,infoVo);
        infoVo.setApplyDate(DateUtils.convertToSlashAndMinDate(invoice.getApplyDate()));
        List<OrderAmountListVo> orderAmountListVoList = new ArrayList<>();
        for (AppletOrder order:orderList) {
            OrderAmountListVo listVo = new OrderAmountListVo();
            BeanUtils.copyProperties(order,listVo);
            listVo.setCreateDate(DateUtils.convertToSlashAndMinDate(order.getCreateDate()));
            orderAmountListVoList.add(listVo);
        }
        infoVo.setOrderAmountListVoList(orderAmountListVoList);

        return JsonResNewVo.buildSuccess(infoVo);
    }

    @ApiOperation(value = "上传发票" ,  notes="上传发票")
    @RequestMapping(value="/invoice/upload", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo uploadInvoice(@ApiParam(name="queryInvoiceReq",value="查询参数",required=true) QueryInvoiceReq req){
        logger.info("后台上传图片: " + req.toString());
        return JsonResVo.buildSuccess(adminInvoiceService.uploadInvoice(req.getApplyId(),req.getInvoiceUrl()));
    }

    @ApiOperation(value = "确认重新发送发票" ,  notes="确认重新发送发票")
    @RequestMapping(value="/invoice/checkReStart", method = RequestMethod.GET)
    @ResponseBody
    public JsonResVo checkReStart(@ApiParam(name="queryInvoiceReq",value="查询参数",required=true) QueryInvoiceReq req){
        logger.info("后台上传图片: " + req.toString());
        return JsonResVo.buildSuccess(adminInvoiceService.checkRestartInvoice(req.getApplyId()));
    }

    @Value("${image.resource.location}")
    private String imageResourcelocation;

//    @RequestMapping(value = "/uploadPDF2Img",method = RequestMethod.POST)
//    @ResponseBody
//    public JsonResVo uploadPDF2Img(HttpServletRequest request) {
//
//        logger.info("上传PDF并准换成图片");
//
//        logger.info("文件名");
//        StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
//        for (Map.Entry<String, MultipartFile> entry:req.getFileMap().entrySet()) {
//            logger.info("key------"+entry.getKey());
//            logger.info("value------"+entry.getValue());
//        }
//        MultipartFile image = req.getFile("file");
//
//        logger.info("PDF名: "+image.getOriginalFilename());
//
//        //判断图片地址是否存在
//        String picPath = imageResourcelocation;
//        File picsdir = new File(picPath);
//        if (!picsdir.exists() && !picsdir.isDirectory()) {
//            picsdir.mkdirs();
//        }
//
//        String day = redisUtils.get(RedisConstants.DAY);
//        if (StringUtils.isBlank(day)){
//            day = DateUtils.formatDayString(new Date());
//        }
//
//        List<String> pdfImgList = new ArrayList<>();
//
//        //插入图片
//        String sign = NumberGeneratorUtils.generateDate();
//        try {
//            if (image != null) {
//                String infoImageOriginalFilename = image.getOriginalFilename();
//                String suffixName = infoImageOriginalFilename.substring(infoImageOriginalFilename.lastIndexOf(".") + 1);
//                if (suffixName.equals("pdf")){
//                    logger.info("上传PDF文件");
//                    pdfImgList = PdfToImageUtils.pdf2ImgByIcePDF(imageResourcelocation+"/pdf/"+sign,image,sign);
//                    return JsonResVo.buildSuccess("/pdf/"+pdfImgList.get(0));
//                }
//            }
//        } catch (Exception e) {
//            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(), "上传失败");
//        }
//        return JsonResVo.buildSuccess(sign);
//    }
}
