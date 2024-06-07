package com.cx.mall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 宸憙商城主启动类
 */
@EnableSwagger2
@MapperScan("com.cx.mall.dao")
@SpringBootApplication
public class StarseaMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(StarseaMallApplication.class, args);
    }

}
