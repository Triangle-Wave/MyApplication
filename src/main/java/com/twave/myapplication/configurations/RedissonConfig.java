package com.twave.myapplication.configurations;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author TWAVE
 * @date 2023/8/9 17:18
 */
@Configuration
public class RedissonConfig {
    @Bean
    public RedissonClient redissonClient() {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://r-uf6yj70znlfnqrhfc4pd.redis.rds.aliyuncs.com:6379")
                .setPassword("WgF!19981123");
        return Redisson.create(config);
    }
}
