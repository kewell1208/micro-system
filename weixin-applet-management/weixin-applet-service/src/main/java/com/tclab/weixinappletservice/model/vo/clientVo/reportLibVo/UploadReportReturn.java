package com.tclab.weixinappletservice.model.vo.clientVo.reportLibVo;

import java.io.Serializable;

/**
 * Created by Kewell on 2017/2/23.
 */
public class UploadReportReturn implements Serializable {

    private String barcode;
    private String uploadPdfPath;
    private String uploadWordPath;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getUploadPdfPath() {
        return uploadPdfPath;
    }

    public void setUploadPdfPath(String uploadPdfPath) {
        this.uploadPdfPath = uploadPdfPath;
    }

    public String getUploadWordPath() {
        return uploadWordPath;
    }

    public void setUploadWordPath(String uploadWordPath) {
        this.uploadWordPath = uploadWordPath;
    }
}
