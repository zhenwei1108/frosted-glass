package com.github.zhenwei.glass.common.exceptions;

import com.github.zhenwei.glass.common.enums.IGlassEnum;

public class GlassNettyException extends AbstractGlassException {

    public GlassNettyException(Throwable throwable) {
        super(throwable);
    }

    public GlassNettyException(String message, int code) {
        super(message, code);
    }

    public GlassNettyException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public GlassNettyException(IGlassEnum iGlassEnum) {
        super(iGlassEnum);
    }

    public GlassNettyException(IGlassEnum iGlassEnum, Throwable throwable) {
        super(iGlassEnum, throwable);
    }
}
