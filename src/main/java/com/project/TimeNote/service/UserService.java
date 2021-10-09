package com.project.TimeNote.service;

import com.project.TimeNote.domain.user.UserEntity;
import com.project.TimeNote.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @Transactional
    public UserEntity 회원가입(UserEntity user) {

        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            return null;
        }
        String rawPassword = user.getPassword(); // 원본 비밀번호
        String encPassword = encoder.encode(rawPassword); // 해쉬 비밀번호

        user.setPassword(encPassword);

        userRepository.save(user);

        return user;
    }
}
