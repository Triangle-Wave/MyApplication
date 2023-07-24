package com.twave.myapplication.constants;

/**
 * @author : twave
 * @date : 2023/7/21 11:24
 */
public class Constants {
    /**
     * 上传文件的最大大小，200MB
     */
    public static final int FILE_MAXSIZE = 200 * 1024 * 1024;

    /**
     * 请求成功的状态码
     */
    public static final int REQUEST_SUCCESS = 200;
    /**
     * 文件为空
     */
    public static final int FILE_EMPTY = 6000;
    /**
     * 文件大小超出限制
     */
    public static final int FILE_SIZE_EXCEED = 6001;
    /**
     * 文件类型错误
     */
    public static final int FILE_TYPE_UNSUPPORT = 6002;
    /**
     * 文件状态错误
     */
    public static final int FILE_STATE_ERROR = 6003;
    /**
     * 未知端口
     */
    public static final int UNKNOW_HOST = 6005;
    /**
     * 文件不存在
     */
    public static final int FILE_NOT_EXIST = 6006;
    /**
     * 文件读写异常
     */
    public static final int FILE_IO_EXCEPTION = 6007;

}
