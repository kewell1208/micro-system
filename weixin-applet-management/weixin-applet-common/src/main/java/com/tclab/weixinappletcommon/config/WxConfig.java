package com.tclab.weixinappletcommon.config;

public class WxConfig {

  //商户号
  private static final String mch_id = "1519050351";
  //商户支付秘钥
  private static final String key = "a80405adq4091w429aea94ar26342a20";
  //小程序ID
  private static final String appID = "wxbd3c5444673a2896";
  // 小程序的secret
  private static final String secret = "53934b8cd5016a5d4c6091420d507a44";
  //    树兰环境 支付成功后的服务器回调url
//    private static final String notify_url = "https://tc.shulan.com/user/order/wxNotify";
//    测试环境 支付成功后的服务器回调url
//    private static final String notify_url = "https://www.genedoctor.org.cn/user/order/wxNotify";
//    线上环境 支付成功后的服务器回调url
 //   private static final String notify_url = "https://zhlm.genedoctor.org.cn/user/order/wxNotify";
//    IM测试环境 支付成功后的服务器回调url
  private static final String notify_url = "https://doctor.genedoctor.org.cn/user/order/wxNotify";
  //签名方式
  private static final String SIGNTYPE = "MD5";
  //交易类型
  private static final String TRADETYPE = "JSAPI";
  //微信统一下单接口地址
  private static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";
  //腾讯IM即时通讯id
  private static final Long sdkAppId = 1400269618L;
  //腾讯IM即时通讯密钥
  private static final String secretKey = "7a9161c35997caaa1e649724b795ec7e4991bc11bfa84f98ba634b3e1f503b9f";

  public static Long getSdkAppId() {
    return sdkAppId;
  }

  public static String getSecretKey() {
    return secretKey;
  }

  public static String getMch_id() {
    return mch_id;
  }

  public static String getKey() {
    return key;
  }

  public static String getAppID() {
    return appID;
  }

  public static String getSecret() {
    return secret;
  }

  public static String getNotify_url() {
    return notify_url;
  }

  public static String getSIGNTYPE() {
    return SIGNTYPE;
  }

  public static String getTRADETYPE() {
    return TRADETYPE;
  }

  public static String getPay_url() {
    return pay_url;
  }
}
