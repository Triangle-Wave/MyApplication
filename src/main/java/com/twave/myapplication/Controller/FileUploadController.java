package com.twave.myapplication.Controller;

import com.twave.myapplication.Controller.Exception.FileEmptyException;
import com.twave.myapplication.Controller.Exception.FileSizeException;
import com.twave.myapplication.Controller.Exception.FileStateException;
import com.twave.myapplication.Controller.Exception.FileUploadIOException;
import com.twave.myapplication.Service.Impl.FileServiceImpl;
import com.twave.myapplication.Util.JSONResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * 上传文件的Controller
 *
 * @author : twave
 * @date : 2023/7/14 16:54
 */
@CrossOrigin
@RestController
@RequestMapping("file")
public class FileUploadController extends BaseController {
    @Resource
    FileServiceImpl fileService;

    @PostMapping("/upload")
    public JSONResult<String> saveFile(@RequestParam("file") MultipartFile file) {
        fileService.uploadFile(file);
        return new JSONResult<>(REQUEST_SUCCESS, "文件上传成功");
    }
}
