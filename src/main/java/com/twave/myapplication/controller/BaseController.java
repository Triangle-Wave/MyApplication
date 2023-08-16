package com.twave.myapplication.controller;

import com.twave.myapplication.controller.exception.fileException.*;
import com.twave.myapplication.controller.exception.hostException.UnknownHostException;
import com.twave.myapplication.controller.exception.lockException.LockUsedException;
import com.twave.myapplication.util.JSONResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.twave.myapplication.constants.StatusCode.*;


/**
 * 所有Controller的基类
 *
 * @author : twave
 * @date : 2023/7/14 16:44
 */
public class BaseController {


    /**
     * 请求处理方法，这个方法的返回值就是需要传递给前端的数据
     * 自动将异常对象传递给此方法的参数列
     * 当前项目中产生的异常，会被统一拦截到此方法中，这个方法此时充当请求处理方法，方法的返回值直接给前端
     * -@ExceptionHandler注解用于描述当前方法可以处理哪些异常
     * 这个注解可以接受一个列表
     */
    @ExceptionHandler({
            FileEmptyException.class,
            FileSizeException.class,
            FileTypeException.class,
            FileStateException.class,
            UnknownHostException.class,
            FileNotExistException.class,
            FileIoException.class,
            LockUsedException.class,
            FileSuffixException.class
    })
    public JSONResult<Void> handleException(Throwable e) {
        JSONResult<Void> result = new JSONResult<>();
        if (e instanceof FileEmptyException) {
            result.setState(FILE_EMPTY);
            result.setMessage("上传的文件为空");
        } else if (e instanceof FileSizeException) {
            result.setState(FILE_SIZE_EXCEED);
            result.setMessage("文件过大");
        } else if (e instanceof FileTypeException) {
            result.setState(FILE_TYPE_UNSUPPORT);
            result.setMessage("文件类型错误");
        } else if (e instanceof FileStateException) {
            result.setState(FILE_STATE_ERROR);
            result.setMessage("文件状态错误");
        } else if (e instanceof UnknownHostException) {
            result.setState(UNKNOW_HOST);
            result.setMessage("服务器连接失败");
        } else if (e instanceof FileNotExistException) {
            result.setState(FILE_NOT_EXIST);
            result.setMessage("文件不存在");
        } else if (e instanceof FileIoException) {
            result.setState(FILE_IO_EXCEPTION);
            result.setMessage("文件读写异常");
        } else if (e instanceof LockUsedException) {
            result.setState(LOCK_USED);
            result.setMessage("锁已被占用");
        } else if (e instanceof FileSuffixException) {
            result.setState(FILE_SUFFIX_ERROR);
            result.setMessage("文件后缀名错误");
        } else {
            result.setState(UNKNOWN_EXCEPTION);
            result.setMessage("未知错误");
        }
        return result;
    }
}
