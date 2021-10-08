package com.project.TimeNote.controller;

import com.project.TimeNote.domain.user.UserEntity;
import com.project.TimeNote.domain.user.UserRepository;
import com.project.TimeNote.dto.ResponseDto;
import com.project.TimeNote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserApiController {

    @Autowired // DI
    public UserRepository userRepository;

    @Autowired
    public UserService userService;

    @PostMapping("/join")
    public ResponseDto<Integer> join(@RequestBody UserEntity user){ //name, password, email, school
        System.out.println(user.getUsername() + user.getPassword() + user.getEmail());
        System.out.println("User Join API");
        if (userService.회원가입(user) == null){
            System.out.println("User 중복");
            return new ResponseDto<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), 1);
        }
        return new ResponseDto<Integer>(HttpStatus.OK.value(),1);
    }

}
