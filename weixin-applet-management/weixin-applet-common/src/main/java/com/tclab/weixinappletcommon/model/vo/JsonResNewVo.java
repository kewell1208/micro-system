package com.tclab.weixinappletcommon.model.vo;

import com.tclab.weixinappletcommon.constant.ErrorEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "返回对象",description = "JsonResVo")
public class JsonResNewVo<T> {

    @ApiModelProperty(value = "状态码",required = true)
    private int code;
    @ApiModelProperty(value = "详细信息",required = true)
    private String errmsg;
    @ApiModelProperty(value = "具体返回值",required = true)
    private T data;

    public static JsonResNewVo buildSuccess() {
        return buildSuccess(null);
    }

    public static JsonResNewVo buildSuccess(Object data) {
        return build(ErrorEnum.OK.getErrorCode(), null, data);
    }

    public static JsonResNewVo buildFail(ErrorEnum errorEnum) {
        return buildErrorResult(errorEnum.getErrorCode(), errorEnum.getErrorMessage());
    }

    public static JsonResNewVo buildErrorResult(int code, String errmsg) {
        return buildErrorResult(code, errmsg, null);
    }

    public static JsonResNewVo buildErrorResult(int code, String errmsg, Object data) {
        return build(code, errmsg, data);
    }


    private static JsonResNewVo build(int code, String errmsg, Object data) {
        JsonResNewVo jsonResVo = new JsonResNewVo();
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}