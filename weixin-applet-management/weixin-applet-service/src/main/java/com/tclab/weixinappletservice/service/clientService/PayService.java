package com.tclab.weixinappletservice.service.clientService;

import com.tclab.weixinappletcommon.config.WxConfig;
import com.tclab.weixinappletcommon.utils.IpUtils;
import com.tclab.weixinappletcommon.utils.PayUtils;
import com.tclab.weixinappletcommon.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class PayService {

    private static final Logger logger = LoggerFactory.getLogger(PayService.class);

    public Map<String, Object> wxPay(String openid, String orderNo, String goodName, String payAmount, HttpServletRequest request){
        try{

            logger.info("微信支付开始");

            //生成的随机字符串
            String nonce_str = StringUtils.getRandomStringByLength(32);

            logger.info("微信支付生成的随机字符串"+nonce_str);

            //商品名称
//            String body = "同创质检测试商品名称";
            //订单价格
//            if (payAmount!=null){
//                String payAmount = payAmount.toString();
//            }
            //获取客户端的ip地址
            String spbill_create_ip = IpUtils.getIpAddrNew(request);

            logger.info("微信支付获取发起端的ip地址"+spbill_create_ip);

            //因为微信支付系统会根据订单号和body生成一条记录，这样会导致很多信息上误判，所以每次支付传入的订单号尽量不一样
            long orderSign = new Date().getTime();
            orderNo = orderNo+"_"+orderSign;

            //组装参数，用户生成统一下单接口的签名
            Map<String, String> packageParams = new HashMap<String, String>();
            packageParams.put("appid", WxConfig.getAppID());
            packageParams.put("mch_id", WxConfig.getMch_id());
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", goodName);
            packageParams.put("out_trade_no", orderNo);//商户订单号
            packageParams.put("total_fee", payAmount);//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("spbill_create_ip", spbill_create_ip);//客户端IP
            packageParams.put("notify_url", WxConfig.getNotify_url());//支付成功后的回调地址
            packageParams.put("trade_type", WxConfig.getTRADETYPE());//支付方式
            packageParams.put("openid", openid);

            String prestr = PayUtils.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

            logger.info("prestr "+prestr);

            //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
            //String mysign = PayUtils.sign(prestr, WxPayConfig.key, "utf-8").toUpperCase();
            String mysign = PayUtils.sign(prestr, WxConfig.getKey(), "utf-8").toUpperCase();

            logger.info("mysign "+mysign);

            //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
            String xml = "<xml>" + "<appid>" + WxConfig.getAppID() + "</appid>"
                    //+ "<body><![CDATA[" + body + "]]></body>"
                    + "<body>" + goodName + "</body>"
                    + "<mch_id>" + WxConfig.getMch_id() + "</mch_id>"
                    + "<nonce_str>" + nonce_str + "</nonce_str>"
                    + "<notify_url>" + WxConfig.getNotify_url() + "</notify_url>"
                    + "<openid>" + openid + "</openid>"
                    + "<out_trade_no>" + orderNo + "</out_trade_no>"
                    + "<spbill_create_ip>" + spbill_create_ip + "</spbill_create_ip>"
                    + "<total_fee>" + payAmount + "</total_fee>"
                    + "<trade_type>" + WxConfig.getTRADETYPE() + "</trade_type>"
                    + "<sign>" + mysign + "</sign>"
                    + "</xml>";

            logger.info("调试模式_统一下单接口 请求XML数据：" + xml);

            //调用统一下单接口，并接受返回的结果
            String result = PayUtils.httpRequest(WxConfig.getPay_url(), "POST", xml);

            logger.info("调试模式_统一下单接口 返回XML数据：" + result);

            // 将解析结果存储在HashMap中
            Map map = PayUtils.doXMLParse(result);

            String return_code = (String) map.get("return_code");//返回状态码
            String result_code = (String) map.get("result_code");//返回业务码

            Map<String, Object> response = new HashMap<String, Object>();//返回给小程序端需要的参数
            if(org.apache.commons.lang3.StringUtils.isNotBlank(return_code)&&return_code.equals("SUCCESS")&&result_code.equals("SUCCESS")){
                logger.info("微信服务器返回支付结果:成功");
                String prepay_id = (String) map.get("prepay_id");//返回的预付单信息
                response.put("nonceStr", nonce_str);
                response.put("package", "prepay_id=" + prepay_id);
                Long timeStamp = System.currentTimeMillis() / 1000;
                response.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                //拼接签名需要的参数
                String stringSignTemp = "appId=" + WxConfig.getAppID() + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id+ "&signType=MD5&timeStamp=" + timeStamp;
                //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                String paySign = PayUtils.sign(stringSignTemp, WxConfig.getKey(), "utf-8").toUpperCase();

                logger.info("paySign "+paySign);

                response.put("paySign", paySign);
            } else {
                if (return_code.equals("SUCCESS")&&result_code.equals("FAIL")) {
                    String err_code_des = (String) map.get("err_code_des");
                    logger.info("微信服务器返回支付结果:失败" + " 错误原因:" + err_code_des);
                    throw new RuntimeException("微信服务器返回支付结果:失败" + " 错误原因:" + err_code_des);
                } else {
                    logger.info("微信支付通讯失败");
                    throw new RuntimeException("微信支付通讯失败");
                }
            }

            response.put("appid", WxConfig.getAppID());

            return response;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
