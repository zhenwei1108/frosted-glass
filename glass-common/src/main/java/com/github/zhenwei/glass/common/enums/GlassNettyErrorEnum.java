package com.github.zhenwei.glass.common.enums;

public enum GlassNettyErrorEnum implements IGlassEnum{
    BUILD_CLIENT_ERR("构建客户端失败", 100001),

    ;


    private String message = SYSTEM_ERR_MSG;

    private int code = SYSTEM_ERR_CODE;

    GlassNettyErrorEnum(String message, int code) {
        this.message = message;
        this.code = code;
    }

    GlassNettyErrorEnum() {
    }

    public String getErrMessage() {
        return this.message;
    }


    @Override
    public int getErrCode() {
        return this.code;
    }
}
