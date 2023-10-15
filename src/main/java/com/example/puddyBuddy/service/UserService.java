package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.User;
import com.example.puddyBuddy.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
