package com.zju.nir.rey;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaoguo
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ReyTaskParseServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(ReyTaskParseServiceMain.class, args);
    }
}
