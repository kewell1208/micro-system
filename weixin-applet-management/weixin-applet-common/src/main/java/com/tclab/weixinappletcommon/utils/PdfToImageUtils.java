package com.tclab.weixinappletcommon.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.pdfbox.io.RandomAccessBuffer;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;
//import org.icepdf.core.pobjects.Document;
//import org.icepdf.core.pobjects.Page;
//import org.icepdf.core.util.GraphicsRenderingHints;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.image.BufferedImage;
//import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PdfToImageUtils {

    private static final Logger logger = LoggerFactory.getLogger(PdfToImageUtils.class);

    /**
     * 将pdf单页转换为图片
     *
     * @param page         当页对象
     * @param saveFileName 保存的图片名称
     * @param imgType      保存的图片类型
     * @param renderer     用于获取BufferedImage
     * @param index        页索引
     * @throws IOException
     */
    public static void pdfPage2Img(PDPage page, String saveFileName, String imgType, PDFRenderer renderer, int index) throws IOException {
        //构造图片
        BufferedImage img_temp = renderer.renderImage(index);
        //设置图片格式
        Iterator<ImageWriter> it = ImageIO.getImageWritersBySuffix(imgType);
        //将文件写出
        ImageWriter writer = (ImageWriter) it.next();
        ImageOutputStream imageout = ImageIO.createImageOutputStream(new FileOutputStream(saveFileName));
        writer.setOutput(imageout);
        writer.write(new IIOImage(img_temp, null, null));
    }

    public static List<String> pdf2Img(String goodNo,String savePath, String imgType, String pdfPath) throws Exception{

        logger.info("pdf转图片开始: "+goodNo);

        List<String> imgList = new ArrayList<>();

        //计时器
        StopWatch watch = new StopWatch();
        // 计时器开始
        watch.start();
        //pdf本地保存地址
        //String savePath = "d:/tclab/pdf/";
        //pdf文件名
        //String imgType = "jpg";
        //pdf网络地址
        //String pdfPath = "http://120.193.21.152:8081/group1/M00/50/3F/rBIUC1phfxWAQVWoAAzDqLUhlMY571.pdf";
        if (StringUtils.isBlank(pdfPath)||pdfPath.equals("0")){
            return null;
        }
        String urlPdfPath = "http://120.193.21.152:8081/"+pdfPath;
        // 构造URL
        URL url = new URL(urlPdfPath);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(60*1000);
        // 输入流
        InputStream is = con.getInputStream();
        //InputStream is = null;

        //String fileName = pdfPath.substring(pdfPath.lastIndexOf("/")+1, pdfPath.length());
        String fileName = goodNo+"-r";
        //fileName = fileName.substring(0,fileName.lastIndexOf("."));
        PDDocument pdDocument = null;

        try {
            //is = new BufferedInputStream(new FileInputStream(pdfPath));
            is = new BufferedInputStream(is);
            //创建pdf文件解析器
            PDFParser parser = new PDFParser(new RandomAccessBuffer(is));
            parser.parse();
            //获取解析后的pdf文档
            pdDocument = parser.getPDDocument();
            //获取pdf渲染器，主要用来后面获取BufferedImage
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            //获取pdf文件总页数
            int pageCount = pdDocument.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                //构造保存文件名称格式
                String saveDBName = fileName + "-" + i + "." + imgType;
                String saveFileName = savePath + "/" + saveDBName;
                //获取当前页对象
                PDPage page = pdDocument.getPage(i);
                //图片转换
                pdfPage2Img(page, saveFileName, imgType, renderer, i);
                imgList.add(saveDBName);
            }
        } catch (Exception e) {
            logger.info("pdf转图片文件出错: "+goodNo);
            e.printStackTrace();
        } finally {
            watch.stop();
            Long time = watch.getTime();
            logger.info("文件转换用时: goodNo "+goodNo+" "+time);
            if (pdDocument != null) {
                try {
                    pdDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return imgList;
        }
    }

    public static List<String> pdf2ImgByFile(String goodNo,String savePath, String imgType, MultipartFile file) throws Exception{

        logger.info("文件pdf转图片开始: "+goodNo);

        List<String> imgList = new ArrayList<>();

        //计时器
        StopWatch watch = new StopWatch();
        // 计时器开始
        watch.start();

        InputStream is = file.getInputStream();
        //InputStream is = null;

        //String fileName = pdfPath.substring(pdfPath.lastIndexOf("/")+1, pdfPath.length());
        String fileName = goodNo+"-f";
        //fileName = fileName.substring(0,fileName.lastIndexOf("."));
        PDDocument pdDocument = null;

        try {
            //is = new BufferedInputStream(new FileInputStream(pdfPath));
            is = new BufferedInputStream(is);
            //创建pdf文件解析器
            PDFParser parser = new PDFParser(new RandomAccessBuffer(is));
            parser.parse();
            //获取解析后的pdf文档
            pdDocument = parser.getPDDocument();
            //获取pdf渲染器，主要用来后面获取BufferedImage
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            //获取pdf文件总页数
            int pageCount = pdDocument.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                //构造保存文件名称格式
                String saveDBName = fileName + "-" + i + "." + imgType;
                String saveFileName = savePath + "/" + saveDBName;
                //获取当前页对象
                PDPage page = pdDocument.getPage(i);
                //图片转换
                pdfPage2Img(page, saveFileName, imgType, renderer, i);
                imgList.add(saveDBName);
            }
        } catch (Exception e) {
            logger.info("pdf转图片文件出错: "+goodNo);
            e.printStackTrace();
        } finally {
            watch.stop();
            Long time = watch.getTime();
            logger.info("文件转换用时: goodNo "+goodNo+" "+time);
            if (pdDocument != null) {
                try {
                    pdDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return imgList;
        }
    }

    public static List<String> pdf2ImgByUrl(String id,String savePath, String imgType,String pdfUrl) throws Exception{

        logger.info("pdf转图片开始: "+id);

        List<String> imgList = new ArrayList<>();

        //计时器
        StopWatch watch = new StopWatch();
        // 计时器开始
        watch.start();

        String urlPdfPath = pdfUrl;
        // 构造URL
        URL url = new URL(urlPdfPath);
        // 打开连接
        URLConnection con = url.openConnection();
        //设置请求超时为5s
        con.setConnectTimeout(60*1000);
        // 输入流
        InputStream is = con.getInputStream();
        //InputStream is = null;

        //String fileName = pdfPath.substring(pdfPath.lastIndexOf("/")+1, pdfPath.length());
        String fileName = id+"-r";
        //fileName = fileName.substring(0,fileName.lastIndexOf("."));
        PDDocument pdDocument = null;

        try {
            //is = new BufferedInputStream(new FileInputStream(pdfPath));
            is = new BufferedInputStream(is);
            //创建pdf文件解析器
            PDFParser parser = new PDFParser(new RandomAccessBuffer(is));
            parser.parse();
            //获取解析后的pdf文档
            pdDocument = parser.getPDDocument();
            //获取pdf渲染器，主要用来后面获取BufferedImage
            PDFRenderer renderer = new PDFRenderer(pdDocument);
            //获取pdf文件总页数
            int pageCount = pdDocument.getNumberOfPages();
            for (int i = 0; i < pageCount; i++) {
                //构造保存文件名称格式
                String saveDBName = fileName + "-" + i + "." + imgType;
                String saveFileName = savePath + "/" + saveDBName;
                //获取当前页对象
                PDPage page = pdDocument.getPage(i);
                //图片转换
                pdfPage2Img(page, saveFileName, imgType, renderer, i);
                imgList.add(saveDBName);
            }
        } catch (Exception e) {
            logger.info("pdf转图片文件出错: "+id);
            e.printStackTrace();
        } finally {
            watch.stop();
            Long time = watch.getTime();
            logger.info("文件转换用时: goodNo "+id+" "+time);
            if (pdDocument != null) {
                try {
                    pdDocument.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return imgList;
        }
    }

//    public static List<String> pdf2ImgByIcePDF(String address,String pdfUrl,String name){
//
//        Document document = new Document();
//        try {
//            URL url = new URL(pdfUrl);
//            URLConnection con = url.openConnection();
//            con.setConnectTimeout(60*1000);
//            InputStream is = con.getInputStream();
//            document.setInputStream(is,null);
//        } catch (Exception ex) {
//            logger.info("读取数据流错误");
//            throw new RuntimeException("读取数据流错误");
//        }
//
//        float scale = 2f;
//        float rotation = 0f;
//
//        List<String> imgList = new ArrayList<>();
//
//        for (int i = 0; i < document.getNumberOfPages(); i++) {
//
//            logger.info("开始转换");
//            BufferedImage image = (BufferedImage)document.getPageImage(i, GraphicsRenderingHints.SCREEN,
//                    Page.BOUNDARY_CROPBOX, rotation, scale);
//            RenderedImage rendImage = image;
//
//            String imgForPdf = address+"-"+i+"-f"+".png";
//            String imgName = name+"-"+i+"-f"+".png";
//
//            try {
//                File file = new File(imgForPdf);
//                ImageIO.write(rendImage, "png", file);
//                imgList.add(imgName);
//            } catch (IOException e) {
//                logger.info(imgForPdf+"转换图片错误");
//                throw new RuntimeException("pdf转换图片错误");
//            }
//            image.flush();
//        }
//        document.dispose();
//        return imgList;
//    }

}
