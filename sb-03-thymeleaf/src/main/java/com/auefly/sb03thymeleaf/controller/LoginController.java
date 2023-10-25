package com.auefly.sb03thymeleaf.controller;

import com.auefly.sb03thymeleaf.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String show() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session) {
        if (user != null && "secret".equals(user.getPassword())) {
            session.setAttribute("user", user);
            return "redirect:/home";
        }
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
