package com.auefly.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class MapAndModelController {
    @GetMapping("/map-and-model")
    String mapAndModelSetting(Model model, Map<String, String> map) {
        map.put("mapAttribute", "mapAttributeValue");
        model.addAttribute("modelAttribute", "modelAttributeValue");
        return "forward:map-and-model-show";
    }

    @GetMapping("/map-and-model-show")
    @ResponseBody
    String mapAndModelAttributeShowing(HttpServletRequest request){
        return request.getAttribute("mapAttribute") + System.lineSeparator() + request.getAttribute("modelAttribute");
    }
}