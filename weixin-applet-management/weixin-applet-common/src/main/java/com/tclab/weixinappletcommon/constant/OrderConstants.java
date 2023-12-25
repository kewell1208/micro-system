package com.tclab.weixinappletcommon.constant;

public class OrderConstants {

    public static final int ORDER_STATUS_UNPAY = 0;
    public static final int ORDER_STATUS_UNCOLLECT = 1;
    public static final int ORDER_STATUS_COLLECTED= 2;
    public static final int ORDER_STATUS_COMPLETED= 3;

    public static final int ORDER_CANCEL_TYPE_SELF= 0;
    public static final int ORDER_CANCEL_TYPE_AUTO= 1;

    public static final int CANCEL_REASON_UNPAY= 0;
    public static final int CANCEL_REASON_SELF= 1;

    public static final int EXCEPTION_REASON_GOOD_DELAY= 0;

    public static final int ORDER_SERVICE_TYPE_SELF= 0;
    public static final int ORDER_SERVICE_TYPE_ACQUISITION= 1;
    public static final int ORDER_SERVICE_TYPE_HOME= 2;

    public static final int ORDER_TYPE_SELF= 0;
    public static final int ORDER_TYPE_GIVE= 1;
    public static final int ORDER_TYPE_RECEIVE= 2;

    public static final int REPORT_TYPE_ELE= 0;
    public static final int REPORT_TYPE_PAPER_AND_ELE= 1;

    public static final int USE_SELF = 0;
    public static final int USE_OTHER = 1;

    //未支付
    public static final int ORDER_PAY_STATUS_UNPAY = 0;
    //支付中预下单
    public static final int ORDER_PAY_STATUS_PAYING = 1;
    //已支付
    public static final int ORDER_PAY_STATUS_PAYED = 2;
    //支付失败
    public static final int ORDER_PAY_STATUS_PAYFAILED = 3;

    public static final int ORDER_REFUND_STATUS_UNPAY = 0;
    public static final int ORDER_REFUND_STATUS_PAYING = 1;
    public static final int ORDER_REFUND_STATUS_PAYED = 2;
    public static final int ORDER_REFUND_STATUS_PART_REFUNDING = 5;
    public static final int ORDER_REFUND_STATUS_PART_REFUNDED = 4;

    public static final int WRITE_OFF_STATUS_UNFINISH = 0;
    public static final int WRITE_OFF_STATUS_DEALING = 1;
    public static final int WRITE_OFF_STATUS_FINISHED = 2;

    public static final int ORDER_EXCEPTION_NORMAL = 0;
    public static final int ORDER_EXCEPTION_DEALING = 1;
    public static final int ORDER_EXCEPTION_ERROR = 2;

    public static final int ORDER_REFUND_REASON_USER = 0;
    public static final int ORDER_REFUND_REASON_ACQUISITION = 1;
    public static final int ORDER_REFUND_REASON_EXCEPTION = 2;
    public static final int ORDER_REFUND_REASON_BACK = 3;
    public static final int ORDER_REFUND_REASON_OTHERFREE = 4;

}
