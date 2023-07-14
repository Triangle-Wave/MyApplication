package com.twave.myapplication.Service.Exception;

/**
 * 所有业务异常的基类
 *
 * @author : twave
 * @date : 2023/7/14 16:48
 */
public class ServiceException extends RuntimeException {
    public ServiceException() {
        super();
    }

    // 抛出异常信息
    public ServiceException(String message) {
        super(message);
    }

    // 抛出异常信息和对象
    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
