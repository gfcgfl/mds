package com.zju.nir.link;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author xiaoguo
 */
@SpringBootApplication(scanBasePackages = "com.zju.nir" )
@EnableDiscoveryClient
@EnableFeignClients(basePackages =  "com.zju.nir.base")
//@ComponentScan(basePackages = {"com.zju.nir.link", })
public class TaskLinkingParseServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(TaskLinkingParseServiceMain.class, args);
    }
}
