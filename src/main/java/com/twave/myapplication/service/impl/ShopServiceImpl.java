package com.twave.myapplication.service.impl;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.TypeReference;
import com.twave.myapplication.entity.ExpireEntity;
import com.twave.myapplication.entity.Shop;
import com.twave.myapplication.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : twave
 * @date : 2023/7/25 10:14
 */
@Service
public class ShopServiceImpl implements IShopService {
    @Autowired
    StringRedisTemplate redisTemplate;

    /**
     * 通过店铺ID获取店铺信息<p>
     * 首先尝试从Redis中获取店铺信息，如果Redis中没有，则从数据库中获取
     *
     * @param shopId
     * @return
     */
    @Override
    public Shop getShopInfo(String shopId) {
        // 从Redis中获取店铺信息
        String shopString = redisTemplate.opsForValue().get("cache:shop:" + shopId);
        Shop shop = new Shop();
        // 判断是否获取到了数据，shopString是否为空
        if (shopString != null) {
            // 如果获取到了数据
            // 将JSON字符串转换为对象，其中ExpireEntity是一个带有过期时间的对象
            // Shop是ExpireEntity的泛型参数
            // TypeReference是一个抽象类，用于获取泛型类型
            ExpireEntity<Shop> expireEntity =
                    JSON.parseObject(shopString, new TypeReference<ExpireEntity<Shop>>() {
                    });
            if (expireEntity != null) {
                shop = expireEntity.getData();
            }
        } else {
            // TODO 从数据库中获取数据，并打包成ExpireEntity写回Redis
            shop.setName("未找到店铺");
        }
        // 如果没有获取到数据，则从数据库中获取
        return shop;
    }
}
