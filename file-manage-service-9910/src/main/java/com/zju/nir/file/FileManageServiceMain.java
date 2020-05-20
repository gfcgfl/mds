package com.zju.nir.file;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author xiaoguo
 */
@SpringBootApplication //(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@MapperScan("com.zju.nir.file")
public class FileManageServiceMain {
    public static void main(String[] args) {
        SpringApplication.run(FileManageServiceMain.class, args);
    }
}
