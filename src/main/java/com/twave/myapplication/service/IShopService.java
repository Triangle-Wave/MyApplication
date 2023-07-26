package com.twave.myapplication.service;

/**
 * @author : twave
 * @date : 2023/7/25 10:05
 */

import com.twave.myapplication.entity.Shop;

/**
 * 店铺相关操作的接口
 *
 * @author TWAVE
 */
public interface IShopService {
    Shop getShopInfo(String shopId);
}
