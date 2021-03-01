package com.easy.exception;


import com.easy.result.ErrorCode;

/**
 * @author linNaibin
 * @version V1.0
 * @Title: EasyException.java
 * @Package com.easy.gis.exception
 * @Description: TODO
 * @date 2021年2月10日 上午14:45:21
 */
public class EasyException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ErrorCode errorCode;

    public EasyException(ErrorCode errorCode) {
        super(errorCode.msg());
        this.errorCode = errorCode;
    }

    public EasyException(String message) {
        super(message);
    }

    public EasyException(Throwable cause) {
        super(cause);
    }

    public EasyException(String message, Throwable cause) {
        super(message, cause);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
