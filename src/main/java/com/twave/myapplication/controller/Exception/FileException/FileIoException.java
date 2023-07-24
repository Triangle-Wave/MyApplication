package com.twave.myapplication.controller.Exception.FileException;

/**
 * 文件读写异常
 *
 * @author TWAVE
 */
public class FileIoException extends FileException {
    public FileIoException() {
        super();
    }

    public FileIoException(String message) {
        super(message);
    }

    public FileIoException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileIoException(Throwable cause) {
        super(cause);
    }

    protected FileIoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
