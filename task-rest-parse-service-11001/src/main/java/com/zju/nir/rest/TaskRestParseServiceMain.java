package com.zju.nir.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaoguo
 */
@SpringBootApplication
@EnableDiscoveryClient
public class TaskRestParseServiceMain {

    public static void main(String[] args) {
        SpringApplication.run(TaskRestParseServiceMain.class, args);
    }
}
