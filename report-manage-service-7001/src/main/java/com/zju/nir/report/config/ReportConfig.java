package com.zju.nir.report.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;

/**
 * @author xiaoguo
 */
@Configuration
//@PropertySource(value = {"classpath:customconfig.yml"})
@ConfigurationProperties
@Data
public class ReportConfig {

    private List<String> reportNeededTask;

    private List<Integer> reportTaskidSequence;
}
