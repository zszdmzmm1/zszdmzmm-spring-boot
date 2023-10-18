package com.auefly.config;

import org.springframework.boot.context.properties.ConfigurationProperties;


@ConfigurationProperties(
        prefix = "my"
)
public class MyProperties {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
