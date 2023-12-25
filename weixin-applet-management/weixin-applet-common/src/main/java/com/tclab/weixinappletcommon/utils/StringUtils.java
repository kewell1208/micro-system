package com.tclab.weixinappletcommon.utils;

import net.sourceforge.pinyin4j.PinyinHelper;

import java.util.*;

public class StringUtils {

    //处理存入数据库的字符串,以分号分隔
    public static String getString(List<String> strs,String pre){
        if (strs.size()==0){
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (String infoImageUrl:strs) {
            sb.append(pre+infoImageUrl);
            sb.append(";");
        }
        String images = sb.toString();
        String result = images.substring(0,images.length()-1);
        return result;
    }

    public static String getFirstBigAlphabet(String str){
        StringBuffer pybf = new StringBuffer();
        // 获取首个字符
        char word = str.charAt(0);
        // 提取汉字的首字母
        String[] pinyinArray;
        // 是否是因为字母
        if (word > 128) {
            pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            // 如果不是汉字，就返回*
            if (pinyinArray != null) {
                pybf.append(pinyinArray[0].charAt(0));
            } else {
                pybf.append("*");
            }
        } else {
            // 是字母直接返回
            if (Character.isLetter(word)) {
                pybf.append(word);
            } else if (Character.isDigit(word)){
                pybf.append(word);
            } else {
                pybf.append("*");
            }
        }

        // 全部返回大写
        return pybf.toString().toUpperCase();
    }

    public static List<String> getSameStrs(List<String> a,List<String> b){
        List<String> c = new ArrayList<String>();
        for (String astr:a) {
            for (String bstr:b) {
                if (astr.equals(bstr)){
                    c.add(astr);
                }
            }
        }
        return c;
    }

    public static List<String> getDiffrentList(List<String> list1, List<String> list2)
    {
        Map<String,Integer> map = new HashMap<String,Integer>(list1.size()+list2.size());
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if(list2.size()>list1.size())
        {
            maxList = list2;
            minList = list1;
        }

        for (String string : maxList)
        {
            map.put(string, 1);
        }

        for (String string : minList)
        {
            Integer cc = map.get(string);
            if(cc!=null)
            {
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }

        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        return diff;
    }

    /**
     * StringUtils工具类方法
     * 获取一定长度的随机字符串，范围0-9，a-z
     * @param length：指定字符串长度
     * @return 一定长度的随机字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

}
