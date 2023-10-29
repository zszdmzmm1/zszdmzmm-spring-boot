package com.auefly.sb08usemyownstarter;

import com.auefly.spring.boot.autoconfigure.annotation.EnableGreeting;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableGreeting
public class Sb08UseMyOwnStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(Sb08UseMyOwnStarterApplication.class, args);
    }

}
