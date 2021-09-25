package com.xdemo.auth;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.TimeZone;


@SpringBootApplication
@EnableSwagger2
@EnableOpenApi
@MapperScan(basePackages = {"com.xdemo.auth"})
public class XdemoAuthApplication {

    public static void main(String[] args) {
        //添加时区处理
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
        SpringApplication.run(XdemoAuthApplication.class, args);
    }
}
