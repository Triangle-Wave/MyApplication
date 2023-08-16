package com.twave.myapplication.service;

import com.alibaba.fastjson2.JSONObject;
import com.twave.myapplication.entity.Coupon;

/**
 * @author : twave
 * @date : 2023/7/25 16:48
 */
public interface ICouponService {
    JSONObject getCouponInfo(String couponId);

    Long addCoupon(Coupon coupon, String shopId);
}
