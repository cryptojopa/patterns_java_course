package com.patterns.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class SecurityController {
    @PostMapping("/register")
    public String register(@RequestParam String login,
                           @RequestParam String password) {
        return " ";
    }
}
