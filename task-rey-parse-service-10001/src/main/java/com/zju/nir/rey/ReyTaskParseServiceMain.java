package com.zju.nir.rey;

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
public class ReyTaskParseServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(ReyTaskParseServiceMain.class, args);
    }
}
