package com.tclab.weixinappletcommon.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {

    /**
     * 判断是否符合邮箱格式
     * @param emailAddress
     * @return
     */
    public static boolean isEmail(String emailAddress) {
        if (StringUtils.isBlank(emailAddress))
            return false;
        String regEx1 = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern p;
        Matcher m;
        p = Pattern.compile(regEx1);
        m = p.matcher(emailAddress);
        if (m.matches())
            return true;
        else
            return false;
    }

}
