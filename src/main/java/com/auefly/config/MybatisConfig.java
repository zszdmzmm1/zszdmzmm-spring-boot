package com.auefly.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com.auefly.dao")
public class MybatisConfig {
}
