package com.tclab.weixinappletuserclient.controller.front.doctor_client;

import static com.tclab.weixinappletcommon.constant.ErrorEnum.SYSTEM_ERROR;

import com.tclab.weixinappletcommon.model.vo.JsonResNewVo;
import com.tclab.weixinappletcommon.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.io.File;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Package：com.tclab.weixinappletuserclient.controller.front.doctor_client
 * @Class：DcUploadController
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/18 2:46 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Api(tags = "IM聊天")
@Controller
@RequestMapping("/doctor")
public class DcUploadController {

  private static final Logger logger = LoggerFactory.getLogger(DcUploadController.class);

  @Value("${tclab.im.voice.path}")
  private String path;

  @ApiOperation(value = "上传语音", notes = "上传语音")
  @RequestMapping(value = "/voiceUpload", method = RequestMethod.POST)
  @ResponseBody
  public JsonResNewVo voiceUpload(@RequestParam("file") MultipartFile[] files) {
    logger.info("上传语音...");
    if (files != null && files.length >= 1) {
      try {
        String fileName = System.currentTimeMillis() + "" + (int)((Math.random() * 9 + 1) * 100000) +".mp3";
        String uploadPath = DateUtils.formatDate(new Date(), "yyyyMMdd") + "/" + fileName;
        //判断是否有文件
        if (StringUtils.isNoneBlank(fileName)) {
          //输出到本地路径
          File outFile = new File(path + "/" + uploadPath);
          FileUtils.copyInputStreamToFile(files[0].getInputStream(), outFile);
          return JsonResNewVo.buildSuccess("/voice/" + uploadPath);
        }
      } catch (Exception e) {
        e.printStackTrace();
        logger.info("上传语音失败:" + e.getMessage());
      }
    }
    return JsonResNewVo.buildFail(SYSTEM_ERROR);
  }

}
