package com.auefly.controller;

import com.auefly.pojo.User;
import com.auefly.service.UserService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MybatisController {
    @Autowired
    UserService userService;

    @GetMapping("/select-user")
    public IPage<User> selectUser(@RequestParam(defaultValue = "-1") int page, @RequestParam(defaultValue = "10") int count) {
        if (page == -1) {
            return userService.selectUser(new Page<>());
        }
        return userService.selectUser(new Page<>(page, count));
    }
}