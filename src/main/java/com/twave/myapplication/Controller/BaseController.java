package com.twave.myapplication.Controller;

import com.twave.myapplication.Controller.Exception.FileException.*;
import com.twave.myapplication.Controller.Exception.HostException.*;
import com.twave.myapplication.Service.Exception.ServiceException;
import com.twave.myapplication.Util.JSONResult;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 所有Controller的基类
 *
 * @author : twave
 * @date : 2023/7/14 16:44
 */
public class BaseController {
    // 定义一个请求成功的状态码
    public static final int REQUEST_SUCCESS = 200;

    /**
     * 请求处理方法，这个方法的返回值就是需要传递给前端的数据
     * 自动将异常对象传递给此方法的参数列
     * 当前项目中产生的异常，会被统一拦截到此方法中，这个方法此时充当请求处理方法，方法的返回值直接给前端
     * -@ExceptionHandler注解用于描述当前方法可以处理哪些异常
     * 这个注解可以接受一个列表
     */
    // @ExceptionHandler({
    //         ServiceException.class,
    //         FileUploadIOException.class,
    //         UnknownHostException.class
    // })
    @ExceptionHandler({
            FileEmptyException.class,
            FileSizeException.class,
            FileTypeException.class,
            FileStateException.class,
            UnknownHostException.class,
            FileNotExistException.class,
            FileIoException.class,
    })
    public JSONResult<Void> handleException(Throwable e) {
        JSONResult<Void> result = new JSONResult<>();
        if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("上传的文件为空");
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
            result.setMessage("文件过大");
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
            result.setMessage("文件类型错误");
        } else if (e instanceof FileStateException) {
            result.setState(6003);
            result.setMessage("文件状态错误");
        } else if (e instanceof UnknownHostException) {
            result.setState(6005);
            result.setMessage("服务器连接失败");
        } else if (e instanceof FileNotExistException) {
            result.setState(6006);
            result.setMessage("文件不存在");
        } else if (e instanceof FileIoException) {
            result.setState(6007);
            result.setMessage("文件读写异常");
        }
        return result;
    }

    // 扫描获取指定包名下的所有异常类
    private static Set<Class<? extends Throwable>> getExceptionClasses(String packageName) {

        Set<Class<? extends Throwable>> classSet = new HashSet<>();

        // 扫描代码获取包名下所有异常类

        return classSet;
    }
}
