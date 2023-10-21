package com.auefly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    @GetMapping("/error5xx")
    public String servletError() {
        int i = 1 / 0;
        return String.valueOf(i);
    }
}
