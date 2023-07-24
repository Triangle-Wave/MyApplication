package com.twave.myapplication.service;

/**
 * 向指定用户发送邮件
 *
 * @author : twave
 * @date : 2023/7/24 15:30
 */
public interface ISendMailService {
    void sendMail(String userName);
}
