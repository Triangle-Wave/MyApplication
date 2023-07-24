package com.twave.myapplication.controller.Exception.lockException;

/**
 * 锁被占用异常
 *
 * @author : twave
 * @date : 2023/7/24 15:46
 */
public class LockUsedException extends RuntimeException {
    public LockUsedException() {
        super();
    }

    public LockUsedException(String message) {
        super(message);
    }

    public LockUsedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LockUsedException(Throwable cause) {
        super(cause);
    }

    protected LockUsedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
