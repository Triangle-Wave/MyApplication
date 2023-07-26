package com.twave.myapplication.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.twave.myapplication.entity.Coupon;
import com.twave.myapplication.service.ICouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author : twave
 * @date : 2023/7/25 16:48
 */
@Service
public class CouponServiceImpl implements ICouponService {
    // 注入StringRedisTemplate
    @Autowired
    StringRedisTemplate redisTemplate;
    private static final DefaultRedisScript<Long> ADD_COUPON_SCRIPT;
    private static final DefaultRedisScript<List<String>> GET_COUPON_SCRIPT;

    static {
        // 加载addCoupon脚本
        ADD_COUPON_SCRIPT = new DefaultRedisScript<>();
        // 设置脚本文件为resource文件夹下的unlock.lua文件
        ADD_COUPON_SCRIPT.setLocation(new ClassPathResource("lua/addCoupon.lua"));
        // 设置脚本返回值类型为Long
        ADD_COUPON_SCRIPT.setResultType(Long.class);
        // 加载getCoupon脚本
        GET_COUPON_SCRIPT = new DefaultRedisScript<>();
        // 设置脚本文件为resource文件夹下的unlock.lua文件
        GET_COUPON_SCRIPT.setLocation(new ClassPathResource("lua/getCoupon.lua"));
        // 设置脚本返回值类型为List
        GET_COUPON_SCRIPT.setResultType((Class<List<String>>) (Class<?>) List.class);
    }

    @Override
    public JSONObject getCouponInfo(String shopId) {
        List<String> keys = new ArrayList<>();
        keys.add(shopId);
        List<String> couponList = redisTemplate.execute(
                GET_COUPON_SCRIPT,
                keys);
        List<JSONObject> jsonObjectList = new ArrayList<>();
        if (couponList != null) {
            for (String coupon : couponList) {
                JSONObject jsonObject = JSON.parseObject(coupon);
                jsonObjectList.add(jsonObject);
            }
            // 根据amount排序
            jsonObjectList.sort(Collections.reverseOrder(Comparator.comparingInt(o -> o.getIntValue("amount"))));
            JSONArray jsonArray = new JSONArray(jsonObjectList);
            JSONObject couponJson = new JSONObject();
            // 创建一个新的JSON对象，并将List作为一个键为"Coupon"的值
            couponJson.put("shopId", shopId);
            couponJson.put("amount", jsonObjectList.size());
            couponJson.put("coupon", jsonArray);
            return couponJson;
        }
        return null;
    }

    @Override
    public Long addCoupon(Coupon coupon, String shopId) {
        // 使用fastjson进行序列化
        String couponJson = JSON.toJSONString(coupon);
        // 生成一个唯一的优惠券ID
        String couponId = String.valueOf(UUID.randomUUID());
        Long state = redisTemplate.execute(
                ADD_COUPON_SCRIPT,
                Collections.singletonList("COUPON:" + shopId + ":" + couponId),
                couponJson);
        return state;
    }
}
