package com.tclab.weixinappletcommon.utils;

public class ImageUtils {

    private static final String[] format={"jpg","jpeg","png"};

    public final static boolean checkImageFormat(String fileName){
        String suffixName=fileName.substring(fileName.lastIndexOf(".")+1);
        for (int i = 0; i < format.length; i++)
        {
            if (suffixName.equals(format[i]))
            {
                return true;
            }
        }
        return false;
    }

    public final static boolean checkImagesuffixNameFormat(String suffixName){
        for (int i = 0; i < format.length; i++)
        {
            if (suffixName.equals(format[i]))
            {
                return true;
            }
        }
        return false;
    }


}
