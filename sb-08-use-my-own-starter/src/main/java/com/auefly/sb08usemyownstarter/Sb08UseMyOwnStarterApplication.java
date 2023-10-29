package com.auefly.sb08usemyownstarter;

import com.auefly.spring.boot.autoconfigure.GreetingAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(GreetingAutoConfiguration.class)
public class Sb08UseMyOwnStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb08UseMyOwnStarterApplication.class, args);
    }

}
