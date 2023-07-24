package com.twave.myapplication.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.twave.myapplication.controller.Exception.HostException.UnknownHostException;
import com.twave.myapplication.service.ISystemInfoService;
import com.twave.myapplication.util.SystemInfoUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : twave
 * @date : 2023/7/17 10:25
 */
@Service
public class SystemInfoServiceImpl implements ISystemInfoService {
    @Resource
    SystemInfoUtil systemInfoUtil = new SystemInfoUtil();

    /**
     * 获取系统全部信息
     */
    @Override
    public JSONObject getSystemInfo(){
        JSONObject info;
        try {
            info = systemInfoUtil.getInfo();
        } catch (java.net.UnknownHostException e) {
            // 抛出UnknownHostException异常
            throw new UnknownHostException("未知主机异常");
        }
        return info;
    }
}
