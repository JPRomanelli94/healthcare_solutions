package com.example.healthcare_solutions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @GetMapping("/oauth2")
    public String logisCodeLogin(){
        return "Hi! This endpoint is secured";
    }
}
