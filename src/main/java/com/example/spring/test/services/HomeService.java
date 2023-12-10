package com.example.spring.test.services;

import org.springframework.stereotype.Service;

@Service
public class HomeService {

    public String getWelcomeMessage(){
        return "Welcome to Home";
    }
}
