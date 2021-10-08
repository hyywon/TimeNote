package com.project.TimeNote.service;

import com.project.TimeNote.domain.user.UserEntity;
import com.project.TimeNote.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    public UserEntity 회원가입(UserEntity user) {

        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            return null;
        }

        userRepository.save(user);

        return user;
    }
}
