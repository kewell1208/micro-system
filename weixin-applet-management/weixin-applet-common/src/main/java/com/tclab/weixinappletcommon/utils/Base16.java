package com.tclab.weixinappletcommon.utils;

/**
 * Created by wang on 2017-06-13.
 */
public class Base16 {
    public static String encode(byte[] src) {
        StringBuffer rlt = new StringBuffer();
        for (int i = 0; i < src.length; ++i) {
            int v = src[i] & 0xFF;
            if (v <= 15) {
                rlt.append("0");
            }
            rlt.append(Integer.toHexString(v));
        }
        return rlt.toString();
    }

    public static byte[] decode(String src) {
        byte[] rlt = new byte[src.length() / 2];
        for (int i = 0; i < src.length(); i += 2) {
            rlt[(i / 2)] = (byte) Integer.parseInt(src.substring(i, i + 2), 16);
        }
        return rlt;
    }

//    private final static String DES = "DES";
//    private final static String ENCODE = "GBK";
//    private final static String defaultKey = "netwxactive";
//
//    /**
//     * Description 根据键值进行加密
//     * @param data 待加密数据
//     * @param key 密钥
//     * @return
//     * @throws Exception
//     */
//    public static String encrypt(String data, String key) throws Exception {
//        byte[] bt = encrypt(data.getBytes(ENCODE), key.getBytes(ENCODE));
//        String strs = new BASE64Encoder().encode(bt);
//        return strs;
//    }
//
//    /**
//     * 根据键值进行解密
//     * @param data 待解密数据
//     * @param key    密钥
//     * @return
//     * @throws IOException
//     * @throws Exception
//     */
//    public static String decrypt(String data, String key) throws IOException, Exception {
//        if (data == null)
//            return null;
//        BASE64Decoder decoder = new BASE64Decoder();
//        byte[] buf = decoder.decodeBuffer(data);
//        byte[] bt = decrypt(buf, key.getBytes(ENCODE));
//        return new String(bt, ENCODE);
//    }
}
