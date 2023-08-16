package com.twave.myapplication.controller;

import com.alibaba.fastjson2.JSONObject;
import com.twave.myapplication.service.impl.CouponServiceImpl;
import com.twave.myapplication.util.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.twave.myapplication.constants.StatusCode.REQUEST_SUCCESS;

/**
 * @author : twave
 * @date : 2023/7/26 10:42
 */
@RestController
@RequestMapping("/coupon")
public class CouponController {
    @Autowired
    CouponServiceImpl couponService;

    @GetMapping("/get")
    public JSONResult<JSONObject> getCoupon(@RequestParam("shopId") String shopId) {
        JSONObject coupon = couponService.getCouponInfo(shopId);
        return new JSONResult<>(REQUEST_SUCCESS, coupon);
    }
}
