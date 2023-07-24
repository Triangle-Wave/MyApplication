package com.twave.myapplication.controller.Exception.FileException;

/**
 * 文件不存在异常
 *
 * @author : twave
 * @date : 2023/7/21 8:46
 */
public class FileNotExistException extends FileException {
    public FileNotExistException() {
        super();
    }

    public FileNotExistException(String message) {
        super(message);
    }

    public FileNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotExistException(Throwable cause) {
        super(cause);
    }

    protected FileNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
