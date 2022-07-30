package com.github.zhenwei.glass.common.exceptions;

import com.github.zhenwei.glass.common.enums.IGlassEnum;

public abstract class AbstractGlassException extends Exception implements IGlassException {

    String message;

    int code;

    public AbstractGlassException(Throwable throwable) {
        super(throwable);
        this.message = throwable.getMessage();
        this.code = IGlassEnum.SYSTEM_ERR_CODE;
    }


    public AbstractGlassException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public AbstractGlassException(String message, Throwable throwable) {
        super(message, throwable);
        this.message = message;
        this.code = IGlassEnum.SYSTEM_ERR_CODE;
    }

    public AbstractGlassException(IGlassEnum iGlassEnum) {
        super(iGlassEnum.getErrMessage());
        this.message = iGlassEnum.getErrMessage();
        this.code = iGlassEnum.getErrCode();
    }

    public AbstractGlassException(IGlassEnum iGlassEnum, Throwable throwable) {
        super(iGlassEnum.getErrMessage() + " : " + throwable.getMessage());
        this.message = iGlassEnum.getErrMessage();
        this.code = iGlassEnum.getErrCode();
    }

}
