package com.twave.myapplication.service.impl;

import com.twave.myapplication.controller.exception.lockException.LockUsedException;
import com.twave.myapplication.mapper.MailMapper;
import com.twave.myapplication.service.ISendMailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 向用户发送邮件的Service
 *
 * @author : twave
 * @date : 2023/7/24 15:31
 */
@Service
public class SendMailServiceImpl implements ISendMailService {
    @Resource
    MailMapper mailMapper;

    @Override
    public void sendMail(String userName) {
        try {
            mailMapper.getLock(userName);
        } catch (Exception e) {
            // 报错说明锁已经被占用，向Controller抛出异常
            throw new LockUsedException("锁被占用");
        }
        // 发送邮件，用延时10s模拟发送邮件
        try {
            Thread.sleep(10000);
            mailMapper.releaseLock(userName);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
