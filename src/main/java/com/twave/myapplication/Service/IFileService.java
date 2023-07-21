package com.twave.myapplication.Service;

import com.twave.myapplication.Util.JSONResult;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @author : twave
 * @date : 2023/7/14 17:01
 */
public interface IFileService {
    /**
     * 上传文件接口
     *
     * @param file 上传的文件
     * @return 状态值
     */
    JSONResult<String> uploadFile(MultipartFile file);

    void downloadFile(HttpServletResponse response, String fileName);
}
