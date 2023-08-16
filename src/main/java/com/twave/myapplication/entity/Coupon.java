package com.twave.myapplication.entity;

import lombok.Data;

/**
 * 优惠券实体类，包含优惠券ID、商家ID、优惠金额、过期时间
 *
 * @author : twave
 * @date : 2023/7/25 16:42
 */
@Data
public class Coupon {
    private String productId;
    private Integer amount;
    private String expireTime;
}
