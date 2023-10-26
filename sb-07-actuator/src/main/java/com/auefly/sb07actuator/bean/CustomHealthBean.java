package com.auefly.sb07actuator.bean;

import org.springframework.stereotype.Component;

@Component
public class CustomHealthBean {
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
}
