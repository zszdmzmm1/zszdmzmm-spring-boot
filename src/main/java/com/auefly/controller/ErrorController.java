package com.auefly.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.NOT_IMPLEMENTED;

@RestController
public class ErrorController {
    @GetMapping("/error5xx")
    public String servletError() {
        int i = 1 / 0;
        return String.valueOf(i);
    }

    @GetMapping("/custom-status")
    @ResponseStatus(reason = "this is a custom error", code = NOT_IMPLEMENTED)
    public String customStatus() {
        return "this is a return of the custom error page";
    }
}
