package com.tclab.weixinappletcommon.constant;

public class GoodConstants {

    //未支付
    public static final int GOOD_STATUS_UNPAY = 0;
    //未采集
    public static final int GOOD_STATUS_UNCOLLECT = 1;
    //已采集
    public static final int GOOD_STATUS_COLLECTED = 3;
    //检测中
    public static final int GOOD_STATUS_TESTING = 4;
    //取消
    public static final int GOOD_STATUS_CANCEL = 5;
    //退款中
    public static final int GOOD_STATUS_REFUNDING = 9;
    //退款结束
    public static final int GOOD_STATUS_REFUND = 6;
    //已出报告
    public static final int GOOD_STATUS_REPORTED = 7;
    //已解读
    public static final int GOOD_STATUS_INTERPRETED = 8;

    public static final int GOOD_EXCEPTION_DEAL_CANCEL_REFUND = 0;
    public static final int GOOD_EXCEPTION_DEAL_DELAY = 1;

    public static final int GOOD_EXCEPTION_STATUS_INIT = 0;
    public static final int GOOD_EXCEPTION_STATUS_ENABLE = 2;

    public static final int GOOD_EXCEPTION_REASON_1 = 1;
    public static final int GOOD_EXCEPTION_REASON_2 = 2;
    public static final int GOOD_EXCEPTION_REASON_3 = 3;
    public static final int GOOD_EXCEPTION_REASON_4 = 4;
    public static final int GOOD_EXCEPTION_REASON_5 = 5;

    public static final int GOOD_REFUND_REASON_USER = 0;
    public static final int GOOD_REFUND_REASON_ACQUISITION = 1;
    public static final int GOOD_REFUND_REASON_EXCEPTION = 2;
    public static final int GOOD_REFUND_REASON_BACK = 3;
    public static final int GOOD_REFUND_REASON_OTHERFREE = 4;

    public static final int GOOD_REFUND_STATUS_UNPAY = 0;
    public static final int GOOD_REFUND_STATUS_PAYING = 1;
    public static final int GOOD_REFUND_STATUS_PAYED = 2;
    public static final int GOOD_REFUND_STATUS_PART_REFUNDED = 4;

    //报告出完消息已分发
    public static final String GOOD_MESSAGE_OUT = "1";

}
