package com.zju.nir.stroop;

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
public class TaskStroopParseServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(TaskStroopParseServiceMain.class, args);
    }
}
