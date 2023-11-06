package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.User;
import com.example.puddyBuddy.dto.user.UserListRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/users",  produces = "application/json;charset=utf8")
@Tag(name = "회원 API")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "회원 전체 목록")
    @GetMapping
    public BaseResponse<List<UserListRes>> getUsers() {
        try {
            List<User> users = userService.getUsers();
            List<UserListRes> userList = users.stream()
                    .map(UserListRes::new)
                    .collect(Collectors.toList());
            return new BaseResponse<>(userList);
        } catch(BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }
}
