package com.twave.myapplication.controller.exception.fileException;

/**
 * 文件操作相关异常的基类
 *
 * @author TWAVE
 */
public class FileException extends RuntimeException {
    public FileException() {
        super();
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileException(Throwable cause) {
        super(cause);
    }

    protected FileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
