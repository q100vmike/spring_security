package ru.mtshomework.spring_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World from Spring Security";
    }

    @GetMapping("/hello-pr")
    public String helloProtected() {
        return "PROTECTED Hello World from Spring Security";
    }
}
