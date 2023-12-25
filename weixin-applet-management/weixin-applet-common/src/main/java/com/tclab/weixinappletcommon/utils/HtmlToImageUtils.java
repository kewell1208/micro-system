package com.tclab.weixinappletcommon.utils;

import gui.ava.html.image.generator.HtmlImageGenerator;

import java.awt.*;
import java.io.*;

public class HtmlToImageUtils {

    /**
     * html转String
     * @param filePath
     * @param charset
     * @return
     */
    public static String getHtmlContent(String filePath, String charset){

        String line = null;
        StringBuilder sb = new StringBuilder();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(filePath)),charset));
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("读取HTML文件，获取字符内容异常");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("关闭流异常");
            }
        }
        return sb.toString();
    }

    public static String html2Img(String htmText, String saveImageLocation){

        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        try {
            imageGenerator.loadHtml(htmText);
            Thread.sleep(200);
            imageGenerator.getBufferedImage();
            Thread.sleep(200);

            Dimension dimension = new Dimension(575,800);
            imageGenerator.setSize(dimension);

            imageGenerator.saveAsImage(saveImageLocation);
            //imageGenerator.saveAsHtmlWithMap("hello-world.html", saveImageLocation);
            //不需要转换位图的，下面三行可以不要
            //BufferedImage sourceImg = ImageIO.read(new File(saveImageLocation));
            //sourceImg = transform_Gray24BitMap(sourceImg);
            //ImageIO.write(sourceImg, "BMP", new File(saveImageLocation));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("将HTML文件转换成图片异常");
        }
        return saveImageLocation;
    }

    public static String html2ImgByUrl(String url, String saveImageLocation){

        HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
        try {
            imageGenerator.loadUrl(url);
            Thread.sleep(100);
            //Thread.sleep(3000);
            imageGenerator.getBufferedImage();
            Thread.sleep(100);
            //Thread.sleep(3000);
            imageGenerator.saveAsImage(saveImageLocation);
            //imageGenerator.saveAsHtmlWithMap("hello-world.html", saveImageLocation);
            //不需要转换位图的，下面三行可以不要
            //BufferedImage sourceImg = ImageIO.read(new File(saveImageLocation));
            //sourceImg = transform_Gray24BitMap(sourceImg);
            //ImageIO.write(sourceImg, "BMP", new File(saveImageLocation));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("将HTML文件转换成图片异常");
        }
        return saveImageLocation;
    }

}
