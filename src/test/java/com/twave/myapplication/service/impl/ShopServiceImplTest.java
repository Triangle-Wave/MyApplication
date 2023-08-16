package com.twave.myapplication.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author : twave
 * @date : 2023/7/25 10:18
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShopServiceImplTest {
    @Autowired
    ShopServiceImpl shopService;

    @Test
    public void getShopInfo() {
        System.out.println(shopService.getShopInfo("2"));
    }
}