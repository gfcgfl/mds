package com.zju.nir.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaoguo
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@ComponentScan(basePackages = {"com.zju.nir.rest", "com.zju.nir.base"})
public class TaskRestParseServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(TaskRestParseServiceMain.class, args);
    }
}
