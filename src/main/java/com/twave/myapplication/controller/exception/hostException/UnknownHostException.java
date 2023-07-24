package com.twave.myapplication.controller.exception.hostException;

/**
 * @author : twave
 * @date : 2023/7/17 10:56
 */
public class UnknownHostException extends RuntimeException {
    public UnknownHostException() {
        super();
    }

    public UnknownHostException(String message) {
        super(message);
    }

    public UnknownHostException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownHostException(Throwable cause) {
        super(cause);
    }

    protected UnknownHostException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
