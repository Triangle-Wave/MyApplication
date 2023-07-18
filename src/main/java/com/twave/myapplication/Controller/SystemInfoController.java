package com.twave.myapplication.Controller;

import com.alibaba.fastjson.JSONObject;
import com.twave.myapplication.Service.Impl.SystemInfoServiceImpl;
import com.twave.myapplication.Util.JSONResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : twave
 * @date : 2023/7/17 10:27
 */
@CrossOrigin
@RestController
@RequestMapping("/system")
public class SystemInfoController extends BaseController {
    @Resource
    SystemInfoServiceImpl systemInfoServiceImpl = new SystemInfoServiceImpl();

    /**
     * 获取系统信息
     *
     * @return 系统信息
     */
    @RequestMapping("/info")
    public JSONResult<Object> getSystemInfo() {
        JSONObject systemInfo = systemInfoServiceImpl.getSystemInfo();
        return new JSONResult<>(REQUEST_SUCCESS, systemInfo);
    }
}
