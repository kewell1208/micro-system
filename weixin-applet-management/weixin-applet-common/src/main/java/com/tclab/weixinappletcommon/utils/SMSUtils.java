package com.tclab.weixinappletcommon.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

//@Component
public class SMSUtils {

    private static final Logger logger = LoggerFactory.getLogger(SMSUtils.class);

//    static String accessKeyId = "LTAI6Kqqu36mzwAZ";
    static String accessKeyId = "LTAIMwEK5REWq5A9";
//    static String accessKeySecret = "dhnVLJnYEz4KeflSewMpAIlsDErAPO";
    static String accessKeySecret = "WX7qQSqtOei4Z6fateTrfrH9JINADB";
//    static String signName = "智烁医疗";
    static String signName = "同创医疗";
    //注册
//    public static String templateCodeRegisterNew = "SMS_162480868";
    //注册
//    public static String templateCodeChangePassword = "SMS_136680101";
    //同创物流
//    public static String templateCodeTcLogistics = "SMS_164245056";
    //同创物流
//    public static String templateCodeApplyOrder = "SMS_164266014";
    //同创物流
//    public static String templateCodeSelfOrder = "SMS_164185382";

    public static String templateCodeRegisterNew = "SMS_165060675";
    public static String templateCodeChangePassword = "SMS_165060681";
    public static String templateCodeTcLogistics = "SMS_165060833";
    public static String templateCodeApplyOrder = "SMS_165070534";
    public static String templateCodeSelfOrder = "SMS_165070537";
    /*客户端已出报告通知*/
    public static String templateCodeOutOrder = "SMS_175070084";
    /*客户端已出报告通知医生*/
    public static String templateCodeOutOrderDoc = "SMS_175125491";
    /*医生付费服务通知*/
    public static String templateCodeNotifyImRecord2Doctor = "SMS_175121317";


    public static String splitParam(Map<String,String> map){
        StringBuffer stringBuffer = new StringBuffer();
        String str;
        for (Map.Entry<String, String> entry:map.entrySet()) {
            stringBuffer.append("\""+entry.getKey()+"\"");
            stringBuffer.append(":");
            stringBuffer.append("\""+entry.getValue()+"\"");
            stringBuffer.append(",");
        }
        if (stringBuffer.length()!=0){
            str = stringBuffer.substring(0,stringBuffer.length()-1);
            return "{"+str+"}";
        } else {
            return null;
        }
    }

    public static boolean sendSms(String phone,Map<String,String> map,String templateCode){

        String paramStr = splitParam(map);
        if (paramStr==null){
            logger.info("短信发送参数为空: "+phone);
            return false;
        }

        DefaultProfile profile = DefaultProfile.getProfile("default",accessKeyId,accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCode);
        request.putQueryParameter("TemplateParam", paramStr);
        try {
            //发送短信
            CommonResponse response = client.getCommonResponse(request);
            String responeStr = response.getData();

            logger.info("手机号: "+phone+" 短信参数信息: "+paramStr);
            logger.info("短信发送返回结果: "+responeStr);

            JSONObject jsonObject = JSONObject.parseObject(responeStr);
            String code = jsonObject.getString("Code");
            if (code.equals("OK")){
                logger.info("短信发送成功: "+phone);
                return true;
            } else {
                logger.info("短信发送失败: "+phone);
                return false;
            }
        } catch (ServerException e) {
            e.printStackTrace();
            logger.info("短信发送失败: "+phone+" 服务器异常");
            return false;
        } catch (ClientException e) {
            logger.info("短信发送失败: "+phone+" 客户端异常");
            e.printStackTrace();
            return false;
        } catch (Exception e){
            logger.info("短信发送失败: "+phone+" 系统错误");
            e.printStackTrace();
            return false;
        }
    }

    public static boolean sendSmsForRegister(String phone,String verifyCode){

        DefaultProfile profile = DefaultProfile.getProfile("default",accessKeyId,accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setMethod(MethodType.POST);
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", signName);
        request.putQueryParameter("TemplateCode", templateCodeRegisterNew);
        request.putQueryParameter("TemplateParam", "{\"code\":\""+verifyCode+"\"}");
        try {
            //发送短信
            CommonResponse response = client.getCommonResponse(request);
            String responeStr = response.getData();

            logger.info("手机号: "+phone+" 验证码: "+verifyCode);
            logger.info("短信发送信息: "+responeStr);

            JSONObject jsonObject = JSONObject.parseObject(responeStr);
            String code = jsonObject.getString("Code");
            if (code.equals("OK")){
                return true;
            } else {
                return false;
            }
        } catch (ServerException e) {
            e.printStackTrace();
            return false;
        } catch (ClientException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

//    public static boolean sendSmsForTcLogistics(String phone,String logisticsId,String acquisitionName,String operatorPhone){
//
//        DefaultProfile profile = DefaultProfile.getProfile("default",accessKeyId,accessKeySecret);
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//        request.putQueryParameter("PhoneNumbers", phone);
//        request.putQueryParameter("SignName", signName);
//        request.putQueryParameter("TemplateCode", templateCodeTcLogistics);
//        request.putQueryParameter("TemplateParam", "{\"code\":\""+logisticsId+"\",\"address\":\""+acquisitionName+"\",\"phone\":\""+operatorPhone+"\"}");
//        try {
//            //发送短信
//            CommonResponse response = client.getCommonResponse(request);
//            String responeStr = response.getData();
//
//            logger.info("手机号: "+phone+" 参数: "+"{\"code\":\""+logisticsId+"\",\"address\":\""+acquisitionName+"\",\"phone\":\""+operatorPhone+"\"}");
//            logger.info("短信发送信息: "+responeStr);
//
//            JSONObject jsonObject = JSONObject.parseObject(responeStr);
//            String code = jsonObject.getString("Code");
//            if (code.equals("OK")){
//                return true;
//            } else {
//                return false;
//            }
//        } catch (ServerException e) {
//            e.printStackTrace();
//            return false;
//        } catch (ClientException e) {
//            e.printStackTrace();
//            return false;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static boolean sendSmsForApplyOrder(String phone,String logisticsId,String acquisitionName,String operatorPhone){
//
//        DefaultProfile profile = DefaultProfile.getProfile("default",accessKeyId,accessKeySecret);
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//        request.putQueryParameter("PhoneNumbers", phone);
//        request.putQueryParameter("SignName", signName);
//        request.putQueryParameter("TemplateCode", templateCodeApplyOrder);
//        request.putQueryParameter("TemplateParam", "{\"date\":\"2019/04/26\",\"address\":\"树兰风景门诊\"}");
//        try {
//            //发送短信
//            CommonResponse response = client.getCommonResponse(request);
//            String responeStr = response.getData();
//
//            logger.info("手机号: "+phone+" 参数: "+"{\"code\":\""+logisticsId+"\",\"address\":\""+acquisitionName+"\",\"phone\":\""+operatorPhone+"\"}");
//            logger.info("短信发送信息: "+responeStr);
//
//            JSONObject jsonObject = JSONObject.parseObject(responeStr);
//            String code = jsonObject.getString("Code");
//            if (code.equals("OK")){
//                return true;
//            } else {
//                return false;
//            }
//        } catch (ServerException e) {
//            e.printStackTrace();
//            return false;
//        } catch (ClientException e) {
//            e.printStackTrace();
//            return false;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public static boolean sendSmsForSelfOrder(String phone,String orderNo){
//
//        DefaultProfile profile = DefaultProfile.getProfile("default",accessKeyId,accessKeySecret);
//        IAcsClient client = new DefaultAcsClient(profile);
//
//        CommonRequest request = new CommonRequest();
//        request.setMethod(MethodType.POST);
//        request.setDomain("dysmsapi.aliyuncs.com");
//        request.setVersion("2017-05-25");
//        request.setAction("SendSms");
//        request.putQueryParameter("PhoneNumbers", phone);
//        request.putQueryParameter("SignName", signName);
//        request.putQueryParameter("TemplateCode", templateCodeSelfOrder);
//        request.putQueryParameter("TemplateParam", "{\"orderNo\":\""+orderNo+"\"}");
//        try {
//            //发送短信
//            CommonResponse response = client.getCommonResponse(request);
//            String responeStr = response.getData();
//
//            logger.info("手机号: "+phone+" 参数: "+"{\"orderNo\":\""+orderNo+"\"}");
//            logger.info("短信发送信息: "+responeStr);
//
//            JSONObject jsonObject = JSONObject.parseObject(responeStr);
//            String code = jsonObject.getString("Code");
//            if (code.equals("OK")){
//                return true;
//            } else {
//                return false;
//            }
//        } catch (ServerException e) {
//            e.printStackTrace();
//            return false;
//        } catch (ClientException e) {
//            e.printStackTrace();
//            return false;
//        } catch (Exception e){
//            e.printStackTrace();
//            return false;
//        }
//    }
}
