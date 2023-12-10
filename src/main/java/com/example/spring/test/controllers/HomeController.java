package com.example.spring.test.controllers;

import com.example.spring.test.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Autowired
    private HomeService service;

    @GetMapping("/home")
    public String home() {
        return service.getWelcomeMessage();
    }
}
