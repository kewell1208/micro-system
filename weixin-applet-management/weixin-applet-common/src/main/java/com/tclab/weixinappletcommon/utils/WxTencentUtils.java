package com.tclab.weixinappletcommon.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tclab.weixinappletcommon.config.WxConfig;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @Package：com.tclab.weixinappletcommon.utils
 * @Class：WX
 * @Description： TODO
 * @Author：dcd
 * @Date：Created in 2019/9/11 3:31 PM
 * @Company:
 * @Version：
 * @Modified By:
 */
@Component
public class WxTencentUtils {

  private static final Logger logger = LoggerFactory.getLogger(WxTencentUtils.class);


  private static String appId = "wx960fb9008e7ad9ed";
  private static String secret = "0259a70b83b0f52b132c6fb54178fc27";
  private static String reportTemplate = "fGnkPzqBRUZwwHNfTltZKZ6O8UHR9qT2-gf8wH260Gc";

  public static String getReportTemplate() {
    return reportTemplate;
  }

  public static void setReportTemplate(String reportTemplate) {
    WxTencentUtils.reportTemplate = reportTemplate;
  }

  private static String qrPath = "/home/tclab/pic/qr/";


  @Autowired
  private RedisUtils redisUtils;

  /**
   * 判断用户是否关注了公众号
   */
  public boolean judgeIsFollow(String openid) {
    Integer subscribe = 0;
    String token = getToken();
    String url = "https://api.weixin.qq.com/cgi-bin/user/info?access_token=" + token + "&openid=" + openid + "&lang=zh_CN";
    try {
      URL urlGet = new URL(url);
      HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();
      http.setRequestMethod("GET"); // 必须是get方式请求
      http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      http.setDoOutput(true);
      http.setDoInput(true);
      http.connect();
      InputStream is = http.getInputStream();
      int size = is.available();
      byte[] jsonBytes = new byte[size];
      is.read(jsonBytes);
      String message = new String(jsonBytes, "UTF-8");
      JSONObject demoJson = JSONObject.parseObject(message);
      subscribe = demoJson.getInteger("subscribe");

      is.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 1 == subscribe ? true : false;
  }

  private String getToken() {
      String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + WxConfig.getAppID() + "&secret=" + WxConfig.getSecret();
      try {
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(url);
        getMethod.releaseConnection();
        httpClient.executeMethod(getMethod);
        String result = getMethod.getResponseBodyAsString();
        JSONObject jsonObject = JSONObject.parseObject(result);
        String token = (String) jsonObject.get("access_token");
        Long expires = Long.valueOf((int) jsonObject.get("expires_in"));
        return token;
      } catch (IOException e) {
        e.printStackTrace();
      }
      return null;
  }

  /**
   * 推送消息到公众号
   */
  public static void pushMessage(String openId, String templateId) {
    //1，配置
    WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
    wxStorage.setAppId(appId);
    wxStorage.setSecret(secret);
    WxMpService wxMpService = new WxMpServiceImpl();
    wxMpService.setWxMpConfigStorage(wxStorage);

    //2,推送消息
    WxMpTemplateMessage templateMessage = WxMpTemplateMessage.builder()
        .toUser(openId)//要推送的用户openid
        .templateId(templateId)//模版id
        .url("https://www.baidu.com")//点击模版消息要访问的网址
        .build();
    //3,如果是正式版发送模版消息，这里需要配置你的信息
    //       templateMessage.addData(new WxMpTemplateData("first", "aaaaaaaaaaaa", "#FF00FF"));
    //                templateMessage.addData(new WxMpTemplateData(name2, value2, color2));
    try {
      wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
    } catch (Exception e) {
      logger.error("推送失败：" + e.getMessage());
      e.printStackTrace();
    }

  }

  public static String sendImMessage(String doctorId, String userId, List<Map<String, Object>> msgBody) {
    try {
      Map<String, Object> map = new HashMap<>();
      map.put("SyncFromOldSystem", 1);
      map.put("From_Account", userId);
      map.put("To_Account", doctorId);
      map.put("MsgRandom", (int) ((Math.random() * 9 + 1) * 1000000));
      map.put("MsgTimeStamp", System.currentTimeMillis() / 1000);
      map.put("MsgBody", msgBody);

      TLSSigAPIv2 tlsSigAPIv2 = new TLSSigAPIv2(WxConfig.getSdkAppId(), WxConfig.getSecretKey());
      String userSig = tlsSigAPIv2.genSig("admin", 2592000L);
      String result = CommonHttpClientUtils
          .postMethodClient(JSON.toJSONString(map),
              "https://console.tim.qq.com/v4/openim/importmsg?sdkappid=" + WxConfig.getSdkAppId() + "&identifier=admin&usersig=" + userSig + "&random=" + (int) ((Math.random() * 9 + 1) * Math
                  .pow(10, 32)) + "&contenttype=json");
      System.out.println(result);
      JSONObject jsonObject = JSONObject.parseObject(result);
      if (!"OK".equals(jsonObject.get("ActionStatus"))) {
        logger.error("发送IM聊天失败：" + result);
        return "0";
      } else {
        return "1";
      }
    } catch (Exception e) {
      logger.error("IM发送报告解读消息失败");
      return "0";
    }
  }


  public Map getminiqrQr(String data,String name) {
    RestTemplate rest = new RestTemplate();
    InputStream inputStream = null;
    OutputStream outputStream = null;
    try {
      String url = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=" + getToken();
      Map<String, Object> param = new HashMap<>();
      param.put("scene", data);
      param.put("page", "pages/store/store");
      param.put("width", 430);
      param.put("auto_color", false);
      Map<String, Object> line_color = new HashMap<>();
      line_color.put("r", 0);
      line_color.put("g", 0);
      line_color.put("b", 0);
      param.put("line_color", line_color);
      MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
      HttpEntity requestEntity = new HttpEntity(param, headers);
      ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
      byte[] result = entity.getBody();
      inputStream = new ByteArrayInputStream(result);

      File file = new File(qrPath + name + ".png");
      if (!file.exists()) {
        file.createNewFile();
      }
      outputStream = new FileOutputStream(file);
      int len = 0;
      byte[] buf = new byte[1024];
      while ((len = inputStream.read(buf, 0, 1024)) != -1) {
        outputStream.write(buf, 0, len);
      }
      outputStream.flush();
    } catch (Exception e) {
      logger.error("调用小程序生成微信永久小程序码URL接口异常", e);
    } finally {
      if (inputStream != null) {
        try {
          inputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (outputStream != null) {
        try {
          outputStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return null;
  }
}