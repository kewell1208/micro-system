package com.tclab.weixinappletcommon.utils;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonHttpClientUtils {

    private static final Logger logger = LoggerFactory.getLogger(CommonHttpClientUtils.class);


    /**
     *
     * @param jsonStr 参数
     * @param methodUrl 方法地址
     * @return
     */
    public static String postMethodClient(String jsonStr, String methodUrl) {
        try {
            HttpClient httpClient = new HttpClient();
            // 设置连接超时时间(单位毫秒)
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
            // 设置读数据超时时间(单位毫秒)
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(9000);

            httpClient.getHostConfiguration().setHost(methodUrl);
            PostMethod method = new PostMethod(methodUrl);
            RequestEntity requestEntity = new StringRequestEntity(jsonStr, "application/json", "UTF-8");
            method.setRequestEntity(requestEntity);
            method.releaseConnection();
            httpClient.executeMethod(method);
//            InputStream inputStream = method.getResponseBodyAsStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            StringBuffer stringBuffer = new StringBuffer();
//            while (!"".equals(null2String(bufferedReader.readLine()))){
//                stringBuffer.append(bufferedReader.readLine());
//            }
//            return stringBuffer.toString();
            String inputStream = method.getResponseBodyAsString();
            return inputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String null2String(String s){
        if (StringUtils.isBlank(s)) {
            return "";
        } else {
            return s;
        }
    }

    public static String postMethodClient(String methodUrl) {
        try {
            HttpClient httpClient = new HttpClient();
            // 设置连接超时时间(单位毫秒)
            httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(3000);
            // 设置读数据超时时间(单位毫秒)
            httpClient.getHttpConnectionManager().getParams().setSoTimeout(9000);

            httpClient.getHostConfiguration().setHost(methodUrl);
            PostMethod method = new PostMethod(methodUrl);
            method.releaseConnection();
            httpClient.executeMethod(method);
            String inputStream = method.getResponseBodyAsString();
            return inputStream;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
