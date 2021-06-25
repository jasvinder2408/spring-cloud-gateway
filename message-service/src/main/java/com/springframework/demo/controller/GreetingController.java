package com.springframework.demo.controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
class GreetingController {


    @GetMapping("message")
    public String getMessage() {
        return "Hello from REST API";
    }
}