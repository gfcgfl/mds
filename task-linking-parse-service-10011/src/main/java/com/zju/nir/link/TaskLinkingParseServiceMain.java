package com.zju.nir.link;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaoguo
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.zju.nir.link", "com.zju.nir.base"})
public class TaskLinkingParseServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(TaskLinkingParseServiceMain.class, args);
    }
}
