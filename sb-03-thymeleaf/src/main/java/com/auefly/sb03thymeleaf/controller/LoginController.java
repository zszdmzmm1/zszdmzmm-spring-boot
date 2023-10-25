package com.auefly.sb03thymeleaf.controller;

import com.auefly.sb03thymeleaf.pojo.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String show() {
        return "login";
    }

    @PostMapping("/login")
    public String login(User user, HttpSession session, RedirectAttributes redirectAttributes) {
        if (user != null && "secret".equals(user.getPassword())) {
            session.setAttribute("user", user);
            return "redirect:/home";
        }
        redirectAttributes.addFlashAttribute("msg", "密码错误!");
        return "redirect:/login";
    }

    @GetMapping("/home")
    public String home(HttpSession session, RedirectAttributes redirectAttributes) {
        if(session.getAttribute("user") == null){
            redirectAttributes.addFlashAttribute("msg", "请登录!");
            return "redirect:/login";
        }
        return "home";
    }
}
