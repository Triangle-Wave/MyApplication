package com.twave.myapplication.service.impl;

import com.twave.myapplication.entity.Coupon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author : twave
 * @date : 2023/7/25 16:55
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CouponServiceImplTest {
    @Autowired
    CouponServiceImpl couponService;

    @Test
    public void getCouponInfo() {
        System.out.println(couponService.getCouponInfo("1"));
    }


    @Test
    public void addCoupon() throws ParseException {
        Coupon coupon = new Coupon();
        coupon.setProductId("1");
        coupon.setAmount(1000);
        // 将指定日期转换为时间戳
        String str = "2023-8-30 16:13:49";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse(str);
        long timestamp = date.getTime();
        coupon.setExpireTime(String.valueOf(timestamp));
        System.out.println(couponService.addCoupon(coupon, "2"));
    }
}