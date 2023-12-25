package com.tclab.weixinappletcommon.constant;

public class CommonConstants {

    public static final String GenerateID_ACQUISITION = "A";
    public static final String GenerateID_ORDER = "E";
    public static final String GenerateID_GOOD = "G";
    public static final String GenerateID_PACKAGE = "P";
    public static final String GenerateID_CLERK = "K";
    public static final String GenerateID_USER = "U";
    public static final String GenerateID_STAFF = "S";
    public static final String GenerateID_WRITEOFF_CODE = "W";
    public static final String GenerateID_MESSAGE = "M";
    public static final String GenerateID_HOSPITAL ="H";
    public static final String GenerateID_DOCTOR ="D";

    public static final String GenerateID_LOGISTICS_TC = "LC";
    public static final String GenerateID_LOGISTICS_THIRD = "LD";
    public static final String GenerateID_PARTICIPANT = "PT";
    public static final String GenerateID_SERVICEINFO = "SI";
    public static final String GenerateID_DEPARTMENT = "DP";
    public static final String GenerateID_TAG = "TG";
    public static final String GenerateID_IM ="IM";
    public static final String GenerateID_IM_RECOMMEND ="IR";
    public static final String GenerateID_INTERPRET ="IT";
    public static final String GenerateID_INVOICE = "IN";
    public static final String GenerateID_HOSPITAL_DEPARTMENT ="HP";

    public static final String GenerateID_PACKAGE_CATALOG = "CA";
    public static final String GenerateID_PACKAGE_PURPOSE = "PU";
    public static final String GenerateID_PACKAGE_POPULATION = "PO";

    public static final int INIT = 0;
    public static final int PEND = 1;
    public static final int ENABLE = 2;
    public static final int INVALID = 3;

    public static final int MALE = 0;
    public static final int FEMALE = 1;

    public static final int PLACE_ORDER_FROM_SELF = 0;
    public static final int PLACE_ORDER_FROM_USER = 1;
    public static final int PLACE_ORDER_FROM_APP = 2;

    //普通用户:                 登陆客户端
    public static final int USER_ROLE_USER = 0;
    //采集点医生兼采集员工:       登陆采集点端 客户端
    public static final int USER_ROLE_ACQUISITION_DOCTOR_AND_STAFF = 1;
    //采集点员工:                登陆采集点端 客户端
    public static final int USER_ROLE_ACQUISITION_STAFF = 2;
    //采集点医生:                登陆客户端
    public static final int USER_ROLE_ACQUISITION_DOCTOR = 6;
    //采集点所有权限:             登陆采集点端 客户端 后台
    public static final int USER_ROLE_ACQUISITION_ALL = 7;
    //同创开单医生:               默认开单作用，实际没有这种实体用户
    public static final int USER_ROLE_VERIFY_DEFAULT = 8;

    //采集点管理员: 登陆客户端后台
    public static final int USER_ROLE_ACQUISITION = 5;
    //采集点管理员同时也是采集点员工: 登陆用户端和采集点端和后台
    public static final int USER_ROLE_ACQUISITION_NURSE_ADMIN = 3;
    //同创管理员: 登陆客户端和后台
    public static final int USER_ROLE_ADMIN = 2;
    //同创开单医生: 登陆客户端和后台
    public static final int USER_ROLE_VERIFY = 4;

    public static final int TWO = 2;

    //树兰接口随机数
    public static final String sign_key = "27Nt3V3MS9wP25Au";

}
