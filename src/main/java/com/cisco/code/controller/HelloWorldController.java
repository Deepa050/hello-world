package com.cisco.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class HelloWorldController {


    @RequestMapping
    String home() {
        return "Hello World Spring Boot from ci-cd instance!";
    }

    @GetMapping("/echo")
    public String echo() {
        return "Welcome to Deepa's CI/CD world ";
    }

}
