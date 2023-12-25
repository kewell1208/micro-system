package com.tclab.weixinappletcommon.utils;

public class NumberUtils {

    public static int null2num(Integer num){
        if (num==null){
            return 0;
        } else {
            return num.intValue();
        }
    }

}
