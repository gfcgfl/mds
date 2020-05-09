package com.zju.nir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaoguo
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class TasksManageServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(TasksManageServiceMain.class, args);
    }

}
