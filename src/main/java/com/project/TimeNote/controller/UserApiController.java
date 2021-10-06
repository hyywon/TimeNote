package com.project.TimeNote.controller;

import com.project.TimeNote.domain.user.UserEntity;
import com.project.TimeNote.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserApiController {

    @Autowired // DI
    public UserRepository userRepository;


    @PostMapping("/join")
    public Integer join(@RequestBody UserEntity user){ //name, password, email
        System.out.println(user.getUsername() + user.getPassword() + user.getEmail());
        System.out.println("User API 호출");
        return 1;
    }

    @PostMapping("/login")
    public Integer login(@RequestBody UserEntity user){ //name, password, email
        System.out.println(user.getPassword() + user.getEmail());
        System.out.println("User API 호출");
        return 1;
    }
}
