package com.twave.myapplication.controller;

import com.twave.myapplication.service.impl.RedissonLockImpl;
import com.twave.myapplication.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author TWAVE
 * @date 2023/8/9 17:33
 */
@RestController
@RequestMapping("/redisson")
public class RedissonLockController extends BaseController {
    @Autowired
    private RedissonLockImpl redissonLock;

    @GetMapping("/send1")
    private JSONResult<String> sendMessage1() {
        return redissonLock.sendMailTask1();
    }

    @GetMapping("/send2")
    private JSONResult<String> sendMessage2() {
        return redissonLock.sendMailTask2();
    }
}
