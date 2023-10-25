package com.auefly.sb03thymeleaf.controller;

import com.auefly.sb03thymeleaf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {
    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = Arrays.asList(
                new User("admin@qq.com", "admin"),
                new User("user@qq.com", "123456"),
                new User("vister@qq.com", "null")
        );
        model.addAttribute("users", users);
        return "users";
    }
}
