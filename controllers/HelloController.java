package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Spring Boot rodando com sucesso!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Ola! O backend está funcionando.";
    }
}
