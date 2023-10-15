package com.example.puddyBuddy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
//@Tag(name = "계정 API")
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

//    private final AccountService accountService;

//    @Operation(summary = "테스트", description = "테스트 api 입니다!")
    @GetMapping("/test")
    public String test() {
        return "success";
    }

}