package com.tclab.weixinappletcommon.constant;

public enum ErrorEnum {

    OK(0,0,"正常"),

    SYSTEM_ERROR(100, 101, "系统错误"),
    ERROR_BIZ_FAIL(100, 102, "业务失败"),
    ERROR_BIZ_UNIQUE_REQ_ID(100, 103, "唯一性约束重复"),

    OBJECT_ERROR_EMPTY(200,201,"对象为空"),
    SERVICE_ERROR(200, 202, "服务未更新"),
    PARAM_ERROR_EMPTY(200,203,"参数错误"),
    USER_NOT_EXIST(200, 204, "用户不存在"),
    USER_EXISTED(200, 205, "用户已存在"),
    USER_CLOSE(200, 205, "用户已关闭"),

    SERVICE_NOT_SUPPORT(300,301,"服务暂时未支持"),
    ;

    private final int errorCode;
    private final int parentCode;
    private final String errorMessage;

    ErrorEnum(int parentCode, int errorCode, String errorMessage) {
        this.parentCode = parentCode;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public int getParentCode() {
        if (String.valueOf(errorCode).startsWith("1")) {
            return errorCode;
        }

        return parentCode;
    }

    public ErrorEnum getOutError() {
        return getErrorByCode(getParentCode());
    }

    public static ErrorEnum getErrorByCode(int code) {
        for (ErrorEnum errorEnum : values()) {
            if (errorEnum.getErrorCode() == code) {
                return errorEnum;
            }
        }
        return null;
    }

}
