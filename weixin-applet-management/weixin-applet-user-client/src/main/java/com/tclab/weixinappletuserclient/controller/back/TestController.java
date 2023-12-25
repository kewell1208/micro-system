package com.tclab.weixinappletuserclient.controller.back;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.tclab.weixinappletcommon.constant.ErrorEnum;
import com.tclab.weixinappletcommon.constant.RedisConstants;
import com.tclab.weixinappletservice.service.clientService.GoodService;
import com.tclab.weixinappletservice.service.clientService.InvoiceService;
import com.tclab.weixinappletservice.service.clientService.PayService;
import com.tclab.weixinappletservice.service.clientService.UserService;
import com.tclab.weixinappletuserclient.model.req.apiReq.DemoReq;
import com.tclab.weixinappletcommon.model.vo.JsonResVo;
import com.tclab.weixinappletservice.pojo.AppletAcquisition;
import com.tclab.weixinappletservice.pojo.AppletAcquisitionExample;
import com.tclab.weixinappletservice.pojo.AppletUser;
import com.tclab.weixinappletcommon.utils.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/test", method = RequestMethod.POST)
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Value("${image.resource.location}")
    private String imageResourcelocation;

    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private UserService userService;
    @Autowired
    private PayService payService;
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private GoodService goodService;

//    @RequestMapping(value = "/redis/set", consumes = "application/json;charset=UTF-8")
//    @ResponseBody
    public JsonResVo testRedisSet(@RequestBody DemoReq req) {

        logger.info("打印属性: " + imageResourcelocation);
        logger.info("打印请求 key: " + req.getKey());
        logger.info("打印请求 value: " + req.getValue());

        return JsonResVo.buildSuccess(redisUtils.set(req.getKey(), req.getValue()));
    }

//    @RequestMapping(value = "/redis/get", consumes = "application/json;charset=UTF-8")
//    @ResponseBody
    public JsonResVo testGet(@RequestBody DemoReq req) {
        return JsonResVo.buildSuccess(redisUtils.get(req.getKey()));
    }

//    @RequestMapping(value = "/db/get", consumes = "application/json;charset=UTF-8")
//    @ResponseBody
    public JsonResVo testDB(@RequestBody DemoReq req) {

        AppletUser user = new AppletUser();
        user.setUserName("徐天宝");
        String id = userService.addUser(user, null);

        return JsonResVo.buildSuccess(id);
    }

    @RequestMapping(value = "/json/edit", consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public JsonResVo testJSON(@RequestBody DemoReq req) {

        AppletAcquisitionExample acquisitionExample = new AppletAcquisitionExample();
        AppletAcquisitionExample.Criteria criteria = acquisitionExample.createCriteria();
        criteria.andAcquisitionIdEqualTo(req.getKey());
        AppletAcquisition acquisition = new AppletAcquisition();

        JsonObject object = new JsonObject();
        object.addProperty("Longitude", 30.3360347317);
        object.addProperty("latitude", 120.1814919851);
//        acquisition.setAcquisitionCoordinate(object.toString());
//        int i = acquisitionMapper.updateByExampleSelective(acquisition,acquisitionExample);

        String locationStr = object.toString();

        logger.info(locationStr);

        JSONObject jsonObject = JSONObject.parseObject(locationStr);

        logger.info(jsonObject.getDouble("Longitude").toString());

        Double longitude1 = jsonObject.getDouble("Longitude");
        Double latitude1 = jsonObject.getDouble("latitude");

        logger.info(longitude1.toString());
        logger.info(latitude1.toString());

        Double distance = LocationUtils.getDistance(latitude1, longitude1, 40, 50);


        return JsonResVo.buildSuccess(distance);
    }

//    @RequestMapping(value = "/pay/edit")
//    @ResponseBody
    public JsonResVo testPay(HttpServletRequest req) {

        logger.info("微信支付测试");

        String orderNo = req.getParameter("outOrderNo");
        String openid = req.getParameter("openid");
        String goodName = req.getParameter("goodName");

        logger.info("参数  " + orderNo + "   " + openid + "  " + goodName);

        Map<String, Object> preResult = payService.wxPay(openid, orderNo, goodName, null, req);
        return JsonResVo.buildSuccess(preResult);
    }

    @RequestMapping(value = "/uploadImg")
    @ResponseBody
    public JsonResVo testUploadImg(HttpServletRequest request,@RequestParam("image")MultipartFile image) {

        logger.info("上传图片");

//        StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
//        MultipartFile image = req.getFile("image");

        logger.info("图片名: "+image.getOriginalFilename());

        //判断图片地址是否存在
        String picPath = imageResourcelocation;
        File picsdir = new File(picPath);
        if (!picsdir.exists() && !picsdir.isDirectory()) {
            picsdir.mkdirs();
        }

        String day = redisUtils.get(RedisConstants.DAY);
        if (StringUtils.isBlank(day)){
            day = DateUtils.formatDayString(new Date());
        }

        //插入图片
        String sign = NumberGeneratorUtils.generateDate();
        try {
            if (image != null) {
                String infoImageOriginalFilename = image.getOriginalFilename();
                String suffixName = infoImageOriginalFilename.substring(infoImageOriginalFilename.lastIndexOf(".") + 1);
                if (ImageUtils.checkImagesuffixNameFormat(suffixName)) {
                    sign = NumberGeneratorUtils.generateDate();
                    File infoDest = new File(picsdir + "/"+day+"/"+sign+ "."+suffixName);
                    if (!infoDest.getParentFile().exists()) {
                        infoDest.getParentFile().mkdir();
                    }
                    image.transferTo(infoDest);
                    sign = "/"+day+"/"+sign+ "."+suffixName;
                }
            }
        } catch (IOException e) {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(), "图片上传失败");
        }
        return JsonResVo.buildSuccess(sign);
    }

    @RequestMapping(value = "/uploadImgN")
    @ResponseBody
    public JsonResVo testUploadImgNew(HttpServletRequest request) {

        logger.info("上传图片非微信方式");

        logger.info("文件名");
        StandardMultipartHttpServletRequest req = (StandardMultipartHttpServletRequest) request;
        for (Map.Entry<String, MultipartFile> entry:req.getFileMap().entrySet()) {
            logger.info("key------"+entry.getKey());
            logger.info("value------"+entry.getValue());
        }
        MultipartFile image = req.getFile("file");

        logger.info("图片名: "+image.getOriginalFilename());

        //判断图片地址是否存在
        String picPath = imageResourcelocation;
        File picsdir = new File(picPath);
        if (!picsdir.exists() && !picsdir.isDirectory()) {
            picsdir.mkdirs();
        }

        String day = redisUtils.get(RedisConstants.DAY);
        if (StringUtils.isBlank(day)){
            day = DateUtils.formatDayString(new Date());
        }

        List<String> pdfImgList = new ArrayList<>();

        //插入图片
        String sign = NumberGeneratorUtils.generateDate();
        try {
            if (image != null) {
                String infoImageOriginalFilename = image.getOriginalFilename();
                String suffixName = infoImageOriginalFilename.substring(infoImageOriginalFilename.lastIndexOf(".") + 1);
                if (ImageUtils.checkImagesuffixNameFormat(suffixName)) {
                    sign = NumberGeneratorUtils.generateDate();
                    File infoDest = new File(picsdir + "/"+day+"/"+sign+ "."+suffixName);
                    if (!infoDest.getParentFile().exists()) {
                        infoDest.getParentFile().mkdir();
                    }
                    image.transferTo(infoDest);
                    sign = "/"+day+"/"+sign+ "."+suffixName;
                } else if (suffixName.equals("pdf")){
                    logger.info("上传PDF文件");
                    String pdfSign = NumberGeneratorUtils.generateDate();
                    pdfImgList = PdfToImageUtils.pdf2ImgByFile(pdfSign,imageResourcelocation+"/pdf","png",image);
                    return JsonResVo.buildSuccess("/pdf/"+pdfImgList.get(0));
                }
            }
        } catch (Exception e) {
            return JsonResVo.buildErrorResult(ErrorEnum.SERVICE_ERROR.getErrorCode(), "上传失败");
        }
        return JsonResVo.buildSuccess(sign);
    }

//    @RequestMapping(value = "/sum/amount", consumes = "application/json;charset=UTF-8")
//    @ResponseBody
    public JsonResVo testAmount(@RequestBody DemoReq req) {
        List<String> orderNoList = new ArrayList<>();
        orderNoList.add("E20190708000003");
        orderNoList.add("E20190708000004");
        return JsonResVo.buildSuccess(invoiceService.getRefundAmount(orderNoList));
    }

}
