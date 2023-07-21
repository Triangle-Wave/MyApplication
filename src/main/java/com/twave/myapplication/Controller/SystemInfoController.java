package com.twave.myapplication.Controller;

import com.alibaba.fastjson.JSONObject;
import com.twave.myapplication.Service.Impl.SystemInfoServiceImpl;
import com.twave.myapplication.Util.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 获取系统运行信息
 *
 * @author : twave
 * @date : 2023/7/17 10:27
 */
@Slf4j
@CrossOrigin
@RestController
@RequestMapping("/system")
public class SystemInfoController extends BaseController {
    /**
     * 注入系统信息的业务层对象
     */
    @Resource
    SystemInfoServiceImpl systemInfoServiceImpl = new SystemInfoServiceImpl();

    /**
     * 获取系统信息
     *
     * @return 系统信息
     */
    @RequestMapping("/info")
    public JSONResult<JSONObject> getSystemInfo() {
        JSONObject systemInfo = systemInfoServiceImpl.getSystemInfo();
        return new JSONResult<>(REQUEST_SUCCESS, systemInfo);
    }
}
