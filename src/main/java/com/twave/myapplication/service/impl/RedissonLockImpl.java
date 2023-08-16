package com.twave.myapplication.service.impl;


import com.twave.myapplication.util.JSONResult;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static com.twave.myapplication.constants.StatusCode.REQUEST_SUCCESS;


/**
 * 测试Redisson分布式锁
 *
 * @author TWAVE
 * @date 2023/8/9 16:50
 */
@Service
public class RedissonLockImpl {
    @Resource
    private RedissonClient redissonClient;

    public JSONResult<String> sendMailTask1() {
        RLock lock = redissonClient.getLock("lock");
        boolean isLock;
        try {
            isLock = lock.tryLock(200, 6000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (isLock) {
            // 模拟业务处理
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            return new JSONResult<>(REQUEST_SUCCESS, "任务1执行完成");
        } else {
            return new JSONResult<>(REQUEST_SUCCESS, "未获取到锁");
        }
    }

    public JSONResult<String> sendMailTask2() {
        RLock lock = redissonClient.getLock("lock");
        boolean isLock;
        try {
            isLock = lock.tryLock(200, 1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (isLock) {
            return new JSONResult<>(REQUEST_SUCCESS, "任务2执行完成");
        } else {
            return new JSONResult<>(REQUEST_SUCCESS, "未获取到锁");
        }
    }
}
