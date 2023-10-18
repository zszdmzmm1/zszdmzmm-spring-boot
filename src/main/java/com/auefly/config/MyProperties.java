package com.auefly.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(
        prefix = "my"
)
public class MyProperties {
    private int age;
    private String name;
}
