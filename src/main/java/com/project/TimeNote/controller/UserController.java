package com.project.TimeNote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "join";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {

        return "login";
    }
}