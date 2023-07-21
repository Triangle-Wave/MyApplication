package com.twave.myapplication.Service;

import com.alibaba.fastjson.JSONObject;
import com.twave.myapplication.Util.JSONResult;

import java.net.UnknownHostException;

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
