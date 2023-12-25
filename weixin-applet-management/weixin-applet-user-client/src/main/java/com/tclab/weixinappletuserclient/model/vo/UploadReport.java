package com.tclab.weixinappletuserclient.model.vo;

import java.io.Serializable;

/**
 * Created by Kewell on 2017/2/23.
 */
public class UploadReport implements Serializable {

    private String barcode;
    private String pdfStream;
    private String wordStream;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getPdfStream() {
        return pdfStream;
    }

    public void setPdfStream(String pdfStream) {
        this.pdfStream = pdfStream;
    }

    public String getWordStream() {
        return wordStream;
    }

    public void setWordStream(String wordStream) {
        this.wordStream = wordStream;
    }
}
