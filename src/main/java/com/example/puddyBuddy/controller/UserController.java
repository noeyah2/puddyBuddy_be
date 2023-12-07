package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.User;
import com.example.puddyBuddy.dto.user.UserListRes;
import com.example.puddyBuddy.dto.user.UserRes;
import com.example.puddyBuddy.exception.common.BusinessException;
import com.example.puddyBuddy.response.BaseResponse;

import com.example.puddyBuddy.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "회원 정보 조회")
    @GetMapping("/{userId}")
    public BaseResponse<UserRes> getUser(@PathVariable Long userId){
        try {
            return new BaseResponse<>(userService.getUserOne(userId));
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }
    @Operation(summary = "이메일로 회원 존재 여부 확인")
    @GetMapping("/exists")
    public BaseResponse<Boolean> checkUserByEmail(@RequestParam(name = "email") String email) {
        try {
            boolean userExists = userService.checkUserByEmail(email);
            return new BaseResponse<>(userExists);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "로그인시 user id 프론트에게 전달")
    @GetMapping("/success")
    public BaseResponse<UserRes> giveUser(@RequestParam(name = "email") String email) {
        try {
            User user = userService.getUserIdByEmail(email);
            return new BaseResponse<>(new UserRes(user));
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

    @Operation(summary = "새로운 회원인 경우 입력받은 이메일과 닉네임으로 회원 생성")
    @GetMapping("/newuser")
    public BaseResponse<UserRes> createNewUser(
            @RequestParam(name = "email") String email,
            @RequestParam(name = "nickname") String nickname) {
        try {
            Long userId = userService.createNewUser(email, nickname);
            // 생성된 회원 정보 조회
            User createdUser = userService.getUserById(userId);
            // UserRes 객체를 생성하여 반환
            UserRes userRes = new UserRes(createdUser.getUserId(), createdUser.getNickname(), createdUser.getEmail());
            return new BaseResponse<>(userRes);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

}
