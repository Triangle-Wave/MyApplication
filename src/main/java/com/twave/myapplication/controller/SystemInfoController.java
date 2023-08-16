package com.twave.myapplication.controller;

import com.alibaba.fastjson2.JSONObject;
import com.twave.myapplication.service.impl.SystemInfoServiceImpl;
import com.twave.myapplication.util.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import static com.twave.myapplication.constants.StatusCode.REQUEST_SUCCESS;

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
