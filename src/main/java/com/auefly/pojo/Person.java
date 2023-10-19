package com.auefly.pojo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
@Data
@ConfigurationProperties(
        prefix = "person"
)
public class Person {
    private String userName;
    private Boolean boss;
    private Date birth;
    private Integer age;
    private String[] interests;
    private List<String> animal;
    private Map<String, Object> score;
    private Set<Double> salaries;
    private Pet pet;
    private Map<String, List<Pet>> allPets;
}
