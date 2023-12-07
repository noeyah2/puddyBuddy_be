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

    public User getUserIdByEmail(String email) {
        User user = (User) userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessException(ErrorCode.NO_EXIST_USER));
        return user;
    }

    public Long createNewUser(String email, String nickname) {
        // 중복 이메일 체크
        if (userRepository.findByEmail(email).isPresent()) {
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }
        // 중복 닉네임 체크
        if (userRepository.findByNickname(nickname).isPresent()) {
            throw new BusinessException(ErrorCode.DUPLICATE_NICKNAME);
        }
        // 중복이 없으면 새로운 사용자 생성
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setNickname(nickname);

        User savedUser = userRepository.save(newUser);
        return savedUser.getUserId();
    }

    public User getUserById(Long userId) {
        return userRepository.findByUserId(userId)
                .orElseThrow(() -> new BusinessException(ErrorCode.EMPTY_DATA));
    }
}
