package com.project.TimeNote.controller;

import com.project.TimeNote.domain.user.UserEntity;
import com.project.TimeNote.domain.user.UserRepository;
import com.project.TimeNote.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserApiController {

    @Autowired // DI
    public UserRepository userRepository;


    @PostMapping("/join")
    public ResponseDto<Integer> join(@RequestBody UserEntity user){ //name, password, email
        System.out.println(user.getUsername() + user.getPassword() + user.getEmail());
        System.out.println("User API 호출");
        userRepository.save(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

//    @PostMapping("/login")
//    public ResponseDto<Integer> login(@RequestBody UserEntity user){ //name, password, email
//        System.out.println(user.getPassword() + user.getEmail());
//
//        UserEntity reUser = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword()).orElseGet(() -> {
//            return new
//        });
//
//        System.out.println("User Login 성공");
//        return 1;
//    }
}
