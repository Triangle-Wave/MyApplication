package com.twave.myapplication.service.impl;

import com.twave.myapplication.controller.exception.fileException.*;
import com.twave.myapplication.service.IFileService;
import com.twave.myapplication.util.JSONResult;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;

import static com.twave.myapplication.constants.StatusCode.*;

/**
 * @author : twave
 * @date : 2023/7/14 17:03
 */
@Service
public class FileServiceImpl implements IFileService {
    @Value("${file.uploadPath}")
    String savePath;

    /**
     * 上传文件的Service层代码<p>
     * Controller调用该方法实现将前端上传的文件存放到文件夹的指定位置<p>
     * FileStateException是自定义的异常类
     *
     * @param file 上传的文件
     * @return 状态值
     */
    @Override
    public JSONResult<String> uploadFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new FileEmptyException("文件为空");
        } else if (file.getSize() > FILE_MAXSIZE) {
            throw new FileSizeException("文件大小超出限制");
        }
        // file对象指向这个路径，判断路径是否存在
        File dir = new File(savePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 获取文件名，保存文件
        File dest = new File(dir, Objects.requireNonNull(file.getOriginalFilename()));
        // 将参数file中的数据写入到空文件中
        System.out.println(dest);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new FileNotExistException("文件读写异常");
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        }
        return new JSONResult<>(200, "文件上传成功");
    }

    /**
     * 下载文件的Service层代码<p>
     * Controller调用该方法实现文件下载
     *
     * @param fileName 文件名
     * @return
     */
    @Override
    public void downloadFile(HttpServletResponse response, String fileName) {
        File file = new File(savePath + "\\" + fileName);
        // 从文件中获取输入流
        FileInputStream fis;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new FileNotExistException("文件不存在");
        }
        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);
        // 将文件的输入流复制到http响应的输入流中
        try {
            IOUtils.copy(fis, response.getOutputStream());
        } catch (IOException e) {
            throw new FileIoException("文件读写异常");
        }
    }
}
