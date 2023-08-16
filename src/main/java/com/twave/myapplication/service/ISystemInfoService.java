package com.twave.myapplication.service;

import com.alibaba.fastjson2.JSONObject;

/**
 * @author : twave
 * @date : 2023/7/17 10:24
 */
public interface ISystemInfoService {
    /**
     * 获取系统全部信息
     */
    JSONObject getSystemInfo();
}
