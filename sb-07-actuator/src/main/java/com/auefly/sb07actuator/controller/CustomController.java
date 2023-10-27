package com.auefly.sb07actuator.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomController {
    Counter counter;

    public CustomController(@Autowired MeterRegistry meterRegistry) {
        counter =  meterRegistry.counter("custom.viewCount");
    }

    @GetMapping("/custom-metrics")
    String customMetrics(){
        counter.increment();
        return "count:" + counter.count();
    }
}
