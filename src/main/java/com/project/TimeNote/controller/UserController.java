package com.project.TimeNote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/joinForm")
    public String joinForm() {

        return "join";
    }

    @GetMapping("/loginForm")
    public String loginForm() {

        return "login";
    }
}