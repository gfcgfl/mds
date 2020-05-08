package com.zju.nir.collect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xiaoguo
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CollectManageServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(CollectManageServiceMain.class, args);
    }
}
