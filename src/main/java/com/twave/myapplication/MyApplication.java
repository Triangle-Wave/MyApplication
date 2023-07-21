package com.twave.myapplication;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyApplication {
    // 访问根路径时返回欢迎语
    @RequestMapping("/")
    String helloWorld() {
        return "Welcome to Twave's Application";
    }

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
