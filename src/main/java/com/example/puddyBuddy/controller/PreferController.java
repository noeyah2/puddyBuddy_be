package com.example.puddyBuddy.controller;

import com.example.puddyBuddy.domain.*;
import com.example.puddyBuddy.dto.prefer.PreferRes;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.example.puddyBuddy.response.BaseResponse;
import com.example.puddyBuddy.service.PreferService;
import com.example.puddyBuddy.exception.common.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@RequestMapping( value = "/prefers",  produces = "application/json;charset=utf8")
@Tag(name = "선호 조건 API")
public class PreferController {
    private final PreferService preferService;
    public PreferController(PreferService preferService) {
        this.preferService = preferService;
    }

    @Operation(summary = "선호조건 회원별로 보기", description = "회원 번호를 넘겨주면 그 회원이 가진 선호 조건 리스트를 보내드립니다.")
    @GetMapping("/{userId}")
    public BaseResponse<List<PreferRes>> getPreferUser(@PathVariable Long userId){
        try {
//            List<Prefer> prefers = preferService.getPreferUser(userId);
//            List<PreferRes> preferResList = prefers.stream()
//                    .map(PreferRes::new)
//                    .collect(Collectors.toList());
            List<PreferRes> preferResList = preferService.getPreferUser(userId);
            return new BaseResponse<>(preferResList);
        } catch (BusinessException e) {
            return new BaseResponse<>(e.getErrorCode());
        }
    }

//    @Operation(summary = "선호조건 등록")
//    @PostMapping()
}