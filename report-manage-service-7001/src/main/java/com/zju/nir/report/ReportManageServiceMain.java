package com.zju.nir.report;

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
public class ReportManageServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(ReportManageServiceMain.class, args);
    }
}
