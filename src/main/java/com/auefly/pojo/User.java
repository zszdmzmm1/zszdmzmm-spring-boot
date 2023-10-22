package com.auefly.pojo;

import lombok.Data;

@Data
public class User {
    private int uid;
    private String email;
    private String password;
    private String role;
}