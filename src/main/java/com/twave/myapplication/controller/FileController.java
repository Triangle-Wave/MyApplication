package com.twave.myapplication.controller;

import com.twave.myapplication.service.impl.FileServiceImpl;
import com.twave.myapplication.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

import static com.twave.myapplication.constants.StatusCode.*;

/**
 * 上传文件的Controller
 *
 * @author : twave
 * @date : 2023/7/14 16:54
 */
@CrossOrigin
@RestController
@RequestMapping("file")
public class FileController extends BaseController {
    @Autowired
    FileServiceImpl fileService;

    @PostMapping("/upload")
    public JSONResult<String> saveFile(@RequestParam("file") MultipartFile file) {
        // 调用业务层的方法，将文件保存到服务器设定的位置
        fileService.uploadFile(file);
        // 如果上面的方法没有抛出异常，则执行成功，可以返回成功的状态码200和文本信息
        return new JSONResult<>(REQUEST_SUCCESS, "文件上传成功");
    }

    // 引入commons-io或hutool方便流操作
    @GetMapping("/getfile")
    // SpringMVC会自动注入参数response-
    public void sendFile(HttpServletResponse response, @RequestParam String fileName) {
        // 直接调用业务层的方法，将文件写入到response中
        fileService.downloadFile(response, fileName);
    }

    @PostMapping("/uploadexcel")
    public JSONResult<String> saveExcel(@RequestParam("file") MultipartFile file) {
        // 调用业务层的方法，将文件保存到服务器设定的位置
        fileService.uploadExcel(file);
        // 如果上面的方法没有抛出异常，则执行成功，可以返回成功的状态码200和文本信息
        return new JSONResult<>(REQUEST_SUCCESS, "文件上传成功");
    }
}
