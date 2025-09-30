package com.accenture.interview.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:error_message.yml", factory = YamlPropertySourceFactory.class)
@ConfigurationProperties(prefix = "error")
@Data
public class ErrorMessageConfig {
    String empIdRegEx;
    String empNameRegEx;
    String compRegEx;
    String salaryRegEx;
}
