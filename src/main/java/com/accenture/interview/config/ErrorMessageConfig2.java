package com.accenture.interview.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "error2")
@Data
public class ErrorMessageConfig2 {
    String empIdRegEx;
    String empNameRegEx;
    String compRegEx;
    String salaryRegEx;
}
