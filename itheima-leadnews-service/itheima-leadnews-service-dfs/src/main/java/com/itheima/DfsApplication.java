package com.itheima;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @version 1.0
 * @description 说明
 * @package com.itheima
 */
@SpringBootApplication
@EnableFeignClients("com.itheima.*.feign")
public class DfsApplication {
    public static void main(String[] args) {
        SpringApplication.run(DfsApplication.class,args);
    }
}
