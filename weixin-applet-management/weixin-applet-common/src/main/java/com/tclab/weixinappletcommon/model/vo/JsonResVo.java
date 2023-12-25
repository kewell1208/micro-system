package com.tclab.weixinappletcommon.model.vo;


import com.tclab.weixinappletcommon.constant.ErrorEnum;

public class JsonResVo {

    private int code;

    private String errmsg;

    private Object data;

    public static JsonResVo buildSuccess() {
        return buildSuccess(null);
    }

    public static JsonResVo buildSuccess(Object data) {
        return build(ErrorEnum.OK.getErrorCode(), null, data);
    }

    public static JsonResVo buildFail(ErrorEnum errorEnum) {
        return buildErrorResult(errorEnum.getErrorCode(), errorEnum.getErrorMessage());
    }

    public static JsonResVo buildErrorResult(int code, String errmsg) {
        return buildErrorResult(code, errmsg, null);
    }

    public static JsonResVo buildErrorResult(int code, String errmsg, Object data) {
        return build(code, errmsg, data);
    }


    private static JsonResVo build(int code, String errmsg, Object data) {
        JsonResVo jsonResVo = new JsonResVo();
        jsonResVo.setCode(code);
        jsonResVo.setErrmsg(errmsg);
        jsonResVo.setData(data);
        return jsonResVo;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}