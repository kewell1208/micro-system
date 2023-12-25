package com.tclab.weixinappletcommon.constant;

public class LogisticsConstants {

    public static final int LOGISTICS_STATUS_UNSEND = 0;
    //自采用户
    public static final int LOGISTICS_STATUS_PRESEND = 1;
    public static final int LOGISTICS_STATUS_SENDEDTOTC = 2;
    public static final int LOGISTICS_STATUS_RECEIVED = 3;
    public static final int LOGISTICS_STATUS_CANCEL = 4;

    public static final int ACQUISITION_LOGISTICS_STATUS_UNSEND = 0;
    public static final int ACQUISITION_LOGISTICS_STATUS_SENDING = 1;
    public static final int ACQUISITION_LOGISTICS_STATUS_SENDED = 2;

    public static final int LOGISTICS_TYPE_THIRD_ACQUISITION = 0;
    public static final int LOGISTICS_TYPE_THIRD_SELF = 1;
    public static final int LOGISTICS_TYPE_TC = 2;
    public static final int LOGISTICS_TYPE_THIRD_SENDTOUSER = 3;

    public static final int LOGISTICS_ACTION_SEND = 0;
    public static final int LOGISTICS_ACTION_CANCEL = 1;
    public static final int LOGISTICS_ACTION_ADD = 2;
    public static final int LOGISTICS_ACTION_CHECK = 3;
    public static final int LOGISTICS_ACTION_DELETE = 4;

}
