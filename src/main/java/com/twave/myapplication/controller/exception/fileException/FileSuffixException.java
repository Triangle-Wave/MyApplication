package com.twave.myapplication.controller.exception.fileException;

/**
 * @author TWAVE
 * @date 2023/8/15 12:50
 */
public class FileSuffixException extends FileException {
    public FileSuffixException() {
        super();
    }

    public FileSuffixException(String message) {
        super(message);
    }

    public FileSuffixException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileSuffixException(Throwable cause) {
        super(cause);
    }

    protected FileSuffixException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
