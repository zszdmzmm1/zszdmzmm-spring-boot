package com.auefly.controller;

import com.auefly.pojo.User;
import com.auefly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {
    @Autowired
    UserService userService;

    @GetMapping("/select-user")
    public List<User> selectUser() {
        return userService.selectUser();
    }
}