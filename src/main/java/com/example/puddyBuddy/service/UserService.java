package com.example.puddyBuddy.service;

import com.example.puddyBuddy.domain.User;
import com.example.puddyBuddy.dto.user.UserRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.exception.common.ErrorCode;
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

    public UserRes getUserOne(Long userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(() -> new BusinessException(ErrorCode.EMPTY_DATA));
        UserRes response = new UserRes(user);
        return response;
    }

    public boolean checkUserByEmail(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
