package com.example.sbjpa.service;

import com.example.sbjpa.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sbjpa.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User login(User user) {
        return userRepository.login(user.getUserId(), user.getPassword());
    }
}
