package com.auefly.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ThymeleafController {
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("custom_name", "hjf");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login_process")
    @ResponseBody
    public Map<String, String> loginProcess(@RequestParam(defaultValue = "") String email, @RequestParam(defaultValue = "") String password) {
        String message;
        if ("admin".equals(email)) {
            if ("secret".equals(password)) {
                message = "login success";
            } else {
                message = "password is wrong";
            }
        } else {
            message = "email is not exist";
        }
        Map<String, String> map = new HashMap<>();
        map.put("msg", message);
        return map;
    }

    @PostMapping("/users")
    @ResponseBody
    public String users(@RequestParam String email,@RequestParam String password) {
        return "email:" + email + System.lineSeparator()
                + "password:" + password;
    }
}