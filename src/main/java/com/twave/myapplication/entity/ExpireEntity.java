package com.twave.myapplication.entity;

import lombok.Data;

/**
 * 带有超时时间的实体类，其中包含一个泛型类
 *
 * @author : twave
 * @date : 2023/7/25 10:25
 */
@Data
public class ExpireEntity<T> {
    // 泛型类data
    private T data;
    // 过期时间，使用时间戳表示
    private String expireTime;
}
