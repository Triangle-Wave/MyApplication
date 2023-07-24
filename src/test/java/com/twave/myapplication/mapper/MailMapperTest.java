package com.twave.myapplication.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : twave
 * @date : 2023/7/24 15:38
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MailMapperTest {
    @Autowired
    MailMapper mailMapper;

    @Test
    public void getLock() {
        try {
            System.out.println(mailMapper.getLock("twave"));
        } catch (Exception e) {
            System.out.println("锁已被占用");
        }

    }

    @Test
    public void releaseLock() {
        // 返回0表示之前数据库不存在这条记录
        System.out.println(mailMapper.releaseLock("twave"));
    }
}