package com.zju.nir.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaoguo
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages =  "com.zju.nir.base")
public class TaskRestParseServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(TaskRestParseServiceMain.class, args);
    }
}
