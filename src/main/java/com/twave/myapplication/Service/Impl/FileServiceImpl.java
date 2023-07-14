package com.twave.myapplication.Service.Impl;

import com.twave.myapplication.Controller.Exception.FileEmptyException;
import com.twave.myapplication.Controller.Exception.FileSizeException;
import com.twave.myapplication.Controller.Exception.FileStateException;
import com.twave.myapplication.Controller.Exception.FileUploadIOException;
import com.twave.myapplication.Service.IFileService;
import com.twave.myapplication.Util.JSONResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

/**
 * @author : twave
 * @date : 2023/7/14 17:03
 */
@Service
public class FileServiceImpl implements IFileService {
    public static final int FILE_MAXSIZE = 200 * 1024 * 1024;

    @Value("${file.uploadPath}")
    String savePath;

    /**
     * 上传文件接口
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
            throw new FileUploadIOException("文件读写异常");
        } catch (FileStateException e) {
            throw new FileStateException("文件状态异常");
        }
        return new JSONResult<>(200, "文件上传成功");
    }
}
