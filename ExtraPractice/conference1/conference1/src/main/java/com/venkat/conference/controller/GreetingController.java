package com.venkat.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting (Map<String, Object> model) {
        model.put("message", "Hello Venkat");
        return "greeting";
    }


}
